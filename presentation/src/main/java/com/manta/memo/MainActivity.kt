package com.manta.memo

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.manta.memo.data.Memo
import com.manta.memo.databinding.ActivityMainBinding
import com.manta.domain.entity.MemoEntity
import com.manta.memo.presentation.memo.MemoAdapter
import com.manta.memo.presentation.memo.MemoViewModel
import dagger.android.DaggerActivity

import javax.inject.Inject


class MainActivity : DaggerActivity() {

    @Inject
    lateinit var factory : ViewModelProvider.Factory
    //내부적으로 팩토리를 이용해 viewModel을 생성.
    private val memoViewModel : MemoViewModel by lazy{
        factory.create(MemoViewModel::class.java)
    }

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.adapter = MemoAdapter()
        binding.items = emptyList<Memo>()
        setContentView(binding.root)


        memoViewModel.createMemo(MemoEntity(0, "aaa"))



    }
}


