package cl.uchile.dcc
package gwent.observer

/**
 * Interface used for [[AbstractPlayer]], which can play and draw cards.
 *
 * A player can have a strategy, which determines which card they choose to play on the board.
 * Concretely, a player can play cards one of their cards on the board and draw a new card.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.3
 */
trait Subject {
  def registerObserver(observer: Observer): Unit
  def notifyObservers(): Unit

}
