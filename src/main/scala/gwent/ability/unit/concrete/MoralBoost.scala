package cl.uchile.dcc
package gwent.ability.unit.concrete

import gwent.ability.unit.general.AbstractUnitAbility
import gwent.card.general.Card
import gwent.card.unit.UnitCard

/** Ability for cards of type [[UnitCard]].
 * When a new card with this ability is played on a row, it adds +1 to the current strength 
 * of all other cards on the row, not including itself.
 *
 * @constructor Creates a new ability object for Moral Boost.
 * @example
 * {{{
 * val mb = new MoralBoost()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class MoralBoost extends AbstractUnitAbility with Equals {
  /** Applies the Moral Boost effect of a given new card to the target card, adding 1 to its current strength,
   * if it is a different instance of the new card.
   * @param newCard    The card recently placed on the row that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyUnitEffect(newCard: UnitCard, targetCard: UnitCard): Unit = {
    if (!(newCard eq targetCard)) {
      val old_strength: Int = targetCard.getCurrentStrength
      targetCard.setCurrentStrength(old_strength + 1)
    }
  }

  /** Returns true if the other instance is of class MoralBoost. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[MoralBoost]

  /** Returns true if the other instance is of class MoralBoost. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[MoralBoost] else false
  }

}
