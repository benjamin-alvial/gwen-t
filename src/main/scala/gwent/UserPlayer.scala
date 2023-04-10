package cl.uchile.dcc
package gwent

class UserPlayer(name_input: String) extends Player {
  val name: String = name_input
  var gem_counter: Int = 2
  val deck: CardSet = new CardSet() // Initially with 25 cards.
  val hand: CardSet = new CardSet(10) // Choose 10.

  def play_card(): Unit = ???

  def draw_card(): Unit = ???
}
