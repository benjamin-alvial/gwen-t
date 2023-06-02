# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

# Tarea 2

Para implementar el tablero, se ha pensado en cómo se vería este físicamente. De esta manera, resulta natural que el tablero, de tipo Board, se componga de dos lados de tipo Side y una zona común donde se juegan cartas de clima, de tipo WeatherZone. A su vez, cada lado se compone de tres zonas de tipos CloseRow, RangedRow y SiegeRow para jugar las cartas de unidad. Los lugares donde se juegan cartas resultan tener comportamientos similares, por lo que se crea una interfaz Zone que representa una zona donde puede ser jugada una carta. Asimismo, hay comportamientos cuyas implementaciones son comunes para las tres zonas, por lo que se crea una clase abstracta AbstractZone. La estructura básica de una zona es simplemente un conjunto de cartas, un CardSet, al que se le pueden agregar y quitar cartas.

Para implementar la funcionalidad de jugar una carta, se ha pensado en cómo se implementará a futuro el controlador. Si se espera un input de un usuario para jugar una carta, es lógico que sea el jugador quien juega una carta sobre su lado del tablero. Por lo tanto, se ha optado por que los jugadores tengan un lado de tablero, de tipo Side. Así, al llamar al método con el que el jugador juega una carta determinada, se puede enviar un mensaje a la carta para que se juegue en el lado de tablero dado. Como la carta es de cierto tipo según su clase, puede enviarle un mensaje al lado del tablero para que la juegue en la zona que le corresponde según su tipo. De esta forma, se resuelve su ubicación sin pattern matching, con los métodos receiveClose, receiveSiege y receiveRanged. En el caso de cartas de clima, el funcionamiento es similar, solo que se debe acceder al tablero al que pertenece cada lado. Para testear la funcionalidad pedida, se ha revisado que las ocurrencias de una carta en una determinada zona aumenten si se juega en este zona.

Se han utilizado algunas excepciones para evitar comportamientos indeseados. La implementación completa de estas excepciones depende de cómo se implemente a futuro la lógica del juego en el controlador. Por ahora, se crearon excepciones para: evitar que el contador de gemas se vuelva negativo, evitar que se quiten gemas cuando ya no quedan, evitar que se jueguen cartas si no se poseen o si simplemente no hay cartas que sacar. Todas estas excepciones han sido testeadas.

Todos los atributos que requerían ser accedidos desde fuera de las clases donde estaban definidos tuvieron asociados la creación de un getter. Asimismo, se crearon setters para atributos que puedan ser asignados, ya sea porque cambian durante el juego (contadores de gemas) o para su correcta inicialización (asociarle a un jugador un lado del tablero, que ha sido definido fuera su contexto).

Se han corregido otros aspectos del diseño. Con respecto a las cartas, se ha refactorizado el código, generando una clase abstracta desde la cual extienden clases para los tres tipos de cartas de unidad, CloseUnitCard, RangedUnitCard y SiegeUnitCard. Por lo tanto, se ha trasladado la sobreescritura del método equals a estas clases concretas. Además, se ha cambiado la habilidad (aún como String, a ser modificado) de las cartas de unidad por una habilidad genérica. En lugar de un Option, se utilizará el patrón de diseño de objeto nulo para resolver los casos donde una carta con habilidad nula ejerce un efecto (no hará nada). De esta manera, toda carta tiene una habilidad.
