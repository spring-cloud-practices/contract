package yh.study.producer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


/**
 * @author Yonghui
 * @since 2020. 08. 07
 */
@RestController
class EvenOddController {
    @GetMapping("/validate/prime-number")
    fun isNumberPrime(@RequestParam("number") number: Int): String {
        return if (number % 2 == 0) "Even" else "Odd"
    }
}