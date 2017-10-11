package services.model

import java.util.UUID

import core.ESEntity
import org.joda.time.DateTime

case class Question(id: UUID = UUID.randomUUID(),
                    authorId: UUID,
                    body: String,
                    tags: Set[Tag],
                    createdAt: DateTime = new DateTime()) extends ESEntity {

  override def estype = "question"

  override def fieldsAsMap: Map[String, Any] = {
    Map("authorID" -> authorId, "body" -> body, "createdAt" -> createdAt.getMillis)
  }
}
