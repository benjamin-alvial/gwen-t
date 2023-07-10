package cl.uchile.dcc
package gwent.board.unit

import gwent.board.general.AbstractZone

/** Represents one of the three rows on each side of the board.
 *
 * It can be a [[CloseRow]], [[RangedRow]], or [[SiegeRow]].
 * All rows play cards on their zones in the same manner, adding to the current card set.
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.1
 */
abstract class AbstractRow extends AbstractZone {
  // Future: implement method to get the total strength of the cards in the row, useful to implement Computer's strategy.
}
