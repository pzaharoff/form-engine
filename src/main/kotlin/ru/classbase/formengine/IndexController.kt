package ru.classbase.formengine

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import ru.classbase.formengine.core.CreateReq
import ru.classbase.formengine.core.CreateRs
import ru.classbase.formengine.core.FormEngine
import ru.classbase.formengine.model.Role
import ru.classbase.formengine.model.User
import ru.classbase.formengine.permission.UserDto
import ru.classbase.formengine.permission.UserManager


@RestController
class IndexController(private val formEngine: FormEngine, private val userManager: UserManager) {


    @PostMapping("create")
    fun create(request: CreateReq, role: Role?, user: User): CreateRs? {
        val role = userManager.selectRole(role, user)
        return formEngine.create(request, role)
    }

}