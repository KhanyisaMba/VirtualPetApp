package com.example.virtualpetapp
import VirtualPet
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var virtualPet: VirtualPet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize virtual pet with random initial stats
        virtualPet =
            VirtualPet(Random.nextInt(50, 100), Random.nextInt(50, 100), Random.nextInt(50, 100))

        val imageView = findViewById<ImageView>(R.id.myImageView)
        imageView.setOnClickListener {
            val swooshAnimation = AnimationUtils.loadAnimation(this, R.anim.swoosh_animation)
            imageView.startAnimation(swooshAnimation)
        }

        // Set up onClickListeners for buttons
        val feedButton = findViewById<Button>(R.id.feedButton)
        feedButton.setOnClickListener {
            virtualPet.feed()
            updateUI()
            Toast.makeText(this, "You fed your pet!", Toast.LENGTH_SHORT).show()
        }

        val cleanButton = findViewById<Button>(R.id.cleanButton)
        cleanButton.setOnClickListener {
            virtualPet.clean()
            updateUI()
            Toast.makeText(this, "You cleaned your pet!", Toast.LENGTH_SHORT).show()
        }

        // Add onClickListener for the backButton
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            // Navigate back to the WelcomeActivity
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish() // Finish the MainActivity so the user can't navigate back to it
        }

        // Update UI initially
        updateUI()
    }

    // Method to update UI with the pet's current status
    private fun updateUI() {
        val healthText = "Health: ${virtualPet.health}"
        val hungerText = "Hunger: ${virtualPet.hunger}"
        val cleanlinessText = "Cleanliness: ${virtualPet.cleanliness}"

        runOnUiThread {
            findViewById<TextView>(R.id.healthTextView)?.text = healthText
            findViewById<TextView>(R.id.hungerTextView)?.text = hungerText
            findViewById<TextView>(R.id.cleanlinessTextView)?.text = cleanlinessText
        }
    }
}
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
package com.example.virtualpetapp// com.example.virtualpetapp.WelcomeActivity.kt
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Set onClickListener for the Start Game button
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            // Start com.example.virtualpetapp.MainActivity when the Start Game button is clicked
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Finish the com.example.virtualpetapp.WelcomeActivity so the user can't navigate back to it
        }
    }
}
