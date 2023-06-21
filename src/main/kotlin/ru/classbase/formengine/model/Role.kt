package ru.classbase.formengine.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(
    name = "sys_role",
    uniqueConstraints = [UniqueConstraint(name = "uk_role", columnNames = ["code"])]
)
class Role : BaseEntity() {
    @Column(name = "code", nullable = false, length = 32)
    lateinit var code: String

    @Column(name = "name", nullable = false)
    lateinit var name: String

}