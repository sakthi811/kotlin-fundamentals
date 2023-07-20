package com.droiddude.apps.practice.coroutines

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class UserFragment : Fragment() {

    private val userViewModel : UserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = 3

        userViewModel.getUserById(userId)

        userViewModel.user.onEach { user ->
            println(user?.name)
            println(user?.email)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}