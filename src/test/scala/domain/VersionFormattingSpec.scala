package domain

import io.circe.syntax._
import io.circe.parser._

class VersionFormattingSpec extends munit.FunSuite {

  test("Version should be encoded as expected") {
    val version = Version(1)
    val Right(expectedJson) = parse(
      """{
          "value": 1
        }""".stripMargin
    )

    assertEquals(version.asJson, expectedJson)
  }
}
