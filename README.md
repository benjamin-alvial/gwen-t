# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

# Tarea 1

En términos generales, la funcionalidad hasta ahora se reparte en dos paquetes: player y card.

Para representar a los jugadores, se crean dos clases, ComputerPlayer y UserPlayer, que representan a un jugador de computadora y a un jugador humano, respectivamente. Las clases son distintas pues las estrategias de juego son distintas: una es automática y la otra requiere de _inputs_ del usuario. Sin embargo, las dos clases comparten funcionalidades, como sus estados (tienen gemas, mazo y mano) y métodos (perder una gema), por lo que se crea la clase abstracta AbstractPlayer de la que se hereda para no repetir el código de estas funcionalidades. Finalmente, se crea una interfaz que representa un jugador, y es implementada por la clase abstracta. Esta sirve para abstraer el comportamiento de un jugador y para referirse al tipo Player. El método _equals_ se implementa solamente como igualdad de nombres, pues si, por ejemplo, un jugador pierde una gema, no deja de ser el mismo jugador.

Para representar a las cartas, se crean dos clases, UnitCard y WeatherCard, que representan a una carta de unidad y de clima, respectivamente. Las clases son distintas pues tienen aspectos que difieren: una carta de clima siempre tiene una habilidad, pero una carta de unidad solamente a veces la tiene. Es importante recalcar que se crea la variable habilidad como tipo String solo por ahora (es un mal diseño, no se le puede asignar responsabilidad a un string y dificulta la creación y definición de los efectos), pues aún no se implementan las habilidades.  Nuevamente, a pesar de ser distintas, comparten funcionalidades que tienen que ver con cómo se posicionan en el tablero, que se especifican en AbstractCard. Por ahora, esto no se implementa pues requiere del tablero. Finalmente, se crea una interfaz para las cartas que encapsulan comportamientos generales. El método _equals_ se implementa como es habitual, mediante igualdad de atributos.

La conexión entre ambos tipos de clases son los conjuntos de cartas o CardSets. Un jugador tiene como dos de sus atributos conjuntos de cartas: el mazo y la mano. Esta representación se realiza mediante una clase CardSet que tiene una lista de cartas. En esta clase se han implementado varias funcionalidades básicas para un conjunto de cartas: obtener cantidad, sacar y poner cartas, escoger un subconjunto, revolver y contar ocurrencias de una carta dada. La implementación de la sobreescritura del métoo _equals_ en este caso es un poco distinta a las anteriores: no se busca igualdad de atributos (de listas) pues no es relevante el orden y además se pueden tener cartas repetidas. Por ello, se utiliza el método para contar ocurrencias para esta implementación.
