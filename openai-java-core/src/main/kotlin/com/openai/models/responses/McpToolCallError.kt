// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

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

@JsonDeserialize(using = McpToolCallError.Deserializer::class)
@JsonSerialize(using = McpToolCallError.Serializer::class)
class McpToolCallError
private constructor(
    private val protocol: McpProtocolError? = null,
    private val toolExecution: McpToolExecutionError? = null,
    private val http: HttpError? = null,
    private val _json: JsonValue? = null,
) {

    fun protocol(): Optional<McpProtocolError> = Optional.ofNullable(protocol)

    fun toolExecution(): Optional<McpToolExecutionError> = Optional.ofNullable(toolExecution)

    fun http(): Optional<HttpError> = Optional.ofNullable(http)

    fun isProtocol(): Boolean = protocol != null

    fun isToolExecution(): Boolean = toolExecution != null

    fun isHttp(): Boolean = http != null

    fun asProtocol(): McpProtocolError = protocol.getOrThrow("protocol")

    fun asToolExecution(): McpToolExecutionError = toolExecution.getOrThrow("toolExecution")

    fun asHttp(): HttpError = http.getOrThrow("http")

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
     * Optional<String> result = mcpToolCallError.accept(new McpToolCallError.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitProtocol(McpProtocolError protocol) {
     *         return Optional.of(protocol.toString());
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
            protocol != null -> visitor.visitProtocol(protocol)
            toolExecution != null -> visitor.visitToolExecution(toolExecution)
            http != null -> visitor.visitHttp(http)
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
    fun validate(): McpToolCallError = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitProtocol(protocol: McpProtocolError) {
                    protocol.validate()
                }

                override fun visitToolExecution(toolExecution: McpToolExecutionError) {
                    toolExecution.validate()
                }

                override fun visitHttp(http: HttpError) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitProtocol(protocol: McpProtocolError) = protocol.validity()

                override fun visitToolExecution(toolExecution: McpToolExecutionError) =
                    toolExecution.validity()

                override fun visitHttp(http: HttpError) = http.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is McpToolCallError &&
            protocol == other.protocol &&
            toolExecution == other.toolExecution &&
            http == other.http
    }

    override fun hashCode(): Int = Objects.hash(protocol, toolExecution, http)

    override fun toString(): String =
        when {
            protocol != null -> "McpToolCallError{protocol=$protocol}"
            toolExecution != null -> "McpToolCallError{toolExecution=$toolExecution}"
            http != null -> "McpToolCallError{http=$http}"
            _json != null -> "McpToolCallError{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid McpToolCallError")
        }

    companion object {

        @JvmStatic
        fun ofProtocol(protocol: McpProtocolError) = McpToolCallError(protocol = protocol)

        @JvmStatic
        fun ofToolExecution(toolExecution: McpToolExecutionError) =
            McpToolCallError(toolExecution = toolExecution)

        @JvmStatic fun ofHttp(http: HttpError) = McpToolCallError(http = http)
    }

    /**
     * An interface that defines how to map each variant of [McpToolCallError] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitProtocol(protocol: McpProtocolError): T

        fun visitToolExecution(toolExecution: McpToolExecutionError): T

        fun visitHttp(http: HttpError): T

        /**
         * Maps an unknown variant of [McpToolCallError] to a value of type [T].
         *
         * An instance of [McpToolCallError] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown McpToolCallError: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<McpToolCallError>(McpToolCallError::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): McpToolCallError {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "mcp_protocol_error" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpProtocolError>())?.let {
                        McpToolCallError(protocol = it, _json = json)
                    } ?: McpToolCallError(_json = json)
                }
                "mcp_tool_execution_error" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpToolExecutionError>())?.let {
                        McpToolCallError(toolExecution = it, _json = json)
                    } ?: McpToolCallError(_json = json)
                }
                "http_error" -> {
                    return tryDeserialize(node, jacksonTypeRef<HttpError>())?.let {
                        McpToolCallError(http = it, _json = json)
                    } ?: McpToolCallError(_json = json)
                }
            }

            return McpToolCallError(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<McpToolCallError>(McpToolCallError::class) {

        override fun serialize(
            value: McpToolCallError,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.protocol != null -> generator.writeObject(value.protocol)
                value.toolExecution != null -> generator.writeObject(value.toolExecution)
                value.http != null -> generator.writeObject(value.http)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid McpToolCallError")
            }
        }
    }

    class McpProtocolError
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<Long>,
        private val message: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(code, message, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): Long = code.getRequired("code")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_protocol_error")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Long> = code

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
             * Returns a mutable builder for constructing an instance of [McpProtocolError].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpProtocolError]. */
        class Builder internal constructor() {

            private var code: JsonField<Long>? = null
            private var message: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("mcp_protocol_error")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpProtocolError: McpProtocolError) = apply {
                code = mcpProtocolError.code
                message = mcpProtocolError.message
                type = mcpProtocolError.type
                additionalProperties = mcpProtocolError.additionalProperties.toMutableMap()
            }

            fun code(code: Long) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<Long>) = apply { this.code = code }

            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_protocol_error")
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
             * Returns an immutable instance of [McpProtocolError].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpProtocolError =
                McpProtocolError(
                    checkRequired("code", code),
                    checkRequired("message", message),
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
        fun validate(): McpProtocolError = apply {
            if (validated) {
                return@apply
            }

            code()
            message()
            _type().let {
                if (it != JsonValue.from("mcp_protocol_error")) {
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
            (if (code.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp_protocol_error")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpProtocolError &&
                code == other.code &&
                message == other.message &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, message, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpProtocolError{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
    }

    class McpToolExecutionError
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonValue,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content") @ExcludeMissing content: JsonValue = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(content, type, mutableMapOf())

        /**
         * This arbitrary value can be deserialized into a custom type using the `convert` method:
         * ```java
         * MyClass myObject = mcpToolExecutionError.content().convert(MyClass.class);
         * ```
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonValue = content

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_tool_execution_error")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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
             * Returns a mutable builder for constructing an instance of [McpToolExecutionError].
             *
             * The following fields are required:
             * ```java
             * .content()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpToolExecutionError]. */
        class Builder internal constructor() {

            private var content: JsonValue? = null
            private var type: JsonValue = JsonValue.from("mcp_tool_execution_error")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpToolExecutionError: McpToolExecutionError) = apply {
                content = mcpToolExecutionError.content
                type = mcpToolExecutionError.type
                additionalProperties = mcpToolExecutionError.additionalProperties.toMutableMap()
            }

            fun content(content: JsonValue) = apply { this.content = content }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_tool_execution_error")
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
             * Returns an immutable instance of [McpToolExecutionError].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .content()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpToolExecutionError =
                McpToolExecutionError(
                    checkRequired("content", content),
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
        fun validate(): McpToolExecutionError = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("mcp_tool_execution_error")) {
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
            type.let { if (it == JsonValue.from("mcp_tool_execution_error")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpToolExecutionError &&
                content == other.content &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(content, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpToolExecutionError{content=$content, type=$type, additionalProperties=$additionalProperties}"
    }

    class HttpError
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<Long>,
        private val message: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(code, message, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): Long = code.getRequired("code")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("http_error")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Long> = code

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
             * Returns a mutable builder for constructing an instance of [HttpError].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [HttpError]. */
        class Builder internal constructor() {

            private var code: JsonField<Long>? = null
            private var message: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("http_error")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(httpError: HttpError) = apply {
                code = httpError.code
                message = httpError.message
                type = httpError.type
                additionalProperties = httpError.additionalProperties.toMutableMap()
            }

            fun code(code: Long) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<Long>) = apply { this.code = code }

            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("http_error")
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
             * Returns an immutable instance of [HttpError].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): HttpError =
                HttpError(
                    checkRequired("code", code),
                    checkRequired("message", message),
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
        fun validate(): HttpError = apply {
            if (validated) {
                return@apply
            }

            code()
            message()
            _type().let {
                if (it != JsonValue.from("http_error")) {
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
            (if (code.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("http_error")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is HttpError &&
                code == other.code &&
                message == other.message &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, message, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "HttpError{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
    }
}
