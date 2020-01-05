package com.demo.coroutineexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class APILiveData<T> : MutableLiveData<DataWrapper<T>>() {

    fun observe(
        owner: BaseActivity,
        onSuccess: (ResponseBody<T>) -> Unit,
        onError: (Throwable) -> Boolean = { true }
    ) {
        super.observe(owner, Observer<DataWrapper<T>> {
            if(it.responseBody != null){
                if (it.responseBody!!.code == "1") {
                    onSuccess(it.responseBody!!)
                } else {
                    val serverException =
                        ServerException(it.responseBody!!.code, it.responseBody!!.message)
                    if (onError(serverException)) {
                        owner.onError(serverException)
                    }
                }
            }else{
                owner.onError(it.throwable!!)
            }
        })
    }
}