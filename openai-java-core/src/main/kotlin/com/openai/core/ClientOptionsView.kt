package com.openai.core

/**
 * Adds an SDK presentation header without creating a second owner for an authenticated pipeline.
 */
@JvmSynthetic
internal fun ClientOptions.withDefaultUserAgent(userAgent: String): ClientOptions {
    if (headers.values("User-Agent").isNotEmpty()) return this
    val builder = toBuilder().putHeader("User-Agent", userAgent)
    if (propagatesAsyncCancellation()) builder.shareHttpPipeline(httpClient)
    return builder.build()
}
