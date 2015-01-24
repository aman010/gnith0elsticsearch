import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.transport.InetSocketTransportAddress



object search_amaz extends App {

  val client = new TransportClient()
    .addTransportAddress(new InetSocketTransportAddress("112.196.38.242", 9300))




  def getClient = client

  val index = "_river"

  val _type = "gedit2"

  val _id = "_meta"

  val fields =
    """{
     |"settings" : {
     |"number_of_shards" : 0,
     |"number_of_replicas" : 0
     |},
     "type"      : "jdbc",
     |"jdbc"     : {
     |"url"      : "jdbc:mysql://112.196.38.250:3306/gedit" ,
     |"user"     : "arcadian1" ,
     |"password" : "mysql" ,
     |"sql"      : "select addon_id as _id , addon_item as addon_item from addons",
     |"shard"    : 0 ,
     |"size"     : 30
     |}
     |}"""
      .stripMargin

val state =Indexer().createIndex(client,
    _type,
    index,
    _id,
    fields)



  def getindex = index
  def get_type = _type
  def get_id = _id



}
