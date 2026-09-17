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

/** The MCP server and authentication configuration of a vault credential, excluding secrets. */
@JsonDeserialize(using = CredentialAuth.Deserializer::class)
@JsonSerialize(using = CredentialAuth.Serializer::class)
class CredentialAuth
private constructor(
    private val mcpO: McpOAuth? = null,
    private val staticBearer: StaticBearer? = null,
    private val _json: JsonValue? = null,
) {

    /** Public metadata for an OAuth credential; tokens and client secrets are never returned. */
    fun mcpO(): Optional<McpOAuth> = Optional.ofNullable(mcpO)

    /** Metadata for a bearer-token credential, without automatic OAuth refresh. */
    fun staticBearer(): Optional<StaticBearer> = Optional.ofNullable(staticBearer)

    fun isMcpO(): Boolean = mcpO != null

    fun isStaticBearer(): Boolean = staticBearer != null

    /** Public metadata for an OAuth credential; tokens and client secrets are never returned. */
    fun asMcpO(): McpOAuth = mcpO.getOrThrow("mcpO")

    /** Metadata for a bearer-token credential, without automatic OAuth refresh. */
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
     * Optional<String> result = credentialAuth.accept(new CredentialAuth.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitMcpO(McpOAuth mcpO) {
     *         return Optional.of(mcpO.toString());
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
            mcpO != null -> visitor.visitMcpO(mcpO)
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
    fun validate(): CredentialAuth = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitMcpO(mcpO: McpOAuth) {
                    mcpO.validate()
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
                override fun visitMcpO(mcpO: McpOAuth) = mcpO.validity()

                override fun visitStaticBearer(staticBearer: StaticBearer) = staticBearer.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CredentialAuth && mcpO == other.mcpO && staticBearer == other.staticBearer
    }

    override fun hashCode(): Int = Objects.hash(mcpO, staticBearer)

    override fun toString(): String =
        when {
            mcpO != null -> "CredentialAuth{mcpO=$mcpO}"
            staticBearer != null -> "CredentialAuth{staticBearer=$staticBearer}"
            _json != null -> "CredentialAuth{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid CredentialAuth")
        }

    companion object {

        /**
         * Public metadata for an OAuth credential; tokens and client secrets are never returned.
         */
        @JvmStatic fun ofMcpO(mcpO: McpOAuth) = CredentialAuth(mcpO = mcpO)

        /** Metadata for a bearer-token credential, without automatic OAuth refresh. */
        @JvmStatic
        fun ofStaticBearer(staticBearer: StaticBearer) = CredentialAuth(staticBearer = staticBearer)
    }

    /**
     * An interface that defines how to map each variant of [CredentialAuth] to a value of type [T].
     */
    interface Visitor<out T> {

        /**
         * Public metadata for an OAuth credential; tokens and client secrets are never returned.
         */
        fun visitMcpO(mcpO: McpOAuth): T

        /** Metadata for a bearer-token credential, without automatic OAuth refresh. */
        fun visitStaticBearer(staticBearer: StaticBearer): T

        /**
         * Maps an unknown variant of [CredentialAuth] to a value of type [T].
         *
         * An instance of [CredentialAuth] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown CredentialAuth: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<CredentialAuth>(CredentialAuth::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): CredentialAuth {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "mcp_oauth" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpOAuth>())?.let {
                        CredentialAuth(mcpO = it, _json = json)
                    } ?: CredentialAuth(_json = json)
                }
                "static_bearer" -> {
                    return tryDeserialize(node, jacksonTypeRef<StaticBearer>())?.let {
                        CredentialAuth(staticBearer = it, _json = json)
                    } ?: CredentialAuth(_json = json)
                }
            }

            return CredentialAuth(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<CredentialAuth>(CredentialAuth::class) {

        override fun serialize(
            value: CredentialAuth,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.mcpO != null -> generator.writeObject(value.mcpO)
                value.staticBearer != null -> generator.writeObject(value.staticBearer)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid CredentialAuth")
            }
        }
    }

    /** Public metadata for an OAuth credential; tokens and client secrets are never returned. */
    class McpOAuth
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val expiresAt: JsonField<String>,
        private val mcpServerUrl: JsonField<String>,
        private val refresh: JsonField<Refresh>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mcp_server_url")
            @ExcludeMissing
            mcpServerUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("refresh") @ExcludeMissing refresh: JsonField<Refresh> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(expiresAt, mcpServerUrl, refresh, type, mutableMapOf())

        /**
         * When the OAuth access token expires, as an RFC 3339 timestamp, if known.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAt(): Optional<String> = expiresAt.getOptional("expires_at")

        /**
         * The HTTPS MCP server URL authorized by this credential.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun mcpServerUrl(): String = mcpServerUrl.getRequired("mcp_server_url")

        /**
         * Configuration used to refresh an MCP OAuth access token, excluding secret values.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun refresh(): Optional<Refresh> = refresh.getOptional("refresh")

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
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<String> = expiresAt

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
             * .expiresAt()
             * .mcpServerUrl()
             * .refresh()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpOAuth]. */
        class Builder internal constructor() {

            private var expiresAt: JsonField<String>? = null
            private var mcpServerUrl: JsonField<String>? = null
            private var refresh: JsonField<Refresh>? = null
            private var type: JsonValue = JsonValue.from("mcp_oauth")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpOAuth: McpOAuth) = apply {
                expiresAt = mcpOAuth.expiresAt
                mcpServerUrl = mcpOAuth.mcpServerUrl
                refresh = mcpOAuth.refresh
                type = mcpOAuth.type
                additionalProperties = mcpOAuth.additionalProperties.toMutableMap()
            }

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

            /** Configuration used to refresh an MCP OAuth access token, excluding secret values. */
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
             * .expiresAt()
             * .mcpServerUrl()
             * .refresh()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpOAuth =
                McpOAuth(
                    checkRequired("expiresAt", expiresAt),
                    checkRequired("mcpServerUrl", mcpServerUrl),
                    checkRequired("refresh", refresh),
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
        fun validate(): McpOAuth = apply {
            if (validated) {
                return@apply
            }

            expiresAt()
            mcpServerUrl()
            refresh().ifPresent { it.validate() }
            _type().let {
                if (it != JsonValue.from("mcp_oauth")) {
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
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (if (mcpServerUrl.asKnown().isPresent) 1 else 0) +
                (refresh.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("mcp_oauth")) 1 else 0 }

        /** Configuration used to refresh an MCP OAuth access token, excluding secret values. */
        class Refresh
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val clientId: JsonField<String>,
            private val resource: JsonField<String>,
            private val scope: JsonField<String>,
            private val tokenEndpoint: JsonField<String>,
            private val tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuth>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("client_id")
                @ExcludeMissing
                clientId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("resource")
                @ExcludeMissing
                resource: JsonField<String> = JsonMissing.of(),
                @JsonProperty("scope") @ExcludeMissing scope: JsonField<String> = JsonMissing.of(),
                @JsonProperty("token_endpoint")
                @ExcludeMissing
                tokenEndpoint: JsonField<String> = JsonMissing.of(),
                @JsonProperty("token_endpoint_auth")
                @ExcludeMissing
                tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuth> = JsonMissing.of(),
            ) : this(clientId, resource, scope, tokenEndpoint, tokenEndpointAuth, mutableMapOf())

            /**
             * The OAuth client ID used when requesting a new access token.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun clientId(): String = clientId.getRequired("client_id")

            /**
             * The resource URI sent to the OAuth token endpoint during refresh, if configured.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun resource(): Optional<String> = resource.getOptional("resource")

            /**
             * Space-separated OAuth scopes requested during refresh, if configured.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun scope(): Optional<String> = scope.getOptional("scope")

            /**
             * The HTTPS OAuth token endpoint used for refresh.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tokenEndpoint(): String = tokenEndpoint.getRequired("token_endpoint")

            /**
             * How the OAuth client authenticates to the token endpoint, excluding its client
             * secret.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tokenEndpointAuth(): McpOAuthTokenEndpointAuth =
                tokenEndpointAuth.getRequired("token_endpoint_auth")

            /**
             * Returns the raw JSON value of [clientId].
             *
             * Unlike [clientId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("client_id") @ExcludeMissing fun _clientId(): JsonField<String> = clientId

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
            fun _tokenEndpointAuth(): JsonField<McpOAuthTokenEndpointAuth> = tokenEndpointAuth

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
                 * .resource()
                 * .scope()
                 * .tokenEndpoint()
                 * .tokenEndpointAuth()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Refresh]. */
            class Builder internal constructor() {

                private var clientId: JsonField<String>? = null
                private var resource: JsonField<String>? = null
                private var scope: JsonField<String>? = null
                private var tokenEndpoint: JsonField<String>? = null
                private var tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuth>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(refresh: Refresh) = apply {
                    clientId = refresh.clientId
                    resource = refresh.resource
                    scope = refresh.scope
                    tokenEndpoint = refresh.tokenEndpoint
                    tokenEndpointAuth = refresh.tokenEndpointAuth
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
                 * The resource URI sent to the OAuth token endpoint during refresh, if configured.
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

                /** Space-separated OAuth scopes requested during refresh, if configured. */
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

                /** The HTTPS OAuth token endpoint used for refresh. */
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

                /**
                 * How the OAuth client authenticates to the token endpoint, excluding its client
                 * secret.
                 */
                fun tokenEndpointAuth(tokenEndpointAuth: McpOAuthTokenEndpointAuth) =
                    tokenEndpointAuth(JsonField.of(tokenEndpointAuth))

                /**
                 * Sets [Builder.tokenEndpointAuth] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tokenEndpointAuth] with a well-typed
                 * [McpOAuthTokenEndpointAuth] value instead. This method is primarily for setting
                 * the field to an undocumented or not yet supported value.
                 */
                fun tokenEndpointAuth(tokenEndpointAuth: JsonField<McpOAuthTokenEndpointAuth>) =
                    apply {
                        this.tokenEndpointAuth = tokenEndpointAuth
                    }

                /**
                 * Alias for calling [tokenEndpointAuth] with `McpOAuthTokenEndpointAuth.ofNone()`.
                 */
                fun tokenEndpointAuthNone() = tokenEndpointAuth(McpOAuthTokenEndpointAuth.ofNone())

                /**
                 * Alias for calling [tokenEndpointAuth] with
                 * `McpOAuthTokenEndpointAuth.ofClientSecretBasic()`.
                 */
                fun tokenEndpointAuthClientSecretBasic() =
                    tokenEndpointAuth(McpOAuthTokenEndpointAuth.ofClientSecretBasic())

                /**
                 * Alias for calling [tokenEndpointAuth] with
                 * `McpOAuthTokenEndpointAuth.ofClientSecretPost()`.
                 */
                fun tokenEndpointAuthClientSecretPost() =
                    tokenEndpointAuth(McpOAuthTokenEndpointAuth.ofClientSecretPost())

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
                 * .resource()
                 * .scope()
                 * .tokenEndpoint()
                 * .tokenEndpointAuth()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Refresh =
                    Refresh(
                        checkRequired("clientId", clientId),
                        checkRequired("resource", resource),
                        checkRequired("scope", scope),
                        checkRequired("tokenEndpoint", tokenEndpoint),
                        checkRequired("tokenEndpointAuth", tokenEndpointAuth),
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
                resource()
                scope()
                tokenEndpoint()
                tokenEndpointAuth().validate()
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
                    (if (resource.asKnown().isPresent) 1 else 0) +
                    (if (scope.asKnown().isPresent) 1 else 0) +
                    (if (tokenEndpoint.asKnown().isPresent) 1 else 0) +
                    (tokenEndpointAuth.asKnown().getOrNull()?.validity() ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Refresh &&
                    clientId == other.clientId &&
                    resource == other.resource &&
                    scope == other.scope &&
                    tokenEndpoint == other.tokenEndpoint &&
                    tokenEndpointAuth == other.tokenEndpointAuth &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    clientId,
                    resource,
                    scope,
                    tokenEndpoint,
                    tokenEndpointAuth,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Refresh{clientId=$clientId, resource=$resource, scope=$scope, tokenEndpoint=$tokenEndpoint, tokenEndpointAuth=$tokenEndpointAuth, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpOAuth &&
                expiresAt == other.expiresAt &&
                mcpServerUrl == other.mcpServerUrl &&
                refresh == other.refresh &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(expiresAt, mcpServerUrl, refresh, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpOAuth{expiresAt=$expiresAt, mcpServerUrl=$mcpServerUrl, refresh=$refresh, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Metadata for a bearer-token credential, without automatic OAuth refresh. */
    class StaticBearer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val mcpServerUrl: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("mcp_server_url")
            @ExcludeMissing
            mcpServerUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(mcpServerUrl, type, mutableMapOf())

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
             * .mcpServerUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [StaticBearer]. */
        class Builder internal constructor() {

            private var mcpServerUrl: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("static_bearer")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(staticBearer: StaticBearer) = apply {
                mcpServerUrl = staticBearer.mcpServerUrl
                type = staticBearer.type
                additionalProperties = staticBearer.additionalProperties.toMutableMap()
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
             * .mcpServerUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): StaticBearer =
                StaticBearer(
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
            (if (mcpServerUrl.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("static_bearer")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is StaticBearer &&
                mcpServerUrl == other.mcpServerUrl &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(mcpServerUrl, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "StaticBearer{mcpServerUrl=$mcpServerUrl, type=$type, additionalProperties=$additionalProperties}"
    }
}
