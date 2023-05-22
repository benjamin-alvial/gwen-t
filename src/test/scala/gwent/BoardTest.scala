package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.player.concrete.UserPlayer
import munit.FunSuite

/** Tests methods related to a Player playing Cards on the Zones of the Board. */
class BoardTest extends FunSuite {
  
  var USR: UserPlayer = null
  var U_close_card: CloseUnitCard = null
  var U_ranged_card: RangedUnitCard = null
  var U_siege_card: SiegeUnitCard = null
  var W_card: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    USR = new UserPlayer("Kermit")
    U_close_card = new CloseUnitCard("C1", 100)
    U_ranged_card = new RangedUnitCard("R1", 100)
    U_siege_card = new SiegeUnitCard("S1", 100)
  }

  test("Close combat unit card played by Player must be removed from hand and added to close combat zone.") {
    val count_in_hand: Int = USR.getHand().occurrences(U_close_card)
    val count_in_zone: Int = USR.getSide().zone_close.cards.occurrences(U_close_card)
    USR.play(U_close_card)
    assertEquals(USR.getHand().occurrences(U_close_card), count_in_hand-1)
    assertEquals(USR.getHand().occurrences(U_close_card), count_in_zone+1)
  }

  test("Ranged unit card played by Player must be removed from hand and added to ranged zone.") {
    val count_in_hand: Int = USR.getHand().occurrences(U_ranged_card)
    val count_in_zone: Int = USR.getSide().zone_ranged.cards.occurrences(U_ranged_card)
    USR.play(U_ranged_card)
    assertEquals(USR.getHand().occurrences(U_ranged_card), count_in_hand - 1)
    assertEquals(USR.getHand().occurrences(U_ranged_card), count_in_zone + 1)
  }

  test("Siege unit card played by Player must be removed from hand and added to siege zone.") {
    val count_in_hand: Int = USR.getHand().occurrences(U_siege_card)
    val count_in_zone: Int = USR.getSide().zone_siege.cards.occurrences(U_siege_card)
    USR.play(U_siege_card)
    assertEquals(USR.getHand().occurrences(U_siege_card), count_in_hand - 1)
    assertEquals(USR.getHand().occurrences(U_siege_card), count_in_zone + 1)
  }

}
