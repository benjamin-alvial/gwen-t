package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where controller throws a coin to choose which player to start.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class StartRound extends State {
  override def coin_user(): Unit = this.changeState(new UserPlaysOne())
  override def coin_computer(): Unit = this.changeState(new ComputerPlaysOne())

  override def isStartRound = true

}
