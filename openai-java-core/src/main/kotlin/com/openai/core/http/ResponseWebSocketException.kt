package com.openai.core.http

import com.openai.errors.OpenAIException
import com.openai.models.responses.ResponsesServerEvent

/** A protocol error returned by a response helper. The original event retains its details. */
class ResponseWebSocketException(@get:JvmName("event") val event: ResponsesServerEvent) :
    OpenAIException("Responses WebSocket protocol error")
