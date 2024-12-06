package com.example.testapplication

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * com.example.testapplication
 * created: cuizj4
 * at : 2024/6/26-15:39
 * desc:
 * version : 1.0.0
 */
object Constant{
    const val TAG="NetExt"
}

class LiveDataPage<T> {
    var loading: ((T) -> Unit)? = null
    fun loading(call: ((T) -> Unit)?) {
        loading = call
    }
}

@MainThread
fun <T> LiveData<T>.show(
    owner: LifecycleOwner,
    lambda: LiveDataPage<T>.() -> Unit,
) {
    this.observe(owner) {
        Log.d(Constant.TAG,"#show.Observer ")
        LiveDataPage<T>().apply(lambda).apply {
            loading?.invoke(it)
        }

    }
}