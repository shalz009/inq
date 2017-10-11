package controllers

import play.api._
import play.api.mvc._
import java.util.UUID
import services.logic.AuthorHandler;
import scala.concurrent.Future

import javax.inject.Singleton

@Singleton
class AuthorController extends Controller {

  def create(name: String) = Action {

    AuthorHandler.handle(name)

    Ok("hello")



  }
}