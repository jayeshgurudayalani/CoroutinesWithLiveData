package com.demo.coroutineexample

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    private var userListAdapter: UserListAdapter? = null
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        observeLiveData()
        setAdapter()

        buttonCallApi.setOnClickListener {
            mainViewModel.userList()
        }

    }

    private fun observeLiveData() {
        mainViewModel.exampleLiveData.observe(this, ::onSuccess, ::onErrorFromApi)
    }

    private fun onSuccess(responseBody: ResponseBody<MutableList<User>>) {
        userListAdapter!!.addItems(responseBody.data)
    }

    private fun onErrorFromApi(throwable: Throwable): Boolean {
        if (throwable is ServerException && throwable.code == "0") {
            Log.e("MainActivity", throwable.message)
            return false
        }
        return true
    }

    private fun setAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        userListAdapter = UserListAdapter()
        recyclerView.adapter = userListAdapter
    }
}