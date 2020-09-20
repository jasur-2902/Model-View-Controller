package edu.adelphi.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf (
        Question(R.string.question_1_multiplication, true),
        Question(R.string.question_2_square, true),
        Question(R.string.question_3_square, false),
        Question(R.string.question_4_division, true),
        Question(R.string.question_5_multiplication, false),
        Question(R.string.question_6_square_root, true))

    private var currentIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
            // Do something in response to a click here
        }
        falseButton.setOnClickListener { view: View ->
            // Do something in response to a click here
            checkAnswer(false)
        }

        nextButton.setOnClickListener { view: View ->
            // Do something in response to a click here
            updateQuestion()

        }
        updateQuestion()

    }
    private fun updateQuestion() {
        currentIndex = (currentIndex+1)%questionBank.size
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)

    }

    private fun checkAnswer(userAnswer: Boolean){

        val correctAnswer = questionBank[currentIndex].answer
        val messageRedId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        }
        else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageRedId, Toast.LENGTH_SHORT).show()
        updateQuestion()
    }
}
