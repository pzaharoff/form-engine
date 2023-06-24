package ru.classbase.formengine.core

import ru.classbase.formengine.core.ResponseStatus.OK
import java.util.*

enum class ResponseStatus {
    OK, ERROR, WARNING, VALIDATION_ERROR, FORBIDDEN
}

data class CreateReq(
    val form: String,
    val data: Map<String, Any?> = hashMapOf()
)

data class CreateRs(
    val id: UUID,
    val form: String,
    val data: Map<String, Any?> = hashMapOf(),
    val status: ResponseStatus = OK,
    val message: String = "",
)

data class UpdateReq(
    val form: String,
    val id: UUID,
    val data: Map<String, Any?>
)

data class UpdateRs(
    val id: UUID,
    val entity: String,
    val data: Map<String, Any?>
)
