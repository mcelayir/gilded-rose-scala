package gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BackstagePassItemSpec extends AnyFlatSpec with Matchers {
  it should "increase quality by 3 if sellIn <= 5  " in {
    val sub1 = BackstagePassItem("bps", 5, 10).degrade().get()
    sub1.quality shouldBe 13
    sub1.sellIn shouldBe 4

    val sub2 = BackstagePassItem("bps", 4, 10).degrade().get()
    sub2.quality shouldBe 13
    sub2.sellIn shouldBe 3
  }

  it should "increase quality by 2 if sellIn <= 10  " in {
    val sub1 = BackstagePassItem("bps", 10, 10).degrade().get()
    sub1.quality shouldBe 12
    sub1.sellIn shouldBe 9

    val sub2 = BackstagePassItem("bps", 9, 10).degrade().get()
    sub2.quality shouldBe 12
    sub2.sellIn shouldBe 8
  }

  it should "decrease quality by 1 if sellIn > 10  " in {
    val sub1 = BackstagePassItem("bps", 11, 10).degrade().get()
    sub1.quality shouldBe 9
    sub1.sellIn shouldBe 10
  }

  it should "not decrease quality if quality <= 0  " in {
    val sub1 = BackstagePassItem("bps", -1, 0).degrade().get()
    sub1.quality shouldBe 0
    sub1.sellIn shouldBe -2
  }

  it should "decrease quality to zero if sellIn == 0 decrease quality if quality <= 0  " in {
    val sub1 = BackstagePassItem("bps", 1, 50).degrade().get()
    sub1.quality shouldBe 0
    sub1.sellIn shouldBe 0
  }

}
