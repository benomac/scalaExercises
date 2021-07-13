import scala.annotation.tailrec

@tailrec
def compound(per: Double, value: Double, time: Double): Double = {
  if(time == 0) value
  else {
    println((value / 100) * per + value)
    compound(per, ((value / 100) * per) + value, time - 1)
  }
}
println(compound(23, 100, 12))

