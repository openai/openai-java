// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.openai.core.SecurityOptions
import com.openai.core.http.WebSocketBinding

/** Endpoint metadata consumed by SDK-owned WebSocket helpers. */
internal object RealtimeWebSocketBinding {
    fun create():
        WebSocketBinding<
            com.openai.models.realtime.RealtimeClientEvent,
            com.openai.models.realtime.RealtimeServerEvent,
        > =
        WebSocketBinding(
            listOf("realtime"),
            SecurityOptions.builder().bearerAuth(true).build(),
            com.openai.models.realtime.RealtimeServerEvent::class.java,
            { it.validate() },
        )
}
