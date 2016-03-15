/**
 * Created by vivano03 on 04/02/2016.
 */
object Main {
  def main(args: Array[String]): Unit = {


    def checkWeather(sky:String, tmp:Int) : Boolean = (sky, tmp) match {
      case ("sunny" | "partly cloudy", x) if x > 80  => return true
      case _ => return false
    }

    println(checkWeather("sunny", 82))
    println(checkWeather("sunny", 70))
    println(checkWeather("partly cloudy", 82))
    println(checkWeather("partly cloudy", 70))
    println(checkWeather("rainy", 82))
    println(checkWeather("rainy", 72))

    def fahrenheitToCelsius(temperature: Float) : Float = {
      return (temperature - 32) * 5 / 9
    }

    println(fahrenheitToCelsius(80))
    println(fahrenheitToCelsius(81))

    def celsiusToFahrenheit(temperature: Float) : Float = {
      return temperature * 9 / 5 +32
    }

    println(celsiusToFahrenheit(26.666666f))

    def getSquare(num: Double) : Double = {
      return num * num
    }
    assert(9 == getSquare(3))
    assert(4 == getSquare(-2))
    assert(36 == getSquare(6))
    assert(100 != getSquare(11))

    def isArg1GreaterThanArg2(one:Double, two:Double) : Boolean ={
      return one > two
    }
    assert(!isArg1GreaterThanArg2(4.1, 4.12))
    assert(isArg1GreaterThanArg2(2.1, 1.2))

    def manyTimes(text:String, iter:Int) : String = {
      return text * iter
    }

    println(manyTimes("abc", 3))
    assert(manyTimes("abc", 3) == "abcabcabc", "ABC test failed")
    assert(manyTimes("123", 3) == "123123123", "123 test failed")

    val range1 = 1 to 5
    println(range1.step)
    val range2 = 1 to 10 by 2
    println(range2.step)

    var sa1 = "Sally"
    var sa2 = "Sally"

    if(sa1.equals(sa2)) println("s1 and s2 are equal") else println("s1 and s2 are NOT equal")
    if(sa1 == sa2) println("s1 and s2 are equal") else println("s1 and s2 are NOT equal")


    val sailboat = new Sailboat;
    val r1 = sailboat.raise()
    assert(r1 == "Sails raised", "Expected Sails raised, Got " + r1)
    val r2 = sailboat.lower()
    assert(r2 == "Sails lowered", "Expected Sails lowered, Got " + r2)

    val motorboat = new Motorboat
    val s1 = motorboat.on()
    assert(s1 == "Motor on", "Expected Motor on, Got " + s1)
    val s2 = motorboat.off()
    assert(s2 == "Motor off", "Expected Motor off, Got " + s2)
  }
}
