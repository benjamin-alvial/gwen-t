package cl.uchile.dcc
package gwent.player.general

import gwent.player.general.AbstractPlayer

import cl.uchile.dcc.gwent.card.general.Card

/** 
 * Interface used for [[AbstractPlayer]], which can play and draw cards. 
 * 
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.1
 */
trait Player {
  /** Carries out the player's strategy. */
  def strategy(): Unit
  /** Plays a card on the board. */
  def play(x: Card): Unit
  /** Draws a card from the deck. */
  def draw(): Unit
}
