package deserial.source


trait DocumentSource {

def json : String

}

case class StringDocumentSource(str:String) extends DocumentSource {
  override def json = str
  }


trait DocumentMap {

  def map:Map[String , Any]

}