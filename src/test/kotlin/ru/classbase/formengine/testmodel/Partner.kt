package ru.classbase.formengine.testmodel

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import ru.classbase.formengine.base.BaseEntity
import java.math.BigDecimal

@Entity
@Table(name = "partner")
class Partner : BaseEntity() {

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "amout", nullable = false)
    open var amount: Long = 0

    @Column(name = "cost", nullable = false)
    lateinit var cost: BigDecimal

    @Column(name = "active", nullable = false)
    open var active: Boolean = true
}
