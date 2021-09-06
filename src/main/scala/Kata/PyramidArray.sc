

val a = 2
val b = (0 to a).toList

  def pyramid(i: Int, acc: List[List[Int]] = Nil): List[List[Int]] = {
    if (i == 0) acc.map(x => x.map(y => 1))
    else pyramid(i - 1, (1 to i).toList +: acc)
  }

pyramid(6)

def pyramid2(i: Int, acc: List[List[Int]] = Nil): List[List[Int]] = {
  if (i == 0) acc.map(x => x.map(y => 1))
  else pyramid2(i - 1, List.fill(i)(1) :: acc)
}

pyramid(6)