package controllers

import java.util.UUID
import javax.inject.Singleton

import core.ESBase
import play.api.libs.json.Json
import play.api.mvc._
import services.model.{Question, QuestionRequest}

import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class QuestionController extends Controller {

  def create() = Action.async(BodyParsers.parse.json) {
    implicit request =>
      val body = request.body.as[QuestionRequest]
      logic.QuestionHandler.create(body) map { a =>
        Created(a.toString)
      }
  }

  def get(id: UUID) = Action {
    Ok(Json.toJson(Question(id, ESBase.lookup(id, "question"))))
  }
}
