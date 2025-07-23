// File generated from our OpenAPI spec by Stainless.

package com.openai.models.embeddings

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.errors.OpenAIInvalidDataException
import java.nio.ByteBuffer
import java.util.Base64
import java.util.Objects

/**
 * Represents embedding data that can be either a list of floats or base64-encoded string. This
 * union type allows for efficient handling of both formats.
 *
 * This class is immutable - all instances are thread-safe and cannot be modified after creation.
 */
@JsonDeserialize(using = EmbeddingValue.Deserializer::class)
@JsonSerialize(using = EmbeddingValue.Serializer::class)
class EmbeddingValue
private constructor(
    private val floats: List<Float>? = null,
    private val base64: String? = null,
    private val _json: JsonValue? = null,
) {

    /** Returns the embedding as a list of floats, or null if this value represents base64 data. */
    fun floats(): List<Float>? = floats

    /**
     * Returns the embedding as a base64-encoded string, or null if this value represents float
     * data.
     */
    fun base64(): String? = base64

    /** Returns true if this value contains float list data. */
    fun isFloats(): Boolean = floats != null

    /** Returns true if this value contains base64 string data. */
    fun isBase64(): Boolean = base64 != null

    /**
     * Returns the embedding data as a list of floats.
     *
     * **Important feature: Automatic Base64 decoding** This method is the core part of backward
     * compatibility. When data is stored in Base64 format, it automatically decodes and returns
     * List<Float>, so existing user code requires no changes.
     *
     * Processing flow:
     * - Float format data → Return as-is
     * - Base64 format data → Automatically decode and return as List<Float>
     *
     * @return Decoded embedding data in List<Float> format
     */
    fun asFloats(): List<Float> =
        when {
            floats != null -> floats
            base64 != null -> decodeBase64ToFloats(base64) // Automatic Base64 decoding
            else -> throw IllegalStateException("No valid embedding data")
        }

    /**
     * Returns the embedding data as a base64-encoded string. If the data is a float list, it will
     * be encoded automatically.
     */
    fun asBase64(): String =
        when {
            base64 != null -> base64
            floats != null -> encodeFloatsToBase64(floats)
            else -> throw IllegalStateException("No valid embedding data")
        }

    /** Returns the raw JSON value for debugging purposes. */
    fun _json(): JsonValue? = _json

    /** Accepts a visitor that can handle both float list and base64 string cases. */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            floats != null -> visitor.visitFloats(floats)
            base64 != null -> visitor.visitBase64(base64)
            else -> visitor.unknown(_json)
        }

    /**
     * Validates the embedding data and returns a new validated instance. This method is immutable -
     * it returns a new instance if validation is successful, or throws an exception if validation
     * fails.
     *
     * @return this instance if validation succeeds
     * @throws OpenAIInvalidDataException if validation fails
     */
    fun validate(): EmbeddingValue {
        accept(
            object : Visitor<Unit> {
                override fun visitFloats(floats: List<Float>) {}

                override fun visitBase64(base64: String) {}
            }
        )
        return this // Return this instance if validation succeeds
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return other is EmbeddingValue && floats == other.floats && base64 == other.base64
    }

    override fun hashCode(): Int = Objects.hash(floats, base64)

    override fun toString(): String =
        when {
            floats != null -> "EmbeddingValue{floats=$floats}"
            base64 != null -> "EmbeddingValue{base64=$base64}"
            _json != null -> "EmbeddingValue{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid EmbeddingValue")
        }

    companion object {
        /**
         * Creates an EmbeddingValue from a list of floats. The input list is defensively copied to
         * ensure immutability.
         *
         * @param floats the list of float values (will be copied)
         * @return a new immutable EmbeddingValue instance
         * @throws OpenAIInvalidDataException if validation fails
         */
        @JvmStatic
        fun ofFloats(floats: List<Float>): EmbeddingValue {
            return EmbeddingValue(floats = floats.toList()).apply { validate() }
        }

        /**
         * Creates an EmbeddingValue from a base64-encoded string.
         *
         * @param base64 the base64-encoded string
         * @return a new immutable EmbeddingValue instance
         * @throws OpenAIInvalidDataException if validation fails
         */
        @JvmStatic
        fun ofBase64(base64: String): EmbeddingValue {
            return EmbeddingValue(base64 = base64).apply { validate() }
        }

        /**
         * Decodes a base64 string to a list of floats. Assumes the base64 string represents an
         * array of 32-bit IEEE 754 floats in little-endian format.
         */
        private fun decodeBase64ToFloats(base64: String): List<Float> {
            return Base64.getDecoder().decode(base64).let { bytes ->
                ByteBuffer.wrap(bytes).asFloatBuffer().let { buffer ->
                    (0 until buffer.remaining()).map { buffer.get() }
                }
            }
        }

        /**
         * Encodes a list of floats to a base64 string. Encodes the floats as an array of 32-bit
         * IEEE 754 floats in little-endian format.
         */
        private fun encodeFloatsToBase64(floats: List<Float>): String {
            return ByteBuffer.allocate(floats.size * 4)
                .apply { floats.forEach { putFloat(it) } }
                .array()
                .let { bytes -> Base64.getEncoder().encodeToString(bytes) }
        }
    }

    /** Visitor interface for handling different types of embedding data. */
    interface Visitor<out T> {
        fun visitFloats(floats: List<Float>): T

        fun visitBase64(base64: String): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown EmbeddingValue: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<EmbeddingValue>(EmbeddingValue::class) {
        override fun ObjectCodec.deserialize(node: JsonNode): EmbeddingValue {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<List<Float>>())?.let {
                            EmbeddingValue(floats = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            EmbeddingValue(base64 = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()

            return when (bestMatches.size) {
                0 -> EmbeddingValue(_json = json)
                1 -> bestMatches.single()
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<EmbeddingValue>(EmbeddingValue::class) {
        override fun serialize(
            value: EmbeddingValue,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.floats != null -> generator.writeObject(value.floats)
                value.base64 != null -> generator.writeObject(value.base64)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid EmbeddingValue")
            }
        }
    }

    /** Returns a score indicating how many valid values are contained in this object. */
    @JvmSynthetic
    internal fun validity(): Int =
        when {
            floats != null -> floats.size
            base64 != null -> 1
            else -> 0
        }
}
