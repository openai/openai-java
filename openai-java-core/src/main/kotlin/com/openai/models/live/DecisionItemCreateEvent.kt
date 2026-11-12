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
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Append an input item for future decisions without starting an evaluation or changing Live voice
 * context.
 */
class DecisionItemCreateEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val item: JsonField<Item>,
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item") @ExcludeMissing item: JsonField<Item> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
    ) : this(item, type, eventId, mutableMapOf())

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun item(): java.util.Optional<Item> = item.getOptional("item")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun itemOrThrow(): Item = item.getRequired("item")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("decision.item.create")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

    /**
     * Optional client identifier for correlating this command with a server event's client_event_id
     * or error.client_event_id. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun eventId(): java.util.Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun eventIdOrThrow(): String = eventId.getRequired("event_id")

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<Item> = item

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
            "item" to this.item,
            "type" to this.type,
            "event_id" to this.eventId,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DecisionItemCreateEvent].
         *
         * The following fields are required:
         * ```java
         * .item()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionItemCreateEvent]. */
    class Builder internal constructor() {

        private var item: JsonField<Item>? = null
        private var type: JsonValue = JsonValue.from("decision.item.create")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionItemCreateEvent: DecisionItemCreateEvent) = apply {
            item = decisionItemCreateEvent.item
            type = decisionItemCreateEvent.type
            eventId = decisionItemCreateEvent.eventId
            additionalProperties = decisionItemCreateEvent.additionalProperties.toMutableMap()
        }

        fun item(item: Item) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [Item] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun item(item: JsonField<Item>) = apply { this.item = item }

        /** Alias for calling [item] with `Item.ofDecisionUserMessage(decisionUserMessage)`. */
        fun item(decisionUserMessage: DecisionUserMessage) =
            item(Item.ofDecisionUserMessage(decisionUserMessage))

        /**
         * Alias for calling [item] with
         * `Item.ofDecisionDeveloperMessage(decisionDeveloperMessage)`.
         */
        fun item(decisionDeveloperMessage: DecisionDeveloperMessage) =
            item(Item.ofDecisionDeveloperMessage(decisionDeveloperMessage))

        /** Alias for calling [item] with `Item.ofDecisionSystemMessage(decisionSystemMessage)`. */
        fun item(decisionSystemMessage: DecisionSystemMessage) =
            item(Item.ofDecisionSystemMessage(decisionSystemMessage))

        /**
         * Alias for calling [item] with
         * `Item.ofDecisionAssistantMessage(decisionAssistantMessage)`.
         */
        fun item(decisionAssistantMessage: DecisionAssistantMessage) =
            item(Item.ofDecisionAssistantMessage(decisionAssistantMessage))

        /** Alias for calling [item] with `Item.ofFunctionCall(functionCall)`. */
        fun item(functionCall: Item.FunctionCall) = item(Item.ofFunctionCall(functionCall))

        /** Alias for calling [item] with `Item.ofFunctionCallOutput(functionCallOutput)`. */
        fun item(functionCallOutput: Item.FunctionCallOutput) =
            item(Item.ofFunctionCallOutput(functionCallOutput))

        /** Alias for calling [item] with `Item.ofCustomToolCall(customToolCall)`. */
        fun item(customToolCall: Item.CustomToolCall) = item(Item.ofCustomToolCall(customToolCall))

        /** Alias for calling [item] with `Item.ofCustomToolCallOutput(customToolCallOutput)`. */
        fun item(customToolCallOutput: Item.CustomToolCallOutput) =
            item(Item.ofCustomToolCallOutput(customToolCallOutput))

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("decision.item.create")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Optional client identifier for correlating this command with a server event's
         * client_event_id or error.client_event_id.
         */
        fun eventId(eventId: String?) = eventId(JsonField.ofNullable(eventId))

        /** Alias for calling [Builder.eventId] with `eventId.orElse(null)`. */
        fun eventId(eventId: Optional<String>) = eventId(eventId.getOrNull())

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

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
         * Returns an immutable instance of [DecisionItemCreateEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .item()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DecisionItemCreateEvent =
            DecisionItemCreateEvent(
                checkRequired("item", item),
                type,
                eventId,
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
    fun validate(): DecisionItemCreateEvent = apply {
        if (validated) {
            return@apply
        }

        itemOrThrow().validate()
        typeOrThrow()
        eventId()
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
        (item.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("decision.item.create")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0)

    @JsonDeserialize(using = Item.Deserializer::class)
    @JsonSerialize(using = Item.Serializer::class)
    class Item
    private constructor(
        private val decisionUserMessage: DecisionUserMessage? = null,
        private val decisionDeveloperMessage: DecisionDeveloperMessage? = null,
        private val decisionSystemMessage: DecisionSystemMessage? = null,
        private val decisionAssistantMessage: DecisionAssistantMessage? = null,
        private val functionCall: FunctionCall? = null,
        private val functionCallOutput: FunctionCallOutput? = null,
        private val customToolCall: CustomToolCall? = null,
        private val customToolCallOutput: CustomToolCallOutput? = null,
        private val _json: JsonValue? = null,
    ) {

        fun decisionUserMessage(): Optional<DecisionUserMessage> =
            Optional.ofNullable(decisionUserMessage)

        fun decisionDeveloperMessage(): Optional<DecisionDeveloperMessage> =
            Optional.ofNullable(decisionDeveloperMessage)

        fun decisionSystemMessage(): Optional<DecisionSystemMessage> =
            Optional.ofNullable(decisionSystemMessage)

        fun decisionAssistantMessage(): Optional<DecisionAssistantMessage> =
            Optional.ofNullable(decisionAssistantMessage)

        fun functionCall(): Optional<FunctionCall> = Optional.ofNullable(functionCall)

        fun functionCallOutput(): Optional<FunctionCallOutput> =
            Optional.ofNullable(functionCallOutput)

        fun customToolCall(): Optional<CustomToolCall> = Optional.ofNullable(customToolCall)

        fun customToolCallOutput(): Optional<CustomToolCallOutput> =
            Optional.ofNullable(customToolCallOutput)

        fun isDecisionUserMessage(): Boolean = decisionUserMessage != null

        fun isDecisionDeveloperMessage(): Boolean = decisionDeveloperMessage != null

        fun isDecisionSystemMessage(): Boolean = decisionSystemMessage != null

        fun isDecisionAssistantMessage(): Boolean = decisionAssistantMessage != null

        fun isFunctionCall(): Boolean = functionCall != null

        fun isFunctionCallOutput(): Boolean = functionCallOutput != null

        fun isCustomToolCall(): Boolean = customToolCall != null

        fun isCustomToolCallOutput(): Boolean = customToolCallOutput != null

        fun asDecisionUserMessage(): DecisionUserMessage =
            decisionUserMessage.getOrThrow("decisionUserMessage")

        fun asDecisionDeveloperMessage(): DecisionDeveloperMessage =
            decisionDeveloperMessage.getOrThrow("decisionDeveloperMessage")

        fun asDecisionSystemMessage(): DecisionSystemMessage =
            decisionSystemMessage.getOrThrow("decisionSystemMessage")

        fun asDecisionAssistantMessage(): DecisionAssistantMessage =
            decisionAssistantMessage.getOrThrow("decisionAssistantMessage")

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
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = item.accept(new Item.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitDecisionUserMessage(DecisionUserMessage decisionUserMessage) {
         *         return Optional.of(decisionUserMessage.toString());
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
                decisionUserMessage != null -> visitor.visitDecisionUserMessage(decisionUserMessage)
                decisionDeveloperMessage != null ->
                    visitor.visitDecisionDeveloperMessage(decisionDeveloperMessage)
                decisionSystemMessage != null ->
                    visitor.visitDecisionSystemMessage(decisionSystemMessage)
                decisionAssistantMessage != null ->
                    visitor.visitDecisionAssistantMessage(decisionAssistantMessage)
                functionCall != null -> visitor.visitFunctionCall(functionCall)
                functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
                customToolCall != null -> visitor.visitCustomToolCall(customToolCall)
                customToolCallOutput != null ->
                    visitor.visitCustomToolCallOutput(customToolCallOutput)
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
        fun validate(): Item = apply {
            if (validated) {
                return@apply
            }

            if (decisionUserMessage != null && decisionUserMessage._type().isNull()) {
                // The released null-tag contract supports only text and image content.
                val parts = decisionUserMessage._allProperties()["content"]?.asArray()?.getOrNull()
                if (
                    parts != null &&
                        parts.any {
                            val kind = it.asObject().getOrNull()?.get("type")
                            kind != JsonValue.from("input_text") &&
                                kind != JsonValue.from("input_image")
                        }
                ) {
                    throw OpenAIInvalidDataException("Invalid content for a null-type user message")
                }
            }
            accept(
                object : Visitor<Unit> {
                    override fun visitDecisionUserMessage(
                        decisionUserMessage: DecisionUserMessage
                    ) {
                        decisionUserMessage.validate()
                    }

                    override fun visitDecisionDeveloperMessage(
                        decisionDeveloperMessage: DecisionDeveloperMessage
                    ) {
                        if (decisionDeveloperMessage._type().isNull()) {
                            throw OpenAIInvalidDataException(
                                "Only a user message may have a null type"
                            )
                        }
                        decisionDeveloperMessage.validate()
                    }

                    override fun visitDecisionSystemMessage(
                        decisionSystemMessage: DecisionSystemMessage
                    ) {
                        if (decisionSystemMessage._type().isNull()) {
                            throw OpenAIInvalidDataException(
                                "Only a user message may have a null type"
                            )
                        }
                        decisionSystemMessage.validate()
                    }

                    override fun visitDecisionAssistantMessage(
                        decisionAssistantMessage: DecisionAssistantMessage
                    ) {
                        if (decisionAssistantMessage._type().isNull()) {
                            throw OpenAIInvalidDataException(
                                "Only a user message may have a null type"
                            )
                        }
                        decisionAssistantMessage.validate()
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

                    override fun visitCustomToolCallOutput(
                        customToolCallOutput: CustomToolCallOutput
                    ) {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitDecisionUserMessage(
                        decisionUserMessage: DecisionUserMessage
                    ) = decisionUserMessage.validity()

                    override fun visitDecisionDeveloperMessage(
                        decisionDeveloperMessage: DecisionDeveloperMessage
                    ) = decisionDeveloperMessage.validity()

                    override fun visitDecisionSystemMessage(
                        decisionSystemMessage: DecisionSystemMessage
                    ) = decisionSystemMessage.validity()

                    override fun visitDecisionAssistantMessage(
                        decisionAssistantMessage: DecisionAssistantMessage
                    ) = decisionAssistantMessage.validity()

                    override fun visitFunctionCall(functionCall: FunctionCall) =
                        functionCall.validity()

                    override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
                        functionCallOutput.validity()

                    override fun visitCustomToolCall(customToolCall: CustomToolCall) =
                        customToolCall.validity()

                    override fun visitCustomToolCallOutput(
                        customToolCallOutput: CustomToolCallOutput
                    ) = customToolCallOutput.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Item &&
                decisionUserMessage == other.decisionUserMessage &&
                decisionDeveloperMessage == other.decisionDeveloperMessage &&
                decisionSystemMessage == other.decisionSystemMessage &&
                decisionAssistantMessage == other.decisionAssistantMessage &&
                functionCall == other.functionCall &&
                functionCallOutput == other.functionCallOutput &&
                customToolCall == other.customToolCall &&
                customToolCallOutput == other.customToolCallOutput &&
                (decisionUserMessage != null ||
                    decisionDeveloperMessage != null ||
                    decisionSystemMessage != null ||
                    decisionAssistantMessage != null ||
                    functionCall != null ||
                    functionCallOutput != null ||
                    customToolCall != null ||
                    customToolCallOutput != null ||
                    _json == other._json)
        }

        override fun hashCode(): Int =
            if (
                decisionUserMessage == null &&
                    decisionDeveloperMessage == null &&
                    decisionSystemMessage == null &&
                    decisionAssistantMessage == null &&
                    functionCall == null &&
                    functionCallOutput == null &&
                    customToolCall == null &&
                    customToolCallOutput == null
            )
                Objects.hash(_json)
            else
                Objects.hash(
                    decisionUserMessage,
                    decisionDeveloperMessage,
                    decisionSystemMessage,
                    decisionAssistantMessage,
                    functionCall,
                    functionCallOutput,
                    customToolCall,
                    customToolCallOutput,
                )

        override fun toString(): String =
            when {
                decisionUserMessage != null -> "Item{decisionUserMessage=$decisionUserMessage}"
                decisionDeveloperMessage != null ->
                    "Item{decisionDeveloperMessage=$decisionDeveloperMessage}"
                decisionSystemMessage != null ->
                    "Item{decisionSystemMessage=$decisionSystemMessage}"
                decisionAssistantMessage != null ->
                    "Item{decisionAssistantMessage=$decisionAssistantMessage}"
                functionCall != null -> "Item{functionCall=$functionCall}"
                functionCallOutput != null -> "Item{functionCallOutput=$functionCallOutput}"
                customToolCall != null -> "Item{customToolCall=$customToolCall}"
                customToolCallOutput != null -> "Item{customToolCallOutput=$customToolCallOutput}"
                _json != null -> "Item{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Item")
            }

        // Project the final wire fields through the released message accessors.
        private fun legacyMessage(): DecisionUserMessage =
            if (isDecisionUserMessage()) asDecisionUserMessage()
            else checkNotNull(JsonValue.from(this).convert(DecisionUserMessage::class.java))

        fun content(): Optional<Content> = _content().getOptional("content")

        fun contentOrThrow() = _content().getRequired("content")

        fun _content(): JsonField<Content> =
            legacyMessage()._content().map {
                checkNotNull(JsonValue.from(it).convert(Content::class.java))
            }

        fun id() = legacyMessage().id()

        fun idOrThrow(): String = legacyMessage().idOrThrow()

        fun _id(): JsonField<String> = legacyMessage()._id()

        private fun wireField(name: String): JsonValue =
            (_json ?: JsonValue.from(this)).asObject().getOrNull()?.get(name) ?: JsonMissing.of()

        fun role(): Optional<JsonValue> {
            val raw = wireField("role")
            if (raw.isMissing() || raw.isNull()) return Optional.empty()
            return when (raw.asString().getOrNull()) {
                "user",
                "developer",
                "system",
                "assistant" -> Optional.of(raw)
                else -> throw OpenAIInvalidDataException("`role` is invalid")
            }
        }

        fun roleOrThrow(): JsonValue = role().orElseGet { _role().getRequired("role") }

        fun _role(): JsonField<JsonValue> = wireField("role")

        fun type(): Optional<Type> =
            _type().getOptional("type").map { value ->
                when (value.asString()) {
                    "message",
                    "function_call",
                    "function_call_output",
                    "custom_tool_call",
                    "custom_tool_call_output" -> value
                    else -> throw OpenAIInvalidDataException("`type` is invalid")
                }
            }

        fun typeOrThrow(): Type = type().orElseGet { _type().getRequired("type") }

        fun _type(): JsonField<Type> {
            val raw = wireField("type")
            val tag = raw.asString().getOrNull() ?: return raw
            return JsonField.of(Type.of(tag))
        }

        fun _allProperties(): Map<String, JsonValue> = legacyMessage()._allProperties()

        fun toBuilder(): Builder = Builder().from(this)

        /** Builds an item from the final wire fields using the released message defaults. */
        class Builder internal constructor() {
            private val message = DecisionUserMessage.builder()

            internal fun from(value: Item) = apply { message.from(value.legacyMessage()) }

            fun content(value: String) = apply { message.content(value) }

            fun content(value: DecisionUserMessage.Content) = apply { message.content(value) }

            fun content(value: Content) = content(JsonField.of(value))

            fun content(value: JsonField<Content>) = apply {
                message.content(
                    value.map {
                        checkNotNull(
                            JsonValue.from(it).convert(DecisionUserMessage.Content::class.java)
                        )
                    }
                )
            }

            fun contentOfDecisionItemCreateEventItemContentItems(
                values: List<Content.DecisionItemCreateEventItemContentItem>
            ) = content(Content.ofDecisionItemCreateEventItemContentItems(values))

            fun id(value: String?) = apply { message.id(value) }

            fun id(value: Optional<String>) = apply { message.id(value) }

            fun id(value: JsonField<String>) = apply { message.id(value) }

            fun role(value: JsonValue) = apply { message.role(value) }

            fun type(value: DecisionUserMessage.Type) = apply { message.type(value) }

            fun type(value: Type) = type(JsonField.of(value))

            fun type(value: JsonField<Type>) = apply {
                message.type(
                    value.map {
                        checkNotNull(
                            JsonValue.from(it).convert(DecisionUserMessage.Type::class.java)
                        )
                    }
                )
            }

            fun additionalProperties(properties: Map<String, JsonValue>) = apply {
                message.additionalProperties(properties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                message.putAdditionalProperty(key, value)
            }

            fun putAllAdditionalProperties(properties: Map<String, JsonValue>) = apply {
                message.putAllAdditionalProperties(properties)
            }

            fun removeAdditionalProperty(key: String) = apply {
                message.removeAdditionalProperty(key)
            }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                message.removeAllAdditionalProperties(keys)
            }

            fun build(): Item =
                checkNotNull(JsonValue.from(message.build()).convert(Item::class.java))
        }

        companion object {

            /** Creates a builder for the original user-message variant. */
            @JvmStatic fun builder() = Builder()

            @JvmStatic
            fun ofDecisionUserMessage(decisionUserMessage: DecisionUserMessage) =
                Item(decisionUserMessage = decisionUserMessage)

            @JvmStatic
            fun ofDecisionDeveloperMessage(decisionDeveloperMessage: DecisionDeveloperMessage) =
                Item(decisionDeveloperMessage = decisionDeveloperMessage)

            @JvmStatic
            fun ofDecisionSystemMessage(decisionSystemMessage: DecisionSystemMessage) =
                Item(decisionSystemMessage = decisionSystemMessage)

            @JvmStatic
            fun ofDecisionAssistantMessage(decisionAssistantMessage: DecisionAssistantMessage) =
                Item(decisionAssistantMessage = decisionAssistantMessage)

            @JvmStatic
            fun ofFunctionCall(functionCall: FunctionCall) = Item(functionCall = functionCall)

            @JvmStatic
            fun ofFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
                Item(functionCallOutput = functionCallOutput)

            @JvmStatic
            fun ofCustomToolCall(customToolCall: CustomToolCall) =
                Item(customToolCall = customToolCall)

            @JvmStatic
            fun ofCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput) =
                Item(customToolCallOutput = customToolCallOutput)
        }

        /** An interface that defines how to map each variant of [Item] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitDecisionUserMessage(decisionUserMessage: DecisionUserMessage): T =
                unknown(JsonValue.from(decisionUserMessage))

            fun visitDecisionDeveloperMessage(
                decisionDeveloperMessage: DecisionDeveloperMessage
            ): T = unknown(JsonValue.from(decisionDeveloperMessage))

            fun visitDecisionSystemMessage(decisionSystemMessage: DecisionSystemMessage): T =
                unknown(JsonValue.from(decisionSystemMessage))

            fun visitDecisionAssistantMessage(
                decisionAssistantMessage: DecisionAssistantMessage
            ): T = unknown(JsonValue.from(decisionAssistantMessage))

            fun visitFunctionCall(functionCall: FunctionCall): T =
                unknown(JsonValue.from(functionCall))

            fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput): T =
                unknown(JsonValue.from(functionCallOutput))

            fun visitCustomToolCall(customToolCall: CustomToolCall): T =
                unknown(JsonValue.from(customToolCall))

            fun visitCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput): T =
                unknown(JsonValue.from(customToolCallOutput))

            /**
             * Maps an unknown variant of [Item] to a value of type [T].
             *
             * An instance of [Item] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * Unhandled known JSON variants reach this method as JSON values.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Item")
            }
        }

        internal class Deserializer : BaseDeserializer<Item>(Item::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Item {
                val json = JsonValue.fromJsonNode(node)
                val type =
                    json
                        .asObject()
                        .getOrNull()
                        ?.getOrDefault("type", JsonValue.from("message"))
                        ?.asString()
                        ?.getOrNull()

                // Decode the original node so the released null type survives serialization.
                if (node.path("type").isNull && node.path("role").textValue() == "user") {
                    return tryDeserialize(node, jacksonTypeRef<DecisionUserMessage>())
                        ?.let { Item(decisionUserMessage = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: Item(_json = json)
                }
                when (type) {
                    "message" -> {
                        // Select the authored nested tag without validating future payload fields.
                        return when (
                            json.asObject().getOrNull()?.get("role")?.asString()?.getOrNull()
                        ) {
                            "user" ->
                                tryDeserialize(node, jacksonTypeRef<DecisionUserMessage>())?.let {
                                    Item(decisionUserMessage = it, _json = json)
                                } ?: Item(_json = json)
                            "developer" ->
                                tryDeserialize(node, jacksonTypeRef<DecisionDeveloperMessage>())
                                    ?.let { Item(decisionDeveloperMessage = it, _json = json) }
                                    ?: Item(_json = json)
                            "system" ->
                                tryDeserialize(node, jacksonTypeRef<DecisionSystemMessage>())?.let {
                                    Item(decisionSystemMessage = it, _json = json)
                                } ?: Item(_json = json)
                            "assistant" ->
                                tryDeserialize(node, jacksonTypeRef<DecisionAssistantMessage>())
                                    ?.let { Item(decisionAssistantMessage = it, _json = json) }
                                    ?: Item(_json = json)
                            else -> Item(_json = json)
                        }
                    }
                    "function_call" -> {
                        return tryDeserialize(node, jacksonTypeRef<FunctionCall>())?.let {
                            Item(functionCall = it, _json = json)
                        } ?: Item(_json = json)
                    }
                    "function_call_output" -> {
                        return tryDeserialize(node, jacksonTypeRef<FunctionCallOutput>())?.let {
                            Item(functionCallOutput = it, _json = json)
                        } ?: Item(_json = json)
                    }
                    "custom_tool_call" -> {
                        return tryDeserialize(node, jacksonTypeRef<CustomToolCall>())?.let {
                            Item(customToolCall = it, _json = json)
                        } ?: Item(_json = json)
                    }
                    "custom_tool_call_output" -> {
                        return tryDeserialize(node, jacksonTypeRef<CustomToolCallOutput>())?.let {
                            Item(customToolCallOutput = it, _json = json)
                        } ?: Item(_json = json)
                    }
                }

                return Item(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Item>(Item::class) {

            override fun serialize(
                value: Item,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.decisionUserMessage != null ->
                        generator.writeObject(value.decisionUserMessage)
                    value.decisionDeveloperMessage != null ->
                        generator.writeObject(value.decisionDeveloperMessage)
                    value.decisionSystemMessage != null ->
                        generator.writeObject(value.decisionSystemMessage)
                    value.decisionAssistantMessage != null ->
                        generator.writeObject(value.decisionAssistantMessage)
                    value.functionCall != null -> generator.writeObject(value.functionCall)
                    value.functionCallOutput != null ->
                        generator.writeObject(value.functionCallOutput)
                    value.customToolCall != null -> generator.writeObject(value.customToolCall)
                    value.customToolCallOutput != null ->
                        generator.writeObject(value.customToolCallOutput)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Item")
                }
            }
        }

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val MESSAGE = of("message")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Known {
                MESSAGE
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Value {
                MESSAGE,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            fun value(): Value =
                when (this) {
                    MESSAGE -> Value.MESSAGE
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
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            fun known(): Known =
                when (this) {
                    MESSAGE -> Known.MESSAGE
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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
            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The text input to the model. */
        @JsonDeserialize(using = Content.Deserializer::class)
        @JsonSerialize(using = Content.Serializer::class)
        class Content
        private constructor(
            private val string: String? = null,
            private val decisionItemCreateEventItemContentItems:
                List<DecisionItemCreateEventItemContentItem>? =
                null,
            private val _json: JsonValue? = null,
        ) {

            /** The text input to the model. */
            fun string(): Optional<String> = Optional.ofNullable(string)

            fun decisionItemCreateEventItemContentItems():
                Optional<List<DecisionItemCreateEventItemContentItem>> =
                Optional.ofNullable(decisionItemCreateEventItemContentItems)

            fun isString(): Boolean = string != null

            fun isDecisionItemCreateEventItemContentItems(): Boolean =
                decisionItemCreateEventItemContentItems != null

            /** The text input to the model. */
            fun asString(): String = string.getOrThrow("string")

            fun asDecisionItemCreateEventItemContentItems():
                List<DecisionItemCreateEventItemContentItem> =
                decisionItemCreateEventItemContentItems.getOrThrow(
                    "decisionItemCreateEventItemContentItems"
                )

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
             * Optional<String> result = content.accept(new Content.Visitor<Optional<String>>() {
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
                    decisionItemCreateEventItemContentItems != null ->
                        visitor.visitDecisionItemCreateEventItemContentItems(
                            decisionItemCreateEventItemContentItems
                        )
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
            fun validate(): Content = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitDecisionItemCreateEventItemContentItems(
                            decisionItemCreateEventItemContentItems:
                                List<DecisionItemCreateEventItemContentItem>
                        ) {
                            decisionItemCreateEventItemContentItems.forEach { it.validate() }
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

                        override fun visitDecisionItemCreateEventItemContentItems(
                            decisionItemCreateEventItemContentItems:
                                List<DecisionItemCreateEventItemContentItem>
                        ) = decisionItemCreateEventItemContentItems.sumOf { it.validity().toInt() }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Content &&
                    string == other.string &&
                    decisionItemCreateEventItemContentItems ==
                        other.decisionItemCreateEventItemContentItems &&
                    (string != null ||
                        decisionItemCreateEventItemContentItems != null ||
                        _json == other._json)
            }

            override fun hashCode(): Int =
                if (string == null && decisionItemCreateEventItemContentItems == null)
                    Objects.hash(_json)
                else Objects.hash(string, decisionItemCreateEventItemContentItems)

            override fun toString(): String =
                when {
                    string != null -> "Content{string=$string}"
                    decisionItemCreateEventItemContentItems != null ->
                        "Content{decisionItemCreateEventItemContentItems=$decisionItemCreateEventItemContentItems}"
                    _json != null -> "Content{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Content")
                }

            companion object {

                /** The text input to the model. */
                @JvmStatic fun ofString(string: String) = Content(string = string)

                @JvmStatic
                fun ofDecisionItemCreateEventItemContentItems(
                    decisionItemCreateEventItemContentItems:
                        List<DecisionItemCreateEventItemContentItem>
                ) =
                    Content(
                        decisionItemCreateEventItemContentItems =
                            decisionItemCreateEventItemContentItems.toImmutable()
                    )
            }

            /**
             * An interface that defines how to map each variant of [Content] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** The text input to the model. */
                fun visitString(string: String): T = unknown(JsonValue.from(string))

                fun visitDecisionItemCreateEventItemContentItems(
                    decisionItemCreateEventItemContentItems:
                        List<DecisionItemCreateEventItemContentItem>
                ): T = unknown(JsonValue.from(decisionItemCreateEventItemContentItems))

                /**
                 * Maps an unknown variant of [Content] to a value of type [T].
                 *
                 * An instance of [Content] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * Unhandled known JSON variants reach this method as JSON values.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Content")
                }
            }

            internal class Deserializer : BaseDeserializer<Content>(Content::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Content {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Content(string = it, _json = json)
                                },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<
                                            List<DecisionItemCreateEventItemContentItem>
                                        >(),
                                    )
                                    ?.let {
                                        Content(
                                            decisionItemCreateEventItemContentItems = it,
                                            _json = json,
                                        )
                                    },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Content(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Content>(Content::class) {

                override fun serialize(
                    value: Content,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.decisionItemCreateEventItemContentItems != null ->
                            generator.writeObject(value.decisionItemCreateEventItemContentItems)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Content")
                    }
                }
            }

            @JsonDeserialize(using = DecisionItemCreateEventItemContentItem.Deserializer::class)
            @JsonSerialize(using = DecisionItemCreateEventItemContentItem.Serializer::class)
            class DecisionItemCreateEventItemContentItem
            private constructor(
                private val inputText: InputText? = null,
                private val inputImage: InputImage? = null,
                private val inputJson: InputJson? = null,
                private val _json: JsonValue? = null,
            ) {

                fun inputText(): Optional<InputText> = Optional.ofNullable(inputText)

                fun inputImage(): Optional<InputImage> = Optional.ofNullable(inputImage)

                fun inputJson(): Optional<InputJson> = Optional.ofNullable(inputJson)

                fun isInputText(): Boolean = inputText != null

                fun isInputImage(): Boolean = inputImage != null

                fun isInputJson(): Boolean = inputJson != null

                fun asInputText(): InputText = inputText.getOrThrow("inputText")

                fun asInputImage(): InputImage = inputImage.getOrThrow("inputImage")

                fun asInputJson(): InputJson = inputJson.getOrThrow("inputJson")

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
                 * Optional<String> result = decisionUserMessageContentItem.accept(new DecisionItemCreateEventItemContentItem.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitInputText(InputText inputText) {
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
                        inputJson != null -> visitor.visitInputJson(inputJson)
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
                fun validate(): DecisionItemCreateEventItemContentItem = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitInputText(inputText: InputText) {
                                inputText.validate()
                            }

                            override fun visitInputImage(inputImage: InputImage) {
                                inputImage.validate()
                            }

                            override fun visitInputJson(inputJson: InputJson) {
                                inputJson.validate()
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
                            override fun visitInputText(inputText: InputText) = inputText.validity()

                            override fun visitInputImage(inputImage: InputImage) =
                                inputImage.validity()

                            override fun visitInputJson(inputJson: InputJson) = inputJson.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is DecisionItemCreateEventItemContentItem &&
                        inputText == other.inputText &&
                        inputImage == other.inputImage &&
                        inputJson == other.inputJson &&
                        (inputText != null ||
                            inputImage != null ||
                            inputJson != null ||
                            _json == other._json)
                }

                override fun hashCode(): Int =
                    if (inputText == null && inputImage == null && inputJson == null)
                        Objects.hash(_json)
                    else Objects.hash(inputText, inputImage, inputJson)

                override fun toString(): String =
                    when {
                        inputText != null ->
                            "DecisionItemCreateEventItemContentItem{inputText=$inputText}"
                        inputImage != null ->
                            "DecisionItemCreateEventItemContentItem{inputImage=$inputImage}"
                        inputJson != null ->
                            "DecisionItemCreateEventItemContentItem{inputJson=$inputJson}"
                        _json != null -> "DecisionItemCreateEventItemContentItem{_unknown=$_json}"
                        else ->
                            throw IllegalStateException(
                                "Invalid DecisionItemCreateEventItemContentItem"
                            )
                    }

                companion object {

                    @JvmStatic
                    fun ofInputText(inputText: InputText) =
                        DecisionItemCreateEventItemContentItem(inputText = inputText)

                    @JvmStatic
                    fun ofInputImage(inputImage: InputImage) =
                        DecisionItemCreateEventItemContentItem(inputImage = inputImage)

                    @JvmStatic
                    fun ofInputJson(inputJson: InputJson) =
                        DecisionItemCreateEventItemContentItem(inputJson = inputJson)
                }

                /**
                 * An interface that defines how to map each variant of
                 * [DecisionItemCreateEventItemContentItem] to a value of type [T].
                 */
                interface Visitor<out T> {

                    fun visitInputText(inputText: InputText): T = unknown(JsonValue.from(inputText))

                    fun visitInputImage(inputImage: InputImage): T =
                        unknown(JsonValue.from(inputImage))

                    fun visitInputJson(inputJson: InputJson): T = unknown(JsonValue.from(inputJson))

                    /**
                     * Maps an unknown variant of [DecisionItemCreateEventItemContentItem] to a
                     * value of type [T].
                     *
                     * An instance of [DecisionItemCreateEventItemContentItem] can contain an
                     * unknown variant if it was deserialized from data that doesn't match any known
                     * variant. For example, if the SDK is on an older version than the API, then
                     * the API may respond with new variants that the SDK is unaware of.
                     *
                     * Unhandled known JSON variants reach this method as JSON values.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException(
                            "Unknown DecisionItemCreateEventItemContentItem"
                        )
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<DecisionItemCreateEventItemContentItem>(
                        DecisionItemCreateEventItemContentItem::class
                    ) {

                    override fun ObjectCodec.deserialize(
                        node: JsonNode
                    ): DecisionItemCreateEventItemContentItem {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "input_text" -> {
                                return tryDeserialize(node, jacksonTypeRef<InputText>())?.let {
                                    DecisionItemCreateEventItemContentItem(
                                        inputText = it,
                                        _json = json,
                                    )
                                } ?: DecisionItemCreateEventItemContentItem(_json = json)
                            }
                            "input_image" -> {
                                return tryDeserialize(node, jacksonTypeRef<InputImage>())?.let {
                                    DecisionItemCreateEventItemContentItem(
                                        inputImage = it,
                                        _json = json,
                                    )
                                } ?: DecisionItemCreateEventItemContentItem(_json = json)
                            }
                            "input_json" -> {
                                return tryDeserialize(node, jacksonTypeRef<InputJson>())?.let {
                                    DecisionItemCreateEventItemContentItem(
                                        inputJson = it,
                                        _json = json,
                                    )
                                } ?: DecisionItemCreateEventItemContentItem(_json = json)
                            }
                        }

                        return DecisionItemCreateEventItemContentItem(_json = json)
                    }
                }

                internal class Serializer :
                    BaseSerializer<DecisionItemCreateEventItemContentItem>(
                        DecisionItemCreateEventItemContentItem::class
                    ) {

                    override fun serialize(
                        value: DecisionItemCreateEventItemContentItem,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.inputText != null -> generator.writeObject(value.inputText)
                            value.inputImage != null -> generator.writeObject(value.inputImage)
                            value.inputJson != null -> generator.writeObject(value.inputJson)
                            value._json != null -> generator.writeObject(value._json)
                            else ->
                                throw IllegalStateException(
                                    "Invalid DecisionItemCreateEventItemContentItem"
                                )
                        }
                    }
                }

                class InputText
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val text: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("text")
                        @ExcludeMissing
                        text: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(text, type, mutableMapOf())

                    /**
                     * The text input to the model. The schema requires this property. Returns empty
                     * if the JSON property is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun text(): java.util.Optional<String> = text.getOptional("text")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun textOrThrow(): String = text.getRequired("text")

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("input_text")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * Returns the raw JSON value of [text].
                     *
                     * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "text" to this.text,
                            "type" to this.type,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [InputText].
                         *
                         * The following fields are required:
                         * ```java
                         * .text()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [InputText]. */
                    class Builder internal constructor() {

                        private var text: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("input_text")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(inputText: InputText) = apply {
                            text = inputText.text
                            type = inputText.type
                            additionalProperties = inputText.additionalProperties.toMutableMap()
                        }

                        /** The text input to the model. */
                        fun text(text: String) = text(JsonField.of(text))

                        /**
                         * Sets [Builder.text] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.text] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun text(text: JsonField<String>) = apply { this.text = text }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("input_text")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [InputText].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .text()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): InputText =
                            InputText(
                                checkRequired("text", text),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): InputText = apply {
                        if (validated) {
                            return@apply
                        }

                        textOrThrow()
                        typeOrThrow()
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
                        (if (text.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("input_text")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is InputText &&
                            text == other.text &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(text, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "InputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
                }

                class InputImage
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val imageUrl: JsonField<String>,
                    private val type: JsonValue,
                    private val detail: JsonField<Detail>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("image_url")
                        @ExcludeMissing
                        imageUrl: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        @JsonProperty("detail")
                        @ExcludeMissing
                        detail: JsonField<Detail> = JsonMissing.of(),
                    ) : this(imageUrl, type, detail, mutableMapOf())

                    /**
                     * A base64-encoded image data URL or a publicly accessible HTTP(S) image URL.
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun imageUrl(): java.util.Optional<String> = imageUrl.getOptional("image_url")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun imageUrlOrThrow(): String = imageUrl.getRequired("image_url")

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("input_image")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * The detail level of the image to be sent to the model. One of `high`, `low`,
                     * `auto`, or `original`. Defaults to `auto`. Returns empty if the JSON property
                     * is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun detail(): java.util.Optional<Detail> = detail.getOptional("detail")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun detailOrThrow(): Detail = detail.getRequired("detail")

                    /**
                     * Returns the raw JSON value of [imageUrl].
                     *
                     * Unlike [imageUrl], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("image_url")
                    @ExcludeMissing
                    fun _imageUrl(): JsonField<String> = imageUrl

                    /**
                     * Returns the raw JSON value of [detail].
                     *
                     * Unlike [detail], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("detail")
                    @ExcludeMissing
                    fun _detail(): JsonField<Detail> = detail

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "image_url" to this.imageUrl,
                            "type" to this.type,
                            "detail" to this.detail,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [InputImage].
                         *
                         * The following fields are required:
                         * ```java
                         * .imageUrl()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [InputImage]. */
                    class Builder internal constructor() {

                        private var imageUrl: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("input_image")
                        private var detail: JsonField<Detail> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(inputImage: InputImage) = apply {
                            imageUrl = inputImage.imageUrl
                            type = inputImage.type
                            detail = inputImage.detail
                            additionalProperties = inputImage.additionalProperties.toMutableMap()
                        }

                        /**
                         * A base64-encoded image data URL or a publicly accessible HTTP(S) image
                         * URL.
                         */
                        fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

                        /**
                         * Sets [Builder.imageUrl] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.imageUrl] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun imageUrl(imageUrl: JsonField<String>) = apply {
                            this.imageUrl = imageUrl
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("input_image")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /**
                         * The detail level of the image to be sent to the model. One of `high`,
                         * `low`, `auto`, or `original`. Defaults to `auto`.
                         */
                        fun detail(detail: Detail?) = detail(JsonField.ofNullable(detail))

                        /** Alias for calling [Builder.detail] with `detail.orElse(null)`. */
                        fun detail(detail: Optional<Detail>) = detail(detail.getOrNull())

                        /**
                         * Sets [Builder.detail] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.detail] with a well-typed [Detail] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [InputImage].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .imageUrl()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): InputImage =
                            InputImage(
                                checkRequired("imageUrl", imageUrl),
                                type,
                                detail,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): InputImage = apply {
                        if (validated) {
                            return@apply
                        }

                        imageUrlOrThrow()
                        typeOrThrow()
                        detail().ifPresent { it.validate() }
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
                        (if (imageUrl.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("input_image")) 1 else 0 } +
                            (detail.asKnown().getOrNull()?.validity() ?: 0)

                    /**
                     * The detail level of the image to be sent to the model. One of `high`, `low`,
                     * `auto`, or `original`. Defaults to `auto`.
                     */
                    class Detail
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val LOW = of("low")

                            @JvmField val HIGH = of("high")

                            @JvmField val AUTO = of("auto")

                            @JvmField val ORIGINAL = of("original")

                            @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
                        }

                        /** An enum containing [Detail]'s known values. */
                        @Deprecated("Use asString() for string values or _value() for raw JSON.")
                        enum class Known {
                            LOW,
                            HIGH,
                            AUTO,
                            ORIGINAL,
                        }

                        /**
                         * An enum containing [Detail]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Detail] can contain an unknown value in a couple of
                         * cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        @Deprecated("Use asString() for string values or _value() for raw JSON.")
                        enum class Value {
                            LOW,
                            HIGH,
                            AUTO,
                            ORIGINAL,
                            /**
                             * An enum member indicating that [Detail] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        @Deprecated("Use asString() for string values or _value() for raw JSON.")
                        fun value(): Value =
                            when (this) {
                                LOW -> Value.LOW
                                HIGH -> Value.HIGH
                                AUTO -> Value.AUTO
                                ORIGINAL -> Value.ORIGINAL
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        @Deprecated("Use asString() for string values or _value() for raw JSON.")
                        fun known(): Known =
                            when (this) {
                                LOW -> Known.LOW
                                HIGH -> Known.HIGH
                                AUTO -> Known.AUTO
                                ORIGINAL -> Known.ORIGINAL
                                else -> throw OpenAIInvalidDataException("Unknown Detail: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                OpenAIInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Detail = apply {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Detail && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is InputImage &&
                            imageUrl == other.imageUrl &&
                            type == other.type &&
                            detail == other.detail &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(imageUrl, type, detail, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "InputImage{imageUrl=$imageUrl, type=$type, detail=$detail, additionalProperties=$additionalProperties}"
                }

                class InputJson
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val data: JsonField<Data>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("data")
                        @ExcludeMissing
                        data: JsonField<Data> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(data, type, mutableMapOf())

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun data(): java.util.Optional<Data> = data.getOptional("data")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun dataOrThrow(): Data = data.getRequired("data")

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("input_json")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * Returns the raw JSON value of [data].
                     *
                     * Unlike [data], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "data" to this.data,
                            "type" to this.type,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [InputJson].
                         *
                         * The following fields are required:
                         * ```java
                         * .data()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [InputJson]. */
                    class Builder internal constructor() {

                        private var data: JsonField<Data>? = null
                        private var type: JsonValue = JsonValue.from("input_json")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(inputJson: InputJson) = apply {
                            data = inputJson.data
                            type = inputJson.type
                            additionalProperties = inputJson.additionalProperties.toMutableMap()
                        }

                        fun data(data: Data) = data(JsonField.of(data))

                        /**
                         * Sets [Builder.data] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.data] with a well-typed [Data] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun data(data: JsonField<Data>) = apply { this.data = data }

                        /**
                         * Alias for calling [data] with
                         * `Data.ofDecisionJsonObject(decisionJsonObject)`.
                         */
                        fun data(decisionJsonObject: DecisionJsonObject) =
                            data(Data.ofDecisionJsonObject(decisionJsonObject))

                        /**
                         * Alias for calling [data] with
                         * `Data.ofDecisionJsonObjects(decisionJsonObjects)`.
                         */
                        fun dataOfDecisionJsonObjects(
                            decisionJsonObjects: List<DecisionJsonObject>
                        ) = data(Data.ofDecisionJsonObjects(decisionJsonObjects))

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("input_json")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [InputJson].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .data()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): InputJson =
                            InputJson(
                                checkRequired("data", data),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): InputJson = apply {
                        if (validated) {
                            return@apply
                        }

                        dataOrThrow().validate()
                        typeOrThrow()
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
                        (data.asKnown().getOrNull()?.validity() ?: 0) +
                            type.let { if (it == JsonValue.from("input_json")) 1 else 0 }

                    @JsonDeserialize(using = Data.Deserializer::class)
                    @JsonSerialize(using = Data.Serializer::class)
                    class Data
                    private constructor(
                        private val decisionJsonObject: DecisionJsonObject? = null,
                        private val decisionJsonObjects: List<DecisionJsonObject>? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        fun decisionJsonObject(): Optional<DecisionJsonObject> =
                            Optional.ofNullable(decisionJsonObject)

                        fun decisionJsonObjects(): Optional<List<DecisionJsonObject>> =
                            Optional.ofNullable(decisionJsonObjects)

                        fun isDecisionJsonObject(): Boolean = decisionJsonObject != null

                        fun isDecisionJsonObjects(): Boolean = decisionJsonObjects != null

                        fun asDecisionJsonObject(): DecisionJsonObject =
                            decisionJsonObject.getOrThrow("decisionJsonObject")

                        fun asDecisionJsonObjects(): List<DecisionJsonObject> =
                            decisionJsonObjects.getOrThrow("decisionJsonObjects")

                        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                        /**
                         * Maps this instance's current variant to a value of type [T] using the
                         * given [visitor].
                         *
                         * Note that this method is _not_ forwards compatible with new variants from
                         * the API, unless [visitor] overrides [Visitor.unknown]. To handle variants
                         * not known to this version of the SDK gracefully, consider overriding
                         * [Visitor.unknown]:
                         * ```java
                         * import com.openai.core.JsonValue;
                         * import java.util.Optional;
                         *
                         * Optional<String> result = data.accept(new Data.Visitor<Optional<String>>() {
                         *     @Override
                         *     public Optional<String> visitDecisionJsonObject(DecisionJsonObject decisionJsonObject) {
                         *         return Optional.of(decisionJsonObject.toString());
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
                         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden
                         *   in [visitor] and the current variant is unknown.
                         */
                        fun <T> accept(visitor: Visitor<T>): T =
                            when {
                                decisionJsonObject != null ->
                                    visitor.visitDecisionJsonObject(decisionJsonObject)
                                decisionJsonObjects != null ->
                                    visitor.visitDecisionJsonObjects(decisionJsonObjects)
                                else -> visitor.unknown(_json)
                            }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Data = apply {
                            if (validated) {
                                return@apply
                            }

                            accept(
                                object : Visitor<Unit> {
                                    override fun visitDecisionJsonObject(
                                        decisionJsonObject: DecisionJsonObject
                                    ) {
                                        decisionJsonObject.validate()
                                    }

                                    override fun visitDecisionJsonObjects(
                                        decisionJsonObjects: List<DecisionJsonObject>
                                    ) {
                                        decisionJsonObjects.forEach { it.validate() }
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            accept(
                                object : Visitor<Int> {
                                    override fun visitDecisionJsonObject(
                                        decisionJsonObject: DecisionJsonObject
                                    ) = decisionJsonObject.validity()

                                    override fun visitDecisionJsonObjects(
                                        decisionJsonObjects: List<DecisionJsonObject>
                                    ) = decisionJsonObjects.sumOf { it.validity().toInt() }

                                    override fun unknown(json: JsonValue?) = 0
                                }
                            )

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Data &&
                                decisionJsonObject == other.decisionJsonObject &&
                                decisionJsonObjects == other.decisionJsonObjects &&
                                (decisionJsonObject != null ||
                                    decisionJsonObjects != null ||
                                    _json == other._json)
                        }

                        override fun hashCode(): Int =
                            if (decisionJsonObject == null && decisionJsonObjects == null)
                                Objects.hash(_json)
                            else Objects.hash(decisionJsonObject, decisionJsonObjects)

                        override fun toString(): String =
                            when {
                                decisionJsonObject != null ->
                                    "Data{decisionJsonObject=$decisionJsonObject}"
                                decisionJsonObjects != null ->
                                    "Data{decisionJsonObjects=$decisionJsonObjects}"
                                _json != null -> "Data{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid Data")
                            }

                        companion object {

                            @JvmStatic
                            fun ofDecisionJsonObject(decisionJsonObject: DecisionJsonObject) =
                                Data(decisionJsonObject = decisionJsonObject)

                            @JvmStatic
                            fun ofDecisionJsonObjects(
                                decisionJsonObjects: List<DecisionJsonObject>
                            ) = Data(decisionJsonObjects = decisionJsonObjects.toImmutable())
                        }

                        /**
                         * An interface that defines how to map each variant of [Data] to a value of
                         * type [T].
                         */
                        interface Visitor<out T> {

                            fun visitDecisionJsonObject(decisionJsonObject: DecisionJsonObject): T =
                                unknown(JsonValue.from(decisionJsonObject))

                            fun visitDecisionJsonObjects(
                                decisionJsonObjects: List<DecisionJsonObject>
                            ): T = unknown(JsonValue.from(decisionJsonObjects))

                            /**
                             * Maps an unknown variant of [Data] to a value of type [T].
                             *
                             * An instance of [Data] can contain an unknown variant if it was
                             * deserialized from data that doesn't match any known variant. For
                             * example, if the SDK is on an older version than the API, then the API
                             * may respond with new variants that the SDK is unaware of.
                             *
                             * Unhandled known JSON variants reach this method as JSON values.
                             *
                             * @throws OpenAIInvalidDataException in the default implementation.
                             */
                            fun unknown(json: JsonValue?): T {
                                throw OpenAIInvalidDataException("Unknown Data")
                            }
                        }

                        internal class Deserializer : BaseDeserializer<Data>(Data::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): Data {
                                val json = JsonValue.fromJsonNode(node)

                                val bestMatches =
                                    sequenceOf(
                                            tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<DecisionJsonObject>(),
                                                )
                                                ?.let {
                                                    Data(decisionJsonObject = it, _json = json)
                                                },
                                            tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<List<DecisionJsonObject>>(),
                                                )
                                                ?.let {
                                                    Data(decisionJsonObjects = it, _json = json)
                                                },
                                        )
                                        .filterNotNull()
                                        .allMaxBy { it.validity() }
                                        .toList()
                                return when (bestMatches.size) {
                                    // This can happen if what we're deserializing is completely
                                    // incompatible with all the possible variants (e.g.
                                    // deserializing from boolean).
                                    0 -> Data(_json = json)
                                    1 -> bestMatches.single()
                                    // If there's more than one match with the highest validity,
                                    // then use the first completely valid match, or simply the
                                    // first match if none are completely valid.
                                    else ->
                                        bestMatches.firstOrNull { it.isValid() }
                                            ?: bestMatches.first()
                                }
                            }
                        }

                        internal class Serializer : BaseSerializer<Data>(Data::class) {

                            override fun serialize(
                                value: Data,
                                generator: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                when {
                                    value.decisionJsonObject != null ->
                                        generator.writeObject(value.decisionJsonObject)
                                    value.decisionJsonObjects != null ->
                                        generator.writeObject(value.decisionJsonObjects)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid Data")
                                }
                            }
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is InputJson &&
                            data == other.data &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(data, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "InputJson{data=$data, type=$type, additionalProperties=$additionalProperties}"
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
                @JsonProperty("call_id")
                @ExcludeMissing
                callId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("namespace")
                @ExcludeMissing
                namespace: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            ) : this(arguments, callId, name, type, id, namespace, status, mutableMapOf())

            /**
             * The function arguments as a JSON string. The schema requires this property. Returns
             * empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun arguments(): java.util.Optional<String> = arguments.getOptional("arguments")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun argumentsOrThrow(): String = arguments.getRequired("arguments")

            /**
             * The unique ID of the function tool call generated by the model. The schema requires
             * this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun callId(): java.util.Optional<String> = callId.getOptional("call_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun callIdOrThrow(): String = callId.getRequired("call_id")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun name(): java.util.Optional<String> = name.getOptional("name")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun nameOrThrow(): String = name.getRequired("name")

            /**
             * The item type. Always `function_call`. The schema requires this property. Returns
             * empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("function_call")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

            /**
             * The local Decision item ID. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun id(): java.util.Optional<String> = id.getOptional("id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun idOrThrow(): String = id.getRequired("id")

            /**
             * The namespace of the function to call. Returns empty if the JSON property is missing
             * or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun namespace(): java.util.Optional<String> = namespace.getOptional("namespace")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun namespaceOrThrow(): String = namespace.getRequired("namespace")

            /**
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun status(): java.util.Optional<Status> = status.getOptional("status")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun statusOrThrow(): Status = status.getRequired("status")

            /**
             * Returns the raw JSON value of [arguments].
             *
             * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("arguments")
            @ExcludeMissing
            fun _arguments(): JsonField<String> = arguments

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
             * Unlike [namespace], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("namespace")
            @ExcludeMissing
            fun _namespace(): JsonField<String> = namespace

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
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
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

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                /** The function arguments as a JSON string. */
                fun arguments(arguments: String) = arguments(JsonField.of(arguments))

                /**
                 * Sets [Builder.arguments] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.arguments] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

                /** The unique ID of the function tool call generated by the model. */
                fun callId(callId: String) = callId(JsonField.of(callId))

                /**
                 * Sets [Builder.callId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.callId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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

                /** The local Decision item ID. */
                fun id(id: String?) = id(JsonField.ofNullable(id))

                /** Alias for calling [Builder.id] with `id.orElse(null)`. */
                fun id(id: Optional<String>) = id(id.getOrNull())

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The namespace of the function to call. */
                fun namespace(namespace: String?) = namespace(JsonField.ofNullable(namespace))

                /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
                fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

                /**
                 * Sets [Builder.namespace] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.namespace] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun namespace(namespace: JsonField<String>) = apply { this.namespace = namespace }

                fun status(status: Status?) = status(JsonField.ofNullable(status))

                /** Alias for calling [Builder.status] with `status.orElse(null)`. */
                fun status(status: Optional<Status>) = status(status.getOrNull())

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [Status] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): FunctionCall = apply {
                if (validated) {
                    return@apply
                }

                argumentsOrThrow()
                callIdOrThrow()
                nameOrThrow()
                typeOrThrow()
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

            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val IN_PROGRESS = of("in_progress")

                    @JvmField val COMPLETED = of("completed")

                    @JvmField val INCOMPLETE = of("incomplete")

                    @JvmStatic fun of(value: String) = Status(JsonField.of(value))
                }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Status = apply {
                    if (validated) {
                        return@apply
                    }

                    asString()
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
                    when (this) {
                        IN_PROGRESS -> 1
                        COMPLETED -> 1
                        INCOMPLETE -> 1
                        else -> 0
                    }

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
                Objects.hash(
                    arguments,
                    callId,
                    name,
                    type,
                    id,
                    namespace,
                    status,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FunctionCall{arguments=$arguments, callId=$callId, name=$name, type=$type, id=$id, namespace=$namespace, status=$status, additionalProperties=$additionalProperties}"
        }

        class FunctionCallOutput
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val callId: JsonField<String>,
            private val output: JsonField<DecisionToolOutput>,
            private val type: JsonValue,
            private val id: JsonField<String>,
            private val status: JsonField<Status>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("call_id")
                @ExcludeMissing
                callId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("output")
                @ExcludeMissing
                output: JsonField<DecisionToolOutput> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            ) : this(callId, output, type, id, status, mutableMapOf())

            /**
             * The unique ID of the function tool call generated by the model. The schema requires
             * this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun callId(): java.util.Optional<String> = callId.getOptional("call_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun callIdOrThrow(): String = callId.getRequired("call_id")

            /**
             * The text input to the model. The schema requires this property. Returns empty if the
             * JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun output(): java.util.Optional<DecisionToolOutput> = output.getOptional("output")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun outputOrThrow(): DecisionToolOutput = output.getRequired("output")

            /**
             * The type of the function tool call output. Always `function_call_output`. The schema
             * requires this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("function_call_output")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

            /**
             * The local Decision item ID. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun id(): java.util.Optional<String> = id.getOptional("id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun idOrThrow(): String = id.getRequired("id")

            /**
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun status(): java.util.Optional<Status> = status.getOptional("status")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun statusOrThrow(): Status = status.getRequired("status")

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
            @JsonProperty("output")
            @ExcludeMissing
            fun _output(): JsonField<DecisionToolOutput> = output

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
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
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

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
                private var output: JsonField<DecisionToolOutput>? = null
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

                /** The unique ID of the function tool call generated by the model. */
                fun callId(callId: String) = callId(JsonField.of(callId))

                /**
                 * Sets [Builder.callId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.callId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                /** The text input to the model. */
                fun output(output: DecisionToolOutput) = output(JsonField.of(output))

                /**
                 * Sets [Builder.output] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.output] with a well-typed [DecisionToolOutput]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun output(output: JsonField<DecisionToolOutput>) = apply { this.output = output }

                /** Alias for calling [output] with `DecisionToolOutput.ofString(string)`. */
                fun output(string: String) = output(DecisionToolOutput.ofString(string))

                /** Alias for calling [output] with `DecisionToolOutput.ofParts(parts)`. */
                fun outputOfParts(parts: List<DecisionToolOutputContentPart>) =
                    output(DecisionToolOutput.ofParts(parts))

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

                /** The local Decision item ID. */
                fun id(id: String?) = id(JsonField.ofNullable(id))

                /** Alias for calling [Builder.id] with `id.orElse(null)`. */
                fun id(id: Optional<String>) = id(id.getOrNull())

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun status(status: Status?) = status(JsonField.ofNullable(status))

                /** Alias for calling [Builder.status] with `status.orElse(null)`. */
                fun status(status: Optional<Status>) = status(status.getOrNull())

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [Status] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): FunctionCallOutput = apply {
                if (validated) {
                    return@apply
                }

                callIdOrThrow()
                outputOrThrow().validate()
                typeOrThrow()
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

            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val IN_PROGRESS = of("in_progress")

                    @JvmField val COMPLETED = of("completed")

                    @JvmField val INCOMPLETE = of("incomplete")

                    @JvmStatic fun of(value: String) = Status(JsonField.of(value))
                }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Status = apply {
                    if (validated) {
                        return@apply
                    }

                    asString()
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
                    when (this) {
                        IN_PROGRESS -> 1
                        COMPLETED -> 1
                        INCOMPLETE -> 1
                        else -> 0
                    }

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
                @JsonProperty("call_id")
                @ExcludeMissing
                callId: JsonField<String> = JsonMissing.of(),
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
             * The unique ID of the function tool call generated by the model. The schema requires
             * this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun callId(): java.util.Optional<String> = callId.getOptional("call_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun callIdOrThrow(): String = callId.getRequired("call_id")

            /**
             * The input to the custom tool call. The schema requires this property. Returns empty
             * if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun input(): java.util.Optional<String> = input.getOptional("input")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun inputOrThrow(): String = input.getRequired("input")

            /**
             * The name of the custom tool to call. The schema requires this property. Returns empty
             * if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun name(): java.util.Optional<String> = name.getOptional("name")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun nameOrThrow(): String = name.getRequired("name")

            /**
             * The item type. Always `custom_tool_call`. The schema requires this property. Returns
             * empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("custom_tool_call")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

            /**
             * The local Decision item ID. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun id(): java.util.Optional<String> = id.getOptional("id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun idOrThrow(): String = id.getRequired("id")

            /**
             * The namespace of the function to call. Returns empty if the JSON property is missing
             * or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun namespace(): java.util.Optional<String> = namespace.getOptional("namespace")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun namespaceOrThrow(): String = namespace.getRequired("namespace")

            /**
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun status(): java.util.Optional<Status> = status.getOptional("status")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun statusOrThrow(): Status = status.getRequired("status")

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
             * Unlike [namespace], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("namespace")
            @ExcludeMissing
            fun _namespace(): JsonField<String> = namespace

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
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
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

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                /** The unique ID of the function tool call generated by the model. */
                fun callId(callId: String) = callId(JsonField.of(callId))

                /**
                 * Sets [Builder.callId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.callId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                /** The input to the custom tool call. */
                fun input(input: String) = input(JsonField.of(input))

                /**
                 * Sets [Builder.input] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.input] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun input(input: JsonField<String>) = apply { this.input = input }

                /** The name of the custom tool to call. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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

                /** The local Decision item ID. */
                fun id(id: String?) = id(JsonField.ofNullable(id))

                /** Alias for calling [Builder.id] with `id.orElse(null)`. */
                fun id(id: Optional<String>) = id(id.getOrNull())

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The namespace of the function to call. */
                fun namespace(namespace: String?) = namespace(JsonField.ofNullable(namespace))

                /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
                fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

                /**
                 * Sets [Builder.namespace] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.namespace] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun namespace(namespace: JsonField<String>) = apply { this.namespace = namespace }

                fun status(status: Status?) = status(JsonField.ofNullable(status))

                /** Alias for calling [Builder.status] with `status.orElse(null)`. */
                fun status(status: Optional<Status>) = status(status.getOrNull())

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [Status] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): CustomToolCall = apply {
                if (validated) {
                    return@apply
                }

                callIdOrThrow()
                inputOrThrow()
                nameOrThrow()
                typeOrThrow()
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

            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val IN_PROGRESS = of("in_progress")

                    @JvmField val COMPLETED = of("completed")

                    @JvmField val INCOMPLETE = of("incomplete")

                    @JvmStatic fun of(value: String) = Status(JsonField.of(value))
                }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Status = apply {
                    if (validated) {
                        return@apply
                    }

                    asString()
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
                    when (this) {
                        IN_PROGRESS -> 1
                        COMPLETED -> 1
                        INCOMPLETE -> 1
                        else -> 0
                    }

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
            private val output: JsonField<DecisionToolOutput>,
            private val type: JsonValue,
            private val id: JsonField<String>,
            private val status: JsonField<Status>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("call_id")
                @ExcludeMissing
                callId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("output")
                @ExcludeMissing
                output: JsonField<DecisionToolOutput> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            ) : this(callId, output, type, id, status, mutableMapOf())

            /**
             * The unique ID of the function tool call generated by the model. The schema requires
             * this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun callId(): java.util.Optional<String> = callId.getOptional("call_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun callIdOrThrow(): String = callId.getRequired("call_id")

            /**
             * The text input to the model. The schema requires this property. Returns empty if the
             * JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun output(): java.util.Optional<DecisionToolOutput> = output.getOptional("output")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun outputOrThrow(): DecisionToolOutput = output.getRequired("output")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("custom_tool_call_output")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

            /**
             * The local Decision item ID. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun id(): java.util.Optional<String> = id.getOptional("id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun idOrThrow(): String = id.getRequired("id")

            /**
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun status(): java.util.Optional<Status> = status.getOptional("status")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun statusOrThrow(): Status = status.getRequired("status")

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
            @JsonProperty("output")
            @ExcludeMissing
            fun _output(): JsonField<DecisionToolOutput> = output

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
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
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

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
                private var output: JsonField<DecisionToolOutput>? = null
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

                /** The unique ID of the function tool call generated by the model. */
                fun callId(callId: String) = callId(JsonField.of(callId))

                /**
                 * Sets [Builder.callId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.callId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                /** The text input to the model. */
                fun output(output: DecisionToolOutput) = output(JsonField.of(output))

                /**
                 * Sets [Builder.output] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.output] with a well-typed [DecisionToolOutput]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun output(output: JsonField<DecisionToolOutput>) = apply { this.output = output }

                /** Alias for calling [output] with `DecisionToolOutput.ofString(string)`. */
                fun output(string: String) = output(DecisionToolOutput.ofString(string))

                /** Alias for calling [output] with `DecisionToolOutput.ofParts(parts)`. */
                fun outputOfParts(parts: List<DecisionToolOutputContentPart>) =
                    output(DecisionToolOutput.ofParts(parts))

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

                /** The local Decision item ID. */
                fun id(id: String?) = id(JsonField.ofNullable(id))

                /** Alias for calling [Builder.id] with `id.orElse(null)`. */
                fun id(id: Optional<String>) = id(id.getOrNull())

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun status(status: Status?) = status(JsonField.ofNullable(status))

                /** Alias for calling [Builder.status] with `status.orElse(null)`. */
                fun status(status: Optional<Status>) = status(status.getOrNull())

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [Status] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): CustomToolCallOutput = apply {
                if (validated) {
                    return@apply
                }

                callIdOrThrow()
                outputOrThrow().validate()
                typeOrThrow()
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

            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val IN_PROGRESS = of("in_progress")

                    @JvmField val COMPLETED = of("completed")

                    @JvmField val INCOMPLETE = of("incomplete")

                    @JvmStatic fun of(value: String) = Status(JsonField.of(value))
                }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Status = apply {
                    if (validated) {
                        return@apply
                    }

                    asString()
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
                    when (this) {
                        IN_PROGRESS -> 1
                        COMPLETED -> 1
                        INCOMPLETE -> 1
                        else -> 0
                    }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionItemCreateEvent &&
            item == other.item &&
            type == other.type &&
            eventId == other.eventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(item, type, eventId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionItemCreateEvent{item=$item, type=$type, eventId=$eventId, additionalProperties=$additionalProperties}"
}
