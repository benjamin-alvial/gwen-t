package cl.uchile.dcc
package gwent.board.zone
import gwent.card.general.Card

/** Represents the zone where only cards of type [[WeatherCard]] are played.
 *
 * @constructor Creates a new row for weather.
 *
 * @example
 * {{{
 * val weather = new WeatherZone()
 * }}}
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class WeatherZone extends Zone {
  private var current_card: Option[Card] = None

  def play(c: Card): Unit = {
    current_card = Some(c)
  }
}
