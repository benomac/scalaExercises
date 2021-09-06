def solution(s: String): List[String] = {
  def loop(str: String, acc: List[String]): List[String] ={
    if (str == "") acc
    else
      if (str.length == 1) loop("", acc :+ str + "_")
      else loop(str.slice(2, str.last), acc :+ str.slice(0, 2))
  }
  loop(s, Nil)
}
solution(("ben"))
