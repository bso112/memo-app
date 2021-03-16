package com.manta.memo.data

import androidx.annotation.ColorRes
import androidx.recyclerview.widget.DiffUtil

data class Memo (
    var content : String = "",
    var title : String = "",
    var isFolder : Boolean = false,
    var date : String = "",
    @ColorRes var filter : Int = 0
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