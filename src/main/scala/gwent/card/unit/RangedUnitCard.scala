package cl.uchile.dcc
package gwent.card.unit

/** Represents the unit cards of type ranged.
 *
 * @param name The name of the card.
 * @param strength The base strength of the card.
 * @constructor Creates a new ranged unit card with the specified name and strength.
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class RangedUnitCard(override val name: String, override val strength: Int) extends UnitCard(name, strength) {

}
