package cl.uchile.dcc
package gwent.board.unit

import gwent.board.general.AbstractZone

import cl.uchile.dcc.gwent.ability.general.Ability
import cl.uchile.dcc.gwent.card.general.{Card, UnitCard}
import cl.uchile.dcc.gwent.card.unit.AbstractUnitCard
import cl.uchile.dcc.gwent.observe.Observer

import scala.collection.mutable.ListBuffer

/** Represents one of the three rows on each side of the board.
 *
 * It can be a [[CloseRow]], [[RangedRow]], or [[SiegeRow]].
 * All rows play cards on their zones in the same manner, adding to the current card set.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.1
 */
abstract class AbstractRow extends AbstractZone {
  // Future: implement method to get the total strength of the cards in the row, useful to implement Computer's strategy.

  val observers: ListBuffer[Observer] = ListBuffer()

  def registerObserver(o: Observer): Unit = observers += o

  def notifyObservers(response: UnitCard) = {
    for (o <- observers) {
      o.update(this, response)
    }
  }
  
  def play(c: UnitCard): Unit = {
    getCurrentCards().put(c)
    registerObserver(c)
    notifyObservers(c)
  }
}
