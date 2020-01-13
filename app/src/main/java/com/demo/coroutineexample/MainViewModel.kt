package com.demo.coroutineexample

class MainViewModel : BaseViewModel() {
    private var mainDataSource: MainDataSource = MainDataSource()

    val exampleLiveData: APILiveData<MutableList<User>> by lazy {
        APILiveData<MutableList<User>>()
    }

    fun userList() {
        withLiveData(exampleLiveData){
            mainDataSource.getUserList()
        }
    }
}