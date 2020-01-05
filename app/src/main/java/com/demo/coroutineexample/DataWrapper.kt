package com.demo.coroutineexample

data class DataWrapper<T>(
    var responseBody: ResponseBody<T>? = null,
    var throwable: Throwable? = null
) {
}