package cl.uchile.dcc
package gwent.player

import gwent.card.CardSet

abstract class AbstractPlayer(val name: String) extends Player {
  
  //val side: Side
  var gem_counter: Int = 2
  val deck: CardSet = new CardSet() // Initially with 25 cards.
  val hand: CardSet = deck.choose(10) // Choose 10.

  def draw(): Unit = ???
  
}
