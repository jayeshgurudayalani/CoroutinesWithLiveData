package com.demo.coroutineexample

import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun onError(throwable: Throwable) {
        if (throwable is ServerException) {
            Log.e("BaseActivity", throwable.message)
        }else if(throwable is AuthenticationException){
            Log.e("BaseActivity",throwable.message)
        } else {
            Log.e("BaseActivity", "unknown error from baseactivity ${throwable.message}")
        }
    }
}