package gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest  extends AnyFlatSpec with Matchers {
  it should "updateQuality" in {
    val items = Array[Item](new Item("foo", 0, 2))
    val app = new GildedRose(items, ItemConverter)
    app.updateQuality()
    app.items(0).name should equal ("foo")
    app.items(0).sellIn should equal (-1)
    app.items(0).quality should equal (0)
  }

  it should "updateQuality2" in {
    val items = Array[Item](new Item("foo", 0, 2))
    val app = new GildedRose(items, ItemConverter).updateQuality2()
    app.items(0).name should equal ("foo")
    app.items(0).sellIn should equal (-1)
    app.items(0).quality should equal (0)
  }

  it should "run same for both versions" in {
    def items = Array[Item](
      new Item("+5 Dexterity Vest", 10, 20),
      new Item("Aged Brie", 2, 0),
      new Item("Elixir of the Mongoose", 5, 7),
      new Item("Sulfuras, Hand of Ragnaros", 0, 80),
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
      new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", 3, 6)
    )

    val app = new GildedRose(items.map(identity), ItemConverter)
    var app2 = new GildedRose(items.map(identity), ItemConverter)
    //app2 = app2.updateQuality2()

    for (i <- 0 until 30) {
      app.updateQuality()
      app2 = app2.updateQuality2()
    }

    app.items.map(i => (i.name, i.sellIn, i.quality)) should contain theSameElementsAs  app2.items.map(i => (i.name, i.sellIn, i.quality))
  }
}
