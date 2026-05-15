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

/** Configuration for reasoning-capable Realtime models such as `gpt-realtime-2`. */
class RealtimeReasoning
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val effort: JsonField<RealtimeReasoningEffort>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("effort")
        @ExcludeMissing
        effort: JsonField<RealtimeReasoningEffort> = JsonMissing.of()
    ) : this(effort, mutableMapOf())

    /**
     * Constrains effort on reasoning for reasoning-capable Realtime models such as
     * `gpt-realtime-2`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun effort(): Optional<RealtimeReasoningEffort> = effort.getOptional("effort")

    /**
     * Returns the raw JSON value of [effort].
     *
     * Unlike [effort], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("effort")
    @ExcludeMissing
    fun _effort(): JsonField<RealtimeReasoningEffort> = effort

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

        /** Returns a mutable builder for constructing an instance of [RealtimeReasoning]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeReasoning]. */
    class Builder internal constructor() {

        private var effort: JsonField<RealtimeReasoningEffort> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeReasoning: RealtimeReasoning) = apply {
            effort = realtimeReasoning.effort
            additionalProperties = realtimeReasoning.additionalProperties.toMutableMap()
        }

        /**
         * Constrains effort on reasoning for reasoning-capable Realtime models such as
         * `gpt-realtime-2`.
         */
        fun effort(effort: RealtimeReasoningEffort) = effort(JsonField.of(effort))

        /**
         * Sets [Builder.effort] to an arbitrary JSON value.
         *
         * You should usually call [Builder.effort] with a well-typed [RealtimeReasoningEffort]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun effort(effort: JsonField<RealtimeReasoningEffort>) = apply { this.effort = effort }

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
         * Returns an immutable instance of [RealtimeReasoning].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeReasoning =
            RealtimeReasoning(effort, additionalProperties.toMutableMap())
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
    fun validate(): RealtimeReasoning = apply {
        if (validated) {
            return@apply
        }

        effort().ifPresent { it.validate() }
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
    @JvmSynthetic internal fun validity(): Int = (effort.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeReasoning &&
            effort == other.effort &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(effort, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeReasoning{effort=$effort, additionalProperties=$additionalProperties}"
}
