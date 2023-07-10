package cl.uchile.dcc
package gwent.states.general

import gwent.controller.GameController

class State() {

  private var gc: Option[GameController] = None
  
  def setGameController(gc: GameController): Unit = {
    this.gc = Some(gc)
  }
  
  protected def changeState(state: State) : Unit = {
    if(gc.isDefined)
      gc.get.setState(state)
  }
  
  private def error() = throw new AssertionError("Wrong State")

  def input_name(): Unit = error()
  def coin_user(): Unit = error()
  def coin_computer(): Unit = error()
  def user_pass(): Unit = error()
  def computer_pass(): Unit = error()
  def play_one_computer(): Unit = error()
  def play_one_user(): Unit = error()
  def end_round(): Unit = error()
  def one_still_alive(): Unit = error()
  def continue_user(): Unit = error()
  def continue_computer(): Unit = error()
  def one_dies(): Unit = error()

  def isStartGame: Boolean = false
  def isEndGame: Boolean = false
  def isStartRound: Boolean = false
  def isEndRound: Boolean = false
  def isNextRound: Boolean = false
  def isUserPlaysOne: Boolean = false
  def isComputerPlaysOne: Boolean = false
  def isUserPlaysUnlimited: Boolean = false
  def isComputerPlaysUnlimited: Boolean = false
  
}
