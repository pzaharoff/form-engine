package ru.classbase.formengine.model

enum class Permission {
    ENABLED, DISABLED, DENY
}

enum class AppResourceType {
    FORM, FIELD, ACTION, FORM_ACTION
}

enum class FormAction(val label: String) {
    CREATE("Создать запись"),
    READ("Чтение записи"),
    UPDATE("Обновление записи"),
    DELETE("Удаление записи"),
    LIST("Чтение списка строк"),
    SORT("Сортировка"),
    SEARCH("Поиск")
}