package gildedrose

case class NormalItem(name: String, sellIn: Int, quality: Int)
  extends DegradeableItem(name, sellIn, quality) {

  override def degrade(): Degradeable[Item] = {
    val degradedSellIn = sellIn - 1
    val degradedQuality = if(degradedSellIn <= 0) {
      decreaseQuality(2)
    } else {
      decreaseQuality(1)
    }
    copy(sellIn = degradedSellIn, quality = degradedQuality)
  }
}
