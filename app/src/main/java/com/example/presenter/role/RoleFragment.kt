package com.example.presenter.role

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.presenter.R
import com.example.presenter.databinding.FragmentRoleBinding

class RoleFragment: Fragment() {
    /**
     * Displays roles, categories and, optionally, persons.
     * Filters include all roles, checked roles, unchecked roles, all persons, no persons,
     * selected persons, and selected categories.
     * Sorted by role name or category name.
     */

    private val roleViewModel: RoleViewModel by lazy {
        ViewModelProvider(this)[RoleViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentRoleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_role, container, false)

        // To use the View Model with data binding, explicitly give the binding
        // object a reference to it.
        binding.roleViewModel = roleViewModel

        val adapter = RoleAdapter()
        binding.rvRoleList.adapter = adapter

        return binding.root
    }
}