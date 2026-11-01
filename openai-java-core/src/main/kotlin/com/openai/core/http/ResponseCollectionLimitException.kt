package com.openai.core.http

import com.openai.errors.OpenAIException

/** The caller's managed response-collection budget was exceeded; raw reads remain usable. */
class ResponseCollectionLimitException(
    @get:JvmName("maxResponseBytes") val maxResponseBytes: Long
) : OpenAIException("Responses collection exceeded maxResponseBytes ($maxResponseBytes)")
