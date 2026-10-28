// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

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
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A user message containing input text, images, or JSON. */
@JsonDeserialize(using = DecisionInputItem.Deserializer::class)
@JsonSerialize(using = DecisionInputItem.Serializer::class)
class DecisionInputItem
private constructor(
    private val decisionInputMessage: DecisionInputMessage? = null,
    private val functionCall: FunctionCall? = null,
    private val functionCallOutput: FunctionCallOutput? = null,
    private val customToolCall: CustomToolCall? = null,
    private val customToolCallOutput: CustomToolCallOutput? = null,
    private val _json: JsonValue? = null,
) {

    /** A user message containing input text, images, or JSON. */
    fun decisionInputMessage(): Optional<DecisionInputMessage> =
        Optional.ofNullable(decisionInputMessage)

    fun functionCall(): Optional<FunctionCall> = Optional.ofNullable(functionCall)

    fun functionCallOutput(): Optional<FunctionCallOutput> = Optional.ofNullable(functionCallOutput)

    fun customToolCall(): Optional<CustomToolCall> = Optional.ofNullable(customToolCall)

    fun customToolCallOutput(): Optional<CustomToolCallOutput> =
        Optional.ofNullable(customToolCallOutput)

    fun isDecisionInputMessage(): Boolean = decisionInputMessage != null

    fun isFunctionCall(): Boolean = functionCall != null

    fun isFunctionCallOutput(): Boolean = functionCallOutput != null

    fun isCustomToolCall(): Boolean = customToolCall != null

    fun isCustomToolCallOutput(): Boolean = customToolCallOutput != null

    /** A user message containing input text, images, or JSON. */
    fun asDecisionInputMessage(): DecisionInputMessage =
        decisionInputMessage.getOrThrow("decisionInputMessage")

    fun asFunctionCall(): FunctionCall = functionCall.getOrThrow("functionCall")

    fun asFunctionCallOutput(): FunctionCallOutput =
        functionCallOutput.getOrThrow("functionCallOutput")

    fun asCustomToolCall(): CustomToolCall = customToolCall.getOrThrow("customToolCall")

    fun asCustomToolCallOutput(): CustomToolCallOutput =
        customToolCallOutput.getOrThrow("customToolCallOutput")

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
     * Optional<String> result = decisionInputItem.accept(new DecisionInputItem.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitDecisionInputMessage(DecisionInputMessage decisionInputMessage) {
     *         return Optional.of(decisionInputMessage.toString());
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
            decisionInputMessage != null -> visitor.visitDecisionInputMessage(decisionInputMessage)
            functionCall != null -> visitor.visitFunctionCall(functionCall)
            functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
            customToolCall != null -> visitor.visitCustomToolCall(customToolCall)
            customToolCallOutput != null -> visitor.visitCustomToolCallOutput(customToolCallOutput)
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
    fun validate(): DecisionInputItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitDecisionInputMessage(decisionInputMessage: DecisionInputMessage) {
                    decisionInputMessage.validate()
                }

                override fun visitFunctionCall(functionCall: FunctionCall) {
                    functionCall.validate()
                }

                override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) {
                    functionCallOutput.validate()
                }

                override fun visitCustomToolCall(customToolCall: CustomToolCall) {
                    customToolCall.validate()
                }

                override fun visitCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput) {
                    customToolCallOutput.validate()
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
                override fun visitDecisionInputMessage(decisionInputMessage: DecisionInputMessage) =
                    decisionInputMessage.validity()

                override fun visitFunctionCall(functionCall: FunctionCall) = functionCall.validity()

                override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
                    functionCallOutput.validity()

                override fun visitCustomToolCall(customToolCall: CustomToolCall) =
                    customToolCall.validity()

                override fun visitCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput) =
                    customToolCallOutput.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionInputItem &&
            decisionInputMessage == other.decisionInputMessage &&
            functionCall == other.functionCall &&
            functionCallOutput == other.functionCallOutput &&
            customToolCall == other.customToolCall &&
            customToolCallOutput == other.customToolCallOutput &&
            (decisionInputMessage != null ||
                functionCall != null ||
                functionCallOutput != null ||
                customToolCall != null ||
                customToolCallOutput != null ||
                _json == other._json)
    }

    override fun hashCode(): Int =
        if (
            decisionInputMessage == null &&
                functionCall == null &&
                functionCallOutput == null &&
                customToolCall == null &&
                customToolCallOutput == null
        )
            Objects.hash(_json)
        else
            Objects.hash(
                decisionInputMessage,
                functionCall,
                functionCallOutput,
                customToolCall,
                customToolCallOutput,
            )

    override fun toString(): String =
        when {
            decisionInputMessage != null ->
                "DecisionInputItem{decisionInputMessage=$decisionInputMessage}"
            functionCall != null -> "DecisionInputItem{functionCall=$functionCall}"
            functionCallOutput != null ->
                "DecisionInputItem{functionCallOutput=$functionCallOutput}"
            customToolCall != null -> "DecisionInputItem{customToolCall=$customToolCall}"
            customToolCallOutput != null ->
                "DecisionInputItem{customToolCallOutput=$customToolCallOutput}"
            _json != null -> "DecisionInputItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid DecisionInputItem")
        }

    companion object {

        /** A user message containing input text, images, or JSON. */
        @JvmStatic
        fun ofDecisionInputMessage(decisionInputMessage: DecisionInputMessage) =
            DecisionInputItem(decisionInputMessage = decisionInputMessage)

        @JvmStatic
        fun ofFunctionCall(functionCall: FunctionCall) =
            DecisionInputItem(functionCall = functionCall)

        @JvmStatic
        fun ofFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
            DecisionInputItem(functionCallOutput = functionCallOutput)

        @JvmStatic
        fun ofCustomToolCall(customToolCall: CustomToolCall) =
            DecisionInputItem(customToolCall = customToolCall)

        @JvmStatic
        fun ofCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput) =
            DecisionInputItem(customToolCallOutput = customToolCallOutput)
    }

    /**
     * An interface that defines how to map each variant of [DecisionInputItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A user message containing input text, images, or JSON. */
        fun visitDecisionInputMessage(decisionInputMessage: DecisionInputMessage): T

        fun visitFunctionCall(functionCall: FunctionCall): T

        fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput): T

        fun visitCustomToolCall(customToolCall: CustomToolCall): T

        fun visitCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput): T

        /**
         * Maps an unknown variant of [DecisionInputItem] to a value of type [T].
         *
         * An instance of [DecisionInputItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown DecisionInputItem")
        }
    }

    internal class Deserializer : BaseDeserializer<DecisionInputItem>(DecisionInputItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): DecisionInputItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "function_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<FunctionCall>())?.let {
                        DecisionInputItem(functionCall = it, _json = json)
                    } ?: DecisionInputItem(_json = json)
                }
                "function_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<FunctionCallOutput>())?.let {
                        DecisionInputItem(functionCallOutput = it, _json = json)
                    } ?: DecisionInputItem(_json = json)
                }
                "custom_tool_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<CustomToolCall>())?.let {
                        DecisionInputItem(customToolCall = it, _json = json)
                    } ?: DecisionInputItem(_json = json)
                }
                "custom_tool_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<CustomToolCallOutput>())?.let {
                        DecisionInputItem(customToolCallOutput = it, _json = json)
                    } ?: DecisionInputItem(_json = json)
                }
            }

            return tryDeserialize(node, jacksonTypeRef<DecisionInputMessage>())?.let {
                DecisionInputItem(decisionInputMessage = it, _json = json)
            } ?: DecisionInputItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<DecisionInputItem>(DecisionInputItem::class) {

        override fun serialize(
            value: DecisionInputItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.decisionInputMessage != null ->
                    generator.writeObject(value.decisionInputMessage)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.functionCallOutput != null -> generator.writeObject(value.functionCallOutput)
                value.customToolCall != null -> generator.writeObject(value.customToolCall)
                value.customToolCallOutput != null ->
                    generator.writeObject(value.customToolCallOutput)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid DecisionInputItem")
            }
        }
    }

    class FunctionCall
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val arguments: JsonField<String>,
        private val callId: JsonField<String>,
        private val name: JsonField<String>,
        private val type: JsonValue,
        private val id: JsonField<String>,
        private val namespace: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("arguments")
            @ExcludeMissing
            arguments: JsonField<String> = JsonMissing.of(),
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("namespace")
            @ExcludeMissing
            namespace: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(arguments, callId, name, type, id, namespace, status, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("function_call")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun namespace(): Optional<String> = namespace.getOptional("namespace")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [arguments].
         *
         * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [namespace].
         *
         * Unlike [namespace], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("namespace") @ExcludeMissing fun _namespace(): JsonField<String> = namespace

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
                "arguments" to this.arguments,
                "call_id" to this.callId,
                "name" to this.name,
                "type" to this.type,
                "id" to this.id,
                "namespace" to this.namespace,
                "status" to this.status,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [FunctionCall].
             *
             * The following fields are required:
             * ```java
             * .arguments()
             * .callId()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FunctionCall]. */
        class Builder internal constructor() {

            private var arguments: JsonField<String>? = null
            private var callId: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("function_call")
            private var id: JsonField<String> = JsonMissing.of()
            private var namespace: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(functionCall: FunctionCall) = apply {
                arguments = functionCall.arguments
                callId = functionCall.callId
                name = functionCall.name
                type = functionCall.type
                id = functionCall.id
                namespace = functionCall.namespace
                status = functionCall.status
                additionalProperties = functionCall.additionalProperties.toMutableMap()
            }

            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * Sets [Builder.arguments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.arguments] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("function_call")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            fun id(id: String?) = id(JsonField.ofNullable(id))

            /** Alias for calling [Builder.id] with `id.orElse(null)`. */
            fun id(id: Optional<String>) = id(id.getOrNull())

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun namespace(namespace: String?) = namespace(JsonField.ofNullable(namespace))

            /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
            fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

            /**
             * Sets [Builder.namespace] to an arbitrary JSON value.
             *
             * You should usually call [Builder.namespace] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun namespace(namespace: JsonField<String>) = apply { this.namespace = namespace }

            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [FunctionCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .arguments()
             * .callId()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FunctionCall =
                FunctionCall(
                    checkRequired("arguments", arguments),
                    checkRequired("callId", callId),
                    checkRequired("name", name),
                    type,
                    id,
                    namespace,
                    status,
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
        fun validate(): FunctionCall = apply {
            if (validated) {
                return@apply
            }

            arguments()
            callId()
            name()
            _type().let {
                if (it != JsonValue.from("function_call")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            id()
            namespace()
            status().ifPresent { it.validate() }
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
            (if (arguments.asKnown().isPresent) 1 else 0) +
                (if (callId.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("function_call")) 1 else 0 } +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (namespace.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
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
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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
            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FunctionCall &&
                arguments == other.arguments &&
                callId == other.callId &&
                name == other.name &&
                type == other.type &&
                id == other.id &&
                namespace == other.namespace &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(arguments, callId, name, type, id, namespace, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FunctionCall{arguments=$arguments, callId=$callId, name=$name, type=$type, id=$id, namespace=$namespace, status=$status, additionalProperties=$additionalProperties}"
    }

    class FunctionCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val output: JsonField<Output>,
        private val type: JsonValue,
        private val id: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<Output> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(callId, output, type, id, status, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Text evidence or an ordered list of text and image parts.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun output(): Output = output.getRequired("output")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("function_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<Output> = output

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
                "call_id" to this.callId,
                "output" to this.output,
                "type" to this.type,
                "id" to this.id,
                "status" to this.status,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [FunctionCallOutput].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .output()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FunctionCallOutput]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var output: JsonField<Output>? = null
            private var type: JsonValue = JsonValue.from("function_call_output")
            private var id: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(functionCallOutput: FunctionCallOutput) = apply {
                callId = functionCallOutput.callId
                output = functionCallOutput.output
                type = functionCallOutput.type
                id = functionCallOutput.id
                status = functionCallOutput.status
                additionalProperties = functionCallOutput.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** Text evidence or an ordered list of text and image parts. */
            fun output(output: Output) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [Output] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<Output>) = apply { this.output = output }

            /** Alias for calling [output] with `Output.ofString(string)`. */
            fun output(string: String) = output(Output.ofString(string))

            /**
             * Alias for calling [output] with
             * `Output.ofUnnamedSchemaWithArrayParent1s(unnamedSchemaWithArrayParent1s)`.
             */
            fun outputOfUnnamedSchemaWithArrayParent1s(
                unnamedSchemaWithArrayParent1s: List<Output.UnnamedSchemaWithArrayParent1>
            ) = output(Output.ofUnnamedSchemaWithArrayParent1s(unnamedSchemaWithArrayParent1s))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("function_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            fun id(id: String?) = id(JsonField.ofNullable(id))

            /** Alias for calling [Builder.id] with `id.orElse(null)`. */
            fun id(id: Optional<String>) = id(id.getOrNull())

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [FunctionCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .output()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FunctionCallOutput =
                FunctionCallOutput(
                    checkRequired("callId", callId),
                    checkRequired("output", output),
                    type,
                    id,
                    status,
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
        fun validate(): FunctionCallOutput = apply {
            if (validated) {
                return@apply
            }

            callId()
            output().validate()
            _type().let {
                if (it != JsonValue.from("function_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            id()
            status().ifPresent { it.validate() }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                (output.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("function_call_output")) 1 else 0 } +
                (if (id.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        /** Text evidence or an ordered list of text and image parts. */
        @JsonDeserialize(using = Output.Deserializer::class)
        @JsonSerialize(using = Output.Serializer::class)
        class Output
        private constructor(
            private val string: String? = null,
            private val unnamedSchemaWithArrayParent1s: List<UnnamedSchemaWithArrayParent1>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun unnamedSchemaWithArrayParent1s(): Optional<List<UnnamedSchemaWithArrayParent1>> =
                Optional.ofNullable(unnamedSchemaWithArrayParent1s)

            fun isString(): Boolean = string != null

            fun isUnnamedSchemaWithArrayParent1s(): Boolean = unnamedSchemaWithArrayParent1s != null

            fun asString(): String = string.getOrThrow("string")

            fun asUnnamedSchemaWithArrayParent1s(): List<UnnamedSchemaWithArrayParent1> =
                unnamedSchemaWithArrayParent1s.getOrThrow("unnamedSchemaWithArrayParent1s")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = output.accept(new Output.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitString(String string) {
             *         return Optional.of(string.toString());
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    unnamedSchemaWithArrayParent1s != null ->
                        visitor.visitUnnamedSchemaWithArrayParent1s(unnamedSchemaWithArrayParent1s)
                    else -> visitor.unknown(_json)
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
            fun validate(): Output = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitUnnamedSchemaWithArrayParent1s(
                            unnamedSchemaWithArrayParent1s: List<UnnamedSchemaWithArrayParent1>
                        ) {
                            unnamedSchemaWithArrayParent1s.forEach { it.validate() }
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
                        override fun visitString(string: String) = 1

                        override fun visitUnnamedSchemaWithArrayParent1s(
                            unnamedSchemaWithArrayParent1s: List<UnnamedSchemaWithArrayParent1>
                        ) = unnamedSchemaWithArrayParent1s.sumOf { it.validity().toInt() }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Output &&
                    string == other.string &&
                    unnamedSchemaWithArrayParent1s == other.unnamedSchemaWithArrayParent1s &&
                    (string != null ||
                        unnamedSchemaWithArrayParent1s != null ||
                        _json == other._json)
            }

            override fun hashCode(): Int =
                if (string == null && unnamedSchemaWithArrayParent1s == null) Objects.hash(_json)
                else Objects.hash(string, unnamedSchemaWithArrayParent1s)

            override fun toString(): String =
                when {
                    string != null -> "Output{string=$string}"
                    unnamedSchemaWithArrayParent1s != null ->
                        "Output{unnamedSchemaWithArrayParent1s=$unnamedSchemaWithArrayParent1s}"
                    _json != null -> "Output{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Output")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = Output(string = string)

                @JvmStatic
                fun ofUnnamedSchemaWithArrayParent1s(
                    unnamedSchemaWithArrayParent1s: List<UnnamedSchemaWithArrayParent1>
                ) =
                    Output(
                        unnamedSchemaWithArrayParent1s =
                            unnamedSchemaWithArrayParent1s.toImmutable()
                    )
            }

            /**
             * An interface that defines how to map each variant of [Output] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitUnnamedSchemaWithArrayParent1s(
                    unnamedSchemaWithArrayParent1s: List<UnnamedSchemaWithArrayParent1>
                ): T

                /**
                 * Maps an unknown variant of [Output] to a value of type [T].
                 *
                 * An instance of [Output] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Output")
                }
            }

            internal class Deserializer : BaseDeserializer<Output>(Output::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Output {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Output(string = it, _json = json)
                                },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<List<UnnamedSchemaWithArrayParent1>>(),
                                    )
                                    ?.let {
                                        Output(unnamedSchemaWithArrayParent1s = it, _json = json)
                                    },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Output(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Output>(Output::class) {

                override fun serialize(
                    value: Output,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.unnamedSchemaWithArrayParent1s != null ->
                            generator.writeObject(value.unnamedSchemaWithArrayParent1s)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Output")
                    }
                }
            }

            /**
             * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs
             * are not supported.
             */
            @JsonDeserialize(using = UnnamedSchemaWithArrayParent1.Deserializer::class)
            @JsonSerialize(using = UnnamedSchemaWithArrayParent1.Serializer::class)
            class UnnamedSchemaWithArrayParent1
            private constructor(
                private val inputText: DecisionInputText? = null,
                private val inputImage: DecisionInputImage? = null,
                private val _json: JsonValue? = null,
            ) {

                fun inputText(): Optional<DecisionInputText> = Optional.ofNullable(inputText)

                /**
                 * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File
                 * IDs are not supported.
                 */
                fun inputImage(): Optional<DecisionInputImage> = Optional.ofNullable(inputImage)

                fun isInputText(): Boolean = inputText != null

                fun isInputImage(): Boolean = inputImage != null

                fun asInputText(): DecisionInputText = inputText.getOrThrow("inputText")

                /**
                 * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File
                 * IDs are not supported.
                 */
                fun asInputImage(): DecisionInputImage = inputImage.getOrThrow("inputImage")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = unnamedSchemaWithArrayParent1.accept(new UnnamedSchemaWithArrayParent1.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitInputText(DecisionInputText inputText) {
                 *         return Optional.of(inputText.toString());
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
                 * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                 *   [visitor] and the current variant is unknown.
                 */
                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        inputText != null -> visitor.visitInputText(inputText)
                        inputImage != null -> visitor.visitInputImage(inputImage)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): UnnamedSchemaWithArrayParent1 = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitInputText(inputText: DecisionInputText) {
                                inputText.validate()
                            }

                            override fun visitInputImage(inputImage: DecisionInputImage) {
                                inputImage.validate()
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
                            override fun visitInputText(inputText: DecisionInputText) =
                                inputText.validity()

                            override fun visitInputImage(inputImage: DecisionInputImage) =
                                inputImage.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnnamedSchemaWithArrayParent1 &&
                        inputText == other.inputText &&
                        inputImage == other.inputImage &&
                        (inputText != null || inputImage != null || _json == other._json)
                }

                override fun hashCode(): Int =
                    if (inputText == null && inputImage == null) Objects.hash(_json)
                    else Objects.hash(inputText, inputImage)

                override fun toString(): String =
                    when {
                        inputText != null -> "UnnamedSchemaWithArrayParent1{inputText=$inputText}"
                        inputImage != null ->
                            "UnnamedSchemaWithArrayParent1{inputImage=$inputImage}"
                        _json != null -> "UnnamedSchemaWithArrayParent1{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent1")
                    }

                companion object {

                    @JvmStatic
                    fun ofInputText(inputText: DecisionInputText) =
                        UnnamedSchemaWithArrayParent1(inputText = inputText)

                    /**
                     * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL.
                     * File IDs are not supported.
                     */
                    @JvmStatic
                    fun ofInputImage(inputImage: DecisionInputImage) =
                        UnnamedSchemaWithArrayParent1(inputImage = inputImage)
                }

                /**
                 * An interface that defines how to map each variant of
                 * [UnnamedSchemaWithArrayParent1] to a value of type [T].
                 */
                interface Visitor<out T> {

                    fun visitInputText(inputText: DecisionInputText): T

                    /**
                     * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL.
                     * File IDs are not supported.
                     */
                    fun visitInputImage(inputImage: DecisionInputImage): T

                    /**
                     * Maps an unknown variant of [UnnamedSchemaWithArrayParent1] to a value of type
                     * [T].
                     *
                     * An instance of [UnnamedSchemaWithArrayParent1] can contain an unknown variant
                     * if it was deserialized from data that doesn't match any known variant. For
                     * example, if the SDK is on an older version than the API, then the API may
                     * respond with new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown UnnamedSchemaWithArrayParent1")
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<UnnamedSchemaWithArrayParent1>(
                        UnnamedSchemaWithArrayParent1::class
                    ) {

                    override fun ObjectCodec.deserialize(
                        node: JsonNode
                    ): UnnamedSchemaWithArrayParent1 {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "input_text" -> {
                                return tryDeserialize(node, jacksonTypeRef<DecisionInputText>())
                                    ?.let {
                                        UnnamedSchemaWithArrayParent1(inputText = it, _json = json)
                                    } ?: UnnamedSchemaWithArrayParent1(_json = json)
                            }
                            "input_image" -> {
                                return tryDeserialize(node, jacksonTypeRef<DecisionInputImage>())
                                    ?.let {
                                        UnnamedSchemaWithArrayParent1(inputImage = it, _json = json)
                                    } ?: UnnamedSchemaWithArrayParent1(_json = json)
                            }
                        }

                        return UnnamedSchemaWithArrayParent1(_json = json)
                    }
                }

                internal class Serializer :
                    BaseSerializer<UnnamedSchemaWithArrayParent1>(
                        UnnamedSchemaWithArrayParent1::class
                    ) {

                    override fun serialize(
                        value: UnnamedSchemaWithArrayParent1,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.inputText != null -> generator.writeObject(value.inputText)
                            value.inputImage != null -> generator.writeObject(value.inputImage)
                            value._json != null -> generator.writeObject(value._json)
                            else ->
                                throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent1")
                        }
                    }
                }
            }
        }

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
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
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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
            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FunctionCallOutput &&
                callId == other.callId &&
                output == other.output &&
                type == other.type &&
                id == other.id &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(callId, output, type, id, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FunctionCallOutput{callId=$callId, output=$output, type=$type, id=$id, status=$status, additionalProperties=$additionalProperties}"
    }

    class CustomToolCall
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val input: JsonField<String>,
        private val name: JsonField<String>,
        private val type: JsonValue,
        private val id: JsonField<String>,
        private val namespace: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("input") @ExcludeMissing input: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("namespace")
            @ExcludeMissing
            namespace: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(callId, input, name, type, id, namespace, status, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): String = input.getRequired("input")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("custom_tool_call")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun namespace(): Optional<String> = namespace.getOptional("namespace")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [namespace].
         *
         * Unlike [namespace], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("namespace") @ExcludeMissing fun _namespace(): JsonField<String> = namespace

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
                "call_id" to this.callId,
                "input" to this.input,
                "name" to this.name,
                "type" to this.type,
                "id" to this.id,
                "namespace" to this.namespace,
                "status" to this.status,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [CustomToolCall].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .input()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CustomToolCall]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var input: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("custom_tool_call")
            private var id: JsonField<String> = JsonMissing.of()
            private var namespace: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(customToolCall: CustomToolCall) = apply {
                callId = customToolCall.callId
                input = customToolCall.input
                name = customToolCall.name
                type = customToolCall.type
                id = customToolCall.id
                namespace = customToolCall.namespace
                status = customToolCall.status
                additionalProperties = customToolCall.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            fun input(input: String) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun input(input: JsonField<String>) = apply { this.input = input }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("custom_tool_call")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            fun id(id: String?) = id(JsonField.ofNullable(id))

            /** Alias for calling [Builder.id] with `id.orElse(null)`. */
            fun id(id: Optional<String>) = id(id.getOrNull())

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun namespace(namespace: String?) = namespace(JsonField.ofNullable(namespace))

            /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
            fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

            /**
             * Sets [Builder.namespace] to an arbitrary JSON value.
             *
             * You should usually call [Builder.namespace] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun namespace(namespace: JsonField<String>) = apply { this.namespace = namespace }

            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [CustomToolCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .input()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CustomToolCall =
                CustomToolCall(
                    checkRequired("callId", callId),
                    checkRequired("input", input),
                    checkRequired("name", name),
                    type,
                    id,
                    namespace,
                    status,
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
        fun validate(): CustomToolCall = apply {
            if (validated) {
                return@apply
            }

            callId()
            input()
            name()
            _type().let {
                if (it != JsonValue.from("custom_tool_call")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            id()
            namespace()
            status().ifPresent { it.validate() }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                (if (input.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("custom_tool_call")) 1 else 0 } +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (namespace.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
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
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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
            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CustomToolCall &&
                callId == other.callId &&
                input == other.input &&
                name == other.name &&
                type == other.type &&
                id == other.id &&
                namespace == other.namespace &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(callId, input, name, type, id, namespace, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CustomToolCall{callId=$callId, input=$input, name=$name, type=$type, id=$id, namespace=$namespace, status=$status, additionalProperties=$additionalProperties}"
    }

    class CustomToolCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val output: JsonField<Output>,
        private val type: JsonValue,
        private val id: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<Output> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(callId, output, type, id, status, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Text evidence or an ordered list of text and image parts.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun output(): Output = output.getRequired("output")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("custom_tool_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<Output> = output

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
                "call_id" to this.callId,
                "output" to this.output,
                "type" to this.type,
                "id" to this.id,
                "status" to this.status,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [CustomToolCallOutput].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .output()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CustomToolCallOutput]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var output: JsonField<Output>? = null
            private var type: JsonValue = JsonValue.from("custom_tool_call_output")
            private var id: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(customToolCallOutput: CustomToolCallOutput) = apply {
                callId = customToolCallOutput.callId
                output = customToolCallOutput.output
                type = customToolCallOutput.type
                id = customToolCallOutput.id
                status = customToolCallOutput.status
                additionalProperties = customToolCallOutput.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** Text evidence or an ordered list of text and image parts. */
            fun output(output: Output) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [Output] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<Output>) = apply { this.output = output }

            /** Alias for calling [output] with `Output.ofString(string)`. */
            fun output(string: String) = output(Output.ofString(string))

            /**
             * Alias for calling [output] with
             * `Output.ofUnnamedSchemaWithArrayParent2s(unnamedSchemaWithArrayParent2s)`.
             */
            fun outputOfUnnamedSchemaWithArrayParent2s(
                unnamedSchemaWithArrayParent2s: List<Output.UnnamedSchemaWithArrayParent2>
            ) = output(Output.ofUnnamedSchemaWithArrayParent2s(unnamedSchemaWithArrayParent2s))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("custom_tool_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            fun id(id: String?) = id(JsonField.ofNullable(id))

            /** Alias for calling [Builder.id] with `id.orElse(null)`. */
            fun id(id: Optional<String>) = id(id.getOrNull())

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [CustomToolCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .output()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CustomToolCallOutput =
                CustomToolCallOutput(
                    checkRequired("callId", callId),
                    checkRequired("output", output),
                    type,
                    id,
                    status,
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
        fun validate(): CustomToolCallOutput = apply {
            if (validated) {
                return@apply
            }

            callId()
            output().validate()
            _type().let {
                if (it != JsonValue.from("custom_tool_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            id()
            status().ifPresent { it.validate() }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                (output.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("custom_tool_call_output")) 1 else 0 } +
                (if (id.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        /** Text evidence or an ordered list of text and image parts. */
        @JsonDeserialize(using = Output.Deserializer::class)
        @JsonSerialize(using = Output.Serializer::class)
        class Output
        private constructor(
            private val string: String? = null,
            private val unnamedSchemaWithArrayParent2s: List<UnnamedSchemaWithArrayParent2>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun unnamedSchemaWithArrayParent2s(): Optional<List<UnnamedSchemaWithArrayParent2>> =
                Optional.ofNullable(unnamedSchemaWithArrayParent2s)

            fun isString(): Boolean = string != null

            fun isUnnamedSchemaWithArrayParent2s(): Boolean = unnamedSchemaWithArrayParent2s != null

            fun asString(): String = string.getOrThrow("string")

            fun asUnnamedSchemaWithArrayParent2s(): List<UnnamedSchemaWithArrayParent2> =
                unnamedSchemaWithArrayParent2s.getOrThrow("unnamedSchemaWithArrayParent2s")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = output.accept(new Output.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitString(String string) {
             *         return Optional.of(string.toString());
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    unnamedSchemaWithArrayParent2s != null ->
                        visitor.visitUnnamedSchemaWithArrayParent2s(unnamedSchemaWithArrayParent2s)
                    else -> visitor.unknown(_json)
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
            fun validate(): Output = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitUnnamedSchemaWithArrayParent2s(
                            unnamedSchemaWithArrayParent2s: List<UnnamedSchemaWithArrayParent2>
                        ) {
                            unnamedSchemaWithArrayParent2s.forEach { it.validate() }
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
                        override fun visitString(string: String) = 1

                        override fun visitUnnamedSchemaWithArrayParent2s(
                            unnamedSchemaWithArrayParent2s: List<UnnamedSchemaWithArrayParent2>
                        ) = unnamedSchemaWithArrayParent2s.sumOf { it.validity().toInt() }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Output &&
                    string == other.string &&
                    unnamedSchemaWithArrayParent2s == other.unnamedSchemaWithArrayParent2s &&
                    (string != null ||
                        unnamedSchemaWithArrayParent2s != null ||
                        _json == other._json)
            }

            override fun hashCode(): Int =
                if (string == null && unnamedSchemaWithArrayParent2s == null) Objects.hash(_json)
                else Objects.hash(string, unnamedSchemaWithArrayParent2s)

            override fun toString(): String =
                when {
                    string != null -> "Output{string=$string}"
                    unnamedSchemaWithArrayParent2s != null ->
                        "Output{unnamedSchemaWithArrayParent2s=$unnamedSchemaWithArrayParent2s}"
                    _json != null -> "Output{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Output")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = Output(string = string)

                @JvmStatic
                fun ofUnnamedSchemaWithArrayParent2s(
                    unnamedSchemaWithArrayParent2s: List<UnnamedSchemaWithArrayParent2>
                ) =
                    Output(
                        unnamedSchemaWithArrayParent2s =
                            unnamedSchemaWithArrayParent2s.toImmutable()
                    )
            }

            /**
             * An interface that defines how to map each variant of [Output] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitUnnamedSchemaWithArrayParent2s(
                    unnamedSchemaWithArrayParent2s: List<UnnamedSchemaWithArrayParent2>
                ): T

                /**
                 * Maps an unknown variant of [Output] to a value of type [T].
                 *
                 * An instance of [Output] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Output")
                }
            }

            internal class Deserializer : BaseDeserializer<Output>(Output::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Output {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Output(string = it, _json = json)
                                },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<List<UnnamedSchemaWithArrayParent2>>(),
                                    )
                                    ?.let {
                                        Output(unnamedSchemaWithArrayParent2s = it, _json = json)
                                    },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Output(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Output>(Output::class) {

                override fun serialize(
                    value: Output,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.unnamedSchemaWithArrayParent2s != null ->
                            generator.writeObject(value.unnamedSchemaWithArrayParent2s)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Output")
                    }
                }
            }

            /**
             * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs
             * are not supported.
             */
            @JsonDeserialize(using = UnnamedSchemaWithArrayParent2.Deserializer::class)
            @JsonSerialize(using = UnnamedSchemaWithArrayParent2.Serializer::class)
            class UnnamedSchemaWithArrayParent2
            private constructor(
                private val inputText: DecisionInputText? = null,
                private val inputImage: DecisionInputImage? = null,
                private val _json: JsonValue? = null,
            ) {

                fun inputText(): Optional<DecisionInputText> = Optional.ofNullable(inputText)

                /**
                 * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File
                 * IDs are not supported.
                 */
                fun inputImage(): Optional<DecisionInputImage> = Optional.ofNullable(inputImage)

                fun isInputText(): Boolean = inputText != null

                fun isInputImage(): Boolean = inputImage != null

                fun asInputText(): DecisionInputText = inputText.getOrThrow("inputText")

                /**
                 * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File
                 * IDs are not supported.
                 */
                fun asInputImage(): DecisionInputImage = inputImage.getOrThrow("inputImage")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = unnamedSchemaWithArrayParent2.accept(new UnnamedSchemaWithArrayParent2.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitInputText(DecisionInputText inputText) {
                 *         return Optional.of(inputText.toString());
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
                 * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                 *   [visitor] and the current variant is unknown.
                 */
                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        inputText != null -> visitor.visitInputText(inputText)
                        inputImage != null -> visitor.visitInputImage(inputImage)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): UnnamedSchemaWithArrayParent2 = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitInputText(inputText: DecisionInputText) {
                                inputText.validate()
                            }

                            override fun visitInputImage(inputImage: DecisionInputImage) {
                                inputImage.validate()
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
                            override fun visitInputText(inputText: DecisionInputText) =
                                inputText.validity()

                            override fun visitInputImage(inputImage: DecisionInputImage) =
                                inputImage.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnnamedSchemaWithArrayParent2 &&
                        inputText == other.inputText &&
                        inputImage == other.inputImage &&
                        (inputText != null || inputImage != null || _json == other._json)
                }

                override fun hashCode(): Int =
                    if (inputText == null && inputImage == null) Objects.hash(_json)
                    else Objects.hash(inputText, inputImage)

                override fun toString(): String =
                    when {
                        inputText != null -> "UnnamedSchemaWithArrayParent2{inputText=$inputText}"
                        inputImage != null ->
                            "UnnamedSchemaWithArrayParent2{inputImage=$inputImage}"
                        _json != null -> "UnnamedSchemaWithArrayParent2{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent2")
                    }

                companion object {

                    @JvmStatic
                    fun ofInputText(inputText: DecisionInputText) =
                        UnnamedSchemaWithArrayParent2(inputText = inputText)

                    /**
                     * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL.
                     * File IDs are not supported.
                     */
                    @JvmStatic
                    fun ofInputImage(inputImage: DecisionInputImage) =
                        UnnamedSchemaWithArrayParent2(inputImage = inputImage)
                }

                /**
                 * An interface that defines how to map each variant of
                 * [UnnamedSchemaWithArrayParent2] to a value of type [T].
                 */
                interface Visitor<out T> {

                    fun visitInputText(inputText: DecisionInputText): T

                    /**
                     * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL.
                     * File IDs are not supported.
                     */
                    fun visitInputImage(inputImage: DecisionInputImage): T

                    /**
                     * Maps an unknown variant of [UnnamedSchemaWithArrayParent2] to a value of type
                     * [T].
                     *
                     * An instance of [UnnamedSchemaWithArrayParent2] can contain an unknown variant
                     * if it was deserialized from data that doesn't match any known variant. For
                     * example, if the SDK is on an older version than the API, then the API may
                     * respond with new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown UnnamedSchemaWithArrayParent2")
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<UnnamedSchemaWithArrayParent2>(
                        UnnamedSchemaWithArrayParent2::class
                    ) {

                    override fun ObjectCodec.deserialize(
                        node: JsonNode
                    ): UnnamedSchemaWithArrayParent2 {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "input_text" -> {
                                return tryDeserialize(node, jacksonTypeRef<DecisionInputText>())
                                    ?.let {
                                        UnnamedSchemaWithArrayParent2(inputText = it, _json = json)
                                    } ?: UnnamedSchemaWithArrayParent2(_json = json)
                            }
                            "input_image" -> {
                                return tryDeserialize(node, jacksonTypeRef<DecisionInputImage>())
                                    ?.let {
                                        UnnamedSchemaWithArrayParent2(inputImage = it, _json = json)
                                    } ?: UnnamedSchemaWithArrayParent2(_json = json)
                            }
                        }

                        return UnnamedSchemaWithArrayParent2(_json = json)
                    }
                }

                internal class Serializer :
                    BaseSerializer<UnnamedSchemaWithArrayParent2>(
                        UnnamedSchemaWithArrayParent2::class
                    ) {

                    override fun serialize(
                        value: UnnamedSchemaWithArrayParent2,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.inputText != null -> generator.writeObject(value.inputText)
                            value.inputImage != null -> generator.writeObject(value.inputImage)
                            value._json != null -> generator.writeObject(value._json)
                            else ->
                                throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent2")
                        }
                    }
                }
            }
        }

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
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
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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
            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CustomToolCallOutput &&
                callId == other.callId &&
                output == other.output &&
                type == other.type &&
                id == other.id &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(callId, output, type, id, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CustomToolCallOutput{callId=$callId, output=$output, type=$type, id=$id, status=$status, additionalProperties=$additionalProperties}"
    }
}
