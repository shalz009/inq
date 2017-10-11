package controllers

import java.util.UUID
import javax.inject.Singleton

import core.ESBase
import play.api.libs.json.Json
import play.api.mvc._
import services.model.Question

import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class QuestionController extends Controller {

  def create() = Action.async(BodyParsers.parse.json) {
    implicit request =>
      val body = request.body
      val question = Question(body.toString())
      logic.QuestionHandler.create(question) map { a =>
        Created(a.toString)
      }
  }

  def get(id: UUID) = Action {
    Ok(Json.toJson(Question(id, ESBase.lookup(id, "question"))))
  }
}
