val xValues = 1 to 4
val yValues = 1 to 2
val coordinates = for {
  x <- xValues
  y <- yValues
} yield (x, y)
coordinates(4)


val nums = List(List(1), List(2), List(3), List(4), List(5))
val result = for {
  numList <- nums
  num <- numList
  if (num % 2 == 0)
} yield (num)

// Which is the same as
nums.flatMap(numList => numList).filter(_ % 2 == 0)

// or the same as
nums.flatten.filter(_ % 2 == 0)

val nameList = List("Ben", "Dawn", "Andy", "Varun")
val nameListTwo = List(List("Ben"), List("Dawn"), List("Andy"), List("Varun"))

nameList.filter(_.toLowerCase.contains("a"))

nameListTwo.flatten.filter(_.toLowerCase.contains("a"))