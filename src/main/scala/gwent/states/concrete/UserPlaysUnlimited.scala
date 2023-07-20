package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

/**
 * State where user can play an unlimited amount of cards before passing their turn.
 * What is done is determined by the user's input.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class UserPlaysUnlimited extends State {
  /** Changes the state from UserPlaysUnlimited to EndRound,
   * if the user player plays a card. */
  override def play_one_user(): Unit = {}

  /** Changes the state from UserPlaysUnlimited,
   * to EndRound if the player passes their turn. */
  override def end_round(): Unit = this.changeState(new EndRound())
  
  /** Returns always true for this class. */
  override def isUserPlaysUnlimited = true

}
