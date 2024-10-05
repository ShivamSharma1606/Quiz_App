package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Question

object Constants {

    val user="user name"
    val Total_Question="total_question"
    val score="score"

    fun getQuestion(): MutableList<Question> {
        val question = mutableListOf<Question>()

        val quest1 = Question(
            1,
            "What country this flag belong to",
            R.drawable.italy_flag,
            "India",
            "Russia",
            "Italy",
            "Romania",
            3
        )
        question.add(quest1)

        val quest2 = Question(
            1,
            "What country this flag belong to",
            R.drawable.argentina_flag,
            "Bolivia",
            "Peru",
            "Ecuador",
            "Argentina",
            4
        )
        question.add(quest2)

        val quest3 = Question(
            1,
            "What country this flag belong to",
            R.drawable.brazil_flag,
            "India",
            "Brazil",
            "Italy",
            "Serbia",
            2
        )
        question.add(quest3)


        val quest4 = Question(
            1,
            "What country this flag belong to",
            R.drawable.finland_flag,
            "Finland",
            "Russia",
            "France",
            "Romania",
            1
        )
        question.add(quest4)

        val quest5 = Question(
            1,
            "What country this flag belong to",
            R.drawable.france_flag,
            "Netherlands",
            "Luxembourg ",
            "France",
            "Dutch",
            3
        )
        question.add(quest5)

        val quest6 = Question(
            1,
            "What country this flag belong to",
            R.drawable.germany_flag,
            "South Germany",
            "South Belgian ",
            "Belgian ",
            "Gemany",
            4
        )
        question.add(quest6)

        val quest7 = Question(
            1,
            "What country this flag belong to",
            R.drawable.haiti_flag,
            "Haiti",
            "Liechtenstein",
            "Chile",
            "Romania",
            1
        )
        question.add(quest7)

        val quest8 = Question(
            1,
            "What country this flag belong to",
            R.drawable.india_flag,
            "India",
            "Nepal",
            "Sri Lanka",
            "Pre-India",
            1
        )
        question.add(quest8)

        val quest9 = Question(
            1,
            "What country this flag belong to",
            R.drawable.nigeria_flag,
            "Rhodesia",
            "Pakistan",
            "Nigeria",
            "Norfolk",
            3
        )
        question.add(quest9)

        val quest10 = Question(
            1,
            "What country this flag belong to",
            R.drawable.romania_flag,
            "Chad",
            "Romania",
            "Russia",
            "Moldova",
            2
        )
        question.add(quest10)

        return question
    }
}