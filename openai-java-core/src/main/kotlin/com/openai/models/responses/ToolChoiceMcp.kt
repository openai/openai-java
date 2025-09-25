// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Use this option to force the model to call a specific tool on a remote MCP server. */
class ToolChoiceMcp
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val serverLabel: JsonField<String>,
    private val type: JsonValue,
    private val name: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("server_label")
        @ExcludeMissing
        serverLabel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
    ) : this(serverLabel, type, name, mutableMapOf())

    /**
     * The label of the MCP server to use.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serverLabel(): String = serverLabel.getRequired("server_label")

    /**
     * For MCP tools, the type is always `mcp`.
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
     * The name of the tool to call on the server.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Returns the raw JSON value of [serverLabel].
     *
     * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("server_label")
    @ExcludeMissing
    fun _serverLabel(): JsonField<String> = serverLabel

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
         * Returns a mutable builder for constructing an instance of [ToolChoiceMcp].
         *
         * The following fields are required:
         * ```java
         * .serverLabel()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ToolChoiceMcp]. */
    class Builder internal constructor() {

        private var serverLabel: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("mcp")
        private var name: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(toolChoiceMcp: ToolChoiceMcp) = apply {
            serverLabel = toolChoiceMcp.serverLabel
            type = toolChoiceMcp.type
            name = toolChoiceMcp.name
            additionalProperties = toolChoiceMcp.additionalProperties.toMutableMap()
        }

        /** The label of the MCP server to use. */
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

        /** The name of the tool to call on the server. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

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
         * Returns an immutable instance of [ToolChoiceMcp].
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
        fun build(): ToolChoiceMcp =
            ToolChoiceMcp(
                checkRequired("serverLabel", serverLabel),
                type,
                name,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ToolChoiceMcp = apply {
        if (validated) {
            return@apply
        }

        serverLabel()
        _type().let {
            if (it != JsonValue.from("mcp")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        name()
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
            (if (name.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ToolChoiceMcp &&
            serverLabel == other.serverLabel &&
            type == other.type &&
            name == other.name &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(serverLabel, type, name, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ToolChoiceMcp{serverLabel=$serverLabel, type=$type, name=$name, additionalProperties=$additionalProperties}"
}
