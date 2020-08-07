package yh.study.producer

import io.restassured.module.mockmvc.RestAssuredMockMvc
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification
import io.restassured.response.ResponseOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.setup.MockMvcBuilders


/**
 * @author Yonghui
 * @since 2020. 08. 07
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
class BaseTestClass {
    @Autowired
    private val evenOddController: EvenOddController? = null

    @Before
    fun setup() {
        val standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(evenOddController)
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder)
    }

    @Test
    @Throws(Exception::class)
    fun validate_shouldReturnEvenWhenRequestParamIsEven() {
        // given:
        val request: MockMvcRequestSpecification = given()

        // when:
        val response: ResponseOptions<*> = given().spec(request)
            .queryParam("number", "2")
            .get("/validate/prime-number")

        // then:
        assertThat(response.statusCode()).isEqualTo(200)

        // and:
        val responseBody = response.getBody().asString()
        assertThat(responseBody).isEqualTo("Even")
    }
}