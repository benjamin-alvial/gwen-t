package cl.uchile.dcc
package gwent.ability.weather.general

import gwent.ability.general.Ability
import gwent.card.unit.UnitCard
import gwent.card.weather.WeatherCard

/**
 * Interface used for [[AbstractWeatherAbility]], which can apply effects to unit cards. 
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait WeatherAbility extends Ability {
  /** Applies the ability's weather effect of a given new card to the target card.
   *
   * @param newCard    The card recently placed on the row that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyWeatherEffect(newCard: WeatherCard, targetCard: UnitCard): Unit

}
