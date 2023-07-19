package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where the final round ends.
 * Depending on the winner (or lack thereof), a message is displayed.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class EndGame extends State {
  /** Maintains the state in EndGame if the other player also died. */
  override def one_dies(): Unit = this.changeState(new EndGame())

  /** Returns always true for this class. */
  override def isEndGame = true

}
