fun main() {
    println("Start program")
    Printer1.printMessage("Hello!")
    Printer1.printMessage("World!")
    println(Printer1) // Printer@4fccd51b object with hash
    println(Printer2) // Printer2
}

// object keyword will create a singleton https://en.wikipedia.org/wiki/Singleton_pattern
object Printer1 {
    init {
        println("I am creating now") // The initialization of an object declaration is thread-safe and done on first access.
    }

    fun printMessage(message: String) {
        println(message)
    }
}

data object Printer2 //The feature "data objects" is only available since language version 1.8
