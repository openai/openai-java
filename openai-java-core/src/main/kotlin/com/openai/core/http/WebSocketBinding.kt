package com.openai.core.http

import com.openai.core.SecurityOptions

/** Connects generated endpoint and event metadata to the SDK-owned connection implementation. */
internal class WebSocketBinding<C : Any, S : Any>(
    val pathSegments: List<String>,
    val security: SecurityOptions,
    val eventType: Class<S>,
    val validate: (S) -> Unit,
) {}
