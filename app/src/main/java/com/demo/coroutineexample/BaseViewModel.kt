package com.demo.coroutineexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    fun <T> withLiveData(
        liveData: APILiveData<T>,
        callServiceFun: suspend () -> ResponseBody<T>
    ) {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            liveData.postValue(DataWrapper(null, throwable))
        }) {
            //            val response = defeer.await()
//            liveData.postValue(DataWrapper(response, null))
            val response = callServiceFun()
            liveData.postValue(DataWrapper(response, null))
        }
    }
}