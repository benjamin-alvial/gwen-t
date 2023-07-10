# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

# Entrega parcial 6

Se ha implementado el patrón de diseño Observer. El observador es el controlador y los sujetos observados son los dos jugadores, de modo que si un jugador pierde una gema, quedando con cero gemas, este notifica al controlador, que cambia de estado. Esta implementación es extensible, de modo que, si se busca notificar al controlador desde alguna otra clase, basta que esta extienda de la clase abstracta Subject, se suscriba al controlador y se utilice el método de notificar donde corresponda.
