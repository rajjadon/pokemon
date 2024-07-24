package com.raj.common.extension

import com.google.gson.Gson


fun Any.objectToJson(): String = Gson().toJson(this)