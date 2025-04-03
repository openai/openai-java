// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Represents a transcription response returned by model, based on the provided input. */
@JsonDeserialize(using = TranscriptionCreateResponse.Deserializer::class)
@JsonSerialize(using = TranscriptionCreateResponse.Serializer::class)
class TranscriptionCreateResponse
private constructor(
    private val transcription: Transcription? = null,
    private val verbose: TranscriptionVerbose? = null,
    private val _json: JsonValue? = null,
) {

    /** Represents a transcription response returned by model, based on the provided input. */
    fun transcription(): Optional<Transcription> = Optional.ofNullable(transcription)

    /**
     * Represents a verbose json transcription response returned by model, based on the provided
     * input.
     */
    fun verbose(): Optional<TranscriptionVerbose> = Optional.ofNullable(verbose)

    fun isTranscription(): Boolean = transcription != null

    fun isVerbose(): Boolean = verbose != null

    /** Represents a transcription response returned by model, based on the provided input. */
    fun asTranscription(): Transcription = transcription.getOrThrow("transcription")

    /**
     * Represents a verbose json transcription response returned by model, based on the provided
     * input.
     */
    fun asVerbose(): TranscriptionVerbose = verbose.getOrThrow("verbose")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            transcription != null -> visitor.visitTranscription(transcription)
            verbose != null -> visitor.visitVerbose(verbose)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): TranscriptionCreateResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitTranscription(transcription: Transcription) {
                    transcription.validate()
                }

                override fun visitVerbose(verbose: TranscriptionVerbose) {
                    verbose.validate()
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitTranscription(transcription: Transcription) =
                    transcription.validity()

                override fun visitVerbose(verbose: TranscriptionVerbose) = verbose.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranscriptionCreateResponse && transcription == other.transcription && verbose == other.verbose /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(transcription, verbose) /* spotless:on */

    override fun toString(): String =
        when {
            transcription != null -> "TranscriptionCreateResponse{transcription=$transcription}"
            verbose != null -> "TranscriptionCreateResponse{verbose=$verbose}"
            _json != null -> "TranscriptionCreateResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid TranscriptionCreateResponse")
        }

    companion object {

        /** Represents a transcription response returned by model, based on the provided input. */
        @JvmStatic
        fun ofTranscription(transcription: Transcription) =
            TranscriptionCreateResponse(transcription = transcription)

        /**
         * Represents a verbose json transcription response returned by model, based on the provided
         * input.
         */
        @JvmStatic
        fun ofVerbose(verbose: TranscriptionVerbose) =
            TranscriptionCreateResponse(verbose = verbose)
    }

    /**
     * An interface that defines how to map each variant of [TranscriptionCreateResponse] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** Represents a transcription response returned by model, based on the provided input. */
        fun visitTranscription(transcription: Transcription): T

        /**
         * Represents a verbose json transcription response returned by model, based on the provided
         * input.
         */
        fun visitVerbose(verbose: TranscriptionVerbose): T

        /**
         * Maps an unknown variant of [TranscriptionCreateResponse] to a value of type [T].
         *
         * An instance of [TranscriptionCreateResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown TranscriptionCreateResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<TranscriptionCreateResponse>(TranscriptionCreateResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): TranscriptionCreateResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<Transcription>())?.let {
                            TranscriptionCreateResponse(transcription = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<TranscriptionVerbose>())?.let {
                            TranscriptionCreateResponse(verbose = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> TranscriptionCreateResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<TranscriptionCreateResponse>(TranscriptionCreateResponse::class) {

        override fun serialize(
            value: TranscriptionCreateResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.transcription != null -> generator.writeObject(value.transcription)
                value.verbose != null -> generator.writeObject(value.verbose)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid TranscriptionCreateResponse")
            }
        }
    }
}
