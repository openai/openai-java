// File generated from our OpenAPI spec by Stainless.

@file:JvmName("HttpRequestBodies")

package com.openai.core.http

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.node.JsonNodeType
import com.openai.core.MultipartField
import com.openai.errors.OpenAIInvalidDataException
import java.io.OutputStream
import kotlin.jvm.optionals.getOrNull
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder
import org.apache.hc.core5.http.ContentType
import org.apache.hc.core5.http.HttpEntity

@JvmSynthetic
internal inline fun <reified T> json(jsonMapper: JsonMapper, value: T): HttpRequestBody =
    object : HttpRequestBody {
        private val bytes: ByteArray by lazy { jsonMapper.writeValueAsBytes(value) }

        override fun writeTo(outputStream: OutputStream) = outputStream.write(bytes)

        override fun contentType(): String = "application/json"

        override fun contentLength(): Long = bytes.size.toLong()

        override fun repeatable(): Boolean = true

        override fun close() {}
    }

@JvmSynthetic
internal fun multipartFormData(
    jsonMapper: JsonMapper,
    fields: Map<String, MultipartField<*>>,
): HttpRequestBody =
    object : HttpRequestBody {
        private val entity: HttpEntity by lazy {
            MultipartEntityBuilder.create()
                .apply {
                    fields.forEach { (name, field) ->
                        val node = jsonMapper.valueToTree<JsonNode>(field.value)
                        serializePart(name, node).forEach { (name, bytes) ->
                            addBinaryBody(
                                name,
                                bytes,
                                ContentType.parseLenient(field.contentType),
                                field.filename().getOrNull(),
                            )
                        }
                    }
                }
                .build()
        }

        private fun serializePart(name: String, node: JsonNode): Sequence<Pair<String, ByteArray>> =
            when (node.nodeType) {
                JsonNodeType.MISSING,
                JsonNodeType.NULL -> emptySequence()
                JsonNodeType.BINARY -> sequenceOf(name to node.binaryValue())
                JsonNodeType.STRING -> sequenceOf(name to node.textValue().toByteArray())
                JsonNodeType.BOOLEAN ->
                    sequenceOf(name to node.booleanValue().toString().toByteArray())
                JsonNodeType.NUMBER ->
                    sequenceOf(name to node.numberValue().toString().toByteArray())
                JsonNodeType.ARRAY ->
                    node.elements().asSequence().flatMap { element ->
                        serializePart("$name[]", element)
                    }
                JsonNodeType.OBJECT ->
                    node.fields().asSequence().flatMap { (key, value) ->
                        serializePart("$name[$key]", value)
                    }
                JsonNodeType.POJO,
                null ->
                    throw OpenAIInvalidDataException("Unexpected JsonNode type: ${node.nodeType}")
            }

        override fun writeTo(outputStream: OutputStream) = entity.writeTo(outputStream)

        override fun contentType(): String = entity.contentType

        override fun contentLength(): Long = entity.contentLength

        override fun repeatable(): Boolean = entity.isRepeatable

        override fun close() = entity.close()
    }
