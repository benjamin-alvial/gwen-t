package cl.uchile.dcc
package gwent

import gwent.controller.GameController

import munit.FunSuite

/** Tests methods related to states and their transitions. */
class StateTest extends FunSuite {

  var controller: GameController = null
  var controller_user_starts: GameController = null
  var controller_computer_starts: GameController = null
  var controller_round_ended: GameController = null

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()

    controller_user_starts = new GameController()
    controller_user_starts.input_name()
    controller_user_starts.coin_user()

    controller_computer_starts = new GameController()
    controller_computer_starts.input_name()
    controller_computer_starts.coin_computer()

    controller_round_ended = new GameController()
    controller_round_ended.input_name()
    controller_round_ended.coin_user()
    controller_round_ended.user_pass()
    controller_round_ended.end_round()
  }

  test("The initial state is StartGame and transitions to StartRound once input name is given.") {
    assert(controller.isStartGame)
    assert(!controller.isEndGame)
    assert(!controller.isStartRound)
    assert(!controller.isEndRound)
    assert(!controller.isNextRound)
    assert(!controller.isUserPlaysOne)
    assert(!controller.isComputerPlaysOne)
    assert(!controller.isUserPlaysUnlimited)
    assert(!controller.isComputerPlaysUnlimited)

    controller.input_name()

    assert(!controller.isStartGame)
    assert(!controller.isEndGame)
    assert(controller.isStartRound)
    assert(!controller.isEndRound)
    assert(!controller.isNextRound)
    assert(!controller.isUserPlaysOne)
    assert(!controller.isComputerPlaysOne)
    assert(!controller.isUserPlaysUnlimited)
    assert(!controller.isComputerPlaysUnlimited)
  }

  test("Game transitions are valid if User starts playing.") {

    assert(!controller_user_starts.isStartGame)
    assert(!controller_user_starts.isEndGame)
    assert(!controller_user_starts.isStartRound)
    assert(!controller_user_starts.isEndRound)
    assert(!controller_user_starts.isNextRound)
    assert(controller_user_starts.isUserPlaysOne)
    assert(!controller_user_starts.isComputerPlaysOne)
    assert(!controller_user_starts.isUserPlaysUnlimited)
    assert(!controller_user_starts.isComputerPlaysUnlimited)

    controller_user_starts.user_pass()

    assert(!controller_user_starts.isStartGame)
    assert(!controller_user_starts.isEndGame)
    assert(!controller_user_starts.isStartRound)
    assert(!controller_user_starts.isEndRound)
    assert(!controller_user_starts.isNextRound)
    assert(!controller_user_starts.isUserPlaysOne)
    assert(!controller_user_starts.isComputerPlaysOne)
    assert(!controller_user_starts.isUserPlaysUnlimited)
    assert(controller_user_starts.isComputerPlaysUnlimited)

    controller_user_starts.play_one_computer()
    controller_user_starts.play_one_computer()
    controller_user_starts.play_one_computer()

    assert(!controller_user_starts.isStartGame)
    assert(!controller_user_starts.isEndGame)
    assert(!controller_user_starts.isStartRound)
    assert(!controller_user_starts.isEndRound)
    assert(!controller_user_starts.isNextRound)
    assert(!controller_user_starts.isUserPlaysOne)
    assert(!controller_user_starts.isComputerPlaysOne)
    assert(!controller_user_starts.isUserPlaysUnlimited)
    assert(controller_user_starts.isComputerPlaysUnlimited)

    controller_user_starts.end_round()

    assert(!controller_user_starts.isStartGame)
    assert(!controller_user_starts.isEndGame)
    assert(!controller_user_starts.isStartRound)
    assert(controller_user_starts.isEndRound)
    assert(!controller_user_starts.isNextRound)
    assert(!controller_user_starts.isUserPlaysOne)
    assert(!controller_user_starts.isComputerPlaysOne)
    assert(!controller_user_starts.isUserPlaysUnlimited)
    assert(!controller_user_starts.isComputerPlaysUnlimited)

    controller_user_starts.one_dies()

    assert(!controller_user_starts.isStartGame)
    assert(controller_user_starts.isEndGame)
    assert(!controller_user_starts.isStartRound)
    assert(!controller_user_starts.isEndRound)
    assert(!controller_user_starts.isNextRound)
    assert(!controller_user_starts.isUserPlaysOne)
    assert(!controller_user_starts.isComputerPlaysOne)
    assert(!controller_user_starts.isUserPlaysUnlimited)
    assert(!controller_user_starts.isComputerPlaysUnlimited)
  }

  test("Game transitions are valid if Computer starts playing.") {
    assert(!controller_computer_starts.isStartGame)
    assert(!controller_computer_starts.isEndGame)
    assert(!controller_computer_starts.isStartRound)
    assert(!controller_computer_starts.isEndRound)
    assert(!controller_computer_starts.isNextRound)
    assert(!controller_computer_starts.isUserPlaysOne)
    assert(controller_computer_starts.isComputerPlaysOne)
    assert(!controller_computer_starts.isUserPlaysUnlimited)
    assert(!controller_computer_starts.isComputerPlaysUnlimited)

    controller_computer_starts.computer_pass()

    assert(!controller_computer_starts.isStartGame)
    assert(!controller_computer_starts.isEndGame)
    assert(!controller_computer_starts.isStartRound)
    assert(!controller_computer_starts.isEndRound)
    assert(!controller_computer_starts.isNextRound)
    assert(!controller_computer_starts.isUserPlaysOne)
    assert(!controller_computer_starts.isComputerPlaysOne)
    assert(controller_computer_starts.isUserPlaysUnlimited)
    assert(!controller_computer_starts.isComputerPlaysUnlimited)

    controller_computer_starts.play_one_user()
    controller_computer_starts.play_one_user()
    controller_computer_starts.play_one_user()

    assert(!controller_computer_starts.isStartGame)
    assert(!controller_computer_starts.isEndGame)
    assert(!controller_computer_starts.isStartRound)
    assert(!controller_computer_starts.isEndRound)
    assert(!controller_computer_starts.isNextRound)
    assert(!controller_computer_starts.isUserPlaysOne)
    assert(!controller_computer_starts.isComputerPlaysOne)
    assert(controller_computer_starts.isUserPlaysUnlimited)
    assert(!controller_computer_starts.isComputerPlaysUnlimited)

    controller_computer_starts.end_round()

    assert(!controller_computer_starts.isStartGame)
    assert(!controller_computer_starts.isEndGame)
    assert(!controller_computer_starts.isStartRound)
    assert(controller_computer_starts.isEndRound)
    assert(!controller_computer_starts.isNextRound)
    assert(!controller_computer_starts.isUserPlaysOne)
    assert(!controller_computer_starts.isComputerPlaysOne)
    assert(!controller_computer_starts.isUserPlaysUnlimited)
    assert(!controller_computer_starts.isComputerPlaysUnlimited)

    controller_computer_starts.one_dies()

    assert(!controller_computer_starts.isStartGame)
    assert(controller_computer_starts.isEndGame)
    assert(!controller_computer_starts.isStartRound)
    assert(!controller_computer_starts.isEndRound)
    assert(!controller_computer_starts.isNextRound)
    assert(!controller_computer_starts.isUserPlaysOne)
    assert(!controller_computer_starts.isComputerPlaysOne)
    assert(!controller_computer_starts.isUserPlaysUnlimited)
    assert(!controller_computer_starts.isComputerPlaysUnlimited)
  }

  test("Transitions are valid if players play cards alternately.") {
    controller_user_starts.play_one_user()
    assert(!controller_user_starts.isStartGame)
    assert(!controller_user_starts.isEndGame)
    assert(!controller_user_starts.isStartRound)
    assert(!controller_user_starts.isEndRound)
    assert(!controller_user_starts.isNextRound)
    assert(!controller_user_starts.isUserPlaysOne)
    assert(controller_user_starts.isComputerPlaysOne)
    assert(!controller_user_starts.isUserPlaysUnlimited)
    assert(!controller_user_starts.isComputerPlaysUnlimited)

    controller_user_starts.play_one_computer()
    assert(!controller_user_starts.isStartGame)
    assert(!controller_user_starts.isEndGame)
    assert(!controller_user_starts.isStartRound)
    assert(!controller_user_starts.isEndRound)
    assert(!controller_user_starts.isNextRound)
    assert(controller_user_starts.isUserPlaysOne)
    assert(!controller_user_starts.isComputerPlaysOne)
    assert(!controller_user_starts.isUserPlaysUnlimited)
    assert(!controller_user_starts.isComputerPlaysUnlimited)

    controller_user_starts.play_one_user()
    assert(!controller_user_starts.isStartGame)
    assert(!controller_user_starts.isEndGame)
    assert(!controller_user_starts.isStartRound)
    assert(!controller_user_starts.isEndRound)
    assert(!controller_user_starts.isNextRound)
    assert(!controller_user_starts.isUserPlaysOne)
    assert(controller_user_starts.isComputerPlaysOne)
    assert(!controller_user_starts.isUserPlaysUnlimited)
    assert(!controller_user_starts.isComputerPlaysUnlimited)
  }

  test("Transitions are valid for another round if User won last round.") {
    controller_round_ended.one_still_alive()

    assert(!controller_round_ended.isStartGame)
    assert(!controller_round_ended.isEndGame)
    assert(!controller_round_ended.isStartRound)
    assert(!controller_round_ended.isEndRound)
    assert(controller_round_ended.isNextRound)
    assert(!controller_round_ended.isUserPlaysOne)
    assert(!controller_round_ended.isComputerPlaysOne)
    assert(!controller_round_ended.isUserPlaysUnlimited)
    assert(!controller_round_ended.isComputerPlaysUnlimited)

    controller_round_ended.continue_user()

    assert(!controller_round_ended.isStartGame)
    assert(!controller_round_ended.isEndGame)
    assert(!controller_round_ended.isStartRound)
    assert(!controller_round_ended.isEndRound)
    assert(!controller_round_ended.isNextRound)
    assert(controller_round_ended.isUserPlaysOne)
    assert(!controller_round_ended.isComputerPlaysOne)
    assert(!controller_round_ended.isUserPlaysUnlimited)
    assert(!controller_round_ended.isComputerPlaysUnlimited)
  }

  test("Transitions are valid for another round if Computer won last round.") {
    controller_round_ended.one_still_alive()

    assert(!controller_round_ended.isStartGame)
    assert(!controller_round_ended.isEndGame)
    assert(!controller_round_ended.isStartRound)
    assert(!controller_round_ended.isEndRound)
    assert(controller_round_ended.isNextRound)
    assert(!controller_round_ended.isUserPlaysOne)
    assert(!controller_round_ended.isComputerPlaysOne)
    assert(!controller_round_ended.isUserPlaysUnlimited)
    assert(!controller_round_ended.isComputerPlaysUnlimited)

    controller_round_ended.continue_computer()

    assert(!controller_round_ended.isStartGame)
    assert(!controller_round_ended.isEndGame)
    assert(!controller_round_ended.isStartRound)
    assert(!controller_round_ended.isEndRound)
    assert(!controller_round_ended.isNextRound)
    assert(!controller_round_ended.isUserPlaysOne)
    assert(controller_round_ended.isComputerPlaysOne)
    assert(!controller_round_ended.isUserPlaysUnlimited)
    assert(!controller_round_ended.isComputerPlaysUnlimited)
  }

}
