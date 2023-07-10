package cl.uchile.dcc
package gwent.board.general

import gwent.board.unit.{CloseRow, RangedRow, SiegeRow}
import gwent.card.general.Card
import gwent.card.set.CardSet

/** Represents a zone where cards can be played.
 *
 * For all types of zones, for unit cards and weather cards, the zone is composed of a card set.
 * A zone can receive a card to be added to its card set.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
class AbstractZone extends Zone {
  /** The list of cards currently placed on the zone. */
  private val current_cards: CardSet = new CardSet(false)

  /** Returns the card set of the current cards on the board. */
  def getCurrentCards: CardSet = current_cards

  /** Receives a card and places it on its card set. 
   * @param c The card to be played on the zone. */
  def play(c: Card): Unit = current_cards.put(c)
}
