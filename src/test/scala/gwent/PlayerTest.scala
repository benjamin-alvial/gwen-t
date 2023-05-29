package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.board.general.{Board, Side}
import cl.uchile.dcc.gwent.card.general.Card
import cl.uchile.dcc.gwent.player.concrete.{ComputerPlayer, UserPlayer}
import cl.uchile.dcc.gwent.exceptions.NoMoreGemsToRemoveException
import munit.FunSuite

/** Tests methods related to Players. */
class PlayerTest extends FunSuite {
  
  var USR: UserPlayer = null
  var CPU: ComputerPlayer = null

  override def beforeEach(context: BeforeEach): Unit = {
    USR = new UserPlayer("Kermit")
    CPU = new ComputerPlayer("Computer")
  }

  test("Player must have a name.") {
    assertEquals(USR.getName(), "Kermit")
    assertEquals(CPU.getName(), "Computer")
  }

  test("Player must have a hand and a deck.") {
    assert(false)
  }

  test("Player must have an initially null side which can be set to another side.") {
    val b = new Board()
    val s1 = new Side(b)
    assertEquals(USR.getSide(), null)
    USR.setSide(s1)
    assertEquals(USR.getSide(), s1)
  }

  test("Player's gems must start at 2 and decrease in 1 when a gem is lost, if there are still any left.") {
    assertEquals(USR.getGems(), 2)
    assertEquals(CPU.getGems(), 2)
    USR.loseGem()
    assertEquals(USR.getGems(), 1)
    assertEquals(CPU.getGems(), 2)
    USR.loseGem()
    assertEquals(USR.getGems(), 0)
    assertEquals(CPU.getGems(), 2)
    // USR has no more gems left.
    intercept[NoMoreGemsToRemoveException] {
      USR.loseGem()
    }
    // Amount remains the same and gem counter can't be negative.
    assertEquals(USR.getGems(), 0)
    assertEquals(CPU.getGems(), 2)
  }

  test("Player's deck and hand amount must begin correctly and remain consistent to draws and plays.") {
    val b = new Board()
    val s1 = new Side(b)
    val s2 = new Side(b)
    USR.setSide(s1)
    CPU.setSide(s2)

    assertEquals(USR.getDeck().getAmount(), 15)
    assertEquals(USR.getHand().getAmount(), 10)
    assertEquals(CPU.getDeck().getAmount(), 15)
    assertEquals(CPU.getHand().getAmount(), 10)

    // Test strategy that first card in hand is played, by User.
    val x1: Card = USR.getHand().getList()(0)
    val x1_occurrences: Int = USR.getHand().occurrences(x1)

    USR.play(x1)
    assertEquals(USR.getDeck().getAmount(), 15)
    assertEquals(USR.getHand().getAmount(), 9)
    assertEquals(USR.getHand().occurrences(x1), x1_occurrences-1)

    // Test that first card in deck is drawn, by User.
    val x2: Card = USR.getDeck().getList()(0)
    val x2_occurrences: Int = USR.getHand().occurrences(x2)

    USR.draw()
    assertEquals(USR.getDeck().getAmount(), 14)
    assertEquals(USR.getHand().getAmount(), 10)
    assertEquals(USR.getDeck().occurrences(x2), x2_occurrences-1)

    // Test strategy that first card in hand is played, by Computer.
    val y1: Card = CPU.getHand().getList()(0)
    val y1_occurrences: Int = CPU.getHand().occurrences(y1)

    CPU.play(y1)
    assertEquals(CPU.getDeck().getAmount(), 15)
    assertEquals(CPU.getHand().getAmount(), 9)
    assertEquals(CPU.getHand().occurrences(y1), y1_occurrences-1)

    // Test that first card in deck is drawn, by User.
    val y2: Card = CPU.getDeck().getList()(0)
    val y2_occurrences: Int = CPU.getHand().occurrences(y2)

    CPU.draw()
    assertEquals(CPU.getDeck().getAmount(), 14)
    assertEquals(CPU.getHand().getAmount(), 10)
    assertEquals(CPU.getDeck().occurrences(y2), y2_occurrences - 1)
  }

  test("Two players of the same type with the same name are equal.") {
    // Player with itself.
    assertEquals(CPU, CPU)
    assertEquals(USR, USR)

    // Player with another with same name.
    val CPU2 = new ComputerPlayer("Computer")
    val CPU3 = new ComputerPlayer("Laptop")
    val USR2 = new UserPlayer("Kermit")
    val USR3 = new UserPlayer("PeppaPig")
    assertEquals(CPU, CPU2)
    assertNotEquals(CPU, CPU3)
    assertEquals(USR, USR2)
    assertNotEquals(USR, USR3)

    // Player with object of another type (String).
    val name_string_CPU: String = "Computer"
    val name_string_USR: String = "Kermit"
    assertNotEquals[Any, Any](CPU, name_string_CPU)
    assertNotEquals[Any, Any](USR, name_string_USR)

    // Players of different subclasses (UserPlayer and ComputerPlayer).
    val USR4 = new UserPlayer("Computer")
    assertNotEquals[Any, Any](CPU, USR) // Different class and different name.
    assertNotEquals[Any, Any](CPU, USR4) // Different class but same name.
  }

}
