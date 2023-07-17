package cl.uchile.dcc
package gwent.board.weather

import gwent.board.general.AbstractZone
import gwent.card.general.Card
import gwent.card.weather.WeatherCard

/** Represents the weather where only cards of type [[WeatherCard]] are played.
 *
 * @constructor Creates a new zone for weather.
 * @example
 * {{{
 * val weather = new WeatherZone()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.5
 */
class WeatherZone extends AbstractZone with Equals {

  /** Receives a weather card and places it on its zone, removing the old one. 
   * @param c The card to be played on the weather zone. */
  def play(c: WeatherCard): Unit = {
    if (getCurrentCards.getAmount != 0) getCurrentCards.take()
    getCurrentCards.put(c)
  }

  /** Returns true if the other instance is of class WeatherZone. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherZone]

  /** Returns true if the two instances of WeatherZone share the same current cards. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherZone]
      (this eq other) || (this.getCurrentCards == other.getCurrentCards)
    } else {
      false
    }
  }
  
}
