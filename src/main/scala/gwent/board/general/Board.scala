package cl.uchile.dcc
package gwent.board.general

import gwent.card.weather.WeatherCard
import gwent.player.concrete.{ComputerPlayer, UserPlayer}
import cl.uchile.dcc.gwent.board.zone.{WeatherZone, Zone}

/** Represents the physical board on which the game is played.
 *
 * The board has two sides, one for [[UserPlayer]], one for [[ComputerPlayer]],
 * and a zone where a [[WeatherCard]] can be played.
 *
 * @constructor Creates a new board with a side for each player and a zone
 *              for weather cards.
 * @example
 * {{{
 * val board = new Board()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class Board {
  /** Section for the user player. */
  val section_user: Side = new Side()
  /** Section for the computer player. */
  val section_computer: Side = new Side()
  /** Section for the weather cards. */
  private val section_weather: Zone = new WeatherZone()
  
  /** Receives a weather card and calls on the corresponding zone to play it. */
  def receiveWeather(c: WeatherCard): Unit = section_weather.play(c)
}
