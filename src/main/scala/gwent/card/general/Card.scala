package cl.uchile.dcc
package gwent.card.general

import gwent.ability.general.Ability
import gwent.board.general.Side
import gwent.card.general.AbstractCard

/**
 * Interface used for [[AbstractCard]], which can be played. 
 *
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
trait Card {
  /** Places the card on the board to carry out its effects and add strength to its row.
   * The target zone for the card is resolved by its type. 
   * @param side The side onto which the card will be played. */
  def play(side: Side): Unit

  /** Returns the name of the card. */
  def getName: String

  /** Returns the ability of the card. */
  def getAbility: Ability
}
