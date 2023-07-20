package cl.uchile.dcc
package gwent.ability.weather.concrete

import gwent.ability.weather.general.AbstractWeatherAbility
import gwent.card.unit.UnitCard
import gwent.card.weather.WeatherCard

/** Ability for cards of type [[WeatherCard]].
 * When a new card with this ability is played on the weather zone, it changes the current strength
 * of all ranged cards to 1, on both sides of the board.
 *
 * @constructor Creates a new ability object for Impenetrable Fog.
 * @example
 * {{{
 * val if = new ImpenetrableFog()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class ImpenetrableFog extends AbstractWeatherAbility with Equals {
  /** Applies the Impenetrable Fog effect of a given new card to the target card of type ranged, 
   * overriding its current strength to 1.
   *
   * @param newCard    The card recently placed on the weather zone that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyWeatherEffect(newCard: WeatherCard, targetCard: UnitCard): Unit = {
    targetCard.setCurrentStrength(1)
  }
  
  /** Returns true if the other instance is of class ImpenetrableFog. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ImpenetrableFog]

  /** Returns true if the other instance is of class ImpenetrableFog. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[ImpenetrableFog] else false
  }

}
