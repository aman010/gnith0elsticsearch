import akka.actor.{ActorLogging, Actor, Props}
import org.elasticsearch.search.SearchHit

/**
 * Created by geek on 20/1/15.
 */
 class reciver extends Actor with ActorLogging{


context.actorOf(Props(new IndexedResponse())) ! "Maaza"

def receive ={
case msg:Array[SearchHit] => {
   for(m <- msg){
     log.info(m.getSourceAsString)
         }
  context.system.shutdown()
     }
   }
}
