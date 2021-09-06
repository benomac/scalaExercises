object NoteClass {

//  case class Note(name: String, duration: String, octave: Int)


  sealed trait Symbol
  case class Note(name: String, duration: String, octave: Int) extends Symbol
  case class Rest(duration: String) extends Symbol

  val symbolNote: Symbol = Note("C", "Quarter", 3)
  val symbolRest: Symbol = Rest("Whole")

  val c3 = Note("C", "Quarter", 3)


  def symbolDuration(symbol: Symbol): String = symbol match {
    case Note(_, duration, _) => duration
    case Rest(duration) => duration
  }



}

import NoteClass._

c3.getClass
symbolNote.getClass
symbolRest.getClass

symbolDuration(symbolNote)
symbolDuration(symbolRest)

def unexhaustive(): Unit = {
  sealed trait Symbol
  case class Note(name: String, duration: String, octave: Int) extends Symbol
  case class Rest(duration: String) extends Symbol

  def nonExhaustiveDuration(symbol: Symbol): String =
    symbol match {
      case Rest(duration) => duration
    }
}

def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(x: Int, acc: Int): Int =
    if (x > b) acc
    else loop(x + 1, acc + f(x))
  loop(a,
    0
  )
}
sum(x => x, 1, 10)