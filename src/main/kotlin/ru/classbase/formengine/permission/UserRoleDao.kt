package ru.classbase.formengine.permission

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.classbase.formengine.common.JpaDao
import ru.classbase.formengine.model.Role
import ru.classbase.formengine.model.User
import ru.classbase.formengine.model.UserRole

interface UserRoleDao : JpaDao<UserRole> {
    @Query(
        """
        select t.role
          from UserRole t
          where t.user = :user
    """
    )
    fun findByUser(@Param("user") user: User): List<Role>
}