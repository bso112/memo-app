package com.manta.memo.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.annotation.DrawableRes
import androidx.lifecycle.LifecycleOwner
import com.manta.memo.R
import com.manta.memo.data.Memo
import com.manta.memo.databinding.AppDialogLayoutBinding
import com.manta.memo.tools.app.BuilderBase
import com.manta.memo.tools.app.LifecycleAware

class AppDialog<T>(
    builder: Builder<T>
) : Dialog(builder.context, getThemeResId(builder.windowWidth)), LifecycleAware {

    companion object{
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


    private var binding: AppDialogLayoutBinding =
        AppDialogLayoutBinding.inflate(LayoutInflater.from(builder.context))

    init {
        binding.icon = builder.image
        binding.content = builder.content
        binding.title = builder.title
        binding.delegate = builder.delegate
        binding.memo = builder.toDelete //삭제할 메모
        binding.dialog = this

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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



    //꼭 있어야하는건 생성자로
    class Builder<T>(val context: Context, val toDelete : Memo) : BuilderBase {
        @DrawableRes
        var image : Int = 0
        var title : String = ""
        var content : String = ""
        var delegate : AppDialogDelegate<T>? = null
        var windowWidth = 0

        fun build(): AppDialog<T> {
            return AppDialog(this)
        }

    }
}



interface AppDialogDelegate<T>{
    /**
     * @param contents : 이 다이어로그가 설명하는 대상
     * ex) 삭제 다이어로그면 삭제하는 대상
     * @param dialog : 이 콜백을 수행할 다이어로그
     */
    fun onConfirm(contents : T, dialog : Dialog)

    /**
     * @param contents : 이 다이어로그가 설명하는 대상
     * ex) 삭제 다이어로그면 삭제하는 대상
     * @param dialog : 이 콜백을 수행할 다이어로그
     */
    fun onCancel(contents : T, dialog : Dialog)
}