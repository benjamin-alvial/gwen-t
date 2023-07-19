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
  /** Changes the state from UserPlaysOne to ComputerPlaysUnlimited,
   * if the user player passes their turn. */
  override def user_pass(): Unit = this.changeState(new ComputerPlaysUnlimited())
  /** Changes the state from UserPlaysOne to ComputerPlaysOne,
   * if the user player plays a card. */
  override def play_one_user(): Unit = this.changeState(new ComputerPlaysOne())
  
  /** Returns always true for this class. */
  override def isUserPlaysOne = true

}
