package cl.uchile.dcc
package gwent.ability.unit.concrete

import gwent.ability.unit.general.AbstractUnitAbility

class MoralBoost extends AbstractUnitAbility with Equals {
  /** Returns true if the other instance is of class MoralBoost. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[MoralBoost]

  /** Returns true if the other instance is of class MoralBoost. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[MoralBoost] else false
  }

}
