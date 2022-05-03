package com.example.presenter.role

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presenter.databinding.ItemRoleBinding
import com.example.presenter.database.entity.Role

class RoleAdapter: ListAdapter<Role,RoleAdapter.RoleViewHolder>(DiffCallback) {

    class RoleViewHolder(private var binding: ItemRoleBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(role: Role) {
            binding.role = role
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Role>() {
        override fun areItemsTheSame(oldItem: Role, newItem: Role): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: Role, newItem: Role): Boolean {
            return oldItem.roleId == newItem.roleId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoleViewHolder {
        return RoleViewHolder(ItemRoleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RoleViewHolder, position: Int) {
        val job = getItem(position)
        holder.bind(job)
    }
}