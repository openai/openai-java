@file:JvmName("Check")

package com.openai.core

@JvmSynthetic
internal fun <T : Any> checkRequired(name: String, value: T?): T =
    checkNotNull(value) { "`$name` is required but was not set" }
