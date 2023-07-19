package cl.uchile.dcc
package gwent.controller

import gwent.board.general.Board
import gwent.observer.Observer
import gwent.player.concrete.{ComputerPlayer, UserPlayer}
import gwent.states.concrete.StartGame
import gwent.states.general.State

import scala.io.StdIn.readLine

/** Represents the controller that manages the flow of the game.
 * It has a board in which the game is played and the two players of the game.
 *
 * It can be in and change between different states
 * It observes the players for the moment one of them loses gems.
 *
 * @constructor Creates a new controller with the specified name.
 *
 * @example
 * {{{
 * val controller = new GameController()
 * }}}
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class GameController extends Observer {
  /** The board of the game. */
  private var board: Board = null
  /** The user player of the game. */
  private var user: UserPlayer = null
  /** The computer player of the game. */
  private var cpu: ComputerPlayer = null
  /** The current state of the game, initially in StartGame. */
  private var state: State = new StartGame()
  state.setGameController(this)

  /** Sets the board of the game. */
  def setBoard(b: Board): Unit = {
    board = b
  }

  /** Sets the user player of the game. */
  def setUserPlayer(p: UserPlayer): Unit = {
    user = p
  }

  /** Sets the computer player of the game. */
  def setComputerPlayer(p: ComputerPlayer): Unit = {
    cpu = p
  }

  /** When the controller is notified when a player loses a gem,
   * it updates its state to end the game if one has lost all their gems. */
  def update(): Unit = {
    // User loses and CPU wins
    if ((user.getGems == 0) && (cpu.getGems > 0)) {
      one_dies()
    }
    // CPU loses and User wins
    if ((cpu.getGems == 0) && (user.getGems > 0)) {
      one_dies()
    }

    // Both CPU and User lose
    if ((user.getGems == 0) && (cpu.getGems == 0)) {
      one_dies()
    }
  }

  /** Sets the controller's state to the given state.
   * @param aState An instance of the desired state. */
  def setState(aState: State): Unit = {
    state = aState
    state.setGameController(this)
  }

  /** Changes the state from StartGame to StartRound,
   * receiving the input of the player's name, creating the board and its players
   * and shuffling their decks. */
  def input_name(): Unit = {
    //val input = readLine("insert name> ")
    val input = "Kermit"

    val b = new Board()

    val USR = new UserPlayer(input)
    val CPU = new ComputerPlayer("Computer")

    USR.setSide(b.getUserSide)
    CPU.setSide(b.getComputerSide)
    state.input_name()
  }
  /** Changes the state from StartRound to UserPlaysOne,
   * if the thrown coin lands on user. */
  def coin_user(): Unit = state.coin_user()
  /** Changes the state from StartRound to ComputerPlaysOne,
   * if the thrown coin lands on computer. */
  def coin_computer(): Unit = state.coin_computer()
  /** Changes the state from UserPlaysOne to ComputerPlaysUnlimited,
   * if the user player passes their turn. */
  def user_pass(): Unit = state.user_pass()
  /** Changes the state from ComputerPlaysOne to UserPlaysUnlimited,
   * if the computer player passes their turn. */
  def computer_pass(): Unit = state.computer_pass()
  /** Changes the state from ComputerPlaysOne to UserPlaysOne,
   * if the computer player plays a card. */
  def play_one_computer(): Unit = state.play_one_computer()
  /** Changes the state from UserPlaysOne to ComputerPlaysOne,
   * if the user player plays a card. */
  def play_one_user(): Unit = state.play_one_user()
  /** Changes the state from ComputerPlaysUnlimited or UserPlaysUnlimited,
   * to EndRound if the player passes their turn. */
  def end_round(): Unit = state.end_round()
  /** Changes the state from EndRound to NextRound,
   * if both players still have gems left. */
  def one_still_alive(): Unit = state.one_still_alive()
  /** Changes the state from NextRound to UserPlaysOne,
   * if the user had more power in previous round. */
  def continue_user(): Unit = state.continue_user()
  /** Changes the state from NextRound to ComputerPlaysOne,
   * if the computer had more power in previous round. */
  def continue_computer(): Unit = state.continue_computer()
  /** Changes the state from EndRound to EndGame,
   * if one of the players loses all their gems. */
  def one_dies(): Unit = state.one_dies()

  /** Returns true if the current state is StartGame. */
  def isStartGame: Boolean = state.isStartGame
  /** Returns true if the current state is EndGame. */
  def isEndGame: Boolean = state.isEndGame
  /** Returns true if the current state is StartRound. */
  def isStartRound: Boolean = state.isStartRound
  /** Returns true if the current state is EndRound. */
  def isEndRound: Boolean = state.isEndRound
  /** Returns true if the current state is NextRound. */
  def isNextRound: Boolean = state.isNextRound
  /** Returns true if the current state is UserPlaysOne. */
  def isUserPlaysOne: Boolean = state.isUserPlaysOne
  /** Returns true if the current state is ComputerPlaysOne. */
  def isComputerPlaysOne: Boolean = state.isComputerPlaysOne
  /** Returns true if the current state is UserPlaysUnlimited. */
  def isUserPlaysUnlimited: Boolean = state.isUserPlaysUnlimited
  /** Returns true if the current state is ComputerPlaysUnlimited. */
  def isComputerPlaysUnlimited: Boolean = state.isComputerPlaysUnlimited

}
