package ru.classbase.formengine.permission

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.classbase.formengine.common.JpaDao
import ru.classbase.formengine.model.User

interface UserDao : JpaDao<User> {
    @Query("""
        from User u
        join fetch u.currentRole
        where u.login = :login
    """)
    fun findByLogin(@Param("login") login: String): User

}