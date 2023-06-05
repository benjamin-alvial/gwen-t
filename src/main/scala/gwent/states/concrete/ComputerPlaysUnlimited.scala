package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class ComputerPlaysUnlimited extends State {
  override def play_one_computer() = {}
  override def end_round() = this.changeState(new EndRound())

  override def isComputerPlaysUnlimited() = true

}
