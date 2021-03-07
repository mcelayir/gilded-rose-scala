# gilded-rose-scala

A scala implementation for [Gilded Rose Refactoring Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata)

For definition of the problem and requirements:

https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt

Used versions:
- scala: 2.13.5
- sbt: 1.4.7
- jdk: 11 

## Implementation notes

The problems with the initial implementation

The focus of this refactoring is to create the domain model for Gilded Rose where the items and their behaviors are reflected as types and traits. Depending on the requirements, item classes are generalised based on their degrading behavior and domain classes realize this behavior on items..

### trait Degradable[+A]

Degradable trait is used to define the `degrade` behavior for given type. Domain classes extends `Degradable[Item]` to define the degrading behavior for each type.

### abstract class DegradableItem

This class extends `Degradable[Item]` and is the class where common fields like quality limits and methods like increase/decrease is abstacted. DegradableItem defines the skeleton for all item types.  

### Domain classes

Each item type is represented with a domain class. Each domain class extends `Degradable[Item]` to define degrading behavior for their given type of item. This will create separate boundaries between item types and rules can be applied directly agains types instead of complex flows of checking the type of an item by name. Also types can be tested separately within their boundaries.

- `NormalItem` -> Items degrade according to normal degrading rules , 
- `InvertedItem` -> Items whose quality increases even if the sellIn decreases, like `Aged Brie`
- `LegendaryItem` -> Items never has to be sold or decrease in quality,  like `Sulfuras`
- `BackstagePassItem` -> Backstage passes
- `ConjuredItem`-> Items degrade twice as fast as normal item

## Running the tests
TexttestsFixture.scala is copied from the original repository and updated to use the refactored version of the `updateQuality`
Also a test case created based on this test inside `GildedRoseTest` to ensure that both old and refactored version return same results.

To run the tests

```
> sbt test
```
