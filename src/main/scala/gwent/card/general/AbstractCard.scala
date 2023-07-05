package cl.uchile.dcc
package gwent.card.general

import gwent.card.unit.AbstractUnitCard
import gwent.card.weather.WeatherCard

import cl.uchile.dcc.gwent.ability.general.Ability

/** Represents a card.
 *
 * The card can be an [[AbstractUnitCard]] or [[WeatherCard]].
 * All cards have a name and an ability. In the case of unit cards with no effect, the ability is the null ability.
 *
 * @param name The name of the card.
 * @param ability The ability of the card.
 * @constructor Creates a new card with the specified name.
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.1
 */
abstract class AbstractCard(private val name: String, private val ability: Ability) extends Card {
  /** Returns the name of the card. */
  def getName(): String = name

  /** Returns the ability of the card. */
  def getAbility(): Ability = ability
}
