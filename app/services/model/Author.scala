package services.model

import org.joda.time.DateTime
import java.util.UUID

case class Author (
                  id : UUID = UUID.randomUUID(),
                  name : String,
                  createdAt : DateTime = new DateTime()
                  )