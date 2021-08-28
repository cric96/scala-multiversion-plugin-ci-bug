package problem

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BTest {
  class CTest extends AnyFlatSpec with Matchers{
    it should "work" in {
      B().foo shouldBe A().foo
    }
  }
}
