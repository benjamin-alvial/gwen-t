package cl.uchile.dcc
package gwent.ability.unit.concrete

import gwent.ability.unit.general.AbstractUnitAbility

class NullAbility extends AbstractUnitAbility with Equals {
  /** Returns true if the other instance is of class NullAbility. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[NullAbility]

  /** Returns true if the other instance is of class NullAbility. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[NullAbility] else false
  }

}
