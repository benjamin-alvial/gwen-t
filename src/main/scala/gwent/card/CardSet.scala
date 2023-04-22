package cl.uchile.dcc
package gwent.card

import scala.collection.mutable.ListBuffer
import scala.util.Random

class CardSet(build: Boolean) extends Equals {

  private var list: ListBuffer[Card] = new ListBuffer()
  
  if (build) {
    list = ListBuffer(
      new UnitCard("C1"),
      new UnitCard("C1"),
      new UnitCard("C2"),
      new UnitCard("C2"),
      new UnitCard("C1", "MB"), // Morale Boost.
      new UnitCard("C1", "TB"), // Tight Bond.

      new UnitCard("R1"),
      new UnitCard("R1"),
      new UnitCard("R2"),
      new UnitCard("R2"),
      new UnitCard("R1", "MB"), // Morale Boost.
      new UnitCard("R1", "TB"), // Tight Bond.

      new UnitCard("S1"),
      new UnitCard("S1"),
      new UnitCard("S2"),
      new UnitCard("S2"),
      new UnitCard("S1", "MB"), // Morale Boost.
      new UnitCard("S1", "TB"), // Tight Bond.

      new WeatherCard("W1", "BF"), // Biting Frost.
      new WeatherCard("W1", "BF"), // Biting Frost.
      new WeatherCard("W2", "IF"), // Impenetrable Fog.
      new WeatherCard("W2", "IF"), // Impenetrable Fog.
      new WeatherCard("W3", "TR"), // Torrential Rain.
      new WeatherCard("W3", "TR"), // Torrential Rain.
      new WeatherCard("W4", "CW") // Clear Weather.
      )
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[CardSet]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CardSet]

      var same_elements: Boolean = true

      for (x <- this.list) {
        if (this.occurrences(x) != other.occurrences(x)) {
          same_elements = false
        }
      }

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
  
  def getAmount(): Int = list.size
  
  def take(): Card = {
    //val idx = Random.nextInt(amount)
    val idx = 0
    printf(idx.toString)
    list.remove(idx)
  }

  def put(x: Card): Unit = list.append(x)

  def choose(card_amount: Int): CardSet = {

    val election = new CardSet(build = false)

    for (i <- 1 to card_amount) {
      printf(i.toString)
      val taken = take()
      election.put(taken)
    }
    election
  }

  def shuffle(): Unit = {
    Random.shuffle(list)
  }

  private def occurrences(x: Card): Int = {
    var i: Int = 0
    for (c <- list) {
      if (c == x) {
        i += 1
      }
    }
    i
  }

}
