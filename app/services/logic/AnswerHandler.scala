package services.logic

import java.util.UUID

import services.model.Answer

import scala.concurrent.Future

/**
  * Created by pillaci on 10/11/17.
  */
object AnswerHandler {

  def create(authorId: UUID, questionId: UUID, body: String): Future[String] = {
    val a = Answer(authorId, questionId, body)
    Future.successful(a.id.toString)
  }

  def get

}
