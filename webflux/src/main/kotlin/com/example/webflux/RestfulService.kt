package com.example.webflux

import retrofit2.http.GET

/**
 * @author qiuchangdong
 * @Type RestfulService
 * @Desc 。
 * @date 2021-03-11 15:25:22
 */
interface RestfulService {
    @GET("/ok")
    suspend fun ok(): Boolean
}