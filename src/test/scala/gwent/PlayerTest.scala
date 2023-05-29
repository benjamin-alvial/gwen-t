package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.card.set.CardSet
import cl.uchile.dcc.gwent.card.unit.{CloseUnitCard, RangedUnitCard, SiegeUnitCard}
import cl.uchile.dcc.gwent.card.weather.WeatherCard
import cl.uchile.dcc.gwent.exceptions.NoMoreGemsToRemoveException
import munit.FunSuite
import cl.uchile.dcc.gwent.player.concrete.{ComputerPlayer, UserPlayer}

import scala.collection.mutable.ListBuffer

/** Tests methods related to Players. */
class PlayerTest extends FunSuite {
  
  var USR: UserPlayer = null
  var CPU: ComputerPlayer = null

  override def beforeEach(context: BeforeEach): Unit = {
    USR = new UserPlayer("Kermit")
    CPU = new ComputerPlayer("Computer")
  }

  test("Player must have a name.") {
    assertEquals(USR.name, "Kermit")
    assertEquals(CPU.name, "Computer")
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
    intercept[NoMoreGemsToRemoveException] {
      USR.loseGem()
    }
    assertEquals(USR.getGems(), 0)
    assertEquals(CPU.getGems(), 2)
  }

  test("Player's deck and hand amount must begin correctly and remain consistent to draws and plays.") {
    assertEquals(USR.getDeck().getAmount(), 15)
    assertEquals(USR.getHand().getAmount(), 10)
    USR.strategy()
    assertEquals(USR.getDeck().getAmount(), 15)
    assertEquals(USR.getHand().getAmount(), 9)
    USR.draw()
    assertEquals(USR.getDeck().getAmount(), 14)
    assertEquals(USR.getHand().getAmount(), 10)

    assertEquals(CPU.getDeck().getAmount(), 15)
    assertEquals(CPU.getHand().getAmount(), 10)
    CPU.strategy()
    assertEquals(CPU.getDeck().getAmount(), 15)
    assertEquals(CPU.getHand().getAmount(), 9)
    CPU.draw()
    assertEquals(CPU.getDeck().getAmount(), 14)
    assertEquals(CPU.getHand().getAmount(), 10)
    // Future: once strategy is implemented, verify cards are actually removed from sets.
  }

  test("Two players with the same name are equal.") {
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
