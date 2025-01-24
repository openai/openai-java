@file:JvmName("Check")

package com.openai.core

fun <T : Any> checkRequired(name: String, value: T?): T =
    checkNotNull(value) { "`$name` is required, but was not set" }

@JvmSynthetic
internal fun checkLength(name: String, value: String, length: Int): String =
    value.also {
        check(it.length == length) { "`$name` must have length $length, but was ${it.length}" }
    }

@JvmSynthetic
internal fun checkMinLength(name: String, value: String, minLength: Int): String =
    value.also {
        check(it.length >= minLength) {
            if (minLength == 1) "`$name` must be non-empty, but was empty"
            else "`$name` must have at least length $minLength, but was ${it.length}"
        }
    }

@JvmSynthetic
internal fun checkMaxLength(name: String, value: String, maxLength: Int): String =
    value.also {
        check(it.length <= maxLength) {
            "`$name` must have at most length $maxLength, but was ${it.length}"
        }
    }
