package cl.uchile.dcc
package gwent.board.unit

import gwent.card.unit.RangedUnitCard
import gwent.board.general.AbstractZone

/** Represents the unit where only cards of type [[RangedUnitCard]] are played.
 *
 * @constructor Creates a new unit for ranged.
 * @example
 * {{{
 * val ranged = new RangedRow()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
class RangedRow extends AbstractRow with Equals {
  /** Returns true if the other instance is of class RangedRow. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangedRow]

  /** Returns true if the two instances of RangedRow share the same current cards. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangedRow]
      (this eq other) || (this.getCurrentCards == other.getCurrentCards)
    } else {
      false
    }
  }

}
