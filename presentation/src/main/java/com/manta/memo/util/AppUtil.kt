package com.manta.memo.util

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.util.Log
import android.util.TypedValue
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

object AppUtil {


    val EXTRA_MEMO = "com.manta.memo.presentation.creatememo.EXTRA_MEMO"
    val EXTRA_MEMO_ID = "com.manta.memo.presentation.creatememo.EXTRA_MEMO_ID"

    fun dp2Px(context: Context, dp: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        ).toInt()
    }

    fun toast(msg: String) {
        Toast.makeText(AppContext.context, msg, Toast.LENGTH_SHORT).show()
    }

    fun LogD(log: String?) {
        Log.d("myTest", log ?: "error occur with no message")
    }

    fun LogE(log: String?) {
        Log.e("myTest", log ?: "error occur with no message")
    }

    fun getColor(@ColorRes res: Int): Int {
        return AppContext.context.resources.getColor(res)
    }

    fun getColorTintList(@ColorRes res: Int): ColorStateList {
        return AppContext.context.resources.getColorStateList(res)
    }


    fun getDate(date: Date): String {
        return SimpleDateFormat(
            "yyyy-MM-dd",
            AppContext.context.resources.configuration.locale
        ).format(date)
    }
}