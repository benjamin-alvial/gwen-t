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
  
  def getStrength: Int
  def getCurrentStrength: Int

  def setCurrentStrength(x: Int): Unit

  override def getAbility: UnitAbility

}
