package logic

import java.util.UUID

import services.model.Question

import scala.concurrent.Future

object QuestionHandler {

  def create(q: Question): Future[UUID] = {

    println(s"id : ${q.id}")
    println(s"authorId : ${q.authorId}")
    println(s"body : ${q.body}")

    Future.successful(q.id)

  }

}