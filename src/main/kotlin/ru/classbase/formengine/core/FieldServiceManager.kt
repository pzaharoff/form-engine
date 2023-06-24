package ru.classbase.formengine.core

import jakarta.annotation.PostConstruct
import org.springframework.context.ApplicationContext

import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@Component
class FieldServiceManager(private val ctx: ApplicationContext) {
    private val services = hashMapOf<KClass<*>, FieldHandler<*, *>>()

    @PostConstruct
    fun initServices() {
        ctx.getBeansOfType(FieldHandler::class.java).values.forEach { service ->
            if (services.putIfAbsent(service::class, service) != null) {
                throw IllegalStateException("Duplicate service with class=${service::class}")
            }
        }
    }

    fun get(type: KClass<*>) = services[type] ?: throw IllegalStateException("Service not found, class=${type}")
    fun get(field: Field<*>) = services[field::class] ?: throw IllegalStateException("Service not found, class=${field::class}")
}