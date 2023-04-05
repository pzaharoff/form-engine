package ru.classbase.formengine.form

data class Form(
    val id: String,
    val name: String,
    val entityName : String,
    val fields: List<Field>

)


