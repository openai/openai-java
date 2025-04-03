// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

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
import kotlin.jvm.optionals.getOrNull

class FineTuningJobWandbIntegrationObject
private constructor(
    private val type: JsonValue,
    private val wandb: JsonField<FineTuningJobWandbIntegration>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("wandb")
        @ExcludeMissing
        wandb: JsonField<FineTuningJobWandbIntegration> = JsonMissing.of(),
    ) : this(type, wandb, mutableMapOf())

    /**
     * The type of the integration being enabled for the fine-tuning job
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("wandb")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The settings for your integration with Weights and Biases. This payload specifies the project
     * that metrics will be sent to. Optionally, you can set an explicit display name for your run,
     * add tags to your run, and set a default entity (team, username, etc) to be associated with
     * your run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun wandb(): FineTuningJobWandbIntegration = wandb.getRequired("wandb")

    /**
     * Returns the raw JSON value of [wandb].
     *
     * Unlike [wandb], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("wandb")
    @ExcludeMissing
    fun _wandb(): JsonField<FineTuningJobWandbIntegration> = wandb

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
         * [FineTuningJobWandbIntegrationObject].
         *
         * The following fields are required:
         * ```java
         * .wandb()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FineTuningJobWandbIntegrationObject]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("wandb")
        private var wandb: JsonField<FineTuningJobWandbIntegration>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            fineTuningJobWandbIntegrationObject: FineTuningJobWandbIntegrationObject
        ) = apply {
            type = fineTuningJobWandbIntegrationObject.type
            wandb = fineTuningJobWandbIntegrationObject.wandb
            additionalProperties =
                fineTuningJobWandbIntegrationObject.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("wandb")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        fun wandb(wandb: FineTuningJobWandbIntegration) = wandb(JsonField.of(wandb))

        /**
         * Sets [Builder.wandb] to an arbitrary JSON value.
         *
         * You should usually call [Builder.wandb] with a well-typed [FineTuningJobWandbIntegration]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun wandb(wandb: JsonField<FineTuningJobWandbIntegration>) = apply { this.wandb = wandb }

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
         * Returns an immutable instance of [FineTuningJobWandbIntegrationObject].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .wandb()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FineTuningJobWandbIntegrationObject =
            FineTuningJobWandbIntegrationObject(
                type,
                checkRequired("wandb", wandb),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FineTuningJobWandbIntegrationObject = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("wandb")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        wandb().validate()
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
        type.let { if (it == JsonValue.from("wandb")) 1 else 0 } +
            (wandb.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJobWandbIntegrationObject && type == other.type && wandb == other.wandb && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, wandb, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJobWandbIntegrationObject{type=$type, wandb=$wandb, additionalProperties=$additionalProperties}"
}
