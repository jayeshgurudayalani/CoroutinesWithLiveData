package com.demo.coroutineexample

import kotlinx.coroutines.Deferred
import retrofit2.http.PUT
import retrofit2.http.QueryMap

interface DemoService {
    @PUT("5e11d1643100002700593f6b")
    fun getEmployeeList(): Deferred<ResponseBody<MutableList<User>>>

    @PUT("5e1094c635000054001e6984")
    fun getTestDelayResponse(@QueryMap list: HashMap<String, String>): Deferred<Any>
}