package cl.uchile.dcc
package gwent.player.general

import gwent.card.set.CardSet

import cl.uchile.dcc.gwent.board.general.Side
import cl.uchile.dcc.gwent.card.general.Card
import cl.uchile.dcc.gwent.exceptions.{CardNotInSetException, NoMoreGemsToRemoveException, TakeFromEmptySetException}
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
 * @version 0.1.5
 */
abstract class AbstractPlayer(val name: String) extends Player with Equals {

  /** The current amount of gems, initially set as 2. */
  private var gems: Int = 2
  
  /** The CardSet of drawable cards, initially with 15 cards. 
   * As it is instantiated, it has the 25 original cards.
   * After 10 cards have been chosen for the hand, it has 15 remaining. */
  private val deck: CardSet = new CardSet(build = true)
  
  /** The CardSet of playable cards, initially with 10 cards. 
   * It is a subset of the original 25 cards. */
  private val hand: CardSet = deck.choose(10)

  /** The side of the board of the player, composed of three rows on which unit cards can be played. */
  private var side: Side = null

  /** Sets the side of the player. */
  def setSide(s: Side) = {
    side = s
  }

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

  /** Decreases the current amount of gems by one if there are still gems left. */
  def loseGem(): Unit = {

    if (getGems() == 0) throw new NoMoreGemsToRemoveException
    else setGems(getGems() - 1)
    
  }

  /** Removes a random card from deck and puts it in hand. */
  def draw(): Unit = {
    val taken = deck.take()
    hand.put(taken)
  }

  /** Returns the side of the player. */
  def getSide(): Side = side

  /** Calls for a card to play itself on the given side. */
  def play(c: Card): Unit = {
    try{
      getHand().take(c)
      c.play(side)
    }
    catch {
      case tfes: TakeFromEmptySetException => println("Card cannot be taken from empty card set.")
      case cnis: CardNotInSetException => println("Card cannot be taken from set that doesn't contain it.")
    }

  }

}
