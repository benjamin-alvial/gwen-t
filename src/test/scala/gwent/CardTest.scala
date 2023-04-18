package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.card.{CardSet, UnitCard, WeatherCard}
import munit.FunSuite


class CardTest extends FunSuite {

  override def beforeEach(context: BeforeEach): Unit = {
    val Unit_plain = new UnitCard("C1")
    val Unit_effect = new UnitCard("C2", "MB")
    val Weather = new WeatherCard("W1", "BF")

    val Small_set = new CardSet(1)
  }

  test("Card must have a name.") {
    assertEquals(Unit_plain.name, expected = "C1")
    assertEquals(Unit_effect.name, expected = "C2")
    assertEquals(Weather.name, expected = "W1")
  }

  test("Weather cards must have an effect.") {
    assertEquals(Weather.effect, expected = "BF")
  }

  test("Card sets must have the desired amount of cards, if specified.") {
    assertEquals(Small_set.amount, expected = 1)
  }

  test("Card sets must correctly remove card when drawn or played.") {
    // Future implementation with ids.
  }

}
