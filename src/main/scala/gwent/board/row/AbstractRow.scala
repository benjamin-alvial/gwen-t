package cl.uchile.dcc
package gwent.board.row
import gwent.card.general.Card
import gwent.card.set.CardSet
import cl.uchile.dcc.gwent.board.zone.Zone


/** Represents one of the three rows on each side of the board.
 *
 * The row can be a [[CloseRow]], [[RangedRow]], or [[SiegeRow]].
 * 
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class AbstractRow extends Zone {
  /** The list of cards currently placed on row. */
  private val current_cards: CardSet = new CardSet(false)
  
  def play(c: Card): Unit = current_cards.put(c)
}
