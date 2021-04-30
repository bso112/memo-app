package com.manta.memo.presentation.memo

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manta.memo.R
import com.manta.memo.databinding.ActivityMainBinding
import com.manta.memo.presentation.creatememo.CreateMemoActivity
import com.manta.memo.presentation.dialog.DeleteMemoDialog
import com.manta.memo.tools.app.AppActivity
import com.manta.memo.util.AppUtil
import com.manta.memo.util.itemdecoration.SpacingItemDecoration
import javax.inject.Inject


class MainActivity : AppActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val REQUEST_CREATE_MEMO = 0

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    //내부적으로 팩토리를 이용해 viewModel을 생성.
    private val memoViewModel: MemoViewModel by viewModels { factory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding {
            lifecycleOwner = this@MainActivity
            recycler.adapter = MemoAdapter(memoViewModel)
            recycler.addItemDecoration(SpacingItemDecoration(this@MainActivity, 10F))
            viewModel = memoViewModel
        }

        memoViewModel.onClickCreateMemoEvent.observe(this, Observer {
            Intent(this, CreateMemoActivity::class.java).apply {
                startActivityForResult(this, REQUEST_CREATE_MEMO)
            }
        })

        memoViewModel.onClickMemoEvent.observe(this, Observer {
            Intent(this@MainActivity, CreateMemoActivity::class.java).apply {
                putExtra(AppUtil.EXTRA_MEMO, it)
                startActivityForResult(this, REQUEST_CREATE_MEMO)
            }
        })

        memoViewModel.onLongClickMemoEvent.observe(this, Observer {
            DeleteMemoDialog(this).apply {
                setOnConfirmListener { memoViewModel.deleteMemo(it); memoViewModel.getAll(); }
            }.show()
        })

        memoViewModel.getAll()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CREATE_MEMO && resultCode == RESULT_OK) {
            AppUtil.toast("메모 생성완료!")
            memoViewModel.getAll()
        }
    }



}


