package cl.uchile.dcc
package gwent.player

/** 
 * Interface used for [[cl.uchile.dcc.gwent.player.AbstractPlayer]], which can play and draw cards. 
 * 
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait Player {
  /** Carries out the player's strategy. */
  def play(): Unit
  /** Draws a card from the deck. */
  def draw(): Unit
}
