package ru.classbase.formengine.forms

import org.springframework.stereotype.Component
import ru.classbase.formengine.core.AbstractForm
import java.math.BigDecimal
import java.math.BigDecimal.ZERO

@Component
class FirstForm : AbstractFirstForm()
abstract class AbstractFirstForm : AbstractForm("firstForm", TestEntity::class) {

    init {
        textField {
            id = "first"
            label = "Первое поле"
            defaultValue = { "" }
        }
        textField {
            id = "second"
            label = "Второе поле"
        }
        decimalField {
            id = "decimalFirst"
            label = "Первое десятичное"
            defaultValue = { ZERO }
        }
    }
}
