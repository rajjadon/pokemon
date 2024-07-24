package com.raj.common.qualifiers

import javax.inject.Qualifier

@Qualifier
annotation class ApiQualifier(val apiConstantEnum: ApiConstantEnum)