package ru.classbase.formengine

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import ru.classbase.formengine.core.AbstractForm

@SpringBootTest
class GeneratorTest {

    @Test
    fun createForm() {

    }

    class TestForm : AbstractForm() {
        init {

        }
    }
    //@Autowired
    //lateinit var formEngine: FormEngine
    /*
        @Autowired
        lateinit var loader: ResourceLoader

        @Autowired
        lateinit var em: EntityManager

        @Autowired
        lateinit var tx: TransactionTemplate
    */

    @Test
    fun generate() {
        /* val request = CreateReq(
             "PartnerForm",
             mapOf(
                 "name" to "Наименование",
                 "amount" to "20",
                 "cost" to "25",
                 "active" to "true"
             )
         )

         val response = formEngine.create(request)

         println(response)*/

        /*
                    val formResource = loader.getResource("classpath:PartnerForm.json")
                    val form = mapper.readValue(formResource.inputStream, Form::class.java)

                    val partner = Partner().apply {
                        name = "Наименование"
                        amount = 20
                        cost = "25".toBigDecimal()
                        active = true
                    }

                    tx.execute {
                        em.persist(partner)
                    }


                    println(form)
            */
    }

}