package com.example.workout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.workout.R.id.container
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.nav_home ->{
                    title=resources.getString(R.string.navi_bar_home)
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_workout ->{
                    title=resources.getString(R.string.navi_bar_workout)
                    loadFragment(WorkoutFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_profile ->{
                    title=resources.getString(R.string.navi_bar_profile)
                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }


//        val exercises = listOf(
//            Exercise("OHP", 3,8, 40),
//            Exercise("Squat", 5, 5, 85),
//            Exercise("Bench press", 5, 5, 70),
//            Exercise("Dead lift", 5, 5, 120)
//        )
//
//        var totalReps = 0
//        var totalWeights = 0
//        exercises.forEach{
//            exerciseTextView.append("${it.name} -> ${it.sets} serie po ${it.reps} powtórzeń na ${it.weight} kg\n")
//            totalReps += it.sets*it.reps
//            totalWeights += it.sets*it.reps*it.weight
//
//        }
//        repsCountTextView.append("Twoja ilość powtórzeń to: $totalReps\n")
//        repsCountTextView.append("Twoja ilość rzuconego żelastwa to: $totalWeights kg\n")

//        d("lukasz", "Powtórzenia to: $totalReps, a obciążenie to: $totalWeights")

    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
