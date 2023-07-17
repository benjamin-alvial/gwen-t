package cl.uchile.dcc
package gwent.card.unit

import gwent.ability.unit.general.UnitAbility
import gwent.card.general.AbstractCard
import gwent.card.weather.WeatherCard

/** Represents the unit cards.
 *
 * A unit card is placed on one of three rows to accumulate strength,
 * which begins at the given base strength.
 * Every unit card has an ability, but if it doesn't have an effect, it will be the null ability.
 *
 * @param name The name of the unit card.
 * @param strength The base strength of the unit card. 
 * @param ability The ability of the unit card.
 * @constructor Creates a new unit card with the specified name, strength, and ability.
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.8
 */
abstract class AbstractUnitCard(private val name: String, private val strength: Int, private val ability: UnitAbility)
  extends AbstractCard(name, ability) with UnitCard {
  /** The current strength of a unit card.
   * It is initially the base strength of the card and changes when other cards are placed on the board/ */
  private var current_strength = strength

  /** Returns the base strength of the unit card. */
  def getStrength: Int = strength

  override def getAbility: UnitAbility = ability

  /** Returns the current strength of the unit card. */
  def getCurrentStrength: Int = current_strength

  def setCurrentStrength(x: Int): Unit = {
    current_strength = x
  }

  /** When a new card is placed on target card (this)'s zone,
   * update sends a message to the ability to apply its effect to this.
   * 
   * @param newCard The card recently placed on the row that applies the effect. */
  def update(newCard: UnitCard): Unit = {
    newCard.getAbility.applyUnitEffect(newCard, this)
  }

  /** When a new weather card is placed on the weather zone,
   * update sends a message to the ability to apply its effect to this.
   *
   * @param newCard The card recently placed on the row that applies the effect. */
  def updateWeather(newCard: WeatherCard): Unit = {
    newCard.getAbility.applyWeatherEffect(newCard, this)
  }

}
