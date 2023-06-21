package ru.classbase.formengine.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(
    name = "sys_user",
    uniqueConstraints = [UniqueConstraint(name = "uk_user", columnNames = ["login"])]
)
class User : BaseEntity() {
    @Column(name = "login", nullable = false, length = 32)
    lateinit var login: String

    @Column(name = "password", nullable = false)
    lateinit var password: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_role_id")
    var currentRole: Role? = null

}