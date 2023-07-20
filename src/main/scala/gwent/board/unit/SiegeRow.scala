package cl.uchile.dcc
package gwent.board.unit

import gwent.ability.weather.concrete.{ClearWeather, TorrentialRain}
import gwent.ability.weather.general.WeatherAbility
import gwent.board.general.AbstractZone
import gwent.card.unit.SiegeUnitCard

/** Represents the row where only cards of type [[SiegeUnitCard]] are played.
 * It can be affected by the effect [[TorrentialRain]].
 *
 * @constructor Creates a row unit for siege.
 * @example
 * {{{
 * val siege = new SiegeRow()
 * }}}
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.3
 */
class SiegeRow extends AbstractRow with Equals {
  weatherTypes.addOne(new TorrentialRain())
  
  /** Returns true if the other instance is of class SiegeRow. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeRow]

  /** Returns true if the two instances of SiegeRow share the same current cards. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeRow]
      (this eq other) || (this.getCurrentCards == other.getCurrentCards)
    } else {
      false
    }
  }

}
