package sml

/**
  * Instruction to move value to a register.
  *
  * @param label of instruction
  * @param opcode of instruction
  * @param register destination
  * @param value to be moved to register
  */
case class LinInstruction(label: String, opcode: String, register: Int, value: Int) extends Instruction(label, opcode) {

  override def execute(m: Machine) =
    m.regs(register) = value

  override def toString(): String = {
    super.toString + " register " + register + " value is " + value
  }
}

object LinInstruction {
  def apply(label: String, register: Int, value: Int) =
    new LinInstruction(label, "lin", register, value)
}