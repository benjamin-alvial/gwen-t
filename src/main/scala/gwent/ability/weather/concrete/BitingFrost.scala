package cl.uchile.dcc
package gwent.ability.weather.concrete

import gwent.ability.weather.general.AbstractWeatherAbility

class BitingFrost extends AbstractWeatherAbility with Equals {
  /** Returns true if the other instance is of class BitingFrost. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[BitingFrost]

  /** Returns true if the other instance is of class BitingFrost. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[BitingFrost] else false
  }

}
