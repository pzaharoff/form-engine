package ru.classbase.formengine.permission

import ru.classbase.formengine.common.JpaDao
import ru.classbase.formengine.model.Role

interface RoleDao : JpaDao<Role> {
    fun findByCode(code: String): Role
}