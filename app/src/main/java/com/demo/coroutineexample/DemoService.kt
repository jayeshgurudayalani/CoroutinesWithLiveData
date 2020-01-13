package com.demo.coroutineexample

import retrofit2.http.PUT
import retrofit2.http.QueryMap

interface DemoService {
    @PUT("5e11d1643100002700593f6b")
    suspend fun getEmployeeList(): ResponseBody<MutableList<User>>

    @PUT("5e1094c635000054001e6984")
    suspend fun getTestDelayResponse(@QueryMap list: HashMap<String, String>): Any
}