package sml.tests

import org.scalatest.{BeforeAndAfter, FunSuite}
import sml.OutInstruction

/**
  * OutInstruction test.
  */
class OutInstructionTest extends FunSuite with BeforeAndAfter{

  var instruction: OutInstruction = _

  before {
    instruction = OutInstruction("L1",0);
  }

  test("Out instruction has correct register") {
    assert(instruction.reg == 0)
  }

  test("Sub instruction has to produce correct string") {
    assert(instruction.toString() == "L1: out content of register 0 print out")
  }

}