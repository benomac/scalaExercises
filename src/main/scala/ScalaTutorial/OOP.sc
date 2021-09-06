class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def addRational(r: Rational): Rational =
    new Rational(
      r.numer * denom + numer * r.denom,
      r.denom * denom)

  def makeString(r: Rational) =
    s"${r.numer}/${r.denom}"
}

val frac1 = new Rational(1, 2)

frac1.numer
frac1.denom

frac1.addRational(new Rational(1, 2))
frac1.makeString(frac1.addRational(new Rational(1, 2)))

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}