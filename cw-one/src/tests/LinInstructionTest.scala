import org.scalatest.{FunSuite, Matchers}
import sml.LinInstruction

/**
  * Created by Workstation on 26/03/16.
  */
class LinInstructionTest extends FunSuite with Matchers {

  var instruction = LinInstruction("L1",0,10);

  test("Lin instruction has correct value") {
    assert(instruction.value == 10)
  }

  test("Lin instruction has correct register") {
    assert(instruction.register == 0)
  }

  test("Lin instruction has to produce correct string") {
    (instruction.toString()) should equal ("L1: lin register 0 value is 10");
  }

}
