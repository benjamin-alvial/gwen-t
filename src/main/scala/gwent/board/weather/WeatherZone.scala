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
 * @version 0.1.1
 */
class WeatherZone extends AbstractZone {

  /** Receives a weather card and places it on its weather, removing the old one. */
  override def play(c: Card): Unit = {
    getCurrentCards().take(c)
    getCurrentCards().put(c)
  }

}
