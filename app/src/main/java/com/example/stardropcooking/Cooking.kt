package com.example.stardropcooking

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cooking(
    val name: String,
    val photo: String,
    val shortDescr: String,

    val gold: String,
    val energy: String,
    val health: String,

    val descr: String,
    val descr2: String,

) : Parcelable
