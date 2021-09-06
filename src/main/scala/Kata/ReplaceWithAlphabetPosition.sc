
def alphabetPosition(text: String): String = {
  val tL = text.toList
  def loop(t: List[Char], acc: String): String = {
    if (t == Nil) acc
    else if (!t.head.isLetter) loop(t.tail, acc)
    else loop(t.tail, acc + s"${(t.head.toLower - 96)} ")
  }
  loop(tL, "").trim
}

def loop(t: List[Char], acc: String): String = t match {
  case Nil => acc
  case head :: tail =>
}

alphabetPosition("The sunset sets at twelve o' clock.")


  def alphabetPosition1(text: String): String =
    text.filter(_.isLetter).map(c => c.asDigit - 9).mkString(" ")

alphabetPosition1("The sunset sets at twelve o' clock.")

def getPosition(letter: Char) : String = {
  val alphabet = ('a' to 'z').toList
  val alphabetIndexed = alphabet.zipWithIndex

  if (!alphabet.contains(letter.toLower)) ""
  else " " + alphabetIndexed
    .filter(_._1 == letter.toLower)
    .map(_._2)
    .head
    .+(1)
    .toString;
}

def alphabetPosition(text: String): String = text.foldLeft("")(_ + getPosition(_)).tail

