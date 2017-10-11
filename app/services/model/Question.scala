package services.model

import java.util.UUID

import core.ESEntity
import org.joda.time.DateTime
import play.api.libs.json.Json

case class Question(id: UUID,
                    authorId: UUID,
                    body: String,
                    tags: Set[Tag],
                    createdAt: DateTime = new DateTime()) extends ESEntity {

  override def estype = "question"

  override def fieldsAsMap: Map[String, Any] = {
    Map("authorID" -> authorId, "body" -> body, "createdAt" -> createdAt.getMillis)
  }
}

object Question {
  implicit val fmt = Json.format[Question]

  def apply(id: UUID, values: Map[String, Any]): Question =
    Question(id, UUID.fromString(values("authorID").toString), values("body").toString, Set.empty, new DateTime(values("createdAt")))

  def apply(body: String): Question =
    Question(UUID.randomUUID(), UUID.randomUUID(), body, Set.empty[Tag], new DateTime())
}
