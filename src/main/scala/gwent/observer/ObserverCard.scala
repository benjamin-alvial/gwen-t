package cl.uchile.dcc
package gwent.observer

import gwent.card.unit.UnitCard

trait ObserverCard {
  def update(newCard: UnitCard): Unit

}
