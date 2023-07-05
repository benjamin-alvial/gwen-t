package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class NextRound extends State {
  
  override def continue_user() = this.changeState(new UserPlaysOne())

  override def continue_computer() = this.changeState(new ComputerPlaysOne())

  override def isNextRound() = true

}
