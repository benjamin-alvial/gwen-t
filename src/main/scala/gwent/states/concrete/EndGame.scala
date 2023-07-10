package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class EndGame extends State {
  override def one_dies(): Unit = this.changeState(new EndGame())

  override def isEndGame = true

}
