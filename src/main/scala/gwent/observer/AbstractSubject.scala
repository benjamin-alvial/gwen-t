package cl.uchile.dcc
package gwent.observer

import scala.collection.mutable.ListBuffer

class AbstractSubject extends Subject {
  val observerCollection: ListBuffer[Observer] = ListBuffer()
  def registerObserver(observer: Observer): Unit = {
    observerCollection.addOne(observer)
  }

  def notifyObservers(): Unit = {
    for (o <- observerCollection) {
      o.update()
    }
  }

}
