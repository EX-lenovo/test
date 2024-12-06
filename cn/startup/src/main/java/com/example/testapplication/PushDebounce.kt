package com.example.testapplication

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object PushDebounce {
    private var latestParam: Any? = null
    private var throttleJob: Job? = null
    private var timeMillis: Long = -1

    @OptIn(DelicateCoroutinesApi::class)
    fun throttleLatest(intervalMs: Long = 300L,
                       param :Any?,
                       destinationFunction: (Any?) -> Unit){

        if(System.currentTimeMillis() - timeMillis > 2000){
            //保证一次被执行
            param.let(destinationFunction)
        }
        latestParam = param
        timeMillis = System.currentTimeMillis()
        if (throttleJob?.isCompleted != false) {
            throttleJob = GlobalScope.launch(Dispatchers.IO) {
                delay(intervalMs)
                //间隔结束后，最新数据被执行
                GlobalScope.launch(Dispatchers.Main){
                    latestParam.let(destinationFunction)
                }
            }
        }

    }
}