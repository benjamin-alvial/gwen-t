package cl.uchile.dcc
package gwent.card.general

import gwent.ability.general.Ability

trait UnitCard extends Card {
  def getAbility(): Ability
  def getName(): String

}
