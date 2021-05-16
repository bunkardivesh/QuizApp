package com.divesh.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val mUsername = intent.getStringExtra(Constants.USER_NAME)
        username.text = mUsername

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        textscore.text = "Your Score is $correctAnswers out of $totalQuestions"

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}