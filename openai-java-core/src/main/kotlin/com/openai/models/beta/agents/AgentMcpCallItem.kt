// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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
import kotlin.jvm.optionals.getOrNull

/** A call to a tool on an MCP server. */
class AgentMcpCallItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val arguments: JsonValue,
    private val error: JsonValue,
    private val name: JsonField<String>,
    private val output: JsonValue,
    private val serverLabel: JsonField<String>,
    private val status: JsonField<AgentFunctionCallStatus>,
    private val turnId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("arguments") @ExcludeMissing arguments: JsonValue = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonValue = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output") @ExcludeMissing output: JsonValue = JsonMissing.of(),
        @JsonProperty("server_label")
        @ExcludeMissing
        serverLabel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<AgentFunctionCallStatus> = JsonMissing.of(),
        @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, arguments, error, name, output, serverLabel, status, turnId, type, mutableMapOf())

    /**
     * The ID of the MCP call item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The arguments passed to the MCP tool.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = agentMcpCallItem.arguments().convert(MyClass.class);
     * ```
     */
    @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonValue = arguments

    /**
     * The error returned by the MCP tool, if any.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = agentMcpCallItem.error().convert(MyClass.class);
     * ```
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonValue = error

    /**
     * The name of the MCP tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The output returned by the MCP tool, if any.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = agentMcpCallItem.output().convert(MyClass.class);
     * ```
     */
    @JsonProperty("output") @ExcludeMissing fun _output(): JsonValue = output

    /**
     * The label of the MCP server.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serverLabel(): String = serverLabel.getRequired("server_label")

    /**
     * The status of the MCP tool call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): AgentFunctionCallStatus = status.getRequired("status")

    /**
     * The ID of the turn that contains this item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun turnId(): String = turnId.getRequired("turn_id")

    /**
     * The item type. Always `mcp_call`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("mcp_call")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [serverLabel].
     *
     * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("server_label")
    @ExcludeMissing
    fun _serverLabel(): JsonField<String> = serverLabel

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status")
    @ExcludeMissing
    fun _status(): JsonField<AgentFunctionCallStatus> = status

    /**
     * Returns the raw JSON value of [turnId].
     *
     * Unlike [turnId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("turn_id") @ExcludeMissing fun _turnId(): JsonField<String> = turnId

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
         * Returns a mutable builder for constructing an instance of [AgentMcpCallItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .arguments()
         * .error()
         * .name()
         * .output()
         * .serverLabel()
         * .status()
         * .turnId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentMcpCallItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var arguments: JsonValue? = null
        private var error: JsonValue? = null
        private var name: JsonField<String>? = null
        private var output: JsonValue? = null
        private var serverLabel: JsonField<String>? = null
        private var status: JsonField<AgentFunctionCallStatus>? = null
        private var turnId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("mcp_call")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentMcpCallItem: AgentMcpCallItem) = apply {
            id = agentMcpCallItem.id
            arguments = agentMcpCallItem.arguments
            error = agentMcpCallItem.error
            name = agentMcpCallItem.name
            output = agentMcpCallItem.output
            serverLabel = agentMcpCallItem.serverLabel
            status = agentMcpCallItem.status
            turnId = agentMcpCallItem.turnId
            type = agentMcpCallItem.type
            additionalProperties = agentMcpCallItem.additionalProperties.toMutableMap()
        }

        /** The ID of the MCP call item. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The arguments passed to the MCP tool. */
        fun arguments(arguments: JsonValue) = apply { this.arguments = arguments }

        /** The error returned by the MCP tool, if any. */
        fun error(error: JsonValue) = apply { this.error = error }

        /** The name of the MCP tool. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The output returned by the MCP tool, if any. */
        fun output(output: JsonValue) = apply { this.output = output }

        /** The label of the MCP server. */
        fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

        /**
         * Sets [Builder.serverLabel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serverLabel] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun serverLabel(serverLabel: JsonField<String>) = apply { this.serverLabel = serverLabel }

        /** The status of the MCP tool call. */
        fun status(status: AgentFunctionCallStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [AgentFunctionCallStatus]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun status(status: JsonField<AgentFunctionCallStatus>) = apply { this.status = status }

        /** The ID of the turn that contains this item. */
        fun turnId(turnId: String) = turnId(JsonField.of(turnId))

        /**
         * Sets [Builder.turnId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("mcp_call")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [AgentMcpCallItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .arguments()
         * .error()
         * .name()
         * .output()
         * .serverLabel()
         * .status()
         * .turnId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentMcpCallItem =
            AgentMcpCallItem(
                checkRequired("id", id),
                checkRequired("arguments", arguments),
                checkRequired("error", error),
                checkRequired("name", name),
                checkRequired("output", output),
                checkRequired("serverLabel", serverLabel),
                checkRequired("status", status),
                checkRequired("turnId", turnId),
                type,
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
    fun validate(): AgentMcpCallItem = apply {
        if (validated) {
            return@apply
        }

        id()
        name()
        serverLabel()
        status().validate()
        turnId()
        _type().let {
            if (it != JsonValue.from("mcp_call")) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (serverLabel.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (turnId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("mcp_call")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentMcpCallItem &&
            id == other.id &&
            arguments == other.arguments &&
            error == other.error &&
            name == other.name &&
            output == other.output &&
            serverLabel == other.serverLabel &&
            status == other.status &&
            turnId == other.turnId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            arguments,
            error,
            name,
            output,
            serverLabel,
            status,
            turnId,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentMcpCallItem{id=$id, arguments=$arguments, error=$error, name=$name, output=$output, serverLabel=$serverLabel, status=$status, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
}
