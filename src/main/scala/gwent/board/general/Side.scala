package cl.uchile.dcc
package gwent.board.general

import gwent.board.row.{CloseRow, RangedRow, SiegeRow}
import gwent.card.unit.{CloseUnitCard, RangedUnitCard, SiegeUnitCard}
import gwent.card.weather.WeatherCard
import gwent.player.concrete.{ComputerPlayer, UserPlayer}
import cl.uchile.dcc.gwent.board.zone.Zone

/** Represents the physical side which a player has control over.
 *
 * The side belongs to either [[UserPlayer]] or [[ComputerPlayer]].
 * It is divided into three rows: [[CloseRow]], [[RangedRow]], [[SiegeRow]].
 *
 * @constructor Creates a new side with three rows.
 *              
 * @example
 * {{{
 * val side = new Side()
 * }}}
 * 
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.2
 */
class Side(b: Board) {
  /** Zone for the close combat cards. */
  val zone_close: CloseRow = new CloseRow()
  /** Zone for the ranged cards. */
  val zone_ranged: RangedRow = new RangedRow()
  /** Zone for the siege cards. */
  val zone_siege: SiegeRow = new SiegeRow()
  /** Board where the side belongs to. */
  val board: Board = b

  /** Receives a close combat card and calls on the corresponding zone to play it. */
  def receiveClose(c: CloseUnitCard): Unit = zone_close.play(c)

  /** Receives a ranged card and calls on the corresponding zone to play it. */
  def receiveRanged(c: RangedUnitCard): Unit = zone_ranged.play(c)

  /** Receives a siege card and calls on the corresponding zone to play it. */
  def receiveSiege(c: SiegeUnitCard): Unit = zone_siege.play(c)

}
