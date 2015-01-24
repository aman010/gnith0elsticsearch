package deserial.source

import com.fasterxml.jackson.databind.JsonNode

/**
 * Created by geek on 18/1/15.
 */
class JacksonSource(root :JsonNode) extends DocumentSource{
def json = root.toString
}

object JacksonSource {
  def apply(root:JsonNode)  = new JacksonSource(root)

}