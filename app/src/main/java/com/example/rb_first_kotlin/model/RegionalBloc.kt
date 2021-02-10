package com.example.rb_first_kotlin.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegionalBloc(
    val acronym: String,
    val name: String,
    val otherAcronyms: List<Any>,
    val otherNames: List<String>
)