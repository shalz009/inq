package core

import java.util.UUID

import com.sksamuel.elastic4s.ElasticsearchClientUri
import com.sksamuel.elastic4s.http.HttpClient
import core.ESBase.client
import org.joda.time.DateTime
import services.model.Question
import services.model.Author

object Test {
  def main(args: Array[String]) {
    val qid = UUID.randomUUID()
    val input = Question(qid, UUID.randomUUID(), "Who are you?", Set.empty, new DateTime())
    println(s"input = $input")
    ESBase.insert(input)
    val result = Question.apply(qid, ESBase.lookup(qid, "question"))
    println(s"result = $result")
    ESBase.updateSingle(result.copy(body = "Updated Body"))

    /*
     * Delete Question by ID
     */
    val q1 = Question(UUID.randomUUID(), UUID.randomUUID(), "Test Delete Question by ID", Set.empty, new DateTime())
    ESBase.insert(q1)
    ESBase.deleteByID(q1.id, q1.estype)
  }
}
