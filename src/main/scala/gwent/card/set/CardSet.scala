package cl.uchile.dcc
package gwent.card.set

import gwent.card.unit.CloseUnitCard
import gwent.card.unit.RangedUnitCard
import gwent.card.unit.SiegeUnitCard
import gwent.card.weather.WeatherCard

import cl.uchile.dcc.gwent.card.general.Card
import cl.uchile.dcc.gwent.exceptions.{CardNotInSetException, TakeFromEmptySetException}

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** Represents a set of cards.
 *
 * The card set is a list of cards.
 *
 * @param build Use default set of 25 cards.
 *
 * @constructor Creates the default card set of 25 cards when build is true and an empty card set when build is false.
 *
 * @example
 * {{{
 * val build_set = new CardSet(true)
 * val empty_set = new CardSet(false)
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.3
 */
class CardSet(build: Boolean) extends Equals {

  /** The list of cards. */
  private var list: ListBuffer[Card] = new ListBuffer()
  
  if (build) {
    list = ListBuffer(
      // Future: implement abilities.
      new CloseUnitCard("C1", 100, "NULL"),
      new CloseUnitCard("C1", 100, "NULL"),
      new CloseUnitCard("C2", 100, "NULL"),
      new CloseUnitCard("C2", 100, "NULL"),
      new CloseUnitCard("C1", 100, "MB"), // Morale Boost.
      new CloseUnitCard("C1", 100, "TB"), // Tight Bond.

      new RangedUnitCard("R1", 100, "NULL"),
      new RangedUnitCard("R1", 100, "NULL"),
      new RangedUnitCard("R2", 100, "NULL"),
      new RangedUnitCard("R2", 100, "NULL"),
      new RangedUnitCard("R1", 100, "MB"), // Morale Boost.
      new RangedUnitCard("R1", 100, "TB"), // Tight Bond.

      new SiegeUnitCard("S1", 100, "NULL"),
      new SiegeUnitCard("S1", 100, "NULL"),
      new SiegeUnitCard("S2", 100, "NULL"),
      new SiegeUnitCard("S2", 100, "NULL"),
      new SiegeUnitCard("S1", 100, "MB"), // Morale Boost.
      new SiegeUnitCard("S1", 100, "TB"), // Tight Bond.

      new WeatherCard("W1", "BF"), // Biting Frost.
      new WeatherCard("W1", "BF"), // Biting Frost.
      new WeatherCard("W2", "IF"), // Impenetrable Fog.
      new WeatherCard("W2", "IF"), // Impenetrable Fog.
      new WeatherCard("W3", "TR"), // Torrential Rain.
      new WeatherCard("W3", "TR"), // Torrential Rain.
      new WeatherCard("W4", "CW") // Clear Weather.
      )
  }

  /** Returns the list of cards in the card set. */
  def getList(): ListBuffer[Card] = list

  /** Returns true if the other instance is of class CardSet. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CardSet]

  /** Returns true if the two instances of CardSet contain the same cards and same amount of each. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CardSet]

      var same_elements: Boolean = true

      // Iterate over the cards of this list and check if they appear the same amount on the other list.
      for (x <- this.list) {
        if (this.occurrences(x) != other.occurrences(x)) {
          same_elements = false
        }
      }

      // Iterate over the cards of the other list and check if they appear the same amount on this list.
      for (x <- other.list) {
        if (this.occurrences(x) != other.occurrences(x)) {
          same_elements = false
        }
      }

      (this eq other) || same_elements

    } else {
      false
    }
  }

  /** Returns amount of cards in the card list. */
  def getAmount(): Int = list.size

  /** Removes and returns the first card from the list. */
  def take(): Card = {
    //val idx = Random.nextInt(amount)
    val idx = 0
    list.remove(idx)
  }

  /** Removes the specified card from the list. 
   * @param c The card to be removed from the card set. */
  def take(x: Card): Unit = {
    if (list.isEmpty) throw new TakeFromEmptySetException

    val election = new CardSet(build = false)
    var found = false // State variable to mark that we already took the 1 instance we wanted.

    for (i <- 1 to getAmount()) {
      val taken = take() // Take the first card.

      if (found == true) {
        election.put(taken) // If it has already been found, keep the other cards.
      } else {
        if (taken != x) {
          election.put(taken) // If it hasn't been found, keep searching and keep others.
        } else found = true // If it is found, don't keep it.
      }

    }

    list = election.list
    if (found == false) throw new CardNotInSetException

  }

  /** Adds the given card to the list. 
   * @param x The card to be added to the card set. */
  def put(x: Card): Unit = list.append(x)

  /** Chooses a subset of cards from the list.
   *
   * Chooses the desired amount of cards from the CardSet randomly, removes them and adds them to a new CardSet, which is returned.
   *
   * @param card_amount The amount of cards to be chosen.
   * @return The CardSet whose list contains the chosen cards.
   * @example
   * {{{
   * val deck: CardSet = new CardSet(build = true)
   * val hand: CardSet = deck.choose(10)
   * }}}
   * */
  def choose(card_amount: Int): CardSet = {

    val election = new CardSet(build = false)

    for (i <- 1 to card_amount) {
      val taken = take()
      election.put(taken)
    }
    election
  }

  /** Shuffles the list of cards. */
  def shuffle(): Unit = {
    Random.shuffle(list)
  }

  /** Counts the occurrences of a given card in the list. 
   * @param x The card which will be counted. */
  def occurrences(x: Card): Int = {
    var i: Int = 0
    for (c <- list) {
      if (c == x) {
        i += 1
      }
    }
    i
  }

}
