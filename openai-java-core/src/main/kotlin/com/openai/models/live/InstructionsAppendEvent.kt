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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Append instructions to the Live conversation while it is running, optionally associating them
 * with an existing client delegation.
 */
class InstructionsAppendEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val content: JsonField<String>,
    private val delegationId: JsonField<String>,
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("content") @ExcludeMissing content: JsonField<String> = JsonMissing.of(),
        @JsonProperty("delegation_id")
        @ExcludeMissing
        delegationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
    ) : this(content, delegationId, type, eventId, mutableMapOf())

    /**
     * Instruction text to append, limited to 500 tokens. This is a plain string, not an array of
     * content parts.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun content(): String = content.getRequired("content")

    /**
     * Required, nullable. Set null for general session context, or use the ID from
     * session.delegation.created for an existing client delegation. Non-null IDs are not accepted
     * with Responses delegation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun delegationId(): Optional<String> = delegationId.getOptional("delegation_id")

    /**
     * The Live client event type. Always `session.instructions.append`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("session.instructions.append")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional client identifier for correlating this command with a server event's client_event_id
     * or error.client_event_id.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventId(): Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the raw JSON value of [content].
     *
     * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

    /**
     * Returns the raw JSON value of [delegationId].
     *
     * Unlike [delegationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delegation_id")
    @ExcludeMissing
    fun _delegationId(): JsonField<String> = delegationId

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
         * Returns a mutable builder for constructing an instance of [InstructionsAppendEvent].
         *
         * The following fields are required:
         * ```java
         * .content()
         * .delegationId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InstructionsAppendEvent]. */
    class Builder internal constructor() {

        private var content: JsonField<String>? = null
        private var delegationId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("session.instructions.append")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(instructionsAppendEvent: InstructionsAppendEvent) = apply {
            content = instructionsAppendEvent.content
            delegationId = instructionsAppendEvent.delegationId
            type = instructionsAppendEvent.type
            eventId = instructionsAppendEvent.eventId
            additionalProperties = instructionsAppendEvent.additionalProperties.toMutableMap()
        }

        /**
         * Instruction text to append, limited to 500 tokens. This is a plain string, not an array
         * of content parts.
         */
        fun content(content: String) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun content(content: JsonField<String>) = apply { this.content = content }

        /**
         * Required, nullable. Set null for general session context, or use the ID from
         * session.delegation.created for an existing client delegation. Non-null IDs are not
         * accepted with Responses delegation.
         */
        fun delegationId(delegationId: String?) = delegationId(JsonField.ofNullable(delegationId))

        /** Alias for calling [Builder.delegationId] with `delegationId.orElse(null)`. */
        fun delegationId(delegationId: Optional<String>) = delegationId(delegationId.getOrNull())

        /**
         * Sets [Builder.delegationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delegationId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun delegationId(delegationId: JsonField<String>) = apply {
            this.delegationId = delegationId
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("session.instructions.append")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Optional client identifier for correlating this command with a server event's
         * client_event_id or error.client_event_id.
         */
        fun eventId(eventId: String?) = eventId(JsonField.ofNullable(eventId))

        /** Alias for calling [Builder.eventId] with `eventId.orElse(null)`. */
        fun eventId(eventId: Optional<String>) = eventId(eventId.getOrNull())

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

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
         * Returns an immutable instance of [InstructionsAppendEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .content()
         * .delegationId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InstructionsAppendEvent =
            InstructionsAppendEvent(
                checkRequired("content", content),
                checkRequired("delegationId", delegationId),
                type,
                eventId,
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
    fun validate(): InstructionsAppendEvent = apply {
        if (validated) {
            return@apply
        }

        content()
        delegationId()
        _type().let {
            if (it != JsonValue.from("session.instructions.append")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        eventId()
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
        (if (content.asKnown().isPresent) 1 else 0) +
            (if (delegationId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("session.instructions.append")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InstructionsAppendEvent &&
            content == other.content &&
            delegationId == other.delegationId &&
            type == other.type &&
            eventId == other.eventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(content, delegationId, type, eventId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InstructionsAppendEvent{content=$content, delegationId=$delegationId, type=$type, eventId=$eventId, additionalProperties=$additionalProperties}"
}
