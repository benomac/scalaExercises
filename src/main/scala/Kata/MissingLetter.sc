import scala.annotation.tailrec

def findMissingLetter(chars: Array[Char]): Char = {
  @tailrec
  def loop(c: Array[Char], acc: Int): Char = {
    if (c.head.hashCode != acc + 1) (acc + 1).toChar
    else loop(c.tail, c.head.hashCode)
  }
  loop(chars, chars.head.hashCode - 1)
}


findMissingLetter(Array('a', 'b', 'c', 'd', 'f'))