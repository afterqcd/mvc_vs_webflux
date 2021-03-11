package com.example.webflux

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

/**
 * @author qiuchangdong
 * @Type PersonRepository
 * @Desc 。
 * @date 2021-03-10 10:18:28
 */
interface PersonRepository: CoroutineCrudRepository<Person, Int> {
}