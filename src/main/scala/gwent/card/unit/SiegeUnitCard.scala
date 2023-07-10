package cl.uchile.dcc
package gwent.card.unit

import gwent.board.general.Side

/** Represents the unit cards of type siege. They can only be placed in Siege zones.
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
 * @version 0.1.4
 */
class SiegeUnitCard(private val name: String, private val strength: Int, private val ability: String) extends AbstractUnitCard(name, strength, ability) with Equals {
  /** Sends a message to the given side to receive the card of type siege. 
   * @param s The side to which the card will be played. */
  def play(s: Side): Unit = s.receiveSiege(this)

  /** Returns true if the other instance is of class SiegeUnitCard. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeUnitCard]

  /** Returns true if the two instances of SiegeUnitCard share the same name, ability, and strength. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeUnitCard]
      (this eq other) || ((this.name == other.getName) && (this.ability == other.getAbility) && (this.strength == other.getStrength))
    } else {
      false
    }
  }
}
