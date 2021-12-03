import cats.Monad
import cats.effect.std.Console
import cats.effect.{Async, IO, IOApp, Resource}
import com.comcast.ip4s._
import org.http4s.HttpRoutes
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Server
import cats.implicits._
import domain.Version
import org.http4s.dsl.Http4sDsl

object ServiceApp extends IOApp.Simple {

  def serve[F[_]: Async](service: HttpRoutes[F]): Resource[F, Server] = EmberServerBuilder
    .default[F]
    .withHttpApp(service.orNotFound)
    .withHost(host"0.0.0.0")
    .withPort(port"8080")
    .build

  def pingRoute[F[_]: Monad]: HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._

    HttpRoutes.of[F] {
      case (GET | HEAD) -> Root / "ping" =>
        Ok(Version(1))
    }
  }

  def create[F[_]: Async: Console]: Resource[F, Server] = for {
    httpApp <- Resource.pure(pingRoute[F])
    server <- serve(httpApp)
  } yield server

  implicit val console: Console[IO] = Console.make

  override def run: IO[Unit] = create[IO].use { server =>
    console.println(s"Server started at ${server.address}") >>
      Async[IO].never[Unit]
  }

}
