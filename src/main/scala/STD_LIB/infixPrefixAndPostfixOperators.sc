import scala.language.postfixOps

//Any method which takes a single parameter can be used as an infix operator:
// a.m(b) can also be written as a m b.
val g = 3
(g + 4)
g.+(4)

//Infix operators do NOT work if an object has a method that takes two parameters:
val g: String = "Check out the big brains on Brad!"
g indexOf 'o'
// g indexOf 'o', 4 should be (6) //indexOf(Char, Int) cannot be used as an infix operator
g.indexOf('o', 7)

//Any method which does not require a parameter can be used as a postfix operator: a.m can be written as a m.
//
//For instance, a.+(b) is equivalent to a + b and a.! is the same as a!.
//
//  Postfix operators have lower precedence than infix operators, so:
//
//  foo bar baz means foo.bar(baz).
//  foo bar baz bam means (foo.bar(baz)).bam
//foo bar baz bam bim means (foo.bar(baz)).bam(bim).

val g: Int = 31

(g toHexString)

//Prefix operators work if an object has a method name that starts with unary_ :
val g: Int = 31
(-g)