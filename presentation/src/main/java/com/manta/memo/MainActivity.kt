package com.manta.memo

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.manta.data.data.Memo
import com.manta.domain.entity.MemoEntity
import com.manta.memo.databinding.ActivityMainBinding
import com.manta.memo.presentation.memo.MemoAdapter
import com.manta.memo.presentation.memo.MemoViewModel
import dagger.android.DaggerActivity

import javax.inject.Inject


class MainActivity : DaggerActivity() {

    @Inject
    lateinit var factory : ViewModelProvider.Factory
    //내부적으로 팩토리를 이용해 viewModel을 생성.
    private lateinit var memoViewModel : MemoViewModel

    lateinit var binding : ActivityMainBinding

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.adapter = MemoAdapter()
        binding.items = emptyList<Memo>()
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        memoViewModel = factory.create(MemoViewModel::class.java)
        memoViewModel.createMemo(MemoEntity(1,"33"))
    }
}


