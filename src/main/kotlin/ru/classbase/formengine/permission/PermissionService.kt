package ru.classbase.formengine.permission



/*

@Component
class PermissionService(private val appResourceDao: AppResourceDao, private val application: Application) {
    private val ADMIN_ROLE = "ADMIN"
    private val READER_ROLE = "READER"

    //private val crudActions =  listOf(FormAction.CREATE, FormAction.READ, FormAction.UPDATE, FormAction.DELETE, FormAction.LIST)

    */
/**
     * Обновить или создать ресурсы и права по умолчанию для всех форм
     *//*

    fun refreshFormResources() {
        application.getForms().forEach {
            refreshFormResource(it.value.id)
        }

        removeNonExistingFormResources()
    }

    */
/**
     * Обновить или создать ресурсы и права по умолчанию для формы
     *//*

    fun refreshFormResource(formId: String) {
        val form = application.getForm(formId)

        val refreshedForm = refreshFormResource(form)

        refreshFormResourceActions(refreshedForm)
        refreshFieldResources(refreshedForm, form)
        refreshPermissions()
    }

    private fun refreshFormResource(form: Form): AppResource {
        val storedForm = appResourceDao.find(form.id) ?: AppResource()

        storedForm.apply {
            type = FORM
            name = form.label
            path = form.id
            fullPath = form.id
        }

        return appResourceDao.save(storedForm)
    }

    private fun refreshFormResourceActions(form: AppResource): Set<AppResource> {
        val result = mutableSetOf<AppResource>()

        val storedActions = appResourceDao.find(form, FORM_ACTION)

        for (crudAction in crudActions) {
            val storedAction = storedActions.firstOrNull { it.path == crudAction.name } ?: AppResource()

            storedAction.apply {
                parent = form
                type = FORM_ACTION
                path = crudAction.name
                fullPath = "${refreshedForm.fullPath}/${action.name}"
                name = crudAction.label
            }

            result.add(appResourceDao.save(storedAction))
        }

        return result
    }

    private fun refreshFieldResources(storedForm: AppResource, form: Form) {
        val storedFields = appResourceDao.find(storedForm, FIELD)

        //Создадим или обновим существующие поля
        for (fieldEntry in form.fields) {
            val storedField = storedFields.firstOrNull { it.path == fieldEntry.value.fieldName } ?: AppResource()

            storedField.apply {
                type = FIELD
                parent = storedForm
                path = fieldEntry.value.fieldName
                fullPath = "${storedForm.fullPath}/${FIELD}/${fieldEntry.value.fieldName}"
            }

            appResourceDao.save(storedField)
        }

        //Удаляем из БД поля, которых нет в метаданных формы
        for (storedField in storedFields) {
            if (!form.fields.containsKey(storedField.path)) {
                storedField.deleted = false
                appResourceDao.save(storedField)
            }
        }
    }

    private fun removeNonExistingFormResources() {
        val forms = application.getForms()
        val storedForms = appResourceDao.find(FORM)

        storedForms.forEach {
            if (!forms.containsKey(it.fullPath)) {
                it.deleted = true
            }
        }

        appResourceDao.saveAll(storedForms)
    }

}*/
