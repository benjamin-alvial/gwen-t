package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where a round has ended and a gem is removed from one or both players.
 * Depending on whether a player has gems left, a new round begins or not.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class EndRound extends State {
  override def one_dies(): Unit = this.changeState(new EndGame())
  override def one_still_alive(): Unit = this.changeState(new NextRound())

  override def isEndRound = true

}
