package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * @author Yonghui* @since 2020. 08. 07
 */

Contract.make {
    description "should return even when number input is even"
    request {
        method GET()
        url("/validate/prime-number") {
            queryParameters {
                parameter("number", "2")
            }
        }
    }
    response {
        body("Even")
        status 200
    }
}
