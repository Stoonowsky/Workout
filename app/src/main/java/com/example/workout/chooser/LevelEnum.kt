package com.example.workout.chooser

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.workout.R
import com.example.workout.WLApp

enum class LevelEnum(@StringRes val label: Int,
                     @DrawableRes val image: Int) {

    EASY(R.string.level_easy, R.drawable.ic_level_easy),
    AVERAGE(R.string.level_average, R.drawable.ic_level_average),
    HARD(R.string.level_hard, R.drawable.ic_level_hard);

    fun getString() =
            WLApp.res.getString(this.label)

}