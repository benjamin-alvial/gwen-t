package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.board.general.{Board, Side}
import cl.uchile.dcc.gwent.card.unit.{CloseUnitCard, RangedUnitCard, SiegeUnitCard}
import cl.uchile.dcc.gwent.card.weather.WeatherCard
import cl.uchile.dcc.gwent.player.concrete.UserPlayer
import cl.uchile.dcc.gwent.board.row.AbstractRow
import cl.uchile.dcc.gwent.board.zone.WeatherZone
import munit.FunSuite

/** Tests methods related to a Player playing Cards on the Zones of the Board. */
class BoardTest extends FunSuite {

  var b: Board = null
  var s1: Side = null
  var s2: Side = null
  var USR: UserPlayer = null
  var U_close_card: CloseUnitCard = null
  var U_ranged_card: RangedUnitCard = null
  var U_siege_card: SiegeUnitCard = null
  var W_card: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    b = new Board()
    s1 = new Side(b)
    s2 = new Side(b)
    USR = new UserPlayer("Kermit")

    USR.setSide(s1)


    U_close_card = new CloseUnitCard("C1", 100)
    U_ranged_card = new RangedUnitCard("R1", 100)
    U_siege_card = new SiegeUnitCard("S1", 100)
    W_card = new WeatherCard("W1", "BF")

    USR.getHand().take()
    USR.getHand().take()
    USR.getHand().take()
    USR.getHand().take()
    USR.getHand().put(U_close_card)
    USR.getHand().put(U_ranged_card)
    USR.getHand().put(U_siege_card)
    USR.getHand().put(W_card)
  }

  test("Close combat unit card played by Player must be removed from hand and added to close combat zone.") {
    val count_in_hand: Int = USR.getHand().occurrences(U_close_card)
    val count_in_zone: Int = USR.getSide().zone_close.getCurrentCards().occurrences(U_close_card)
    USR.play(U_close_card)
    assertEquals(USR.getHand().occurrences(U_close_card), count_in_hand-1)
    assertEquals(USR.getSide().zone_close.getCurrentCards().occurrences(U_close_card), count_in_zone+1)
  }

  test("Ranged unit card played by Player must be removed from hand and added to ranged zone.") {
    val count_in_hand: Int = USR.getHand().occurrences(U_ranged_card)
    val count_in_zone: Int = USR.getSide().zone_ranged.getCurrentCards().occurrences(U_ranged_card)
    USR.play(U_ranged_card)
    assertEquals(USR.getHand().occurrences(U_ranged_card), count_in_hand - 1)
    assertEquals(USR.getSide().zone_ranged.getCurrentCards().occurrences(U_ranged_card), count_in_zone + 1)
  }

  test("Siege unit card played by Player must be removed from hand and added to siege zone.") {
    val count_in_hand: Int = USR.getHand().occurrences(U_siege_card)
    val count_in_zone: Int = USR.getSide().zone_siege.getCurrentCards().occurrences(U_siege_card)
    USR.play(U_siege_card)
    assertEquals(USR.getHand().occurrences(U_siege_card), count_in_hand - 1)
    assertEquals(USR.getSide().zone_siege.getCurrentCards().occurrences(U_siege_card), count_in_zone + 1)
  }

  test("Weather card played by Player must be removed from hand and added to weather zone") {
    val count_in_hand: Int = USR.getHand().occurrences(W_card)
    val count_in_zone: Int = USR.getSide().board.zone_weather.getCurrentCards().occurrences(W_card)
    USR.play(W_card)
    assertEquals(USR.getHand().occurrences(W_card), count_in_hand - 1)
    assertEquals(USR.getSide().board.zone_weather.getCurrentCards().occurrences(W_card), count_in_zone + 1)
  }

}
