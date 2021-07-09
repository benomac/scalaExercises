object Main extends App {
  case class Dog(name: String, breed: String)

  val d1 = Dog("Scooby", "Doberman")
  val d2 = Dog("Rex", "Custom")
  val d3 = new Dog("Scooby", "Doberman") // the old way of creating using new

  println(d1.toString)
}
