package controllers

import play._
import java.util.UUID
import services.logic.AuthorHandler;
import scala.concurrent.Future

object AuthorSvc extends Controller {

  def create(name: String) = Action {

    AuthorHandler.handle(name)
    OK(200)

  }
}