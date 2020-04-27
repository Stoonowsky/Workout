package com.example.workout.workout

import java.io.Serializable

data class ExerciseItem(
            var exercise: String = "",
            var sets: Int = 0,
            var reps: Int = 0,
            var weights: Int = 0) : Serializable