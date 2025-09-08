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
class RealtimeAudioConfig
private constructor(
    private val input: JsonField<RealtimeAudioConfigInput>,
    private val output: JsonField<RealtimeAudioConfigOutput>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input")
        @ExcludeMissing
        input: JsonField<RealtimeAudioConfigInput> = JsonMissing.of(),
        @JsonProperty("output")
        @ExcludeMissing
        output: JsonField<RealtimeAudioConfigOutput> = JsonMissing.of(),
    ) : this(input, output, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun input(): Optional<RealtimeAudioConfigInput> = input.getOptional("input")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun output(): Optional<RealtimeAudioConfigOutput> = output.getOptional("output")

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<RealtimeAudioConfigInput> = input

    /**
     * Returns the raw JSON value of [output].
     *
     * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output")
    @ExcludeMissing
    fun _output(): JsonField<RealtimeAudioConfigOutput> = output

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

        /** Returns a mutable builder for constructing an instance of [RealtimeAudioConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeAudioConfig]. */
    class Builder internal constructor() {

        private var input: JsonField<RealtimeAudioConfigInput> = JsonMissing.of()
        private var output: JsonField<RealtimeAudioConfigOutput> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeAudioConfig: RealtimeAudioConfig) = apply {
            input = realtimeAudioConfig.input
            output = realtimeAudioConfig.output
            additionalProperties = realtimeAudioConfig.additionalProperties.toMutableMap()
        }

        fun input(input: RealtimeAudioConfigInput) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [RealtimeAudioConfigInput]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun input(input: JsonField<RealtimeAudioConfigInput>) = apply { this.input = input }

        fun output(output: RealtimeAudioConfigOutput) = output(JsonField.of(output))

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed [RealtimeAudioConfigOutput]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun output(output: JsonField<RealtimeAudioConfigOutput>) = apply { this.output = output }

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
         * Returns an immutable instance of [RealtimeAudioConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeAudioConfig =
            RealtimeAudioConfig(input, output, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): RealtimeAudioConfig = apply {
        if (validated) {
            return@apply
        }

        input().ifPresent { it.validate() }
        output().ifPresent { it.validate() }
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
        (input.asKnown().getOrNull()?.validity() ?: 0) +
            (output.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeAudioConfig &&
            input == other.input &&
            output == other.output &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(input, output, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeAudioConfig{input=$input, output=$output, additionalProperties=$additionalProperties}"
}
