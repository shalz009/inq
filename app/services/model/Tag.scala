package services.model

import java.util.UUID

import org.joda.time.DateTime

/**
 * Created by v723840 on 10/11/17.
 */
case class Tag (id: UUID = UUID.randomUUID(),
          name: String,
      	  createdAt: DateTime = new DateTime)
