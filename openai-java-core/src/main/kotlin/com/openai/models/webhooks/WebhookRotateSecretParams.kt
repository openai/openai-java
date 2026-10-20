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
import com.openai.core.Params
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Rotates the signing secret for a webhook endpoint in the authenticated project. */
class WebhookRotateSecretParams
private constructor(
    private val webhookEndpointId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun webhookEndpointId(): Optional<String> = Optional.ofNullable(webhookEndpointId)

    /**
     * Whether to keep the previous signing secret valid for 24 hours after rotation. Defaults to
     * false, which invalidates the previous secret immediately.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun keepOldSecretActiveFor24Hours(): Optional<Boolean> = body.keepOldSecretActiveFor24Hours()

    /**
     * Returns the raw JSON value of [keepOldSecretActiveFor24Hours].
     *
     * Unlike [keepOldSecretActiveFor24Hours], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _keepOldSecretActiveFor24Hours(): JsonField<Boolean> = body._keepOldSecretActiveFor24Hours()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): WebhookRotateSecretParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [WebhookRotateSecretParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookRotateSecretParams]. */
    class Builder internal constructor() {

        private var webhookEndpointId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(webhookRotateSecretParams: WebhookRotateSecretParams) = apply {
            webhookEndpointId = webhookRotateSecretParams.webhookEndpointId
            body = webhookRotateSecretParams.body.toBuilder()
            additionalHeaders = webhookRotateSecretParams.additionalHeaders.toBuilder()
            additionalQueryParams = webhookRotateSecretParams.additionalQueryParams.toBuilder()
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
         * - [keepOldSecretActiveFor24Hours]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Whether to keep the previous signing secret valid for 24 hours after rotation. Defaults
         * to false, which invalidates the previous secret immediately.
         */
        fun keepOldSecretActiveFor24Hours(keepOldSecretActiveFor24Hours: Boolean) = apply {
            body.keepOldSecretActiveFor24Hours(keepOldSecretActiveFor24Hours)
        }

        /**
         * Sets [Builder.keepOldSecretActiveFor24Hours] to an arbitrary JSON value.
         *
         * You should usually call [Builder.keepOldSecretActiveFor24Hours] with a well-typed
         * [Boolean] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun keepOldSecretActiveFor24Hours(keepOldSecretActiveFor24Hours: JsonField<Boolean>) =
            apply {
                body.keepOldSecretActiveFor24Hours(keepOldSecretActiveFor24Hours)
            }

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
         * Returns an immutable instance of [WebhookRotateSecretParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookRotateSecretParams =
            WebhookRotateSecretParams(
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
        private val keepOldSecretActiveFor24Hours: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("keep_old_secret_active_for_24_hours")
            @ExcludeMissing
            keepOldSecretActiveFor24Hours: JsonField<Boolean> = JsonMissing.of()
        ) : this(keepOldSecretActiveFor24Hours, mutableMapOf())

        /**
         * Whether to keep the previous signing secret valid for 24 hours after rotation. Defaults
         * to false, which invalidates the previous secret immediately.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun keepOldSecretActiveFor24Hours(): Optional<Boolean> =
            keepOldSecretActiveFor24Hours.getOptional("keep_old_secret_active_for_24_hours")

        /**
         * Returns the raw JSON value of [keepOldSecretActiveFor24Hours].
         *
         * Unlike [keepOldSecretActiveFor24Hours], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("keep_old_secret_active_for_24_hours")
        @ExcludeMissing
        fun _keepOldSecretActiveFor24Hours(): JsonField<Boolean> = keepOldSecretActiveFor24Hours

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var keepOldSecretActiveFor24Hours: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                keepOldSecretActiveFor24Hours = body.keepOldSecretActiveFor24Hours
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Whether to keep the previous signing secret valid for 24 hours after rotation.
             * Defaults to false, which invalidates the previous secret immediately.
             */
            fun keepOldSecretActiveFor24Hours(keepOldSecretActiveFor24Hours: Boolean) =
                keepOldSecretActiveFor24Hours(JsonField.of(keepOldSecretActiveFor24Hours))

            /**
             * Sets [Builder.keepOldSecretActiveFor24Hours] to an arbitrary JSON value.
             *
             * You should usually call [Builder.keepOldSecretActiveFor24Hours] with a well-typed
             * [Boolean] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun keepOldSecretActiveFor24Hours(keepOldSecretActiveFor24Hours: JsonField<Boolean>) =
                apply {
                    this.keepOldSecretActiveFor24Hours = keepOldSecretActiveFor24Hours
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(keepOldSecretActiveFor24Hours, additionalProperties.toMutableMap())
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

            keepOldSecretActiveFor24Hours()
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
        internal fun validity(): Int =
            (if (keepOldSecretActiveFor24Hours.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                keepOldSecretActiveFor24Hours == other.keepOldSecretActiveFor24Hours &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(keepOldSecretActiveFor24Hours, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{keepOldSecretActiveFor24Hours=$keepOldSecretActiveFor24Hours, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookRotateSecretParams &&
            webhookEndpointId == other.webhookEndpointId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(webhookEndpointId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "WebhookRotateSecretParams{webhookEndpointId=$webhookEndpointId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
