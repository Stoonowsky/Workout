package com.example.workout.profile

import java.io.Serializable

data class UserItem(
            var name: String = "",
            var url: String = "",
            var uid: String = ""): Serializable