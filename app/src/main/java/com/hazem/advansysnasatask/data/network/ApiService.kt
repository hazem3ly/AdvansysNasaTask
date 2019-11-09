package com.hazem.advansysnasatask.data.network

import com.hazem.advansysnasatask.data.Const
import com.hazem.advansysnasatask.data.Const.SEARCH_URL
import com.hazem.advansysnasatask.data.network.interceptor.ConnectivityInterceptor
import com.hazem.advansysnasatask.data.network.apiresponse.genelab.GenelabBaseResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


interface ApiService {


    @GET(SEARCH_URL)
    fun getGenelabData():
            Single<GenelabBaseResponse>


    companion object {
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): ApiService {
            val okHttpClient = getOkHttpClient(connectivityInterceptor)

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Const.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

        private fun getOkHttpClient(connectivityInterceptor: ConnectivityInterceptor) =
            OkHttpClient().newBuilder()
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60L, TimeUnit.SECONDS)
                .build()

    }

}