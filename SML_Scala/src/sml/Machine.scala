package sml

/**
  * The machine language interpreter
  */
case class Machine(labels: Labels, prog: Vector[Instruction]) {
  private final val NUMBEROFREGISTERS = 32
  // The registers of the SML machine
  val regs: Registers = new Registers(NUMBEROFREGISTERS)

  var PC = 0; // program counter

  override def toString(): String = {
    prog.foldLeft("")(_ + _)
  }

  // Execute the program in prog, beginning at instruction 0.
  // Precondition: the program and its labels have been store properly.
  def execute(start: Int) ={
    PC = start;
    while (PC < prog.length){
      prog(PC) execute this
      PC += 1
    }

//      start.until(prog.length).foreach(x => prog(x) execute this)
  }

}

object Machine extends App {
  //for tests without a command line
  override val args:Array[String] = new Array[String](3)
  args(0) = "C:\\Users\\Workstation\\Desktop\\IdeaProjects\\Birkbeck\\SDP2016_portfolio\\SML_Scala\\src\\factorial.sml"


  if (args.length == 0) {
    println("Machine: args should be sml code file to execute")
  } else {
    println("SML interpreter - Scala version")

    val m = Translator(args(0)).readAndTranslate(new Machine(Labels(), Vector()))

    println("Here is the program; it has " + m.prog.size + " instructions.")
    println(m)
    println("Beginning program execution.")
    m.execute(0)
    println("Ending program execution.")
    println("Values of registers at program termination:")
    println(m.regs + ".")
  }
}