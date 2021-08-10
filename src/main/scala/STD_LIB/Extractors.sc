object Twice {
  def apply(x: Int): Int = x * 2
  def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
}

  val x = Twice.apply(2)
  x match {
    case Twice(n) => Console.println(n)
  } // prints 21
  Twice.unapply(x)
Twice(x)

class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)

object ChopShop {
  def apply(x: Car): Some[(String, String, Short, Short)] = Some(x.make.toUpperCase, x.model.toUpperCase, x.year, x.topSpeed)
  def unapply(x: Car) = Some((x.make, x.model, x.year, x.topSpeed))
}
val ChopShop(a, b, c, d) = new Car("Chevy", "Camaro", 1978, 120)
val newCar1 = new Car("Chevy", "Camaro", 1978, 120)

newCar1 match {
  case ChopShop(a, b, _, _) => (a, b)
  case _ => ("mb", "e class")
}

class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)
class Employee(val firstName: String, val middleName: Option[String], val lastName: String)

object Tokenizer {
  def unapply(x: Car) = Some((x.make, x.model, x.year, x.topSpeed))

  def unapply(x: Employee) = Some((x.firstName, x.lastName))
}

val result = new Employee("Kurt", None, "Vonnegut") match {
  case Tokenizer(c, d) => "c: %s, d: %s".format(c, d)
  case _ => "Not found"
}

class Employee(
                val firstName: String,
                val middleName: Option[String],
                val lastName: String)

object Employee {
  //factory methods, extractors, apply
  //Extractor: Create tokens that represent your object
  def unapply(x: Employee) =
    Some((x.lastName, x.middleName, x.firstName))
}

val singri = new Employee("Singri", None, "Keerthi")

val result = singri match {
  case Employee(singri.lastName, None, _) =>
    "Yay, Singri %s! with no middle name!".format(x)
  case Employee("Singri", Some(x), _) =>
    "Yay, Singri with a middle name of %s".format(x)
  case _ => "I don't care, going on break"
}
singri.lastName