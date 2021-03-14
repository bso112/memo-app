package com.manta.domain.entity

import androidx.recyclerview.widget.DiffUtil

data class Memo (
    var content : String = ""
){
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Memo>(){
            override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
                return oldItem.content == newItem.content
            }

            override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
                return oldItem == newItem
            }

        }
    }
}