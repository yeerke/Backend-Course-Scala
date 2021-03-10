package models

class Calculator {
    var temp: Int = 0
    var res: Int = 0
    var last_operation: (Int, Int) => Int = _

    val operations: Map[String, (Int, Int) => Int] = Map("+" -> add, "-" -> subtract, "*" -> multiplication, "/" -> divide)
    def add(x: Int, y: Int): Int = {x + y}
    def subtract(x: Int, y: Int): Int = {x - y}
    def multiplication(x: Int, y: Int): Int = {x * y}
    def divide(x: Int, y: Int): Int = {x / y}

    def set(num: Int): Unit = {
        res = num
    }

    def isOperation(symbol: String): Boolean = operations.contains(symbol)

    def execute(symbol: String): Unit = {
        if (symbol == "=" && last_operation != null) {
            res = last_operation(temp, res)
            temp = 0
            last_operation = null
        }
        else if (symbol != "=") {
            if (last_operation != null) {
                execute("=")
            }
            last_operation = operations(symbol)
            temp = res
        }
    }
}