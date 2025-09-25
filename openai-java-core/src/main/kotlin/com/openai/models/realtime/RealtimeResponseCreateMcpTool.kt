// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Give the model access to additional tools via remote Model Context Protocol (MCP) servers.
 * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
 */
class RealtimeResponseCreateMcpTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val serverLabel: JsonField<String>,
    private val type: JsonValue,
    private val allowedTools: JsonField<AllowedTools>,
    private val authorization: JsonField<String>,
    private val connectorId: JsonField<ConnectorId>,
    private val headers: JsonField<Headers>,
    private val requireApproval: JsonField<RequireApproval>,
    private val serverDescription: JsonField<String>,
    private val serverUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("server_label")
        @ExcludeMissing
        serverLabel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("allowed_tools")
        @ExcludeMissing
        allowedTools: JsonField<AllowedTools> = JsonMissing.of(),
        @JsonProperty("authorization")
        @ExcludeMissing
        authorization: JsonField<String> = JsonMissing.of(),
        @JsonProperty("connector_id")
        @ExcludeMissing
        connectorId: JsonField<ConnectorId> = JsonMissing.of(),
        @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
        @JsonProperty("require_approval")
        @ExcludeMissing
        requireApproval: JsonField<RequireApproval> = JsonMissing.of(),
        @JsonProperty("server_description")
        @ExcludeMissing
        serverDescription: JsonField<String> = JsonMissing.of(),
        @JsonProperty("server_url") @ExcludeMissing serverUrl: JsonField<String> = JsonMissing.of(),
    ) : this(
        serverLabel,
        type,
        allowedTools,
        authorization,
        connectorId,
        headers,
        requireApproval,
        serverDescription,
        serverUrl,
        mutableMapOf(),
    )

    /**
     * A label for this MCP server, used to identify it in tool calls.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serverLabel(): String = serverLabel.getRequired("server_label")

    /**
     * The type of the MCP tool. Always `mcp`.
     *
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
     * List of allowed tool names or a filter object.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowedTools(): Optional<AllowedTools> = allowedTools.getOptional("allowed_tools")

    /**
     * An OAuth access token that can be used with a remote MCP server, either with a custom MCP
     * server URL or a service connector. Your application must handle the OAuth authorization flow
     * and provide the token here.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun authorization(): Optional<String> = authorization.getOptional("authorization")

    /**
     * Identifier for service connectors, like those available in ChatGPT. One of `server_url` or
     * `connector_id` must be provided. Learn more about service connectors
     * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
     *
     * Currently supported `connector_id` values are:
     * - Dropbox: `connector_dropbox`
     * - Gmail: `connector_gmail`
     * - Google Calendar: `connector_googlecalendar`
     * - Google Drive: `connector_googledrive`
     * - Microsoft Teams: `connector_microsoftteams`
     * - Outlook Calendar: `connector_outlookcalendar`
     * - Outlook Email: `connector_outlookemail`
     * - SharePoint: `connector_sharepoint`
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun connectorId(): Optional<ConnectorId> = connectorId.getOptional("connector_id")

    /**
     * Optional HTTP headers to send to the MCP server. Use for authentication or other purposes.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun headers(): Optional<Headers> = headers.getOptional("headers")

    /**
     * Specify which of the MCP server's tools require approval.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun requireApproval(): Optional<RequireApproval> =
        requireApproval.getOptional("require_approval")

    /**
     * Optional description of the MCP server, used to provide more context.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serverDescription(): Optional<String> = serverDescription.getOptional("server_description")

    /**
     * The URL for the MCP server. One of `server_url` or `connector_id` must be provided.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serverUrl(): Optional<String> = serverUrl.getOptional("server_url")

    /**
     * Returns the raw JSON value of [serverLabel].
     *
     * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("server_label")
    @ExcludeMissing
    fun _serverLabel(): JsonField<String> = serverLabel

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
    @JsonProperty("connector_id")
    @ExcludeMissing
    fun _connectorId(): JsonField<ConnectorId> = connectorId

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
     * Returns the raw JSON value of [serverUrl].
     *
     * Unlike [serverUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("server_url") @ExcludeMissing fun _serverUrl(): JsonField<String> = serverUrl

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
         * Returns a mutable builder for constructing an instance of
         * [RealtimeResponseCreateMcpTool].
         *
         * The following fields are required:
         * ```java
         * .serverLabel()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeResponseCreateMcpTool]. */
    class Builder internal constructor() {

        private var serverLabel: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("mcp")
        private var allowedTools: JsonField<AllowedTools> = JsonMissing.of()
        private var authorization: JsonField<String> = JsonMissing.of()
        private var connectorId: JsonField<ConnectorId> = JsonMissing.of()
        private var headers: JsonField<Headers> = JsonMissing.of()
        private var requireApproval: JsonField<RequireApproval> = JsonMissing.of()
        private var serverDescription: JsonField<String> = JsonMissing.of()
        private var serverUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeResponseCreateMcpTool: RealtimeResponseCreateMcpTool) = apply {
            serverLabel = realtimeResponseCreateMcpTool.serverLabel
            type = realtimeResponseCreateMcpTool.type
            allowedTools = realtimeResponseCreateMcpTool.allowedTools
            authorization = realtimeResponseCreateMcpTool.authorization
            connectorId = realtimeResponseCreateMcpTool.connectorId
            headers = realtimeResponseCreateMcpTool.headers
            requireApproval = realtimeResponseCreateMcpTool.requireApproval
            serverDescription = realtimeResponseCreateMcpTool.serverDescription
            serverUrl = realtimeResponseCreateMcpTool.serverUrl
            additionalProperties = realtimeResponseCreateMcpTool.additionalProperties.toMutableMap()
        }

        /** A label for this MCP server, used to identify it in tool calls. */
        fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

        /**
         * Sets [Builder.serverLabel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serverLabel] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun serverLabel(serverLabel: JsonField<String>) = apply { this.serverLabel = serverLabel }

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

        /** List of allowed tool names or a filter object. */
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

        /** Alias for calling [allowedTools] with `AllowedTools.ofMcp(mcp)`. */
        fun allowedToolsOfMcp(mcp: List<String>) = allowedTools(AllowedTools.ofMcp(mcp))

        /** Alias for calling [allowedTools] with `AllowedTools.ofMcpToolFilter(mcpToolFilter)`. */
        fun allowedTools(mcpToolFilter: AllowedTools.McpToolFilter) =
            allowedTools(AllowedTools.ofMcpToolFilter(mcpToolFilter))

        /**
         * An OAuth access token that can be used with a remote MCP server, either with a custom MCP
         * server URL or a service connector. Your application must handle the OAuth authorization
         * flow and provide the token here.
         */
        fun authorization(authorization: String) = authorization(JsonField.of(authorization))

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
         * Identifier for service connectors, like those available in ChatGPT. One of `server_url`
         * or `connector_id` must be provided. Learn more about service connectors
         * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
         *
         * Currently supported `connector_id` values are:
         * - Dropbox: `connector_dropbox`
         * - Gmail: `connector_gmail`
         * - Google Calendar: `connector_googlecalendar`
         * - Google Drive: `connector_googledrive`
         * - Microsoft Teams: `connector_microsoftteams`
         * - Outlook Calendar: `connector_outlookcalendar`
         * - Outlook Email: `connector_outlookemail`
         * - SharePoint: `connector_sharepoint`
         */
        fun connectorId(connectorId: ConnectorId) = connectorId(JsonField.of(connectorId))

        /**
         * Sets [Builder.connectorId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.connectorId] with a well-typed [ConnectorId] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun connectorId(connectorId: JsonField<ConnectorId>) = apply {
            this.connectorId = connectorId
        }

        /**
         * Optional HTTP headers to send to the MCP server. Use for authentication or other
         * purposes.
         */
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

        /** Specify which of the MCP server's tools require approval. */
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
         * `RequireApproval.ofMcpToolApprovalFilter(mcpToolApprovalFilter)`.
         */
        fun requireApproval(mcpToolApprovalFilter: RequireApproval.McpToolApprovalFilter) =
            requireApproval(RequireApproval.ofMcpToolApprovalFilter(mcpToolApprovalFilter))

        /**
         * Alias for calling [requireApproval] with
         * `RequireApproval.ofMcpToolApprovalSetting(mcpToolApprovalSetting)`.
         */
        fun requireApproval(mcpToolApprovalSetting: RequireApproval.McpToolApprovalSetting) =
            requireApproval(RequireApproval.ofMcpToolApprovalSetting(mcpToolApprovalSetting))

        /** Optional description of the MCP server, used to provide more context. */
        fun serverDescription(serverDescription: String) =
            serverDescription(JsonField.of(serverDescription))

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

        /** The URL for the MCP server. One of `server_url` or `connector_id` must be provided. */
        fun serverUrl(serverUrl: String) = serverUrl(JsonField.of(serverUrl))

        /**
         * Sets [Builder.serverUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serverUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun serverUrl(serverUrl: JsonField<String>) = apply { this.serverUrl = serverUrl }

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
         * Returns an immutable instance of [RealtimeResponseCreateMcpTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .serverLabel()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeResponseCreateMcpTool =
            RealtimeResponseCreateMcpTool(
                checkRequired("serverLabel", serverLabel),
                type,
                allowedTools,
                authorization,
                connectorId,
                headers,
                requireApproval,
                serverDescription,
                serverUrl,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeResponseCreateMcpTool = apply {
        if (validated) {
            return@apply
        }

        serverLabel()
        _type().let {
            if (it != JsonValue.from("mcp")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        allowedTools().ifPresent { it.validate() }
        authorization()
        connectorId().ifPresent { it.validate() }
        headers().ifPresent { it.validate() }
        requireApproval().ifPresent { it.validate() }
        serverDescription()
        serverUrl()
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
        (if (serverLabel.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("mcp")) 1 else 0 } +
            (allowedTools.asKnown().getOrNull()?.validity() ?: 0) +
            (if (authorization.asKnown().isPresent) 1 else 0) +
            (connectorId.asKnown().getOrNull()?.validity() ?: 0) +
            (headers.asKnown().getOrNull()?.validity() ?: 0) +
            (requireApproval.asKnown().getOrNull()?.validity() ?: 0) +
            (if (serverDescription.asKnown().isPresent) 1 else 0) +
            (if (serverUrl.asKnown().isPresent) 1 else 0)

    /** List of allowed tool names or a filter object. */
    @JsonDeserialize(using = AllowedTools.Deserializer::class)
    @JsonSerialize(using = AllowedTools.Serializer::class)
    class AllowedTools
    private constructor(
        private val mcp: List<String>? = null,
        private val mcpToolFilter: McpToolFilter? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A string array of allowed tool names */
        fun mcp(): Optional<List<String>> = Optional.ofNullable(mcp)

        /** A filter object to specify which tools are allowed. */
        fun mcpToolFilter(): Optional<McpToolFilter> = Optional.ofNullable(mcpToolFilter)

        fun isMcp(): Boolean = mcp != null

        fun isMcpToolFilter(): Boolean = mcpToolFilter != null

        /** A string array of allowed tool names */
        fun asMcp(): List<String> = mcp.getOrThrow("mcp")

        /** A filter object to specify which tools are allowed. */
        fun asMcpToolFilter(): McpToolFilter = mcpToolFilter.getOrThrow("mcpToolFilter")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                mcp != null -> visitor.visitMcp(mcp)
                mcpToolFilter != null -> visitor.visitMcpToolFilter(mcpToolFilter)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): AllowedTools = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMcp(mcp: List<String>) {}

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
                    override fun visitMcp(mcp: List<String>) = mcp.size

                    override fun visitMcpToolFilter(mcpToolFilter: McpToolFilter) =
                        mcpToolFilter.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AllowedTools && mcp == other.mcp && mcpToolFilter == other.mcpToolFilter
        }

        override fun hashCode(): Int = Objects.hash(mcp, mcpToolFilter)

        override fun toString(): String =
            when {
                mcp != null -> "AllowedTools{mcp=$mcp}"
                mcpToolFilter != null -> "AllowedTools{mcpToolFilter=$mcpToolFilter}"
                _json != null -> "AllowedTools{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid AllowedTools")
            }

        companion object {

            /** A string array of allowed tool names */
            @JvmStatic fun ofMcp(mcp: List<String>) = AllowedTools(mcp = mcp.toImmutable())

            /** A filter object to specify which tools are allowed. */
            @JvmStatic
            fun ofMcpToolFilter(mcpToolFilter: McpToolFilter) =
                AllowedTools(mcpToolFilter = mcpToolFilter)
        }

        /**
         * An interface that defines how to map each variant of [AllowedTools] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** A string array of allowed tool names */
            fun visitMcp(mcp: List<String>): T

            /** A filter object to specify which tools are allowed. */
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
                throw OpenAIInvalidDataException("Unknown AllowedTools: $json")
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
                                AllowedTools(mcp = it, _json = json)
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
                    value.mcp != null -> generator.writeObject(value.mcp)
                    value.mcpToolFilter != null -> generator.writeObject(value.mcpToolFilter)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid AllowedTools")
                }
            }
        }

        /** A filter object to specify which tools are allowed. */
        class McpToolFilter
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val readOnly: JsonField<Boolean>,
            private val toolNames: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("read_only")
                @ExcludeMissing
                readOnly: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("tool_names")
                @ExcludeMissing
                toolNames: JsonField<List<String>> = JsonMissing.of(),
            ) : this(readOnly, toolNames, mutableMapOf())

            /**
             * Indicates whether or not a tool modifies data or is read-only. If an MCP server is
             * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
             * it will match this filter.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

            /**
             * List of allowed tool names.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun toolNames(): Optional<List<String>> = toolNames.getOptional("tool_names")

            /**
             * Returns the raw JSON value of [readOnly].
             *
             * Unlike [readOnly], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("read_only")
            @ExcludeMissing
            fun _readOnly(): JsonField<Boolean> = readOnly

            /**
             * Returns the raw JSON value of [toolNames].
             *
             * Unlike [toolNames], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("tool_names")
            @ExcludeMissing
            fun _toolNames(): JsonField<List<String>> = toolNames

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

                /** Returns a mutable builder for constructing an instance of [McpToolFilter]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [McpToolFilter]. */
            class Builder internal constructor() {

                private var readOnly: JsonField<Boolean> = JsonMissing.of()
                private var toolNames: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(mcpToolFilter: McpToolFilter) = apply {
                    readOnly = mcpToolFilter.readOnly
                    toolNames = mcpToolFilter.toolNames.map { it.toMutableList() }
                    additionalProperties = mcpToolFilter.additionalProperties.toMutableMap()
                }

                /**
                 * Indicates whether or not a tool modifies data or is read-only. If an MCP server
                 * is
                 * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                 * it will match this filter.
                 */
                fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                /**
                 * Sets [Builder.readOnly] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.readOnly] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun readOnly(readOnly: JsonField<Boolean>) = apply { this.readOnly = readOnly }

                /** List of allowed tool names. */
                fun toolNames(toolNames: List<String>) = toolNames(JsonField.of(toolNames))

                /**
                 * Sets [Builder.toolNames] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.toolNames] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun toolNames(toolNames: JsonField<List<String>>) = apply {
                    this.toolNames = toolNames.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [toolNames].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addToolName(toolName: String) = apply {
                    toolNames =
                        (toolNames ?: JsonField.of(mutableListOf())).also {
                            checkKnown("toolNames", it).add(toolName)
                        }
                }

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
                 * Returns an immutable instance of [McpToolFilter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): McpToolFilter =
                    McpToolFilter(
                        readOnly,
                        (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): McpToolFilter = apply {
                if (validated) {
                    return@apply
                }

                readOnly()
                toolNames()
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
                (if (readOnly.asKnown().isPresent) 1 else 0) +
                    (toolNames.asKnown().getOrNull()?.size ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is McpToolFilter &&
                    readOnly == other.readOnly &&
                    toolNames == other.toolNames &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(readOnly, toolNames, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "McpToolFilter{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
        }
    }

    /**
     * Identifier for service connectors, like those available in ChatGPT. One of `server_url` or
     * `connector_id` must be provided. Learn more about service connectors
     * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
     *
     * Currently supported `connector_id` values are:
     * - Dropbox: `connector_dropbox`
     * - Gmail: `connector_gmail`
     * - Google Calendar: `connector_googlecalendar`
     * - Google Drive: `connector_googledrive`
     * - Microsoft Teams: `connector_microsoftteams`
     * - Outlook Calendar: `connector_outlookcalendar`
     * - Outlook Email: `connector_outlookemail`
     * - SharePoint: `connector_sharepoint`
     */
    class ConnectorId @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val CONNECTOR_DROPBOX = of("connector_dropbox")

            @JvmField val CONNECTOR_GMAIL = of("connector_gmail")

            @JvmField val CONNECTOR_GOOGLECALENDAR = of("connector_googlecalendar")

            @JvmField val CONNECTOR_GOOGLEDRIVE = of("connector_googledrive")

            @JvmField val CONNECTOR_MICROSOFTTEAMS = of("connector_microsoftteams")

            @JvmField val CONNECTOR_OUTLOOKCALENDAR = of("connector_outlookcalendar")

            @JvmField val CONNECTOR_OUTLOOKEMAIL = of("connector_outlookemail")

            @JvmField val CONNECTOR_SHAREPOINT = of("connector_sharepoint")

            @JvmStatic fun of(value: String) = ConnectorId(JsonField.of(value))
        }

        /** An enum containing [ConnectorId]'s known values. */
        enum class Known {
            CONNECTOR_DROPBOX,
            CONNECTOR_GMAIL,
            CONNECTOR_GOOGLECALENDAR,
            CONNECTOR_GOOGLEDRIVE,
            CONNECTOR_MICROSOFTTEAMS,
            CONNECTOR_OUTLOOKCALENDAR,
            CONNECTOR_OUTLOOKEMAIL,
            CONNECTOR_SHAREPOINT,
        }

        /**
         * An enum containing [ConnectorId]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ConnectorId] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CONNECTOR_DROPBOX,
            CONNECTOR_GMAIL,
            CONNECTOR_GOOGLECALENDAR,
            CONNECTOR_GOOGLEDRIVE,
            CONNECTOR_MICROSOFTTEAMS,
            CONNECTOR_OUTLOOKCALENDAR,
            CONNECTOR_OUTLOOKEMAIL,
            CONNECTOR_SHAREPOINT,
            /**
             * An enum member indicating that [ConnectorId] was instantiated with an unknown value.
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
                CONNECTOR_DROPBOX -> Value.CONNECTOR_DROPBOX
                CONNECTOR_GMAIL -> Value.CONNECTOR_GMAIL
                CONNECTOR_GOOGLECALENDAR -> Value.CONNECTOR_GOOGLECALENDAR
                CONNECTOR_GOOGLEDRIVE -> Value.CONNECTOR_GOOGLEDRIVE
                CONNECTOR_MICROSOFTTEAMS -> Value.CONNECTOR_MICROSOFTTEAMS
                CONNECTOR_OUTLOOKCALENDAR -> Value.CONNECTOR_OUTLOOKCALENDAR
                CONNECTOR_OUTLOOKEMAIL -> Value.CONNECTOR_OUTLOOKEMAIL
                CONNECTOR_SHAREPOINT -> Value.CONNECTOR_SHAREPOINT
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
                CONNECTOR_DROPBOX -> Known.CONNECTOR_DROPBOX
                CONNECTOR_GMAIL -> Known.CONNECTOR_GMAIL
                CONNECTOR_GOOGLECALENDAR -> Known.CONNECTOR_GOOGLECALENDAR
                CONNECTOR_GOOGLEDRIVE -> Known.CONNECTOR_GOOGLEDRIVE
                CONNECTOR_MICROSOFTTEAMS -> Known.CONNECTOR_MICROSOFTTEAMS
                CONNECTOR_OUTLOOKCALENDAR -> Known.CONNECTOR_OUTLOOKCALENDAR
                CONNECTOR_OUTLOOKEMAIL -> Known.CONNECTOR_OUTLOOKEMAIL
                CONNECTOR_SHAREPOINT -> Known.CONNECTOR_SHAREPOINT
                else -> throw OpenAIInvalidDataException("Unknown ConnectorId: $value")
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

        fun validate(): ConnectorId = apply {
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

            return other is ConnectorId && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Optional HTTP headers to send to the MCP server. Use for authentication or other purposes.
     */
    class Headers
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

        override fun toString() = "Headers{additionalProperties=$additionalProperties}"
    }

    /** Specify which of the MCP server's tools require approval. */
    @JsonDeserialize(using = RequireApproval.Deserializer::class)
    @JsonSerialize(using = RequireApproval.Serializer::class)
    class RequireApproval
    private constructor(
        private val mcpToolApprovalFilter: McpToolApprovalFilter? = null,
        private val mcpToolApprovalSetting: McpToolApprovalSetting? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Specify which of the MCP server's tools require approval. Can be `always`, `never`, or a
         * filter object associated with tools that require approval.
         */
        fun mcpToolApprovalFilter(): Optional<McpToolApprovalFilter> =
            Optional.ofNullable(mcpToolApprovalFilter)

        /**
         * Specify a single approval policy for all tools. One of `always` or `never`. When set to
         * `always`, all tools will require approval. When set to `never`, all tools will not
         * require approval.
         */
        fun mcpToolApprovalSetting(): Optional<McpToolApprovalSetting> =
            Optional.ofNullable(mcpToolApprovalSetting)

        fun isMcpToolApprovalFilter(): Boolean = mcpToolApprovalFilter != null

        fun isMcpToolApprovalSetting(): Boolean = mcpToolApprovalSetting != null

        /**
         * Specify which of the MCP server's tools require approval. Can be `always`, `never`, or a
         * filter object associated with tools that require approval.
         */
        fun asMcpToolApprovalFilter(): McpToolApprovalFilter =
            mcpToolApprovalFilter.getOrThrow("mcpToolApprovalFilter")

        /**
         * Specify a single approval policy for all tools. One of `always` or `never`. When set to
         * `always`, all tools will require approval. When set to `never`, all tools will not
         * require approval.
         */
        fun asMcpToolApprovalSetting(): McpToolApprovalSetting =
            mcpToolApprovalSetting.getOrThrow("mcpToolApprovalSetting")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                mcpToolApprovalFilter != null ->
                    visitor.visitMcpToolApprovalFilter(mcpToolApprovalFilter)
                mcpToolApprovalSetting != null ->
                    visitor.visitMcpToolApprovalSetting(mcpToolApprovalSetting)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): RequireApproval = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMcpToolApprovalFilter(
                        mcpToolApprovalFilter: McpToolApprovalFilter
                    ) {
                        mcpToolApprovalFilter.validate()
                    }

                    override fun visitMcpToolApprovalSetting(
                        mcpToolApprovalSetting: McpToolApprovalSetting
                    ) {
                        mcpToolApprovalSetting.validate()
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
                    override fun visitMcpToolApprovalFilter(
                        mcpToolApprovalFilter: McpToolApprovalFilter
                    ) = mcpToolApprovalFilter.validity()

                    override fun visitMcpToolApprovalSetting(
                        mcpToolApprovalSetting: McpToolApprovalSetting
                    ) = mcpToolApprovalSetting.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RequireApproval &&
                mcpToolApprovalFilter == other.mcpToolApprovalFilter &&
                mcpToolApprovalSetting == other.mcpToolApprovalSetting
        }

        override fun hashCode(): Int = Objects.hash(mcpToolApprovalFilter, mcpToolApprovalSetting)

        override fun toString(): String =
            when {
                mcpToolApprovalFilter != null ->
                    "RequireApproval{mcpToolApprovalFilter=$mcpToolApprovalFilter}"
                mcpToolApprovalSetting != null ->
                    "RequireApproval{mcpToolApprovalSetting=$mcpToolApprovalSetting}"
                _json != null -> "RequireApproval{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid RequireApproval")
            }

        companion object {

            /**
             * Specify which of the MCP server's tools require approval. Can be `always`, `never`,
             * or a filter object associated with tools that require approval.
             */
            @JvmStatic
            fun ofMcpToolApprovalFilter(mcpToolApprovalFilter: McpToolApprovalFilter) =
                RequireApproval(mcpToolApprovalFilter = mcpToolApprovalFilter)

            /**
             * Specify a single approval policy for all tools. One of `always` or `never`. When set
             * to `always`, all tools will require approval. When set to `never`, all tools will not
             * require approval.
             */
            @JvmStatic
            fun ofMcpToolApprovalSetting(mcpToolApprovalSetting: McpToolApprovalSetting) =
                RequireApproval(mcpToolApprovalSetting = mcpToolApprovalSetting)
        }

        /**
         * An interface that defines how to map each variant of [RequireApproval] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /**
             * Specify which of the MCP server's tools require approval. Can be `always`, `never`,
             * or a filter object associated with tools that require approval.
             */
            fun visitMcpToolApprovalFilter(mcpToolApprovalFilter: McpToolApprovalFilter): T

            /**
             * Specify a single approval policy for all tools. One of `always` or `never`. When set
             * to `always`, all tools will require approval. When set to `never`, all tools will not
             * require approval.
             */
            fun visitMcpToolApprovalSetting(mcpToolApprovalSetting: McpToolApprovalSetting): T

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
                throw OpenAIInvalidDataException("Unknown RequireApproval: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<RequireApproval>(RequireApproval::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): RequireApproval {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<McpToolApprovalFilter>())?.let {
                                RequireApproval(mcpToolApprovalFilter = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<McpToolApprovalSetting>())?.let {
                                RequireApproval(mcpToolApprovalSetting = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from array).
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
                    value.mcpToolApprovalFilter != null ->
                        generator.writeObject(value.mcpToolApprovalFilter)
                    value.mcpToolApprovalSetting != null ->
                        generator.writeObject(value.mcpToolApprovalSetting)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid RequireApproval")
                }
            }
        }

        /**
         * Specify which of the MCP server's tools require approval. Can be `always`, `never`, or a
         * filter object associated with tools that require approval.
         */
        class McpToolApprovalFilter
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val always: JsonField<Always>,
            private val never: JsonField<Never>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("always")
                @ExcludeMissing
                always: JsonField<Always> = JsonMissing.of(),
                @JsonProperty("never") @ExcludeMissing never: JsonField<Never> = JsonMissing.of(),
            ) : this(always, never, mutableMapOf())

            /**
             * A filter object to specify which tools are allowed.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun always(): Optional<Always> = always.getOptional("always")

            /**
             * A filter object to specify which tools are allowed.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun never(): Optional<Never> = never.getOptional("never")

            /**
             * Returns the raw JSON value of [always].
             *
             * Unlike [always], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("always") @ExcludeMissing fun _always(): JsonField<Always> = always

            /**
             * Returns the raw JSON value of [never].
             *
             * Unlike [never], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("never") @ExcludeMissing fun _never(): JsonField<Never> = never

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
                 * Returns a mutable builder for constructing an instance of
                 * [McpToolApprovalFilter].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [McpToolApprovalFilter]. */
            class Builder internal constructor() {

                private var always: JsonField<Always> = JsonMissing.of()
                private var never: JsonField<Never> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(mcpToolApprovalFilter: McpToolApprovalFilter) = apply {
                    always = mcpToolApprovalFilter.always
                    never = mcpToolApprovalFilter.never
                    additionalProperties = mcpToolApprovalFilter.additionalProperties.toMutableMap()
                }

                /** A filter object to specify which tools are allowed. */
                fun always(always: Always) = always(JsonField.of(always))

                /**
                 * Sets [Builder.always] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.always] with a well-typed [Always] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun always(always: JsonField<Always>) = apply { this.always = always }

                /** A filter object to specify which tools are allowed. */
                fun never(never: Never) = never(JsonField.of(never))

                /**
                 * Sets [Builder.never] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.never] with a well-typed [Never] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun never(never: JsonField<Never>) = apply { this.never = never }

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
                 * Returns an immutable instance of [McpToolApprovalFilter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): McpToolApprovalFilter =
                    McpToolApprovalFilter(always, never, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): McpToolApprovalFilter = apply {
                if (validated) {
                    return@apply
                }

                always().ifPresent { it.validate() }
                never().ifPresent { it.validate() }
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
                (always.asKnown().getOrNull()?.validity() ?: 0) +
                    (never.asKnown().getOrNull()?.validity() ?: 0)

            /** A filter object to specify which tools are allowed. */
            class Always
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val readOnly: JsonField<Boolean>,
                private val toolNames: JsonField<List<String>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("read_only")
                    @ExcludeMissing
                    readOnly: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("tool_names")
                    @ExcludeMissing
                    toolNames: JsonField<List<String>> = JsonMissing.of(),
                ) : this(readOnly, toolNames, mutableMapOf())

                /**
                 * Indicates whether or not a tool modifies data or is read-only. If an MCP server
                 * is
                 * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                 * it will match this filter.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

                /**
                 * List of allowed tool names.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun toolNames(): Optional<List<String>> = toolNames.getOptional("tool_names")

                /**
                 * Returns the raw JSON value of [readOnly].
                 *
                 * Unlike [readOnly], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("read_only")
                @ExcludeMissing
                fun _readOnly(): JsonField<Boolean> = readOnly

                /**
                 * Returns the raw JSON value of [toolNames].
                 *
                 * Unlike [toolNames], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("tool_names")
                @ExcludeMissing
                fun _toolNames(): JsonField<List<String>> = toolNames

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

                    /** Returns a mutable builder for constructing an instance of [Always]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Always]. */
                class Builder internal constructor() {

                    private var readOnly: JsonField<Boolean> = JsonMissing.of()
                    private var toolNames: JsonField<MutableList<String>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(always: Always) = apply {
                        readOnly = always.readOnly
                        toolNames = always.toolNames.map { it.toMutableList() }
                        additionalProperties = always.additionalProperties.toMutableMap()
                    }

                    /**
                     * Indicates whether or not a tool modifies data or is read-only. If an MCP
                     * server is
                     * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                     * it will match this filter.
                     */
                    fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                    /**
                     * Sets [Builder.readOnly] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.readOnly] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun readOnly(readOnly: JsonField<Boolean>) = apply { this.readOnly = readOnly }

                    /** List of allowed tool names. */
                    fun toolNames(toolNames: List<String>) = toolNames(JsonField.of(toolNames))

                    /**
                     * Sets [Builder.toolNames] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.toolNames] with a well-typed `List<String>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun toolNames(toolNames: JsonField<List<String>>) = apply {
                        this.toolNames = toolNames.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [toolNames].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addToolName(toolName: String) = apply {
                        toolNames =
                            (toolNames ?: JsonField.of(mutableListOf())).also {
                                checkKnown("toolNames", it).add(toolName)
                            }
                    }

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
                     * Returns an immutable instance of [Always].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Always =
                        Always(
                            readOnly,
                            (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Always = apply {
                    if (validated) {
                        return@apply
                    }

                    readOnly()
                    toolNames()
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
                    (if (readOnly.asKnown().isPresent) 1 else 0) +
                        (toolNames.asKnown().getOrNull()?.size ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Always &&
                        readOnly == other.readOnly &&
                        toolNames == other.toolNames &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(readOnly, toolNames, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Always{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
            }

            /** A filter object to specify which tools are allowed. */
            class Never
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val readOnly: JsonField<Boolean>,
                private val toolNames: JsonField<List<String>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("read_only")
                    @ExcludeMissing
                    readOnly: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("tool_names")
                    @ExcludeMissing
                    toolNames: JsonField<List<String>> = JsonMissing.of(),
                ) : this(readOnly, toolNames, mutableMapOf())

                /**
                 * Indicates whether or not a tool modifies data or is read-only. If an MCP server
                 * is
                 * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                 * it will match this filter.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

                /**
                 * List of allowed tool names.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun toolNames(): Optional<List<String>> = toolNames.getOptional("tool_names")

                /**
                 * Returns the raw JSON value of [readOnly].
                 *
                 * Unlike [readOnly], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("read_only")
                @ExcludeMissing
                fun _readOnly(): JsonField<Boolean> = readOnly

                /**
                 * Returns the raw JSON value of [toolNames].
                 *
                 * Unlike [toolNames], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("tool_names")
                @ExcludeMissing
                fun _toolNames(): JsonField<List<String>> = toolNames

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

                    /** Returns a mutable builder for constructing an instance of [Never]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Never]. */
                class Builder internal constructor() {

                    private var readOnly: JsonField<Boolean> = JsonMissing.of()
                    private var toolNames: JsonField<MutableList<String>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(never: Never) = apply {
                        readOnly = never.readOnly
                        toolNames = never.toolNames.map { it.toMutableList() }
                        additionalProperties = never.additionalProperties.toMutableMap()
                    }

                    /**
                     * Indicates whether or not a tool modifies data or is read-only. If an MCP
                     * server is
                     * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                     * it will match this filter.
                     */
                    fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                    /**
                     * Sets [Builder.readOnly] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.readOnly] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun readOnly(readOnly: JsonField<Boolean>) = apply { this.readOnly = readOnly }

                    /** List of allowed tool names. */
                    fun toolNames(toolNames: List<String>) = toolNames(JsonField.of(toolNames))

                    /**
                     * Sets [Builder.toolNames] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.toolNames] with a well-typed `List<String>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun toolNames(toolNames: JsonField<List<String>>) = apply {
                        this.toolNames = toolNames.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [toolNames].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addToolName(toolName: String) = apply {
                        toolNames =
                            (toolNames ?: JsonField.of(mutableListOf())).also {
                                checkKnown("toolNames", it).add(toolName)
                            }
                    }

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
                     * Returns an immutable instance of [Never].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Never =
                        Never(
                            readOnly,
                            (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Never = apply {
                    if (validated) {
                        return@apply
                    }

                    readOnly()
                    toolNames()
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
                    (if (readOnly.asKnown().isPresent) 1 else 0) +
                        (toolNames.asKnown().getOrNull()?.size ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Never &&
                        readOnly == other.readOnly &&
                        toolNames == other.toolNames &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(readOnly, toolNames, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Never{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is McpToolApprovalFilter &&
                    always == other.always &&
                    never == other.never &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(always, never, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "McpToolApprovalFilter{always=$always, never=$never, additionalProperties=$additionalProperties}"
        }

        /**
         * Specify a single approval policy for all tools. One of `always` or `never`. When set to
         * `always`, all tools will require approval. When set to `never`, all tools will not
         * require approval.
         */
        class McpToolApprovalSetting
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

                @JvmStatic fun of(value: String) = McpToolApprovalSetting(JsonField.of(value))
            }

            /** An enum containing [McpToolApprovalSetting]'s known values. */
            enum class Known {
                ALWAYS,
                NEVER,
            }

            /**
             * An enum containing [McpToolApprovalSetting]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [McpToolApprovalSetting] can contain an unknown value in a couple of
             * cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                ALWAYS,
                NEVER,
                /**
                 * An enum member indicating that [McpToolApprovalSetting] was instantiated with an
                 * unknown value.
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
                        throw OpenAIInvalidDataException("Unknown McpToolApprovalSetting: $value")
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

            fun validate(): McpToolApprovalSetting = apply {
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

                return other is McpToolApprovalSetting && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeResponseCreateMcpTool &&
            serverLabel == other.serverLabel &&
            type == other.type &&
            allowedTools == other.allowedTools &&
            authorization == other.authorization &&
            connectorId == other.connectorId &&
            headers == other.headers &&
            requireApproval == other.requireApproval &&
            serverDescription == other.serverDescription &&
            serverUrl == other.serverUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            serverLabel,
            type,
            allowedTools,
            authorization,
            connectorId,
            headers,
            requireApproval,
            serverDescription,
            serverUrl,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeResponseCreateMcpTool{serverLabel=$serverLabel, type=$type, allowedTools=$allowedTools, authorization=$authorization, connectorId=$connectorId, headers=$headers, requireApproval=$requireApproval, serverDescription=$serverDescription, serverUrl=$serverUrl, additionalProperties=$additionalProperties}"
}
