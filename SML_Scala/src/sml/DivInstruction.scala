package sml

/**
  * Instruction to divide two register values.
  *
  * @param label of instruction
  * @param op operation code of instruction (div)
  * @param result of the operation
  * @param op1 numerator
  * @param op2 denominator
  */
class DivInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op){

  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 / value2
  }

  override def toString(): String = {
    super.toString + " " + op1 + " / " + op2 + " to " + result
  }
}

object DivInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int) = {
    new DivInstruction(label, "div", result, op1, op2)
  }
}
