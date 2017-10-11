package core

import java.util.UUID

trait ESEntity {
  def id: UUID

  def estype: String

  def fieldsAsMap: Map[String, Any]
}
