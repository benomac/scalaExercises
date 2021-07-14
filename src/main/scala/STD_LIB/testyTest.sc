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



def sumOfList(lst: List[Int]): Int = {
  lst match {
    case Nil => 0
    case head :: tail => head + sumOfList(tail)
  }
}

sumOfList(List(1,2,3,4))