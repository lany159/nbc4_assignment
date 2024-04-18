package com.example.testapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val profile: Int,
    val title: String,
    val address: String,
    val price: Int,
    val detail: String,
    val userId : String
) : Parcelable