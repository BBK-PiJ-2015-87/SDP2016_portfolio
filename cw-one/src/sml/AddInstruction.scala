package sml

/**
  * Instruction to add two register values.
  *
  * @param label of instruction
  * @param op operation code of instruction (add)
  * @param result of the operation
  * @param op1 first operand
  * @param op2 second operand
  */
class AddInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 + value2
  }

  override def toString(): String = {
    super.toString + " " + op1 + " + " + op2 + " to " + result
  }
}

object AddInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int) = {
    new AddInstruction(label, "add", result, op1, op2)
  }
}