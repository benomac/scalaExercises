// Chars that are allowed ':' ';' '-' '~' ')' 'D'
val smiles = Vector(":D",":~)",";~D",":-)", ":)", ":)D")
val regexPattern = "^[:;][~-]?[)D]$".r


//def countSmileys(vec: Vector[String]): Int = {
//  def loop(v: Vector[String], smile: Vector[String], acc: Int): Int = {
//    if (smile.isEmpty) acc
//    else
//      if (v.contains(smile.head)) loop(v, smile.tail, acc + v.count(x => x == smile.head))
//      else loop(v, smile.tail, acc)
//  }
//  loop(vec, smiles, 0)
//}
//countSmileys(Vector(":D",":~)",";~D",":)"))
//countSmileys(Vector(":)",":(",":D",":O",":;"))
//countSmileys(Vector(";]", ":[", ";*", ":$", ";-D"))

smiles.flatMap(x => regexPattern.findAllMatchIn(x))

val smiled = smiles.map(x => for (patterMatch <- regexPattern.findAllMatchIn(x))
  patterMatch.groupCount
)
smiled.length
