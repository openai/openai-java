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

/** Authentication credentials for an MCP server used by agent tools. */
@JsonDeserialize(using = CredentialAuthCreateParam.Deserializer::class)
@JsonSerialize(using = CredentialAuthCreateParam.Serializer::class)
class CredentialAuthCreateParam
private constructor(
    private val mcpOauth: McpOAuth? = null,
    private val staticBearer: StaticBearer? = null,
    private val _json: JsonValue? = null,
) {

    /** An OAuth credential for an HTTPS MCP destination. */
    fun mcpOauth(): Optional<McpOAuth> = Optional.ofNullable(mcpOauth)

    /** A bearer token for an MCP server, without automatic OAuth refresh. */
    fun staticBearer(): Optional<StaticBearer> = Optional.ofNullable(staticBearer)

    fun isMcpOAuth(): Boolean = mcpOauth != null

    fun isStaticBearer(): Boolean = staticBearer != null

    /** An OAuth credential for an HTTPS MCP destination. */
    fun asMcpOAuth(): McpOAuth = mcpOauth.getOrThrow("mcpOauth")

    /** A bearer token for an MCP server, without automatic OAuth refresh. */
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
     * Optional<String> result = credentialAuthCreateParam.accept(new CredentialAuthCreateParam.Visitor<Optional<String>>() {
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
    fun validate(): CredentialAuthCreateParam = apply {
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

        return other is CredentialAuthCreateParam &&
            mcpOauth == other.mcpOauth &&
            staticBearer == other.staticBearer
    }

    override fun hashCode(): Int = Objects.hash(mcpOauth, staticBearer)

    override fun toString(): String =
        when {
            mcpOauth != null -> "CredentialAuthCreateParam{mcpOauth=$mcpOauth}"
            staticBearer != null -> "CredentialAuthCreateParam{staticBearer=$staticBearer}"
            _json != null -> "CredentialAuthCreateParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid CredentialAuthCreateParam")
        }

    companion object {

        /** An OAuth credential for an HTTPS MCP destination. */
        @JvmStatic
        fun ofMcpOAuth(mcpOauth: McpOAuth) = CredentialAuthCreateParam(mcpOauth = mcpOauth)

        /** A bearer token for an MCP server, without automatic OAuth refresh. */
        @JvmStatic
        fun ofStaticBearer(staticBearer: StaticBearer) =
            CredentialAuthCreateParam(staticBearer = staticBearer)
    }

    /**
     * An interface that defines how to map each variant of [CredentialAuthCreateParam] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** An OAuth credential for an HTTPS MCP destination. */
        fun visitMcpOAuth(mcpOauth: McpOAuth): T

        /** A bearer token for an MCP server, without automatic OAuth refresh. */
        fun visitStaticBearer(staticBearer: StaticBearer): T

        /**
         * Maps an unknown variant of [CredentialAuthCreateParam] to a value of type [T].
         *
         * An instance of [CredentialAuthCreateParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown CredentialAuthCreateParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<CredentialAuthCreateParam>(CredentialAuthCreateParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): CredentialAuthCreateParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "mcp_oauth" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpOAuth>())?.let {
                        CredentialAuthCreateParam(mcpOauth = it, _json = json)
                    } ?: CredentialAuthCreateParam(_json = json)
                }
                "static_bearer" -> {
                    return tryDeserialize(node, jacksonTypeRef<StaticBearer>())?.let {
                        CredentialAuthCreateParam(staticBearer = it, _json = json)
                    } ?: CredentialAuthCreateParam(_json = json)
                }
            }

            return CredentialAuthCreateParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<CredentialAuthCreateParam>(CredentialAuthCreateParam::class) {

        override fun serialize(
            value: CredentialAuthCreateParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.mcpOauth != null -> generator.writeObject(value.mcpOauth)
                value.staticBearer != null -> generator.writeObject(value.staticBearer)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid CredentialAuthCreateParam")
            }
        }
    }

    /** An OAuth credential for an HTTPS MCP destination. */
    class McpOAuth
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val accessToken: JsonField<String>,
        private val mcpServerUrl: JsonField<String>,
        private val type: JsonValue,
        private val expiresAt: JsonField<String>,
        private val refresh: JsonField<Refresh>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("access_token")
            @ExcludeMissing
            accessToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mcp_server_url")
            @ExcludeMissing
            mcpServerUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("refresh") @ExcludeMissing refresh: JsonField<Refresh> = JsonMissing.of(),
        ) : this(accessToken, mcpServerUrl, type, expiresAt, refresh, mutableMapOf())

        /**
         * A write-only OAuth access token; never returned by credential resources.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun accessToken(): String = accessToken.getRequired("access_token")

        /**
         * The HTTPS MCP server URL authorized by this credential.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun mcpServerUrl(): String = mcpServerUrl.getRequired("mcp_server_url")

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
         * When the OAuth access token expires, as an RFC 3339 timestamp, if known.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAt(): Optional<String> = expiresAt.getOptional("expires_at")

        /**
         * Configuration for refreshing the access token of an MCP OAuth credential.
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
         * Returns the raw JSON value of [mcpServerUrl].
         *
         * Unlike [mcpServerUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("mcp_server_url")
        @ExcludeMissing
        fun _mcpServerUrl(): JsonField<String> = mcpServerUrl

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

            /**
             * Returns a mutable builder for constructing an instance of [McpOAuth].
             *
             * The following fields are required:
             * ```java
             * .accessToken()
             * .mcpServerUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpOAuth]. */
        class Builder internal constructor() {

            private var accessToken: JsonField<String>? = null
            private var mcpServerUrl: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("mcp_oauth")
            private var expiresAt: JsonField<String> = JsonMissing.of()
            private var refresh: JsonField<Refresh> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpOAuth: McpOAuth) = apply {
                accessToken = mcpOAuth.accessToken
                mcpServerUrl = mcpOAuth.mcpServerUrl
                type = mcpOAuth.type
                expiresAt = mcpOAuth.expiresAt
                refresh = mcpOAuth.refresh
                additionalProperties = mcpOAuth.additionalProperties.toMutableMap()
            }

            /** A write-only OAuth access token; never returned by credential resources. */
            fun accessToken(accessToken: String) = accessToken(JsonField.of(accessToken))

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

            /** The HTTPS MCP server URL authorized by this credential. */
            fun mcpServerUrl(mcpServerUrl: String) = mcpServerUrl(JsonField.of(mcpServerUrl))

            /**
             * Sets [Builder.mcpServerUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mcpServerUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mcpServerUrl(mcpServerUrl: JsonField<String>) = apply {
                this.mcpServerUrl = mcpServerUrl
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

            /** When the OAuth access token expires, as an RFC 3339 timestamp, if known. */
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

            /** Configuration for refreshing the access token of an MCP OAuth credential. */
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
             *
             * The following fields are required:
             * ```java
             * .accessToken()
             * .mcpServerUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpOAuth =
                McpOAuth(
                    checkRequired("accessToken", accessToken),
                    checkRequired("mcpServerUrl", mcpServerUrl),
                    type,
                    expiresAt,
                    refresh,
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
        fun validate(): McpOAuth = apply {
            if (validated) {
                return@apply
            }

            accessToken()
            mcpServerUrl()
            _type().let {
                if (it != JsonValue.from("mcp_oauth")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (accessToken.asKnown().isPresent) 1 else 0) +
                (if (mcpServerUrl.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp_oauth")) 1 else 0 } +
                (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (refresh.asKnown().getOrNull()?.validity() ?: 0)

        /** Configuration for refreshing the access token of an MCP OAuth credential. */
        class Refresh
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val clientId: JsonField<String>,
            private val refreshToken: JsonField<String>,
            private val tokenEndpoint: JsonField<String>,
            private val tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuthCreateParam>,
            private val resource: JsonField<String>,
            private val scope: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("client_id")
                @ExcludeMissing
                clientId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("refresh_token")
                @ExcludeMissing
                refreshToken: JsonField<String> = JsonMissing.of(),
                @JsonProperty("token_endpoint")
                @ExcludeMissing
                tokenEndpoint: JsonField<String> = JsonMissing.of(),
                @JsonProperty("token_endpoint_auth")
                @ExcludeMissing
                tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuthCreateParam> =
                    JsonMissing.of(),
                @JsonProperty("resource")
                @ExcludeMissing
                resource: JsonField<String> = JsonMissing.of(),
                @JsonProperty("scope") @ExcludeMissing scope: JsonField<String> = JsonMissing.of(),
            ) : this(
                clientId,
                refreshToken,
                tokenEndpoint,
                tokenEndpointAuth,
                resource,
                scope,
                mutableMapOf(),
            )

            /**
             * The OAuth client ID used when requesting a new access token.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun clientId(): String = clientId.getRequired("client_id")

            /**
             * The refresh token to store. This secret is never returned in credential resources.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun refreshToken(): String = refreshToken.getRequired("refresh_token")

            /**
             * The HTTPS OAuth token endpoint used to exchange the refresh token for a new access
             * token.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tokenEndpoint(): String = tokenEndpoint.getRequired("token_endpoint")

            /**
             * How the OAuth client authenticates to the token endpoint.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tokenEndpointAuth(): McpOAuthTokenEndpointAuthCreateParam =
                tokenEndpointAuth.getRequired("token_endpoint_auth")

            /**
             * The resource URI to send to the OAuth token endpoint during refresh, if required.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun resource(): Optional<String> = resource.getOptional("resource")

            /**
             * Space-separated OAuth scopes to request during refresh, if required.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun scope(): Optional<String> = scope.getOptional("scope")

            /**
             * Returns the raw JSON value of [clientId].
             *
             * Unlike [clientId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("client_id") @ExcludeMissing fun _clientId(): JsonField<String> = clientId

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
             * Returns the raw JSON value of [tokenEndpoint].
             *
             * Unlike [tokenEndpoint], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("token_endpoint")
            @ExcludeMissing
            fun _tokenEndpoint(): JsonField<String> = tokenEndpoint

            /**
             * Returns the raw JSON value of [tokenEndpointAuth].
             *
             * Unlike [tokenEndpointAuth], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("token_endpoint_auth")
            @ExcludeMissing
            fun _tokenEndpointAuth(): JsonField<McpOAuthTokenEndpointAuthCreateParam> =
                tokenEndpointAuth

            /**
             * Returns the raw JSON value of [resource].
             *
             * Unlike [resource], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("resource") @ExcludeMissing fun _resource(): JsonField<String> = resource

            /**
             * Returns the raw JSON value of [scope].
             *
             * Unlike [scope], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("scope") @ExcludeMissing fun _scope(): JsonField<String> = scope

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
                 * Returns a mutable builder for constructing an instance of [Refresh].
                 *
                 * The following fields are required:
                 * ```java
                 * .clientId()
                 * .refreshToken()
                 * .tokenEndpoint()
                 * .tokenEndpointAuth()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Refresh]. */
            class Builder internal constructor() {

                private var clientId: JsonField<String>? = null
                private var refreshToken: JsonField<String>? = null
                private var tokenEndpoint: JsonField<String>? = null
                private var tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuthCreateParam>? =
                    null
                private var resource: JsonField<String> = JsonMissing.of()
                private var scope: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(refresh: Refresh) = apply {
                    clientId = refresh.clientId
                    refreshToken = refresh.refreshToken
                    tokenEndpoint = refresh.tokenEndpoint
                    tokenEndpointAuth = refresh.tokenEndpointAuth
                    resource = refresh.resource
                    scope = refresh.scope
                    additionalProperties = refresh.additionalProperties.toMutableMap()
                }

                /** The OAuth client ID used when requesting a new access token. */
                fun clientId(clientId: String) = clientId(JsonField.of(clientId))

                /**
                 * Sets [Builder.clientId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.clientId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun clientId(clientId: JsonField<String>) = apply { this.clientId = clientId }

                /**
                 * The refresh token to store. This secret is never returned in credential
                 * resources.
                 */
                fun refreshToken(refreshToken: String) = refreshToken(JsonField.of(refreshToken))

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
                 * The HTTPS OAuth token endpoint used to exchange the refresh token for a new
                 * access token.
                 */
                fun tokenEndpoint(tokenEndpoint: String) =
                    tokenEndpoint(JsonField.of(tokenEndpoint))

                /**
                 * Sets [Builder.tokenEndpoint] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tokenEndpoint] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tokenEndpoint(tokenEndpoint: JsonField<String>) = apply {
                    this.tokenEndpoint = tokenEndpoint
                }

                /** How the OAuth client authenticates to the token endpoint. */
                fun tokenEndpointAuth(tokenEndpointAuth: McpOAuthTokenEndpointAuthCreateParam) =
                    tokenEndpointAuth(JsonField.of(tokenEndpointAuth))

                /**
                 * Sets [Builder.tokenEndpointAuth] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tokenEndpointAuth] with a well-typed
                 * [McpOAuthTokenEndpointAuthCreateParam] value instead. This method is primarily
                 * for setting the field to an undocumented or not yet supported value.
                 */
                fun tokenEndpointAuth(
                    tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuthCreateParam>
                ) = apply { this.tokenEndpointAuth = tokenEndpointAuth }

                /**
                 * Alias for calling [tokenEndpointAuth] with
                 * `McpOAuthTokenEndpointAuthCreateParam.ofNone()`.
                 */
                fun tokenEndpointAuthNone() =
                    tokenEndpointAuth(McpOAuthTokenEndpointAuthCreateParam.ofNone())

                /**
                 * Alias for calling [tokenEndpointAuth] with
                 * `McpOAuthTokenEndpointAuthCreateParam.ofClientSecretBasic(clientSecretBasic)`.
                 */
                fun tokenEndpointAuth(
                    clientSecretBasic: McpOAuthTokenEndpointAuthCreateParam.ClientSecretBasic
                ) =
                    tokenEndpointAuth(
                        McpOAuthTokenEndpointAuthCreateParam.ofClientSecretBasic(clientSecretBasic)
                    )

                /**
                 * Alias for calling [tokenEndpointAuth] with the following:
                 * ```java
                 * McpOAuthTokenEndpointAuthCreateParam.ClientSecretBasic.builder()
                 *     .clientSecret(clientSecret)
                 *     .build()
                 * ```
                 */
                fun clientSecretBasicTokenEndpointAuth(clientSecret: String) =
                    tokenEndpointAuth(
                        McpOAuthTokenEndpointAuthCreateParam.ClientSecretBasic.builder()
                            .clientSecret(clientSecret)
                            .build()
                    )

                /**
                 * Alias for calling [tokenEndpointAuth] with
                 * `McpOAuthTokenEndpointAuthCreateParam.ofClientSecretPost(clientSecretPost)`.
                 */
                fun tokenEndpointAuth(
                    clientSecretPost: McpOAuthTokenEndpointAuthCreateParam.ClientSecretPost
                ) =
                    tokenEndpointAuth(
                        McpOAuthTokenEndpointAuthCreateParam.ofClientSecretPost(clientSecretPost)
                    )

                /**
                 * Alias for calling [tokenEndpointAuth] with the following:
                 * ```java
                 * McpOAuthTokenEndpointAuthCreateParam.ClientSecretPost.builder()
                 *     .clientSecret(clientSecret)
                 *     .build()
                 * ```
                 */
                fun clientSecretPostTokenEndpointAuth(clientSecret: String) =
                    tokenEndpointAuth(
                        McpOAuthTokenEndpointAuthCreateParam.ClientSecretPost.builder()
                            .clientSecret(clientSecret)
                            .build()
                    )

                /**
                 * The resource URI to send to the OAuth token endpoint during refresh, if required.
                 */
                fun resource(resource: String?) = resource(JsonField.ofNullable(resource))

                /** Alias for calling [Builder.resource] with `resource.orElse(null)`. */
                fun resource(resource: Optional<String>) = resource(resource.getOrNull())

                /**
                 * Sets [Builder.resource] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.resource] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun resource(resource: JsonField<String>) = apply { this.resource = resource }

                /** Space-separated OAuth scopes to request during refresh, if required. */
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
                 *
                 * The following fields are required:
                 * ```java
                 * .clientId()
                 * .refreshToken()
                 * .tokenEndpoint()
                 * .tokenEndpointAuth()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Refresh =
                    Refresh(
                        checkRequired("clientId", clientId),
                        checkRequired("refreshToken", refreshToken),
                        checkRequired("tokenEndpoint", tokenEndpoint),
                        checkRequired("tokenEndpointAuth", tokenEndpointAuth),
                        resource,
                        scope,
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

                clientId()
                refreshToken()
                tokenEndpoint()
                tokenEndpointAuth().validate()
                resource()
                scope()
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
                (if (clientId.asKnown().isPresent) 1 else 0) +
                    (if (refreshToken.asKnown().isPresent) 1 else 0) +
                    (if (tokenEndpoint.asKnown().isPresent) 1 else 0) +
                    (tokenEndpointAuth.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (resource.asKnown().isPresent) 1 else 0) +
                    (if (scope.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Refresh &&
                    clientId == other.clientId &&
                    refreshToken == other.refreshToken &&
                    tokenEndpoint == other.tokenEndpoint &&
                    tokenEndpointAuth == other.tokenEndpointAuth &&
                    resource == other.resource &&
                    scope == other.scope &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    clientId,
                    refreshToken,
                    tokenEndpoint,
                    tokenEndpointAuth,
                    resource,
                    scope,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Refresh{clientId=$clientId, refreshToken=$refreshToken, tokenEndpoint=$tokenEndpoint, tokenEndpointAuth=$tokenEndpointAuth, resource=$resource, scope=$scope, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpOAuth &&
                accessToken == other.accessToken &&
                mcpServerUrl == other.mcpServerUrl &&
                type == other.type &&
                expiresAt == other.expiresAt &&
                refresh == other.refresh &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(accessToken, mcpServerUrl, type, expiresAt, refresh, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpOAuth{accessToken=$accessToken, mcpServerUrl=$mcpServerUrl, type=$type, expiresAt=$expiresAt, refresh=$refresh, additionalProperties=$additionalProperties}"
    }

    /** A bearer token for an MCP server, without automatic OAuth refresh. */
    class StaticBearer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val token: JsonField<String>,
        private val mcpServerUrl: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mcp_server_url")
            @ExcludeMissing
            mcpServerUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(token, mcpServerUrl, type, mutableMapOf())

        /**
         * The bearer token to store. This secret is never returned in credential resources.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun token(): String = token.getRequired("token")

        /**
         * The HTTPS MCP server URL authorized by this credential.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun mcpServerUrl(): String = mcpServerUrl.getRequired("mcp_server_url")

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

        /**
         * Returns the raw JSON value of [mcpServerUrl].
         *
         * Unlike [mcpServerUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("mcp_server_url")
        @ExcludeMissing
        fun _mcpServerUrl(): JsonField<String> = mcpServerUrl

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
             * .mcpServerUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [StaticBearer]. */
        class Builder internal constructor() {

            private var token: JsonField<String>? = null
            private var mcpServerUrl: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("static_bearer")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(staticBearer: StaticBearer) = apply {
                token = staticBearer.token
                mcpServerUrl = staticBearer.mcpServerUrl
                type = staticBearer.type
                additionalProperties = staticBearer.additionalProperties.toMutableMap()
            }

            /** The bearer token to store. This secret is never returned in credential resources. */
            fun token(token: String) = token(JsonField.of(token))

            /**
             * Sets [Builder.token] to an arbitrary JSON value.
             *
             * You should usually call [Builder.token] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun token(token: JsonField<String>) = apply { this.token = token }

            /** The HTTPS MCP server URL authorized by this credential. */
            fun mcpServerUrl(mcpServerUrl: String) = mcpServerUrl(JsonField.of(mcpServerUrl))

            /**
             * Sets [Builder.mcpServerUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mcpServerUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mcpServerUrl(mcpServerUrl: JsonField<String>) = apply {
                this.mcpServerUrl = mcpServerUrl
            }

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
             * .mcpServerUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): StaticBearer =
                StaticBearer(
                    checkRequired("token", token),
                    checkRequired("mcpServerUrl", mcpServerUrl),
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
            mcpServerUrl()
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
                (if (mcpServerUrl.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("static_bearer")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is StaticBearer &&
                token == other.token &&
                mcpServerUrl == other.mcpServerUrl &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(token, mcpServerUrl, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "StaticBearer{token=$token, mcpServerUrl=$mcpServerUrl, type=$type, additionalProperties=$additionalProperties}"
    }
}
