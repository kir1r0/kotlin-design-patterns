package kr.kotlin.design.patterns.creation

fun main() {
    val rifleFactory = RifleFactory()
    val pistolFactory = PistolFactory()
    val weaponCreator = WeaponCreator(rifleFactory, pistolFactory)
    println(weaponCreator.createAkSetup())
    println(weaponCreator.createM16Setup())
}

// https://en.wikipedia.org/wiki/Abstract_factory_pattern
interface Weapon {
    val calibre: Double
    val capacity: Int
}

interface Pistol : Weapon
interface Rifle : Weapon

data class Nagant(override val calibre: Double = 7.62, override val capacity: Int = 7) : Pistol
data class TT(override val calibre: Double = 7.62, override val capacity: Int = 8) : Pistol

data class AK47(override val calibre: Double = 7.62, override val capacity: Int = 30) : Rifle
data class M16(override val calibre: Double = 5.56, override val capacity: Int = 30) : Rifle

interface WeaponFactory {
    fun createWeapon(type: String): Weapon
}

class RifleFactory() : WeaponFactory {
    override fun createWeapon(type: String): Weapon {
        return when (type) {
            "ak" -> {
                AK47()
            }

            "m16" -> {
                M16()
            }

            else -> throw IllegalArgumentException("Unknown weapon type: $type")
        }
    }
}

class PistolFactory : WeaponFactory {
    override fun createWeapon(type: String): Weapon {
        return when (type) {
            "nagant" -> {
                Nagant()
            }

            "tt" -> {
                TT()
            }

            else -> throw IllegalArgumentException("Unknown weapon type: $type")
        }
    }
}

class WeaponCreator(private val rifleFactory: RifleFactory, private val pistolFactory: PistolFactory) {
    fun createAkSetup(): Pair<Weapon, Weapon> {
        return rifleFactory.createWeapon("ak") to pistolFactory.createWeapon("nagant")
    }

    fun createM16Setup(): Pair<Weapon, Weapon> {
        return rifleFactory.createWeapon("m16") to pistolFactory.createWeapon("tt")
    }
}


