package cl.uchile.dcc
package gwent.player

import gwent.card.CardSet

abstract class AbstractPlayer(val name: String) extends Player with Equals {

  private var gems: Int = 2
  private val deck: CardSet = new CardSet(build = true) // Initially with 25 cards.
  private val hand: CardSet = deck.choose(10) // Choose 10.

  def getGems(): Int = gems

  private def setGems(x: Int): Unit = {
    gems = x
  }

  def getDeck(): CardSet = deck

  def getHand(): CardSet = hand

  def loseGem(): Unit = {
    setGems(getGems() - 1)
  }

  def draw(): Unit = {
    val taken = deck.take()
    hand.put(taken)
  }


  
}
