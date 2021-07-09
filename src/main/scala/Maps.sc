// MAPS

// For details go to https://www.scala-exercises.org/std_lib/maps

val thisMap = Map("one" -> 1, "two" -> 2, "three" -> 3)

thisMap.get("one").getOrElse("Not Found")
// is the same as
thisMap.getOrElse("one", "Not Found")

val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
val mapValues = myMap.values
mapValues.head
mapValues.last

val myMap =
  Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
val aNewMap = myMap - "MN"

"b".toUpperCase()