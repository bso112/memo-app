package com.manta.memo

import io.reactivex.rxjava3.core.Observable
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun rxJavaTest(){
        val data = Observable.just(1,2,3)

        data.map {
            it.toString()
        }.subscribe { print(it)}

        println("=========")

        data.flatMap {v ->
            Observable.create<Int> { emitter->
                for (i in 0..v){
                    emitter.onNext(i)
                }
                emitter.onComplete()
            }
        }.subscribe { print(it)}


    }

    class A(private val a : Int)
    data class B(private val b : Int)
    @Test
    fun eqaulTest(){
        assertEquals(false, A(3) == A(3) )
        assertEquals(false, B(2) == B(3) )
        assertEquals(true, B(3) == B(3) )


    }
}