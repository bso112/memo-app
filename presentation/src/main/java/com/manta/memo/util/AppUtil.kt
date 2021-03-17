package com.manta.memo.util

import android.content.Context
import android.util.Log
import android.util.TypedValue
import android.widget.Toast

object AppUtil {

    fun dp2Px(context: Context, dp : Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics).toInt()
    }

    fun toast(msg : String){
        Toast.makeText(AppContext.context, msg, Toast.LENGTH_SHORT).show()
    }

    fun log(log : String){
        Log.d("myTest", log)
    }
}