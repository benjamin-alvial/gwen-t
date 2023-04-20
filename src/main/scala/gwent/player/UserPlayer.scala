package cl.uchile.dcc
package gwent.player

import gwent.card.CardSet

class UserPlayer(name: String) extends AbstractPlayer(name) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[UserPlayer]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[UserPlayer]
      (this eq other) || (this.name == other.name)
    } else {
      false
    }
  }

  def play(): Unit = {
    getHand().take()
  } // Strategy to be implemented.

}
