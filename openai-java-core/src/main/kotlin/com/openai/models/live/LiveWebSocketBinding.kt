// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.openai.core.SecurityOptions
import com.openai.core.http.WebSocketBinding

/** Endpoint metadata consumed by SDK-owned WebSocket helpers. */
internal object LiveWebSocketBinding {
    fun create():
        WebSocketBinding<com.openai.models.live.ClientEvent, com.openai.models.live.ServerEvent> =
        WebSocketBinding(
            listOf("live", "sessions"),
            SecurityOptions.builder().bearerAuth(true).build(),
            com.openai.models.live.ServerEvent::class.java,
            { it.validate() },
        )
}
