package gildedrose


import scala.util.matching.Regex



object ItemConverter extends (Item => Degradeable[Item]){

  private val briePattern: Regex = "(Aged Brie)".r
  private val sulphurPattern: Regex = "(Sulfuras.*)".r
  private val backstagePassPattern: Regex = "(Backstage passes.*)".r
  private val conjuredPattern: Regex = "(Conjured.*)".r

  def apply(item: Item): Degradeable[Item] = item.name match {
    case briePattern(item.name) => InvertedItem(item.name, item.sellIn, item.quality)
    case sulphurPattern(item.name) => LegendaryItem(item.name, item.sellIn, item.quality)
    case backstagePassPattern(item.name) => BackstagePassItem(item.name, item.sellIn, item.quality)
    case conjuredPattern(item.name) => ConjuredItem(item.name, item.sellIn, item.quality)
    case _ => NormalItem(item.name, item.sellIn, item.quality)
  }

}
