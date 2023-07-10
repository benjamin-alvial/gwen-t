package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class StartRound extends State {
  override def coin_user(): Unit = this.changeState(new UserPlaysOne())
  override def coin_computer(): Unit = this.changeState(new ComputerPlaysOne())

  override def isStartRound = true

}
