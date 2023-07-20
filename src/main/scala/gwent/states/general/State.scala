package cl.uchile.dcc
package gwent.states.general

import gwent.controller.GameController

/**
 * Represents the state at a given moment of the game controller.
 * All transitions are undefined for this incomplete class. 
 * Each subclass overrides its possible transitions.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class State() {

  /** A reference to the game controller that has a state, initially undefined. */
  private var gc: Option[GameController] = None

  /** Sets the game controller. */
  def setGameController(gc: GameController): Unit = {
    this.gc = Some(gc)
  }

  /** Changes the controller to the given state. 
   * @param state The target state. */
  protected def changeState(state: State) : Unit = {
    if(gc.isDefined)
      gc.get.setState(state)
  }

  /** Throws an error for a transition that is not valid. */
  private def error() = throw new AssertionError("Wrong State")

  /** Any transition is invalid in the general state class. */
  def input_name(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def coin_user(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def coin_computer(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def user_pass(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def computer_pass(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def play_one_computer(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def play_one_user(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def end_round(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def one_still_alive(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def continue_user(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def continue_computer(): Unit = error()
  /** Any transition is invalid in the general state class. */
  def one_dies(): Unit = error()

  /** A general state is not any particular one. */
  def isStartGame: Boolean = false
  /** A general state is not any particular one. */
  def isEndGame: Boolean = false
  /** A general state is not any particular one. */
  def isStartRound: Boolean = false
  /** A general state is not any particular one. */
  def isEndRound: Boolean = false
  /** A general state is not any particular one. */
  def isNextRound: Boolean = false
  /** A general state is not any particular one. */
  def isUserPlaysOne: Boolean = false
  /** A general state is not any particular one. */
  def isComputerPlaysOne: Boolean = false
  /** A general state is not any particular one. */
  def isUserPlaysUnlimited: Boolean = false
  /** A general state is not any particular one. */
  def isComputerPlaysUnlimited: Boolean = false
  
}
