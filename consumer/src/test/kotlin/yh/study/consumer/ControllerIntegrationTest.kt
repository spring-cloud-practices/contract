package yh.study.consumer

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


/**
 * @author Yonghui
 * @since 2020. 08. 07
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = ["yh.study:producer:+:stubs:8090"]
)
class ControllerIntegrationTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun given_WhenPassEvenNumberInQueryParam_ThenReturnEven() {
        mvc.perform(
            MockMvcRequestBuilders
                .get("/calculate?number=2")
                .contentType(MediaType.APPLICATION_JSON.toString())
        )
            .andExpect(status().isOk)
            .andExpect(content().string("Even"))
    }
}