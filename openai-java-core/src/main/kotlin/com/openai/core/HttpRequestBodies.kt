@file:JvmName("HttpRequestBodies")

package com.openai.core

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.HttpRequestBody
import com.openai.errors.OpenAIException
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder

@JvmSynthetic
internal inline fun <reified T> json(jsonMapper: JsonMapper, value: T): HttpRequestBody {
    return object : HttpRequestBody {
        private var cachedBytes: ByteArray? = null

        private fun serialize(): ByteArray {
            if (cachedBytes != null) return cachedBytes!!

            val buffer = ByteArrayOutputStream()
            try {
                jsonMapper.writeValue(buffer, value)
                cachedBytes = buffer.toByteArray()
                return cachedBytes!!
            } catch (e: Exception) {
                throw OpenAIException("Error writing request", e)
            }
        }

        override fun writeTo(outputStream: OutputStream) {
            outputStream.write(serialize())
        }

        override fun contentType(): String = "application/json"

        override fun contentLength(): Long {
            return serialize().size.toLong()
        }

        override fun repeatable(): Boolean = true

        override fun close() {}
    }
}

@JvmSynthetic
internal fun multipartFormData(
    jsonMapper: JsonMapper,
    parts: Array<MultipartFormValue<*>?>,
): HttpRequestBody {
    val builder = MultipartEntityBuilder.create()
    parts.forEach { part ->
        if (part?.value != null) {
            when (part.value) {
                is JsonValue -> {
                    val buffer = ByteArrayOutputStream()
                    try {
                        jsonMapper.writeValue(buffer, part.value)
                    } catch (e: Exception) {
                        throw OpenAIException("Error serializing value to json", e)
                    }
                    builder.addBinaryBody(
                        part.name,
                        buffer.toByteArray(),
                        part.contentType,
                        part.filename,
                    )
                }
                is Boolean ->
                    builder.addTextBody(
                        part.name,
                        if (part.value) "true" else "false",
                        part.contentType,
                    )
                is Int -> builder.addTextBody(part.name, part.value.toString(), part.contentType)
                is Long -> builder.addTextBody(part.name, part.value.toString(), part.contentType)
                is Double -> builder.addTextBody(part.name, part.value.toString(), part.contentType)
                is ByteArray ->
                    builder.addBinaryBody(part.name, part.value, part.contentType, part.filename)
                is String -> builder.addTextBody(part.name, part.value, part.contentType)
                is Enum -> builder.addTextBody(part.name, part.value.toString(), part.contentType)
                else ->
                    throw IllegalArgumentException(
                        "Unsupported content type: ${part.value::class.java.simpleName}"
                    )
            }
        }
    }
    val entity = builder.build()

    return object : HttpRequestBody {
        override fun writeTo(outputStream: OutputStream) {
            try {
                return entity.writeTo(outputStream)
            } catch (e: Exception) {
                throw OpenAIException("Error writing request", e)
            }
        }

        override fun contentType(): String = entity.contentType

        override fun contentLength(): Long = -1

        override fun repeatable(): Boolean = entity.isRepeatable

        override fun close() = entity.close()
    }
}
