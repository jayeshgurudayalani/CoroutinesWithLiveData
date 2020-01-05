package com.demo.coroutineexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter : RecyclerView.Adapter<UserListViewHolder>() {

    private val userList = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_raw_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.setData(userList[position])
    }

    fun addItems(list:MutableList<User>){
        userList.addAll(list)
        notifyDataSetChanged()
    }
}