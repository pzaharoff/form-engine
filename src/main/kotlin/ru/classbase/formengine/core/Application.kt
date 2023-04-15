package ru.classbase.formengine.core

import mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.stereotype.Component
import ru.classbase.formengine.form.Form

@Component
class Application(private val resourceLoader: ResourceLoader, formLocations: List<String> = listOf()) {
    private val forms =  mutableMapOf<String, Form>()


    init {
        val locations = formLocations.ifEmpty { listOf("classpath:/forms/**/*.json") }
        val resolver = PathMatchingResourcePatternResolver(resourceLoader)

        locations.forEach { location ->
            resolver.getResources(location).forEach { formResource ->
                val form = mapper.readValue(formResource.inputStream, Form::class.java)

                if (forms.containsKey(form.id)) {
                    throw FormException("Найдены формы с повторяющимся ключом: ${form.id}")
                } else {
                    forms[form.id] = form
                }

            }
        }
    }

    fun getForm(formId: String): Form {
        return forms.getOrElse(formId) {
            throw FormException("Форма с id=$formId не найдена")
        }
    }

    fun getForms() = forms
}