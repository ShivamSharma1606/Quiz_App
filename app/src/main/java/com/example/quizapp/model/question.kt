package com.example.quizapp.model

//we store image in int data type because image are stored in drawable folder which store image in the format of Int
data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val opt1: String,
    val opt2: String,
    val opt3: String,
    val opt4: String,
    val correctAns: Int
)

