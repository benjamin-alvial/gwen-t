package cl.uchile.dcc
package gwent.ability.weather.concrete

import gwent.ability.weather.general.AbstractWeatherAbility

class ImpenetrableFog extends AbstractWeatherAbility with Equals {
  /** Returns true if the other instance is of class ImpenetrableFog. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ImpenetrableFog]

  /** Returns true if the other instance is of class ImpenetrableFog. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[ImpenetrableFog] else false
  }

}
