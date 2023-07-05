package cl.uchile.dcc
package gwent.card.unit

import gwent.board.general.Side

/** Represents the unit cards of type close combat. They can only be placed in Close combat zones.
 *
 * @param name The name of the card.
 * @param strength The base strength of the card.
 * @param ability The ability of the unit card.
 * @constructor Creates a new close combat unit card with the specified name, strength, and ability.
 * @example
 * {{{
 * val x = new CloseUnitCard("C1", 100, "NULL")
 * val x = new CloseUnitCard("C2", 100, "MB")
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.3
 */
class CloseUnitCard(private val name: String, private val strength: Int, private val ability: Ability) extends AbstractUnitCard(name, strength, ability) with Equals {
  /** Sends a message to the given side to receive the card of type close combat. 
   * @param s The side to which the card will be played. */
  def play(s: Side): Unit = s.receiveClose(this)

  /** Returns true if the other instance is of class CloseUnitCard. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CloseUnitCard]

  /** Returns true if the two instances of CloseUnitCard share the same name, ability, and strength. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CloseUnitCard]
      (this eq other) || ((this.name == other.getName()) && (this.ability == other.getAbility()) && (this.strength == other.getStrength()))
    } else {
      false
    }
  }

}
