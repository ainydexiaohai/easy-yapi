package com.itangcent.suv.http

import org.apache.http.client.HttpClient

abstract class AbstractHttpClientProvider : HttpClientProvider {

    var httpClientInstance: HttpClient? = null

    override fun getHttpClient(): HttpClient {
        if (httpClientInstance == null) {
            synchronized(this)
            {
                if (httpClientInstance == null) {
                    httpClientInstance = buildHttpClient()
                }
            }
        }
        return httpClientInstance!!
    }

    abstract fun buildHttpClient(): HttpClient
}