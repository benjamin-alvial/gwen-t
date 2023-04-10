package cl.uchile.dcc
package gwent

trait Player {
  val name: String
  var gem_counter: Int
  val deck: CardSet
  val hand: CardSet
  def play_card(): Unit
  def draw_card(): Unit
}
