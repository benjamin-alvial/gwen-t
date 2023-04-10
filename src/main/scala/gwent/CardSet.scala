package cl.uchile.dcc
package gwent

class CardSet() {
  
  def this(card_amount: Int) = {
    this()
    // To implement: choose 10 at random.
  }
  
  var list: List[Card] = List(
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
  
  def amount: Int = {}
  
  def take(x: Card): Unit = {}

}
