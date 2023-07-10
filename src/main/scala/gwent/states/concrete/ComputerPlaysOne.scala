package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class ComputerPlaysOne extends State {
  override def computer_pass(): Unit = this.changeState(new UserPlaysUnlimited())
  override def play_one_computer(): Unit = this.changeState(new UserPlaysOne())

  override def isComputerPlaysOne = true

}
