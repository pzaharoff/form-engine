package ru.classbase.formengine.core

import jakarta.persistence.EntityManager
import org.springframework.beans.factory.BeanFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionTemplate
import ru.classbase.formengine.base.BaseEntity
import ru.classbase.formengine.model.Role
import ru.classbase.formengine.model.User
import ru.classbase.formengine.permission.PermissionService
import kotlin.reflect.full.createInstance


@Component
class FormEngine(
    private val em: EntityManager,
    private val tx: TransactionTemplate,
    private val application: Application,
    private val beanFactory: BeanFactory,
    private val formManager: FormManager,
    private val permissionService: PermissionService
) {

    fun create(request: CreateReq, role: Role): CreateRs? {
        val form = formManager.get(request.form)
        permissionService.checkCreate(form.formId, role)

        //отфильтруем левые поля, которых вообще нет в форме
        val filteredValues = filterNotExists(request, form)

        return null
    }

    private fun filterNotExists(request: CreateReq, form: Form): Map<String, Any?> {
        val result = request.data.filterKeys { form.fields.containsKey(it) }
        if (result.isEmpty()) {
            throw FormException("Ошибка: ни одно из полей формы [${form.formId}] в запросе не найдено")
        }

        return result
    }

    private fun createEmptyEntity(form: Form): BaseEntity {
        return form.entityClass.createInstance()
    }

    /*

        fun create(request: CreateReq, userRoles: Set<Role>): CreateRs? {
            val form = application.getForm(request.form)

            //Проверяем, наличие прав на действие согласно ролевой модели
            checkRoleFormPermissions(form, CREATE, userRoles)

            //Проверяем возможность выполнения согласно пользовательским SpEL проверкам
            validateFormAction(form, CREATE, userRoles)

            //Создаем пустой экземляр сущности привязанной к форме
            var entity = createEmptyEntity(form)

            val cleanedRequest = cleanRequest(form, request, userRoles)
            processEmbeddedValidations(form)
            //Убираем из запроса поля на которые нет прав при выполнении действия
            val filteredRequest = asda

            fillEntity(entity, request)


            //parseCreateReq(request, form)

            tx.execute {
                em.persist(entity)
            }

            return null
        }

        private fun cleanRequest(form: Form, request: CreateReq): CreateReq {
            val data = request.data.filter { }
        }

        private fun fillEntity(entity: BaseEntity, request: CreateReq) {
            val result = tx.execute {

                val beanWrapper = BeanWrapperImpl(entity)

                request.data.forEach {
                    val value = getDefaultValue(form, it.key, it.value)
                    beanWrapper.setPropertyValue(it.key, value)
                }
            }

            return result as BaseEntity

        }


        private fun validateFormAction(form: Form, create: FormAction, userRoles: Set<Role>) {
            TODO("Not yet implemented")
        }

        private fun checkRoleFormPermissions(form: Form, action: FormAction, userRoles: Set<Role>) {
            val formPermissions = form.permissions.getOrDefault(action, setOf())
            if (!userRoles.any { it in formPermissions }) {
                throw FormException("Недостаточно прав на выполнение действия: [${action.label}]")
            }
        }

        private fun hasPermissions(userRoles: Iterable<Role>, targetRoles: Set<Role>): Boolean {
            return userRoles.any { it in targetRoles }
        }

        private fun getDefaultValue(form: Form, key: String, value: Any?): Any? {
            val field = form.fields.first { it.fieldName == key }
            return if (field.defaultValue.isNullOrEmpty()) {
                value
            } else {
                val parser = SpelExpressionParser()
                val context = StandardEvaluationContext()
                context.setBeanResolver(BeanFactoryResolver(beanFactory))
                context.addPropertyAccessor(BeanExpressionContextAccessor())
                //val expression: Expression = parser.parseExpression("someOtherBean.getData()")
                //val rootObject = BeanExpressionContext(beanFactory, null)

                //val context = StandardEvaluationContext()
                //val parser = SpelExpressionParser()
                parser.parseExpression(field.defaultValue).getValue(context)
                //exp.value
            }
        }

        private fun parseCreateReq(request: CreateReq, form: Form): BaseEntity {


        }
    */
}