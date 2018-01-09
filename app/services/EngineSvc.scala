package services

import java.sql.Timestamp

import yamazaki.{Answer, Author, Question}

import scala.concurrent.Future


class Engine {


  def createAuthor(author:Author): Unit ={
    println(author.authorId+" "+author.name)
  }

  def createQuestion(question: Question) : String = {
    return "Not implemented yet";
  }

  def listNewQuestions() : Seq[Question] = {
    return Seq.empty;
  }

  def getQuestion(questionId: Long)(implicit client: TcpClient) : Future[Option[Question]] = {

    return None;
  }

  def createAnswer(answer: Answer) : Option[Question] = {
    return None;
  }
}

object Test extends App {

  val c = Author(1,"Shalz")
  val a = Answer(10, 1, "this is answer 1", 1, Timestamp.valueOf("2017-10-11 11:17:31")) //Timestamp format must be yyyy-mm-dd hh:mm:ss[.fffffffff]
  val b = Question(1, 1, "when is lunchtime?", Seq("Social"), 1, Timestamp.valueOf("2017-10-11 11:27:31"))

  println(a)
  println(b)
  println(c)
}
