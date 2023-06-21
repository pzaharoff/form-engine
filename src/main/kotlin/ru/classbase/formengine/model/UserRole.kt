package ru.classbase.formengine.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(
    name = "sys_user_role",
    uniqueConstraints = [UniqueConstraint(name = "uk_user_role", columnNames = ["sys_user_id", "sys_role_id"])]
)
class UserRole : BaseEntity() {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_user_id")
    lateinit var user: User

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_role_id")
    lateinit var role: Role

}