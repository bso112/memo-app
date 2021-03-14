package com.manta.memo.util

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class AppViewHolder<T>(private val binding : ViewBinding) : RecyclerView.ViewHolder(binding.root){
    abstract fun bindDataOnView(data : T)
}

