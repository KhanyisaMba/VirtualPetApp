class VirtualPet(var health: Int = 100, var hunger: Int = 0, var cleanliness: Int = 0) {

    // Method to feed the pet
    fun feed() {
        hunger += 10
        if (hunger > 100) hunger = 100
    }

    // Method to clean the pet
    fun clean() {
        cleanliness += 10
        if (cleanliness > 100) cleanliness = 100
    }

    // Method to play with the pet
    fun play() {
        // When playing, hunger and cleanliness are affected
        hunger += 10
        cleanliness += 10

        // Ensure values are within the valid range (0-100)
        hunger = if (hunger < 0) 0 else hunger
        cleanliness = if (cleanliness < 0) 0 else cleanliness
    }

    // Method to update the pet's status
    fun update() {
        // Decrease health if hunger or cleanliness is too low
        health += if (hunger <= 20) 10 else 0
        health += if (cleanliness <= 20) 10 else 0

        // Ensure health is within the valid range (0-100)
        health = if (health < 0) 0 else if (health > 100) 100 else health
    }
}









