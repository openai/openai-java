// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime.translations

import com.openai.core.SecurityOptions
import com.openai.core.http.WebSocketBinding

/** Endpoint metadata consumed by SDK-owned WebSocket helpers. */
internal object TranslationWebSocketBinding {
    fun create():
        WebSocketBinding<
            com.openai.models.realtime.RealtimeTranslationClientEvent,
            com.openai.models.realtime.RealtimeTranslationServerEvent,
        > =
        WebSocketBinding(
            listOf("realtime", "translations"),
            SecurityOptions.builder().bearerAuth(true).build(),
            com.openai.models.realtime.RealtimeTranslationServerEvent::class.java,
            { it.validate() },
        )
}
