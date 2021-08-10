package STD_LIB

object Main extends App {
  def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
    "%d %ss can give you %s".format(x, y, z.mkString(", "))
    s"$x $y can give you ${z.mkString(", ")}"
  }

  val d = repeatedParameterMethod(
    3,
    "egg",
    "a delicious sandwich",
    "protein",
    "high cholesterol")
  d.getClass
  val c = repeatedParameterMethod(
    3,
    "egg",
    List("a delicious sandwich", "protein", "high cholesterol"))

  List("a delicious sandwich", "protein", "high cholesterol").mkString(", ")


  val e = repeatedParameterMethod(
    3,
    "egg",
    List("a delicious sandwich", "protein", "high cholesterol"): _*)
println("ben".getClass)
  println(d)
  println(c.getClass)
  println(e)
}
