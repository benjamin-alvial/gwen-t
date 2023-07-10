package cl.uchile.dcc
package gwent.board.unit

import gwent.card.unit.CloseUnitCard
import gwent.board.general.AbstractZone

/** Represents the unit where only cards of type [[CloseUnitCard]] are played.
 *
 * @constructor Creates a new unit for close combat.
 * @example
 * {{{
 * val close = new CloseRow()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
class CloseRow extends AbstractRow with Equals {
  /** Returns true if the other instance is of class CloseRow. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CloseRow]

  /** Returns true if the two instances of CloseRow share the same current cards. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CloseRow]
      (this eq other) || (this.getCurrentCards == other.getCurrentCards)
    } else {
      false
    }
  }

}
