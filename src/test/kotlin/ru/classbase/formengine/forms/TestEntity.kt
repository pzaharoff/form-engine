package ru.classbase.formengine.forms

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity
import java.math.BigDecimal

@Entity
@Table(
    name = "test_entity"

)
class TestEntity : BaseEntity() {
    @Column(name = "code", nullable = false, length = 32)
    lateinit var code: String

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "decimal_field", nullable = false)
    lateinit var decimalField: BigDecimal

    @Column(name = "boolean_field", nullable = false)
    var booleanField: Boolean = false


}