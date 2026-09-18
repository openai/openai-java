// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Sends a sample event to a webhook endpoint for the authenticated project. */
class WebhookTestParams
private constructor(
    private val webhookEndpointId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun webhookEndpointId(): Optional<String> = Optional.ofNullable(webhookEndpointId)

    /**
     * The event type to send as a sample delivery.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventType(): EventType = body.eventType()

    /**
     * Returns the raw JSON value of [eventType].
     *
     * Unlike [eventType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _eventType(): JsonField<EventType> = body._eventType()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WebhookTestParams].
         *
         * The following fields are required:
         * ```java
         * .eventType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookTestParams]. */
    class Builder internal constructor() {

        private var webhookEndpointId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(webhookTestParams: WebhookTestParams) = apply {
            webhookEndpointId = webhookTestParams.webhookEndpointId
            body = webhookTestParams.body.toBuilder()
            additionalHeaders = webhookTestParams.additionalHeaders.toBuilder()
            additionalQueryParams = webhookTestParams.additionalQueryParams.toBuilder()
        }

        fun webhookEndpointId(webhookEndpointId: String?) = apply {
            this.webhookEndpointId = webhookEndpointId
        }

        /** Alias for calling [Builder.webhookEndpointId] with `webhookEndpointId.orElse(null)`. */
        fun webhookEndpointId(webhookEndpointId: Optional<String>) =
            webhookEndpointId(webhookEndpointId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [eventType]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The event type to send as a sample delivery. */
        fun eventType(eventType: EventType) = apply { body.eventType(eventType) }

        /**
         * Sets [Builder.eventType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventType] with a well-typed [EventType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun eventType(eventType: JsonField<EventType>) = apply { body.eventType(eventType) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [WebhookTestParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WebhookTestParams =
            WebhookTestParams(
                webhookEndpointId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> webhookEndpointId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val eventType: JsonField<EventType>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event_type")
            @ExcludeMissing
            eventType: JsonField<EventType> = JsonMissing.of()
        ) : this(eventType, mutableMapOf())

        /**
         * The event type to send as a sample delivery.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventType(): EventType = eventType.getRequired("event_type")

        /**
         * Returns the raw JSON value of [eventType].
         *
         * Unlike [eventType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_type")
        @ExcludeMissing
        fun _eventType(): JsonField<EventType> = eventType

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .eventType()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var eventType: JsonField<EventType>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                eventType = body.eventType
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The event type to send as a sample delivery. */
            fun eventType(eventType: EventType) = eventType(JsonField.of(eventType))

            /**
             * Sets [Builder.eventType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventType] with a well-typed [EventType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventType(eventType: JsonField<EventType>) = apply { this.eventType = eventType }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .eventType()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(checkRequired("eventType", eventType), additionalProperties.toMutableMap())
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            eventType().validate()
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
        @JvmSynthetic
        internal fun validity(): Int = (eventType.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                eventType == other.eventType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(eventType, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{eventType=$eventType, additionalProperties=$additionalProperties}"
    }

    /** The event type to send as a sample delivery. */
    class EventType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val BATCH_COMPLETED = of("batch.completed")

            @JvmField val BATCH_FAILED = of("batch.failed")

            @JvmField val BATCH_EXPIRED = of("batch.expired")

            @JvmField val BATCH_CANCELLED = of("batch.cancelled")

            @JvmField val RESPONSE_COMPLETED = of("response.completed")

            @JvmField val RESPONSE_FAILED = of("response.failed")

            @JvmField val RESPONSE_CANCELLED = of("response.cancelled")

            @JvmField val RESPONSE_INCOMPLETE = of("response.incomplete")

            @JvmField val EVAL_RUN_SUCCEEDED = of("eval.run.succeeded")

            @JvmField val EVAL_RUN_FAILED = of("eval.run.failed")

            @JvmField val EVAL_RUN_CANCELED = of("eval.run.canceled")

            @JvmField val FINE_TUNING_JOB_SUCCEEDED = of("fine_tuning.job.succeeded")

            @JvmField val FINE_TUNING_JOB_FAILED = of("fine_tuning.job.failed")

            @JvmField val FINE_TUNING_JOB_CANCELLED = of("fine_tuning.job.cancelled")

            @JvmField val REALTIME_CALL_INCOMING = of("realtime.call.incoming")

            @JvmField val VIDEO_COMPLETED = of("video.completed")

            @JvmField val VIDEO_FAILED = of("video.failed")

            @JvmField val SAFETY_ALERT_CREATED = of("safety.alert.created")

            @JvmStatic fun of(value: String) = EventType(JsonField.of(value))
        }

        /** An enum containing [EventType]'s known values. */
        enum class Known {
            BATCH_COMPLETED,
            BATCH_FAILED,
            BATCH_EXPIRED,
            BATCH_CANCELLED,
            RESPONSE_COMPLETED,
            RESPONSE_FAILED,
            RESPONSE_CANCELLED,
            RESPONSE_INCOMPLETE,
            EVAL_RUN_SUCCEEDED,
            EVAL_RUN_FAILED,
            EVAL_RUN_CANCELED,
            FINE_TUNING_JOB_SUCCEEDED,
            FINE_TUNING_JOB_FAILED,
            FINE_TUNING_JOB_CANCELLED,
            REALTIME_CALL_INCOMING,
            VIDEO_COMPLETED,
            VIDEO_FAILED,
            SAFETY_ALERT_CREATED,
        }

        /**
         * An enum containing [EventType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [EventType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            BATCH_COMPLETED,
            BATCH_FAILED,
            BATCH_EXPIRED,
            BATCH_CANCELLED,
            RESPONSE_COMPLETED,
            RESPONSE_FAILED,
            RESPONSE_CANCELLED,
            RESPONSE_INCOMPLETE,
            EVAL_RUN_SUCCEEDED,
            EVAL_RUN_FAILED,
            EVAL_RUN_CANCELED,
            FINE_TUNING_JOB_SUCCEEDED,
            FINE_TUNING_JOB_FAILED,
            FINE_TUNING_JOB_CANCELLED,
            REALTIME_CALL_INCOMING,
            VIDEO_COMPLETED,
            VIDEO_FAILED,
            SAFETY_ALERT_CREATED,
            /**
             * An enum member indicating that [EventType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                BATCH_COMPLETED -> Value.BATCH_COMPLETED
                BATCH_FAILED -> Value.BATCH_FAILED
                BATCH_EXPIRED -> Value.BATCH_EXPIRED
                BATCH_CANCELLED -> Value.BATCH_CANCELLED
                RESPONSE_COMPLETED -> Value.RESPONSE_COMPLETED
                RESPONSE_FAILED -> Value.RESPONSE_FAILED
                RESPONSE_CANCELLED -> Value.RESPONSE_CANCELLED
                RESPONSE_INCOMPLETE -> Value.RESPONSE_INCOMPLETE
                EVAL_RUN_SUCCEEDED -> Value.EVAL_RUN_SUCCEEDED
                EVAL_RUN_FAILED -> Value.EVAL_RUN_FAILED
                EVAL_RUN_CANCELED -> Value.EVAL_RUN_CANCELED
                FINE_TUNING_JOB_SUCCEEDED -> Value.FINE_TUNING_JOB_SUCCEEDED
                FINE_TUNING_JOB_FAILED -> Value.FINE_TUNING_JOB_FAILED
                FINE_TUNING_JOB_CANCELLED -> Value.FINE_TUNING_JOB_CANCELLED
                REALTIME_CALL_INCOMING -> Value.REALTIME_CALL_INCOMING
                VIDEO_COMPLETED -> Value.VIDEO_COMPLETED
                VIDEO_FAILED -> Value.VIDEO_FAILED
                SAFETY_ALERT_CREATED -> Value.SAFETY_ALERT_CREATED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                BATCH_COMPLETED -> Known.BATCH_COMPLETED
                BATCH_FAILED -> Known.BATCH_FAILED
                BATCH_EXPIRED -> Known.BATCH_EXPIRED
                BATCH_CANCELLED -> Known.BATCH_CANCELLED
                RESPONSE_COMPLETED -> Known.RESPONSE_COMPLETED
                RESPONSE_FAILED -> Known.RESPONSE_FAILED
                RESPONSE_CANCELLED -> Known.RESPONSE_CANCELLED
                RESPONSE_INCOMPLETE -> Known.RESPONSE_INCOMPLETE
                EVAL_RUN_SUCCEEDED -> Known.EVAL_RUN_SUCCEEDED
                EVAL_RUN_FAILED -> Known.EVAL_RUN_FAILED
                EVAL_RUN_CANCELED -> Known.EVAL_RUN_CANCELED
                FINE_TUNING_JOB_SUCCEEDED -> Known.FINE_TUNING_JOB_SUCCEEDED
                FINE_TUNING_JOB_FAILED -> Known.FINE_TUNING_JOB_FAILED
                FINE_TUNING_JOB_CANCELLED -> Known.FINE_TUNING_JOB_CANCELLED
                REALTIME_CALL_INCOMING -> Known.REALTIME_CALL_INCOMING
                VIDEO_COMPLETED -> Known.VIDEO_COMPLETED
                VIDEO_FAILED -> Known.VIDEO_FAILED
                SAFETY_ALERT_CREATED -> Known.SAFETY_ALERT_CREATED
                else -> throw OpenAIInvalidDataException("Unknown EventType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

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
        fun validate(): EventType = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EventType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookTestParams &&
            webhookEndpointId == other.webhookEndpointId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(webhookEndpointId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "WebhookTestParams{webhookEndpointId=$webhookEndpointId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
