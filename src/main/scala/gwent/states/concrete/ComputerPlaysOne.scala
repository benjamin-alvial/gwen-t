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
  override def computer_pass(): Unit = this.changeState(new UserPlaysUnlimited())
  override def play_one_computer(): Unit = this.changeState(new UserPlaysOne())
  override def isComputerPlaysOne = true

}
