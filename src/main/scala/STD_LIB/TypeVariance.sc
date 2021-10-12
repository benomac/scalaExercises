class MyContainer[A](val a: A)(implicit manifest: scala.reflect.Manifest[A]) {
  def contents = a
}
val fruitBasket = new MyContainer[Int](1)
fruitBasket.contents

val fruitBasket1: MyContainer[String] = new MyContainer("dawn")

fruitBasket1.contents
