package cl.uchile.dcc
package gwent.board.weather
import gwent.card.general.Card

import cl.uchile.dcc.gwent.board.general.AbstractZone

/** Represents the weather where only cards of type [[WeatherCard]] are played.
 *
 * @constructor Creates a new weather for weather.
 * @example
 * {{{
 * val weather = new WeatherZone()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
class WeatherZone extends AbstractZone with Equals {

  /** Receives a weather card and places it on its weather, removing the old one. */
  override def play(c: Card): Unit = {
    getCurrentCards().take(c)
    getCurrentCards().put(c)
  }

  /** Returns true if the other instance is of class WeatherZone. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherZone]

  /** Returns true if the two instances of WeatherZone share the same current cards. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherZone]
      (this eq other) || (this.getCurrentCards() == other.getCurrentCards())
    } else {
      false
    }
  }
  
}
