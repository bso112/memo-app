package com.manta.memo.presentation.memo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manta.memo.R
import com.manta.memo.data.Memo
import com.manta.memo.presentation.creatememo.CreateMemoActivity
import com.manta.memo.databinding.ActivityMainBinding
import com.manta.memo.presentation.dialog.AppDialog
import com.manta.memo.presentation.dialog.AppDialogDelegate
import com.manta.memo.tools.app.AppActivity
import com.manta.memo.tools.app.set
import com.manta.memo.util.AppUtil
import com.manta.memo.util.itemdecoration.SpacingItemDecoration
import javax.inject.Inject


class MainActivity : AppActivity() {

    private val REQUEST_CREATE_MEMO = 0

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    //내부적으로 팩토리를 이용해 viewModel을 생성.
    private val memoViewModel: MemoViewModel by viewModels { factory }

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.recycler.adapter = MemoAdapter(memoViewModel)


        binding.recycler.addItemDecoration(SpacingItemDecoration(this, 10F))
        binding.viewModel = memoViewModel
        setContentView(binding.root)

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
            AppDialog.Builder<Memo>(this, it)
                .set { title = it.title }
                .set { content = it.content }
                .set { image = R.drawable.ic_baseline_delete_24}
                .set { delegate = memoViewModel}
                .set { windowWidth = AppDialog.MIN_WIDTH}
                .build()
                .show()
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


