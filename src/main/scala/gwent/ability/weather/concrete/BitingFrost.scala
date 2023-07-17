package cl.uchile.dcc
package gwent.ability.weather.concrete

import gwent.ability.weather.general.AbstractWeatherAbility
import gwent.card.unit.UnitCard
import gwent.card.weather.WeatherCard

/** Ability for cards of type [[WeatherCard]].
 * When a new card with this ability is played on the weather zone, it changes the current strength 
 * of all close combat cards to 1, on both sides of the board.
 *
 * @constructor Creates a new ability object for Biting Frost.
 * @example
 * {{{
 * val bf = new BitingFrost()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class BitingFrost extends AbstractWeatherAbility with Equals {
  /** Applies the Biting Frost effect of a given new card to the target card of type close combat, 
   * overriding its current strength to 1.
   * @param newCard    The card recently placed on the weather zone that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyWeatherEffect(newCard: WeatherCard, targetCard: UnitCard): Unit = {
    targetCard.setCurrentStrength(1)
  }

  /** Returns true if the other instance is of class BitingFrost. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[BitingFrost]

  /** Returns true if the other instance is of class BitingFrost. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[BitingFrost] else false
  }

}
