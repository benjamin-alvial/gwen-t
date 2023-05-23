package cl.uchile.dcc
package gwent.player.concrete

import gwent.card.set.CardSet
import gwent.player.general.AbstractPlayer

/** Represents the computer playing the game.
 *
 * The computer player is automatically controlled by the computer.
 *
 * @param name The name of the player.
 *
 * @constructor Creates a new computer player with the specified name.
 *
 * @example
 * {{{
 * val cpu = new ComputerPlayer("CPU")
 * cpu.play()
 * }}}
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.1
 */
class ComputerPlayer(name: String) extends AbstractPlayer(name) with Equals {

  /** Returns true if the other instance is of class ComputerPlayer. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ComputerPlayer]

  /** Returns true if the two instances of ComputerPlayer share the same name. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[ComputerPlayer]
      (this eq other) || (this.name == other.name)
    } else {
      false
    }
  }
  
  /** Removes a random card from the hand. */
  def strategy(): Unit = {
    getHand().take()
  }
}
