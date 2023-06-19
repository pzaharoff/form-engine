package ru.classbase.formengine.core

open abstract class AbstractForm(override val formId: String) : Form {
    var fields = hashMapOf<String, Field>()
    fun field(init: Field.() -> Unit): Field {
        val field = Field()
        field.init()
        fields[field.id] = field
        return field
    }
}

interface Form {
    val formId: String
}

class Field {
    lateinit var id: String
    lateinit var label: String

}

