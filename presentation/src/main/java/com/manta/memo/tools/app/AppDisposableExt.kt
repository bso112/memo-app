package com.manta.memo.tools.app

import com.manta.memo.util.AppDisposableOwner
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Park. w. h on 2019-09-10.
 */
inline fun <T> Observable<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit
) {
    subscribe {
        onNext(it)
    }.let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Observable<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit,
    crossinline onError: (Throwable) -> Unit
) {
    subscribe({
        onNext(it)
    }, {
        onError(it)
    }).let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Observable<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit,
    crossinline onError: (Throwable) -> Unit,
    crossinline onComplete: () -> Unit
) {
    subscribe({
        onNext(it)
    }, {
        onError(it)
    }, {
        onComplete()
    }).let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Flowable<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit
) {
    subscribe {
        onNext(it)
    }.let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Flowable<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit,
    crossinline onError: (Throwable) -> Unit
) {
    subscribe({
        onNext(it)
    }, {
        onError(it)
    }).let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Flowable<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit,
    crossinline onError: (Throwable) -> Unit,
    crossinline onComplete: () -> Unit
) {
    subscribe({
        onNext(it)
    }, {
        onError(it)
    }, {
        onComplete()
    }).let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Maybe<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit
) {
    subscribe {
        onNext(it)
    }.let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Maybe<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit,
    crossinline onError: (Throwable) -> Unit
) {
    subscribe({
        onNext(it)
    }, {
        onError(it)
    }).let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Maybe<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit,
    crossinline onError: (Throwable) -> Unit,
    crossinline onComplete: () -> Unit
) {
    subscribe({
        onNext(it)
    }, {
        onError(it)
    }, {
        onComplete()
    }).let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Single<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit
) {
    subscribe { it ->
        onNext(it)
    }.let {
        owner.disposable.addDisposable(it)
    }
}

inline fun <T> Single<T>.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: (T) -> Unit,
    crossinline onError: (Throwable) -> Unit
) {
    subscribe({
        onNext(it)
    }, {
        onError(it)
    }).let {
        owner.disposable.addDisposable(it)
    }
}


inline fun Completable.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: () -> Unit
) {
    subscribe {
        onNext()
    }.let {
        owner.disposable.addDisposable(it)
    }
}


inline fun Completable.subscribeWithDisposable(
    owner: AppDisposableOwner,
    crossinline onNext: () -> Unit,
    crossinline onError: (Throwable) -> Unit
) {
    subscribe(
        { onNext() },
        { it -> onError(it) }
    ).let {
        owner.disposable.addDisposable(it)
    }
}


