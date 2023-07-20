package cl.uchile.dcc
package gwent.ability.unit.concrete

import gwent.ability.unit.general.AbstractUnitAbility
import gwent.card.general.Card
import gwent.card.unit.UnitCard

/** Ability for cards of type [[UnitCard]]. 
 * When a new card with this ability is played on a row, it doubles the current strength of all other cards 
 * on the row with the same name, including itself.
 *
 * @constructor Creates a new ability object for Tight Bond.
 * @example
 * {{{
 * val tb = new TightBond()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class TightBond extends AbstractUnitAbility with Equals {
  /** Applies the Tight Bond effect of a given new card to the target card, doubling its current strength 
   * if it shares names with the new card. The target card can be the same instance as the new card.
   * @param newCard    The card recently placed on the row that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyUnitEffect(newCard: UnitCard, targetCard: UnitCard): Unit = {
    if (newCard.getName == targetCard.getName) {
      val old_strength: Int = targetCard.getCurrentStrength
      targetCard.setCurrentStrength(old_strength * 2)
    }
  }
  
  /** Returns true if the other instance is of class TightBond. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[TightBond]

  /** Returns true if the other instance is of class TightBond. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[TightBond] else false
  }

}
