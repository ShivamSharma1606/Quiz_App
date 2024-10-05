package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants

class questionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var flagImage: ImageView

    private lateinit var textViewOpt1: TextView
    private lateinit var textViewOpt2: TextView
    private lateinit var textViewOpt3: TextView
    private lateinit var textViewOpt4: TextView
    private lateinit var checkButton: Button

    private var currentPosition = 0
    private lateinit var questionList: MutableList<Question>

    private var answer = false
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question

    private lateinit var name:String
    private var score=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)

        //code
        questionList = Constants.getQuestion()

        progressBar = findViewById(R.id.progressBar)
        textViewProgress = findViewById(R.id.progress_text)
        textViewQuestion = findViewById(R.id.question_textView)
        flagImage = findViewById(R.id.imageFlag)

        textViewOpt1 = findViewById(R.id.textViewOption1)
        textViewOpt2 = findViewById(R.id.textViewOption2)
        textViewOpt3 = findViewById(R.id.textViewOption3)
        textViewOpt4 = findViewById(R.id.textViewOption4)
        checkButton = findViewById(R.id.buttonCheck)

        textViewOpt1.setOnClickListener(this)
        textViewOpt2.setOnClickListener(this)
        textViewOpt3.setOnClickListener(this)
        textViewOpt4.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        showNextQuestion()

        if(intent.hasExtra(Constants.user)){
            name=intent.getStringExtra(Constants.user)!!

        }

    }

    private fun showNextQuestion() {


        if (currentPosition < questionList.size) {
            checkButton.text = "CHECK"
            currentQuestion = questionList[currentPosition]

            resetColor()
            val question = questionList[currentPosition]
            flagImage.setImageResource(question.image)
            progressBar.progress = currentPosition
            textViewProgress.text = "$currentPosition/${progressBar.max}"
            textViewQuestion.text = question.question
            textViewOpt1.text = question.opt1
            textViewOpt2.text = question.opt2
            textViewOpt3.text = question.opt3
            textViewOpt4.text = question.opt4
        } else {
            checkButton.text = "FINISH"

            //now  passing result data
            Intent(this,ResultActivity::class.java).also {
                it.putExtra(Constants.user,name)
                it.putExtra(Constants.score,score)
                it.putExtra(Constants.Total_Question,questionList.size)
                startActivity(it)
            }
        }

        currentPosition++
        answer = false

    }

    private fun resetColor() {
        val opt = mutableListOf<TextView>()
        opt.add(textViewOpt1)
        opt.add(textViewOpt2)
        opt.add(textViewOpt3)
        opt.add(textViewOpt4)

        for (i in opt) {
            i.setTextColor(Color.parseColor("#D3D3D3"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(
                this,
                R.drawable.defautl_option_color
            )
        }
    }

    private fun OnclickColor(t1: TextView, selectedOption: Int) {
        resetColor()

        selectedAnswer = selectedOption

        t1.setTextColor(Color.parseColor("#000000"))
        t1.typeface = Typeface.DEFAULT_BOLD
        t1.background = ContextCompat.getDrawable(
            this,
            R.drawable.click_option_color
        )
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.textViewOption1 -> OnclickColor(textViewOpt1, 1)
            R.id.textViewOption2 -> OnclickColor(textViewOpt2, 2)
            R.id.textViewOption3 -> OnclickColor(textViewOpt3, 3)
            R.id.textViewOption4 -> OnclickColor(textViewOpt4, 4)
            R.id.buttonCheck -> {
                if (!answer) {
                    checkAnswer()
                } else {
                    showNextQuestion()
                }
                selectedAnswer = 0
            }
        }
    }

    private fun checkAnswer() {
        answer = true
        if (selectedAnswer == currentQuestion.correctAns) {
            score++
            when (selectedAnswer) {
                1 -> textViewOpt1.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_color)

                2 -> textViewOpt2.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_color)

                3 -> textViewOpt3.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_color)

                4 -> textViewOpt4.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_color)
            }
        } else {
            when (selectedAnswer) {
                1 -> textViewOpt1.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_color)

                2 -> textViewOpt2.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_color)

                3 -> textViewOpt3.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_color)

                4 -> textViewOpt4.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_color)
            }
        }
        checkButton.text = "NEXT"
        showSolution()
    }

    private fun showSolution(){
        selectedAnswer=currentQuestion.correctAns

        when(selectedAnswer){
            1 -> textViewOpt1.background =
                ContextCompat.getDrawable(this, R.drawable.correct_option_color)

            2 -> textViewOpt2.background =
                ContextCompat.getDrawable(this, R.drawable.correct_option_color)

            3 -> textViewOpt3.background =
                ContextCompat.getDrawable(this, R.drawable.correct_option_color)

            4 -> textViewOpt4.background =
                ContextCompat.getDrawable(this, R.drawable.correct_option_color)
        }
    }
}