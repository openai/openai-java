// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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

class ContainerReference
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val containerId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("container_id")
        @ExcludeMissing
        containerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(containerId, type, mutableMapOf())

    /**
     * The ID of the referenced container.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun containerId(): String = containerId.getRequired("container_id")

    /**
     * References a container created with the /v1/containers endpoint
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("container_reference")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [containerId].
     *
     * Unlike [containerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("container_id")
    @ExcludeMissing
    fun _containerId(): JsonField<String> = containerId

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
         * Returns a mutable builder for constructing an instance of [ContainerReference].
         *
         * The following fields are required:
         * ```java
         * .containerId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContainerReference]. */
    class Builder internal constructor() {

        private var containerId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("container_reference")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(containerReference: ContainerReference) = apply {
            containerId = containerReference.containerId
            type = containerReference.type
            additionalProperties = containerReference.additionalProperties.toMutableMap()
        }

        /** The ID of the referenced container. */
        fun containerId(containerId: String) = containerId(JsonField.of(containerId))

        /**
         * Sets [Builder.containerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.containerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun containerId(containerId: JsonField<String>) = apply { this.containerId = containerId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("container_reference")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [ContainerReference].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .containerId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContainerReference =
            ContainerReference(
                checkRequired("containerId", containerId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContainerReference = apply {
        if (validated) {
            return@apply
        }

        containerId()
        _type().let {
            if (it != JsonValue.from("container_reference")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
        (if (containerId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("container_reference")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContainerReference &&
            containerId == other.containerId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(containerId, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContainerReference{containerId=$containerId, type=$type, additionalProperties=$additionalProperties}"
}
