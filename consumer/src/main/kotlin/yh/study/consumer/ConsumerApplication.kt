package yh.study.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class ConsumerApplication {
}

fun main(args: Array<String>) {
    runApplication<ConsumerApplication>(*args)
}
