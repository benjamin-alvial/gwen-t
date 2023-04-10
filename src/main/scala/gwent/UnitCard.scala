package cl.uchile.dcc
package gwent

class UnitCard(name: String) extends Card {
  var effect: Option[String] = None

  def this(name: String, effect: String) = {
    this(name)
    this.effect = Some(effect)
  }

  def play(): Unit

  def draw(): Unit

}
