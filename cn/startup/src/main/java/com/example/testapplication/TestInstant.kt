package com.example.testapplication

import android.content.Context
import kotlinx.coroutines.sync.Mutex

/**
 * com.example.testapplication
 * created: cuizj4
 * at : 2024/6/18-9:52
 * desc:
 * version : 1.0.0
 */
class TestInstant private constructor(){

    companion object{
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder= TestInstant()
    }
}
class TestInstantWithParam private constructor(str:String){
    companion object {
        private const val TAG = "LgAppInitializer"

        @Volatile
        private var sInstance: TestInstantWithParam? = null

        private val sLock = Any()

        fun getInstance(str: String): TestInstantWithParam {
            if (sInstance == null) {
                synchronized(sLock) {
                    if (sInstance == null) {
                        sInstance = TestInstantWithParam(str)
                    }
                }
            }
            return sInstance!!
        }
    }
}