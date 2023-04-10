package cl.uchile.dcc
package gwent

trait Card {
  def play(): Unit
  def draw(): Unit
}
