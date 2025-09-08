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

/**
 * This event instructs the server to create a Response, which means triggering model inference.
 * When in Server VAD mode, the server will create Responses automatically.
 *
 * A Response will include at least one Item, and may have two, in which case the second will be a
 * function call. These Items will be appended to the conversation history by default.
 *
 * The server will respond with a `response.created` event, events for Items and content created,
 * and finally a `response.done` event to indicate the Response is complete.
 *
 * The `response.create` event includes inference configuration like `instructions` and `tools`. If
 * these are set, they will override the Session's configuration for this Response only.
 *
 * Responses can be created out-of-band of the default Conversation, meaning that they can have
 * arbitrary input, and it's possible to disable writing the output to the Conversation. Only one
 * Response can write to the default Conversation at a time, but otherwise multiple Responses can be
 * created in parallel. The `metadata` field is a good way to disambiguate multiple simultaneous
 * Responses.
 *
 * Clients can set `conversation` to `none` to create a Response that does not write to the default
 * Conversation. Arbitrary input can be provided with the `input` field, which is an array accepting
 * raw Items and references to existing Items.
 */
class ResponseCreateEvent
private constructor(
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val response: JsonField<RealtimeResponseCreateParams>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("response")
        @ExcludeMissing
        response: JsonField<RealtimeResponseCreateParams> = JsonMissing.of(),
    ) : this(type, eventId, response, mutableMapOf())

    /**
     * The event type, must be `response.create`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.create")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional client-generated ID used to identify this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventId(): Optional<String> = eventId.getOptional("event_id")

    /**
     * Create a new Realtime response with these parameters
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun response(): Optional<RealtimeResponseCreateParams> = response.getOptional("response")

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [response].
     *
     * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response")
    @ExcludeMissing
    fun _response(): JsonField<RealtimeResponseCreateParams> = response

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

        /** Returns a mutable builder for constructing an instance of [ResponseCreateEvent]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCreateEvent]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("response.create")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var response: JsonField<RealtimeResponseCreateParams> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseCreateEvent: ResponseCreateEvent) = apply {
            type = responseCreateEvent.type
            eventId = responseCreateEvent.eventId
            response = responseCreateEvent.response
            additionalProperties = responseCreateEvent.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.create")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Optional client-generated ID used to identify this event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** Create a new Realtime response with these parameters */
        fun response(response: RealtimeResponseCreateParams) = response(JsonField.of(response))

        /**
         * Sets [Builder.response] to an arbitrary JSON value.
         *
         * You should usually call [Builder.response] with a well-typed
         * [RealtimeResponseCreateParams] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun response(response: JsonField<RealtimeResponseCreateParams>) = apply {
            this.response = response
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
         * Returns an immutable instance of [ResponseCreateEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ResponseCreateEvent =
            ResponseCreateEvent(type, eventId, response, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): ResponseCreateEvent = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("response.create")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        eventId()
        response().ifPresent { it.validate() }
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
        type.let { if (it == JsonValue.from("response.create")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (response.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseCreateEvent &&
            type == other.type &&
            eventId == other.eventId &&
            response == other.response &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, eventId, response, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseCreateEvent{type=$type, eventId=$eventId, response=$response, additionalProperties=$additionalProperties}"
}
