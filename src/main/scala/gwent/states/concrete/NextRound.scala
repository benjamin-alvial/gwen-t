package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where a new round begins. 
 * Who begins in this new round is determined by the total sum of each player in the previous round.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class NextRound extends State {
  override def continue_user(): Unit = this.changeState(new UserPlaysOne())
  override def continue_computer(): Unit = this.changeState(new ComputerPlaysOne())

  override def isNextRound = true

}
