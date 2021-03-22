package com.manta.memo.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager

import androidx.annotation.DrawableRes
import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.MutableLiveData
import com.manta.memo.R
import com.manta.memo.tools.app.LifecycleAware
import com.manta.memo.util.AppUtil

abstract class AppDialog(
    context: Context,
    windowWidth: Int = 0
) : Dialog(context, R.style.RoundedCornersDialog), LifecycleAware {

    private var onConfirmListener: (() -> Unit)? = null
    private var onCancelListener: (() -> Unit)? = null


    //이렇게하고 xml에 연결해두면 시점상관없이 외부에서 set하면 바로 갱신된다.
    //따라서 생성자로 이 모든걸 미리 다 받을 필요없음. builder패턴도 필요없음.
    val _imageResource = MutableLiveData(0)

    @DrawableRes
    var imageResource = _imageResource.value
    val title = MutableLiveData("asdf")
    val content = MutableLiveData("asdfasdf")
    val cancelText = MutableLiveData("")
    val confirmText = MutableLiveData("")

    companion object {
        const val MIN_WIDTH = 0
        const val MATCH_PARENT = 1
        const val WRAP_CONTENT = 2

        //constructor에서 쓸것이기 때문에 object안에 있어야함.
        private fun getThemeResId(windowWidth: Int): Int {
            return when (windowWidth) {
                MIN_WIDTH -> R.style.AppTheme_Dialog_MinWidth
                MATCH_PARENT -> R.style.AppTheme_Dialog_Match
                else -> 0
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.attributes?.width = AppUtil.dp2Px(context, 300F)
        window?.attributes?.height = WindowManager.LayoutParams.MATCH_PARENT
    }





    override fun addLifecyclerOwner(lifecyclerOwner: LifecycleOwner) {
        lifecyclerOwner.lifecycle.addObserver(this)
    }

    override fun onOwnerResume() {

    }

    override fun onOwnerPause() {

    }

    override fun onOwnerDestroy() {
        dismiss()
    }

    fun onConfirm() {
        onConfirmListener?.let { it() }
        dismiss()
    }

    fun onCancel() {
        onCancelListener?.let { it() }
        dismiss()
    }


    fun setOnConfirmListener(listener: () -> Unit) {
        onConfirmListener = listener
    }

    fun setOnCancelListener(listener: () -> Unit) {
        onCancelListener = listener
    }


}



