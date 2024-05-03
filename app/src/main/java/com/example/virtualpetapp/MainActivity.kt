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









