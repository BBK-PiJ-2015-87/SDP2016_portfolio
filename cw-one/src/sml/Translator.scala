package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val SUB = "sub"
  private final val DIV = "div"
  private final val OUT = "out"
  private final val BNZ = "bnz"
  private final val MUL = "mul"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case DIV =>
            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case BNZ =>
            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
          case x =>
            println(s"Unknown instruction $x")
        }
      }
    }
    new Machine(labels, program)
  }

  /**
    * This method uses reflection
    *
    * @param m machine
    * @return
    */
  def readAndTranslateRefl(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        val constructor = Class.forName("sml." + fields(1).capitalize + "Instruction").getConstructors()(0)
        var list = List[AnyRef]()
        var element:AnyRef = null;
        //try to parse elements to int, if exception, leave as a string
        for (x <- 0 until fields.length){
          try {
            element = new Integer(fields(x).toInt)
          } catch {
            case ioe: NumberFormatException => element = fields(x)
          }
          list::=element
        }
        program = program :+ constructor.newInstance(list.reverse:_*).asInstanceOf[Instruction]
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) =
    new Translator(file)
}