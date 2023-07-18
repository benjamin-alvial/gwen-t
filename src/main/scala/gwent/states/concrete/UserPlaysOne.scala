package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where user has to play one card or pass their turn.
 * What is done is determined by the user's input.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class UserPlaysOne extends State {
  override def user_pass(): Unit = this.changeState(new ComputerPlaysUnlimited())
  override def play_one_user(): Unit = this.changeState(new ComputerPlaysOne())

  override def isUserPlaysOne = true

}
