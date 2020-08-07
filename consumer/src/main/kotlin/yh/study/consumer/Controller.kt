package yh.study.consumer

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


/**
 * @author Yonghui
 * @since 2020. 08. 07
 */
@RestController
class Controller(val restTemplate: RestTemplate) {
    @GetMapping("/calculate")
    fun checkOddAndEven(@RequestParam("number") number: Int): String? {
        val httpHeaders = HttpHeaders()
        httpHeaders.add("Content-Type", "application/json")
        val responseEntity = restTemplate.exchange(
            "http://localhost:8090/validate/prime-number?number=$number",
            HttpMethod.GET,
            HttpEntity(null, httpHeaders),
            String::class.java
        )
        return responseEntity.body
    }
}