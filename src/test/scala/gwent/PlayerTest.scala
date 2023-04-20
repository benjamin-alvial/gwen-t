package cl.uchile.dcc
package gwent

import munit.FunSuite
import cl.uchile.dcc.gwent.player.{ComputerPlayer, UserPlayer}

class PlayerTest extends FunSuite {
  
  var USR: UserPlayer = null
  var CPU: ComputerPlayer = null

  override def beforeEach(context: BeforeEach): Unit = {
    USR = new UserPlayer("Kermit")
    CPU = new ComputerPlayer("Computer")
  }

  test("Player must have a name.") {
    assertEquals(USR.name, expected = "Kermit")
    assertEquals(CPU.name, expected = "Computer")
  }

  test("Player's gems must start at 2 and decrease in 1 when a gem is lost.") {
    assertEquals(USR.getGems(), expected = 2)
    assertEquals(CPU.getGems(), expected = 2)
    USR.loseGem()
    assertEquals(USR.getGems(), expected = 1)
    assertEquals(CPU.getGems(), expected = 2)
  }

  test("Player's deck and hand amount must begin correctly and remain consistent to draws and plays.") {
    assertEquals(USR.getDeck().getAmount(), expected = 25)
    assertEquals(USR.getHand().getAmount(), expected = 10)
    USR.play()
    assertEquals(USR.getDeck().getAmount(), expected = 25)
    assertEquals(USR.getHand().getAmount(), expected = 9)
    USR.draw()
    assertEquals(USR.getDeck().getAmount(), expected = 24)
    assertEquals(USR.getHand().getAmount(), expected = 10)
  }

  test("Two players with the same name are equal.") {
    val CPU2 = new ComputerPlayer("Computer")
    val CPU3 = new ComputerPlayer("Laptop")
    assertEquals(CPU, CPU)
    assertEquals(CPU, CPU2)
    assertNotEquals(CPU, CPU3)
    assertNotEquals(CPU, CPU3)

    val name_string: String = "Computer"
    assertNotEquals[Any, Any](CPU, name_string)

  }

}
