package cl.uchile.dcc
package gwent.card.general

import gwent.card.general.AbstractCard

import cl.uchile.dcc.gwent.board.general.Side

/**
 * Interface used for [[AbstractCard]], which can be played. 
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.1
 */
trait Card {
  /** Places the card on the board to carry out its effects and add strength to its row.
   * The target zone for the card is resolved by its type. 
   * @param side The side onto which the card will be played. */
  def play(side: Side): Unit
}
