package gildedrose

abstract class DegradeableItem(name: String, sellIn: Int, quality: Int) extends Degradeable[Item] {
  protected def qualityMin = 0
  protected def qualityMax = 50

  assert(quality <= qualityMax, s"Quality cannot be more than $qualityMax. Current: $quality")
  assert(quality >= qualityMin, s"Quality cannot be less than $qualityMin. Current: $sellIn")

  override def get(): Item = new Item(name, sellIn, quality)

  protected[gildedrose] def increaseQuality(inc: Int): Int = {
    val result = quality + inc
    if (result >= qualityMax) qualityMax else result
  }

  protected[gildedrose] def decreaseQuality(dec: Int): Int = {
    val result = quality - dec
    if (result <= qualityMin) qualityMin else result
  }
}
