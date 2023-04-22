package cl.uchile.dcc
package gwent.card

class UnitCard(val name: String) extends AbstractCard(name) with Equals {
  
  var ability: Option[String] = None

  override def canEqual(that: Any): Boolean = that.isInstanceOf[UnitCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[UnitCard]
      (this eq other) || ((this.name == other.name) && (this.ability == other.ability))
    } else {
      false
    }
  }

  def this(name: String, ability: String) = {
    this(name)
    this.ability = Some(ability)
  }

  def play(): Unit = {}

  

}
