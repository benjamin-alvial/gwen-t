package cl.uchile.dcc
package gwent.board.general

import gwent.card.weather.WeatherCard
import gwent.player.concrete.{ComputerPlayer, UserPlayer}
import gwent.board.weather.WeatherZone

/** Represents the physical board on which the game is played.
 *
 * The board has two sides, one for [[UserPlayer]], one for [[ComputerPlayer]],
 * and a weather zone where a [[WeatherCard]] can be played.
 *
 * @constructor Creates a new board with a side for each player and a weather zone
 *              for weather cards.
 * @example
 * {{{
 * val board = new Board()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.4
 */
class Board extends Equals {
  /** Section for the user player. */
  private val user_side: Side = new Side(this)
  /** Section for the computer player. */
  private val computer_side: Side = new Side(this)
  /** Section for the weather cards. */
  private val weather_zone: WeatherZone = new WeatherZone()

  /** Returns the side of the board that belongs to the User player. */
  def getUserSide: Side = user_side

  /** Returns the side of the board that belongs to the Computer player. */
  def getComputerSide: Side = computer_side

  /** Returns the weather zone of the board. */
  def getWeatherZone: WeatherZone = weather_zone

  /** Receives a weather card and calls on the corresponding weather zone to play it,
   * also notifying all cards on both sides of the board that it has been played. 
   *
   * @param c The card to be played on weather zone. */
  def receiveWeather(c: WeatherCard): Unit = {
    weather_zone.play(c)
    user_side.updateWeather(c)
    computer_side.updateWeather(c)
  }

  /** Returns true if the other instance is of class Board. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Board]

  /** Returns true if the two instances of Board share the same sides and weather zone. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Board]
      (this eq other) || (this.getUserSide == other.getUserSide && this.getComputerSide == other.getComputerSide && this.getWeatherZone == other.getWeatherZone)
    } else {
      false
    }
  }
  
}
