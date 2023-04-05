package ru.classbase.formengine.core

import java.util.*

data class CreateRs(
    val id : UUID,
    val entity : String,
    val data : Map<String, String?>
)