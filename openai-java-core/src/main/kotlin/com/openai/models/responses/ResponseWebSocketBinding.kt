// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.openai.core.SecurityOptions
import com.openai.core.http.WebSocketBinding

/** Endpoint metadata consumed by SDK-owned WebSocket helpers. */
internal object ResponseWebSocketBinding {
    fun create():
        WebSocketBinding<
            com.openai.models.responses.ResponsesClientEvent,
            com.openai.models.responses.ResponsesServerEvent,
        > =
        WebSocketBinding(
            listOf("responses"),
            SecurityOptions.builder().bearerAuth(true).build(),
            com.openai.models.responses.ResponsesServerEvent::class.java,
            { it.validate() },
        )
}
