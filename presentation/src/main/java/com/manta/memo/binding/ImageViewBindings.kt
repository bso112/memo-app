package com.manta.memo.binding

import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.databinding.BindingAdapter
import com.manta.memo.util.AppUtil

object ImageViewBindings {

    @JvmStatic
    @BindingAdapter("colorFilter")
    fun ImageView.setColorFilter(@ColorRes res : Int){
        backgroundTintList = AppUtil.getColorTintList(res)
    }
}