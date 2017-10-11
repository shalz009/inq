package services.model

import play.api.libs.json.Json

case class QuestionRequest(body: String)

object QuestionRequest {
  implicit val fmt = Json.format[QuestionRequest]
}
