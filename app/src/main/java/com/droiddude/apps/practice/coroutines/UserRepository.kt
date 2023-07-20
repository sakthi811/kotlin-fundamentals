package com.droiddude.apps.practice.coroutines

class UserRepository {

    suspend fun getUserById(id : Int) : User? {
        return User(3,"Sam","sam.andersson@gmail.com")
    }
}