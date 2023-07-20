package cl.uchile.dcc
package gwent.player.general

import gwent.player.general.AbstractPlayer
import gwent.card.general.Card

/** 
 * Interface used for [[AbstractPlayer]], which can play and draw cards. 
 * 
 * A player can have a strategy, which determines which card they choose to play on the board.
 * Concretely, a player can play cards one of their cards on the board and draw a new card.
 * 
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.3
 */
trait Player {
  /** Carries out the player's strategy or way of choosing a card to play. 
   * This method calls should at some point call on the method play with a chosen card.*/
  def strategy(): Unit
  
  /** Plays a card on the board. 
   * This method delegates the responsibility of playing a card to the card itself.*/
  def play(x: Card): Unit
  
  /** Draws a card from the deck, adding it to its hand. */
  def draw(): Card
}
