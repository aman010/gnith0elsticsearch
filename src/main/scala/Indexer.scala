import akka.actor.{Props, ActorSystem}
import org.elasticsearch.client.{Requests, Client}



@SerialVersionUID(15l)
 class Indexer() extends Serializable {




  def createIndex(client: Client, _type: String, index: String, _id: String, fields: String) = (client.prepareGet(index, _type, _id).get().isExists()) match  {

    case true => {
     val system = ActorSystem("searching")
     system.actorOf(Props(new reciver()))
    }
    case false => {
      client.index(Requests.indexRequest(index)
        .`type`(_type)
        .id(_id)
        .source(fields)
      ).actionGet()

      val system = ActorSystem("searching")
      system.actorOf(Props(new reciver()))

    }



  }


    //client.admin().indices().prepareCreate(indexName)
    // .setSource(indexfile).execute().actionGet()
}

object Indexer {
  def apply() = new Indexer()
}























