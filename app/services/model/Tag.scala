package services.model

import java.util.UUID

/**
 * Created by v723840 on 10/11/17.
 */
case class Tag (
          id: UUID = UUID.randomUUID(),
          name: String)
