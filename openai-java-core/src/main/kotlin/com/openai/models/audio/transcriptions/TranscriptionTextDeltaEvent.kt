// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Emitted when there is an additional text delta. This is also the first event emitted when the
 * transcription starts. Only emitted when you
 * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
 * with the `Stream` parameter set to `true`.
 */
class TranscriptionTextDeltaEvent
private constructor(
    private val delta: JsonField<String>,
    private val type: JsonValue,
    private val logprobs: JsonField<List<Logprob>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("logprobs")
        @ExcludeMissing
        logprobs: JsonField<List<Logprob>> = JsonMissing.of(),
    ) : this(delta, type, logprobs, mutableMapOf())

    /**
     * The text delta that was additionally transcribed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delta(): String = delta.getRequired("delta")

    /**
     * The type of the event. Always `transcript.text.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("transcript.text.delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The log probabilities of the delta. Only included if you
     * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
     * with the `include[]` parameter set to `logprobs`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logprobs(): Optional<List<Logprob>> = Optional.ofNullable(logprobs.getNullable("logprobs"))

    /**
     * Returns the raw JSON value of [delta].
     *
     * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    /**
     * Returns the raw JSON value of [logprobs].
     *
     * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<List<Logprob>> = logprobs

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
         * Returns a mutable builder for constructing an instance of [TranscriptionTextDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .delta()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionTextDeltaEvent]. */
    class Builder internal constructor() {

        private var delta: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("transcript.text.delta")
        private var logprobs: JsonField<MutableList<Logprob>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionTextDeltaEvent: TranscriptionTextDeltaEvent) = apply {
            delta = transcriptionTextDeltaEvent.delta
            type = transcriptionTextDeltaEvent.type
            logprobs = transcriptionTextDeltaEvent.logprobs.map { it.toMutableList() }
            additionalProperties = transcriptionTextDeltaEvent.additionalProperties.toMutableMap()
        }

        /** The text delta that was additionally transcribed. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("transcript.text.delta")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The log probabilities of the delta. Only included if you
         * [create a transcription](https://platform.openai.com/docs/api-reference/audio/create-transcription)
         * with the `include[]` parameter set to `logprobs`.
         */
        fun logprobs(logprobs: List<Logprob>) = logprobs(JsonField.of(logprobs))

        /**
         * Sets [Builder.logprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprobs] with a well-typed `List<Logprob>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun logprobs(logprobs: JsonField<List<Logprob>>) = apply {
            this.logprobs = logprobs.map { it.toMutableList() }
        }

        /**
         * Adds a single [Logprob] to [logprobs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLogprob(logprob: Logprob) = apply {
            logprobs =
                (logprobs ?: JsonField.of(mutableListOf())).also {
                    checkKnown("logprobs", it).add(logprob)
                }
        }

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
         * Returns an immutable instance of [TranscriptionTextDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .delta()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TranscriptionTextDeltaEvent =
            TranscriptionTextDeltaEvent(
                checkRequired("delta", delta),
                type,
                (logprobs ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TranscriptionTextDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        delta()
        _type().let {
            if (it != JsonValue.from("transcript.text.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        logprobs().ifPresent { it.forEach { it.validate() } }
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
            type.let { if (it == JsonValue.from("transcript.text.delta")) 1 else 0 } +
            (logprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Logprob
    private constructor(
        private val token: JsonField<String>,
        private val bytes: JsonField<List<JsonValue>>,
        private val logprob: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bytes")
            @ExcludeMissing
            bytes: JsonField<List<JsonValue>> = JsonMissing.of(),
            @JsonProperty("logprob") @ExcludeMissing logprob: JsonField<Double> = JsonMissing.of(),
        ) : this(token, bytes, logprob, mutableMapOf())

        /**
         * The token that was used to generate the log probability.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun token(): Optional<String> = Optional.ofNullable(token.getNullable("token"))

        /**
         * The bytes that were used to generate the log probability.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bytes(): Optional<List<JsonValue>> = Optional.ofNullable(bytes.getNullable("bytes"))

        /**
         * The log probability of the token.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun logprob(): Optional<Double> = Optional.ofNullable(logprob.getNullable("logprob"))

        /**
         * Returns the raw JSON value of [token].
         *
         * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

        /**
         * Returns the raw JSON value of [bytes].
         *
         * Unlike [bytes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bytes") @ExcludeMissing fun _bytes(): JsonField<List<JsonValue>> = bytes

        /**
         * Returns the raw JSON value of [logprob].
         *
         * Unlike [logprob], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logprob") @ExcludeMissing fun _logprob(): JsonField<Double> = logprob

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

            /** Returns a mutable builder for constructing an instance of [Logprob]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Logprob]. */
        class Builder internal constructor() {

            private var token: JsonField<String> = JsonMissing.of()
            private var bytes: JsonField<MutableList<JsonValue>>? = null
            private var logprob: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logprob: Logprob) = apply {
                token = logprob.token
                bytes = logprob.bytes.map { it.toMutableList() }
                this.logprob = logprob.logprob
                additionalProperties = logprob.additionalProperties.toMutableMap()
            }

            /** The token that was used to generate the log probability. */
            fun token(token: String) = token(JsonField.of(token))

            /**
             * Sets [Builder.token] to an arbitrary JSON value.
             *
             * You should usually call [Builder.token] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun token(token: JsonField<String>) = apply { this.token = token }

            /** The bytes that were used to generate the log probability. */
            fun bytes(bytes: List<JsonValue>) = bytes(JsonField.of(bytes))

            /**
             * Sets [Builder.bytes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bytes] with a well-typed `List<JsonValue>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bytes(bytes: JsonField<List<JsonValue>>) = apply {
                this.bytes = bytes.map { it.toMutableList() }
            }

            /**
             * Adds a single [JsonValue] to [bytes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByte(byte_: JsonValue) = apply {
                bytes =
                    (bytes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("bytes", it).add(byte_)
                    }
            }

            /** The log probability of the token. */
            fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

            /**
             * Sets [Builder.logprob] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logprob] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

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
             * Returns an immutable instance of [Logprob].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Logprob =
                Logprob(
                    token,
                    (bytes ?: JsonMissing.of()).map { it.toImmutable() },
                    logprob,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Logprob = apply {
            if (validated) {
                return@apply
            }

            token()
            bytes()
            logprob()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (token.asKnown().isPresent) 1 else 0) +
                (bytes.asKnown().getOrNull()?.size ?: 0) +
                (if (logprob.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Logprob && token == other.token && bytes == other.bytes && logprob == other.logprob && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(token, bytes, logprob, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Logprob{token=$token, bytes=$bytes, logprob=$logprob, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranscriptionTextDeltaEvent && delta == other.delta && type == other.type && logprobs == other.logprobs && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(delta, type, logprobs, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionTextDeltaEvent{delta=$delta, type=$type, logprobs=$logprobs, additionalProperties=$additionalProperties}"
}
