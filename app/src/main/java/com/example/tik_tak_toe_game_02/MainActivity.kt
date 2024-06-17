package com.example.tik_tak_toe_game_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var startNewGameButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startNewGameButton = findViewById(R.id.startNewGameButton)

        startNewGameButton.setOnClickListener {
           startActivity(Intent(this,GameActivity::class.java))
        }
    }
}