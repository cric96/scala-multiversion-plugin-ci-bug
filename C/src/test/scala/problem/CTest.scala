package problem

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CTest extends AnyFlatSpec with Matchers{
  it should "work" in {
    Thread.sleep(1000) // simulate a long test
    C().foo shouldBe A().foo + B().foo
  }
}
