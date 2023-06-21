package ru.classbase.formengine.permission

import org.springframework.stereotype.Component
import ru.classbase.formengine.core.FormException
import ru.classbase.formengine.model.User

@Component
class UserManager(private val userDao: UserDao, private val userRoleDao: UserRoleDao, private val roleDao: RoleDao) {
    fun getUser(login: String): User {
        var user = userDao.findByLogin(login)

        if (user.currentRole == null) {
            val userRoles = userRoleDao.findByUser(user)
            val role = userRoles.firstOrNull() ?: throw FormException("У пользователя [$login] нет ни одной роли")
            user.currentRole = role
            user = userDao.save(user)
        }

        return user
    }
}