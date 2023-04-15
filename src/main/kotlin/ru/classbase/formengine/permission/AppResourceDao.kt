package ru.classbase.formengine.permission

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.classbase.formengine.model.AppResource
import ru.classbase.formengine.model.AppResourceType
import java.util.*

interface AppResourceDao :JpaRepository<AppResource, UUID> {

    @Query("""
        from AppResource t
        where t.fullPath = :fullPath
          and t.deleted = false
    """)
    fun find(fullPath : String) : AppResource?

/*
    @Query("""
        from AppResource t
        where t.fullPath like :fullPath
          and t.deleted = false
    """)
    fun findResourcesByPath(fullPath : String) : Set<AppResource>
*/

    @Query("""
        from AppResource t
        where t.parent = :parent
          and t.type = :type
          and t.deleted = false
    """)
    fun find(parent : AppResource, type : AppResourceType) : Set<AppResource>

    @Query("""
        from AppResource t
        where t.type = :type
          and t.deleted = false
    """)
    fun find(type : AppResourceType) : Set<AppResource>

    fun deleteByParent(parent : AppResource)

}