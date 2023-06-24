package ru.classbase.formengine.core

interface FieldHandler<T, F : Field<T>> {
    fun convert(value: Any?): T?
    fun validateInternal(value: T?, field: F)
}