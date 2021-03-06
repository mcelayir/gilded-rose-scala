package gildedrose

case class LegendaryItem (name: String, sellIn: Int, quality: Int)
  extends DegradeableItem(name, sellIn, quality) {

  override def qualityMax = 80

  override def degrade(): Degradeable[Item] = this.copy()
}
