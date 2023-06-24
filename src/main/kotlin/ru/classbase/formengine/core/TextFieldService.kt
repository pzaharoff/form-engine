package ru.classbase.formengine.core

import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Component

@Component
class TextFieldService(private val conversionService: ConversionService) {

    fun convert(value: Any?) : String? {
        return conversionService.convert(value, String::class.java)
    }

    fun validate(value: String?, field: TextField) {

    }
}