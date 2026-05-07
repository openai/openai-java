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

/** A Realtime translation server event. */
@JsonDeserialize(using = RealtimeTranslationServerEvent.Deserializer::class)
@JsonSerialize(using = RealtimeTranslationServerEvent.Serializer::class)
class RealtimeTranslationServerEvent
private constructor(
    private val error: RealtimeErrorEvent? = null,
    private val sessionCreated: RealtimeTranslationSessionCreatedEvent? = null,
    private val sessionUpdated: RealtimeTranslationSessionUpdatedEvent? = null,
    private val sessionClosed: RealtimeTranslationSessionClosedEvent? = null,
    private val sessionInputTranscriptDelta: RealtimeTranslationInputTranscriptDeltaEvent? = null,
    private val sessionOutputTranscriptDelta: RealtimeTranslationOutputTranscriptDeltaEvent? = null,
    private val sessionOutputAudioDelta: RealtimeTranslationOutputAudioDeltaEvent? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Returned when an error occurs, which could be a client problem or a server problem. Most
     * errors are recoverable and the session will stay open, we recommend to implementors to
     * monitor and log error messages by default.
     */
    fun error(): Optional<RealtimeErrorEvent> = Optional.ofNullable(error)

    /**
     * Returned when a translation session is created. Emitted automatically when a new connection
     * is established as the first server event. This event contains the default translation session
     * configuration.
     */
    fun sessionCreated(): Optional<RealtimeTranslationSessionCreatedEvent> =
        Optional.ofNullable(sessionCreated)

    /**
     * Returned when a translation session is updated with a `session.update` event, unless there is
     * an error.
     */
    fun sessionUpdated(): Optional<RealtimeTranslationSessionUpdatedEvent> =
        Optional.ofNullable(sessionUpdated)

    /** Returned when a realtime translation session is closed. */
    fun sessionClosed(): Optional<RealtimeTranslationSessionClosedEvent> =
        Optional.ofNullable(sessionClosed)

    /**
     * Returned when optional source-language transcript text is available. This event is emitted
     * only when `audio.input.transcription` is configured.
     *
     * Transcript deltas are append-only text fragments. Clients should not insert unconditional
     * spaces between deltas.
     */
    fun sessionInputTranscriptDelta(): Optional<RealtimeTranslationInputTranscriptDeltaEvent> =
        Optional.ofNullable(sessionInputTranscriptDelta)

    /**
     * Returned when translated transcript text is available.
     *
     * Transcript deltas are append-only text fragments. Clients should not insert unconditional
     * spaces between deltas.
     */
    fun sessionOutputTranscriptDelta(): Optional<RealtimeTranslationOutputTranscriptDeltaEvent> =
        Optional.ofNullable(sessionOutputTranscriptDelta)

    /**
     * Returned when translated output audio is available. Output audio deltas are 200 ms frames of
     * PCM16 audio.
     */
    fun sessionOutputAudioDelta(): Optional<RealtimeTranslationOutputAudioDeltaEvent> =
        Optional.ofNullable(sessionOutputAudioDelta)

    fun isError(): Boolean = error != null

    fun isSessionCreated(): Boolean = sessionCreated != null

    fun isSessionUpdated(): Boolean = sessionUpdated != null

    fun isSessionClosed(): Boolean = sessionClosed != null

    fun isSessionInputTranscriptDelta(): Boolean = sessionInputTranscriptDelta != null

    fun isSessionOutputTranscriptDelta(): Boolean = sessionOutputTranscriptDelta != null

    fun isSessionOutputAudioDelta(): Boolean = sessionOutputAudioDelta != null

    /**
     * Returned when an error occurs, which could be a client problem or a server problem. Most
     * errors are recoverable and the session will stay open, we recommend to implementors to
     * monitor and log error messages by default.
     */
    fun asError(): RealtimeErrorEvent = error.getOrThrow("error")

    /**
     * Returned when a translation session is created. Emitted automatically when a new connection
     * is established as the first server event. This event contains the default translation session
     * configuration.
     */
    fun asSessionCreated(): RealtimeTranslationSessionCreatedEvent =
        sessionCreated.getOrThrow("sessionCreated")

    /**
     * Returned when a translation session is updated with a `session.update` event, unless there is
     * an error.
     */
    fun asSessionUpdated(): RealtimeTranslationSessionUpdatedEvent =
        sessionUpdated.getOrThrow("sessionUpdated")

    /** Returned when a realtime translation session is closed. */
    fun asSessionClosed(): RealtimeTranslationSessionClosedEvent =
        sessionClosed.getOrThrow("sessionClosed")

    /**
     * Returned when optional source-language transcript text is available. This event is emitted
     * only when `audio.input.transcription` is configured.
     *
     * Transcript deltas are append-only text fragments. Clients should not insert unconditional
     * spaces between deltas.
     */
    fun asSessionInputTranscriptDelta(): RealtimeTranslationInputTranscriptDeltaEvent =
        sessionInputTranscriptDelta.getOrThrow("sessionInputTranscriptDelta")

    /**
     * Returned when translated transcript text is available.
     *
     * Transcript deltas are append-only text fragments. Clients should not insert unconditional
     * spaces between deltas.
     */
    fun asSessionOutputTranscriptDelta(): RealtimeTranslationOutputTranscriptDeltaEvent =
        sessionOutputTranscriptDelta.getOrThrow("sessionOutputTranscriptDelta")

    /**
     * Returned when translated output audio is available. Output audio deltas are 200 ms frames of
     * PCM16 audio.
     */
    fun asSessionOutputAudioDelta(): RealtimeTranslationOutputAudioDeltaEvent =
        sessionOutputAudioDelta.getOrThrow("sessionOutputAudioDelta")

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
     * Optional<String> result = realtimeTranslationServerEvent.accept(new RealtimeTranslationServerEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitError(RealtimeErrorEvent error) {
     *         return Optional.of(error.toString());
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
            error != null -> visitor.visitError(error)
            sessionCreated != null -> visitor.visitSessionCreated(sessionCreated)
            sessionUpdated != null -> visitor.visitSessionUpdated(sessionUpdated)
            sessionClosed != null -> visitor.visitSessionClosed(sessionClosed)
            sessionInputTranscriptDelta != null ->
                visitor.visitSessionInputTranscriptDelta(sessionInputTranscriptDelta)
            sessionOutputTranscriptDelta != null ->
                visitor.visitSessionOutputTranscriptDelta(sessionOutputTranscriptDelta)
            sessionOutputAudioDelta != null ->
                visitor.visitSessionOutputAudioDelta(sessionOutputAudioDelta)
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
    fun validate(): RealtimeTranslationServerEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitError(error: RealtimeErrorEvent) {
                    error.validate()
                }

                override fun visitSessionCreated(
                    sessionCreated: RealtimeTranslationSessionCreatedEvent
                ) {
                    sessionCreated.validate()
                }

                override fun visitSessionUpdated(
                    sessionUpdated: RealtimeTranslationSessionUpdatedEvent
                ) {
                    sessionUpdated.validate()
                }

                override fun visitSessionClosed(
                    sessionClosed: RealtimeTranslationSessionClosedEvent
                ) {
                    sessionClosed.validate()
                }

                override fun visitSessionInputTranscriptDelta(
                    sessionInputTranscriptDelta: RealtimeTranslationInputTranscriptDeltaEvent
                ) {
                    sessionInputTranscriptDelta.validate()
                }

                override fun visitSessionOutputTranscriptDelta(
                    sessionOutputTranscriptDelta: RealtimeTranslationOutputTranscriptDeltaEvent
                ) {
                    sessionOutputTranscriptDelta.validate()
                }

                override fun visitSessionOutputAudioDelta(
                    sessionOutputAudioDelta: RealtimeTranslationOutputAudioDeltaEvent
                ) {
                    sessionOutputAudioDelta.validate()
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
                override fun visitError(error: RealtimeErrorEvent) = error.validity()

                override fun visitSessionCreated(
                    sessionCreated: RealtimeTranslationSessionCreatedEvent
                ) = sessionCreated.validity()

                override fun visitSessionUpdated(
                    sessionUpdated: RealtimeTranslationSessionUpdatedEvent
                ) = sessionUpdated.validity()

                override fun visitSessionClosed(
                    sessionClosed: RealtimeTranslationSessionClosedEvent
                ) = sessionClosed.validity()

                override fun visitSessionInputTranscriptDelta(
                    sessionInputTranscriptDelta: RealtimeTranslationInputTranscriptDeltaEvent
                ) = sessionInputTranscriptDelta.validity()

                override fun visitSessionOutputTranscriptDelta(
                    sessionOutputTranscriptDelta: RealtimeTranslationOutputTranscriptDeltaEvent
                ) = sessionOutputTranscriptDelta.validity()

                override fun visitSessionOutputAudioDelta(
                    sessionOutputAudioDelta: RealtimeTranslationOutputAudioDeltaEvent
                ) = sessionOutputAudioDelta.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranslationServerEvent &&
            error == other.error &&
            sessionCreated == other.sessionCreated &&
            sessionUpdated == other.sessionUpdated &&
            sessionClosed == other.sessionClosed &&
            sessionInputTranscriptDelta == other.sessionInputTranscriptDelta &&
            sessionOutputTranscriptDelta == other.sessionOutputTranscriptDelta &&
            sessionOutputAudioDelta == other.sessionOutputAudioDelta
    }

    override fun hashCode(): Int =
        Objects.hash(
            error,
            sessionCreated,
            sessionUpdated,
            sessionClosed,
            sessionInputTranscriptDelta,
            sessionOutputTranscriptDelta,
            sessionOutputAudioDelta,
        )

    override fun toString(): String =
        when {
            error != null -> "RealtimeTranslationServerEvent{error=$error}"
            sessionCreated != null ->
                "RealtimeTranslationServerEvent{sessionCreated=$sessionCreated}"
            sessionUpdated != null ->
                "RealtimeTranslationServerEvent{sessionUpdated=$sessionUpdated}"
            sessionClosed != null -> "RealtimeTranslationServerEvent{sessionClosed=$sessionClosed}"
            sessionInputTranscriptDelta != null ->
                "RealtimeTranslationServerEvent{sessionInputTranscriptDelta=$sessionInputTranscriptDelta}"
            sessionOutputTranscriptDelta != null ->
                "RealtimeTranslationServerEvent{sessionOutputTranscriptDelta=$sessionOutputTranscriptDelta}"
            sessionOutputAudioDelta != null ->
                "RealtimeTranslationServerEvent{sessionOutputAudioDelta=$sessionOutputAudioDelta}"
            _json != null -> "RealtimeTranslationServerEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeTranslationServerEvent")
        }

    companion object {

        /**
         * Returned when an error occurs, which could be a client problem or a server problem. Most
         * errors are recoverable and the session will stay open, we recommend to implementors to
         * monitor and log error messages by default.
         */
        @JvmStatic
        fun ofError(error: RealtimeErrorEvent) = RealtimeTranslationServerEvent(error = error)

        /**
         * Returned when a translation session is created. Emitted automatically when a new
         * connection is established as the first server event. This event contains the default
         * translation session configuration.
         */
        @JvmStatic
        fun ofSessionCreated(sessionCreated: RealtimeTranslationSessionCreatedEvent) =
            RealtimeTranslationServerEvent(sessionCreated = sessionCreated)

        /**
         * Returned when a translation session is updated with a `session.update` event, unless
         * there is an error.
         */
        @JvmStatic
        fun ofSessionUpdated(sessionUpdated: RealtimeTranslationSessionUpdatedEvent) =
            RealtimeTranslationServerEvent(sessionUpdated = sessionUpdated)

        /** Returned when a realtime translation session is closed. */
        @JvmStatic
        fun ofSessionClosed(sessionClosed: RealtimeTranslationSessionClosedEvent) =
            RealtimeTranslationServerEvent(sessionClosed = sessionClosed)

        /**
         * Returned when optional source-language transcript text is available. This event is
         * emitted only when `audio.input.transcription` is configured.
         *
         * Transcript deltas are append-only text fragments. Clients should not insert unconditional
         * spaces between deltas.
         */
        @JvmStatic
        fun ofSessionInputTranscriptDelta(
            sessionInputTranscriptDelta: RealtimeTranslationInputTranscriptDeltaEvent
        ) =
            RealtimeTranslationServerEvent(
                sessionInputTranscriptDelta = sessionInputTranscriptDelta
            )

        /**
         * Returned when translated transcript text is available.
         *
         * Transcript deltas are append-only text fragments. Clients should not insert unconditional
         * spaces between deltas.
         */
        @JvmStatic
        fun ofSessionOutputTranscriptDelta(
            sessionOutputTranscriptDelta: RealtimeTranslationOutputTranscriptDeltaEvent
        ) =
            RealtimeTranslationServerEvent(
                sessionOutputTranscriptDelta = sessionOutputTranscriptDelta
            )

        /**
         * Returned when translated output audio is available. Output audio deltas are 200 ms frames
         * of PCM16 audio.
         */
        @JvmStatic
        fun ofSessionOutputAudioDelta(
            sessionOutputAudioDelta: RealtimeTranslationOutputAudioDeltaEvent
        ) = RealtimeTranslationServerEvent(sessionOutputAudioDelta = sessionOutputAudioDelta)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeTranslationServerEvent] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /**
         * Returned when an error occurs, which could be a client problem or a server problem. Most
         * errors are recoverable and the session will stay open, we recommend to implementors to
         * monitor and log error messages by default.
         */
        fun visitError(error: RealtimeErrorEvent): T

        /**
         * Returned when a translation session is created. Emitted automatically when a new
         * connection is established as the first server event. This event contains the default
         * translation session configuration.
         */
        fun visitSessionCreated(sessionCreated: RealtimeTranslationSessionCreatedEvent): T

        /**
         * Returned when a translation session is updated with a `session.update` event, unless
         * there is an error.
         */
        fun visitSessionUpdated(sessionUpdated: RealtimeTranslationSessionUpdatedEvent): T

        /** Returned when a realtime translation session is closed. */
        fun visitSessionClosed(sessionClosed: RealtimeTranslationSessionClosedEvent): T

        /**
         * Returned when optional source-language transcript text is available. This event is
         * emitted only when `audio.input.transcription` is configured.
         *
         * Transcript deltas are append-only text fragments. Clients should not insert unconditional
         * spaces between deltas.
         */
        fun visitSessionInputTranscriptDelta(
            sessionInputTranscriptDelta: RealtimeTranslationInputTranscriptDeltaEvent
        ): T

        /**
         * Returned when translated transcript text is available.
         *
         * Transcript deltas are append-only text fragments. Clients should not insert unconditional
         * spaces between deltas.
         */
        fun visitSessionOutputTranscriptDelta(
            sessionOutputTranscriptDelta: RealtimeTranslationOutputTranscriptDeltaEvent
        ): T

        /**
         * Returned when translated output audio is available. Output audio deltas are 200 ms frames
         * of PCM16 audio.
         */
        fun visitSessionOutputAudioDelta(
            sessionOutputAudioDelta: RealtimeTranslationOutputAudioDeltaEvent
        ): T

        /**
         * Maps an unknown variant of [RealtimeTranslationServerEvent] to a value of type [T].
         *
         * An instance of [RealtimeTranslationServerEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeTranslationServerEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<RealtimeTranslationServerEvent>(RealtimeTranslationServerEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeTranslationServerEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<RealtimeErrorEvent>())?.let {
                        RealtimeTranslationServerEvent(error = it, _json = json)
                    } ?: RealtimeTranslationServerEvent(_json = json)
                }
                "session.created" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationSessionCreatedEvent>(),
                        )
                        ?.let { RealtimeTranslationServerEvent(sessionCreated = it, _json = json) }
                        ?: RealtimeTranslationServerEvent(_json = json)
                }
                "session.updated" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationSessionUpdatedEvent>(),
                        )
                        ?.let { RealtimeTranslationServerEvent(sessionUpdated = it, _json = json) }
                        ?: RealtimeTranslationServerEvent(_json = json)
                }
                "session.closed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationSessionClosedEvent>(),
                        )
                        ?.let { RealtimeTranslationServerEvent(sessionClosed = it, _json = json) }
                        ?: RealtimeTranslationServerEvent(_json = json)
                }
                "session.input_transcript.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationInputTranscriptDeltaEvent>(),
                        )
                        ?.let {
                            RealtimeTranslationServerEvent(
                                sessionInputTranscriptDelta = it,
                                _json = json,
                            )
                        } ?: RealtimeTranslationServerEvent(_json = json)
                }
                "session.output_transcript.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationOutputTranscriptDeltaEvent>(),
                        )
                        ?.let {
                            RealtimeTranslationServerEvent(
                                sessionOutputTranscriptDelta = it,
                                _json = json,
                            )
                        } ?: RealtimeTranslationServerEvent(_json = json)
                }
                "session.output_audio.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeTranslationOutputAudioDeltaEvent>(),
                        )
                        ?.let {
                            RealtimeTranslationServerEvent(
                                sessionOutputAudioDelta = it,
                                _json = json,
                            )
                        } ?: RealtimeTranslationServerEvent(_json = json)
                }
            }

            return RealtimeTranslationServerEvent(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<RealtimeTranslationServerEvent>(RealtimeTranslationServerEvent::class) {

        override fun serialize(
            value: RealtimeTranslationServerEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.error != null -> generator.writeObject(value.error)
                value.sessionCreated != null -> generator.writeObject(value.sessionCreated)
                value.sessionUpdated != null -> generator.writeObject(value.sessionUpdated)
                value.sessionClosed != null -> generator.writeObject(value.sessionClosed)
                value.sessionInputTranscriptDelta != null ->
                    generator.writeObject(value.sessionInputTranscriptDelta)
                value.sessionOutputTranscriptDelta != null ->
                    generator.writeObject(value.sessionOutputTranscriptDelta)
                value.sessionOutputAudioDelta != null ->
                    generator.writeObject(value.sessionOutputAudioDelta)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeTranslationServerEvent")
            }
        }
    }
}
