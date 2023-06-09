package ru.classbase.formengine.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(
    name = "app_resource_role",
    uniqueConstraints = [UniqueConstraint(name = "", columnNames = ["app_resource_id", "role", "permission"])]
)
class AppResourceRole : BaseEntity() {

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "app_resource_id", nullable = false)
    lateinit var resource: AppResource

    @Column(name = "role", nullable = false, length = 64)
    lateinit var role: String

    @Column(name = "permission", nullable = false)
    @Enumerated(EnumType.STRING)
    lateinit var permission: Permission
}