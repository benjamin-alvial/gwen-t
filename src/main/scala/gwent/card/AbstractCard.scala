package cl.uchile.dcc
package gwent.card

abstract class AbstractCard(name: String) extends Card {

  def draw(): Unit

}
