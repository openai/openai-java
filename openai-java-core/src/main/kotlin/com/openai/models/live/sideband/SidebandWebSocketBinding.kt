// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sideband

import com.openai.core.SecurityOptions
import com.openai.core.http.WebSocketBinding

/** Endpoint metadata consumed by SDK-owned WebSocket helpers. */
internal object SidebandWebSocketBinding {
    fun create(
        `sessionId`: String
    ): WebSocketBinding<
        com.openai.models.live.sideband.SidebandClientEvent,
        com.openai.models.live.sideband.SidebandServerEvent,
    > =
        WebSocketBinding(
            listOf("live", "sessions", `sessionId`.toString(), "attach"),
            SecurityOptions.builder().bearerAuth(true).build(),
            com.openai.models.live.sideband.SidebandServerEvent::class.java,
            { it.validate() },
        )
}
