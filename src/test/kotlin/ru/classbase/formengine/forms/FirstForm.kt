package ru.classbase.formengine.forms

import org.springframework.stereotype.Component
import ru.classbase.formengine.core.AbstractForm

@Component
class FirstForm : AbstractFirstForm()
abstract class AbstractFirstForm : AbstractForm("firstForm") {

    init {
        field {
            id = "first"
            label = "Первое поле"
        }
        field {
            id= "second"
            label = "Второе поле"
        }
    }
}