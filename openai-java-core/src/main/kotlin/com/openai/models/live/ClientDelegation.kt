// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Delegate tasks to your application. The Live session emits delegation events that your backend
 * handles.
 */
class ClientDelegation
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val acknowledgementDelayMs: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("acknowledgement_delay_ms")
        @ExcludeMissing
        acknowledgementDelayMs: JsonField<Long> = JsonMissing.of(),
    ) : this(type, acknowledgementDelayMs, mutableMapOf())

    /**
     * The delegation owner. Always `client` for tasks handled by your application.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("client")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Milliseconds to wait before requesting an automatic spoken acknowledgement for a delegation.
     * The model may still speak before this delay. Any commentary or thinking appended to the
     * session cancels all pending acknowledgements, including those for other delegations. Defaults
     * to 400 for Decisions sessions and 0 (request immediately) for other sessions. Omission in a
     * session update preserves the current value. Updates apply to subsequent delegations.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun acknowledgementDelayMs(): Optional<Long> =
        acknowledgementDelayMs.getOptional("acknowledgement_delay_ms")

    /**
     * Returns the raw JSON value of [acknowledgementDelayMs].
     *
     * Unlike [acknowledgementDelayMs], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("acknowledgement_delay_ms")
    @ExcludeMissing
    fun _acknowledgementDelayMs(): JsonField<Long> = acknowledgementDelayMs

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "type" to this.type,
            "acknowledgement_delay_ms" to this.acknowledgementDelayMs,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [ClientDelegation]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ClientDelegation]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("client")
        private var acknowledgementDelayMs: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(clientDelegation: ClientDelegation) = apply {
            type = clientDelegation.type
            acknowledgementDelayMs = clientDelegation.acknowledgementDelayMs
            additionalProperties = clientDelegation.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("client")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Milliseconds to wait before requesting an automatic spoken acknowledgement for a
         * delegation. The model may still speak before this delay. Any commentary or thinking
         * appended to the session cancels all pending acknowledgements, including those for other
         * delegations. Defaults to 400 for Decisions sessions and 0 (request immediately) for other
         * sessions. Omission in a session update preserves the current value. Updates apply to
         * subsequent delegations.
         */
        fun acknowledgementDelayMs(acknowledgementDelayMs: Long) =
            acknowledgementDelayMs(JsonField.of(acknowledgementDelayMs))

        /**
         * Sets [Builder.acknowledgementDelayMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.acknowledgementDelayMs] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun acknowledgementDelayMs(acknowledgementDelayMs: JsonField<Long>) = apply {
            this.acknowledgementDelayMs = acknowledgementDelayMs
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
         * Returns an immutable instance of [ClientDelegation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ClientDelegation =
            ClientDelegation(type, acknowledgementDelayMs, additionalProperties.toMutableMap())
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
    fun validate(): ClientDelegation = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("client")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        acknowledgementDelayMs()
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
        type.let { if (it == JsonValue.from("client")) 1 else 0 } +
            (if (acknowledgementDelayMs.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ClientDelegation &&
            type == other.type &&
            acknowledgementDelayMs == other.acknowledgementDelayMs &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, acknowledgementDelayMs, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ClientDelegation{type=$type, acknowledgementDelayMs=$acknowledgementDelayMs, additionalProperties=$additionalProperties}"
}
