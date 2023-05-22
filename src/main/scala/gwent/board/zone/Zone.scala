package cl.uchile.dcc
package gwent.board.zone

import gwent.board.row.AbstractRow
import cl.uchile.dcc.gwent.card.general.Card

/**
 * Interface used for [[AbstractRow]] and [[WeatherZone]], which can play cards. 
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait Zone {
  /** Plays a card on the zone. */
  def play(c: Card): Unit
}
