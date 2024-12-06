package com.example.testapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.room.Room
import androidx.room.rxjava3.RxRoom
import com.example.testapplication.room.RoomDataBase
import com.example.testapplication.room.RoomEntity
import com.example.testapplication.room.RoomTestEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class TestActivity : AppCompatActivity() {
    companion object {
        const val TAG = "TestActivity"
    }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BuildConfig.DEBUG

//        TestInstant.instance.context=thi
//        val entity = RoomTestEntity()
//        main()
//        flowOf(1).apply {
//
//        }
//            .asLiveData(lifecycleScope.coroutineContext).show(this) {
//            loading {
//                Log.d(Constant.TAG, "#loading")
//            }
//        }
//        lifecycleScope.launch(Dispatchers.IO) {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//
//                retryCoroutine(){
//                    throw Exception("this is a test for retry")
//                }
//
//                Log.d("test", "currentThread:${Thread.currentThread().name}")
//                withContext(Dispatchers.IO) {
//                    flow {
//                        System.out.println(emit(1))
//                        emit(1)
//                    }
//                }
//                val result1 = async(Dispatchers.IO) {
//                    Log.d("test", "currentThread1:${Thread.currentThread().name}")
//                    delay(3000) // 模拟长时间运行的任务
//                    return@async 1
//                }
//                val result2 = async(Dispatchers.Main) {
//                    Log.d("test", "currentThread2:${Thread.currentThread().name}")
//                    delay(1000) // 模拟长时间运行的任务
//                    return@async 2
//                }
//                Log.d(
//                    "test",
//                    "result is ${result1.await()},${result2.await()},currentThread:${Thread.currentThread().name}"
//                )
//            }
//        }
        val db = Room.databaseBuilder(this, RoomDataBase::class.java, "entityDb")
            // 默认不允许在主线程中连接数据库   强制在主线程中处理
            .allowMainThreadQueries().build();


        RxRoom.createFlowable(db, "entityTable").flatMap {
            val list = db.roomDao().getDataList(1).orEmpty()
            Log.d(TAG, "get data change ${list.size}")
            Flowable.fromIterable(list)
        }.map {
            it.status = 0
            Log.d(TAG, "map updateRes: ${db.roomDao().updateData(it)},${it.name}")
            it
        }.onBackpressureBuffer().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                Log.d(TAG, "onNext ${it.name}")
            }, {
                Log.d(TAG, "onError ${it.message}")
            }, {
                Log.d(TAG, "onComplete ")
            })
    }

    suspend fun doSomethingLong(name: String, ms: Long): Int {
        delay(ms) // 模拟长时间运行的任务
        println("$name done")
        return 1
    }

    fun main() = runBlocking {
        val job = lifecycleScope.launch(Dispatchers.Default) {
            var i = 0
            while (true) {         // 调用 cancel() 后，协程内部的循环任务并不会被取消
                delay(500L) // 注意：如果使用的是 delay，则可以正常停止协程任务
                i++
                println("i = $i")
            }
        }
        job.invokeOnCompletion { println("over") } // 此方法不会回调，表明协程任务没有结束

        delay(2000L)
        job.cancel()          // 取消协程
        println(job.isActive) // false，此时协程已经不是活跃状态了
        job.join()            // Suspends the coroutine until this job is complete
        println("End")        // 由于 join() 会被挂起，且无法恢复，所以程序也永远停不下来
    }

    fun addAndShowFragment(@IdRes containerViewId: Int, f: Fragment?, hide: Fragment? = null) {
//        this.fragmentManager?.beginTransaction().apply {
//            f?.let {
//                if (it.isAdded) {
//                    show(it)
//                    setMaxLifecycle(it, Lifecycle.State.RESUMED)
//                } else {
//                    add(containerViewId, it)
//                }
//            }
//            hide?.let {
//                if (it.isAdded) {
//                    hide(it)
//                    setMaxLifecycle(it, Lifecycle.State.STARTED)
//                }
//            }
//            commitAllowingStateLoss()
//        }

    }

    fun scopeTest() = runBlocking {
        println(1) // 1 - EmptyCoroutineContext - null
        CoroutineScope(Dispatchers.IO + Job() + CoroutineName("bqt")).launch {
            println(2) // 2 - EmptyCoroutineContext - null
        }
        delay(100L)
    }

}