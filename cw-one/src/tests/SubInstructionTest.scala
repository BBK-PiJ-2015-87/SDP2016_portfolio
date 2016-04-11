package sml.tests
import org.scalatest.{BeforeAndAfter, FunSuite}
import sml.{SubInstruction}

/**
  * SubInstruction test class.
  */
class SubInstructionTest extends FunSuite with BeforeAndAfter{

  var instruction: SubInstruction = _

  before {
    instruction = SubInstruction("L1",0,1,2);
  }

  test("Sub instruction has correct first operand") {
    assert(instruction.op1 == 1)
  }

  test("Sub instruction has correct second operand") {
    assert(instruction.op2 == 2)
  }

  test("Sub instruction has to produce correct string") {
    assert(instruction.toString() == "L1: sub 1 - 2 to 0")
  }

}