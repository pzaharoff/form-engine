package ru.classbase.formengine.core

import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class DecimalFieldHandler(private val conversionService: ConversionService) : FieldHandler<BigDecimal, DecimalField> {

    override fun convert(value: Any?): BigDecimal? {
        return conversionService.convert(value, BigDecimal::class.java)
    }

    override fun validateInternal(value: BigDecimal?, field: DecimalField) {
        if (value == null) {
            if (field.required) {
                throw FormException("${field.id} - обязательное поле")
            }
            return
        }

        if (field.minValue != null && value < field.minValue) {
            throw FormException("${field.id} - минимальное значение = ${field.minValue}")
        }
        if (field.maxValue != null && value > field.maxValue) {
            throw FormException("${field.id} - максимальное значение = ${field.maxValue}")
        }

    }
}