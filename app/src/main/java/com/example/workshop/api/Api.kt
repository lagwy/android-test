package com.example.workshop.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Api {

    init {
        val retrofit = initRetrofit()
        initServices(retrofit)
    }

    companion object {

        private var api: Routes? = null

        fun service() : Routes {
            if (api == null) {
                initServices(initRetrofit())
            }
            return api!!
        }

        private fun initRetrofit() : Retrofit {

            val client = OkHttpClient.Builder()

            // Interceptors
            client.addInterceptor(HeadersInterceptor())

            return Retrofit.Builder()
                .client(client.build())
                .baseUrl("https://api.tibiaccs.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun initServices(retrofit: Retrofit) {
            api = retrofit.create(Routes::class.java)
        }

    }

}

class HeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .method(request.method, request.body)
        request = builder.build()

        return chain.proceed(request)
    }

}