package sml

/**
  * Instruction for printing out a value of a register to standard out.
  *
  * @param label of instruction
  * @param op opcode (print out)
  * @param reg value of which will be printed
  */
class OutInstruction(label: String, op: String, val reg: Int)
  extends Instruction(label, op){

  override def execute(m: Machine) {
    println(m.regs(reg))
  }

  override def toString(): String = {
    super.toString + " content of register " + reg + " print out"
  }
}

object OutInstruction {
  def apply(label: String, reg: Int) = {
    new OutInstruction(label, "out", reg)
  }
}

