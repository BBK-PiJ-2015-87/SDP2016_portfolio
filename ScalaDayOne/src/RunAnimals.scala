/**
 * Created by vivano03 on 04/02/2016.
 */
object RunAnimals {
  def main(args: Array[String]): Unit = {
    val tiger = new Tiger
    val tiger2 = new Tiger
    println(tiger)
    println(tiger2)
    println(Integer.toHexString(tiger2.hashCode()))
    val giraffe = new Giraffe
    println(giraffe)

  }
}
