package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class UserPlaysUnlimited extends State {
  override def play_one_user(): Unit = {}
  override def end_round(): Unit = this.changeState(new EndRound())
  
  override def isUserPlaysUnlimited = true

}
