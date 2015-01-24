import akka.actor.{Actor, ActorRef, Props}
import org.elasticsearch.action.search.SearchType
import org.elasticsearch.index.query.{MatchQueryBuilder, QueryBuilders}
import org.elasticsearch.search.SearchHit

/**
 * Created by geek on 20/1/15.
 */

 class IndexedResponse() extends Actor{

  private  var originalSender : Option[ActorRef] = None


  def search(msg:String):Array[SearchHit]= {
    val hits = search_amaz.getClient.prepareSearch("jdbc")
      .setTypes("jdbc")
      .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
      .setQuery(QueryBuilders.multiMatchQuery(msg, "addon_item").operator(MatchQueryBuilder.Operator.OR))
      .setSize(1)
      .execute()
      .actionGet()
      .getHits

println(hits.getTotalHits)

hits.getHits
    }

  def receive = {
    case query =>
     sender ! (search(query.toString))
   }


}


