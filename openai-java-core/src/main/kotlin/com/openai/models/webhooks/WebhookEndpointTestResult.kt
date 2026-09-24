// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

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

class WebhookEndpointTestResult
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val eventType: JsonField<String>,
    private val object_: JsonValue,
    private val statusCode: JsonField<Long>,
    private val success: JsonValue,
    private val webhookEndpointId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_type") @ExcludeMissing eventType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("status_code") @ExcludeMissing statusCode: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonValue = JsonMissing.of(),
        @JsonProperty("webhook_endpoint_id")
        @ExcludeMissing
        webhookEndpointId: JsonField<String> = JsonMissing.of(),
    ) : this(eventType, object_, statusCode, success, webhookEndpointId, mutableMapOf())

    /**
     * The event type sent in the test.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventType(): String = eventType.getRequired("event_type")

    /**
     * The object type, which is always webhook_endpoint.test.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("webhook_endpoint.test")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The HTTP status code returned by the endpoint.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun statusCode(): Long = statusCode.getRequired("status_code")

    /**
     * Whether the test request completed. Always true for returned results; use status_code to
     * determine the endpoint response.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from(true)
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonValue = success

    /**
     * The ID of the webhook endpoint that received the test.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun webhookEndpointId(): String = webhookEndpointId.getRequired("webhook_endpoint_id")

    /**
     * Returns the raw JSON value of [eventType].
     *
     * Unlike [eventType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_type") @ExcludeMissing fun _eventType(): JsonField<String> = eventType

    /**
     * Returns the raw JSON value of [statusCode].
     *
     * Unlike [statusCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status_code") @ExcludeMissing fun _statusCode(): JsonField<Long> = statusCode

    /**
     * Returns the raw JSON value of [webhookEndpointId].
     *
     * Unlike [webhookEndpointId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("webhook_endpoint_id")
    @ExcludeMissing
    fun _webhookEndpointId(): JsonField<String> = webhookEndpointId

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
         * Returns a mutable builder for constructing an instance of [WebhookEndpointTestResult].
         *
         * The following fields are required:
         * ```java
         * .eventType()
         * .statusCode()
         * .webhookEndpointId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookEndpointTestResult]. */
    class Builder internal constructor() {

        private var eventType: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("webhook_endpoint.test")
        private var statusCode: JsonField<Long>? = null
        private var success: JsonValue = JsonValue.from(true)
        private var webhookEndpointId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookEndpointTestResult: WebhookEndpointTestResult) = apply {
            eventType = webhookEndpointTestResult.eventType
            object_ = webhookEndpointTestResult.object_
            statusCode = webhookEndpointTestResult.statusCode
            success = webhookEndpointTestResult.success
            webhookEndpointId = webhookEndpointTestResult.webhookEndpointId
            additionalProperties = webhookEndpointTestResult.additionalProperties.toMutableMap()
        }

        /** The event type sent in the test. */
        fun eventType(eventType: String) = eventType(JsonField.of(eventType))

        /**
         * Sets [Builder.eventType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun eventType(eventType: JsonField<String>) = apply { this.eventType = eventType }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("webhook_endpoint.test")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The HTTP status code returned by the endpoint. */
        fun statusCode(statusCode: Long) = statusCode(JsonField.of(statusCode))

        /**
         * Sets [Builder.statusCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusCode] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun statusCode(statusCode: JsonField<Long>) = apply { this.statusCode = statusCode }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from(true)
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun success(success: JsonValue) = apply { this.success = success }

        /** The ID of the webhook endpoint that received the test. */
        fun webhookEndpointId(webhookEndpointId: String) =
            webhookEndpointId(JsonField.of(webhookEndpointId))

        /**
         * Sets [Builder.webhookEndpointId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.webhookEndpointId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun webhookEndpointId(webhookEndpointId: JsonField<String>) = apply {
            this.webhookEndpointId = webhookEndpointId
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
         * Returns an immutable instance of [WebhookEndpointTestResult].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventType()
         * .statusCode()
         * .webhookEndpointId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WebhookEndpointTestResult =
            WebhookEndpointTestResult(
                checkRequired("eventType", eventType),
                object_,
                checkRequired("statusCode", statusCode),
                success,
                checkRequired("webhookEndpointId", webhookEndpointId),
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
    fun validate(): WebhookEndpointTestResult = apply {
        if (validated) {
            return@apply
        }

        eventType()
        _object_().let {
            if (it != JsonValue.from("webhook_endpoint.test")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        statusCode()
        _success().let {
            if (it != JsonValue.from(true)) {
                throw OpenAIInvalidDataException("'success' is invalid, received $it")
            }
        }
        webhookEndpointId()
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
        (if (eventType.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("webhook_endpoint.test")) 1 else 0 } +
            (if (statusCode.asKnown().isPresent) 1 else 0) +
            success.let { if (it == JsonValue.from(true)) 1 else 0 } +
            (if (webhookEndpointId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookEndpointTestResult &&
            eventType == other.eventType &&
            object_ == other.object_ &&
            statusCode == other.statusCode &&
            success == other.success &&
            webhookEndpointId == other.webhookEndpointId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            eventType,
            object_,
            statusCode,
            success,
            webhookEndpointId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookEndpointTestResult{eventType=$eventType, object_=$object_, statusCode=$statusCode, success=$success, webhookEndpointId=$webhookEndpointId, additionalProperties=$additionalProperties}"
}
