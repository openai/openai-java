// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class McpTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val allowedCallers: JsonField<List<AllowedCaller>>,
    private val allowedTools: JsonField<AllowedTools>,
    private val authorization: JsonField<String>,
    private val connectorId: JsonField<String>,
    private val deferLoading: JsonField<Boolean>,
    private val headers: JsonField<Headers>,
    private val requireApproval: JsonField<RequireApproval>,
    private val serverDescription: JsonField<String>,
    private val serverLabel: JsonField<String>,
    private val serverUrl: JsonField<String>,
    private val tunnelId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("allowed_callers")
        @ExcludeMissing
        allowedCallers: JsonField<List<AllowedCaller>> = JsonMissing.of(),
        @JsonProperty("allowed_tools")
        @ExcludeMissing
        allowedTools: JsonField<AllowedTools> = JsonMissing.of(),
        @JsonProperty("authorization")
        @ExcludeMissing
        authorization: JsonField<String> = JsonMissing.of(),
        @JsonProperty("connector_id")
        @ExcludeMissing
        connectorId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("defer_loading")
        @ExcludeMissing
        deferLoading: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
        @JsonProperty("require_approval")
        @ExcludeMissing
        requireApproval: JsonField<RequireApproval> = JsonMissing.of(),
        @JsonProperty("server_description")
        @ExcludeMissing
        serverDescription: JsonField<String> = JsonMissing.of(),
        @JsonProperty("server_label")
        @ExcludeMissing
        serverLabel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("server_url") @ExcludeMissing serverUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tunnel_id") @ExcludeMissing tunnelId: JsonField<String> = JsonMissing.of(),
    ) : this(
        type,
        allowedCallers,
        allowedTools,
        authorization,
        connectorId,
        deferLoading,
        headers,
        requireApproval,
        serverDescription,
        serverLabel,
        serverUrl,
        tunnelId,
        mutableMapOf(),
    )

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("mcp")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The tool invocation context(s).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowedCallers(): Optional<List<AllowedCaller>> =
        allowedCallers.getOptional("allowed_callers")

    /**
     * A list of MCP tool names that are allowed for this server.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowedTools(): Optional<AllowedTools> = allowedTools.getOptional("allowed_tools")

    /**
     * This value is omitted from returned Live session data.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun authorization(): Optional<String> = authorization.getOptional("authorization")

    /**
     * The ID of a built-in MCP connector. This field is deprecated for models released after
     * September 1, 2026. Use `server_url` to connect to a remote MCP server, or `tunnel_id` to
     * connect to a local MCP server.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    @Deprecated("deprecated")
    fun connectorId(): Optional<String> = connectorId.getOptional("connector_id")

    /**
     * Whether this MCP tool should be deferred and discovered via tool search.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun deferLoading(): Optional<Boolean> = deferLoading.getOptional("defer_loading")

    /**
     * Optional HTTP headers to send when connecting to the MCP server.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun headers(): Optional<Headers> = headers.getOptional("headers")

    /**
     * Controls which MCP tools require explicit user approval before execution.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun requireApproval(): Optional<RequireApproval> =
        requireApproval.getOptional("require_approval")

    /**
     * An optional human-readable description of the MCP server.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serverDescription(): Optional<String> = serverDescription.getOptional("server_description")

    /**
     * A label used to identify the MCP server.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serverLabel(): Optional<String> = serverLabel.getOptional("server_label")

    /**
     * The URL of the MCP server to connect to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serverUrl(): Optional<String> = serverUrl.getOptional("server_url")

    /**
     * The Secure MCP Tunnel ID to use instead of a direct server URL.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tunnelId(): Optional<String> = tunnelId.getOptional("tunnel_id")

    /**
     * Returns the raw JSON value of [allowedCallers].
     *
     * Unlike [allowedCallers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowed_callers")
    @ExcludeMissing
    fun _allowedCallers(): JsonField<List<AllowedCaller>> = allowedCallers

    /**
     * Returns the raw JSON value of [allowedTools].
     *
     * Unlike [allowedTools], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowed_tools")
    @ExcludeMissing
    fun _allowedTools(): JsonField<AllowedTools> = allowedTools

    /**
     * Returns the raw JSON value of [authorization].
     *
     * Unlike [authorization], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("authorization")
    @ExcludeMissing
    fun _authorization(): JsonField<String> = authorization

    /**
     * Returns the raw JSON value of [connectorId].
     *
     * Unlike [connectorId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated")
    @JsonProperty("connector_id")
    @ExcludeMissing
    fun _connectorId(): JsonField<String> = connectorId

    /**
     * Returns the raw JSON value of [deferLoading].
     *
     * Unlike [deferLoading], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("defer_loading")
    @ExcludeMissing
    fun _deferLoading(): JsonField<Boolean> = deferLoading

    /**
     * Returns the raw JSON value of [headers].
     *
     * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

    /**
     * Returns the raw JSON value of [requireApproval].
     *
     * Unlike [requireApproval], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("require_approval")
    @ExcludeMissing
    fun _requireApproval(): JsonField<RequireApproval> = requireApproval

    /**
     * Returns the raw JSON value of [serverDescription].
     *
     * Unlike [serverDescription], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("server_description")
    @ExcludeMissing
    fun _serverDescription(): JsonField<String> = serverDescription

    /**
     * Returns the raw JSON value of [serverLabel].
     *
     * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("server_label")
    @ExcludeMissing
    fun _serverLabel(): JsonField<String> = serverLabel

    /**
     * Returns the raw JSON value of [serverUrl].
     *
     * Unlike [serverUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("server_url") @ExcludeMissing fun _serverUrl(): JsonField<String> = serverUrl

    /**
     * Returns the raw JSON value of [tunnelId].
     *
     * Unlike [tunnelId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tunnel_id") @ExcludeMissing fun _tunnelId(): JsonField<String> = tunnelId

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
            "type" to this.type,
            "allowed_callers" to this.allowedCallers,
            "allowed_tools" to this.allowedTools,
            "authorization" to this.authorization,
            "connector_id" to this.connectorId,
            "defer_loading" to this.deferLoading,
            "headers" to this.headers,
            "require_approval" to this.requireApproval,
            "server_description" to this.serverDescription,
            "server_label" to this.serverLabel,
            "server_url" to this.serverUrl,
            "tunnel_id" to this.tunnelId,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [McpTool]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [McpTool]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("mcp")
        private var allowedCallers: JsonField<MutableList<AllowedCaller>>? = null
        private var allowedTools: JsonField<AllowedTools> = JsonMissing.of()
        private var authorization: JsonField<String> = JsonMissing.of()
        private var connectorId: JsonField<String> = JsonMissing.of()
        private var deferLoading: JsonField<Boolean> = JsonMissing.of()
        private var headers: JsonField<Headers> = JsonMissing.of()
        private var requireApproval: JsonField<RequireApproval> = JsonMissing.of()
        private var serverDescription: JsonField<String> = JsonMissing.of()
        private var serverLabel: JsonField<String> = JsonMissing.of()
        private var serverUrl: JsonField<String> = JsonMissing.of()
        private var tunnelId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mcpTool: McpTool) = apply {
            type = mcpTool.type
            allowedCallers = mcpTool.allowedCallers.map { it.toMutableList() }
            allowedTools = mcpTool.allowedTools
            authorization = mcpTool.authorization
            connectorId = mcpTool.connectorId
            deferLoading = mcpTool.deferLoading
            headers = mcpTool.headers
            requireApproval = mcpTool.requireApproval
            serverDescription = mcpTool.serverDescription
            serverLabel = mcpTool.serverLabel
            serverUrl = mcpTool.serverUrl
            tunnelId = mcpTool.tunnelId
            additionalProperties = mcpTool.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("mcp")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The tool invocation context(s). */
        fun allowedCallers(allowedCallers: List<AllowedCaller>?) =
            allowedCallers(JsonField.ofNullable(allowedCallers))

        /** Alias for calling [Builder.allowedCallers] with `allowedCallers.orElse(null)`. */
        fun allowedCallers(allowedCallers: Optional<List<AllowedCaller>>) =
            allowedCallers(allowedCallers.getOrNull())

        /**
         * Sets [Builder.allowedCallers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedCallers] with a well-typed `List<AllowedCaller>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun allowedCallers(allowedCallers: JsonField<List<AllowedCaller>>) = apply {
            this.allowedCallers = allowedCallers.map { it.toMutableList() }
        }

        /**
         * Adds a single [AllowedCaller] to [allowedCallers].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAllowedCaller(allowedCaller: AllowedCaller) = apply {
            allowedCallers =
                (allowedCallers?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf()))
                    .also { checkKnown("allowedCallers", it).add(allowedCaller) }
        }

        /** A list of MCP tool names that are allowed for this server. */
        fun allowedTools(allowedTools: AllowedTools?) =
            allowedTools(JsonField.ofNullable(allowedTools))

        /** Alias for calling [Builder.allowedTools] with `allowedTools.orElse(null)`. */
        fun allowedTools(allowedTools: Optional<AllowedTools>) =
            allowedTools(allowedTools.getOrNull())

        /**
         * Sets [Builder.allowedTools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedTools] with a well-typed [AllowedTools] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowedTools(allowedTools: JsonField<AllowedTools>) = apply {
            this.allowedTools = allowedTools
        }

        /** Alias for calling [allowedTools] with `AllowedTools.ofStrings(strings)`. */
        fun allowedToolsOfStrings(strings: List<String>) =
            allowedTools(AllowedTools.ofStrings(strings))

        /** Alias for calling [allowedTools] with `AllowedTools.ofMcpToolFilter(mcpToolFilter)`. */
        fun allowedTools(mcpToolFilter: McpToolFilter) =
            allowedTools(AllowedTools.ofMcpToolFilter(mcpToolFilter))

        /** This value is omitted from returned Live session data. */
        fun authorization(authorization: String?) =
            authorization(JsonField.ofNullable(authorization))

        /** Alias for calling [Builder.authorization] with `authorization.orElse(null)`. */
        fun authorization(authorization: Optional<String>) =
            authorization(authorization.getOrNull())

        /**
         * Sets [Builder.authorization] to an arbitrary JSON value.
         *
         * You should usually call [Builder.authorization] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun authorization(authorization: JsonField<String>) = apply {
            this.authorization = authorization
        }

        /**
         * The ID of a built-in MCP connector. This field is deprecated for models released after
         * September 1, 2026. Use `server_url` to connect to a remote MCP server, or `tunnel_id` to
         * connect to a local MCP server.
         */
        @Deprecated("deprecated")
        fun connectorId(connectorId: String?) = connectorId(JsonField.ofNullable(connectorId))

        /** Alias for calling [Builder.connectorId] with `connectorId.orElse(null)`. */
        @Deprecated("deprecated")
        fun connectorId(connectorId: Optional<String>) = connectorId(connectorId.getOrNull())

        /**
         * Sets [Builder.connectorId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.connectorId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        @Deprecated("deprecated")
        fun connectorId(connectorId: JsonField<String>) = apply { this.connectorId = connectorId }

        /** Whether this MCP tool should be deferred and discovered via tool search. */
        fun deferLoading(deferLoading: Boolean?) = deferLoading(JsonField.ofNullable(deferLoading))

        /**
         * Alias for [Builder.deferLoading].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun deferLoading(deferLoading: Boolean) = deferLoading(deferLoading as Boolean?)

        /** Alias for calling [Builder.deferLoading] with `deferLoading.orElse(null)`. */
        fun deferLoading(deferLoading: Optional<Boolean>) = deferLoading(deferLoading.getOrNull())

        /**
         * Sets [Builder.deferLoading] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deferLoading] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun deferLoading(deferLoading: JsonField<Boolean>) = apply {
            this.deferLoading = deferLoading
        }

        /** Optional HTTP headers to send when connecting to the MCP server. */
        fun headers(headers: Headers?) = headers(JsonField.ofNullable(headers))

        /** Alias for calling [Builder.headers] with `headers.orElse(null)`. */
        fun headers(headers: Optional<Headers>) = headers(headers.getOrNull())

        /**
         * Sets [Builder.headers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.headers] with a well-typed [Headers] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

        /** Controls which MCP tools require explicit user approval before execution. */
        fun requireApproval(requireApproval: RequireApproval?) =
            requireApproval(JsonField.ofNullable(requireApproval))

        /** Alias for calling [Builder.requireApproval] with `requireApproval.orElse(null)`. */
        fun requireApproval(requireApproval: Optional<RequireApproval>) =
            requireApproval(requireApproval.getOrNull())

        /**
         * Sets [Builder.requireApproval] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requireApproval] with a well-typed [RequireApproval]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun requireApproval(requireApproval: JsonField<RequireApproval>) = apply {
            this.requireApproval = requireApproval
        }

        /**
         * Alias for calling [requireApproval] with
         * `RequireApproval.ofMcpRequireApprovalFilter(mcpRequireApprovalFilter)`.
         */
        fun requireApproval(mcpRequireApprovalFilter: McpRequireApprovalFilter) =
            requireApproval(RequireApproval.ofMcpRequireApprovalFilter(mcpRequireApprovalFilter))

        /**
         * Alias for calling [requireApproval] with
         * `RequireApproval.ofLiveMcpRequireApprovalApiEnum(liveMcpRequireApprovalApiEnum)`.
         */
        fun requireApproval(
            liveMcpRequireApprovalApiEnum: RequireApproval.LiveMcpRequireApprovalApiEnum
        ) =
            requireApproval(
                RequireApproval.ofLiveMcpRequireApprovalApiEnum(liveMcpRequireApprovalApiEnum)
            )

        /** An optional human-readable description of the MCP server. */
        fun serverDescription(serverDescription: String?) =
            serverDescription(JsonField.ofNullable(serverDescription))

        /** Alias for calling [Builder.serverDescription] with `serverDescription.orElse(null)`. */
        fun serverDescription(serverDescription: Optional<String>) =
            serverDescription(serverDescription.getOrNull())

        /**
         * Sets [Builder.serverDescription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serverDescription] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun serverDescription(serverDescription: JsonField<String>) = apply {
            this.serverDescription = serverDescription
        }

        /** A label used to identify the MCP server. */
        fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

        /**
         * Sets [Builder.serverLabel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serverLabel] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun serverLabel(serverLabel: JsonField<String>) = apply { this.serverLabel = serverLabel }

        /** The URL of the MCP server to connect to. */
        fun serverUrl(serverUrl: String?) = serverUrl(JsonField.ofNullable(serverUrl))

        /** Alias for calling [Builder.serverUrl] with `serverUrl.orElse(null)`. */
        fun serverUrl(serverUrl: Optional<String>) = serverUrl(serverUrl.getOrNull())

        /**
         * Sets [Builder.serverUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serverUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun serverUrl(serverUrl: JsonField<String>) = apply { this.serverUrl = serverUrl }

        /** The Secure MCP Tunnel ID to use instead of a direct server URL. */
        fun tunnelId(tunnelId: String?) = tunnelId(JsonField.ofNullable(tunnelId))

        /** Alias for calling [Builder.tunnelId] with `tunnelId.orElse(null)`. */
        fun tunnelId(tunnelId: Optional<String>) = tunnelId(tunnelId.getOrNull())

        /**
         * Sets [Builder.tunnelId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tunnelId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tunnelId(tunnelId: JsonField<String>) = apply { this.tunnelId = tunnelId }

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
         * Returns an immutable instance of [McpTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): McpTool =
            McpTool(
                type,
                (allowedCallers ?: JsonMissing.of()).map { it.toImmutable() },
                allowedTools,
                authorization,
                connectorId,
                deferLoading,
                headers,
                requireApproval,
                serverDescription,
                serverLabel,
                serverUrl,
                tunnelId,
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
    fun validate(): McpTool = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("mcp")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        allowedCallers().ifPresent { it.forEach { it.validate() } }
        allowedTools().ifPresent { it.validate() }
        authorization()
        connectorId()
        deferLoading()
        headers().ifPresent { it.validate() }
        requireApproval().ifPresent { it.validate() }
        serverDescription()
        serverLabel()
        serverUrl()
        tunnelId()
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
        type.let { if (it == JsonValue.from("mcp")) 1 else 0 } +
            (allowedCallers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (allowedTools.asKnown().getOrNull()?.validity() ?: 0) +
            (if (authorization.asKnown().isPresent) 1 else 0) +
            (if (connectorId.asKnown().isPresent) 1 else 0) +
            (if (deferLoading.asKnown().isPresent) 1 else 0) +
            (headers.asKnown().getOrNull()?.validity() ?: 0) +
            (requireApproval.asKnown().getOrNull()?.validity() ?: 0) +
            (if (serverDescription.asKnown().isPresent) 1 else 0) +
            (if (serverLabel.asKnown().isPresent) 1 else 0) +
            (if (serverUrl.asKnown().isPresent) 1 else 0) +
            (if (tunnelId.asKnown().isPresent) 1 else 0)

    class AllowedCaller @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val DIRECT = of("direct")

            @JvmField val PROGRAMMATIC = of("programmatic")

            @JvmStatic fun of(value: String) = AllowedCaller(JsonField.of(value))
        }

        /** An enum containing [AllowedCaller]'s known values. */
        enum class Known {
            DIRECT,
            PROGRAMMATIC,
        }

        /**
         * An enum containing [AllowedCaller]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AllowedCaller] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DIRECT,
            PROGRAMMATIC,
            /**
             * An enum member indicating that [AllowedCaller] was instantiated with an unknown
             * value.
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
                DIRECT -> Value.DIRECT
                PROGRAMMATIC -> Value.PROGRAMMATIC
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
                DIRECT -> Known.DIRECT
                PROGRAMMATIC -> Known.PROGRAMMATIC
                else -> throw OpenAIInvalidDataException("Unknown AllowedCaller: $value")
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
        fun validate(): AllowedCaller = apply {
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

            return other is AllowedCaller && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** A list of MCP tool names that are allowed for this server. */
    @JsonDeserialize(using = AllowedTools.Deserializer::class)
    @JsonSerialize(using = AllowedTools.Serializer::class)
    class AllowedTools
    private constructor(
        private val strings: List<String>? = null,
        private val mcpToolFilter: McpToolFilter? = null,
        private val _json: JsonValue? = null,
    ) {

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun mcpToolFilter(): Optional<McpToolFilter> = Optional.ofNullable(mcpToolFilter)

        fun isStrings(): Boolean = strings != null

        fun isMcpToolFilter(): Boolean = mcpToolFilter != null

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asMcpToolFilter(): McpToolFilter = mcpToolFilter.getOrThrow("mcpToolFilter")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = allowedTools.accept(new AllowedTools.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitStrings(List<String> strings) {
         *         return Optional.of(strings.toString());
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                strings != null -> visitor.visitStrings(strings)
                mcpToolFilter != null -> visitor.visitMcpToolFilter(mcpToolFilter)
                else -> visitor.unknown(_json)
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
        fun validate(): AllowedTools = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitStrings(strings: List<String>) {}

                    override fun visitMcpToolFilter(mcpToolFilter: McpToolFilter) {
                        mcpToolFilter.validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitStrings(strings: List<String>) = strings.size

                    override fun visitMcpToolFilter(mcpToolFilter: McpToolFilter) =
                        mcpToolFilter.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AllowedTools &&
                strings == other.strings &&
                mcpToolFilter == other.mcpToolFilter &&
                (strings != null || mcpToolFilter != null || _json == other._json)
        }

        override fun hashCode(): Int =
            if (strings == null && mcpToolFilter == null) Objects.hash(_json)
            else Objects.hash(strings, mcpToolFilter)

        override fun toString(): String =
            when {
                strings != null -> "AllowedTools{strings=$strings}"
                mcpToolFilter != null -> "AllowedTools{mcpToolFilter=$mcpToolFilter}"
                _json != null -> "AllowedTools{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid AllowedTools")
            }

        companion object {

            @JvmStatic
            fun ofStrings(strings: List<String>) = AllowedTools(strings = strings.toImmutable())

            @JvmStatic
            fun ofMcpToolFilter(mcpToolFilter: McpToolFilter) =
                AllowedTools(mcpToolFilter = mcpToolFilter)
        }

        /**
         * An interface that defines how to map each variant of [AllowedTools] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitStrings(strings: List<String>): T

            fun visitMcpToolFilter(mcpToolFilter: McpToolFilter): T

            /**
             * Maps an unknown variant of [AllowedTools] to a value of type [T].
             *
             * An instance of [AllowedTools] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown AllowedTools")
            }
        }

        internal class Deserializer : BaseDeserializer<AllowedTools>(AllowedTools::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): AllowedTools {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<McpToolFilter>())?.let {
                                AllowedTools(mcpToolFilter = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                AllowedTools(strings = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> AllowedTools(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<AllowedTools>(AllowedTools::class) {

            override fun serialize(
                value: AllowedTools,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.strings != null -> generator.writeObject(value.strings)
                    value.mcpToolFilter != null -> generator.writeObject(value.mcpToolFilter)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid AllowedTools")
                }
            }
        }
    }

    /** Optional HTTP headers to send when connecting to the MCP server. */
    class Headers
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> = collectAllProperties(additionalProperties)

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Headers]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Headers]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(headers: Headers) = apply {
                additionalProperties = headers.additionalProperties.toMutableMap()
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            /** Adds a string-valued property. */
            fun putProperty(key: String, value: String) = apply {
                putAdditionalProperty(key, JsonValue.from(value))
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Headers].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Headers = Headers(additionalProperties.toImmutable())
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
        fun validate(): Headers = apply {
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

            return other is Headers && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Headers{<redacted>}"
    }

    /** Controls which MCP tools require explicit user approval before execution. */
    @JsonDeserialize(using = RequireApproval.Deserializer::class)
    @JsonSerialize(using = RequireApproval.Serializer::class)
    class RequireApproval
    private constructor(
        private val mcpRequireApprovalFilter: McpRequireApprovalFilter? = null,
        private val liveMcpRequireApprovalApiEnum: LiveMcpRequireApprovalApiEnum? = null,
        private val _json: JsonValue? = null,
    ) {

        fun mcpRequireApprovalFilter(): Optional<McpRequireApprovalFilter> =
            Optional.ofNullable(mcpRequireApprovalFilter)

        /** Default approval behavior for MCP tool calls. */
        fun liveMcpRequireApprovalApiEnum(): Optional<LiveMcpRequireApprovalApiEnum> =
            Optional.ofNullable(liveMcpRequireApprovalApiEnum)

        fun isMcpRequireApprovalFilter(): Boolean = mcpRequireApprovalFilter != null

        fun isLiveMcpRequireApprovalApiEnum(): Boolean = liveMcpRequireApprovalApiEnum != null

        fun asMcpRequireApprovalFilter(): McpRequireApprovalFilter =
            mcpRequireApprovalFilter.getOrThrow("mcpRequireApprovalFilter")

        /** Default approval behavior for MCP tool calls. */
        fun asLiveMcpRequireApprovalApiEnum(): LiveMcpRequireApprovalApiEnum =
            liveMcpRequireApprovalApiEnum.getOrThrow("liveMcpRequireApprovalApiEnum")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = requireApproval.accept(new RequireApproval.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitMcpRequireApprovalFilter(McpRequireApprovalFilter mcpRequireApprovalFilter) {
         *         return Optional.of(mcpRequireApprovalFilter.toString());
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                mcpRequireApprovalFilter != null ->
                    visitor.visitMcpRequireApprovalFilter(mcpRequireApprovalFilter)
                liveMcpRequireApprovalApiEnum != null ->
                    visitor.visitLiveMcpRequireApprovalApiEnum(liveMcpRequireApprovalApiEnum)
                else -> visitor.unknown(_json)
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
        fun validate(): RequireApproval = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMcpRequireApprovalFilter(
                        mcpRequireApprovalFilter: McpRequireApprovalFilter
                    ) {
                        mcpRequireApprovalFilter.validate()
                    }

                    override fun visitLiveMcpRequireApprovalApiEnum(
                        liveMcpRequireApprovalApiEnum: LiveMcpRequireApprovalApiEnum
                    ) {
                        liveMcpRequireApprovalApiEnum.validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitMcpRequireApprovalFilter(
                        mcpRequireApprovalFilter: McpRequireApprovalFilter
                    ) = mcpRequireApprovalFilter.validity()

                    override fun visitLiveMcpRequireApprovalApiEnum(
                        liveMcpRequireApprovalApiEnum: LiveMcpRequireApprovalApiEnum
                    ) = liveMcpRequireApprovalApiEnum.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RequireApproval &&
                mcpRequireApprovalFilter == other.mcpRequireApprovalFilter &&
                liveMcpRequireApprovalApiEnum == other.liveMcpRequireApprovalApiEnum &&
                (mcpRequireApprovalFilter != null ||
                    liveMcpRequireApprovalApiEnum != null ||
                    _json == other._json)
        }

        override fun hashCode(): Int =
            if (mcpRequireApprovalFilter == null && liveMcpRequireApprovalApiEnum == null)
                Objects.hash(_json)
            else Objects.hash(mcpRequireApprovalFilter, liveMcpRequireApprovalApiEnum)

        override fun toString(): String =
            when {
                mcpRequireApprovalFilter != null ->
                    "RequireApproval{mcpRequireApprovalFilter=$mcpRequireApprovalFilter}"
                liveMcpRequireApprovalApiEnum != null ->
                    "RequireApproval{liveMcpRequireApprovalApiEnum=$liveMcpRequireApprovalApiEnum}"
                _json != null -> "RequireApproval{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid RequireApproval")
            }

        companion object {

            @JvmStatic
            fun ofMcpRequireApprovalFilter(mcpRequireApprovalFilter: McpRequireApprovalFilter) =
                RequireApproval(mcpRequireApprovalFilter = mcpRequireApprovalFilter)

            /** Default approval behavior for MCP tool calls. */
            @JvmStatic
            fun ofLiveMcpRequireApprovalApiEnum(
                liveMcpRequireApprovalApiEnum: LiveMcpRequireApprovalApiEnum
            ) = RequireApproval(liveMcpRequireApprovalApiEnum = liveMcpRequireApprovalApiEnum)
        }

        /**
         * An interface that defines how to map each variant of [RequireApproval] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitMcpRequireApprovalFilter(mcpRequireApprovalFilter: McpRequireApprovalFilter): T

            /** Default approval behavior for MCP tool calls. */
            fun visitLiveMcpRequireApprovalApiEnum(
                liveMcpRequireApprovalApiEnum: LiveMcpRequireApprovalApiEnum
            ): T

            /**
             * Maps an unknown variant of [RequireApproval] to a value of type [T].
             *
             * An instance of [RequireApproval] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown RequireApproval")
            }
        }

        internal class Deserializer : BaseDeserializer<RequireApproval>(RequireApproval::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): RequireApproval {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<McpRequireApprovalFilter>())?.let {
                                RequireApproval(mcpRequireApprovalFilter = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<LiveMcpRequireApprovalApiEnum>())
                                ?.let {
                                    RequireApproval(
                                        liveMcpRequireApprovalApiEnum = it,
                                        _json = json,
                                    )
                                },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> RequireApproval(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<RequireApproval>(RequireApproval::class) {

            override fun serialize(
                value: RequireApproval,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.mcpRequireApprovalFilter != null ->
                        generator.writeObject(value.mcpRequireApprovalFilter)
                    value.liveMcpRequireApprovalApiEnum != null ->
                        generator.writeObject(value.liveMcpRequireApprovalApiEnum)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid RequireApproval")
                }
            }
        }

        /** Default approval behavior for MCP tool calls. */
        class LiveMcpRequireApprovalApiEnum
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val ALWAYS = of("always")

                @JvmField val NEVER = of("never")

                @JvmStatic
                fun of(value: String) = LiveMcpRequireApprovalApiEnum(JsonField.of(value))
            }

            /** An enum containing [LiveMcpRequireApprovalApiEnum]'s known values. */
            enum class Known {
                ALWAYS,
                NEVER,
            }

            /**
             * An enum containing [LiveMcpRequireApprovalApiEnum]'s known values, as well as an
             * [_UNKNOWN] member.
             *
             * An instance of [LiveMcpRequireApprovalApiEnum] can contain an unknown value in a
             * couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                ALWAYS,
                NEVER,
                /**
                 * An enum member indicating that [LiveMcpRequireApprovalApiEnum] was instantiated
                 * with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    ALWAYS -> Value.ALWAYS
                    NEVER -> Value.NEVER
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    ALWAYS -> Known.ALWAYS
                    NEVER -> Known.NEVER
                    else ->
                        throw OpenAIInvalidDataException(
                            "Unknown LiveMcpRequireApprovalApiEnum: $value"
                        )
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
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
            fun validate(): LiveMcpRequireApprovalApiEnum = apply {
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

                return other is LiveMcpRequireApprovalApiEnum && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is McpTool &&
            type == other.type &&
            allowedCallers == other.allowedCallers &&
            allowedTools == other.allowedTools &&
            authorization == other.authorization &&
            connectorId == other.connectorId &&
            deferLoading == other.deferLoading &&
            headers == other.headers &&
            requireApproval == other.requireApproval &&
            serverDescription == other.serverDescription &&
            serverLabel == other.serverLabel &&
            serverUrl == other.serverUrl &&
            tunnelId == other.tunnelId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            type,
            allowedCallers,
            allowedTools,
            authorization,
            connectorId,
            deferLoading,
            headers,
            requireApproval,
            serverDescription,
            serverLabel,
            serverUrl,
            tunnelId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString(): String {
        val diagnosticProperties =
            additionalProperties.mapValues { (key, value) ->
                if (key == "authorization" || key == "headers") JsonValue.from("[REDACTED]")
                else value
            }
        return "McpTool{type=$type, allowedCallers=$allowedCallers, allowedTools=$allowedTools, authorization=[REDACTED], connectorId=$connectorId, deferLoading=$deferLoading, headers=[REDACTED], requireApproval=$requireApproval, serverDescription=$serverDescription, serverLabel=$serverLabel, serverUrl=$serverUrl, tunnelId=$tunnelId, additionalProperties=$diagnosticProperties}"
    }
}
