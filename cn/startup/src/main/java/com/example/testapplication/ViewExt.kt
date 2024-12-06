package com.example.testapplication

import android.view.View

fun View.clickThrottle(onClick: (v: View) -> Unit) {
    var curTimeM = System.currentTimeMillis();
    this.setOnClickListener {
        if (System.currentTimeMillis() - curTimeM > 1000) {
            curTimeM = System.currentTimeMillis()
            onClick.invoke(this)
        }
    }
}