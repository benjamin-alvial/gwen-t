package cl.uchile.dcc
package gwent

class WeatherCard(name: String, effect: String) extends Card {
  def play(): Unit
  def draw(): Unit
}
