// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Represents a transcription response returned by model, based on the provided input. */
@JsonDeserialize(using = AudioTranscriptionCreateResponse.Deserializer::class)
@JsonSerialize(using = AudioTranscriptionCreateResponse.Serializer::class)
class AudioTranscriptionCreateResponse
private constructor(
    private val transcription: Transcription? = null,
    private val transcriptionVerbose: TranscriptionVerbose? = null,
    private val _json: JsonValue? = null,
) {

    /** Represents a transcription response returned by model, based on the provided input. */
    fun transcription(): Optional<Transcription> = Optional.ofNullable(transcription)

    /**
     * Represents a verbose json transcription response returned by model, based on the provided
     * input.
     */
    fun transcriptionVerbose(): Optional<TranscriptionVerbose> =
        Optional.ofNullable(transcriptionVerbose)

    fun isTranscription(): Boolean = transcription != null

    fun isTranscriptionVerbose(): Boolean = transcriptionVerbose != null

    /** Represents a transcription response returned by model, based on the provided input. */
    fun asTranscription(): Transcription = transcription.getOrThrow("transcription")

    /**
     * Represents a verbose json transcription response returned by model, based on the provided
     * input.
     */
    fun asTranscriptionVerbose(): TranscriptionVerbose =
        transcriptionVerbose.getOrThrow("transcriptionVerbose")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            transcription != null -> visitor.visitTranscription(transcription)
            transcriptionVerbose != null -> visitor.visitTranscriptionVerbose(transcriptionVerbose)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): AudioTranscriptionCreateResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitTranscription(transcription: Transcription) {
                    transcription.validate()
                }

                override fun visitTranscriptionVerbose(transcriptionVerbose: TranscriptionVerbose) {
                    transcriptionVerbose.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AudioTranscriptionCreateResponse && transcription == other.transcription && transcriptionVerbose == other.transcriptionVerbose /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(transcription, transcriptionVerbose) /* spotless:on */

    override fun toString(): String =
        when {
            transcription != null ->
                "AudioTranscriptionCreateResponse{transcription=$transcription}"
            transcriptionVerbose != null ->
                "AudioTranscriptionCreateResponse{transcriptionVerbose=$transcriptionVerbose}"
            _json != null -> "AudioTranscriptionCreateResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AudioTranscriptionCreateResponse")
        }

    companion object {

        /** Represents a transcription response returned by model, based on the provided input. */
        @JvmStatic
        fun ofTranscription(transcription: Transcription) =
            AudioTranscriptionCreateResponse(transcription = transcription)

        /**
         * Represents a verbose json transcription response returned by model, based on the provided
         * input.
         */
        @JvmStatic
        fun ofTranscriptionVerbose(transcriptionVerbose: TranscriptionVerbose) =
            AudioTranscriptionCreateResponse(transcriptionVerbose = transcriptionVerbose)
    }

    /**
     * An interface that defines how to map each variant of [AudioTranscriptionCreateResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /** Represents a transcription response returned by model, based on the provided input. */
        fun visitTranscription(transcription: Transcription): T

        /**
         * Represents a verbose json transcription response returned by model, based on the provided
         * input.
         */
        fun visitTranscriptionVerbose(transcriptionVerbose: TranscriptionVerbose): T

        /**
         * Maps an unknown variant of [AudioTranscriptionCreateResponse] to a value of type [T].
         *
         * An instance of [AudioTranscriptionCreateResponse] can contain an unknown variant if it
         * was deserialized from data that doesn't match any known variant. For example, if the SDK
         * is on an older version than the API, then the API may respond with new variants that the
         * SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AudioTranscriptionCreateResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AudioTranscriptionCreateResponse>(
            AudioTranscriptionCreateResponse::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): AudioTranscriptionCreateResponse {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<Transcription>()) { it.validate() }
                ?.let {
                    return AudioTranscriptionCreateResponse(transcription = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<TranscriptionVerbose>()) { it.validate() }
                ?.let {
                    return AudioTranscriptionCreateResponse(transcriptionVerbose = it, _json = json)
                }

            return AudioTranscriptionCreateResponse(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<AudioTranscriptionCreateResponse>(AudioTranscriptionCreateResponse::class) {

        override fun serialize(
            value: AudioTranscriptionCreateResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.transcription != null -> generator.writeObject(value.transcription)
                value.transcriptionVerbose != null ->
                    generator.writeObject(value.transcriptionVerbose)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AudioTranscriptionCreateResponse")
            }
        }
    }
}
