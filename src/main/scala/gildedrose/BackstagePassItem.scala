package gildedrose

case class BackstagePassItem(name: String, sellIn: Int, quality: Int)
  extends DegradeableItem(name, sellIn, quality) {

  override def degrade(): Degradeable[Item] = {
    val degradedSellIn = sellIn - 1
    val degradedQuality = if (degradedSellIn <= 0) {
      qualityMin
    } else if (sellIn <= 5) {
      increaseQuality(3)
    } else if (sellIn <= 10) {
      increaseQuality(2)
    } else {
      decreaseQuality(1)
    }
    copy(sellIn = degradedSellIn, quality = degradedQuality)
  }


}
