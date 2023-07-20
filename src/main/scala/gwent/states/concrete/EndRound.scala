package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where a round has ended and a gem is removed from one or both players.
 * Depending on whether a player has gems left, a new round begins or not.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class EndRound extends State {
  /** Changes the state from EndRound to EndGame,
   * if one of the players loses all their gems. */
  override def one_dies(): Unit = this.changeState(new EndGame())

  /** Changes the state from EndRound to NextRound,
   * if both players still have gems left. */
  override def one_still_alive(): Unit = this.changeState(new NextRound())
  
  /** Returns always true for this class. */
  override def isEndRound = true

}
