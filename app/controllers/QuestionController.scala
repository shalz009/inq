package controllers

import javax.inject.Singleton

import play.api.libs.json.{Format, JsValue, Json}
import play.api.mvc._
import services.model.{Tag, Question}
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class QuestionController extends Controller {

//  implicit val questionFormat: Format[Question] = Json.format[Question]
//  implicit val tagFormat: Format[Tag] = Json.format[Tag]

  def create() = Action.async(BodyParsers.parse.json) { implicit request =>
     val body = request.body
    //     val question = body.as[Question]
    val question = Question(body.toString())
    logic.QuestionHandler.create(question) map { a =>
      Created(a.toString)
    }
  }
}
