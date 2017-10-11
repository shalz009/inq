package services.logic

import services.model.Tag
import java.util.UUID
import org.joda.time.DateTime

object TagHandler {
	
	def create(name: String): Tag = {
		val tag = new Tag(UUID.randomUUID(), name, new DateTime)
		return tag
	}

}