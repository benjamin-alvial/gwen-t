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
  def play(): Unit
  def draw(): Unit
}
