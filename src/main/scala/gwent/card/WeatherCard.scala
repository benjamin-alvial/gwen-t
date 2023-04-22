package cl.uchile.dcc
package gwent.card

class WeatherCard(val name: String, val ability: String) extends AbstractCard(name) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      (this eq other) || ((this.name == other.name) && (this.ability == other.ability))
    } else {
      false
    }
  }
  
  def play(): Unit = {}

}
