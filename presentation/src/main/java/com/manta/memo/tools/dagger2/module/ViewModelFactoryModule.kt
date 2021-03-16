package com.manta.memo.tools.dagger2.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import javax.inject.Inject
import javax.inject.Provider

/*

생생자에 인자가 있는 viewModel은 Dagger를 쓰지 않으면
fun provideViewModel(owner: ViewModelStoreOwner, application: Application) =
    ViewModelProvider(owner, object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PictureViewModel(application) as T;
        }}).get(PictureViewModel::class.java);


이런식으로 생성하게 된다.
하지만 Dagger를 쓴다면 인자는 주입을 받으므로 뷰모델마다 뷰모델을 제공받는 함수를 만들지 않고 간단하게 생성할 수 있다.

1. ViewModel은 단순히 생성자로 생성하면 안되기 때문에 viewModel을 직접적으로 주입하지 않는다. 대신에, ViewModelFactory를 주입해서 만들어쓴다.
2. ViewModelFactory는 단순히 생성자로 생성할 수 없기 때문에 Module 으로 주입한다.

참고 : https://trend21c.tistory.com/2111
*/

/**
 * 뷰모델 인스턴스를 가진, 뷰모델 팩토리를 공급하는 모듈
 */
@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}

class ViewModelFactory @Inject constructor(
    //이건 viewModelModule에서 @IntoMap과  @ViewModelKey로 제공받는다.
    val viewModelMap: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    /*
    viewModelMap[modelClass]?.get()은 그냥 viewModelMap에 들어있는 뷰모델 인스턴스를 가져오는 것.
    Dagger를 안쓴다면
    fun provideViewModel(owner: ViewModelStoreOwner, application: Application) =
    ViewModelProvider(owner, object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PictureViewModel(application) as T;    <==== 이부분이랑 같은 역할임
        }}).get(PictureViewModel::class.java);
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModelMap[modelClass]?.get() as T
    }

}