package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class StartGame extends State {
  override def input_name(): Unit = this.changeState(new StartRound())
  
  override def isStartGame = true
  
}
