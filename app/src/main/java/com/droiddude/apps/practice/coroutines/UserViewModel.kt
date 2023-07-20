package com.droiddude.apps.practice.coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val repository : UserRepository) : ViewModel() {

    private var _user = MutableStateFlow<User?>(null)

    val user : StateFlow<User?> = _user

    fun getUserById(id : Int) {
        viewModelScope.launch {
            _user.value = repository.getUserById(id) }
    }
}