package com.example.testapplication

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

/**
 * com.example.testapplication
 * created: cuizj4
 * at : 2024/6/26-16:12
 * desc:
 * version : 1.0.0
 */
class TestFragment:Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    fun addAndShowFragment(@IdRes containerViewId: Int, f: Fragment?, hide: Fragment? = null) {
        childFragmentManager.beginTransaction().apply {
            f?.let {
                if (it.isAdded) {
                    show(it)
                    setMaxLifecycle(it, Lifecycle.State.RESUMED)
                } else {
                    add(containerViewId, it)
                }
            }
            hide?.let {
                if (it.isAdded) {
                    hide(it)
                    setMaxLifecycle(it, Lifecycle.State.STARTED)
                }
            }
            commitAllowingStateLoss()
        }
    }
}