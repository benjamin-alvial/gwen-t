package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where controller is waiting for the player's name as input.
 * With this name, the user player can be initialized and the game can start.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class StartGame extends State {
  override def input_name(): Unit = this.changeState(new StartRound())

  override def isStartGame = true
  
}
