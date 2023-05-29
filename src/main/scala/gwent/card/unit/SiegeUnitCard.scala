package cl.uchile.dcc
package gwent.card.unit

import gwent.board.general.Side

/** Represents the unit cards of type siege.
 *
 * @param name The name of the card.
 * @param strength The base strength of the card.
 * @param ability The ability of the unit card.
 * @constructor Creates a new siege unit card with the specified name, strength, and ability.
 * @example
 * {{{
 * val x = new CloseUnitCard("S1", 100, "NULL")
 * val x = new CloseUnitCard("S2", 100, "MB")
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
class SiegeUnitCard(private val name: String, private val strength: Int, private val ability: String) extends AbstractUnitCard(name, strength, ability) {
  /** Sends a message to the given side to receive the card of type siege. */
  def play(s: Side): Unit = s.receiveSiege(this)
}
