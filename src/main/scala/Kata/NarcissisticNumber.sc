def narcissistic(n: Int): Boolean = {
  s"$n"
    .map(x => scala.math.pow(x.asDigit, n.toString.length))
    .sum == n
}
narcissistic(153)

