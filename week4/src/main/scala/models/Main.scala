package models

object Main extends App {
    val model = new View()
    while (true) {
        model.readKey()
    }
}
