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
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Configuration for input and output audio. */
class RealtimeTranscriptionSessionAudio
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val input: JsonField<RealtimeTranscriptionSessionAudioInput>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input")
        @ExcludeMissing
        input: JsonField<RealtimeTranscriptionSessionAudioInput> = JsonMissing.of()
    ) : this(input, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun input(): Optional<RealtimeTranscriptionSessionAudioInput> = input.getOptional("input")

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input")
    @ExcludeMissing
    fun _input(): JsonField<RealtimeTranscriptionSessionAudioInput> = input

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
         * [RealtimeTranscriptionSessionAudio].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTranscriptionSessionAudio]. */
    class Builder internal constructor() {

        private var input: JsonField<RealtimeTranscriptionSessionAudioInput> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeTranscriptionSessionAudio: RealtimeTranscriptionSessionAudio) =
            apply {
                input = realtimeTranscriptionSessionAudio.input
                additionalProperties =
                    realtimeTranscriptionSessionAudio.additionalProperties.toMutableMap()
            }

        fun input(input: RealtimeTranscriptionSessionAudioInput) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed
         * [RealtimeTranscriptionSessionAudioInput] value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<RealtimeTranscriptionSessionAudioInput>) = apply {
            this.input = input
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
         * Returns an immutable instance of [RealtimeTranscriptionSessionAudio].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeTranscriptionSessionAudio =
            RealtimeTranscriptionSessionAudio(input, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): RealtimeTranscriptionSessionAudio = apply {
        if (validated) {
            return@apply
        }

        input().ifPresent { it.validate() }
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
    @JvmSynthetic internal fun validity(): Int = (input.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranscriptionSessionAudio &&
            input == other.input &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(input, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeTranscriptionSessionAudio{input=$input, additionalProperties=$additionalProperties}"
}
