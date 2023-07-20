package cl.uchile.dcc
package gwent.ability.weather.concrete

import gwent.ability.weather.general.AbstractWeatherAbility
import gwent.card.unit.UnitCard
import gwent.card.weather.WeatherCard

/** Ability for cards of type [[WeatherCard]].
 * When a new card with this ability is played on the weather zone, it changes the current strength 
 * of all cards to their base strength, on both sides of the board.
 *
 * @constructor Creates a new ability object for Biting Frost.
 * @example
 * {{{
 * val cw = new ClearWeather()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class ClearWeather extends AbstractWeatherAbility with Equals {
  /** Applies the Clear Weather effect of a given new card to the target card, 
   * overriding its current strength to its base strength.
   *
   * @param newCard    The card recently placed on the weather zone that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyWeatherEffect(newCard: WeatherCard, targetCard: UnitCard): Unit = {
    targetCard.setCurrentStrength(targetCard.getStrength)
  }
  
  /** Returns true if the other instance is of class ClearWeather. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ClearWeather]

  /** Returns true if the other instance is of class ClearWeather. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[ClearWeather] else false
  }

}
