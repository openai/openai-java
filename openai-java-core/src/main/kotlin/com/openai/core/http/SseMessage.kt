// File generated from our OpenAPI spec by Stainless.

package com.openai.core.http

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.errors.OpenAIException
import java.util.Objects

internal class SseMessage
private constructor(
    val jsonMapper: JsonMapper,
    val event: String?,
    val data: String,
    val id: String?,
    val retry: Int?,
) {

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var jsonMapper: JsonMapper? = null
        private var event: String? = null
        private var data: String = ""
        private var id: String? = null
        private var retry: Int? = null

        fun jsonMapper(jsonMapper: JsonMapper) = apply { this.jsonMapper = jsonMapper }

        fun event(event: String?) = apply { this.event = event }

        fun data(data: String) = apply { this.data = data }

        fun id(id: String?) = apply { this.id = id }

        fun retry(retry: Int?) = apply { this.retry = retry }

        fun build(): SseMessage = SseMessage(jsonMapper!!, event, data, id, retry)
    }

    inline fun <reified T> json(includeEventAndData: Boolean = false): T {
        var jsonNode = jsonNode
        if (includeEventAndData) {
            val newJsonNode = jsonMapper.createObjectNode()
            event?.let { newJsonNode.put("event", event) }
            newJsonNode.replace("data", jsonNode)
            jsonNode = newJsonNode
        }

        return jsonMapper.readerFor(jacksonTypeRef<T>()).readValue(jsonNode)
    }

    private val jsonNode by lazy {
        try {
            jsonMapper.readTree(data)
        } catch (e: Exception) {
            throw OpenAIException("Error deserializing json", e)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SseMessage &&
            event == other.event &&
            data == other.data &&
            id == other.id &&
            retry == other.retry
    }

    override fun hashCode(): Int = Objects.hash(event, data, id, retry)

    override fun toString(): String = "SseMessage{event=$event, data=$data, id=$id, retry=$retry}"
}
