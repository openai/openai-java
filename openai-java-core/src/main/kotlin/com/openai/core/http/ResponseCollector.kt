package com.openai.core.http

import com.openai.core.JsonNull
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseOutputItem
import com.openai.models.responses.ResponsesServerEvent

/** Accessed only under the owning connection's lock, at event consumption rather than arrival. */
internal class ResponseCollector(private val maxBytes: Long) {
    class Result(val response: Response? = null, val error: Throwable? = null)

    private var bytes = 0L
    private val items = sortedMapOf<Long, ResponseOutputItem>()
    private var terminal: Response? = null
    private var error: Throwable? = null

    fun add(event: ResponsesServerEvent, wireBytes: Long) {
        val type =
            when {
                event.isResponseCreated() -> "response.created"
                event.isResponseOutputItemDone() -> "response.output_item.done"
                event.isResponseCompleted() -> "response.completed"
                event.isResponseFailed() -> "response.failed"
                event.isResponseIncomplete() -> "response.incomplete"
                event.isError() -> "error"
                else ->
                    event
                        ._json()
                        .orElse(null)
                        ?.asObject()
                        ?.orElse(null)
                        ?.get("type")
                        ?.asString()
                        ?.orElse(null)
            }
        if (type == "response.created") clear()
        if (type == "error") {
            fail(ResponseWebSocketException(event))
            return
        }
        if (error != null) return
        if (
            type != "response.created" &&
                type != "response.output_item.done" &&
                type != "response.completed" &&
                type != "response.failed" &&
                type != "response.incomplete"
        )
            return
        if (wireBytes > maxBytes - bytes) {
            fail(ResponseCollectionLimitException(maxBytes))
            return
        }
        bytes += wireBytes
        try {
            when (type) {
                "response.output_item.done" -> {
                    val done = event.asResponseOutputItemDone()
                    items[done.outputIndex()] = done.item()
                }
                "response.completed",
                "response.failed",
                "response.incomplete" -> {
                    val value =
                        when (type) {
                            "response.completed" -> event.asResponseCompleted().response()
                            "response.failed" -> event.asResponseFailed().response()
                            else -> event.asResponseIncomplete().response()
                        }
                    val output = value._output()
                    terminal =
                        if (output.isMissing() || output is JsonNull)
                            value.toBuilder().output(items.values.toList()).build()
                        else value
                    items.clear()
                    bytes = 0
                }
            }
        } catch (failure: Exception) {
            fail(failure)
        }
    }

    /**
     * A cached terminal is consumed once. A collection error persists until a new created event.
     */
    fun takeResult(): Result? {
        error?.let {
            return Result(error = it)
        }
        val value = terminal ?: return null
        clear()
        return Result(response = value)
    }

    private fun fail(failure: Throwable) {
        clear()
        error = failure
    }

    private fun clear() {
        bytes = 0
        items.clear()
        terminal = null
        error = null
    }
}
