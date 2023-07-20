package cl.uchile.dcc
package gwent.observer

import gwent.card.unit.UnitCard
import gwent.card.weather.WeatherCard

/**
 * Interface used for [[UnitCard]], which can observe its zone
 * for when a new card is played on it.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait ObserverCard {
  /** Updates its current strength according to the new unit card played. */
  def update(newCard: UnitCard): Unit
  /** Updates its current strength according to the new weather card played. */
  def updateWeather(newCard: WeatherCard): Unit

}
