//A partial function is a trait that when implemented can be used as
// building blocks to determine a solution.
// The trait PartialFunction requires that the method
// isDefinedAt and apply be implemented:

val doubleEvens: PartialFunction[Int, Int] =
  new PartialFunction[Int, Int] {
    //States that this partial function will take on the task
    def isDefinedAt(x: Int): Boolean = x % 2 == 0

    //What we do if this partial function matches
    def apply(v1: Int): Int = v1 * 2
  }

val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
  def isDefinedAt(x: Int): Boolean = x % 2 != 0

  def apply(v1: Int) = v1 * 3
}

val whatToDo = doubleEvens orElse tripleOdds //Here we chain the partial functions together

whatToDo(3)
whatToDo(4)

//Case statements are a quick way to create partial functions.
// When you create a case statement, the apply and isDefinedAt
// methods are created automatically.

val doubleEvens2: PartialFunction[Int, Int] = {
  case x if (x % 2) == 0 => x * 2
}
val tripleOdds2: PartialFunction[Int, Int] = {
  case x if (x % 2) != 0 => x * 3
}

val whatToDo2 = doubleEvens2 orElse tripleOdds2 //Here we chain the partial functions together
whatToDo2(3)
whatToDo2(4)

//The result of partial functions can have an andThen
// function added to the end of the chain:

val doubleEvens3: PartialFunction[Int, Int] = {
  case x if (x % 2 ) == 0 => x * 2
}

val tripleOdds3: PartialFunction[Int, Int] = {
  case x if (x % 2) != 0 => x * 3
}

val addFive = (x: Int)  => x + 5
val whatToDo3 =
  doubleEvens3 orElse tripleOdds3 andThen addFive // Here we chain the partial functions together

whatToDo3(3)
whatToDo3(4)


//andThen can be used to continue onto another chain of logic:
val doubleEvens4: PartialFunction[Int, Int] = {
  case x if (x % 2) == 0 => x * 2
}

val tripleOdds4: PartialFunction[Int, Int] = {
  case x if (x % 2) != 0 => x * 3
}

val printEven: PartialFunction[Int, String] = {
  case x if (x % 2) == 0 => "Even"
}

val printOdd: PartialFunction[Int, String] = {
  case x if (x % 2) != 0 => "Odd"
}

val whatToDo4 = doubleEvens4 orElse tripleOdds4 andThen (printEven orElse printOdd)
doubleEvens4(2)
whatToDo4(3)
whatToDo4(4)












