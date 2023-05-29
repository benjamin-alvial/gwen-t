package cl.uchile.dcc
package gwent.card.unit

import gwent.board.general.Side

/** Represents the unit cards of type ranged.
 *
 * @param name The name of the card.
 * @param strength The base strength of the card.
 * @param ability The ability of the unit card.
 * @constructor Creates a new ranged unit card with the specified name, strength, and ability.
 * @example
 * {{{
 * val x = new RangedUnitCard("R1", 100, "NULL")
 * val x = new RangedUnitCard("R2", 100, "MB")
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
class RangedUnitCard(private val name: String, private val strength: Int, private val ability: String) extends AbstractUnitCard(name, strength, ability) {
  /** Sends a message to the given side to receive the card of type ranged. */
  def play(s: Side): Unit = s.receiveRanged(this)

}
