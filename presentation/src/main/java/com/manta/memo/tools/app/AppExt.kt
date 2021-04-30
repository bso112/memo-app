package com.manta.memo.tools.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.toLiveData() : LiveData<T> = this