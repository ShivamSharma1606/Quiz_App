package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.ui.questionActivity
import com.example.quizapp.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val startButton: Button = findViewById(R.id.button)
        val nameText: EditText = findViewById(R.id.name)

        startButton.setOnClickListener {

            if (!nameText.text.isEmpty()) {
                Intent(this@MainActivity, questionActivity::class.java).also {
                    it.putExtra(Constants.user,nameText.text.toString())
                    startActivity(it)
                    finish()//finish help to don't come from 2nd activity to first home page activity when we press back botton of phone
                }
            }else{
                Toast.makeText(this@MainActivity,"Enter the name first",Toast.LENGTH_SHORT).show()
            }
        }

    }
}