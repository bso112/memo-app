package com.manta.memo.tools.app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.manta.memo.util.AppDisposable
import com.manta.memo.util.AppDisposableImpl
import com.manta.memo.util.AppDisposableOwner
import dagger.android.support.DaggerAppCompatActivity

abstract class AppActivity<T : ViewDataBinding>(
    @LayoutRes private val contentLayoutId : Int
) : DaggerAppCompatActivity(), AppDisposableOwner {

    override val disposable: AppDisposable = AppDisposableImpl()

    protected val binding : T by lazy{
        DataBindingUtil.setContentView<T>(this, contentLayoutId)
    }


    protected inline fun binding(block: T.() -> Unit): T {
        return binding.apply(block)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}