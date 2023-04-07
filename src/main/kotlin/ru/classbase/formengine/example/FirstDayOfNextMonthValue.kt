package ru.classbase.formengine.example

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class FirstDayOfNextMonthValue {

    fun getValue(): String {
        return LocalDate.now().plusMonths(1).withDayOfMonth(1).toString()
    }

}