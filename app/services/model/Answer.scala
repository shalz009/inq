package services.model


import java.util.UUID

import org.joda.time.DateTime
import play.api.libs.json._

case class Answer(
                 id: UUID = UUID.randomUUID(),
                 authorId: UUID,
                 questionId: UUID,
                 body: String,
                 createdAt: DateTime)

object Answer {
  implicit object AnswerReads extends Format[Answer]{
    override def reads (json: JsValue): JsResult[Answer] = JsSuccess{
     Answer(
      (json \ "authorId").as[UUID],
      (json \ "questionId").as[UUID],
      (json \ "body").as[String]
    )
    }

    override def writes(ts: Answer): JsValue =
      JsObject(Seq(
      "id" -> JsString(ts.id.toString),
      "authorId" -> JsString(ts.authorId.toString),
      "questionId" -> JsString(ts.questionId.toString),
      "body" -> JsString(ts.body.toString),
      "createdAt" -> JsString(ts.createdAt.toString)
    ))
  }

  def apply(authorId: UUID, questionId: UUID, body: String): Answer = {
    Answer(UUID.randomUUID(), authorId, questionId, body, new DateTime())
  }
}