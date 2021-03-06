package gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LegendaryItemSpec extends AnyFlatSpec with Matchers {
  it should "not change anything" in {
    val sub1 = LegendaryItem("bps", 0, 80).degrade().get()
    sub1.quality shouldBe 80
    sub1.sellIn shouldBe 0

    val sub2 = LegendaryItem("bps", 5, 10).degrade().get()
    sub2.quality shouldBe 10
    sub2.sellIn shouldBe 5
  }

  it should "not allow quality > 80" in {
    an [AssertionError] should be thrownBy LegendaryItem("bps", 0, 81).degrade()
  }

}
