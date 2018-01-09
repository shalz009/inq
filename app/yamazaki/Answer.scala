package yamazaki

import java.sql.Timestamp


case class Answer (authorId:Long, questionId: Long, body:String, tenantId: Long, creationTime: Timestamp)

case class Question (questionId: Long, authorId:Long, body:String, tags: Seq[String], tenantId: Long, creationTime: Timestamp)

case class Author (authorId: Long, name: String)

case class Tag (tagId: Long, tagName: String)