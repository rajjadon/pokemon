package com.raj.common.extension

import android.content.Context
import android.widget.Toast

fun Context.showStringToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}