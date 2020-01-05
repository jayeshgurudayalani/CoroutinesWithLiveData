package com.demo.coroutineexample

data class ServerException(val code: String, override val message: String) : Throwable() {
}