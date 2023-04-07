package ru.classbase.formengine.example.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import ru.classbase.formengine.base.BaseEntity

@Entity
@Table(name = "net")
class Net : BaseEntity() {
    @Column(name = "name", nullable = false)
    lateinit var name: String
}
