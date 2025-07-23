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
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.nio.ByteBuffer
import java.util.Base64
import java.util.Objects
import java.util.Optional

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

    fun floats(): Optional<List<Float>> = Optional.ofNullable(floats)

    fun base64(): Optional<String> = Optional.ofNullable(base64)

    /** Returns true if this value contains a list of floats. */
    fun isFloats(): Boolean = floats != null

    /** Returns true if this value contains base64 string data. */
    fun isBase64(): Boolean = base64 != null

    /**
     * Returns the embedding data as a list of floats.
     *
     * If this value represents base64 string data, then it's decoded into floats.
     */
    fun asFloats(): List<Float> =
        when {
            floats != null -> floats
            base64 != null -> decodeBase64ToFloats(base64)
            else -> throw IllegalStateException("Invalid EmbeddingValue")
        }

    /**
     * Returns the embedding data as a base64 string.
     *
     * If this value represents a list of floats, then it's decoded into floats.
     */
    fun asBase64(): String =
        when {
            base64 != null -> base64
            floats != null -> encodeFloatsAsBase64(floats)
            else -> throw IllegalStateException("Invalid EmbeddingValue")
        }

    fun _json(): JsonValue? = _json

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            floats != null -> visitor.visitFloats(floats)
            base64 != null -> visitor.visitBase64(base64)
            else -> visitor.unknown(_json)
        }

    fun validate() = apply {
        accept(
            object : Visitor<Unit> {
                override fun visitFloats(floats: List<Float>) {}

                override fun visitBase64(base64: String) {}
            }
        )
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        when {
            floats != null -> floats.size
            base64 != null -> 1
            else -> 0
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EmbeddingValue && floats == other.floats && base64 == other.base64 && _json == other._json /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */  Objects.hash(floats, base64, _json) /* spotless:on */

    override fun toString(): String =
        when {
            floats != null -> "EmbeddingValue{floats=$floats}"
            base64 != null -> "EmbeddingValue{base64=$base64}"
            _json != null -> "EmbeddingValue{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid EmbeddingValue")
        }

    companion object {

        @JvmStatic fun ofFloats(floats: List<Float>) = EmbeddingValue(floats = floats.toImmutable())

        @JvmStatic fun ofBase64(base64: String) = EmbeddingValue(base64 = base64)

        /**
         * Decodes a base64 string to a list of floats. Assumes the base64 string represents an
         * array of 32-bit IEEE 754 floats in little-endian format.
         */
        private fun decodeBase64ToFloats(base64: String): List<Float> =
            Base64.getDecoder().decode(base64).let { bytes ->
                ByteBuffer.wrap(bytes).asFloatBuffer().let { buffer ->
                    (0 until buffer.remaining()).map { buffer.get() }
                }
            }

        /**
         * Encodes a list of floats to a base64 string. Encodes the floats as an array of 32-bit
         * IEEE 754 floats in little-endian format.
         */
        private fun encodeFloatsAsBase64(floats: List<Float>): String =
            ByteBuffer.allocate(floats.size * 4)
                .apply { floats.forEach { putFloat(it) } }
                .array()
                .let { bytes -> Base64.getEncoder().encodeToString(bytes) }
    }

    /**
     * An interface that defines how to map each variant of [EmbeddingValue] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitFloats(floats: List<Float>): T

        fun visitBase64(base64: String): T

        /**
         * Maps an unknown variant of [EmbeddingValue] to a value of type [T].
         *
         * An instance of [EmbeddingValue] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
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
}
