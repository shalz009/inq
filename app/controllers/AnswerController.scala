package controllers

import javax.inject.Singleton

import play.api.libs.json.{Format, JsValue, Json}
import play.api.mvc._
import services.logic.AnswerHandler
import services.model.Answer
import services.model.Answer.AnswerReads
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by pillaci on 10/11/17.
  */

@Singleton
class AnswerController extends Controller{

  implicit val answerParser: Format[Answer] = Json.format[Answer]

  def create = Action.async(BodyParsers.parse.json){ request =>
    val k  = AnswerReads.reads(request.body)
    AnswerHandler.create(k.get.authorId, k.get.questionId, k.get.body) map { a =>
      Created(a)
    }
  }
}

