package logic

import java.util.UUID

import core.ESBase
import services.model.{Question, QuestionRequest}

import scala.concurrent.Future

object QuestionHandler {

  def create(qr: QuestionRequest): Future[UUID] = {
    val q = Question(qr.body)

    ESBase.insert(q)
    Future.successful(q.id)
  }
}
