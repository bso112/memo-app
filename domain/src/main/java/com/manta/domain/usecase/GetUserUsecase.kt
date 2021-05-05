package com.manta.domain.usecase

import com.manta.domain.data.UserData
import com.manta.domain.repository.Repository
import javax.inject.Inject

class GetUserUsecase @Inject constructor(private val repo : Repository)  {
    fun getUser() : UserData = repo.getUserData()
}