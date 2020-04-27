package com.example.workout.home

import java.io.Serializable

data class HomeItem(
            var comment: String = "",
            var workout: String ="",
            var image: String = "",
            var user: String = "",
            var timeMilis: Long = 0,
            var uid: String = "",
            var respects: HashMap<String, Int> = hashMapOf()) : Serializable