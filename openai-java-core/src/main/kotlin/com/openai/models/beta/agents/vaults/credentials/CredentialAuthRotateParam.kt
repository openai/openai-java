// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Updates to a vault credential without changing its authentication method or MCP server. */
@JsonDeserialize(using = CredentialAuthRotateParam.Deserializer::class)
@JsonSerialize(using = CredentialAuthRotateParam.Serializer::class)
class CredentialAuthRotateParam
private constructor(
    private val mcpOauth: McpOAuth? = null,
    private val staticBearer: StaticBearer? = null,
    private val _json: JsonValue? = null,
) {

    /** Rotate an OAuth credential for an HTTPS MCP destination. */
    fun mcpOauth(): Optional<McpOAuth> = Optional.ofNullable(mcpOauth)

    /** Replace the bearer token for the credential's MCP server. */
    fun staticBearer(): Optional<StaticBearer> = Optional.ofNullable(staticBearer)

    fun isMcpOAuth(): Boolean = mcpOauth != null

    fun isStaticBearer(): Boolean = staticBearer != null

    /** Rotate an OAuth credential for an HTTPS MCP destination. */
    fun asMcpOAuth(): McpOAuth = mcpOauth.getOrThrow("mcpOauth")

    /** Replace the bearer token for the credential's MCP server. */
    fun asStaticBearer(): StaticBearer = staticBearer.getOrThrow("staticBearer")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = credentialAuthRotateParam.accept(new CredentialAuthRotateParam.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitMcpOAuth(McpOAuth mcpOauth) {
     *         return Optional.of(mcpOauth.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            mcpOauth != null -> visitor.visitMcpOAuth(mcpOauth)
            staticBearer != null -> visitor.visitStaticBearer(staticBearer)
            else -> visitor.unknown(_json)
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
    fun validate(): CredentialAuthRotateParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitMcpOAuth(mcpOauth: McpOAuth) {
                    mcpOauth.validate()
                }

                override fun visitStaticBearer(staticBearer: StaticBearer) {
                    staticBearer.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitMcpOAuth(mcpOauth: McpOAuth) = mcpOauth.validity()

                override fun visitStaticBearer(staticBearer: StaticBearer) = staticBearer.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CredentialAuthRotateParam &&
            mcpOauth == other.mcpOauth &&
            staticBearer == other.staticBearer
    }

    override fun hashCode(): Int = Objects.hash(mcpOauth, staticBearer)

    override fun toString(): String =
        when {
            mcpOauth != null -> "CredentialAuthRotateParam{mcpOauth=$mcpOauth}"
            staticBearer != null -> "CredentialAuthRotateParam{staticBearer=$staticBearer}"
            _json != null -> "CredentialAuthRotateParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid CredentialAuthRotateParam")
        }

    companion object {

        /** Rotate an OAuth credential for an HTTPS MCP destination. */
        @JvmStatic
        fun ofMcpOAuth(mcpOauth: McpOAuth) = CredentialAuthRotateParam(mcpOauth = mcpOauth)

        /** Replace the bearer token for the credential's MCP server. */
        @JvmStatic
        fun ofStaticBearer(staticBearer: StaticBearer) =
            CredentialAuthRotateParam(staticBearer = staticBearer)
    }

    /**
     * An interface that defines how to map each variant of [CredentialAuthRotateParam] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** Rotate an OAuth credential for an HTTPS MCP destination. */
        fun visitMcpOAuth(mcpOauth: McpOAuth): T

        /** Replace the bearer token for the credential's MCP server. */
        fun visitStaticBearer(staticBearer: StaticBearer): T

        /**
         * Maps an unknown variant of [CredentialAuthRotateParam] to a value of type [T].
         *
         * An instance of [CredentialAuthRotateParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown CredentialAuthRotateParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<CredentialAuthRotateParam>(CredentialAuthRotateParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): CredentialAuthRotateParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "mcp_oauth" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpOAuth>())?.let {
                        CredentialAuthRotateParam(mcpOauth = it, _json = json)
                    } ?: CredentialAuthRotateParam(_json = json)
                }
                "static_bearer" -> {
                    return tryDeserialize(node, jacksonTypeRef<StaticBearer>())?.let {
                        CredentialAuthRotateParam(staticBearer = it, _json = json)
                    } ?: CredentialAuthRotateParam(_json = json)
                }
            }

            return CredentialAuthRotateParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<CredentialAuthRotateParam>(CredentialAuthRotateParam::class) {

        override fun serialize(
            value: CredentialAuthRotateParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.mcpOauth != null -> generator.writeObject(value.mcpOauth)
                value.staticBearer != null -> generator.writeObject(value.staticBearer)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid CredentialAuthRotateParam")
            }
        }
    }

    /** Rotate an OAuth credential for an HTTPS MCP destination. */
    class McpOAuth
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val type: JsonValue,
        private val accessToken: JsonField<String>,
        private val expiresAt: JsonField<String>,
        private val refresh: JsonField<Refresh>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("access_token")
            @ExcludeMissing
            accessToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("refresh") @ExcludeMissing refresh: JsonField<Refresh> = JsonMissing.of(),
        ) : this(type, accessToken, expiresAt, refresh, mutableMapOf())

        /**
         * The type of the object. Always `mcp_oauth`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_oauth")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * A write-only replacement OAuth access token.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun accessToken(): Optional<String> = accessToken.getOptional("access_token")

        /**
         * The replacement expiry as an RFC 3339 timestamp, or `null` to clear it. Omitting this
         * field preserves the expiry unless a new access token is supplied, in which case the
         * expiry is cleared.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAt(): Optional<String> = expiresAt.getOptional("expires_at")

        /**
         * Updates to an MCP credential's existing OAuth refresh configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun refresh(): Optional<Refresh> = refresh.getOptional("refresh")

        /**
         * Returns the raw JSON value of [accessToken].
         *
         * Unlike [accessToken], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("access_token")
        @ExcludeMissing
        fun _accessToken(): JsonField<String> = accessToken

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<String> = expiresAt

        /**
         * Returns the raw JSON value of [refresh].
         *
         * Unlike [refresh], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("refresh") @ExcludeMissing fun _refresh(): JsonField<Refresh> = refresh

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

            /** Returns a mutable builder for constructing an instance of [McpOAuth]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpOAuth]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("mcp_oauth")
            private var accessToken: JsonField<String> = JsonMissing.of()
            private var expiresAt: JsonField<String> = JsonMissing.of()
            private var refresh: JsonField<Refresh> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpOAuth: McpOAuth) = apply {
                type = mcpOAuth.type
                accessToken = mcpOAuth.accessToken
                expiresAt = mcpOAuth.expiresAt
                refresh = mcpOAuth.refresh
                additionalProperties = mcpOAuth.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_oauth")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** A write-only replacement OAuth access token. */
            fun accessToken(accessToken: String?) = accessToken(JsonField.ofNullable(accessToken))

            /** Alias for calling [Builder.accessToken] with `accessToken.orElse(null)`. */
            fun accessToken(accessToken: Optional<String>) = accessToken(accessToken.getOrNull())

            /**
             * Sets [Builder.accessToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accessToken] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accessToken(accessToken: JsonField<String>) = apply {
                this.accessToken = accessToken
            }

            /**
             * The replacement expiry as an RFC 3339 timestamp, or `null` to clear it. Omitting this
             * field preserves the expiry unless a new access token is supplied, in which case the
             * expiry is cleared.
             */
            fun expiresAt(expiresAt: String?) = expiresAt(JsonField.ofNullable(expiresAt))

            /** Alias for calling [Builder.expiresAt] with `expiresAt.orElse(null)`. */
            fun expiresAt(expiresAt: Optional<String>) = expiresAt(expiresAt.getOrNull())

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<String>) = apply { this.expiresAt = expiresAt }

            /** Updates to an MCP credential's existing OAuth refresh configuration. */
            fun refresh(refresh: Refresh?) = refresh(JsonField.ofNullable(refresh))

            /** Alias for calling [Builder.refresh] with `refresh.orElse(null)`. */
            fun refresh(refresh: Optional<Refresh>) = refresh(refresh.getOrNull())

            /**
             * Sets [Builder.refresh] to an arbitrary JSON value.
             *
             * You should usually call [Builder.refresh] with a well-typed [Refresh] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun refresh(refresh: JsonField<Refresh>) = apply { this.refresh = refresh }

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
             * Returns an immutable instance of [McpOAuth].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): McpOAuth =
                McpOAuth(type, accessToken, expiresAt, refresh, additionalProperties.toMutableMap())
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
        fun validate(): McpOAuth = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("mcp_oauth")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            accessToken()
            expiresAt()
            refresh().ifPresent { it.validate() }
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
            type.let { if (it == JsonValue.from("mcp_oauth")) 1 else 0 } +
                (if (accessToken.asKnown().isPresent) 1 else 0) +
                (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (refresh.asKnown().getOrNull()?.validity() ?: 0)

        /** Updates to an MCP credential's existing OAuth refresh configuration. */
        class Refresh
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val refreshToken: JsonField<String>,
            private val scope: JsonField<String>,
            private val tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuthRotateParam>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("refresh_token")
                @ExcludeMissing
                refreshToken: JsonField<String> = JsonMissing.of(),
                @JsonProperty("scope") @ExcludeMissing scope: JsonField<String> = JsonMissing.of(),
                @JsonProperty("token_endpoint_auth")
                @ExcludeMissing
                tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuthRotateParam> =
                    JsonMissing.of(),
            ) : this(refreshToken, scope, tokenEndpointAuth, mutableMapOf())

            /**
             * The replacement refresh token. Omit or pass `null` to keep the stored token. This
             * secret is never returned in resources.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun refreshToken(): Optional<String> = refreshToken.getOptional("refresh_token")

            /**
             * Replacement space-separated OAuth scopes for refresh requests. Omit to keep the
             * scopes, or pass `null` to stop sending a scope parameter.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun scope(): Optional<String> = scope.getOptional("scope")

            /**
             * Client-secret updates that preserve the credential's OAuth authentication method.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun tokenEndpointAuth(): Optional<McpOAuthTokenEndpointAuthRotateParam> =
                tokenEndpointAuth.getOptional("token_endpoint_auth")

            /**
             * Returns the raw JSON value of [refreshToken].
             *
             * Unlike [refreshToken], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("refresh_token")
            @ExcludeMissing
            fun _refreshToken(): JsonField<String> = refreshToken

            /**
             * Returns the raw JSON value of [scope].
             *
             * Unlike [scope], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("scope") @ExcludeMissing fun _scope(): JsonField<String> = scope

            /**
             * Returns the raw JSON value of [tokenEndpointAuth].
             *
             * Unlike [tokenEndpointAuth], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("token_endpoint_auth")
            @ExcludeMissing
            fun _tokenEndpointAuth(): JsonField<McpOAuthTokenEndpointAuthRotateParam> =
                tokenEndpointAuth

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

                /** Returns a mutable builder for constructing an instance of [Refresh]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Refresh]. */
            class Builder internal constructor() {

                private var refreshToken: JsonField<String> = JsonMissing.of()
                private var scope: JsonField<String> = JsonMissing.of()
                private var tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuthRotateParam> =
                    JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(refresh: Refresh) = apply {
                    refreshToken = refresh.refreshToken
                    scope = refresh.scope
                    tokenEndpointAuth = refresh.tokenEndpointAuth
                    additionalProperties = refresh.additionalProperties.toMutableMap()
                }

                /**
                 * The replacement refresh token. Omit or pass `null` to keep the stored token. This
                 * secret is never returned in resources.
                 */
                fun refreshToken(refreshToken: String?) =
                    refreshToken(JsonField.ofNullable(refreshToken))

                /** Alias for calling [Builder.refreshToken] with `refreshToken.orElse(null)`. */
                fun refreshToken(refreshToken: Optional<String>) =
                    refreshToken(refreshToken.getOrNull())

                /**
                 * Sets [Builder.refreshToken] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.refreshToken] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun refreshToken(refreshToken: JsonField<String>) = apply {
                    this.refreshToken = refreshToken
                }

                /**
                 * Replacement space-separated OAuth scopes for refresh requests. Omit to keep the
                 * scopes, or pass `null` to stop sending a scope parameter.
                 */
                fun scope(scope: String?) = scope(JsonField.ofNullable(scope))

                /** Alias for calling [Builder.scope] with `scope.orElse(null)`. */
                fun scope(scope: Optional<String>) = scope(scope.getOrNull())

                /**
                 * Sets [Builder.scope] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.scope] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun scope(scope: JsonField<String>) = apply { this.scope = scope }

                /**
                 * Client-secret updates that preserve the credential's OAuth authentication method.
                 */
                fun tokenEndpointAuth(tokenEndpointAuth: McpOAuthTokenEndpointAuthRotateParam?) =
                    tokenEndpointAuth(JsonField.ofNullable(tokenEndpointAuth))

                /**
                 * Alias for calling [Builder.tokenEndpointAuth] with
                 * `tokenEndpointAuth.orElse(null)`.
                 */
                fun tokenEndpointAuth(
                    tokenEndpointAuth: Optional<McpOAuthTokenEndpointAuthRotateParam>
                ) = tokenEndpointAuth(tokenEndpointAuth.getOrNull())

                /**
                 * Sets [Builder.tokenEndpointAuth] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tokenEndpointAuth] with a well-typed
                 * [McpOAuthTokenEndpointAuthRotateParam] value instead. This method is primarily
                 * for setting the field to an undocumented or not yet supported value.
                 */
                fun tokenEndpointAuth(
                    tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuthRotateParam>
                ) = apply { this.tokenEndpointAuth = tokenEndpointAuth }

                /**
                 * Alias for calling [tokenEndpointAuth] with
                 * `McpOAuthTokenEndpointAuthRotateParam.ofClientSecretBasic(clientSecretBasic)`.
                 */
                fun tokenEndpointAuth(
                    clientSecretBasic: McpOAuthTokenEndpointAuthRotateParam.ClientSecretBasic
                ) =
                    tokenEndpointAuth(
                        McpOAuthTokenEndpointAuthRotateParam.ofClientSecretBasic(clientSecretBasic)
                    )

                /**
                 * Alias for calling [tokenEndpointAuth] with
                 * `McpOAuthTokenEndpointAuthRotateParam.ofClientSecretPost(clientSecretPost)`.
                 */
                fun tokenEndpointAuth(
                    clientSecretPost: McpOAuthTokenEndpointAuthRotateParam.ClientSecretPost
                ) =
                    tokenEndpointAuth(
                        McpOAuthTokenEndpointAuthRotateParam.ofClientSecretPost(clientSecretPost)
                    )

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Refresh].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Refresh =
                    Refresh(
                        refreshToken,
                        scope,
                        tokenEndpointAuth,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Refresh = apply {
                if (validated) {
                    return@apply
                }

                refreshToken()
                scope()
                tokenEndpointAuth().ifPresent { it.validate() }
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
                (if (refreshToken.asKnown().isPresent) 1 else 0) +
                    (if (scope.asKnown().isPresent) 1 else 0) +
                    (tokenEndpointAuth.asKnown().getOrNull()?.validity() ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Refresh &&
                    refreshToken == other.refreshToken &&
                    scope == other.scope &&
                    tokenEndpointAuth == other.tokenEndpointAuth &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(refreshToken, scope, tokenEndpointAuth, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Refresh{refreshToken=$refreshToken, scope=$scope, tokenEndpointAuth=$tokenEndpointAuth, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpOAuth &&
                type == other.type &&
                accessToken == other.accessToken &&
                expiresAt == other.expiresAt &&
                refresh == other.refresh &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(type, accessToken, expiresAt, refresh, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpOAuth{type=$type, accessToken=$accessToken, expiresAt=$expiresAt, refresh=$refresh, additionalProperties=$additionalProperties}"
    }

    /** Replace the bearer token for the credential's MCP server. */
    class StaticBearer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val token: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(token, type, mutableMapOf())

        /**
         * The replacement bearer token. This secret is never returned in credential resources.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun token(): String = token.getRequired("token")

        /**
         * The type of the object. Always `static_bearer`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("static_bearer")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [token].
         *
         * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

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
             * Returns a mutable builder for constructing an instance of [StaticBearer].
             *
             * The following fields are required:
             * ```java
             * .token()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [StaticBearer]. */
        class Builder internal constructor() {

            private var token: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("static_bearer")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(staticBearer: StaticBearer) = apply {
                token = staticBearer.token
                type = staticBearer.type
                additionalProperties = staticBearer.additionalProperties.toMutableMap()
            }

            /**
             * The replacement bearer token. This secret is never returned in credential resources.
             */
            fun token(token: String) = token(JsonField.of(token))

            /**
             * Sets [Builder.token] to an arbitrary JSON value.
             *
             * You should usually call [Builder.token] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun token(token: JsonField<String>) = apply { this.token = token }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("static_bearer")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [StaticBearer].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .token()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): StaticBearer =
                StaticBearer(
                    checkRequired("token", token),
                    type,
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
        fun validate(): StaticBearer = apply {
            if (validated) {
                return@apply
            }

            token()
            _type().let {
                if (it != JsonValue.from("static_bearer")) {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (token.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("static_bearer")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is StaticBearer &&
                token == other.token &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(token, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "StaticBearer{token=$token, type=$type, additionalProperties=$additionalProperties}"
    }
}
