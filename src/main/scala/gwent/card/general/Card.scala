package cl.uchile.dcc
package gwent.card.general

import gwent.card.general.AbstractCard

/**
 * Interface used for [[AbstractCard]], which can be played. 
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
trait Card {
  /** Places the card on the board to carry out its effects and add strength to its row. */
  def play(): Unit
}
