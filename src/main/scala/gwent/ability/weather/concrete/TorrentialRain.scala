package cl.uchile.dcc
package gwent.ability.weather.concrete

import gwent.ability.weather.general.AbstractWeatherAbility
import gwent.card.unit.UnitCard
import gwent.card.weather.WeatherCard

/** Ability for cards of type [[WeatherCard]].
 * When a new card with this ability is played on the weather zone, it changes the current strength
 * of all siege cards to 1, on both sides of the board.
 *
 * @constructor Creates a new ability object for Torrential Rain.
 * @example
 * {{{
 * val tr = new TorrentialRain()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class TorrentialRain extends AbstractWeatherAbility with Equals {
  /** Applies the Torrential Rain effect of a given new card to the target card of type siege, 
   * overriding its current strength to 1.
   *
   * @param newCard    The card recently placed on the weather zone that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyWeatherEffect(newCard: WeatherCard, targetCard: UnitCard): Unit = {
    targetCard.setCurrentStrength(1)
  }
  
  /** Returns true if the other instance is of class TorrentialRain. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[TorrentialRain]

  /** Returns true if the other instance is of class TorrentialRain. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[TorrentialRain] else false
  }

}
