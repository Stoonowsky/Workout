package com.example.workout

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

enum class MainScreen(@IdRes val menuItemId: Int,
                      @DrawableRes val menuItemIconId: Int,
                      @StringRes val titleStringId: Int,
                      val fragment: Fragment
) {
    HOME(R.id.nav_home, R.drawable.ic_home_fragment, R.string.navi_bar_home, HomeFragment()),
    WORKOUT(R.id.nav_workout, R.drawable.ic_workout_fragment, R.string.navi_bar_workout, WorkoutFragment()),
    PROFILE(R.id.nav_profile, R.drawable.ic_profile_fragment, R.string.navi_bar_profile, ProfileFragment()),
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen?{
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId){
            return mainScreen
        }
    }
    return null
}