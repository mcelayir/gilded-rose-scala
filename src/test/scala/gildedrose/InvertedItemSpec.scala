package gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class InvertedItemSpec extends AnyFlatSpec with Matchers {
  it should "increase quality by 1 if sell in > 0 " in {
    val sub1 = InvertedItem("bps", 2, 0).degrade().get()
    sub1.quality shouldBe 1
    sub1.sellIn shouldBe 1
  }

  it should "increase quality by 2 if sell in <= 0 " in {
    val sub1 = InvertedItem("bps", 1, 0).degrade().get()
    sub1.quality shouldBe 2
    sub1.sellIn shouldBe 0
  }

  it should "not increase quality more than allowed " in {
    val sub1 = InvertedItem("bps", 0, 49).degrade().get()
    sub1.quality shouldBe 50
    sub1.sellIn shouldBe -1

    val sub2 = InvertedItem("bps", -1, 50).degrade().get()
    sub2.quality shouldBe 50
    sub2.sellIn shouldBe -2
  }

}
