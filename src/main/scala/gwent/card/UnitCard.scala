package cl.uchile.dcc
package gwent.card

class UnitCard(val name: String) extends AbstractCard(name) {
  
  var ability: Option[String] = None

  def this(name: String, ability: String) = {
    this(name)
    this.ability = Some(ability)
  }

  def play(): Unit = {}

  

}
