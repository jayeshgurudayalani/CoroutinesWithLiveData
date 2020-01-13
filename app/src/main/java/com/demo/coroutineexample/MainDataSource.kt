package com.demo.coroutineexample

//import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainDataSource {
    private var demoService: DemoService

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val retrofit = Retrofit.Builder()
            .baseUrl(getUrl())    //http://dummy.restapiexample.com/api/v1/
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(getAuthenticationExceptionInter())
                    .build()
            )
            .build()

        demoService = retrofit.create(DemoService::class.java)
    }

    private fun getUrl(): HttpUrl {
        return HttpUrl.Builder()
            .scheme("http")
            .host("www.mocky.io")
            .addPathSegments("v2/")
            .build()
    }


    suspend fun getUserList(): ResponseBody<MutableList<User>> {
        val map = hashMapOf<String,String>()
        map["mocky-delay"] = "10000ms"
        return demoService.getEmployeeList(map)
    }

    fun getAuthenticationExceptionInter(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val response = chain.proceed(chain.request())
                if (response.code == 401) {
                    throw AuthenticationException("Auth Exception")
                }
                return response
            }
        }
    }
}