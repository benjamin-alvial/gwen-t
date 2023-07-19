package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where computer can play an unlimited amount of cards before passing their turn.
 * What is done is determined by the computer's automated and pre-programmed strategy.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class ComputerPlaysUnlimited extends State {
  /** Changes the state from ComputerPlaysUnlimited to EndRound,
   * if the computer player plays a card. */
  override def play_one_computer(): Unit = {}

  /** Changes the state from UserPlaysUnlimited,
   * to EndRound if the player passes their turn. */
  override def end_round(): Unit = this.changeState(new EndRound())

  /** Returns always true for this class. */
  override def isComputerPlaysUnlimited = true

}
