package com.example.workshop.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class CharacterListResponse (
    @field:SerializedName("count")
    val count: Int? = null,
    @field:SerializedName("rows")
    val rows: ArrayList<Character>? = null
)

@Parcelize
data class Character (
    @field:SerializedName("level")
    val level: Int? = null,
    @field:SerializedName("vocation")
    val vocation: String? = null,
    @field:SerializedName("world")
    val world: World? = null
) : Parcelable

@Parcelize
data class World (
    @field:SerializedName("name")
    val name: String? = null
): Parcelable