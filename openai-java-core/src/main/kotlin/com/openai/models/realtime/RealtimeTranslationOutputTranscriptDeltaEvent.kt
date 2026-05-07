// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returned when translated transcript text is available.
 *
 * Transcript deltas are append-only text fragments. Clients should not insert unconditional spaces
 * between deltas.
 */
class RealtimeTranslationOutputTranscriptDeltaEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val delta: JsonField<String>,
    private val eventId: JsonField<String>,
    private val type: JsonValue,
    private val elapsedMs: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("elapsed_ms") @ExcludeMissing elapsedMs: JsonField<Long> = JsonMissing.of(),
    ) : this(delta, eventId, type, elapsedMs, mutableMapOf())

    /**
     * Append-only transcript text for the translated output audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delta(): String = delta.getRequired("delta")

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The event type, must be `session.output_transcript.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("session.output_transcript.delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Timing metadata for stream alignment, derived from the translation frame when available. It
     * advances in 200 ms increments, but multiple transcript deltas may share the same
     * `elapsed_ms`. Treat it as alignment metadata, not a unique transcript-delta identifier.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun elapsedMs(): Optional<Long> = elapsedMs.getOptional("elapsed_ms")

    /**
     * Returns the raw JSON value of [delta].
     *
     * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [elapsedMs].
     *
     * Unlike [elapsedMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("elapsed_ms") @ExcludeMissing fun _elapsedMs(): JsonField<Long> = elapsedMs

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [RealtimeTranslationOutputTranscriptDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .eventId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTranslationOutputTranscriptDeltaEvent]. */
    class Builder internal constructor() {

        private var delta: JsonField<String>? = null
        private var eventId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("session.output_transcript.delta")
        private var elapsedMs: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeTranslationOutputTranscriptDeltaEvent:
                RealtimeTranslationOutputTranscriptDeltaEvent
        ) = apply {
            delta = realtimeTranslationOutputTranscriptDeltaEvent.delta
            eventId = realtimeTranslationOutputTranscriptDeltaEvent.eventId
            type = realtimeTranslationOutputTranscriptDeltaEvent.type
            elapsedMs = realtimeTranslationOutputTranscriptDeltaEvent.elapsedMs
            additionalProperties =
                realtimeTranslationOutputTranscriptDeltaEvent.additionalProperties.toMutableMap()
        }

        /** Append-only transcript text for the translated output audio. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("session.output_transcript.delta")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Timing metadata for stream alignment, derived from the translation frame when available.
         * It advances in 200 ms increments, but multiple transcript deltas may share the same
         * `elapsed_ms`. Treat it as alignment metadata, not a unique transcript-delta identifier.
         */
        fun elapsedMs(elapsedMs: Long?) = elapsedMs(JsonField.ofNullable(elapsedMs))

        /**
         * Alias for [Builder.elapsedMs].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun elapsedMs(elapsedMs: Long) = elapsedMs(elapsedMs as Long?)

        /** Alias for calling [Builder.elapsedMs] with `elapsedMs.orElse(null)`. */
        fun elapsedMs(elapsedMs: Optional<Long>) = elapsedMs(elapsedMs.getOrNull())

        /**
         * Sets [Builder.elapsedMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.elapsedMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun elapsedMs(elapsedMs: JsonField<Long>) = apply { this.elapsedMs = elapsedMs }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [RealtimeTranslationOutputTranscriptDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .eventId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeTranslationOutputTranscriptDeltaEvent =
            RealtimeTranslationOutputTranscriptDeltaEvent(
                checkRequired("delta", delta),
                checkRequired("eventId", eventId),
                type,
                elapsedMs,
                additionalProperties.toMutableMap(),
            )
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
    fun validate(): RealtimeTranslationOutputTranscriptDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        delta()
        eventId()
        _type().let {
            if (it != JsonValue.from("session.output_transcript.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        elapsedMs()
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
        (if (delta.asKnown().isPresent) 1 else 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("session.output_transcript.delta")) 1 else 0 } +
            (if (elapsedMs.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranslationOutputTranscriptDeltaEvent &&
            delta == other.delta &&
            eventId == other.eventId &&
            type == other.type &&
            elapsedMs == other.elapsedMs &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(delta, eventId, type, elapsedMs, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeTranslationOutputTranscriptDeltaEvent{delta=$delta, eventId=$eventId, type=$type, elapsedMs=$elapsedMs, additionalProperties=$additionalProperties}"
}
