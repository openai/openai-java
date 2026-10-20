// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.forks

import com.openai.core.SecurityOptions
import com.openai.core.http.WebSocketBinding

/** Endpoint metadata consumed by SDK-owned WebSocket helpers. */
internal object ForkWebSocketBinding {
    fun create(
        `sessionId`: String
    ): WebSocketBinding<
        com.openai.models.live.forks.ForkClientEvent,
        com.openai.models.live.forks.ForkServerEvent,
    > =
        WebSocketBinding(
            listOf("live", "sessions", `sessionId`.toString(), "fork"),
            SecurityOptions.builder().bearerAuth(true).build(),
            com.openai.models.live.forks.ForkServerEvent::class.java,
            { it.validate() },
        )
}
