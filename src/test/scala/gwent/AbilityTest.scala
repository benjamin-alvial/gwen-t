package cl.uchile.dcc
package gwent

import gwent.ability.unit.concrete.{MoralBoost, NullAbility, TightBond}
import gwent.ability.weather.concrete
import gwent.ability.weather.concrete.{BitingFrost, ClearWeather, ImpenetrableFog, TorrentialRain}
import gwent.board.general.{Board, Side}
import gwent.card.unit.{CloseUnitCard, RangedUnitCard, SiegeUnitCard}
import gwent.player.concrete.{ComputerPlayer, UserPlayer}

import cl.uchile.dcc.gwent.card.weather.WeatherCard
import munit.FunSuite

class AbilityTest extends FunSuite {

  var b: Board = null
  var s1: Side = null
  var s2: Side = null
  var USR: UserPlayer = null
  var CPU: ComputerPlayer = null
  var given_strength: Int = 0
  var U_close_card_C1_MB: CloseUnitCard = null
  var U_close_card_C2_TB: CloseUnitCard = null
  var U_close_card_C2_NA: CloseUnitCard = null
  var U_close_card_C3_NA: CloseUnitCard = null
  var U_close_card_R1_MB: RangedUnitCard = null
  var U_close_card_R2_TB: RangedUnitCard = null
  var U_close_card_R2_NA: RangedUnitCard = null
  var U_close_card_R3_NA: RangedUnitCard = null
  var U_close_card_S1_MB: SiegeUnitCard = null
  var U_close_card_S2_TB: SiegeUnitCard = null
  var U_close_card_S2_NA: SiegeUnitCard = null
  var U_close_card_S3_NA: SiegeUnitCard = null
  var W_card_BF: WeatherCard = null
  var W_card_CW: WeatherCard = null
  var W_card_IF: WeatherCard = null
  var W_card_TR: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    b = new Board()
    s1 = new Side(b)
    s2 = new Side(b)

    USR = new UserPlayer("Kermit")
    CPU = new ComputerPlayer("Computer")

    USR.setSide(s1)
    CPU.setSide(s2)

    given_strength = 10

    U_close_card_C1_MB = new CloseUnitCard("C1", given_strength, new MoralBoost())
    U_close_card_C2_TB = new CloseUnitCard("C2", given_strength, new TightBond())
    U_close_card_C2_NA = new CloseUnitCard("C2", given_strength, new NullAbility())
    U_close_card_C3_NA = new CloseUnitCard("C3", given_strength, new NullAbility())

    U_close_card_R1_MB = new RangedUnitCard("R1", given_strength, new MoralBoost())
    U_close_card_R2_TB = new RangedUnitCard("R2", given_strength, new TightBond())
    U_close_card_R2_NA = new RangedUnitCard("R2", given_strength, new NullAbility())
    U_close_card_R3_NA = new RangedUnitCard("R3", given_strength, new NullAbility())

    U_close_card_S1_MB = new SiegeUnitCard("S1", given_strength, new MoralBoost())
    U_close_card_S2_TB = new SiegeUnitCard("S2", given_strength, new TightBond())
    U_close_card_S2_NA = new SiegeUnitCard("S2", given_strength, new NullAbility())
    U_close_card_S3_NA = new SiegeUnitCard("S3", given_strength, new NullAbility())

    W_card_BF = new WeatherCard("W1", new BitingFrost())
    W_card_CW = new WeatherCard("W2", new ClearWeather())
    W_card_IF = new WeatherCard("W3", new ImpenetrableFog())
    W_card_TR = new WeatherCard("W4", new TorrentialRain())

  }

  test("Two abilities are equal if they are of the same class.") {
    val mb1 = new MoralBoost()
    val mb2 = new MoralBoost()
    val na1 = new NullAbility()
    val na2 = new NullAbility()
    val tb1 = new TightBond()
    val tb2 = new TightBond()
    val bf1 = new BitingFrost()
    val bf2 = new BitingFrost()
    val cw1 = new ClearWeather()
    val cw2 = new ClearWeather()
    val if1 = new ImpenetrableFog()
    val if2 = new ImpenetrableFog()
    val tr1 = new TorrentialRain()
    val tr2 = new TorrentialRain()

    assertEquals(mb1, mb2)
    assertEquals(na1, na2)
    assertEquals(tb1, tb2)
    assertEquals(bf1, bf2)
    assertEquals(cw1, cw2)
    assertEquals(if1, if2)
    assertEquals(tr1, tr2)
    assertNotEquals[Any, Any](mb1,na1)
    assertNotEquals[Any, Any](mb1,if1)
    assertNotEquals[Any, Any](if1,tr1)

  }

  test("Initial values for strengths are default values.") {
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, given_strength)
  }

  test("Testing TightBond for EP5.") {
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.put(U_close_card_C1_MB)
    USR.getHand.put(U_close_card_C2_TB)
    USR.getHand.put(U_close_card_C2_NA)
    USR.getHand.put(U_close_card_C3_NA)

    USR.play(U_close_card_C2_NA) // Do nothing.
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    USR.play(U_close_card_C3_NA) // Do nothing.
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, given_strength)
    USR.play(U_close_card_C2_TB) // Multiply by 2 each in row with same name, including itself.
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength * 2)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength * 2)

  }

  test("Three possible effects of close combat cards can be played, null abilities first.") {
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.put(U_close_card_C1_MB)
    USR.getHand.put(U_close_card_C2_TB)
    USR.getHand.put(U_close_card_C2_NA)
    USR.getHand.put(U_close_card_C3_NA)

    USR.play(U_close_card_C2_NA) // Do nothing.
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    USR.play(U_close_card_C3_NA) // Do nothing.
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, given_strength)
    USR.play(U_close_card_C1_MB) // Add 1 to each in row, except itself.
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength+1)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, given_strength+1)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    USR.play(U_close_card_C2_TB) // Multiply by 2 each in row with same name, including itself.
    assertEquals(U_close_card_C2_NA.getCurrentStrength, (given_strength+1)*2)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, given_strength+1)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength*2)
  }

  test("Three possible effects of close combat cards can be played, null abilities last.") {
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.put(U_close_card_C1_MB)
    USR.getHand.put(U_close_card_C2_TB)
    USR.getHand.put(U_close_card_C2_NA)
    USR.getHand.put(U_close_card_C3_NA)

    USR.play(U_close_card_C1_MB) // Add 1 to each in row, except itself.
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    USR.play(U_close_card_C2_TB) // Multiply by 2 each in row with same name, including itself.
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength * 2)
    USR.play(U_close_card_C2_NA) // Do nothing.
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength * 2)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    USR.play(U_close_card_C3_NA) // Do nothing.
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength * 2)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, given_strength)
  }

  test("Multiple instances of the same card should be independent.") {
    val U_close_card_C1_MB_copy = new CloseUnitCard("C1", given_strength, new MoralBoost())
    val U_close_card_C2_TB_copy = new CloseUnitCard("C2", given_strength, new TightBond())
    val U_close_card_C2_NA_copy = new CloseUnitCard("C2", given_strength, new NullAbility())
    val U_close_card_C3_NA_copy = new CloseUnitCard("C3", given_strength, new NullAbility())

    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.put(U_close_card_C1_MB)
    USR.getHand.put(U_close_card_C2_TB)
    USR.getHand.put(U_close_card_C2_NA)
    USR.getHand.put(U_close_card_C3_NA)

    USR.play(U_close_card_C2_NA) // Do nothing.
    USR.play(U_close_card_C3_NA) // Do nothing.
    USR.play(U_close_card_C1_MB) // Add 1 to each in row, except itself.
    USR.play(U_close_card_C2_TB) // Multiply by 2 each in row with same name, including itself.

    // Copies are not modified.
    assertEquals(U_close_card_C1_MB_copy.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB_copy.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_NA_copy.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C3_NA_copy.getCurrentStrength, given_strength)

    // Copies can aldo be played on the board.
    USR.getHand.put(U_close_card_C1_MB_copy)
    USR.getHand.put(U_close_card_C2_TB_copy)
    USR.getHand.put(U_close_card_C2_NA_copy)
    USR.getHand.put(U_close_card_C3_NA_copy)

    USR.play(U_close_card_C2_NA_copy) // Do nothing.
    USR.play(U_close_card_C3_NA_copy) // Do nothing.
    USR.play(U_close_card_C1_MB_copy) // Add 1 to each in row, except itself.
    USR.play(U_close_card_C2_TB_copy) // Multiply by 2 each in row with same name, including itself.

    assertEquals(U_close_card_C2_NA.getCurrentStrength, ((given_strength + 1) * 2 + 1) * 2)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, (given_strength + 1) + 1)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength + 1)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, (given_strength * 2 + 1) * 2)

    assertEquals(U_close_card_C2_NA_copy.getCurrentStrength, (given_strength + 1) * 2)
    assertEquals(U_close_card_C3_NA_copy.getCurrentStrength, given_strength + 1)
    assertEquals(U_close_card_C1_MB_copy.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB_copy.getCurrentStrength, given_strength * 2)
  }

  test("Playing a close combat card should leave other player's close combat cards unchanged.") {
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.put(U_close_card_C2_NA)
    USR.getHand.put(U_close_card_C2_TB)

    CPU.getHand.take()
    CPU.getHand.put(U_close_card_C1_MB)

    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength)

    USR.play(U_close_card_C2_NA)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength)

    // This card should not boost the user's close combat card.
    CPU.play(U_close_card_C1_MB)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength)

    USR.play(U_close_card_C2_TB)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength*2)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength*2)

  }

  test("Biting Frost reduces strength to 1 for close combat units.") {
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.put(W_card_BF)
    USR.getHand.put(U_close_card_C2_NA)
    USR.getHand.put(U_close_card_C3_NA)
    USR.getHand.put(U_close_card_C1_MB)
    USR.getHand.put(U_close_card_C2_TB)

    // Initially weather is clear.
    USR.play(U_close_card_C2_NA)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)

    // And unit abilities work like always.
    USR.play(U_close_card_C1_MB)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength+1)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)

    // Once weather card for Biting Frost is played, close combat units are frozen.
    USR.play(W_card_BF)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, 1)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, 1)

    // Any new card added feels the effect of the current weather.
    USR.play(U_close_card_C3_NA)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, 1)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, 1)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, 1)

    // Even if the new card has a unit effect, weather overrides it.
    USR.play(U_close_card_C2_TB)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, 1)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, 1)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, 1)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, 1)

  }

  test("Biting Frost works for both player's close combat cards.") {
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.take()
    USR.getHand.put(W_card_BF)
    USR.getHand.put(U_close_card_C2_NA)
    USR.getHand.put(U_close_card_C1_MB)
    CPU.getHand.take()
    CPU.getHand.take()
    CPU.getHand.put(U_close_card_C2_TB)
    CPU.getHand.put(U_close_card_C3_NA)

    USR.play(U_close_card_C1_MB)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)

    CPU.play(U_close_card_C2_TB)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength*2)

    USR.play(U_close_card_C2_NA)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength * 2)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)

    CPU.play(U_close_card_C3_NA)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, given_strength * 2)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, given_strength)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, given_strength)

    USR.play(W_card_BF)
    assertEquals(U_close_card_C1_MB.getCurrentStrength, 1)
    assertEquals(U_close_card_C2_TB.getCurrentStrength, 1)
    assertEquals(U_close_card_C2_NA.getCurrentStrength, 1)
    assertEquals(U_close_card_C3_NA.getCurrentStrength, 1)

  }

  test("Playing a close combat card should leave cards from other rows unchanged.") {

  }
}
