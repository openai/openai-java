package com.openai.core.http

import com.openai.errors.OpenAIException

/** An unsuccessful HTTP upgrade. Response headers and body are deliberately not retained. */
class WebSocketHandshakeException(@get:JvmName("statusCode") val statusCode: Int) :
    OpenAIException("WebSocket handshake failed (HTTP $statusCode)")
