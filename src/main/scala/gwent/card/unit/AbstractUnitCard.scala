package cl.uchile.dcc
package gwent.card.unit

import cl.uchile.dcc.gwent.card.general.AbstractCard

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
 * @version 0.1.3
 */
abstract class AbstractUnitCard(private val name: String, private val strength: Int, private val ability: String) extends AbstractCard(name, ability) with Equals {

  /** Returns the strength of the unit card. */
  def getStrength(): Int = strength
  
  /** Returns true if the other instance is of class AbstractUnitCard. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractUnitCard]

  /** Returns true if the two instances of AbstractUnitCard share the same name and ability. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbstractUnitCard]
      (this eq other) || ((this.name == other.name) && (this.ability == other.ability) && (this.strength == other.strength))
    } else {
      false
    }
  }
  
}
