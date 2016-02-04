/**
 * Created by vivano03 on 04/02/2016.
 */
object Main {
  def main(args: Array[String]): Unit = {
    val value = 17;
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

  }
}
