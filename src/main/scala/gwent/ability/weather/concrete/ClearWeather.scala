package cl.uchile.dcc
package gwent.ability.weather.concrete

import gwent.ability.weather.general.AbstractWeatherAbility

class ClearWeather extends AbstractWeatherAbility with Equals {
  /** Returns true if the other instance is of class ClearWeather. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ClearWeather]

  /** Returns true if the other instance is of class ClearWeather. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[ClearWeather] else false
  }

}
