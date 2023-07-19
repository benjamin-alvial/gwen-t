package cl.uchile.dcc
package gwent.observer

import gwent.card.unit.UnitCard

/**
 * Interface used for [[AbstractRow]], which can subscribe the cards in it and
 * notify them when a new cards has arrived.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.3
 */
trait SubjectCard {
  /** Adds the given observer (card) to the observer collection. */
  def registerObserver(observer: ObserverCard): Unit
  /** Notifies all the cards in the observer collection to update. */
  def notifyObservers(newCard: UnitCard): Unit

}
