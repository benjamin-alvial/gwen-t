package cl.uchile.dcc
package gwent.observer

/**
 * Interface used for [[AbstractPlayer]], which can subscribe the game controller as observer
 * and notify it when certain changes have happened.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.3
 */
trait Subject {
  /** Adds the given observer to the observer collection. */
  def registerObserver(observer: Observer): Unit
  /** Notifies all the observers in the observer collection to update. */
  def notifyObservers(): Unit

}
