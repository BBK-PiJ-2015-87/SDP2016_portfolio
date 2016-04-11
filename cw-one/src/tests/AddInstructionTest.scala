package sml.tests

import org.scalatest.{BeforeAndAfter, FunSuite}
import sml.{AddInstruction}

/**
  * Test class for add instruction
  */
class AddInstructionTest extends FunSuite with BeforeAndAfter{

  var instruction: AddInstruction = _

  before {
    instruction = AddInstruction("L1",0,1,2);
  }

  test("Add instruction has correct first operand") {
    assert(instruction.op1 == 1)
  }

  test("Add instruction has correct second operand") {
    assert(instruction.op2 == 2)
  }

  test("Add instruction has to produce correct string") {
    assert(instruction.toString() == "L1: add 1 + 2 to 0")
  }

}
