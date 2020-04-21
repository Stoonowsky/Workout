package com.example.workout

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_exercise.*

class AddExerciseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_exercise)

        buttonSendExercise.setOnClickListener {
            val database = getSharedPreferences("database", Context.MODE_PRIVATE)
            database.edit().apply {
                putString("savedExerciseName", editTextExerciseName.text.toString())
            }.apply()
        }



    }

}