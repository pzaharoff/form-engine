package ru.classbase.formengine.core

import ru.classbase.formengine.base.BaseEntity
import sun.jvm.hotspot.oops.CellTypeState.value
import java.math.BigDecimal
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

open abstract class AbstractForm(override val formId: String, override val entityClass: KClass<out BaseEntity>) : Form {
    override val fields = hashMapOf<String, Field<*>>()
    fun textField(init: TextField.() -> Unit): TextField {
        val field = TextField()
        field.init()
        fields[field.id] = field
        return field
    }

    fun decimalField(init: DecimalField.() -> Unit): DecimalField {
        val field = DecimalField()
        field.init()
        fields[field.id] = field
        return field
    }

    fun booleanField(init: BooleanField.() -> Unit): BooleanField {
        val field = BooleanField()
        field.init()
        fields[field.id] = field
        return field
    }

}

interface Form {
    val formId: String
    val entityClass : KClass<out BaseEntity>
    val fields : Map<String, Field<*>>

}

interface Field<T : Comparable<T>> {
    var type: KClass<T>
    var id: String
}

abstract class AbstractField<T : Comparable<T>> : Field<T> {
    override lateinit var type: KClass<T>
    override lateinit var id: String
    open lateinit var label: String
    open var required = true
    open var defaultValue: () -> T? = { null }

}

class TextField : AbstractField<String>() {
    var minLength = 0
    var maxLength = 255

}

class DecimalField : AbstractField<BigDecimal>() {
    var minValue: BigDecimal? = null
    var maxValue: BigDecimal? = null
}

class BooleanField : AbstractField<Boolean>() {
    override var defaultValue: () -> Boolean? =  { false }
}
