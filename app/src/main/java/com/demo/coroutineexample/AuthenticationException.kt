package com.demo.coroutineexample

import java.io.IOException

class AuthenticationException(override val message: String) : IOException() {
}