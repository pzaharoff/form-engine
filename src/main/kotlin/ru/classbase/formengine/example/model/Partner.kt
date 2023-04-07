package ru.classbase.formengine.example.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity
import java.math.BigDecimal

@Entity
@Table(name = "partner")
class Partner : BaseEntity() {

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "amout", nullable = false)
    var amount: Long = 0

    @Column(name = "cost", nullable = false)
    lateinit var cost: BigDecimal

    @Column(name = "active", nullable = false)
    var active: Boolean = true

/*
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "net_id", nullable = false)
    lateinit var net : Net
*/
}
