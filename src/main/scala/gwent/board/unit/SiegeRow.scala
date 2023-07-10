package cl.uchile.dcc
package gwent.board.unit

import gwent.card.unit.SiegeUnitCard
import gwent.board.general.AbstractZone

/** Represents the unit where only cards of type [[SiegeUnitCard]] are played.
 *
 * @constructor Creates a new unit for siege.
 * @example
 * {{{
 * val siege = new SiegeRow()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
class SiegeRow extends AbstractRow with Equals {
  /** Returns true if the other instance is of class SiegeRow. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeRow]

  /** Returns true if the two instances of SiegeRow share the same current cards. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeRow]
      (this eq other) || (this.getCurrentCards == other.getCurrentCards)
    } else {
      false
    }
  }

}
