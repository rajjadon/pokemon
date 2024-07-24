package com.raj.common.extension

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive

fun CoroutineScope.cancelApiJob() {
    if (this.isActive)
        cancel()
}