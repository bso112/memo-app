package com.manta.memo.tools.dagger2.module

import androidx.lifecycle.ViewModel
import com.manta.memo.presentation.creatememo.CreateMemoViewModel
import com.manta.memo.presentation.memo.MemoViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

//dagger로 하여금 이 어노테이션이 붙은 함수의 리턴값을 Map의 value로 넣도록한다.
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ViewModelKey(val value: KClass<out ViewModel>)


/**
 * 뷰모델의 인스턴스를 공급하는 모듈
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MemoViewModel::class)
   abstract fun provideMemoViewModel(viewModel: MemoViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(CreateMemoViewModel::class)
    abstract fun provideCreateMemoViewModel(viewModel: CreateMemoViewModel) : ViewModel

}