package com.manta.memo.binding

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("onLongClick")
    fun View.setOnLongClick(onLongClick : ()->Unit){
        setOnLongClickListener {
            onLongClick()
            false
        }
    }
}