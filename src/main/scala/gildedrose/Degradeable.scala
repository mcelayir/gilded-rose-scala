package gildedrose

trait Degradeable[+T] {

  def get(): T

  def degrade(): Degradeable[T]
}
