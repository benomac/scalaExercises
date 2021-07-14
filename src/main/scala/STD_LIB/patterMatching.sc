def matchTest(x: Int): String = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "many" // case _ will trigger if all other cases fail.
}

matchTest(2)

matchTest(9)

val stuff = "blue"

val myStuff = stuff match {
  case "red" => println("RED"); 1
  case "blue" => println("BLUE"); 2
  case "green" => println("GREEN"); 3
  case _ => println(stuff); 0 // case _ will trigger if all other cases fail.
}

println(myStuff == 2)

//Pattern matching can wildcard parts of expressions:

def goldilocks(expr: Any) =
  expr match {
    case ("porridge", _) => "eating"
    case ("chair", "Mama") => "sitting"
    case ("bed", "Baby") => "sleeping"
    case _ => "what?"
  }

goldilocks(("porridge", "space"))


//A backquote can be used to refer to a stable variable
// in scope to create a case statement - this prevents "variable shadowing":
val foodItem = "porridge"

def goldilocks2(expr: (String, String)) =
  expr match {
    case (`foodItem`, _) => "eating"
    case ("chair", "porridge") => "sitting"
    case ("bed", "Baby") => "sleeping"
    case _ => "what?"
  }

goldilocks2((foodItem, "Papa"))
goldilocks2(("porridge", "Cousin"))