package gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ConjuredItemSpec extends AnyFlatSpec with Matchers {

  it should "decrease quality by 2 if sellIn > 0  " in {
    val sub1 = ConjuredItem("bps", 2, 10).degrade().get()
    sub1.quality shouldBe 8
    sub1.sellIn shouldBe 1
  }

  it should "decrease quality by 4 if sellIn < 0  " in {
    val sub1 = ConjuredItem("bps", 1, 10).degrade().get()
    sub1.quality shouldBe 6
    sub1.sellIn shouldBe 0
  }

  it should "not decrease quality if quality <= 0  " in {
    val sub1 = ConjuredItem("bps", -1, 0).degrade().get()
    sub1.quality shouldBe 0
    sub1.sellIn shouldBe -2
  }
}
