package cl.uchile.dcc
package gwent.card

/** Represents the weather cards.
 *
 * A weather card is placed on the field and has an ability that affects the battlefield.
 *
 * @param name The name of the weather card.
 *
 * @constructor Creates a new weather card with the specified name and ability.
 *
 * @example
 * {{{
 * val w_card = new WeatherCard("W1", "BF")
 * }}}
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class WeatherCard(val name: String, val ability: String) extends AbstractCard(name) with Equals {

  /** Returns true if the other instance is of class WeatherCard. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  /** Returns true if the two instances of WeatherCard share the same name and ability. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      (this eq other) || ((this.name == other.name) && (this.ability == other.ability))
    } else {
      false
    }
  }
    
  /** Card places itself on field. */
  def play(): Unit = {}

}
