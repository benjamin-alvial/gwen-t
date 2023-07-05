package cl.uchile.dcc
package gwent.states.concrete

import gwent.states.general.State

class UserPlaysUnlimited extends State {
  override def play_one_user() = {}
  override def end_round() = this.changeState(new EndRound())
  override def isUserPlaysUnlimited() = true

}
