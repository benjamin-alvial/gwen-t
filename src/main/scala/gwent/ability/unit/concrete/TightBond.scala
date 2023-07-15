package cl.uchile.dcc
package gwent.ability.unit.concrete

import gwent.ability.unit.general.AbstractUnitAbility

class TightBond extends AbstractUnitAbility with Equals {
  /** Returns true if the other instance is of class TightBond. */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[TightBond]

  /** Returns true if the other instance is of class TightBond. */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) that.isInstanceOf[TightBond] else false
  }

}
