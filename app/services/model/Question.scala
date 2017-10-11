package services.model

import java.util.UUID

import org.joda.time.DateTime

/**
 * Created by v723840 on 10/11/17.
 */
case class Question (
                    id: UUID = UUID.randomUUID(),
                    authorId : UUID,
                    body: String,
                    tags: Set[Tag],
                    createdAt: DateTime = new DateTime())
