package cl.uchile.dcc
package gwent.board.zone
import gwent.card.general.Card

/** Represents the zone where only cards of type [[WeatherCard]] are played.
 *
 * @constructor Creates a new zone for weather.
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
  /** The current card in weather zone, if it exists. */
  private var current_card: Option[Card] = None

  /** Receives a weather card and places it on its zone. */
  def play(c: Card): Unit = {
    current_card = Some(c)
  }
}
