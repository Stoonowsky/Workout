package com.example.workout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this, AddExerciseActivity::class.java))

        }

        val exercises = listOf(
            Exercise("OHP", 3,8, 40),
            Exercise("Squat", 5, 5, 85),
            Exercise("Bench press", 5, 5, 70),
            Exercise("Dead lift", 5, 5, 120)
        )

        var totalReps = 0
        var totalWeights = 0
        exercises.forEach{
            exerciseTextView.append("${it.name} -> ${it.sets} serie po ${it.reps} powtórzeń na ${it.weight} kg\n")
            totalReps += it.sets*it.reps
            totalWeights += it.sets*it.reps*it.weight

        }
        repsCountTextView.append("Twoja ilość powtórzeń to: $totalReps\n")
        repsCountTextView.append("Twoja ilość rzuconego żelastwa to: $totalWeights kg\n")

        d("lukasz", "Powtórzenia to: $totalReps, a obciążenie to: $totalWeights")

    }


}
