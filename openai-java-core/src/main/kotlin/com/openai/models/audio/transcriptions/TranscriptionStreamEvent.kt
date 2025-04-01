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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Emitted when there is an additional text delta. This is also the first event emitted when the
 * transcription starts. Only emitted when you
 * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
 * with the `Stream` parameter set to `true`.
 */
@JsonDeserialize(using = TranscriptionStreamEvent.Deserializer::class)
@JsonSerialize(using = TranscriptionStreamEvent.Serializer::class)
class TranscriptionStreamEvent
private constructor(
    private val transcriptTextDelta: TranscriptionTextDeltaEvent? = null,
    private val transcriptTextDone: TranscriptionTextDoneEvent? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Emitted when there is an additional text delta. This is also the first event emitted when the
     * transcription starts. Only emitted when you
     * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
     * with the `Stream` parameter set to `true`.
     */
    fun transcriptTextDelta(): Optional<TranscriptionTextDeltaEvent> =
        Optional.ofNullable(transcriptTextDelta)

    /**
     * Emitted when the transcription is complete. Contains the complete transcription text. Only
     * emitted when you
     * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
     * with the `Stream` parameter set to `true`.
     */
    fun transcriptTextDone(): Optional<TranscriptionTextDoneEvent> =
        Optional.ofNullable(transcriptTextDone)

    fun isTranscriptTextDelta(): Boolean = transcriptTextDelta != null

    fun isTranscriptTextDone(): Boolean = transcriptTextDone != null

    /**
     * Emitted when there is an additional text delta. This is also the first event emitted when the
     * transcription starts. Only emitted when you
     * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
     * with the `Stream` parameter set to `true`.
     */
    fun asTranscriptTextDelta(): TranscriptionTextDeltaEvent =
        transcriptTextDelta.getOrThrow("transcriptTextDelta")

    /**
     * Emitted when the transcription is complete. Contains the complete transcription text. Only
     * emitted when you
     * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
     * with the `Stream` parameter set to `true`.
     */
    fun asTranscriptTextDone(): TranscriptionTextDoneEvent =
        transcriptTextDone.getOrThrow("transcriptTextDone")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            transcriptTextDelta != null -> visitor.visitTranscriptTextDelta(transcriptTextDelta)
            transcriptTextDone != null -> visitor.visitTranscriptTextDone(transcriptTextDone)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): TranscriptionStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitTranscriptTextDelta(
                    transcriptTextDelta: TranscriptionTextDeltaEvent
                ) {
                    transcriptTextDelta.validate()
                }

                override fun visitTranscriptTextDone(
                    transcriptTextDone: TranscriptionTextDoneEvent
                ) {
                    transcriptTextDone.validate()
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
                override fun visitTranscriptTextDelta(
                    transcriptTextDelta: TranscriptionTextDeltaEvent
                ) = transcriptTextDelta.validity()

                override fun visitTranscriptTextDone(
                    transcriptTextDone: TranscriptionTextDoneEvent
                ) = transcriptTextDone.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranscriptionStreamEvent && transcriptTextDelta == other.transcriptTextDelta && transcriptTextDone == other.transcriptTextDone /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(transcriptTextDelta, transcriptTextDone) /* spotless:on */

    override fun toString(): String =
        when {
            transcriptTextDelta != null ->
                "TranscriptionStreamEvent{transcriptTextDelta=$transcriptTextDelta}"
            transcriptTextDone != null ->
                "TranscriptionStreamEvent{transcriptTextDone=$transcriptTextDone}"
            _json != null -> "TranscriptionStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid TranscriptionStreamEvent")
        }

    companion object {

        /**
         * Emitted when there is an additional text delta. This is also the first event emitted when
         * the transcription starts. Only emitted when you
         * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
         * with the `Stream` parameter set to `true`.
         */
        @JvmStatic
        fun ofTranscriptTextDelta(transcriptTextDelta: TranscriptionTextDeltaEvent) =
            TranscriptionStreamEvent(transcriptTextDelta = transcriptTextDelta)

        /**
         * Emitted when the transcription is complete. Contains the complete transcription text.
         * Only emitted when you
         * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
         * with the `Stream` parameter set to `true`.
         */
        @JvmStatic
        fun ofTranscriptTextDone(transcriptTextDone: TranscriptionTextDoneEvent) =
            TranscriptionStreamEvent(transcriptTextDone = transcriptTextDone)
    }

    /**
     * An interface that defines how to map each variant of [TranscriptionStreamEvent] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /**
         * Emitted when there is an additional text delta. This is also the first event emitted when
         * the transcription starts. Only emitted when you
         * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
         * with the `Stream` parameter set to `true`.
         */
        fun visitTranscriptTextDelta(transcriptTextDelta: TranscriptionTextDeltaEvent): T

        /**
         * Emitted when the transcription is complete. Contains the complete transcription text.
         * Only emitted when you
         * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
         * with the `Stream` parameter set to `true`.
         */
        fun visitTranscriptTextDone(transcriptTextDone: TranscriptionTextDoneEvent): T

        /**
         * Maps an unknown variant of [TranscriptionStreamEvent] to a value of type [T].
         *
         * An instance of [TranscriptionStreamEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown TranscriptionStreamEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<TranscriptionStreamEvent>(TranscriptionStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): TranscriptionStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "transcript.text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<TranscriptionTextDeltaEvent>())
                        ?.let { TranscriptionStreamEvent(transcriptTextDelta = it, _json = json) }
                        ?: TranscriptionStreamEvent(_json = json)
                }
                "transcript.text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<TranscriptionTextDoneEvent>())?.let {
                        TranscriptionStreamEvent(transcriptTextDone = it, _json = json)
                    } ?: TranscriptionStreamEvent(_json = json)
                }
            }

            return TranscriptionStreamEvent(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<TranscriptionStreamEvent>(TranscriptionStreamEvent::class) {

        override fun serialize(
            value: TranscriptionStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.transcriptTextDelta != null ->
                    generator.writeObject(value.transcriptTextDelta)
                value.transcriptTextDone != null -> generator.writeObject(value.transcriptTextDone)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid TranscriptionStreamEvent")
            }
        }
    }
}
