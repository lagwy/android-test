package com.example.workshop.ui.base

import androidx.annotation.StringRes

interface BaseView {

    fun logError(error: String)

    fun logError(@StringRes stringResId: Int)

    fun logMessage(@StringRes stringResId: Int)

    fun logMessage(message: String)
}