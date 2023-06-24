package ru.classbase.formengine.permission

import ru.classbase.formengine.common.JpaDao
import ru.classbase.formengine.model.FieldPermission
import ru.classbase.formengine.model.FormPermission

interface FieldPermissionDao : JpaDao<FieldPermission> {
    fun findByFormPermission(formPermission: FormPermission): Set<FieldPermission>
}