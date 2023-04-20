package cl.uchile.dcc
package gwent.player

import gwent.card.CardSet

class ComputerPlayer(name: String) extends AbstractPlayer(name) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ComputerPlayer]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[ComputerPlayer]
      (this eq other) || (this.name == other.name)
    } else {
      false
    }
  }
  
  def play(): Unit = {
    getHand().take()
  } // Strategy to be implemented.
  
}
