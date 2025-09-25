// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that the
 * model will detect the start and end of speech based on audio volume and respond at the end of
 * user speech.
 */
class RealtimeTranscriptionSessionTurnDetection
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val prefixPaddingMs: JsonField<Long>,
    private val silenceDurationMs: JsonField<Long>,
    private val threshold: JsonField<Double>,
    private val type: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("prefix_padding_ms")
        @ExcludeMissing
        prefixPaddingMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("silence_duration_ms")
        @ExcludeMissing
        silenceDurationMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("threshold") @ExcludeMissing threshold: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
    ) : this(prefixPaddingMs, silenceDurationMs, threshold, type, mutableMapOf())

    /**
     * Amount of audio to include before the VAD detected speech (in milliseconds). Defaults to
     * 300ms.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prefixPaddingMs(): Optional<Long> = prefixPaddingMs.getOptional("prefix_padding_ms")

    /**
     * Duration of silence to detect speech stop (in milliseconds). Defaults to 500ms. With shorter
     * values the model will respond more quickly, but may jump in on short pauses from the user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun silenceDurationMs(): Optional<Long> = silenceDurationMs.getOptional("silence_duration_ms")

    /**
     * Activation threshold for VAD (0.0 to 1.0), this defaults to 0.5. A higher threshold will
     * require louder audio to activate the model, and thus might perform better in noisy
     * environments.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun threshold(): Optional<Double> = threshold.getOptional("threshold")

    /**
     * Type of turn detection, only `server_vad` is currently supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [prefixPaddingMs].
     *
     * Unlike [prefixPaddingMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("prefix_padding_ms")
    @ExcludeMissing
    fun _prefixPaddingMs(): JsonField<Long> = prefixPaddingMs

    /**
     * Returns the raw JSON value of [silenceDurationMs].
     *
     * Unlike [silenceDurationMs], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("silence_duration_ms")
    @ExcludeMissing
    fun _silenceDurationMs(): JsonField<Long> = silenceDurationMs

    /**
     * Returns the raw JSON value of [threshold].
     *
     * Unlike [threshold], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("threshold") @ExcludeMissing fun _threshold(): JsonField<Double> = threshold

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
         * [RealtimeTranscriptionSessionTurnDetection].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTranscriptionSessionTurnDetection]. */
    class Builder internal constructor() {

        private var prefixPaddingMs: JsonField<Long> = JsonMissing.of()
        private var silenceDurationMs: JsonField<Long> = JsonMissing.of()
        private var threshold: JsonField<Double> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeTranscriptionSessionTurnDetection: RealtimeTranscriptionSessionTurnDetection
        ) = apply {
            prefixPaddingMs = realtimeTranscriptionSessionTurnDetection.prefixPaddingMs
            silenceDurationMs = realtimeTranscriptionSessionTurnDetection.silenceDurationMs
            threshold = realtimeTranscriptionSessionTurnDetection.threshold
            type = realtimeTranscriptionSessionTurnDetection.type
            additionalProperties =
                realtimeTranscriptionSessionTurnDetection.additionalProperties.toMutableMap()
        }

        /**
         * Amount of audio to include before the VAD detected speech (in milliseconds). Defaults to
         * 300ms.
         */
        fun prefixPaddingMs(prefixPaddingMs: Long) = prefixPaddingMs(JsonField.of(prefixPaddingMs))

        /**
         * Sets [Builder.prefixPaddingMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prefixPaddingMs] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun prefixPaddingMs(prefixPaddingMs: JsonField<Long>) = apply {
            this.prefixPaddingMs = prefixPaddingMs
        }

        /**
         * Duration of silence to detect speech stop (in milliseconds). Defaults to 500ms. With
         * shorter values the model will respond more quickly, but may jump in on short pauses from
         * the user.
         */
        fun silenceDurationMs(silenceDurationMs: Long) =
            silenceDurationMs(JsonField.of(silenceDurationMs))

        /**
         * Sets [Builder.silenceDurationMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.silenceDurationMs] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun silenceDurationMs(silenceDurationMs: JsonField<Long>) = apply {
            this.silenceDurationMs = silenceDurationMs
        }

        /**
         * Activation threshold for VAD (0.0 to 1.0), this defaults to 0.5. A higher threshold will
         * require louder audio to activate the model, and thus might perform better in noisy
         * environments.
         */
        fun threshold(threshold: Double) = threshold(JsonField.of(threshold))

        /**
         * Sets [Builder.threshold] to an arbitrary JSON value.
         *
         * You should usually call [Builder.threshold] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun threshold(threshold: JsonField<Double>) = apply { this.threshold = threshold }

        /** Type of turn detection, only `server_vad` is currently supported. */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

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
         * Returns an immutable instance of [RealtimeTranscriptionSessionTurnDetection].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeTranscriptionSessionTurnDetection =
            RealtimeTranscriptionSessionTurnDetection(
                prefixPaddingMs,
                silenceDurationMs,
                threshold,
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeTranscriptionSessionTurnDetection = apply {
        if (validated) {
            return@apply
        }

        prefixPaddingMs()
        silenceDurationMs()
        threshold()
        type()
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
        (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
            (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
            (if (threshold.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranscriptionSessionTurnDetection &&
            prefixPaddingMs == other.prefixPaddingMs &&
            silenceDurationMs == other.silenceDurationMs &&
            threshold == other.threshold &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(prefixPaddingMs, silenceDurationMs, threshold, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeTranscriptionSessionTurnDetection{prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, type=$type, additionalProperties=$additionalProperties}"
}
