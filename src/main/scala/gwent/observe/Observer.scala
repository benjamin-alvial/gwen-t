package cl.uchile.dcc
package gwent.observe

import gwent.board.general.Zone

import cl.uchile.dcc.gwent.card.general.UnitCard
import cl.uchile.dcc.gwent.card.unit.AbstractUnitCard

trait Observer {
  //Horrible design abstract can't be type.
  def update(o: Zone, arg: UnitCard): Unit
}
