package cl.uchile.dcc
package gwent.player.general

import gwent.card.set.CardSet

import cl.uchile.dcc.gwent.player.concrete.{ComputerPlayer, UserPlayer}

/** Represents a player of the game.
 *
 * The player can be a [[UserPlayer]] or [[ComputerPlayer]].
 *
 * @param name The name of the player.
 *
 * @constructor Creates a new player with the specified name.
 *              
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
abstract class AbstractPlayer(val name: String) extends Player with Equals {

  /** The current amount of gems. */
  private var gems: Int = 2
  /** The CardSet of drawable cards, initially with 15 cards. */
  private val deck: CardSet = new CardSet(build = true)
  /** The CardSet of playable cards, initially with 10 cards. */
  private val hand: CardSet = deck.choose(10)


  /** Returns the amount of gems left. */
  def getGems(): Int = gems

  /** Sets the current amount of gems to the given value. */
  private def setGems(x: Int): Unit = {
    gems = x
  }

  /** Returns the CardSet of drawable cards. */
  def getDeck(): CardSet = deck

  /** Returns the CardSet of playable cards. */
  def getHand(): CardSet = hand

  /** Decreases the amount of gems by one. */
  def loseGem(): Unit = {
    setGems(getGems() - 1)
  }

  /** Removes a random card from deck and puts it in hand. */
  def draw(): Unit = {
    val taken = deck.take()
    hand.put(taken)
  }

}
