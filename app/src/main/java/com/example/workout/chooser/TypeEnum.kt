package com.example.workout.chooser

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.workout.R
import com.example.workout.WLApp

enum class TypeEnum(@StringRes val label: Int,
                    @DrawableRes val image: Int) {
    FBW(R.string.type_fbw, R.drawable.ic_fbw),
    PPL(R.string.type_ppl, R.drawable.ic_fbw),
    Split(R.string.type_split, R.drawable.ic_fbw);

    fun getString() =
        WLApp.res.getString(this.label)
}