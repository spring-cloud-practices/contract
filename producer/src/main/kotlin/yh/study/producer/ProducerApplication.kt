package yh.study.producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@Configuration
class ProducerApplication {
    @Bean
    fun restTemplate(): RestTemplate = RestTemplateBuilder().build()
}

fun main(args: Array<String>) {
    runApplication<ProducerApplication>(*args)
}
