def abs(x: Double) = if (x >= 0) x else -x
abs(-1)

abs(-8)

val e = true
!true
!false
true && e
false && e
true || e
false || e


def improve(guess: Double, x: Double) =
  (guess + x / guess) / 2

def isGoodEnough(guess: Double, x: Double) =
  abs(guess * guess - x) < 0.001

def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)



def sqrt(x: Double) = sqrtIter(1.0, x)
sqrt(5)
1.4142156862745097 * 1.4142156862745097
5.0 / 2
val c = 2.5 * 2
c.toInt

val x = 0
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  println(x)
  x * x
} + x