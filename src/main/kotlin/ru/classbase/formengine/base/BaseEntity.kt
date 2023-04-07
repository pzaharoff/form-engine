package ru.classbase.formengine.base

import java.time.LocalDateTime
import java.util.*
import jakarta.persistence.*

@MappedSuperclass
open class BaseEntity : Identifier {
    @Id
    //@GeneratedValue
    override var id: UUID = UUID.randomUUID()

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Version
    @Column(name = "version", nullable = false)
    var version : Int = 0

    @Column(name = "deleted", nullable = false)
    var deleted : Boolean = false

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "BaseEntity(id=$id)"
    }


}