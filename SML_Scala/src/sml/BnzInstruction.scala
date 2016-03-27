package sml

/**
  * Instruction for printing out a value of a register to standard out.
  *
  * @param label of instruction
  * @param op opcode (jump)
  * @param reg if not 0 then jump
  * @param next label of instruction to jump to
  */
class BnzInstruction(label: String, op: String, val reg: Int, next: String)
  extends Instruction(label, op){

  override def execute(m: Machine) {
    val index = m.labels.labels.indexOf(next);

    if (m.regs(reg) != 0) {
      m.PC = index - 1; //with PC counter
//      m.execute(index) // no PC counter
    }
  }

  override def toString(): String = {
    super.toString + " next " + next
  }
}

object BnzInstruction {
  def apply(label: String, reg: Int, next: String ) = {
    new BnzInstruction(label, "bnz", reg, next)
  }
}