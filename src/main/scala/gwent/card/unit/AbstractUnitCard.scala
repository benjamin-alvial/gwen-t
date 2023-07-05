package cl.uchile.dcc
package gwent.card.unit

import cl.uchile.dcc.gwent.ability.general.Ability
import cl.uchile.dcc.gwent.ability.unit.concrete.TightBond
import cl.uchile.dcc.gwent.card.general.{AbstractCard, UnitCard}

/** Represents the unit cards.
 *
 * A unit card is placed on one of three rows to accumulate strength.
 * Every unit card has an ability, but if it doesn't have an effect, it will be the null ability.
 *
 * @param name The name of the unit card.
 * @param strength The base strength of the unit card. 
 * @param ability The ability of the unit card.
 * @constructor Creates a new unit card with the specified name, strength, and ability.
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.4
 */
abstract class AbstractUnitCard(private val name: String, private val strength: Int, private val ability: Ability) extends AbstractCard(name, ability) {

  /** Returns the strength of the unit card. */
  def getStrength(): Int = strength

  var currentStrength: Int = strength

  def update(c: UnitCard) = {
    // Horrible design. To be changed in the future.
    if (c.getAbility().isInstanceOf[TightBond] && this.getName() == c.getName()) {
      currentStrength = currentStrength * 2
    }
  }
  

  
}
