package ru.classbase.formengine.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(
    name = "sys_field_permission",
    uniqueConstraints = [UniqueConstraint(
        name = "uk_form_permission",
        columnNames = ["sys_form_permission_id", "field"]
    )]
)
class FieldPermission : BaseEntity() {

    @Column(name = "field", nullable = false)
    lateinit var field: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_form_permission_id")
    lateinit var formPermission: FormPermission

    @Column(name = "has_read", nullable = false)
    var hasRead: Boolean = true

    @Column(name = "has_create", nullable = false)
    var hasCreate: Boolean = false

    @Column(name = "has_update", nullable = false)
    var hasUpdate: Boolean = false

}