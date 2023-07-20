package cl.uchile.dcc
package gwent.ability.unit.general

import gwent.ability.general.Ability
import gwent.card.general.Card
import gwent.card.unit.UnitCard

/**
 * Interface used for [[AbstractUnitAbility]], which can apply effects between unit cards. 
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait UnitAbility extends Ability {
  /** Applies the ability's effect of a given new card to the target card. 
   * Depending on the ability, this effect affects the recently placed card or not.
   *
   * @param newCard    The card recently placed on the row that applies the effect.
   * @param targetCard The card that receives the effect. */
  def applyUnitEffect(newCard: UnitCard, targetCard: UnitCard): Unit
  
}
