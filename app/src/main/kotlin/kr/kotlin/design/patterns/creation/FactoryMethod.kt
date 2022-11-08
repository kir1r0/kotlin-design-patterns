package kr.kotlin.design.patterns.creation

fun main() {
    val neutral = createStalker("neutral")
    println(neutral)
}

// https://en.wikipedia.org/wiki/Factory_method_pattern
interface Stalker {
    val rank: Int
    val name: String
}

data class Bandit(override val rank: Int = 0, override val name: String) : Stalker

data class NeutralStalker(override val rank: Int = 0, override val name: String) : Stalker

fun createStalker(type: String): Stalker { // enum is usually used
    return when (type) {
        "bandit" -> {
            Bandit(name = "Vasya")
        }

        "neutral" -> {
            NeutralStalker(name = "Petya")
        }

        else -> {
            throw IllegalArgumentException("Unknown stalker type: $type")
        }
    }
}