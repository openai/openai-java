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
 * Reports cumulative Live audio usage and, when available, the most recent context-window usage.
 * Delegated Responses token usage is reported separately in response.event events.
 */
class SessionUsageUpdatedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val eventId: JsonField<String>,
    private val type: JsonValue,
    private val usage: JsonField<SessionUsage>,
    private val clientEventId: JsonField<String>,
    private val contextWindow: JsonField<ContextWindow>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<SessionUsage> = JsonMissing.of(),
        @JsonProperty("client_event_id")
        @ExcludeMissing
        clientEventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("context_window")
        @ExcludeMissing
        contextWindow: JsonField<ContextWindow> = JsonMissing.of(),
    ) : this(eventId, type, usage, clientEventId, contextWindow, mutableMapOf())

    /**
     * The unique ID of the Live server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The event type, always `session.usage.updated`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("session.usage.updated")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The cumulative Live audio usage so far.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usage(): SessionUsage = usage.getRequired("usage")

    /**
     * The event_id of the client command associated with this server event, when supplied.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientEventId(): Optional<String> = clientEventId.getOptional("client_event_id")

    /**
     * The latest measured Live context-window usage. Omitted when the context limit is unknown.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contextWindow(): Optional<ContextWindow> = contextWindow.getOptional("context_window")

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<SessionUsage> = usage

    /**
     * Returns the raw JSON value of [clientEventId].
     *
     * Unlike [clientEventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client_event_id")
    @ExcludeMissing
    fun _clientEventId(): JsonField<String> = clientEventId

    /**
     * Returns the raw JSON value of [contextWindow].
     *
     * Unlike [contextWindow], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("context_window")
    @ExcludeMissing
    fun _contextWindow(): JsonField<ContextWindow> = contextWindow

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
         * Returns a mutable builder for constructing an instance of [SessionUsageUpdatedEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionUsageUpdatedEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("session.usage.updated")
        private var usage: JsonField<SessionUsage>? = null
        private var clientEventId: JsonField<String> = JsonMissing.of()
        private var contextWindow: JsonField<ContextWindow> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sessionUsageUpdatedEvent: SessionUsageUpdatedEvent) = apply {
            eventId = sessionUsageUpdatedEvent.eventId
            type = sessionUsageUpdatedEvent.type
            usage = sessionUsageUpdatedEvent.usage
            clientEventId = sessionUsageUpdatedEvent.clientEventId
            contextWindow = sessionUsageUpdatedEvent.contextWindow
            additionalProperties = sessionUsageUpdatedEvent.additionalProperties.toMutableMap()
        }

        /** The unique ID of the Live server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("session.usage.updated")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The cumulative Live audio usage so far. */
        fun usage(usage: SessionUsage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [SessionUsage] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun usage(usage: JsonField<SessionUsage>) = apply { this.usage = usage }

        /** The event_id of the client command associated with this server event, when supplied. */
        fun clientEventId(clientEventId: String) = clientEventId(JsonField.of(clientEventId))

        /**
         * Sets [Builder.clientEventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientEventId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clientEventId(clientEventId: JsonField<String>) = apply {
            this.clientEventId = clientEventId
        }

        /**
         * The latest measured Live context-window usage. Omitted when the context limit is unknown.
         */
        fun contextWindow(contextWindow: ContextWindow) = contextWindow(JsonField.of(contextWindow))

        /**
         * Sets [Builder.contextWindow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contextWindow] with a well-typed [ContextWindow] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun contextWindow(contextWindow: JsonField<ContextWindow>) = apply {
            this.contextWindow = contextWindow
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
         * Returns an immutable instance of [SessionUsageUpdatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SessionUsageUpdatedEvent =
            SessionUsageUpdatedEvent(
                checkRequired("eventId", eventId),
                type,
                checkRequired("usage", usage),
                clientEventId,
                contextWindow,
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
    fun validate(): SessionUsageUpdatedEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        _type().let {
            if (it != JsonValue.from("session.usage.updated")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        usage().validate()
        clientEventId()
        contextWindow().ifPresent { it.validate() }
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
        (if (eventId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("session.usage.updated")) 1 else 0 } +
            (usage.asKnown().getOrNull()?.validity() ?: 0) +
            (if (clientEventId.asKnown().isPresent) 1 else 0) +
            (contextWindow.asKnown().getOrNull()?.validity() ?: 0)

    /** The latest measured Live context-window usage. Omitted when the context limit is unknown. */
    class ContextWindow
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val usageRatio: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("usage_ratio")
            @ExcludeMissing
            usageRatio: JsonField<Double> = JsonMissing.of()
        ) : this(usageRatio, mutableMapOf())

        /**
         * The latest active context token count divided by the Live model context limit. Can
         * decrease after compaction and may lag between measured audio frames.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun usageRatio(): Double = usageRatio.getRequired("usage_ratio")

        /**
         * Returns the raw JSON value of [usageRatio].
         *
         * Unlike [usageRatio], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("usage_ratio")
        @ExcludeMissing
        fun _usageRatio(): JsonField<Double> = usageRatio

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
             * Returns a mutable builder for constructing an instance of [ContextWindow].
             *
             * The following fields are required:
             * ```java
             * .usageRatio()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ContextWindow]. */
        class Builder internal constructor() {

            private var usageRatio: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(contextWindow: ContextWindow) = apply {
                usageRatio = contextWindow.usageRatio
                additionalProperties = contextWindow.additionalProperties.toMutableMap()
            }

            /**
             * The latest active context token count divided by the Live model context limit. Can
             * decrease after compaction and may lag between measured audio frames.
             */
            fun usageRatio(usageRatio: Double) = usageRatio(JsonField.of(usageRatio))

            /**
             * Sets [Builder.usageRatio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.usageRatio] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun usageRatio(usageRatio: JsonField<Double>) = apply { this.usageRatio = usageRatio }

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
             * Returns an immutable instance of [ContextWindow].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .usageRatio()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ContextWindow =
                ContextWindow(
                    checkRequired("usageRatio", usageRatio),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): ContextWindow = apply {
            if (validated) {
                return@apply
            }

            usageRatio()
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
        @JvmSynthetic internal fun validity(): Int = (if (usageRatio.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ContextWindow &&
                usageRatio == other.usageRatio &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(usageRatio, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ContextWindow{usageRatio=$usageRatio, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionUsageUpdatedEvent &&
            eventId == other.eventId &&
            type == other.type &&
            usage == other.usage &&
            clientEventId == other.clientEventId &&
            contextWindow == other.contextWindow &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(eventId, type, usage, clientEventId, contextWindow, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SessionUsageUpdatedEvent{eventId=$eventId, type=$type, usage=$usage, clientEventId=$clientEventId, contextWindow=$contextWindow, additionalProperties=$additionalProperties}"
}
