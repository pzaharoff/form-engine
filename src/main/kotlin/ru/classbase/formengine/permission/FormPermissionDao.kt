package ru.classbase.formengine.permission

import ru.classbase.formengine.common.JpaDao
import ru.classbase.formengine.model.FormPermission
import ru.classbase.formengine.model.Role

interface FormPermissionDao : JpaDao<FormPermission> {
    fun findByFormAndRole(formId: String, role: Role): FormPermission?

}