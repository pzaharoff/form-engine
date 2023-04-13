package ru.classbase.formengine.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(
    name = "app_resource",
    uniqueConstraints = [UniqueConstraint(name = "uk_app_resource", columnNames = ["full_path"])]
)
class AppResource : BaseEntity() {
    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "path", nullable = false, length = 32)
    lateinit var path: String

    @Column(name = "path", nullable = false, length = 1024)
    lateinit var fullPath: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    var parent: AppResource? = null
}