package com.demo.coroutineexample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_raw_layout.view.*

class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(user: User) {
        itemView.textViewName.text = user.employeeName
    }
}