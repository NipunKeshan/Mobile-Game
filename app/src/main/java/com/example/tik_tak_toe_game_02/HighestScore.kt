package com.example.tik_tak_toe_game_02

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HighestScoreActivity : AppCompatActivity() {
    private lateinit var gameManager: GameManager
    private lateinit var startNewGameButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        gameManager = GameManager()
        startNewGameButton = findViewById(R.id.start_new_game_button)
        sharedPreferences = getSharedPreferences("GamePreferences", MODE_PRIVATE)

        startNewGameButton.setOnClickListener {
            startNewGameButton.visibility = View.GONE
            gameManager.reset()
        }

        updateHighestScores()
    }

    private fun updateHighestScores() {
        val player1Score = gameManager.player1Points
        val player2Score = gameManager.player2Points

        val highestPlayer1Score = sharedPreferences.getInt("player1Score", 0)
        val highestPlayer2Score = sharedPreferences.getInt("player2Score", 0)

        if (player1Score > highestPlayer1Score) {
            sharedPreferences.edit().putInt("player1Score", player1Score).apply()
        }

        if (player2Score > highestPlayer2Score) {
            sharedPreferences.edit().putInt("player2Score", player2Score).apply()
        }
    }
}
