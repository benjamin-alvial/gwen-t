package cl.uchile.dcc
package gwent.observer

/**
 * Interface used for [[GameController]], which can observe different parts
 * of the board and update when changes are made..
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait Observer {
  /** Updates its state according to the event observed. */
  def update(): Unit
}
