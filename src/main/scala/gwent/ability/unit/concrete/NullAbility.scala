package cl.uchile.dcc
package gwent.ability.unit.concrete

import gwent.ability.unit.general.AbstractUnitAbility
import gwent.card.general.Card
import gwent.card.unit.UnitCard

/** Ability for cards of type [[UnitCard]]. 
 * It represents an ability that does nothing, used for unit cards with no abilities.
 * When a new card with this ability is played on a row, it maintains the current strength of all cards of the row.
 *
 * @constructor Creates a new ability object for Null Ability.
 * @example
 * {{{
 * val na = new NullAbility()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class NullAbility extends AbstractUnitAbility with Equals {
  /** Applies the Null Ability effect to the target card, doing nothing to its current strength,
   * @param newCard    The card recently placed on the row that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyUnitEffect(newCard: UnitCard, targetCard: UnitCard): Unit = {
    val old_strength: Int = targetCard.getCurrentStrength
    targetCard.setCurrentStrength(old_strength)
  }
  
  /** Returns true if the other instance is of class NullAbility. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[NullAbility]

  /** Returns true if the other instance is of class NullAbility. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[NullAbility] else false
  }

}
