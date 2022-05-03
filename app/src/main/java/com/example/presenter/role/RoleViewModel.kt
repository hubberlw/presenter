package com.example.presenter.role

import android.app.Application
import androidx.lifecycle.*
import com.example.presenter.database.PresenterDatabase
import com.example.presenter.database.entity.Role
import kotlinx.coroutines.launch

enum class RolesLoadStatus {LOADING, ERROR, DONE}

class RoleViewModel(app: Application): AndroidViewModel(app) {

    // Roles database loading status
    private val _status = MutableLiveData<RolesLoadStatus>()

    val status: LiveData<RolesLoadStatus>
        get() = _status

    // Roles list
    private val _roles = MutableLiveData<List<Role>>()

    val roles: LiveData<List<Role>>
        get() = _roles

    /**
     * Call getRolesList() on init so we can display status immediately.
     */
    init {
        getRolesList(app)
    }

    /**
     * Sets the value of the response LiveData to the Mars API status or the successful number of
     * Mars properties retrieved.
     */
    private fun getRolesList(application:Application) {
        viewModelScope.launch {
                 val database = PresenterDatabase.getInstance(application).presenterDao()
                _roles.value = database.getFullRoleList()
        }
    }
//    private fun getRolesList(app:Application) {
//        viewModelScope.launch {
//            _status.value = RolesLoadStatus.LOADING
//            try {
//                val database = PresenterDatabase.getInstance(app).presenterDao()
//                _roles.value = database.getFullRoleList()
//                _status.value = RolesLoadStatus.DONE
//            } catch (e: Exception) {
//                _status.value = RolesLoadStatus.ERROR
//                _roles.value = ArrayList()
//            }
//        }
//    }

//    private suspend fun insert(role: Role) {
//        database.insertRole(role)
//    }
}