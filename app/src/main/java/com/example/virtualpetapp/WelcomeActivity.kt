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
