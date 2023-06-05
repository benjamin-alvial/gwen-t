package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class ComputerPlaysOne extends State {
  override def computer_pass() = this.changeState(new UserPlaysUnlimited())

  override def isComputerPlaysOne() = true

}
