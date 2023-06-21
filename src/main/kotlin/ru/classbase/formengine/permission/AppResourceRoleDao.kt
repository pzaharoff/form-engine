package ru.classbase.formengine.permission

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.classbase.formengine.model.AppResource
import ru.classbase.formengine.model.AppResourceRole
import ru.classbase.formengine.model.Permission
import java.util.*

interface AppResourceRoleDao : JpaRepository<AppResourceRole, UUID> {
    @Query("""
        from AppResourceRole t
        where t.resource = :resource
          and t.permission = 
  """)
    fun findBy(@Param("resource") appResource: AppResource, permission: Permission) : Set<AppResourceRole>
}
