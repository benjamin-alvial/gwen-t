package cl.uchile.dcc
package gwent.card.weather

import gwent.board.general.{Board, Side}
import gwent.card.general.AbstractCard

/** Represents the weather cards.
 *
 * A weather card is placed on the field and has an ability that affects the battlefield.
 * It can only be placed in the Board's weather zone.
 *
 * @param name The name of the weather card.
 * @param ability The ability of the weather card.
 * @constructor Creates a new weather card with the specified name and ability.
 * @example
 * {{{
 * val w_card = new WeatherCard("W1", "BF")
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.5
 */
class WeatherCard(private val name: String, private val ability: String) extends AbstractCard(name, ability) with Equals {
  /** Sends a message to the given side's board to receive the card of type weather. 
   *
   * @param s The side to which the card will be played. */
  def play(s: Side): Unit = s.getBoard.receiveWeather(this)

  /** Returns true if the other instance is of class WeatherCard. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  /** Returns true if the two instances of WeatherCard share the same name and ability. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      (this eq other) || ((this.name == other.getName) && (this.ability == other.getAbility))
    } else {
      false
    }
  }

}
