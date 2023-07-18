package cl.uchile.dcc
package gwent.board.unit

import gwent.ability.weather.concrete.ClearWeather
import gwent.ability.weather.general.WeatherAbility
import gwent.board.general.AbstractZone
import gwent.card.general.Card
import gwent.card.unit.UnitCard
import gwent.card.weather.WeatherCard
import gwent.observer.{ObserverCard, SubjectCard}

import scala.collection.mutable.ListBuffer

/** Represents one of the three rows on each side of the board.
 *
 * It can be a [[CloseRow]], [[RangedRow]], or [[SiegeRow]].
 * All rows play cards on their zones in the same manner, adding to the current card set.
 * Cards are also added to a collection of observers, which are notified to update when a new card is added.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.3
 */
abstract class AbstractRow extends AbstractZone with SubjectCard {
  /** The ListBuffer of unit cards that have been subscribed to this row. 
   * When a new card shows up, this list will be notified. */
  private val observerCollection: ListBuffer[ObserverCard] = ListBuffer()
  /** The possible weather abilities that affect cards on this row. 
   * By default, clear weather is included. */
  val weatherTypes: ListBuffer[WeatherAbility] = ListBuffer(new ClearWeather())

  /** Registers a new observer to the collection.
   *
   * @param observer The new unit card that becomes observer. */
  def registerObserver(observer: ObserverCard): Unit = {
    observerCollection.addOne(observer)
  }

  /** Notifies all the unit cards observers of the zone to update 
   * due to the unit card that has been played.
   *
   * @param newCard The unit card that was played. */
  def notifyObservers(newCard: UnitCard): Unit = {
    for (o <- observerCollection) {
      o.update(newCard)
    }
  }

  /** Notifies all the unit cards observers of the zone to update 
   * due to the weather card that has been played.
   *
   * @param newCard The weather card that was played. */
  private def notifyObserversWeather(newCard: WeatherCard): Unit = {
    for (o <- observerCollection) {
      o.updateWeather(newCard)
    }
  }

  /** Plays a unit card on this row, registers it as an observer,
   * and notifies the rest of the cards that a new card has arrived.
   *
   * @param c The unit card that was played. */
  def play(c: UnitCard): Unit = {
    getCurrentCards.put(c)
    registerObserver(c)
    notifyObservers(c)
  }

  /** Calls to notify observers only if this zone accepts the given weather card's effect.
   *
   * @param c The weather card that was played. */
  def updateWeather(c: WeatherCard): Unit = {
    if (weatherTypes.contains(c.getAbility)) {
      notifyObserversWeather(c)
    }
  }
  
  // Future: implement method to get the total strength of the cards in the row, useful to implement Computer's strategy.
}
