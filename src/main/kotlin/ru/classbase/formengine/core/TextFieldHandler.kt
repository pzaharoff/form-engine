package ru.classbase.formengine.core

import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Component

@Component
class TextFieldHandler(private val conversionService: ConversionService) : FieldHandler<String, TextField> {

    override fun convert(value: Any?): String? {
        return conversionService.convert(value, String::class.java)
    }

    override fun validateInternal(value: String?, field: TextField) {
        if (value == null) {
            if (field.required) {
                throw FormException("${field.id} - обязательное поле")
            }
            return
        }

        if (value.length < field.minLength || value.length > field.maxLength) {
            throw FormException("${field.id} - длина строки должна быть от ${field.minLength} до ${field.maxLength} ")
        }

        if (field.pattern != null && !value.matches(Regex(field.pattern!!))) {
            throw FormException("${field.id} - значение не соответствует регулярному выражению [${field.pattern}] ")
        }
    }
}