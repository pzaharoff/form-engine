package ru.classbase.formengine.common

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.classbase.formengine.model.AppResourceType
import ru.classbase.formengine.model.Role
import java.util.*

interface JpaDao<T> : JpaRepository<T, UUID>