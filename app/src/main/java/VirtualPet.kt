// VirtualPet.kt
import kotlin.random.Random

class VirtualPet(var health: Int, var hunger: Int, var cleanliness: Int) {

    fun feed() {
        hunger -= 10
        if (hunger < 0) hunger = 0
    }

    fun clean() {
        cleanliness -= 10
        if (cleanliness < 0) cleanliness = 0
    }

    fun play() {
        // When playing, hunger and cleanliness are affected
        hunger += 10
        cleanliness += 10

        // Ensure values are within the valid range (0-100)
        hunger = if (hunger > 100) 100 else hunger
        cleanliness = if (cleanliness > 100) 100 else cleanliness
    }

    fun update() {
        // Decrease health if hunger or cleanliness is too low
        health -= if (hunger <= 20) 10 else 0
        health -= if (cleanliness <= 20) 10 else 0

        // Ensure health is within the valid range (0-100)
        health = if (health < 0) 0 else if (health > 100) 100 else health
    }
}



