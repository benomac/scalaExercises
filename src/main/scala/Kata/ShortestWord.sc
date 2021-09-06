def findShort(str: String): Int = {
  val sSplit = str.split(" ").toList
  def loop(l: List[String], acc: String): Int = {
    if (l == Nil) acc.length
    else
      if (l.head.length < acc.length) loop(l.tail, l.head)
      else loop(l.tail, acc)
  }
  loop(sSplit, sSplit.head)
}
findShort("bitcoin take over the world maybe who knows perhaps")
"Hello, " + "Scala!"