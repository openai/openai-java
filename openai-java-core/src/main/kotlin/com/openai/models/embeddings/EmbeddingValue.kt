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
    private val floatList: List<Float>? = null,
    private val base64String: String? = null,
    private val _json: JsonValue? = null,
) {

    /** Returns the embedding as a list of floats, or null if this value represents base64 data. */
    fun floatList(): List<Float>? = floatList

    /**
     * Returns the embedding as a base64-encoded string, or null if this value represents float
     * data.
     */
    fun base64String(): String? = base64String

    /** Returns true if this value contains float list data. */
    fun isFloatList(): Boolean = floatList != null

    /** Returns true if this value contains base64 string data. */
    fun isBase64String(): Boolean = base64String != null

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
    fun asFloatList(): List<Float> =
        when {
            floatList != null -> floatList
            base64String != null ->
                decodeBase64ToFloatList(base64String) // Automatic Base64 decoding
            else -> throw IllegalStateException("No valid embedding data")
        }

    /**
     * Returns the embedding data as a base64-encoded string. If the data is a float list, it will
     * be encoded automatically.
     */
    fun asBase64String(): String =
        when {
            base64String != null -> base64String
            floatList != null -> encodeFloatListToBase64(floatList)
            else -> throw IllegalStateException("No valid embedding data")
        }

    /** Returns the raw JSON value for debugging purposes. */
    fun _json(): JsonValue? = _json

    /** Accepts a visitor that can handle both float list and base64 string cases. */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            floatList != null -> visitor.visitFloatList(floatList)
            base64String != null -> visitor.visitBase64String(base64String)
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
                override fun visitFloatList(floatList: List<Float>) {
                    // Validate that float list is not empty and contains valid values
                    if (floatList.isEmpty()) {
                        throw OpenAIInvalidDataException("Float list cannot be empty")
                    }
                    floatList.forEach { value ->
                        if (!value.isFinite()) {
                            throw OpenAIInvalidDataException("Float values must be finite")
                        }
                    }
                }

                override fun visitBase64String(base64String: String) {
                    // Validate base64 format
                    try {
                        Base64.getDecoder().decode(base64String)
                    } catch (e: IllegalArgumentException) {
                        throw OpenAIInvalidDataException("Invalid base64 string", e)
                    }
                }
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
        return other is EmbeddingValue &&
            floatList == other.floatList &&
            base64String == other.base64String
    }

    override fun hashCode(): Int = Objects.hash(floatList, base64String)

    override fun toString(): String =
        when {
            floatList != null -> "EmbeddingValue{floatList=$floatList}"
            base64String != null -> "EmbeddingValue{base64String=$base64String}"
            _json != null -> "EmbeddingValue{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid EmbeddingValue")
        }

    companion object {
        /**
         * Creates an EmbeddingValue from a list of floats. The input list is defensively copied to
         * ensure immutability.
         *
         * @param floatList the list of float values (will be copied)
         * @return a new immutable EmbeddingValue instance
         * @throws OpenAIInvalidDataException if validation fails
         */
        @JvmStatic
        fun ofFloatList(floatList: List<Float>): EmbeddingValue {
            // Defensive copy to ensure immutability
            val immutableList = floatList.toList()
            val instance = EmbeddingValue(floatList = immutableList)
            return instance.validate() // Validate upon creation
        }

        /**
         * Creates an EmbeddingValue from a base64-encoded string.
         *
         * @param base64String the base64-encoded string
         * @return a new immutable EmbeddingValue instance
         * @throws OpenAIInvalidDataException if validation fails
         */
        @JvmStatic
        fun ofBase64String(base64String: String): EmbeddingValue {
            val instance = EmbeddingValue(base64String = base64String)
            return instance.validate() // Validate upon creation
        }

        /**
         * Decodes a base64 string to a list of floats. Assumes the base64 string represents an
         * array of 32-bit IEEE 754 floats in little-endian format.
         */
        private fun decodeBase64ToFloatList(base64String: String): List<Float> {
            val bytes = Base64.getDecoder().decode(base64String)
            val buffer = ByteBuffer.wrap(bytes).asFloatBuffer()
            return (0 until buffer.remaining()).map { buffer.get() }
        }

        /**
         * Encodes a list of floats to a base64 string. Encodes the floats as an array of 32-bit
         * IEEE 754 floats in little-endian format.
         */
        private fun encodeFloatListToBase64(floatList: List<Float>): String {
            val buffer = ByteBuffer.allocate(floatList.size * 4)
            floatList.forEach { buffer.putFloat(it) }
            return Base64.getEncoder().encodeToString(buffer.array())
        }
    }

    /** Visitor interface for handling different types of embedding data. */
    interface Visitor<out T> {
        fun visitFloatList(floatList: List<Float>): T

        fun visitBase64String(base64String: String): T

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
                            EmbeddingValue(floatList = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            EmbeddingValue(base64String = it, _json = json)
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
                value.floatList != null -> generator.writeObject(value.floatList)
                value.base64String != null -> generator.writeObject(value.base64String)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid EmbeddingValue")
            }
        }
    }

    /** Returns a score indicating how many valid values are contained in this object. */
    @JvmSynthetic
    internal fun validity(): Int =
        when {
            floatList != null -> floatList.size
            base64String != null -> 1
            else -> 0
        }
}
