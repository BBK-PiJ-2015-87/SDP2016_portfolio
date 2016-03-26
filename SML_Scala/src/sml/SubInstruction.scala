package sml

/**
  * Subtraction instruction.
  *
  * @param label of instruction
  * @param op op code (sub)
  * @param result register
  * @param op1 initial value to be subtracted from
  * @param op2 value to be subtracted
  */
class SubInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int) extends Instruction(label, op){
  override def execute(m: Machine): Unit = {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 - value2
  }

  override def toString(): String = {
    super.toString + " " + op1 + " - " + op2 + " to " + result
  }
}

object SubInstruction{
  def apply(label: String, result: Int, op1: Int, op2: Int) ={
    new SubInstruction(label, "sub", result, op1, op2)
  }
}
