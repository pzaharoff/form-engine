package ru.classbase.formengine.core

import jakarta.persistence.EntityManager
import org.springframework.beans.BeanWrapperImpl
import org.springframework.beans.factory.BeanFactory
import org.springframework.context.expression.BeanExpressionContextAccessor
import org.springframework.context.expression.BeanFactoryResolver
import org.springframework.expression.spel.standard.SpelExpressionParser
import org.springframework.expression.spel.support.StandardEvaluationContext
import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionTemplate
import org.springframework.util.ClassUtils
import ru.classbase.formengine.base.BaseEntity
import ru.classbase.formengine.form.Form
import ru.classbase.formengine.form.FormAction
import ru.classbase.formengine.form.FormAction.CREATE


@Component
class FormEngine(
    private val em: EntityManager,
    private val tx: TransactionTemplate,
    private val application: Application,
    private val beanFactory: BeanFactory
) {


    fun create(request: CreateReq, userRoles: Set<Role>): CreateRs? {
        val form = application.getForm(request.form)

        //Проверяем, наличие прав на действие согласно ролевой модели
        checkRoleFormPermissions(form, CREATE, userRoles)
        //Проверяем, наличие прав на действие согласно пользовательским SpEL проверкам
        validateFormAction(form, CREATE, userRoles)

        val entity = parseCreateReq(request, form)

        tx.execute {
            em.persist(entity)
        }

        return null
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

    fun update(request: UpdateReq, form: Form): UpdateRs? {
        val entity = parseUpdateReq(request, form)

        tx.execute {
            em.persist(entity)
        }

        return null
    }

    private fun parseUpdateReq(request: UpdateReq, form: Form): BaseEntity {

        var clazz = ClassUtils.forName(form.entityName, null)

        val result = tx.execute {
            val entity = em.find(clazz, request.id)

            val beanWrapper = BeanWrapperImpl(entity)

            request.data.forEach {
                val value = getDefaultValue(form, it.key, it.value)
                beanWrapper.setPropertyValue(it.key, value)
            }
        }

        return result as BaseEntity
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

        val entity = form.entityClass.getDeclaredConstructor().newInstance()

        val beanWrapper = BeanWrapperImpl(entity)

        request.data.forEach {
            val value = getDefaultValue(form, it.key, it.value)
            beanWrapper.setPropertyValue(it.key, value)
        }

        return entity as BaseEntity
    }
}