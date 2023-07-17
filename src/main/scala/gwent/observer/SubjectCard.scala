package cl.uchile.dcc
package gwent.observer

import gwent.card.unit.UnitCard

trait SubjectCard {
  def registerObserver(observer: ObserverCard): Unit
  def notifyObservers(newCard: UnitCard): Unit

}
