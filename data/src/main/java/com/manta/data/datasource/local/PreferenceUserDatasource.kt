package com.manta.data.datasource.local

import android.content.Context
import com.manta.data.Entity.UserEntity
import com.manta.data.datasource.UserDatasource
import com.manta.data.datasource.local.delegate.StringPref
import com.manta.data.datasource.local.delegate.PreferenceModel

class PreferenceUserDatasource(override val context: Context) : PreferenceModel, UserDatasource {
    override var userName : String by StringPref()
    override fun getUser(): UserEntity {
        return UserEntity(userName)
    }
    


}