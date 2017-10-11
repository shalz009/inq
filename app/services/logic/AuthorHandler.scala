package services.logic

import java.util.UUID
import scala.concurrent.Future
import services.model.Author
import org.joda.time.DateTime

object AuthorHandler {

    def handle(name: String) : Future[String] = {

        val author = new Author(UUID.randomUUID(), name, new DateTime)
        Future.successful("Success")
    }
}