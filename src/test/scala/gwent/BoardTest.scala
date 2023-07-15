package cl.uchile.dcc
package gwent

import gwent.board.general.{AbstractZone, Board, Side}
import gwent.card.unit.{CloseUnitCard, RangedUnitCard, SiegeUnitCard}
import gwent.card.weather.WeatherCard
import gwent.player.concrete.{ComputerPlayer, UserPlayer}
import gwent.board.weather.WeatherZone

import cl.uchile.dcc.gwent.ability.unit.concrete.NullAbility
import cl.uchile.dcc.gwent.ability.weather.concrete.BitingFrost
import munit.FunSuite

/** Tests methods related to a Player playing Cards on the Zones of the Board. */
class BoardTest extends FunSuite {

  var b: Board = null
  var s1: Side = null
  var s2: Side = null
  var USR: UserPlayer = null
  var CPU: ComputerPlayer = null
  var U_close_card: CloseUnitCard = null
  var U_ranged_card: RangedUnitCard = null
  var U_siege_card: SiegeUnitCard = null
  var W_card: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    b = new Board()
    s1 = new Side(b)
    s2 = new Side(b)

    USR = new UserPlayer("Kermit")
    CPU = new ComputerPlayer("Computer")

    USR.setSide(s1)
    CPU.setSide(s2)

    U_close_card = new CloseUnitCard("C1", 100, new NullAbility())
    U_ranged_card = new RangedUnitCard("R1", 100, new NullAbility())
    U_siege_card = new SiegeUnitCard("S1", 100, new NullAbility())
    W_card = new WeatherCard("W1", new BitingFrost())

    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.put(U_close_card)
    USR.getHand.put(U_ranged_card)
    USR.getHand.put(U_siege_card)
    USR.getHand.put(W_card)
  }

  test("Two sides are equal if they have the same cards and they belong to the same board") {
    s1.receiveClose(U_close_card)
    s2.receiveClose(U_close_card)
    s1.receiveRanged(U_ranged_card)
    s2.receiveRanged(U_ranged_card)
    s1.receiveSiege(U_siege_card)
    s2.receiveSiege(U_siege_card)

    assertEquals(s1, s1)
    assertEquals(s2, s2)
    assertEquals(s1, s2)

    val name_string: String = "s1"
    assertNotEquals[Any, Any](s1, name_string)
  }

  test("Two weather zones are equal if they have same cards.") {
    val w_zone_1 = new WeatherZone()
    val w_zone_2 = new WeatherZone()
    w_zone_1.play(W_card)
    w_zone_2.play(W_card)

    assertEquals(w_zone_1, w_zone_1)
    assertEquals(w_zone_2, w_zone_2)
    assertEquals(w_zone_1, w_zone_2)

    val name_string: String = "w_zone_1"
    assertNotEquals[Any, Any](w_zone_1, name_string)
  }

  test("A board has two sides and a weather zone.") {
    assertEquals(b.getUserSide, s1)
    assertEquals(b.getComputerSide, s2)
  }

  test("Zones have card sets, initially all empty.") {
    assertEquals(USR.getSide.getCloseZone.getCurrentCards.getAmount, 0)
    assertEquals(CPU.getSide.getCloseZone.getCurrentCards.getAmount, 0)
    assertEquals(USR.getSide.getRangedZone.getCurrentCards.getAmount, 0)
    assertEquals(CPU.getSide.getRangedZone.getCurrentCards.getAmount, 0)
    assertEquals(USR.getSide.getSiegeZone.getCurrentCards.getAmount, 0)
    assertEquals(CPU.getSide.getSiegeZone.getCurrentCards.getAmount, 0)

    // Access to WeatherZone can be through either player.
    assertEquals(USR.getSide.getBoard.getWeatherZone.getCurrentCards.getAmount, 0)
    assertEquals(CPU.getSide.getBoard.getWeatherZone.getCurrentCards.getAmount, 0)
  }

  test("Close combat unit card played by Player must be removed from hand and added to close combat zone.") {
    val count_in_hand: Int = USR.getHand.occurrences(U_close_card)
    val count_in_zone: Int = USR.getSide.getCloseZone.getCurrentCards.occurrences(U_close_card)
    USR.play(U_close_card)
    assertEquals(USR.getHand.occurrences(U_close_card), count_in_hand-1)
    assertEquals(USR.getSide.getCloseZone.getCurrentCards.occurrences(U_close_card), count_in_zone+1)
  }

  test("Ranged unit card played by Player must be removed from hand and added to ranged zone.") {
    val count_in_hand: Int = USR.getHand.occurrences(U_ranged_card)
    val count_in_zone: Int = USR.getSide.getRangedZone.getCurrentCards.occurrences(U_ranged_card)
    USR.play(U_ranged_card)
    assertEquals(USR.getHand.occurrences(U_ranged_card), count_in_hand - 1)
    assertEquals(USR.getSide.getRangedZone.getCurrentCards.occurrences(U_ranged_card), count_in_zone + 1)
  }

  test("Siege unit card played by Player must be removed from hand and added to siege zone.") {
    val count_in_hand: Int = USR.getHand.occurrences(U_siege_card)
    val count_in_zone: Int = USR.getSide.getSiegeZone.getCurrentCards.occurrences(U_siege_card)
    USR.play(U_siege_card)
    assertEquals(USR.getHand.occurrences(U_siege_card), count_in_hand - 1)
    assertEquals(USR.getSide.getSiegeZone.getCurrentCards.occurrences(U_siege_card), count_in_zone + 1)
  }

  test("Weather card played by Player must be removed from hand and added to weather zone.") {
    val count_in_hand: Int = USR.getHand.occurrences(W_card)
    USR.play(W_card)
    assertEquals(USR.getHand.occurrences(W_card), count_in_hand - 1)
    assertEquals(USR.getSide.getBoard.getWeatherZone.getCurrentCards.occurrences(W_card), 1)

    // In fact, the amount of cards in the weather zone can be only at most one at any given moment.
    assertEquals(USR.getSide.getBoard.getWeatherZone.getCurrentCards.getAmount, 1)

    // If another card is added, the old one should be replaced.
    val W_card_other = new WeatherCard("W2", new BitingFrost())
    USR.getHand.put(W_card_other)
    USR.play(W_card_other)
    assertEquals(USR.getSide.getBoard.getWeatherZone.getCurrentCards.occurrences(W_card), 0)
    assertEquals(USR.getSide.getBoard.getWeatherZone.getCurrentCards.occurrences(W_card_other), 1)

    // And there should still only be one card.
    assertEquals(USR.getSide.getBoard.getWeatherZone.getCurrentCards.getAmount, 1)
  }

}
