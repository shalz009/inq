package controllers

import play.api._
import play.api.mvc._
import services.logic.TagHandler._

class TagController extends Controller {

	def createTag(name: String) = Action {
		val tag = create(name)
		Ok("Request completed")
	}

}
