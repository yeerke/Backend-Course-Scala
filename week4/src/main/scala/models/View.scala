package models

class View {
    val calc = new Calculator()
    var cur = 0
    def readKey(): Unit = {
        val key = scala.io.StdIn.readChar()
        if (key >= '0' && key <= '9')
            readDigit(key - '0')
        else
            readOperation(key.toString)
        println(cur)
    }

    def readDigit(digit: Int): Unit = {
        cur = cur * 10 + digit
    }

    def readOperation(symbol: String): Unit = {
        if (calc.isOperation(symbol) || symbol == "=") {
            calc.set(cur)
            calc.execute(symbol)
            if (symbol == "=")
                cur = calc.res
            else
                cur = 0
        }
    }
}
