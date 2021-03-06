name := "dockerise-everything"

version := "0.1"

scalaVersion := "2.13.7"

libraryDependencies ++= Seq(
  "io.circe"      %% "circe-core"          % "0.14.1",
  "org.typelevel" %% "cats-effect"         % "3.3.0",
  "org.http4s"    %% "http4s-ember-server" % "0.23.6",
  "org.http4s"    %% "http4s-dsl"          % "0.23.6",
  "org.http4s"    %% "http4s-circe"        % "0.23.6",
) ++ Seq(
  "org.typelevel" %% "munit-cats-effect-3" % "1.0.6",
  "io.circe"      %% "circe-parser" % "0.14.1"
).map(_ % Test)