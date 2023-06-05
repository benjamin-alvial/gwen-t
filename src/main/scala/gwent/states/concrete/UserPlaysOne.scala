package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class UserPlaysOne extends State {

  override def user_pass() = this.changeState(new ComputerPlaysUnlimited())

  override def isUserPlaysOne() = true

}
