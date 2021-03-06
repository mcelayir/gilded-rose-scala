package gildedrose

case class ConjuredItem (name: String, sellIn: Int, quality: Int)
  extends DegradeableItem(name, sellIn, quality) {

  override def degrade(): Degradeable[Item] = {
    val degradedSellIn = sellIn - 1
    val degradedQuality = if(degradedSellIn <= 0) {
      decreaseQuality(4)
    } else {
      decreaseQuality(2)
    }
    copy(sellIn = degradedSellIn, quality = degradedQuality)
  }
}
