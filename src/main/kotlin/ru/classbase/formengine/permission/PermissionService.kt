package ru.classbase.formengine.permission

import org.springframework.stereotype.Component
import ru.classbase.formengine.core.Application
import ru.classbase.formengine.form.Form
import ru.classbase.formengine.model.AppResource
import ru.classbase.formengine.model.AppResourceType.FORM

@Component
class PermissionService(private val appResourceDao: AppResourceDao, private val application: Application) {
    private val defaultRoles = listOf("ADMIN", "READER")

    fun refreshDefaultPermissions() {
        application.getForms().forEach {
            updateForm(it.value)
            updateFields(it.value)
        }
    }

    private fun updateFields(value: Form) {

    }

    private fun updateForm(form: Form): AppResource {
        val resource = appResourceDao.findByPath(form.id) ?: AppResource()
        val formPath = form.id.lowercase()
        resource.apply {
            type = FORM
            name = form.label
            path = formPath
            fullPath = formPath
        }

        return appResourceDao.save(resource)
    }

}