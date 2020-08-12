package yh.study.producer

import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder


/**
 * @author Yonghui
 * @since 2020. 08. 12
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
open class ProducerBase {
    @Autowired
    lateinit var evenOddController: EvenOddController

    @Before
    fun setup() {
        val standaloneMockMvcBuilder: StandaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(evenOddController)
    }
}