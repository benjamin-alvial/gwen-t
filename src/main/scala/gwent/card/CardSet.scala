package cl.uchile.dcc
package gwent.card

import scala.collection.mutable.ListBuffer
import scala.util.Random

class CardSet(build: Boolean) {

  private var list: ListBuffer[Card] = new ListBuffer()
  
  if (build) {
    list = ListBuffer(
      new UnitCard("C1"),
      new UnitCard("C1"),
      new UnitCard("C2"),
      new UnitCard("C2"),
      new UnitCard("C1", "MB"),
      new UnitCard("C1", "TB"),

      new UnitCard("R1"),
      new UnitCard("R1"),
      new UnitCard("R2"),
      new UnitCard("R2"),
      new UnitCard("R1", "MB"),
      new UnitCard("R1", "TB"),

      new UnitCard("S1"),
      new UnitCard("S1"),
      new UnitCard("S2"),
      new UnitCard("S2"),
      new UnitCard("S1", "MB"),
      new UnitCard("S1", "TB"),

      new WeatherCard("W1", "BF"),
      new WeatherCard("W1", "BF"),
      new WeatherCard("W2", "IF"),
      new WeatherCard("W2", "IF"),
      new WeatherCard("W3", "TR"),
      new WeatherCard("W3", "TR"),
      new WeatherCard("W4", "CW")
      )
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

    for(i <- 1 to card_amount) {
      printf(i.toString)
      val taken = take()
      election.put(taken)
    }
    election
  }

}
