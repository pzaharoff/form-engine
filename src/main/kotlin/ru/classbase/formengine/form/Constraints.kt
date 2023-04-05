package ru.classbase.formengine.form

interface FieldConstraint

data class LengthConstraint(
    val minLength: Int = 0,
    val maxLength: Int = 255
) : FieldConstraint

data class MinMaxConstraint(
    val minLength: Int = 0,
    val maxLength: Int = Int.MAX_VALUE
) : FieldConstraint

data class SpelConstraint(
    val expression: String
) : FieldConstraint

data class PatternConstraint(
    val pattern: String
) : FieldConstraint