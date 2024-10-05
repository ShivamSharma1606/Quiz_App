package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewScore:TextView
    private lateinit var textViewName:TextView
    private lateinit var finishButton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        textViewScore=findViewById(R.id.textview_score)
        textViewName=findViewById(R.id.textview_name)
        finishButton=findViewById(R.id.finish_button)

        val totalQuestion=intent.getIntExtra(Constants.Total_Question,0)
        val score=intent.getIntExtra(Constants.score,0)
        val name=intent.getStringExtra(Constants.user)

        textViewScore.text="Your score is $score out of $totalQuestion"
        textViewName.text=name

        finishButton.setOnClickListener(){
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}