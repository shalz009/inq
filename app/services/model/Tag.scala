package services.model

import java.util.UUID

import play.api.libs.json.{Format, Json}

case class Tag(id: UUID, name: String)

object Tag {
  implicit val tagFormat: Format[Tag] = Json.format[Tag]
}
