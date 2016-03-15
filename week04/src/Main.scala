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

  }
}
