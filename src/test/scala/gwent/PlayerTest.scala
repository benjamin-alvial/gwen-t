package cl.uchile.dcc
package gwent

import munit.FunSuite
import cl.uchile.dcc.gwent.ComputerPlayer
import cl.uchile.dcc.gwent.UserPlayer

class PlayerTest extends FunSuite {

  override def beforeEach(context: BeforeEach): Unit = {
    val USR = new UserPlayer("Kermit")
    val CPU = new ComputerPlayer("Computer")
  }

  test("Player must have a name.") {
    assertEquals(USR.name, expected = "Kermit")
    assertEquals(CPU.name, expected = "Computer")
  }

  test("Player's gem_counter must start at 2 and decrease in 1 when a gem is lost.") {
    assertEquals(USR.gem_counter, expected = 2)
    assertEquals(CPU.gem_counter, expected = 2)
    USR.lose_gem()
    assertEquals(USR.gem_counter, expected = 1)
    assertEquals(CPU.gem_counter, expected = 2)
  }

  test("Player's deck and hand amount must remain consistent to draws and plays.") {
    assertEquals(USR.deck.amount, expected = 15)
    assertEquals(USR.hand.amount, expected = 10)
    USR.draw_card()
    assertEquals(USR.deck.amount, expected = 15)
    assertEquals(USR.hand.amount, expected = 10)
    USR.play_card()
    assertEquals(USR.deck.amount, expected = 15)
    assertEquals(USR.hand.amount, expected = 9)
    USR.draw_card()
    assertEquals(USR.deck.amount, expected = 14)
    assertEquals(USR.hand.amount, expected = 10)
  }




}
