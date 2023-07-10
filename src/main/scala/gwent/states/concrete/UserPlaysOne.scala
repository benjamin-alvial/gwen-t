package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class UserPlaysOne extends State {
  override def user_pass(): Unit = this.changeState(new ComputerPlaysUnlimited())
  override def play_one_user(): Unit = this.changeState(new ComputerPlaysOne())

  override def isUserPlaysOne = true

}
