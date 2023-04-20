package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.card.{CardSet, UnitCard, WeatherCard}
import munit.FunSuite


class CardTest extends FunSuite {

  var U_plain_card: UnitCard = null
  var U_effect_card: UnitCard = null
  var W_card: WeatherCard = null

  var Build_set: CardSet = null
  var Empty_set: CardSet = null

  override def beforeEach(context: BeforeEach): Unit = {
    U_plain_card = new UnitCard("C1")
    U_effect_card = new UnitCard("C2", "MB")
    W_card = new WeatherCard("W1", "BF")

    Build_set = new CardSet(true)
    Empty_set = new CardSet(false)
  }

  test("Card must have a name.") {
    assertEquals(U_plain_card.name, expected = "C1")
    assertEquals(U_effect_card.name, expected = "C2")
    assertEquals(W_card.name, expected = "W1")
  }


  test("Weather cards must have an effect.") {
    assertEquals(W_card.ability, expected = "BF")
  }

  test("Card sets must have the desired amount of cards.") {
    assertEquals(Empty_set.getAmount(), expected = 0)
    assertEquals(Build_set.getAmount(), expected = 25)
  }

  test("Cards can be taken from non-empty set.") {
    assertEquals(Build_set.getAmount(), expected = 25)
    Build_set.take()
    assertEquals(Build_set.getAmount(), expected = 24)
    // Future: exception for taking from empty set.
  }

  test("Cards can be put into a set.")  {
    assertEquals(Empty_set.getAmount(), expected = 0)
    Empty_set.put(U_plain_card)
    assertEquals(Empty_set.getAmount(), expected = 1)
    // Future: exception for maximum amount on hand.
  }

  test("Subsets must have the desired amount of cards.") {
    val Subset_set: CardSet = Build_set.choose(10)
    assertEquals(Subset_set.getAmount(), expected = 10)
  }

  test("Card sets must correctly remove card when drawn or played.") {
    // Future implementation with ids.
  }


}
