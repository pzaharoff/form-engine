package ru.classbase.formengine.permission

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.classbase.formengine.model.AppResource
import java.util.*

interface AppResourceDao :JpaRepository<AppResource, UUID> {

    @Query("""
        from AppResource t
        where t.fullPath like :fullPath
    """)
    fun findByPath(fullPath : String) : Set<AppResource>
}