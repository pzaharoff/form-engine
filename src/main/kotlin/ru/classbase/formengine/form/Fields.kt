package ru.classbase.formengine.form

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.math.BigDecimal
import java.time.LocalDate

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes(
    value = [
        Type(value = TextField::class, name = "text"),
        Type(value = BoolField::class, name = "boolean"),
        Type(value = LongField::class, name = "long"),
        Type(value = DecimalField::class, name = "decimal"),
        Type(value = DateField::class, name = "date"),
    ]
)
interface Field {
    val id: String
    val name: String
    val required: Boolean
    val defaultValue:String
    val constraints: List<FieldConstraint>
}

data class TextField(
    override val id: String,
    override val name: String,
    override val required: Boolean = true,
    override val constraints: List<FieldConstraint> = listOf(),
    override val defaultValue: String = "null",
    val length: Int = 255,

) : Field

data class BoolField(
    override val id: String,
    override val name: String,
    override val required: Boolean = true,
    override val defaultValue: String = "true",
    override val constraints: List<FieldConstraint> = listOf(),
) : Field

data class LongField(
    override val id: String,
    override val name: String,
    override val required: Boolean = true,
    override val defaultValue: String = "null",
    override val constraints: List<FieldConstraint> = listOf(),
) : Field

data class DecimalField(
    override val id: String,
    override val name: String,
    override val required: Boolean = true,
    override val defaultValue: String = "null",
    override val constraints: List<FieldConstraint> = listOf(),
    val precision: Int = 10,
    val scale: Int = 2,
) : Field

data class DateField(
    override val id: String,
    override val name: String,
    override val required: Boolean = true,
    override val defaultValue: String = "null",
    override val constraints: List<FieldConstraint> = listOf(),
) : Field

