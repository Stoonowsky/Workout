package com.example.workout.chooser

import java.io.Serializable

data class WorkoutItem(
                var level: LevelEnum = LevelEnum.EASY,
                var type: TypeEnum = TypeEnum.FBW,
                var workoutset: String = "") : Serializable