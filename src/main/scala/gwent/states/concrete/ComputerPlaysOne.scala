package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where computer has to play one card or pass their turn.
 * What is done is determined by the computer's automated and pre-programmed strategy.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class ComputerPlaysOne extends State {
  /** Changes the state from ComputerPlaysOne to UserPlaysUnlimited,
   * if the computer player passes their turn. */
  override def computer_pass(): Unit = this.changeState(new UserPlaysUnlimited())
  /** Changes the state from ComputerPlaysOne to UserPlaysOne,
   * if the computer player plays a card. */
  override def play_one_computer(): Unit = this.changeState(new UserPlaysOne())
  
  /** Returns always true for this class. */
  override def isComputerPlaysOne = true

}
