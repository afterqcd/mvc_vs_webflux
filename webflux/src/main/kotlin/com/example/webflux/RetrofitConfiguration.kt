package com.example.webflux

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * @author qiuchangdong
 * @Type RetrofitConfiguration
 * @Desc 。
 * @date 2021-03-11 15:28:05
 */
@Configuration
class RetrofitConfiguration {
    @Bean
    fun restfulService(): RestfulService {
        return Retrofit.Builder()
            .baseUrl("http://127.0.0.1:82")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(RestfulService::class.java)
    }
}