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
  private val close_zone: CloseRow = new CloseRow()
  /** Zone for the ranged cards. */
  private val ranged_zone: RangedRow = new RangedRow()
  /** Zone for the siege cards. */
  private val siege_zone: SiegeRow = new SiegeRow()
  /** Board where the side belongs to. */
  private val board: Board = b

  /** Receives a close combat card and calls on the corresponding zone to play it. */
  def receiveClose(c: CloseUnitCard): Unit = close_zone.play(c)

  /** Receives a ranged card and calls on the corresponding zone to play it. */
  def receiveRanged(c: RangedUnitCard): Unit = ranged_zone.play(c)

  /** Receives a siege card and calls on the corresponding zone to play it. */
  def receiveSiege(c: SiegeUnitCard): Unit = siege_zone.play(c)

  /** Returns the close combat zone of the side. */
  def getCloseZone(): CloseRow = close_zone

  /** Returns the ranged zone of the side. */
  def getRangedZone(): RangedRow = ranged_zone

  /** Returns the siege zone of the side. */
  def getSiegeZone(): SiegeRow = siege_zone

  /** Returns the board to where the side belongs. */
  def getBoard(): Board = board

}
