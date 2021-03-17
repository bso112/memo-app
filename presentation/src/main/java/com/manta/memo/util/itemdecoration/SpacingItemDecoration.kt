package com.manta.memo.util.itemdecoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.manta.memo.util.AppUtil

class SpacingItemDecoration(context: Context, offsetInDP : Float) : RecyclerView.ItemDecoration() {

    private var offsetInDP = 0

    init {
        this.offsetInDP = AppUtil.dp2Px(context, offsetInDP)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)


        outRect.bottom = offsetInDP
        outRect.top = offsetInDP
        outRect.right = offsetInDP
        outRect.left = offsetInDP

    }


}