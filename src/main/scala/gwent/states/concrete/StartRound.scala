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
  /** Changes the state from StartRound to UserPlaysOne,
   * if the thrown coin lands on user. */
  override def coin_user(): Unit = this.changeState(new UserPlaysOne())

  /** Changes the state from StartRound to ComputerPlaysOne,
   * if the thrown coin lands on computer. */
  override def coin_computer(): Unit = this.changeState(new ComputerPlaysOne())
  
  /** Returns always true for this class. */
  override def isStartRound = true

}
