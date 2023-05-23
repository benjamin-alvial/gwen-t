package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.card.set.CardSet
import cl.uchile.dcc.gwent.card.unit.{CloseUnitCard, UnitCard}
import cl.uchile.dcc.gwent.card.weather.WeatherCard
import munit.FunSuite

/** Tests methods related to Cards and CardSets. */
class CardTest extends FunSuite {

  var U_plain_card: CloseUnitCard = null
  var U_effect_card: CloseUnitCard = null
  var W_card: WeatherCard = null

  var Build_set: CardSet = null
  var Empty_set: CardSet = null

  override def beforeEach(context: BeforeEach): Unit = {
    U_plain_card = new CloseUnitCard("C1", 100)
    U_effect_card = new CloseUnitCard("C2", 100)
    //U_effect_card = new CloseUnitCard("C2", "MB")
    W_card = new WeatherCard("W1", "BF")

    Build_set = new CardSet(true)
    Empty_set = new CardSet(false)
  }

  test("Card must have a name.") {
    assertEquals(U_plain_card.name, expected = "C1")
    //assertEquals(U_effect_card.name, expected = "C2")
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
    assertEquals(Build_set.occurrences(U_plain_card), expected = 2)

    Build_set.take(U_plain_card)

    assertEquals(Build_set.getAmount(), expected = 24)
    assertEquals(Build_set.occurrences(U_plain_card), expected = 1)
    // Future: exception for taking from empty set.
  }

  test("Cards can be put into a set.")  {
    assertEquals(Empty_set.getAmount(), expected = 0)
    assertEquals(Empty_set.occurrences(U_plain_card), expected = 0)

    Empty_set.put(U_plain_card)

    assertEquals(Empty_set.getAmount(), expected = 1)
    assertEquals(Empty_set.occurrences(U_plain_card), expected = 1)
    // Future: exception for maximum amount on hand.
  }

  test("Subsets must have the desired amount of cards.") {
    val Subset_set: CardSet = Build_set.choose(10)
    assertEquals(Subset_set.getAmount(), expected = 10)
  }

  test("Cards can be equal if they share name and abilities.") {
    // Card with itself.
    assertEquals(U_plain_card, U_plain_card)
    //assertEquals(U_effect_card, U_effect_card)
    assertEquals(W_card, W_card)

    // Card with another with same name and ability.
    val U_plain_card_copy = new CloseUnitCard("C1", 100)
    //assertEquals(U_plain_card, U_plain_card_copy)

    //val U_effect_card_copy = new UnitCard("C2", "MB")
    //assertEquals(U_effect_card, U_effect_card_copy)

    val W_card_copy = new WeatherCard("W1", "BF")
    assertEquals(W_card, W_card_copy)

    // Card with object of another type (String).
    assertNotEquals[Any, Any](U_plain_card, "C1")
    assertNotEquals[Any, Any](U_effect_card, "C2")
    assertNotEquals[Any, Any](W_card, "W1")

    // Cards of different subclasses (UnitCard and WeatherCard)
    assertNotEquals[Any, Any](U_plain_card, W_card)
    assertNotEquals[Any, Any](U_effect_card, W_card)

    //val U_same_name_effect = new WeatherCard("XX", "ZZ")
    //val W_same_name_effect = new CloseUnitCard("XX", "ZZ")
    //assertNotEquals[Any, Any](U_same_name_effect, W_same_name_effect)

    // Cards with same name but different ability.
    //val U_plain_other_effect = new UnitCard("C2", "MB")
    //assertNotEquals(U_plain_card, U_plain_other_effect)

    val W_card_other_effect = new WeatherCard("W1", "IF")
    assertNotEquals(W_card, W_card_other_effect)

    // Cards with same ability but different name.
    //val U_plain_other_name = new CloseUnitCard("C3", "MB")
    //assertNotEquals(U_plain_card, U_plain_other_name)

    val W_card_other_name = new WeatherCard("W2", "BF")
    assertNotEquals(W_card, W_card_other_name)
  }

  test("CardSets can be equal if they contain the same cards.") {
    // CardSet with itself.
    assertEquals(Build_set, Build_set)
    assertEquals(Empty_set, Empty_set)
    
    // CardSet with a copy.
    val Build_set_copy = new CardSet(true)
    val Empty_set_copy = new CardSet(false)
    assertEquals(Build_set, Build_set_copy)
    assertEquals(Empty_set, Empty_set_copy)

    // CardSet with object of another type (String).
    assertNotEquals[Any, Any](Build_set, "Build_set")
    assertNotEquals[Any, Any](Empty_set, "Empty_set")

    // CardSets constructed with put, also verify same cards but added in different order.
    val Empty_set_1 = new CardSet(false)
    val Empty_set_2 = new CardSet(false)
    assertEquals(Empty_set_1, Empty_set_2)

    Empty_set_1.put(U_plain_card)
    Empty_set_2.put(U_plain_card)
    assertEquals(Empty_set_1, Empty_set_2)

    Empty_set_1.put(U_effect_card)
    Empty_set_1.put(W_card)
    Empty_set_2.put(W_card)
    Empty_set_2.put(U_effect_card)
    assertEquals(Empty_set_1, Empty_set_2)

    // CardSet with different cards.
    assertNotEquals(Build_set, Empty_set)
    assertNotEquals(Empty_set, Build_set)
    
    // CardSet after a shuffle.
    val Build_set_shuffle = new CardSet(true)
    Build_set_shuffle.shuffle()
    assertEquals(Build_set, Build_set_shuffle)
  }


}
