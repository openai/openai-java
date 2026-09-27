// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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
import kotlin.jvm.optionals.getOrNull

/**
 * Queues user input to steer a response on this WebSocket connection. Input can contain text,
 * images, and files. Steering is supported only for single-agent responses on models and execution
 * modes that support steering. Responses bound to a conversation or using automatic compaction do
 * not support steering.
 *
 * A `response.steer.accepted` event acknowledges that the server owns the queued input, not that it
 * has been applied. The successor's `response.created` event is the commit point. Input that cannot
 * be committed is returned in `response.steer.failed`.
 *
 * Steering may cause the active response to finish at a safe output boundary with
 * `response.incomplete` and `incomplete_details.reason` set to `steered`, followed automatically by
 * a successor `response.created`. Normal completion can also be followed by an automatic successor.
 * Automatic successors inherit the previous response's settings and continue from it with the
 * queued input.
 *
 * If the response stops for client-owned tool output or approval, accepted steering input remains
 * queued and `response.steer.pending` is emitted after `response.completed`. Fill the
 * `required_input` stubs from that event with saved tool results or approval decisions, and send
 * one explicit `response.create` per parent with the same `previous_response_id` and WebSocket
 * lane. Do not rerun tools or resend accepted steering input. The queued input is prepended in
 * submission order to that request's input, and the explicit request retains its own settings.
 *
 * This event accepts only `type`, `previous_response_id`, and `input`. Do not send `stream_id`; the
 * target response determines the WebSocket lane.
 */
class ResponseSteerEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val input: JsonField<ResponseSteerInput>,
    private val previousResponseId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input")
        @ExcludeMissing
        input: JsonField<ResponseSteerInput> = JsonMissing.of(),
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        previousResponseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(input, previousResponseId, type, mutableMapOf())

    /**
     * Input to queue for a continuation of the response. Uses the same string or input-item shape
     * as `response.create.input`, with a non-empty array when supplying input items.
     *
     * Steering accepts only messages with the `user` role. Each message may contain only `type`,
     * `role`, and `content`, with `content` as a string or an array of `input_text`, `input_image`,
     * and `input_file` parts. The optional `type` must be `message`. Other roles, tool outputs, and
     * item types are not supported for steering.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): ResponseSteerInput = input.getRequired("input")

    /**
     * The ID of the response to steer on this WebSocket connection.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun previousResponseId(): String = previousResponseId.getRequired("previous_response_id")

    /**
     * The event discriminator. Always `response.steer`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.steer")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<ResponseSteerInput> = input

    /**
     * Returns the raw JSON value of [previousResponseId].
     *
     * Unlike [previousResponseId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("previous_response_id")
    @ExcludeMissing
    fun _previousResponseId(): JsonField<String> = previousResponseId

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
         * Returns a mutable builder for constructing an instance of [ResponseSteerEvent].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .previousResponseId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseSteerEvent]. */
    class Builder internal constructor() {

        private var input: JsonField<ResponseSteerInput>? = null
        private var previousResponseId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.steer")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseSteerEvent: ResponseSteerEvent) = apply {
            input = responseSteerEvent.input
            previousResponseId = responseSteerEvent.previousResponseId
            type = responseSteerEvent.type
            additionalProperties = responseSteerEvent.additionalProperties.toMutableMap()
        }

        /**
         * Input to queue for a continuation of the response. Uses the same string or input-item
         * shape as `response.create.input`, with a non-empty array when supplying input items.
         *
         * Steering accepts only messages with the `user` role. Each message may contain only
         * `type`, `role`, and `content`, with `content` as a string or an array of `input_text`,
         * `input_image`, and `input_file` parts. The optional `type` must be `message`. Other
         * roles, tool outputs, and item types are not supported for steering.
         */
        fun input(input: ResponseSteerInput) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [ResponseSteerInput] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun input(input: JsonField<ResponseSteerInput>) = apply { this.input = input }

        /** Alias for calling [input] with `ResponseSteerInput.ofText(text)`. */
        fun input(text: String) = input(ResponseSteerInput.ofText(text))

        /** Alias for calling [input] with `ResponseSteerInput.ofItemList(itemList)`. */
        fun inputOfItemList(itemList: List<ResponseSteerInput.ResponseSteerInputItem>) =
            input(ResponseSteerInput.ofItemList(itemList))

        /** The ID of the response to steer on this WebSocket connection. */
        fun previousResponseId(previousResponseId: String) =
            previousResponseId(JsonField.of(previousResponseId))

        /**
         * Sets [Builder.previousResponseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.previousResponseId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun previousResponseId(previousResponseId: JsonField<String>) = apply {
            this.previousResponseId = previousResponseId
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.steer")
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
         * Returns an immutable instance of [ResponseSteerEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .previousResponseId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseSteerEvent =
            ResponseSteerEvent(
                checkRequired("input", input),
                checkRequired("previousResponseId", previousResponseId),
                type,
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
    fun validate(): ResponseSteerEvent = apply {
        if (validated) {
            return@apply
        }

        input().validate()
        previousResponseId()
        _type().let {
            if (it != JsonValue.from("response.steer")) {
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
        (input.asKnown().getOrNull()?.validity() ?: 0) +
            (if (previousResponseId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.steer")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseSteerEvent &&
            input == other.input &&
            previousResponseId == other.previousResponseId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(input, previousResponseId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseSteerEvent{input=$input, previousResponseId=$previousResponseId, type=$type, additionalProperties=$additionalProperties}"
}
