package ru.classbase.formengine.form

import ru.classbase.formengine.core.Role

data class Form(
    val id: String,
    val label: String,
    val entityName: String,
    val fields: List<Field>,
    val permissions: Map<FormAction, Set<Role>> = mapOf(),
)


enum class FormAction(val label: String) {
    CREATE("Создать запись"),
    READ("Чтение записи"),
    UPDATE("Обновление записи"),
    DELETE("Удаление записи"),
    LIST("Чтение списка строк")
}