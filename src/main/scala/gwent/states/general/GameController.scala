package cl.uchile.dcc
package gwent.states.general

import gwent.states.general.State
import cl.uchile.dcc.gwent.states.concrete.StartGame

class GameController {

  private var state: State = new StartGame()
  state.setGameController(this)
  def setState(aState: State): Unit = {
    state = aState
    state.setGameController(this)
  }
  
  def input_name(): Unit = state.input_name()
  def coin_user(): Unit = state.coin_user()
  def coin_computer(): Unit = state.coin_computer()
  def user_pass(): Unit = state.user_pass()
  def computer_pass(): Unit = state.computer_pass()
  def play_one_computer(): Unit = state.play_one_computer()
  def play_one_user(): Unit = state.play_one_user()
  def end_round(): Unit = state.end_round()
  def one_still_alive(): Unit = state.one_still_alive()
  def continue_user(): Unit = state.continue_user()
  def continue_computer(): Unit = state.continue_computer()
  def one_dies(): Unit = state.one_dies()

  def isStartGame(): Boolean = state.isStartGame()
  def isEndGame(): Boolean = state.isEndGame()
  def isStartRound(): Boolean = state.isStartRound()
  def isEndRound(): Boolean = state.isEndRound()
  def isNextRound(): Boolean = state.isNextRound()
  def isUserPlaysOne(): Boolean = state.isUserPlaysOne()
  def isComputerPlaysOne(): Boolean = state.isComputerPlaysOne()
  def isUserPlaysUnlimited(): Boolean = state.isUserPlaysUnlimited()
  def isComputerPlaysUnlimited(): Boolean = state.isComputerPlaysUnlimited()

}