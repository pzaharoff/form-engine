package ru.classbase.formengine.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(
    name = "sys_form_permission",
    uniqueConstraints = [UniqueConstraint(name = "uk_form_permission", columnNames = ["form", "role_id"])]
)
class FormPermission : BaseEntity() {
    @Column(name = "form", nullable = false)
    lateinit var form: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    lateinit var role: Role

    @Column(name = "has_read", nullable = false)
    var hasRead: Boolean = true

    @Column(name = "has_create", nullable = false)
    var hasCreate: Boolean = false

    @Column(name = "has_update", nullable = false)
    var hasUpdate: Boolean = false

    @Column(name = "has_delete", nullable = false)
    var hasDelete: Boolean = false

}