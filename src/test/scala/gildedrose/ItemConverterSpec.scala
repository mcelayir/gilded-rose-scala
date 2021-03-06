package gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ItemConverterSpec extends AnyFlatSpec with Matchers {
  it should "convert aged brie to InvertedItem  " in {
    ItemConverter(new Item("Aged Brie", 2, 0)) shouldBe InvertedItem("Aged Brie", 2, 0)
  }

  it should "convert sulphuras to LegendaryItem  " in {
    ItemConverter(new Item("Sulfuras, Hand of Ragnaros", 0, 80)) shouldBe LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80)
    ItemConverter(new Item("Sulfuras, Hand of Ragnaros", -1, 80)) shouldBe LegendaryItem("Sulfuras, Hand of Ragnaros", -1, 80)
  }

  it should "convert backstage pass to BackstagePassItem  " in {
    ItemConverter( new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)) shouldBe BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20)
  }

  it should "convert conjured to ConjuredItem  " in {
    ItemConverter(new Item("Conjured Mana Cake", 3, 6)) shouldBe ConjuredItem("Conjured Mana Cake", 3, 6)
  }

}
