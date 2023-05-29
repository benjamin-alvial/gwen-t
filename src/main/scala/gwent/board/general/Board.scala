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
 * @version 0.1.1
 */
class Board {
  /** Section for the user player. */
  private val user_side: Side = new Side(this)
  /** Section for the computer player. */
  private val computer_side: Side = new Side(this)
  /** Section for the weather cards. */
  private val weather_zone: WeatherZone = new WeatherZone()
  
  /** Receives a weather card and calls on the corresponding zone to play it. */
  def receiveWeather(c: WeatherCard): Unit = weather_zone.play(c)

  /** Returns the side of the board that belongs to the User player. */
  def getUserSide(): Side = user_side

  /** Returns the side of the board that belongs to the Computer player. */
  def getComputerSide(): Side = computer_side

  /** Returns the weather zone of the board. */
  def getWeatherZone(): WeatherZone = weather_zone
  
}
