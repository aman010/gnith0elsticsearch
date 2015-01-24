package deserial.source

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

/**
 * Created by geek on 18/1/15.
 */
class ObjectSource(any:Any) extends DocumentSource{
def json:String = ObjectSource.mapper.writeValueAsString(any)


}
object ObjectSource {
  val mapper  =new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)
  def apply(any:Any) = new ObjectSource(any)

}