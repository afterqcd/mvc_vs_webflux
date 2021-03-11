package com.example.webflux

import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactive.awaitSingleOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.ReactiveStringRedisTemplate
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange
import reactor.core.publisher.Mono

/**
 * @author qiuchangdong
 * @Type HelloController
 * @Desc 。
 * @date 2021-03-09 11:54:56
 */
@RestController
class HelloController(
    val repository: PersonRepository,
    val redis: ReactiveStringRedisTemplate,
    val restfulService: RestfulService
) {

    @GetMapping("/hello")
    suspend fun hello(): String {
        return "Hello"
    }

    @GetMapping("/database")
    suspend fun database(@RequestParam("id") id: Int): String? {
        return repository.findById(id)?.name
    }

    @GetMapping("/restful")
    suspend fun restful(): String {
        val ok = restfulService.ok()
        return  if (ok) "Ok" else "Oops"
    }

    @GetMapping("/ok")
    suspend fun ok(): Boolean {
        return true
    }

    @GetMapping("/redis")
    suspend fun redis(): String {
        return redis.opsForHash<String, String>()
            .get("testh", "test").awaitSingleOrNull()
    }
}