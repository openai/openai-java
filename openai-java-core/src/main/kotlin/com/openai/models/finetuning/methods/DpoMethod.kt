// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.methods

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

/** Configuration for the DPO fine-tuning method. */
class DpoMethod
private constructor(
    private val hyperparameters: JsonField<DpoHyperparameters>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("hyperparameters")
        @ExcludeMissing
        hyperparameters: JsonField<DpoHyperparameters> = JsonMissing.of()
    ) : this(hyperparameters, mutableMapOf())

    /**
     * The hyperparameters used for the DPO fine-tuning job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hyperparameters(): Optional<DpoHyperparameters> =
        hyperparameters.getOptional("hyperparameters")

    /**
     * Returns the raw JSON value of [hyperparameters].
     *
     * Unlike [hyperparameters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hyperparameters")
    @ExcludeMissing
    fun _hyperparameters(): JsonField<DpoHyperparameters> = hyperparameters

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

        /** Returns a mutable builder for constructing an instance of [DpoMethod]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DpoMethod]. */
    class Builder internal constructor() {

        private var hyperparameters: JsonField<DpoHyperparameters> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(dpoMethod: DpoMethod) = apply {
            hyperparameters = dpoMethod.hyperparameters
            additionalProperties = dpoMethod.additionalProperties.toMutableMap()
        }

        /** The hyperparameters used for the DPO fine-tuning job. */
        fun hyperparameters(hyperparameters: DpoHyperparameters) =
            hyperparameters(JsonField.of(hyperparameters))

        /**
         * Sets [Builder.hyperparameters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hyperparameters] with a well-typed [DpoHyperparameters]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun hyperparameters(hyperparameters: JsonField<DpoHyperparameters>) = apply {
            this.hyperparameters = hyperparameters
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [DpoMethod].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DpoMethod = DpoMethod(hyperparameters, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): DpoMethod = apply {
        if (validated) {
            return@apply
        }

        hyperparameters().ifPresent { it.validate() }
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
    internal fun validity(): Int = (hyperparameters.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DpoMethod &&
            hyperparameters == other.hyperparameters &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(hyperparameters, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DpoMethod{hyperparameters=$hyperparameters, additionalProperties=$additionalProperties}"
}
