// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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

/** A Realtime translation client event. */
@JsonDeserialize(using = RealtimeTranslationClientEvent.Deserializer::class)
@JsonSerialize(using = RealtimeTranslationClientEvent.Serializer::class)
class RealtimeTranslationClientEvent
private constructor(
    private val sessionUpdate: RealtimeTranslationSessionUpdateEvent? = null,
    private val sessionInputAudioBufferAppend: RealtimeTranslationInputAudioBufferAppendEvent? =
        null,
    private val sessionClose: RealtimeTranslationSessionCloseEvent? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Send this event to update the translation session configuration. Translation sessions support
     * updates to `audio.output.language`, `audio.input.transcription`, and
     * `audio.input.noise_reduction`.
     */
    fun sessionUpdate(): Optional<RealtimeTranslationSessionUpdateEvent> =
        Optional.ofNullable(sessionUpdate)

    /**
     * Send this event to append audio bytes to the translation session input audio buffer.
     *
     * WebSocket translation sessions accept base64-encoded 24 kHz PCM16 mono little-endian raw
     * audio bytes. Unsupported websocket audio formats return a validation error because
     * lower-quality audio materially degrades translation quality.
     *
     * Translation consumes 200 ms engine frames. For best realtime behavior, append audio in 200 ms
     * chunks. If a chunk is shorter, the server buffers it until it has enough audio for one frame.
     * If a chunk is longer, the server splits it into 200 ms frames and enqueues them back-to-back.
     *
     * Keep appending silence while the session is active. If a client stops sending audio and later
     * resumes, model time treats the resumed audio as contiguous with the previous audio rather
     * than as a real-world pause.
     */
    fun sessionInputAudioBufferAppend(): Optional<RealtimeTranslationInputAudioBufferAppendEvent> =
        Optional.ofNullable(sessionInputAudioBufferAppend)

    /**
     * Gracefully close the realtime translation session. The server flushes pending input audio and
     * emits any remaining translated output before closing the session.
     */
    fun sessionClose(): Optional<RealtimeTranslationSessionCloseEvent> =
        Optional.ofNullable(sessionClose)

    fun isSessionUpdate(): Boolean = sessionUpdate != null

    fun isSessionInputAudioBufferAppend(): Boolean = sessionInputAudioBufferAppend != null

    fun isSessionClose(): Boolean = sessionClose != null

    /**
     * Send this event to update the translation session configuration. Translation sessions support
     * updates to `audio.output.language`, `audio.input.transcription`, and
     * `audio.input.noise_reduction`.
     */
    fun asSessionUpdate(): RealtimeTranslationSessionUpdateEvent =
        sessionUpdate.getOrThrow("sessionUpdate")

    /**
     * Send this event to append audio bytes to the translation session input audio buffer.
     *
     * WebSocket translation sessions accept base64-encoded 24 kHz PCM16 mono little-endian raw
     * audio bytes. Unsupported websocket audio formats return a validation error because
     * lower-quality audio materially degrades translation quality.
     *
     * Translation consumes 200 ms engine frames. For best realtime behavior, append audio in 200 ms
     * chunks. If a chunk is shorter, the server buffers it until it has enough audio for one frame.
     * If a chunk is longer, the server splits it into 200 ms frames and enqueues them back-to-back.
     *
     * Keep appending silence while the session is active. If a client stops sending audio and later
     * resumes, model time treats the resumed audio as contiguous with the previous audio rather
     * than as a real-world pause.
     */
    fun asSessionInputAudioBufferAppend(): RealtimeTranslationInputAudioBufferAppendEvent =
        sessionInputAudioBufferAppend.getOrThrow("sessionInputAudioBufferAppend")

    /**
     * Gracefully close the realtime translation session. The server flushes pending input audio and
     * emits any remaining translated output before closing the session.
     */
    fun asSessionClose(): RealtimeTranslationSessionCloseEvent =
        sessionClose.getOrThrow("sessionClose")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = realtimeTranslationClientEvent.accept(new RealtimeTranslationClientEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitSessionUpdate(RealtimeTranslationSessionUpdateEvent sessionUpdate) {
     *         return Optional.of(sessionUpdate.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            sessionUpdate != null -> visitor.visitSessionUpdate(sessionUpdate)
            sessionInputAudioBufferAppend != null ->
                visitor.visitSessionInputAudioBufferAppend(sessionInputAudioBufferAppend)
            sessionClose != null -> visitor.visitSessionClose(sessionClose)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): RealtimeTranslationClientEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitSessionUpdate(
                    sessionUpdate: RealtimeTranslationSessionUpdateEvent
                ) {
                    sessionUpdate.validate()
                }

                override fun visitSessionInputAudioBufferAppend(
                    sessionInputAudioBufferAppend: RealtimeTranslationInputAudioBufferAppendEvent
                ) {
                    sessionInputAudioBufferAppend.validate()
                }

                override fun visitSessionClose(sessionClose: RealtimeTranslationSessionCloseEvent) {
                    sessionClose.validate()
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
                override fun visitSessionUpdate(
                    sessionUpdate: RealtimeTranslationSessionUpdateEvent
                ) = sessionUpdate.validity()

                override fun visitSessionInputAudioBufferAppend(
                    sessionInputAudioBufferAppend: RealtimeTranslationInputAudioBufferAppendEvent
                ) = sessionInputAudioBufferAppend.validity()

                override fun visitSessionClose(sessionClose: RealtimeTranslationSessionCloseEvent) =
                    sessionClose.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranslationClientEvent &&
            sessionUpdate == other.sessionUpdate &&
            sessionInputAudioBufferAppend == other.sessionInputAudioBufferAppend &&
            sessionClose == other.sessionClose
    }

    override fun hashCode(): Int =
        Objects.hash(sessionUpdate, sessionInputAudioBufferAppend, sessionClose)

    override fun toString(): String =
        when {
            sessionUpdate != null -> "RealtimeTranslationClientEvent{sessionUpdate=$sessionUpdate}"
            sessionInputAudioBufferAppend != null ->
                "RealtimeTranslationClientEvent{sessionInputAudioBufferAppend=$sessionInputAudioBufferAppend}"
            sessionClose != null -> "RealtimeTranslationClientEvent{sessionClose=$sessionClose}"
            _json != null -> "RealtimeTranslationClientEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeTranslationClientEvent")
        }

    companion object {

        /**
         * Send this event to update the translation session configuration. Translation sessions
         * support updates to `audio.output.language`, `audio.input.transcription`, and
         * `audio.input.noise_reduction`.
         */
        @JvmStatic
        fun ofSessionUpdate(sessionUpdate: RealtimeTranslationSessionUpdateEvent) =
            RealtimeTranslationClientEvent(sessionUpdate = sessionUpdate)

        /**
         * Send this event to append audio bytes to the translation session input audio buffer.
         *
         * WebSocket translation sessions accept base64-encoded 24 kHz PCM16 mono little-endian raw
         * audio bytes. Unsupported websocket audio formats return a validation error because
         * lower-quality audio materially degrades translation quality.
         *
         * Translation consumes 200 ms engine frames. For best realtime behavior, append audio in
         * 200 ms chunks. If a chunk is shorter, the server buffers it until it has enough audio for
         * one frame. If a chunk is longer, the server splits it into 200 ms frames and enqueues
         * them back-to-back.
         *
         * Keep appending silence while the session is active. If a client stops sending audio and
         * later resumes, model time treats the resumed audio as contiguous with the previous audio
         * rather than as a real-world pause.
         */
        @JvmStatic
        fun ofSessionInputAudioBufferAppend(
            sessionInputAudioBufferAppend: RealtimeTranslationInputAudioBufferAppendEvent
        ) =
            RealtimeTranslationClientEvent(
                sessionInputAudioBufferAppend = sessionInputAudioBufferAppend
            )

        /**
         * Gracefully close the realtime translation session. The server flushes pending input audio
         * and emits any remaining translated output before closing the session.
         */
        @JvmStatic
        fun ofSessionClose(sessionClose: RealtimeTranslationSessionCloseEvent) =
            RealtimeTranslationClientEvent(sessionClose = sessionClose)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeTranslationClientEvent] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /**
         * Send this event to update the translation session configuration. Translation sessions
         * support updates to `audio.output.language`, `audio.input.transcription`, and
         * `audio.input.noise_reduction`.
         */
        fun visitSessionUpdate(sessionUpdate: RealtimeTranslationSessionUpdateEvent): T

        /**
         * Send this event to append audio bytes to the translation session input audio buffer.
         *
         * WebSocket translation sessions accept base64-encoded 24 kHz PCM16 mono little-endian raw
         * audio bytes. Unsupported websocket audio formats return a validation error because
         * lower-quality audio materially degrades translation quality.
         *
         * Translation consumes 200 ms engine frames. For best realtime behavior, append audio in
         * 200 ms chunks. If a chunk is shorter, the server buffers it until it has enough audio for
         * one frame. If a chunk is longer, the server splits it into 200 ms frames and enqueues
         * them back-to-back.
         *
         * Keep appending silence while the session is active. If a client stops sending audio and
         * later resumes, model time treats the resumed audio as contiguous with the previous audio
         * rather than as a real-world pause.
         */
        fun visitSessionInputAudioBufferAppend(
            sessionInputAudioBufferAppend: RealtimeTranslationInputAudioBufferAppendEvent
        ): T

        /**
         * Gracefully close the realtime translation session. The server flushes pending input audio
         * and emits any remaining translated output before closing the session.
         */
        fun visitSessionClose(sessionClose: RealtimeTranslationSessionCloseEvent): T

        /**
         * Maps an unknown variant of [RealtimeTranslationClientEvent] to a value of type [T].
         *
         * An instance of [RealtimeTranslationClientEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeTranslationClientEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<RealtimeTranslationClientEvent>(RealtimeTranslationClientEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeTranslationClientEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "session.update" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationSessionUpdateEvent>(),
                        )
                        ?.let { RealtimeTranslationClientEvent(sessionUpdate = it, _json = json) }
                        ?: RealtimeTranslationClientEvent(_json = json)
                }
                "session.input_audio_buffer.append" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationInputAudioBufferAppendEvent>(),
                        )
                        ?.let {
                            RealtimeTranslationClientEvent(
                                sessionInputAudioBufferAppend = it,
                                _json = json,
                            )
                        } ?: RealtimeTranslationClientEvent(_json = json)
                }
                "session.close" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationSessionCloseEvent>(),
                        )
                        ?.let { RealtimeTranslationClientEvent(sessionClose = it, _json = json) }
                        ?: RealtimeTranslationClientEvent(_json = json)
                }
            }

            return RealtimeTranslationClientEvent(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<RealtimeTranslationClientEvent>(RealtimeTranslationClientEvent::class) {

        override fun serialize(
            value: RealtimeTranslationClientEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.sessionUpdate != null -> generator.writeObject(value.sessionUpdate)
                value.sessionInputAudioBufferAppend != null ->
                    generator.writeObject(value.sessionInputAudioBufferAppend)
                value.sessionClose != null -> generator.writeObject(value.sessionClose)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeTranslationClientEvent")
            }
        }
    }
}
