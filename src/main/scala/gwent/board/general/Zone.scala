package cl.uchile.dcc
package gwent.board.general

import gwent.board.general.AbstractZone
import gwent.board.weather.WeatherZone
import gwent.card.general.Card

/**
 * Interface used for [[AbstractZone]] and [[WeatherZone]], which can play cards. 
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait Zone {
  /** Plays a card on the zone. 
   * @param c The card to be played on the zone. */
  def play(c: Card): Unit
}
