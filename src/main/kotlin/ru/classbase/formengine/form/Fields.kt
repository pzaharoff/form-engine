package ru.classbase.formengine.form

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo

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
    val fieldName: String
    val label: String
    val required: Boolean
    val defaultValue: String
    val constraints: List<FieldConstraint>
}

data class TextField(
    override val fieldName: String,
    override val label: String,
    override val required: Boolean = true,
    override val constraints: List<FieldConstraint> = listOf(),
    override val defaultValue: String = "",
    val length: Int = 255,

    ) : Field

data class BoolField(
    override val fieldName: String,
    override val label: String,
    override val required: Boolean = true,
    override val defaultValue: String = "",
    override val constraints: List<FieldConstraint> = listOf(),
) : Field

data class LongField(
    override val fieldName: String,
    override val label: String,
    override val required: Boolean = true,
    override val defaultValue: String = "",
    override val constraints: List<FieldConstraint> = listOf(),
) : Field

data class DecimalField(
    override val fieldName: String,
    override val label: String,
    override val required: Boolean = true,
    override val defaultValue: String = "",
    override val constraints: List<FieldConstraint> = listOf(),
    val precision: Int = 10,
    val scale: Int = 2,
) : Field

data class DateField(
    override val fieldName: String,
    override val label: String,
    override val required: Boolean = true,
    override val defaultValue: String = "",
    override val constraints: List<FieldConstraint> = listOf(),
) : Field

data class ReferenceField(
    override val fieldName: String,
    override val label: String,
    override val required: Boolean = true,
    override val defaultValue: String = "",
    override val constraints: List<FieldConstraint> = listOf(),
    val refEntity: String,
    val refViewExpression: String = "name",
    val refListQuery : String = "select t.id, t.name from #refEntity t where lower(t.name) like :search order by t.name"
) : Field

