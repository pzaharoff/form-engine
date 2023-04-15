package ru.classbase.formengine.model

import jakarta.persistence.*
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(
    name = "app_resource",
    uniqueConstraints = [UniqueConstraint(name = "uk_app_resource_full_path", columnNames = ["full_path"])
    , UniqueConstraint(name = "uk_app_resource", columnNames = ["parent_id", "path"])]
)
class AppResource : BaseEntity() {
    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "path", nullable = false, length = 32)
    lateinit var path: String

    @Column(name = "full_path", nullable = false, length = 1024)
    lateinit var fullPath: String

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    lateinit var type: AppResourceType

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "parent_id")
    var parent: AppResource? = null


}