package cl.uchile.dcc
package gwent.card.unit

import gwent.ability.unit.general.UnitAbility
import gwent.card.general.Card
import gwent.observer.ObserverCard

/**
 * Interface used for [[AbstractUnitCard]], which has a current strength that can be changed
 * and an ability of type [[UnitAbility]].
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait UnitCard extends ObserverCard with Card {
  /** Returns the base strength of the card. */
  def getStrength: Int
  /** Returns the current strength of the card. */
  def getCurrentStrength: Int
  /** Sets the current strength of the card to the given value. */
  def setCurrentStrength(x: Int): Unit
  /** Returns the ability of the card. */
  override def getAbility: UnitAbility

}
