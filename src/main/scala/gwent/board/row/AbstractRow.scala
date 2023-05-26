package cl.uchile.dcc
package gwent.board.row
import gwent.card.general.Card
import gwent.card.set.CardSet
import cl.uchile.dcc.gwent.board.zone.Zone


/** Represents one of the three rows on each side of the board.
 *
 * The row can be a [[CloseRow]], [[RangedRow]], or [[SiegeRow]].
 * All rows play cards on their zones in the same manner, adding to the current card set.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.1
 */
class AbstractRow extends Zone {
  /** The list of cards currently placed on row. */
  private val current_cards: CardSet = new CardSet(false)

  /** Receives a unit card and places it on its corresponding row. */
  def play(c: Card): Unit = current_cards.put(c)

  /** Returns the card set of the current cards on the board. */
  def getCurrentCards(): CardSet = current_cards
  
}
