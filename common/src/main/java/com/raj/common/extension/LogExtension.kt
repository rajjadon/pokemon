package com.raj.common.extension

import timber.log.Timber

fun Any?.logError() {
    Timber.e(this.toString())
}