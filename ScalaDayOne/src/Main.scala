/**
 * Created by vivano03 on 04/02/2016.
 */
object Main {
  def main(args: Array[String]): Unit = {
    var value = 17;
//    value = 20; //cant change value
    println(value)
    var text = "ABC1234"
    text = "ABC1234"
    println(text)
    var number = 15.56
    println(number)

    def checkWeather(sky:String, tmp:Int) : Boolean ={
      if ((sky.equals("sunny") || sky.equals("partly cloudy")) && tmp > 80) {
        return true
      } else {
        return false
      }
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

    def celsiusToFahrenhit(temperature: Float) : Float = {
      return temperature * 9 / 5 +32
    }

    println(celsiusToFahrenhit(26.666666f))

    def getSquare(num: Double) : Double = {
      return num * num
    }
    assert(9 == getSquare(3))

  }
}
