import scala.collection.immutable.LazyList.cons

val list = List(("Phoenix", "Arizona"), "Austin" -> "Texas")

val f = ("Phoenix", "Arizona")
val g = "Austin" -> "Texas"

f.getClass
g.getClass

val h = Set(1, 2, 3, 4, 5, 89, 7)

h.head

val list = List(10, 19, 45, 1, 22)
list.tail

def makeLazyList(v: Int): LazyList[Int] = cons(v, makeLazyList(v + 1))
val a = makeLazyList(2)


val fibs: LazyList[BigInt] =
  BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map{ n => n._1 + n._2 }
fibs.take(5).foreach(println)

def makeLazyList(v: Int): LazyList[Int] = cons(v, makeLazyList(v + 1))
val a = makeLazyList(2)
a.take(3).toList
((a drop 6) take 3).toList

val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
val result = array splitAt 3
result._1.getClass
result._2

val array = Array(87, 44, 5, 4, 200, 10, 39, 100)

val oddAndSmallPartial: PartialFunction[Int, String] = {
  case x: Int if x % 2 != 0 && x < 100 => "Odd and less than 100"
}

val evenAndSmallPartial: PartialFunction[Int, String] = {
  case x: Int if x != 0 && x % 2 == 0 && x < 100 => "Even and less than 100"
}

val negativePartial: PartialFunction[Int, String] = {
  case x: Int if x < 0 => "Negative Number"
}

val largePartial: PartialFunction[Int, String] = {
  case x: Int if x > 99 => "Large Number"
}

val zeroPartial: PartialFunction[Int, String] = {
  case x: Int if x == 0 => "Zero"
}

val result = array groupBy {
  oddAndSmallPartial orElse
    evenAndSmallPartial orElse
    negativePartial orElse
    largePartial orElse
    zeroPartial
}

result("Even and less than 100").size
result("Large Number").size

val list = List(5, 4, 3, 2, 1)

val result = list.foldLeft(0) {
  (`running total`, `next element`) =>
  `running total` - `next element`
}

val list = List(5, 4, 3, 2, 1)
val result = list.foldRight(0) { (`next element`, `running total`) =>
  println(`running total`)
  `next element` - `running total`
}

val stringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
stringList.reduceLeft {
  _ + _
}

val stringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
stringList.reduceRight {
  _ + _
}
val intList = List(5, 4, 3, 2, 1)
intList.reduceRight((x, y) => x - y)

val list = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
list.transpose

val stringBuilder = new StringBuilder()
val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
stringBuilder.append("I want all the numbers 6-12: ")
list.filter(it => it > 5 && it < 13).addString(stringBuilder, ",")
