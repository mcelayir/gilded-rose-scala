package gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DegradeableItemSpec extends AnyFlatSpec with Matchers {
  it should "not decrease quality below 0 " in {
    val sub1 = new DegradeableItem("bps", 0, 0){
      override def degrade(): Degradeable[Item] = this
    }
    sub1.decreaseQuality(10) shouldBe 0
  }

  it should "not increase quality above 50 " in {
    val sub1 = new DegradeableItem("bps", 0, 50){
      override def degrade(): Degradeable[Item] = this
    }
    sub1.increaseQuality(10) shouldBe 50
  }

  it should "increas/decrease quality " in {
    val sub1 = new DegradeableItem("bps", 0, 10){
      override def degrade(): Degradeable[Item] = this
    }
    sub1.decreaseQuality(10) shouldBe 0
    sub1.increaseQuality(50) shouldBe 50
  }
}
