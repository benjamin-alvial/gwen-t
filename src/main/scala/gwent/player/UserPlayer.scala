package cl.uchile.dcc
package gwent.player

import gwent.card.CardSet

/** Represents the user playing the game.
 *
 * The user player is controlled by a person.
 *
 * @param name The name of the player.
 *
 * @constructor Creates a new user player with the specified name.
 *
 * @example
 * {{{
 * val user = new UserPlayer("Kermit")
 * user.play()
 * }}}
 * 
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class UserPlayer(name: String) extends AbstractPlayer(name) with Equals {

  /** Returns true if the other instance is of class UserPlayer. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[UserPlayer]

  /** Returns true if the two instances of UserPlayer share the same name. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[UserPlayer]
      (this eq other) || (this.name == other.name)
    } else {
      false
    }
  }

  /** Removes a random card from the hand. */
  def play(): Unit = {
    getHand().take()
  } // Strategy to be implemented.

}
