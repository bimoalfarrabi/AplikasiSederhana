package com.example.aplikasisederhana

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Android(
    val name: String,
    val description: String,
    val photo: Int,
    val release: String
) : Parcelable
