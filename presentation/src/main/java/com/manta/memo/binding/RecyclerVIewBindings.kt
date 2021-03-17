package com.manta.memo.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.manta.memo.tools.app.AppAdapter

object RecyclerVIewBindings {

    @JvmStatic
    @BindingAdapter("items")
    fun RecyclerView.setItems(items: List<Nothing>?) {
        if (this.adapter is ListAdapter<*,*>) {
            (this.adapter as ListAdapter<*,*>).submitList(items)
        }
    }
}