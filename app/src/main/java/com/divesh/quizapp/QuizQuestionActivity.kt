package com.divesh.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        ans1.setOnClickListener(this)
        ans2.setOnClickListener(this)
        ans3.setOnClickListener(this)
        ans4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        val question = mQuestionsList!!.get(mCurrentPosition - 1)

        defaultOptionsView()
        disabledOptionsView(true)


        if (mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
        progress_bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progress_bar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        ans1.text = question.optionOne
        ans2.text = question.optionTwo
        ans3.text = question.optionThree
        ans4.text = question.optionFour

    }

    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()
        options.add(0,ans1)
        options.add(1,ans2)
        options.add(2,ans3)
        options.add(3,ans4)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.text_border)
        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.ans1 -> { selectedOptionView(ans1,1)}
            R.id.ans2 -> { selectedOptionView(ans2,2)}
            R.id.ans3 -> { selectedOptionView(ans3,3)}
            R.id.ans4 -> { selectedOptionView(ans4,4)}

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                                setQuestion()
                        }else ->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option)
                    disabledOptionsView(false)
                    if (mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "Go To Next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer:Int, drawableView: Int){

        when(answer){
            1->{
                ans1.background = ContextCompat.getDrawable(this,drawableView)
            }

            2->{
                ans2.background = ContextCompat.getDrawable(this,drawableView)
            }

            3->{
                ans3.background = ContextCompat.getDrawable(this,drawableView)
            }

            4->{
                ans4.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option)

    }

    private fun disabledOptionsView(click: Boolean){

        val options = ArrayList<TextView>()
        options.add(0,ans1)
        options.add(1,ans2)
        options.add(2,ans3)
        options.add(3,ans4)

        for (option in options){
            if (click) option.isClickable = click else option.isClickable = false
        }
    }
}