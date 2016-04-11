import org.scalatest.{BeforeAndAfter, FunSuite}
import sml.{DivInstruction}

/**
  * DivInstruction test class.
  */
class DivInstructionTest extends FunSuite with BeforeAndAfter{

  var instruction: DivInstruction = _

  before {
    instruction = DivInstruction("L1",0,1,2);
  }

  test("Div instruction has correct first operand") {
    assert(instruction.op1 == 1)
  }

  test("Div instruction has correct second operand") {
    assert(instruction.op2 == 2)
  }

  test("Div instruction has to produce correct string") {
    assert(instruction.toString() == "L1: div 1 / 2 to 0")
  }

}
