//HIGHER ORDER FUNCTIONS


//FIRST LAMBDA
def lambda = { x: Int => x + 1 }
def lambda2 = (x: Int) => x + 2
val lambda3 = (x: Int) => x + 3

val lambda4 = new Function1[Int, Int] {
  // apply is a special function, NOT just a function name
  // means apply body of function to the argument
  def apply(v1: Int): Int = v1 - 1
}

def lambda5(x: Int) = x + 1

val result = lambda(3)
val result1andhalf = lambda.apply(3) //this apply DOES NOT reference the apply in lambda4

val result2 = lambda2(3)
val result3 = lambda3(3)
val result4 = lambda4(3)
val result5 = lambda5(3)


//A closure is a function which maintains a reference to
// one or more variables outside of the function scope
// (it "closes over" the variables). Scala will detect
// that you are using variables outside of scope and
// create an object instance to hold the shared variables.

var incrementer = 1

def closure = { x: Int => x + incrementer }

val result1 = closure(10)



val result2 = closure(10)

def summation(x: Int, y: Int => Int): Int = y(x)

summation(1, closure)
summation(1, x => x + x)


//HIGHER ORDER FUNCTIONS, with and without syntactic sugar
def addWithoutSyntaxSugar(x: Int): Function1[Int, Int] = {
  new Function1[Int, Int]() {
    def apply(y: Int): Int = x + y
  }
}

def addWithSyntaxSugar(x: Int) = (y: Int) => x + y


addWithSyntaxSugar(1)(2)
addWithoutSyntaxSugar(1)(2)


def makeUpper(xs: List[String]) =
  xs map(_.toUpperCase)


def makeWhatEverYouLike(xs: List[String], sideEffect: String => String) =
  xs map sideEffect

makeUpper(List("ben", "dawn"))

makeWhatEverYouLike(List("ben", "dawn"), x => x.toUpperCase)
makeWhatEverYouLike(List("ben", "dawn"), x => x * 2)

val myName = (name: String) => s"My name is $name"
makeWhatEverYouLike(List("John", "Mark"), myName)
List("Scala", "Erlang", "Clojure") map (_.length)