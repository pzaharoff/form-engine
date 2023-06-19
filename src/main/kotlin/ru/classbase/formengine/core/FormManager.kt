package ru.classbase.formengine.core

import jakarta.annotation.PostConstruct
import org.springframework.context.ApplicationContext

import org.springframework.stereotype.Component

@Component
class FormManager(private val ctx: ApplicationContext) {
    private val forms = hashMapOf<String, Form>()

    @PostConstruct
    fun initForms() {
        ctx.getBeansOfType(Form::class.java).values.forEach { form ->
            if (forms.putIfAbsent(form.formId, form) != null) {
                throw IllegalStateException("Duplicate form with id=${form.formId}, class=${form::class.java.simpleName}")
            }
        }
    }

    fun get(formId: String) = forms[formId] ?: throw IllegalStateException("Form not found, id=${formId}")
}