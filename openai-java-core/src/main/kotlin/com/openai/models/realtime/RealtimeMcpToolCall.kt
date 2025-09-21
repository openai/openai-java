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

/** A Realtime item representing an invocation of a tool on an MCP server. */
class RealtimeMcpToolCall
private constructor(
    private val id: JsonField<String>,
    private val arguments: JsonField<String>,
    private val name: JsonField<String>,
    private val serverLabel: JsonField<String>,
    private val type: JsonValue,
    private val approvalRequestId: JsonField<String>,
    private val error: JsonField<Error>,
    private val output: JsonField<String>,
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
        @JsonProperty("approval_request_id")
        @ExcludeMissing
        approvalRequestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
        @JsonProperty("output") @ExcludeMissing output: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        arguments,
        name,
        serverLabel,
        type,
        approvalRequestId,
        error,
        output,
        mutableMapOf(),
    )

    /**
     * The unique ID of the tool call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * A JSON string of the arguments passed to the tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun arguments(): String = arguments.getRequired("arguments")

    /**
     * The name of the tool that was run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The label of the MCP server running the tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serverLabel(): String = serverLabel.getRequired("server_label")

    /**
     * The type of the item. Always `mcp_call`.
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
     * The ID of an associated approval request, if any.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun approvalRequestId(): Optional<String> = approvalRequestId.getOptional("approval_request_id")

    /**
     * The error from the tool call, if any.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<Error> = error.getOptional("error")

    /**
     * The output from the tool call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun output(): Optional<String> = output.getOptional("output")

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

    /**
     * Returns the raw JSON value of [approvalRequestId].
     *
     * Unlike [approvalRequestId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("approval_request_id")
    @ExcludeMissing
    fun _approvalRequestId(): JsonField<String> = approvalRequestId

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

    /**
     * Returns the raw JSON value of [output].
     *
     * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

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
         * Returns a mutable builder for constructing an instance of [RealtimeMcpToolCall].
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

    /** A builder for [RealtimeMcpToolCall]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var arguments: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var serverLabel: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("mcp_call")
        private var approvalRequestId: JsonField<String> = JsonMissing.of()
        private var error: JsonField<Error> = JsonMissing.of()
        private var output: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeMcpToolCall: RealtimeMcpToolCall) = apply {
            id = realtimeMcpToolCall.id
            arguments = realtimeMcpToolCall.arguments
            name = realtimeMcpToolCall.name
            serverLabel = realtimeMcpToolCall.serverLabel
            type = realtimeMcpToolCall.type
            approvalRequestId = realtimeMcpToolCall.approvalRequestId
            error = realtimeMcpToolCall.error
            output = realtimeMcpToolCall.output
            additionalProperties = realtimeMcpToolCall.additionalProperties.toMutableMap()
        }

        /** The unique ID of the tool call. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** A JSON string of the arguments passed to the tool. */
        fun arguments(arguments: String) = arguments(JsonField.of(arguments))

        /**
         * Sets [Builder.arguments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.arguments] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

        /** The name of the tool that was run. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The label of the MCP server running the tool. */
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
         * JsonValue.from("mcp_call")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The ID of an associated approval request, if any. */
        fun approvalRequestId(approvalRequestId: String?) =
            approvalRequestId(JsonField.ofNullable(approvalRequestId))

        /** Alias for calling [Builder.approvalRequestId] with `approvalRequestId.orElse(null)`. */
        fun approvalRequestId(approvalRequestId: Optional<String>) =
            approvalRequestId(approvalRequestId.getOrNull())

        /**
         * Sets [Builder.approvalRequestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.approvalRequestId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun approvalRequestId(approvalRequestId: JsonField<String>) = apply {
            this.approvalRequestId = approvalRequestId
        }

        /** The error from the tool call, if any. */
        fun error(error: Error?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<Error>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [Error] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /** Alias for calling [error] with `Error.ofProtocol(protocol)`. */
        fun error(protocol: RealtimeMcpProtocolError) = error(Error.ofProtocol(protocol))

        /** Alias for calling [error] with `Error.ofToolExecution(toolExecution)`. */
        fun error(toolExecution: RealtimeMcpToolExecutionError) =
            error(Error.ofToolExecution(toolExecution))

        /**
         * Alias for calling [error] with the following:
         * ```java
         * RealtimeMcpToolExecutionError.builder()
         *     .message(message)
         *     .build()
         * ```
         */
        fun toolExecutionError(message: String) =
            error(RealtimeMcpToolExecutionError.builder().message(message).build())

        /** Alias for calling [error] with `Error.ofHttp(http)`. */
        fun error(http: RealtimeMcphttpError) = error(Error.ofHttp(http))

        /** The output from the tool call. */
        fun output(output: String?) = output(JsonField.ofNullable(output))

        /** Alias for calling [Builder.output] with `output.orElse(null)`. */
        fun output(output: Optional<String>) = output(output.getOrNull())

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun output(output: JsonField<String>) = apply { this.output = output }

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
         * Returns an immutable instance of [RealtimeMcpToolCall].
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
        fun build(): RealtimeMcpToolCall =
            RealtimeMcpToolCall(
                checkRequired("id", id),
                checkRequired("arguments", arguments),
                checkRequired("name", name),
                checkRequired("serverLabel", serverLabel),
                type,
                approvalRequestId,
                error,
                output,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeMcpToolCall = apply {
        if (validated) {
            return@apply
        }

        id()
        arguments()
        name()
        serverLabel()
        _type().let {
            if (it != JsonValue.from("mcp_call")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        approvalRequestId()
        error().ifPresent { it.validate() }
        output()
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
            type.let { if (it == JsonValue.from("mcp_call")) 1 else 0 } +
            (if (approvalRequestId.asKnown().isPresent) 1 else 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (if (output.asKnown().isPresent) 1 else 0)

    /** The error from the tool call, if any. */
    @JsonDeserialize(using = Error.Deserializer::class)
    @JsonSerialize(using = Error.Serializer::class)
    class Error
    private constructor(
        private val protocol: RealtimeMcpProtocolError? = null,
        private val toolExecution: RealtimeMcpToolExecutionError? = null,
        private val http: RealtimeMcphttpError? = null,
        private val _json: JsonValue? = null,
    ) {

        fun protocol(): Optional<RealtimeMcpProtocolError> = Optional.ofNullable(protocol)

        fun toolExecution(): Optional<RealtimeMcpToolExecutionError> =
            Optional.ofNullable(toolExecution)

        fun http(): Optional<RealtimeMcphttpError> = Optional.ofNullable(http)

        fun isProtocol(): Boolean = protocol != null

        fun isToolExecution(): Boolean = toolExecution != null

        fun isHttp(): Boolean = http != null

        fun asProtocol(): RealtimeMcpProtocolError = protocol.getOrThrow("protocol")

        fun asToolExecution(): RealtimeMcpToolExecutionError =
            toolExecution.getOrThrow("toolExecution")

        fun asHttp(): RealtimeMcphttpError = http.getOrThrow("http")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                protocol != null -> visitor.visitProtocol(protocol)
                toolExecution != null -> visitor.visitToolExecution(toolExecution)
                http != null -> visitor.visitHttp(http)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitProtocol(protocol: RealtimeMcpProtocolError) {
                        protocol.validate()
                    }

                    override fun visitToolExecution(toolExecution: RealtimeMcpToolExecutionError) {
                        toolExecution.validate()
                    }

                    override fun visitHttp(http: RealtimeMcphttpError) {
                        http.validate()
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
                    override fun visitProtocol(protocol: RealtimeMcpProtocolError) =
                        protocol.validity()

                    override fun visitToolExecution(toolExecution: RealtimeMcpToolExecutionError) =
                        toolExecution.validity()

                    override fun visitHttp(http: RealtimeMcphttpError) = http.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                protocol == other.protocol &&
                toolExecution == other.toolExecution &&
                http == other.http
        }

        override fun hashCode(): Int = Objects.hash(protocol, toolExecution, http)

        override fun toString(): String =
            when {
                protocol != null -> "Error{protocol=$protocol}"
                toolExecution != null -> "Error{toolExecution=$toolExecution}"
                http != null -> "Error{http=$http}"
                _json != null -> "Error{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Error")
            }

        companion object {

            @JvmStatic
            fun ofProtocol(protocol: RealtimeMcpProtocolError) = Error(protocol = protocol)

            @JvmStatic
            fun ofToolExecution(toolExecution: RealtimeMcpToolExecutionError) =
                Error(toolExecution = toolExecution)

            @JvmStatic fun ofHttp(http: RealtimeMcphttpError) = Error(http = http)
        }

        /** An interface that defines how to map each variant of [Error] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitProtocol(protocol: RealtimeMcpProtocolError): T

            fun visitToolExecution(toolExecution: RealtimeMcpToolExecutionError): T

            fun visitHttp(http: RealtimeMcphttpError): T

            /**
             * Maps an unknown variant of [Error] to a value of type [T].
             *
             * An instance of [Error] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Error: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Error>(Error::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Error {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "protocol_error" -> {
                        return tryDeserialize(node, jacksonTypeRef<RealtimeMcpProtocolError>())
                            ?.let { Error(protocol = it, _json = json) } ?: Error(_json = json)
                    }
                    "tool_execution_error" -> {
                        return tryDeserialize(node, jacksonTypeRef<RealtimeMcpToolExecutionError>())
                            ?.let { Error(toolExecution = it, _json = json) } ?: Error(_json = json)
                    }
                    "http_error" -> {
                        return tryDeserialize(node, jacksonTypeRef<RealtimeMcphttpError>())?.let {
                            Error(http = it, _json = json)
                        } ?: Error(_json = json)
                    }
                }

                return Error(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Error>(Error::class) {

            override fun serialize(
                value: Error,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.protocol != null -> generator.writeObject(value.protocol)
                    value.toolExecution != null -> generator.writeObject(value.toolExecution)
                    value.http != null -> generator.writeObject(value.http)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Error")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeMcpToolCall &&
            id == other.id &&
            arguments == other.arguments &&
            name == other.name &&
            serverLabel == other.serverLabel &&
            type == other.type &&
            approvalRequestId == other.approvalRequestId &&
            error == other.error &&
            output == other.output &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            arguments,
            name,
            serverLabel,
            type,
            approvalRequestId,
            error,
            output,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeMcpToolCall{id=$id, arguments=$arguments, name=$name, serverLabel=$serverLabel, type=$type, approvalRequestId=$approvalRequestId, error=$error, output=$output, additionalProperties=$additionalProperties}"
}
