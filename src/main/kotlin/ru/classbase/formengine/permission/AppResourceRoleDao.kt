package ru.classbase.formengine.permission

import org.springframework.data.jpa.repository.JpaRepository
import ru.classbase.formengine.model.AppResourceRole
import java.util.*

interface AppResourceRoleDao : JpaRepository<AppResourceRole, UUID>
