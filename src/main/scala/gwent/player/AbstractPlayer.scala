package cl.uchile.dcc
package gwent.player

import gwent.card.CardSet

abstract class AbstractPlayer(val name: String) extends Player {
  
  //val side: Side
  private var gems: Int = 2
  private val deck: CardSet = new CardSet(build = true) // Initially with 25 cards.
  private val hand: CardSet = deck.choose(10) // Choose 10.

  def draw(): Unit = {
    val taken = deck.take()
    hand.put(taken)
  }

  def getGems(): Int = gems
  
  def loseGem(): Unit = {
    gems = gems - 1
  }

  def getDeck(): CardSet = deck

  def getHand(): CardSet = hand


  
}
