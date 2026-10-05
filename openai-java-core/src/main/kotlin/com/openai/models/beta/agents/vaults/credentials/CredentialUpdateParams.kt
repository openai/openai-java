// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Updates credential metadata or rotates its write-only secret. See
 * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
 */
class CredentialUpdateParams
private constructor(
    private val vaultId: String,
    private val credentialId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun vaultId(): String = vaultId

    fun credentialId(): Optional<String> = Optional.ofNullable(credentialId)

    /**
     * Replacement values for the credential's existing authentication method.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun auth(): Optional<CredentialAuthRotateParam> = body.auth()

    /**
     * Replaces all metadata. Omit to preserve it, or pass {} to clear it. Up to 16 string key-value
     * pairs, with keys up to 64 and values up to 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * Returns the raw JSON value of [auth].
     *
     * Unlike [auth], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _auth(): JsonField<CredentialAuthRotateParam> = body._auth()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CredentialUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .vaultId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CredentialUpdateParams]. */
    class Builder internal constructor() {

        private var vaultId: String? = null
        private var credentialId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(credentialUpdateParams: CredentialUpdateParams) = apply {
            vaultId = credentialUpdateParams.vaultId
            credentialId = credentialUpdateParams.credentialId
            body = credentialUpdateParams.body.toBuilder()
            additionalHeaders = credentialUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = credentialUpdateParams.additionalQueryParams.toBuilder()
        }

        fun vaultId(vaultId: String) = apply { this.vaultId = vaultId }

        fun credentialId(credentialId: String?) = apply { this.credentialId = credentialId }

        /** Alias for calling [Builder.credentialId] with `credentialId.orElse(null)`. */
        fun credentialId(credentialId: Optional<String>) = credentialId(credentialId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [auth]
         * - [metadata]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Replacement values for the credential's existing authentication method. */
        fun auth(auth: CredentialAuthRotateParam) = apply { body.auth(auth) }

        /**
         * Sets [Builder.auth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.auth] with a well-typed [CredentialAuthRotateParam]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun auth(auth: JsonField<CredentialAuthRotateParam>) = apply { body.auth(auth) }

        /** Alias for calling [auth] with `CredentialAuthRotateParam.ofMcpOAuth(mcpOauth)`. */
        fun auth(mcpOauth: CredentialAuthRotateParam.McpOAuth) = apply { body.auth(mcpOauth) }

        /**
         * Alias for calling [auth] with `CredentialAuthRotateParam.ofStaticBearer(staticBearer)`.
         */
        fun auth(staticBearer: CredentialAuthRotateParam.StaticBearer) = apply {
            body.auth(staticBearer)
        }

        /**
         * Alias for calling [auth] with the following:
         * ```java
         * CredentialAuthRotateParam.StaticBearer.builder()
         *     .token(token)
         *     .build()
         * ```
         */
        fun staticBearerAuth(token: String) = apply { body.staticBearerAuth(token) }

        /**
         * Alias for calling [auth] with
         * `CredentialAuthRotateParam.ofEnvironmentVariable(environmentVariable)`.
         */
        fun auth(environmentVariable: CredentialAuthRotateParam.EnvironmentVariable) = apply {
            body.auth(environmentVariable)
        }

        /**
         * Alias for calling [auth] with the following:
         * ```java
         * CredentialAuthRotateParam.EnvironmentVariable.builder()
         *     .secretValue(secretValue)
         *     .build()
         * ```
         */
        fun environmentVariableAuth(secretValue: String) = apply {
            body.environmentVariableAuth(secretValue)
        }

        /**
         * Replaces all metadata. Omit to preserve it, or pass {} to clear it. Up to 16 string
         * key-value pairs, with keys up to 64 and values up to 512 characters.
         */
        fun metadata(metadata: Metadata) = apply { body.metadata(metadata) }

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

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
         * Returns an immutable instance of [CredentialUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .vaultId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CredentialUpdateParams =
            CredentialUpdateParams(
                checkRequired("vaultId", vaultId),
                credentialId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> vaultId
            1 -> credentialId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Metadata, secret, expiry, and OAuth refresh scope updates for an existing vault credential.
     * Supply at least one of `auth` or `metadata`.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val auth: JsonField<CredentialAuthRotateParam>,
        private val metadata: JsonField<Metadata>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("auth")
            @ExcludeMissing
            auth: JsonField<CredentialAuthRotateParam> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
        ) : this(auth, metadata, mutableMapOf())

        /**
         * Replacement values for the credential's existing authentication method.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun auth(): Optional<CredentialAuthRotateParam> = auth.getOptional("auth")

        /**
         * Replaces all metadata. Omit to preserve it, or pass {} to clear it. Up to 16 string
         * key-value pairs, with keys up to 64 and values up to 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * Returns the raw JSON value of [auth].
         *
         * Unlike [auth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("auth")
        @ExcludeMissing
        fun _auth(): JsonField<CredentialAuthRotateParam> = auth

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

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

            private var auth: JsonField<CredentialAuthRotateParam> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                auth = body.auth
                metadata = body.metadata
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Replacement values for the credential's existing authentication method. */
            fun auth(auth: CredentialAuthRotateParam) = auth(JsonField.of(auth))

            /**
             * Sets [Builder.auth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.auth] with a well-typed [CredentialAuthRotateParam]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun auth(auth: JsonField<CredentialAuthRotateParam>) = apply { this.auth = auth }

            /** Alias for calling [auth] with `CredentialAuthRotateParam.ofMcpOAuth(mcpOauth)`. */
            fun auth(mcpOauth: CredentialAuthRotateParam.McpOAuth) =
                auth(CredentialAuthRotateParam.ofMcpOAuth(mcpOauth))

            /**
             * Alias for calling [auth] with
             * `CredentialAuthRotateParam.ofStaticBearer(staticBearer)`.
             */
            fun auth(staticBearer: CredentialAuthRotateParam.StaticBearer) =
                auth(CredentialAuthRotateParam.ofStaticBearer(staticBearer))

            /**
             * Alias for calling [auth] with the following:
             * ```java
             * CredentialAuthRotateParam.StaticBearer.builder()
             *     .token(token)
             *     .build()
             * ```
             */
            fun staticBearerAuth(token: String) =
                auth(CredentialAuthRotateParam.StaticBearer.builder().token(token).build())

            /**
             * Alias for calling [auth] with
             * `CredentialAuthRotateParam.ofEnvironmentVariable(environmentVariable)`.
             */
            fun auth(environmentVariable: CredentialAuthRotateParam.EnvironmentVariable) =
                auth(CredentialAuthRotateParam.ofEnvironmentVariable(environmentVariable))

            /**
             * Alias for calling [auth] with the following:
             * ```java
             * CredentialAuthRotateParam.EnvironmentVariable.builder()
             *     .secretValue(secretValue)
             *     .build()
             * ```
             */
            fun environmentVariableAuth(secretValue: String) =
                auth(
                    CredentialAuthRotateParam.EnvironmentVariable.builder()
                        .secretValue(secretValue)
                        .build()
                )

            /**
             * Replaces all metadata. Omit to preserve it, or pass {} to clear it. Up to 16 string
             * key-value pairs, with keys up to 64 and values up to 512 characters.
             */
            fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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
            fun build(): Body = Body(auth, metadata, additionalProperties.toMutableMap())
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

            auth().ifPresent { it.validate() }
            metadata().ifPresent { it.validate() }
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
            (auth.asKnown().getOrNull()?.validity() ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                auth == other.auth &&
                metadata == other.metadata &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(auth, metadata, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{auth=$auth, metadata=$metadata, additionalProperties=$additionalProperties}"
    }

    /**
     * Replaces all metadata. Omit to preserve it, or pass {} to clear it. Up to 16 string key-value
     * pairs, with keys up to 64 and values up to 512 characters.
     */
    class Metadata
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
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
        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CredentialUpdateParams &&
            vaultId == other.vaultId &&
            credentialId == other.credentialId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(vaultId, credentialId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CredentialUpdateParams{vaultId=$vaultId, credentialId=$credentialId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
