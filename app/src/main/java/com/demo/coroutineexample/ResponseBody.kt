package com.demo.coroutineexample

import com.google.gson.annotations.SerializedName

data class ResponseBody<T>(
    @SerializedName("code")
    var code: String,
    @SerializedName("message")
    var message: String,
    @SerializedName("data")
    var data: T
)