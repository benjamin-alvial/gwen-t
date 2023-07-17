package cl.uchile.dcc
package gwent.observer

import gwent.card.unit.UnitCard
import gwent.card.weather.WeatherCard

trait ObserverCard {
  def update(newCard: UnitCard): Unit
  
  def updateWeather(newCard: WeatherCard): Unit

}
