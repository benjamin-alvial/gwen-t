package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class EndGame extends State {

  override def isEndGame() = true

  override def one_dies() = this.changeState(new EndGame())

}
