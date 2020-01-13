package com.demo.coroutineexample

import retrofit2.http.PUT
import retrofit2.http.QueryMap

interface DemoService {
    @PUT("5e1c1c383200002b002281a3")
    suspend fun getEmployeeList(@QueryMap list: HashMap<String, String>): ResponseBody<MutableList<User>>

    @PUT("5e1094c635000054001e6984")
    suspend fun getTestDelayResponse(@QueryMap list: HashMap<String, String>): Any
}