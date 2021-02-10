package com.example.rb_first_kotlin.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Translations(
    val br: String,
    val de: String,
    val es: String,
    val fa: String,
    val fr: String,
    val hr: String,
    val it: String,
    val ja: String,
    val nl: String,
    val pt: String
)