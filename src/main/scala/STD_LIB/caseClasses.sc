abstract class Term
case class Var(name: String) extends Term
case class Fun(arg: String, body: Term) extends Term
case class App(f: Term, v: Term) extends Term


//This class hierarchy can be used to represent terms of the untyped lambda calculus.
// To facilitate the construction of case class instances,
// Scala does not require that the new primitive is used.
// One can simply use the class name as a function.
//
//Here is an example:
Fun("x", Fun("y", App(Var("x"), Var("y"))))

//The constructor parameters of case classes are treated as public values and can be accessed directly.
val x = Var("x")
println(x.name)

//For every case class the Scala compiler generates an
// equals method which implements structural equality and a toString method. For instance,
val x1 = Var("x")
val x2 = Var("x")
val y1 = Var("y")


println("" + x1 + " == " + x2 + " => " + (x1 == x2))
println("" + x1 + " == " + y1 + " => " + (x1 == y1))



def printTerm(term: Term): Unit = {
  term match {
    case Var(n) =>
      print(n)
    case Fun(x, b) =>
      print("^" + x + ".")
      printTerm(b)
    case App(f, v) =>
      print("(")
      printTerm(f)
      print(" ")
      printTerm(v)
      print(")")
  }
}
def isIdentityFun(term: Term): Boolean = term match {
  case Fun(x, Var(y)) if x == y => true
  case _ => false
}
val id = Fun("x", Var("x"))
val t = Fun("x", Fun("y", App(Var("x"), Var("y"))))
printTerm(t)
println
println(isIdentityFun(id))
println(isIdentityFun(t))

case class Person(first: String, last: String)

val p1 = new Person("Fred", "Jones")
val p2 = new Person("Shaggy", "Rogers")
val p3 = new Person("Fred", "Jones")

//checks if they contain the same information
(p1 == p2)
(p1 == p3)

//checks if they are the same object entirely, do they point to the same thing.
//eq == equality
(p1 eq p2)
(p1 eq p3)
(p1 eq p1)

p1.hashCode
p3.hashCode


case class Dog(name: String, breed: String)

val d1 = Dog("Scooby", "Doberman")
val d2 = Dog("Rex", "Custom")
val d3 = new Dog("Scooby", "Doberman") // the old way of creating using new

d1.toString













