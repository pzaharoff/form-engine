package ru.classbase.formengine.core

data class CreateReq(
    val form : String,
    val data : Map<String, String?>
)