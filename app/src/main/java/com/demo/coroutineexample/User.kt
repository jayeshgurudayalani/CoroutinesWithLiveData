package com.demo.coroutineexample

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id: String,
    @SerializedName("employee_name")
    var employeeName: String,
    @SerializedName("employee_salary")
    var employeeSalary: String,
    @SerializedName("employee_age")
    var employeeAge: String,
    @SerializedName("profile_image")
    var profileImage: String,
    @SerializedName("dummy_field")
    var dummyField:Int
)