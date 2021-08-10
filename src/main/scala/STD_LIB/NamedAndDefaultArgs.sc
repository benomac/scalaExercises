object colours {
  class WithClassParametersInClassDefinition(val defaultRed: Int = 0, val defaultGreen: Int = 255, val defaultBlue: Int = 100) {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }
  }

}
import colours._
val me = new WithClassParametersInClassDefinition()
val myColour = me.addColorsWithDefaults(green = 70)

def reduce(a: Int, f: (Int, Int) => Int = _ + _): Int = f(a, a)

reduce(5)
reduce(5, f = _ * _ )

