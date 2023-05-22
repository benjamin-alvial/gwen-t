package cl.uchile.dcc
package gwent.card.unit

/** Represents the unit cards of type close combat.
 *
 * @param name The name of the card.
 * @param strength The base strength of the card.
 * @constructor Creates a new close combat unit card with the specified name and strength.
 * @author benjamin-alvial
 * @since 0.1.0
 * @version 0.1.0
 */
class CloseUnitCard(override val name: String, override val strength: Int) extends UnitCard(name, strength) {

}
