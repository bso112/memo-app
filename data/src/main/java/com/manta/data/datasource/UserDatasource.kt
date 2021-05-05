package com.manta.data.datasource

import com.manta.data.Entity.UserEntity

interface UserDatasource {
    var userName : String
    fun getUser() : UserEntity
}