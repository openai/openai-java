// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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

/** A Realtime item requesting human approval of a tool invocation. */
class RealtimeMcpApprovalRequest
private constructor(
    private val id: JsonField<String>,
    private val arguments: JsonField<String>,
    private val name: JsonField<String>,
    private val serverLabel: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("arguments") @ExcludeMissing arguments: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("server_label")
        @ExcludeMissing
        serverLabel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, arguments, name, serverLabel, type, mutableMapOf())

    /**
     * The unique ID of the approval request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * A JSON string of arguments for the tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun arguments(): String = arguments.getRequired("arguments")

    /**
     * The name of the tool to run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The label of the MCP server making the request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serverLabel(): String = serverLabel.getRequired("server_label")

    /**
     * The type of the item. Always `mcp_approval_request`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("mcp_approval_request")
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
     * Returns the raw JSON value of [arguments].
     *
     * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

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
         * Returns a mutable builder for constructing an instance of [RealtimeMcpApprovalRequest].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .arguments()
         * .name()
         * .serverLabel()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeMcpApprovalRequest]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var arguments: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var serverLabel: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("mcp_approval_request")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeMcpApprovalRequest: RealtimeMcpApprovalRequest) = apply {
            id = realtimeMcpApprovalRequest.id
            arguments = realtimeMcpApprovalRequest.arguments
            name = realtimeMcpApprovalRequest.name
            serverLabel = realtimeMcpApprovalRequest.serverLabel
            type = realtimeMcpApprovalRequest.type
            additionalProperties = realtimeMcpApprovalRequest.additionalProperties.toMutableMap()
        }

        /** The unique ID of the approval request. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** A JSON string of arguments for the tool. */
        fun arguments(arguments: String) = arguments(JsonField.of(arguments))

        /**
         * Sets [Builder.arguments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.arguments] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

        /** The name of the tool to run. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The label of the MCP server making the request. */
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
         * JsonValue.from("mcp_approval_request")
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
         * Returns an immutable instance of [RealtimeMcpApprovalRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .arguments()
         * .name()
         * .serverLabel()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeMcpApprovalRequest =
            RealtimeMcpApprovalRequest(
                checkRequired("id", id),
                checkRequired("arguments", arguments),
                checkRequired("name", name),
                checkRequired("serverLabel", serverLabel),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeMcpApprovalRequest = apply {
        if (validated) {
            return@apply
        }

        id()
        arguments()
        name()
        serverLabel()
        _type().let {
            if (it != JsonValue.from("mcp_approval_request")) {
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
            (if (arguments.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (serverLabel.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("mcp_approval_request")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeMcpApprovalRequest &&
            id == other.id &&
            arguments == other.arguments &&
            name == other.name &&
            serverLabel == other.serverLabel &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, arguments, name, serverLabel, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeMcpApprovalRequest{id=$id, arguments=$arguments, name=$name, serverLabel=$serverLabel, type=$type, additionalProperties=$additionalProperties}"
}
