package domain

import io.circe.Encoder
import org.http4s.EntityEncoder
import org.http4s.circe.jsonEncoderOf

case class Version (value: Int) extends AnyVal
object Version{
  implicit val encoder: Encoder[Version] = Encoder.forProduct1("value")(_.value)
  implicit def entityEncoder[F[_]]: EntityEncoder[F, Version] = jsonEncoderOf
}