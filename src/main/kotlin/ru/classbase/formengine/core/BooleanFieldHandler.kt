package ru.classbase.formengine.core

import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Component

@Component
class BooleanFieldHandler(private val conversionService: ConversionService) : FieldHandler<Boolean, BooleanField> {

    override fun convert(value: Any?): Boolean? {
        return conversionService.convert(value, Boolean::class.java)
    }

    override fun validateInternal(value: Boolean?, field: BooleanField) {
        if (value == null) {
            if (field.required) {
                throw FormException("${field.id} - обязательное поле")
            }
            return
        }
    }
}