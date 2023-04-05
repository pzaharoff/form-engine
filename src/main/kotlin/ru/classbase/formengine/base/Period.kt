package ru.classbase.formengine.base

import java.time.LocalDate

interface Period {
    /**
     * Начало периода действия
     */
    var startDate: LocalDate

    /**
     * Окончание периода действия
     */
    var endDate: LocalDate?
}