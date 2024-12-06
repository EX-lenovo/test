package com.example.testapplication

import kotlinx.coroutines.delay

/**
 * com.example.testapplication
 * created: cuizj4
 * at : 2024/7/12-11:23
 * desc:
 * version : 1.0.0
 */

suspend fun <T> retryCoroutine(
    maxAttempts: Int = 3,
    initialDelay: Long = 1000,// 初始延迟（毫秒）
    maxDelay: Long = 3000,// 最大延迟（毫秒）
    factor: Double = 2.0,// 每次重试增加延迟的因素
    block: suspend () -> T// 发出网络请求的挂起功能
): T {
    var currentDelay = initialDelay
    repeat(maxAttempts - 1) { attempt ->
        try {
            return block()// 尝试执行
        } catch (e: Exception) {
            println("Attempt ${attempt + 1} failed: ${e.message}")
            delay(currentDelay)
            currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
        }
    }
    return block()// 最后一次尝试，如果失败则抛出异常
}