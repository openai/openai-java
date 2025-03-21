// File generated from our OpenAPI spec by Stainless.

@file:JvmName("SseHandler")

package com.openai.core.handlers

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.SseMessage
import com.openai.core.http.StreamResponse
import com.openai.core.http.map
import com.openai.errors.SseException
import com.openai.models.ErrorObject

@JvmSynthetic
internal fun sseHandler(jsonMapper: JsonMapper): Handler<StreamResponse<SseMessage>> =
    streamHandler { response, lines ->
        val state = SseState(jsonMapper)
        var done = false
        for (line in lines) {
            // Stop emitting messages, but iterate through the full stream.
            if (done) {
                continue
            }
            val message = state.decode(line) ?: continue

            if (message.data.startsWith("[DONE]")) {
                // In this case we don't break because we still want to iterate through the full
                // stream.
                done = true
                continue
            }

            val jsonNode =
                try {
                    message.json<JsonNode>()
                } catch (e: Exception) {
                    jsonMapper.createObjectNode()
                }
            jsonNode.get("error")?.let {
                throw SseException.builder()
                    .statusCode(response.statusCode())
                    .headers(response.headers())
                    .error(
                        try {
                            jsonMapper
                                .readerFor(jacksonTypeRef<ErrorObject?>())
                                .readValue<ErrorObject?>(it)
                        } catch (e: Exception) {
                            null
                        }
                    )
                    .build()
            }
            yield(message)
        }
    }

private class SseState(
    val jsonMapper: JsonMapper,
    var event: String? = null,
    val data: MutableList<String> = mutableListOf(),
    var lastId: String? = null,
    var retry: Int? = null,
) {
    // https://html.spec.whatwg.org/multipage/server-sent-events.html#event-stream-interpretation
    fun decode(line: String): SseMessage? {
        if (line.isEmpty()) {
            return flush()
        }

        if (line.startsWith(':')) {
            return null
        }

        val fieldName: String
        var value: String

        val colonIndex = line.indexOf(':')
        if (colonIndex == -1) {
            fieldName = line
            value = ""
        } else {
            fieldName = line.substring(0, colonIndex)
            value = line.substring(colonIndex + 1)
        }

        if (value.startsWith(' ')) {
            value = value.substring(1)
        }

        when (fieldName) {
            "event" -> event = value
            "data" -> data.add(value)
            "id" -> {
                if (!value.contains('\u0000')) {
                    lastId = value
                }
            }
            "retry" -> value.toIntOrNull()?.let { retry = it }
        }

        return null
    }

    private fun flush(): SseMessage? {
        if (isEmpty()) {
            return null
        }

        val message =
            SseMessage.builder()
                .jsonMapper(jsonMapper)
                .event(event)
                .data(data.joinToString("\n"))
                .id(lastId)
                .retry(retry)
                .build()

        // NOTE: Per the SSE spec, do not reset lastId.
        event = null
        data.clear()
        retry = null

        return message
    }

    private fun isEmpty(): Boolean =
        event.isNullOrEmpty() && data.isEmpty() && lastId.isNullOrEmpty() && retry == null
}

@JvmSynthetic
internal inline fun <reified T> Handler<StreamResponse<SseMessage>>.mapJson(
    includeEventAndData: Boolean = false
): Handler<StreamResponse<T>> =
    object : Handler<StreamResponse<T>> {
        override fun handle(response: HttpResponse): StreamResponse<T> =
            this@mapJson.handle(response).map { it.json<T>(includeEventAndData) }
    }
