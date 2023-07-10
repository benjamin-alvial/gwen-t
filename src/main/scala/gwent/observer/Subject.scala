package cl.uchile.dcc
package gwent.observer

trait Subject {
  def registerObserver(observer: Observer): Unit
  def notifyObservers(): Unit

}
