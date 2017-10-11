package core

import java.util.UUID

import com.sksamuel.elastic4s.ElasticsearchClientUri
import com.sksamuel.elastic4s.http.HttpClient
import com.sksamuel.elastic4s.http.search.SearchResponse
import org.elasticsearch.action.support.WriteRequest.RefreshPolicy

object ESBase {

  import com.sksamuel.elastic4s.http.ElasticDsl._
  val client = HttpClient(ElasticsearchClientUri("localhost", 9200))


  def insert[A <: ESEntity](a:A) = {
    client.execute {
      indexInto("inq" / a.estype).id(a.id).fields(a.fieldsAsMap)
    }
  }.await

  def deleteByID(id: UUID, estype: String) = {
    client.execute {
      delete(id).from(("inq", estype))
    }
  }.await


//  val result = client.execute {
//    search("myindex").matchQuery("capital", "ulaanbaatar")
//  }.await
//
//
//  client.execute{
//    search("")
//  }
  // prints out the original json
//  println(result.hits.head.sourceAsString)

//  client.close()

}
