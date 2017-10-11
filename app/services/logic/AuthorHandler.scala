package services.logic

import java.util.UUID

import org.joda.time.DateTime
import services.model.Author

import scala.concurrent.Future

object AuthorHandler {

  def handle(name: String): Future[String] = {
    val author = Author(UUID.randomUUID(), name, new DateTime)
    Future.successful("Success")
  }
}
