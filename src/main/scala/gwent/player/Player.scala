package cl.uchile.dcc
package gwent.player

trait Player {
  def play(): Unit
  def draw(): Unit
}
