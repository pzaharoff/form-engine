package ru.classbase.formengine.permission

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.classbase.formengine.model.AppResource
import java.util.*

interface AppResourceDao :JpaRepository<AppResource, UUID> {

    fun findByPath(fullPath : String) : AppResource?

    @Query("""
        from AppResource t
        where t.fullPath like :fullPath
    """)
    fun findResourcesByPath(fullPath : String) : Set<AppResource>


}