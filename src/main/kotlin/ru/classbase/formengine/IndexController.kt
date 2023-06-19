package ru.classbase.formengine

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import ru.classbase.formengine.core.CreateReq
import ru.classbase.formengine.core.CreateRs
import ru.classbase.formengine.core.FormEngine


@RestController
class IndexController(private val formEngine: FormEngine) {


    @PostMapping("create")
    fun create(request: CreateReq): CreateRs? {
        return formEngine.create(request)
    }

}