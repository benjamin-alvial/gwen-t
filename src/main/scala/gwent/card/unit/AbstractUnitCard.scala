package cl.uchile.dcc
package gwent.card.unit

import cl.uchile.dcc.gwent.card.general.AbstractCard

/** Represents the unit cards.
 *
 * A unit card is placed on one of three rows to accumulate strength. A unit card may have an ability.
 *
 * @param name The name of the unit card.
 * @param strength The base strength of the unit card.             
 * @constructor Creates a new unit card with the specified name and strength.              
 * @example
 * {{{
 * val u_card = new AbstractUnitCard("C1", 100)
 * val U_card_effect = new AbstractUnitCard("C2", 100, "MB")
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
abstract class AbstractUnitCard(val name: String, val strength: Int) extends AbstractCard(name) with Equals {

  /** The ability of the card. */
  private var ability: Option[String] = None // Abilities are strings only for now.

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

  /** Creates a new unit card with the specified name and ability. */
  def this(name: String, strength: Int, ability: String) = {
    this(name, strength)
    this.ability = Some(ability)
  }
  
}
