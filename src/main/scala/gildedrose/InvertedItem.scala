package gildedrose

case class InvertedItem(name: String, sellIn: Int, quality: Int)
  extends DegradeableItem(name, sellIn, quality){

  override def degrade(): Degradeable[Item] = {
    val degradedSellIn = sellIn - 1
    val degradedQuality = if(degradedSellIn <= 0) {
      increaseQuality(2)
    } else {
      increaseQuality(1)
    }
    copy(sellIn = degradedSellIn, quality = degradedQuality)
  }
}
