package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class EndRound extends State {
  override def one_dies() = this.changeState(new EndGame())

  override def one_still_alive() = this.changeState(new NextRound())

  override def isEndRound() = true

}
