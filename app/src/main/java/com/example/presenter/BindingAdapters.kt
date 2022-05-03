package com.example.presenter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presenter.database.entity.Role
import com.example.presenter.role.RoleAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Role>?) {
    val adapter = recyclerView.adapter as RoleAdapter
    adapter.submitList(data)
}
