package cl.uchile.dcc
package gwent.ability.weather.concrete

import gwent.ability.weather.general.AbstractWeatherAbility

class TorrentialRain extends AbstractWeatherAbility with Equals {
  /** Returns true if the other instance is of class TorrentialRain. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[TorrentialRain]

  /** Returns true if the other instance is of class TorrentialRain. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[TorrentialRain] else false
  }

}
