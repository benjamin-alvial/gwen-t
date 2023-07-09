package cl.uchile.dcc
package gwent

import gwent.states.general.GameController

import cl.uchile.dcc.gwent.board.general.{Board, Side}
import cl.uchile.dcc.gwent.exceptions.NoMoreGemsToRemoveException
import cl.uchile.dcc.gwent.player.concrete.{ComputerPlayer, UserPlayer}
import munit.FunSuite

/** Tests methods related to notifying when gems run out. */
class GemTest extends FunSuite {
  var controller: GameController = null

  var b: Board = null
  var s1: Side = null
  var s2: Side = null
  var USR: UserPlayer = null
  var CPU: ComputerPlayer = null

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()
    controller.input_name()
    controller.coin_user()
    controller.user_pass()
    controller.end_round()

    b = new Board()
    s1 = new Side(b)
    s2 = new Side(b)

    USR = new UserPlayer("Kermit")
    CPU = new ComputerPlayer("Computer")

    USR.setSide(s1)
    CPU.setSide(s2)

    USR.registerObserver(controller)
    CPU.registerObserver(controller)

    controller.setBoard(b)
    controller.setUserPlayer(USR)
    controller.setComputerPlayer(CPU)
  }

  test("If User runs out of gems, the controller must change to EndGame state.") {
    assertEquals(USR.getGems(), 2)
    assert(!controller.isEndGame())
    USR.loseGem()
    assertEquals(USR.getGems(), 1)
    assert(!controller.isEndGame())
    USR.loseGem()
    assertEquals(USR.getGems(), 0)
    assert(controller.isEndGame())
  }

  test("If Computer runs out of gems, the controller must change to EndGame state.") {
    assertEquals(CPU.getGems(), 2)
    assert(!controller.isEndGame())
    CPU.loseGem()
    assertEquals(CPU.getGems(), 1)
    assert(!controller.isEndGame())
    CPU.loseGem()
    assertEquals(CPU.getGems(), 0)
    assert(controller.isEndGame())
  }

  test("If User and Computer run out of gems, the controller must change to EndGame state.") {
    assertEquals(USR.getGems(), 2)
    assertEquals(CPU.getGems(), 2)
    assert(!controller.isEndGame())

    USR.loseGem()
    CPU.loseGem()

    assertEquals(USR.getGems(), 1)
    assertEquals(CPU.getGems(), 1)
    assert(!controller.isEndGame())

    USR.loseGem()
    CPU.loseGem()

    assertEquals(USR.getGems(), 0)
    assertEquals(CPU.getGems(), 0)
    assert(controller.isEndGame())
  }

}