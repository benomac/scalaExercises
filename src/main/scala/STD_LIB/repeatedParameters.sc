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


repeatedParameterMethod(
  3,
  "egg",
  List("a delicious sandwich", "protein", "high cholesterol"): _*)