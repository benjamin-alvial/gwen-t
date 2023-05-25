package cl.uchile.dcc
package gwent.card.unit

import gwent.board.general.Side

/** Represents the unit cards of type siege.
 *
 * @param name The name of the card.
 * @param strength The base strength of the card.
 * @constructor Creates a new siege unit card with the specified name and strength.
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.1
 */
class SiegeUnitCard(override val name: String, override val strength: Int) extends UnitCard(name, strength) {
  /** Sends a message to the given side to receive the card of type siege. */
  def play(s: Side): Unit = s.receiveSiege(this)
}
