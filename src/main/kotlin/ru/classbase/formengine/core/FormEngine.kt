package ru.classbase.formengine.core

import jakarta.persistence.EntityManager
import mapper
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl
import org.springframework.core.convert.ConversionService
import org.springframework.core.io.ResourceLoader
import org.springframework.expression.spel.support.DataBindingPropertyAccessor
import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionTemplate
import org.springframework.util.ClassUtils
import ru.classbase.formengine.base.BaseEntity
import ru.classbase.formengine.form.Form

@Component
class FormEngine(private val em : EntityManager,
                 private val tx : TransactionTemplate,
                 private val loader : ResourceLoader,
    private val conversionService: ConversionService) {


    fun create(request : CreateReq) : CreateRs? {
        val entity = parseRequest(request)

        tx.execute {
            em.persist(entity)
        }

        return null
    }

    private fun parseRequest(request: CreateReq): BaseEntity {
        val formResource = loader.getResource("classpath:PartnerForm.json")
        val form = mapper.readValue(formResource.inputStream, Form::class.java)

        var clazz = ClassUtils.forName(form.entityName, null)
        val model = em.metamodel.entity(clazz)

        val entity = clazz.getDeclaredConstructor().newInstance()

        val beanWrapper = BeanWrapperImpl(entity)

        request.data.forEach {
            val attribute = model.getAttribute(it.key)

            //val field = ReflectionUtils.findField(clazz, it.key)!!

            val value = conversionService.convert(it.value, attribute.javaType)
            beanWrapper.setPropertyValue(it.key, it.value)
            //ReflectionUtils.setField(field, entity, value)

        }
        println("ssdf")

        return entity as BaseEntity
    }

}