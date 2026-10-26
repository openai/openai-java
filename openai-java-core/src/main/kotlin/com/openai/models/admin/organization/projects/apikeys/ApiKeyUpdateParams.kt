// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.apikeys

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Updates the scopes and/or expiration of an existing API key in the project, including a
 * service-account-owned key. Requires permission to write project API keys.
 *
 * Provide at least one of `scopes` or `expires_in_seconds`. Omitted fields stay unchanged; neither
 * field accepts `null`. Both changes are saved together.
 *
 * `scopes` replaces the key's scope restrictions using the same scope identifiers as the dashboard.
 * An empty array means All permissions, subject to the owner's effective access; it does not mean
 * no access. Use `["api.all.read"]` for read-only access or specific scopes such as
 * `["api.files.read"]` for restricted access. This does not change user or service-account roles or
 * grant admin permissions. Scope changes follow the same authentication-cache propagation as
 * dashboard edits.
 *
 * Provide `expires_in_seconds` to set the expiration relative to this request. The value must
 * satisfy the organization's and project's expiry policies. Expired keys cannot be updated.
 * Retrying resets the expiration relative to the new request. The response contains only the
 * redacted key, not its secret.
 */
class ApiKeyUpdateParams
private constructor(
    private val projectId: String,
    private val apiKeyId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun projectId(): String = projectId

    fun apiKeyId(): Optional<String> = Optional.ofNullable(apiKeyId)

    /**
     * Number of seconds from this request until the API key expires. Must comply with the
     * organization and project expiry policies. Expired keys cannot be updated. Retrying resets the
     * expiry relative to the new request. Omit to keep the current expiration.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun expiresInSeconds(): Long = body.expiresInSeconds()

    /** Returns the requested value, or empty if the field is omitted or null. */
    fun expiresInSecondsOptional(): Optional<Long> = body.expiresInSecondsOptional()

    /**
     * Replace the API key scope restrictions. Omit to leave scopes unchanged. An empty array
     * removes key restrictions (All permissions), subject to the owner's effective permissions. Use
     * ["api.all.read"] for read-only access. Scopes do not change the owner's roles or grant
     * administrative permissions.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun scopes(): Optional<List<String>> = body.scopes()

    /**
     * Returns the raw JSON value of [expiresInSeconds].
     *
     * Unlike [expiresInSeconds], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _expiresInSeconds(): JsonField<Long> = body._expiresInSeconds()

    /**
     * Returns the raw JSON value of [scopes].
     *
     * Unlike [scopes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _scopes(): JsonField<List<String>> = body._scopes()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ApiKeyUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .projectId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ApiKeyUpdateParams]. */
    class Builder internal constructor() {

        private var projectId: String? = null
        private var apiKeyId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(apiKeyUpdateParams: ApiKeyUpdateParams) = apply {
            projectId = apiKeyUpdateParams.projectId
            apiKeyId = apiKeyUpdateParams.apiKeyId
            body = apiKeyUpdateParams.body.toBuilder()
            additionalHeaders = apiKeyUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = apiKeyUpdateParams.additionalQueryParams.toBuilder()
        }

        fun projectId(projectId: String) = apply { this.projectId = projectId }

        fun apiKeyId(apiKeyId: String?) = apply { this.apiKeyId = apiKeyId }

        /** Alias for calling [Builder.apiKeyId] with `apiKeyId.orElse(null)`. */
        fun apiKeyId(apiKeyId: Optional<String>) = apiKeyId(apiKeyId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [expiresInSeconds]
         * - [scopes]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Number of seconds from this request until the API key expires. Must comply with the
         * organization and project expiry policies. Expired keys cannot be updated. Retrying resets
         * the expiry relative to the new request. Omit to keep the current expiration.
         */
        fun expiresInSeconds(expiresInSeconds: Long) = apply {
            body.expiresInSeconds(expiresInSeconds)
        }

        /**
         * Sets [Builder.expiresInSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresInSeconds] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expiresInSeconds(expiresInSeconds: JsonField<Long>) = apply {
            body.expiresInSeconds(expiresInSeconds)
        }

        /**
         * Replace the API key scope restrictions. Omit to leave scopes unchanged. An empty array
         * removes key restrictions (All permissions), subject to the owner's effective permissions.
         * Use ["api.all.read"] for read-only access. Scopes do not change the owner's roles or
         * grant administrative permissions.
         */
        fun scopes(scopes: List<String>) = apply { body.scopes(scopes) }

        /**
         * Sets [Builder.scopes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scopes] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun scopes(scopes: JsonField<List<String>>) = apply { body.scopes(scopes) }

        /**
         * Adds a single [String] to [scopes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addScope(scope: String) = apply { body.addScope(scope) }

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
         * Returns an immutable instance of [ApiKeyUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .projectId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ApiKeyUpdateParams =
            ApiKeyUpdateParams(
                checkRequired("projectId", projectId),
                apiKeyId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> projectId
            1 -> apiKeyId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val expiresInSeconds: JsonField<Long>,
        private val scopes: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("expires_in_seconds")
            @ExcludeMissing
            expiresInSeconds: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("scopes")
            @ExcludeMissing
            scopes: JsonField<List<String>> = JsonMissing.of(),
        ) : this(expiresInSeconds, scopes, mutableMapOf())

        /**
         * Number of seconds from this request until the API key expires. Must comply with the
         * organization and project expiry policies. Expired keys cannot be updated. Retrying resets
         * the expiry relative to the new request. Omit to keep the current expiration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun expiresInSeconds(): Long = expiresInSeconds.getRequired("expires_in_seconds")

        /** Returns the requested value, or empty if the field is omitted or null. */
        fun expiresInSecondsOptional(): Optional<Long> =
            expiresInSeconds.getOptional("expires_in_seconds")

        /**
         * Replace the API key scope restrictions. Omit to leave scopes unchanged. An empty array
         * removes key restrictions (All permissions), subject to the owner's effective permissions.
         * Use ["api.all.read"] for read-only access. Scopes do not change the owner's roles or
         * grant administrative permissions.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun scopes(): Optional<List<String>> = scopes.getOptional("scopes")

        /**
         * Returns the raw JSON value of [expiresInSeconds].
         *
         * Unlike [expiresInSeconds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("expires_in_seconds")
        @ExcludeMissing
        fun _expiresInSeconds(): JsonField<Long> = expiresInSeconds

        /**
         * Returns the raw JSON value of [scopes].
         *
         * Unlike [scopes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scopes") @ExcludeMissing fun _scopes(): JsonField<List<String>> = scopes

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
                "expires_in_seconds" to this.expiresInSeconds,
                "scopes" to this.scopes,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
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

            private var expiresInSeconds: JsonField<Long> = JsonMissing.of()
            private var scopes: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                expiresInSeconds = body.expiresInSeconds
                scopes = body.scopes.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Number of seconds from this request until the API key expires. Must comply with the
             * organization and project expiry policies. Expired keys cannot be updated. Retrying
             * resets the expiry relative to the new request. Omit to keep the current expiration.
             */
            fun expiresInSeconds(expiresInSeconds: Long) =
                expiresInSeconds(JsonField.of(expiresInSeconds))

            /**
             * Sets [Builder.expiresInSeconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresInSeconds] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresInSeconds(expiresInSeconds: JsonField<Long>) = apply {
                this.expiresInSeconds = expiresInSeconds
            }

            /**
             * Replace the API key scope restrictions. Omit to leave scopes unchanged. An empty
             * array removes key restrictions (All permissions), subject to the owner's effective
             * permissions. Use ["api.all.read"] for read-only access. Scopes do not change the
             * owner's roles or grant administrative permissions.
             */
            fun scopes(scopes: List<String>) = scopes(JsonField.of(scopes))

            /**
             * Sets [Builder.scopes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scopes] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun scopes(scopes: JsonField<List<String>>) = apply {
                this.scopes = scopes.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [scopes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addScope(scope: String) = apply {
                scopes =
                    (scopes?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf())).also {
                        checkKnown("scopes", it).add(scope)
                    }
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
                Body(
                    expiresInSeconds,
                    (scopes ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            expiresInSecondsOptional()
            scopes()
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
            (if (expiresInSeconds.asKnown().isPresent) 1 else 0) +
                (scopes.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                expiresInSeconds == other.expiresInSeconds &&
                scopes == other.scopes &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(expiresInSeconds, scopes, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{expiresInSeconds=$expiresInSeconds, scopes=$scopes, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApiKeyUpdateParams &&
            projectId == other.projectId &&
            apiKeyId == other.apiKeyId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(projectId, apiKeyId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ApiKeyUpdateParams{projectId=$projectId, apiKeyId=$apiKeyId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
