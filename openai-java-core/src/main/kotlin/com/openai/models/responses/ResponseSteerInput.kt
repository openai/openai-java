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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Input to queue for a continuation of the response. Uses the same string or input-item shape as
 * `response.create.input`, with a non-empty array when supplying input items.
 *
 * Steering accepts only messages with the `user` role. Each message may contain only `type`,
 * `role`, and `content`, with `content` as a string or an array of `input_text`, `input_image`, and
 * `input_file` parts. The optional `type` must be `message`. Other roles, tool outputs, and item
 * types are not supported for steering.
 */
@JsonDeserialize(using = ResponseSteerInput.Deserializer::class)
@JsonSerialize(using = ResponseSteerInput.Serializer::class)
class ResponseSteerInput
private constructor(
    private val text: String? = null,
    private val itemList: List<ResponseSteerInputItem>? = null,
    private val _json: JsonValue? = null,
) {

    /** A text input, equivalent to a message with the `user` role. */
    fun text(): Optional<String> = Optional.ofNullable(text)

    /** A non-empty list of message inputs to queue for the response. */
    fun itemList(): Optional<List<ResponseSteerInputItem>> = Optional.ofNullable(itemList)

    fun isText(): Boolean = text != null

    fun isItemList(): Boolean = itemList != null

    /** A text input, equivalent to a message with the `user` role. */
    fun asText(): String = text.getOrThrow("text")

    /** A non-empty list of message inputs to queue for the response. */
    fun asItemList(): List<ResponseSteerInputItem> = itemList.getOrThrow("itemList")

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
     * Optional<String> result = responseSteerInput.accept(new ResponseSteerInput.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitText(String text) {
     *         return Optional.of(text.toString());
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
            text != null -> visitor.visitText(text)
            itemList != null -> visitor.visitItemList(itemList)
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
    fun validate(): ResponseSteerInput = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitText(text: String) {}

                override fun visitItemList(itemList: List<ResponseSteerInputItem>) {
                    itemList.forEach { it.validate() }
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
                override fun visitText(text: String) = 1

                override fun visitItemList(itemList: List<ResponseSteerInputItem>) =
                    itemList.sumOf { it.validity().toInt() }

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseSteerInput && text == other.text && itemList == other.itemList
    }

    override fun hashCode(): Int = Objects.hash(text, itemList)

    override fun toString(): String =
        when {
            text != null -> "ResponseSteerInput{text=$text}"
            itemList != null -> "ResponseSteerInput{itemList=$itemList}"
            _json != null -> "ResponseSteerInput{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseSteerInput")
        }

    companion object {

        /** A text input, equivalent to a message with the `user` role. */
        @JvmStatic fun ofText(text: String) = ResponseSteerInput(text = text)

        /** A non-empty list of message inputs to queue for the response. */
        @JvmStatic
        fun ofItemList(itemList: List<ResponseSteerInputItem>) =
            ResponseSteerInput(itemList = itemList.toImmutable())
    }

    /**
     * An interface that defines how to map each variant of [ResponseSteerInput] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A text input, equivalent to a message with the `user` role. */
        fun visitText(text: String): T

        /** A non-empty list of message inputs to queue for the response. */
        fun visitItemList(itemList: List<ResponseSteerInputItem>): T

        /**
         * Maps an unknown variant of [ResponseSteerInput] to a value of type [T].
         *
         * An instance of [ResponseSteerInput] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseSteerInput: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ResponseSteerInput>(ResponseSteerInput::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseSteerInput {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            ResponseSteerInput(text = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<ResponseSteerInputItem>>())?.let {
                            ResponseSteerInput(itemList = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> ResponseSteerInput(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<ResponseSteerInput>(ResponseSteerInput::class) {

        override fun serialize(
            value: ResponseSteerInput,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.text != null -> generator.writeObject(value.text)
                value.itemList != null -> generator.writeObject(value.itemList)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseSteerInput")
            }
        }
    }

    /** The output of a function tool call. */
    @JsonDeserialize(using = ResponseSteerInputItem.Deserializer::class)
    @JsonSerialize(using = ResponseSteerInputItem.Serializer::class)
    class ResponseSteerInputItem
    private constructor(
        private val message: Message? = null,
        private val functionCallOutput: FunctionCallOutput? = null,
        private val _json: JsonValue? = null,
    ) {

        fun message(): Optional<Message> = Optional.ofNullable(message)

        /** The output of a function tool call. */
        fun functionCallOutput(): Optional<FunctionCallOutput> =
            Optional.ofNullable(functionCallOutput)

        fun isMessage(): Boolean = message != null

        fun isFunctionCallOutput(): Boolean = functionCallOutput != null

        fun asMessage(): Message = message.getOrThrow("message")

        /** The output of a function tool call. */
        fun asFunctionCallOutput(): FunctionCallOutput =
            functionCallOutput.getOrThrow("functionCallOutput")

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
         * Optional<String> result = responseSteerInputItem.accept(new ResponseSteerInputItem.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitMessage(Message message) {
         *         return Optional.of(message.toString());
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
                message != null -> visitor.visitMessage(message)
                functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
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
        fun validate(): ResponseSteerInputItem = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMessage(message: Message) {
                        message.validate()
                    }

                    override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) {
                        functionCallOutput.validate()
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
                    override fun visitMessage(message: Message) = message.validity()

                    override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
                        functionCallOutput.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseSteerInputItem &&
                message == other.message &&
                functionCallOutput == other.functionCallOutput
        }

        override fun hashCode(): Int = Objects.hash(message, functionCallOutput)

        override fun toString(): String =
            when {
                message != null -> "ResponseSteerInputItem{message=$message}"
                functionCallOutput != null ->
                    "ResponseSteerInputItem{functionCallOutput=$functionCallOutput}"
                _json != null -> "ResponseSteerInputItem{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ResponseSteerInputItem")
            }

        companion object {

            @JvmStatic fun ofMessage(message: Message) = ResponseSteerInputItem(message = message)

            /** The output of a function tool call. */
            @JvmStatic
            fun ofFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
                ResponseSteerInputItem(functionCallOutput = functionCallOutput)
        }

        /**
         * An interface that defines how to map each variant of [ResponseSteerInputItem] to a value
         * of type [T].
         */
        interface Visitor<out T> {

            fun visitMessage(message: Message): T

            /** The output of a function tool call. */
            fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput): T

            /**
             * Maps an unknown variant of [ResponseSteerInputItem] to a value of type [T].
             *
             * An instance of [ResponseSteerInputItem] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown ResponseSteerInputItem: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<ResponseSteerInputItem>(ResponseSteerInputItem::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): ResponseSteerInputItem {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "message" -> {
                        return tryDeserialize(node, jacksonTypeRef<Message>())?.let {
                            ResponseSteerInputItem(message = it, _json = json)
                        } ?: ResponseSteerInputItem(_json = json)
                    }
                    "function_call_output" -> {
                        return tryDeserialize(node, jacksonTypeRef<FunctionCallOutput>())?.let {
                            ResponseSteerInputItem(functionCallOutput = it, _json = json)
                        } ?: ResponseSteerInputItem(_json = json)
                    }
                }

                return ResponseSteerInputItem(_json = json)
            }
        }

        internal class Serializer :
            BaseSerializer<ResponseSteerInputItem>(ResponseSteerInputItem::class) {

            override fun serialize(
                value: ResponseSteerInputItem,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.message != null -> generator.writeObject(value.message)
                    value.functionCallOutput != null ->
                        generator.writeObject(value.functionCallOutput)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ResponseSteerInputItem")
                }
            }
        }

        class Message
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val content: JsonField<Content>,
            private val role: JsonValue,
            private val type: JsonValue,
            private val id: JsonField<String>,
            private val status: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("content")
                @ExcludeMissing
                content: JsonField<Content> = JsonMissing.of(),
                @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            ) : this(content, role, type, id, status, mutableMapOf())

            /**
             * The message content, as an array of content parts.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun content(): Content = content.getRequired("content")

            /**
             * The message role. Always `user`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("user")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

            /**
             * The item type. Always `message`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("message")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The unique ID of this message item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * The status of the message item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun status(): Optional<String> = status.getOptional("status")

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

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
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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
                 * Returns a mutable builder for constructing an instance of [Message].
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Message]. */
            class Builder internal constructor() {

                private var content: JsonField<Content>? = null
                private var role: JsonValue = JsonValue.from("user")
                private var type: JsonValue = JsonValue.from("message")
                private var id: JsonField<String> = JsonMissing.of()
                private var status: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(message: Message) = apply {
                    content = message.content
                    role = message.role
                    type = message.type
                    id = message.id
                    status = message.status
                    additionalProperties = message.additionalProperties.toMutableMap()
                }

                /** The message content, as an array of content parts. */
                fun content(content: Content) = content(JsonField.of(content))

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed [Content] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun content(content: JsonField<Content>) = apply { this.content = content }

                /**
                 * Alias for calling [content] with
                 * `Content.ofResponseSteerInputContents(responseSteerInputContents)`.
                 */
                fun contentOfResponseSteerInputContents(
                    responseSteerInputContents: List<ResponseSteerInputContent>
                ) = content(Content.ofResponseSteerInputContents(responseSteerInputContents))

                /** Alias for calling [content] with `Content.ofString(string)`. */
                fun content(string: String) = content(Content.ofString(string))

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("user")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonValue) = apply { this.role = role }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("message")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The unique ID of this message item. */
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

                /** The status of the message item. */
                fun status(status: String?) = status(JsonField.ofNullable(status))

                /** Alias for calling [Builder.status] with `status.orElse(null)`. */
                fun status(status: Optional<String>) = status(status.getOrNull())

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<String>) = apply { this.status = status }

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
                 * Returns an immutable instance of [Message].
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
                fun build(): Message =
                    Message(
                        checkRequired("content", content),
                        role,
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
            fun validate(): Message = apply {
                if (validated) {
                    return@apply
                }

                content().validate()
                _role().let {
                    if (it != JsonValue.from("user")) {
                        throw OpenAIInvalidDataException("'role' is invalid, received $it")
                    }
                }
                _type().let {
                    if (it != JsonValue.from("message")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                id()
                status()
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
                (content.asKnown().getOrNull()?.validity() ?: 0) +
                    role.let { if (it == JsonValue.from("user")) 1 else 0 } +
                    type.let { if (it == JsonValue.from("message")) 1 else 0 } +
                    (if (id.asKnown().isPresent) 1 else 0) +
                    (if (status.asKnown().isPresent) 1 else 0)

            /** The message content, as an array of content parts. */
            @JsonDeserialize(using = Content.Deserializer::class)
            @JsonSerialize(using = Content.Serializer::class)
            class Content
            private constructor(
                private val responseSteerInputContents: List<ResponseSteerInputContent>? = null,
                private val string: String? = null,
                private val _json: JsonValue? = null,
            ) {

                fun responseSteerInputContents(): Optional<List<ResponseSteerInputContent>> =
                    Optional.ofNullable(responseSteerInputContents)

                /** The message content, as a single string. */
                fun string(): Optional<String> = Optional.ofNullable(string)

                fun isResponseSteerInputContents(): Boolean = responseSteerInputContents != null

                fun isString(): Boolean = string != null

                fun asResponseSteerInputContents(): List<ResponseSteerInputContent> =
                    responseSteerInputContents.getOrThrow("responseSteerInputContents")

                /** The message content, as a single string. */
                fun asString(): String = string.getOrThrow("string")

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
                 * Optional<String> result = content.accept(new Content.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitResponseSteerInputContents(List<ResponseSteerInputContent> responseSteerInputContents) {
                 *         return Optional.of(responseSteerInputContents.toString());
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
                        responseSteerInputContents != null ->
                            visitor.visitResponseSteerInputContents(responseSteerInputContents)
                        string != null -> visitor.visitString(string)
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
                fun validate(): Content = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitResponseSteerInputContents(
                                responseSteerInputContents: List<ResponseSteerInputContent>
                            ) {
                                responseSteerInputContents.forEach { it.validate() }
                            }

                            override fun visitString(string: String) {}
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
                            override fun visitResponseSteerInputContents(
                                responseSteerInputContents: List<ResponseSteerInputContent>
                            ) = responseSteerInputContents.sumOf { it.validity().toInt() }

                            override fun visitString(string: String) = 1

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Content &&
                        responseSteerInputContents == other.responseSteerInputContents &&
                        string == other.string
                }

                override fun hashCode(): Int = Objects.hash(responseSteerInputContents, string)

                override fun toString(): String =
                    when {
                        responseSteerInputContents != null ->
                            "Content{responseSteerInputContents=$responseSteerInputContents}"
                        string != null -> "Content{string=$string}"
                        _json != null -> "Content{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Content")
                    }

                companion object {

                    @JvmStatic
                    fun ofResponseSteerInputContents(
                        responseSteerInputContents: List<ResponseSteerInputContent>
                    ) =
                        Content(
                            responseSteerInputContents = responseSteerInputContents.toImmutable()
                        )

                    /** The message content, as a single string. */
                    @JvmStatic fun ofString(string: String) = Content(string = string)
                }

                /**
                 * An interface that defines how to map each variant of [Content] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitResponseSteerInputContents(
                        responseSteerInputContents: List<ResponseSteerInputContent>
                    ): T

                    /** The message content, as a single string. */
                    fun visitString(string: String): T

                    /**
                     * Maps an unknown variant of [Content] to a value of type [T].
                     *
                     * An instance of [Content] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Content: $json")
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
                                            jacksonTypeRef<List<ResponseSteerInputContent>>(),
                                        )
                                        ?.let {
                                            Content(responseSteerInputContents = it, _json = json)
                                        },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // boolean).
                            0 -> Content(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
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
                            value.responseSteerInputContents != null ->
                                generator.writeObject(value.responseSteerInputContents)
                            value.string != null -> generator.writeObject(value.string)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Content")
                        }
                    }
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Message &&
                    content == other.content &&
                    role == other.role &&
                    type == other.type &&
                    id == other.id &&
                    status == other.status &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(content, role, type, id, status, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Message{content=$content, role=$role, type=$type, id=$id, status=$status, additionalProperties=$additionalProperties}"
        }

        /** The output of a function tool call. */
        class FunctionCallOutput
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val output: JsonField<Output>,
            private val type: JsonValue,
            private val id: JsonField<String>,
            private val callId: JsonField<String>,
            private val caller: JsonField<Caller>,
            private val name: JsonField<String>,
            private val namespace: JsonField<String>,
            private val status: JsonField<Status>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("output")
                @ExcludeMissing
                output: JsonField<Output> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("call_id")
                @ExcludeMissing
                callId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("caller")
                @ExcludeMissing
                caller: JsonField<Caller> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("namespace")
                @ExcludeMissing
                namespace: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            ) : this(output, type, id, callId, caller, name, namespace, status, mutableMapOf())

            /**
             * Text, image, or file output of the function tool call.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun output(): Output = output.getRequired("output")

            /**
             * The type of the function tool call output. Always `function_call_output`.
             *
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
             * The unique ID of the function tool call output. Populated when this item is returned
             * via API.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * The unique ID of the function tool call generated by the model.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun callId(): Optional<String> = callId.getOptional("call_id")

            /**
             * The execution context that produced this tool call.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun caller(): Optional<Caller> = caller.getOptional("caller")

            /**
             * The name of the tool that produced the output.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * The namespace of the tool that produced the output.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun namespace(): Optional<String> = namespace.getOptional("namespace")

            /**
             * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun status(): Optional<Status> = status.getOptional("status")

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
             * Returns the raw JSON value of [callId].
             *
             * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

            /**
             * Returns the raw JSON value of [caller].
             *
             * Unlike [caller], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("caller") @ExcludeMissing fun _caller(): JsonField<Caller> = caller

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                 * .output()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FunctionCallOutput]. */
            class Builder internal constructor() {

                private var output: JsonField<Output>? = null
                private var type: JsonValue = JsonValue.from("function_call_output")
                private var id: JsonField<String> = JsonMissing.of()
                private var callId: JsonField<String> = JsonMissing.of()
                private var caller: JsonField<Caller> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var namespace: JsonField<String> = JsonMissing.of()
                private var status: JsonField<Status> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(functionCallOutput: FunctionCallOutput) = apply {
                    output = functionCallOutput.output
                    type = functionCallOutput.type
                    id = functionCallOutput.id
                    callId = functionCallOutput.callId
                    caller = functionCallOutput.caller
                    name = functionCallOutput.name
                    namespace = functionCallOutput.namespace
                    status = functionCallOutput.status
                    additionalProperties = functionCallOutput.additionalProperties.toMutableMap()
                }

                /** Text, image, or file output of the function tool call. */
                fun output(output: Output) = output(JsonField.of(output))

                /**
                 * Sets [Builder.output] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.output] with a well-typed [Output] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun output(output: JsonField<Output>) = apply { this.output = output }

                /** Alias for calling [output] with `Output.ofString(string)`. */
                fun output(string: String) = output(Output.ofString(string))

                /**
                 * Alias for calling [output] with
                 * `Output.ofResponseFunctionCallOutputItemList(responseFunctionCallOutputItemList)`.
                 */
                fun outputOfResponseFunctionCallOutputItemList(
                    responseFunctionCallOutputItemList: List<ResponseFunctionCallOutputItem>
                ) =
                    output(
                        Output.ofResponseFunctionCallOutputItemList(
                            responseFunctionCallOutputItemList
                        )
                    )

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

                /**
                 * The unique ID of the function tool call output. Populated when this item is
                 * returned via API.
                 */
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

                /** The unique ID of the function tool call generated by the model. */
                fun callId(callId: String?) = callId(JsonField.ofNullable(callId))

                /** Alias for calling [Builder.callId] with `callId.orElse(null)`. */
                fun callId(callId: Optional<String>) = callId(callId.getOrNull())

                /**
                 * Sets [Builder.callId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.callId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                /** The execution context that produced this tool call. */
                fun caller(caller: Caller?) = caller(JsonField.ofNullable(caller))

                /** Alias for calling [Builder.caller] with `caller.orElse(null)`. */
                fun caller(caller: Optional<Caller>) = caller(caller.getOrNull())

                /**
                 * Sets [Builder.caller] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.caller] with a well-typed [Caller] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun caller(caller: JsonField<Caller>) = apply { this.caller = caller }

                /** Alias for calling [caller] with `Caller.ofDirect()`. */
                fun callerDirect() = caller(Caller.ofDirect())

                /** Alias for calling [caller] with `Caller.ofProgram(program)`. */
                fun caller(program: Caller.Program) = caller(Caller.ofProgram(program))

                /**
                 * Alias for calling [caller] with the following:
                 * ```java
                 * Caller.Program.builder()
                 *     .callerId(callerId)
                 *     .build()
                 * ```
                 */
                fun programCaller(callerId: String) =
                    caller(Caller.Program.builder().callerId(callerId).build())

                /** The name of the tool that produced the output. */
                fun name(name: String?) = name(JsonField.ofNullable(name))

                /** Alias for calling [Builder.name] with `name.orElse(null)`. */
                fun name(name: Optional<String>) = name(name.getOrNull())

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** The namespace of the tool that produced the output. */
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

                /**
                 * The status of the item. One of `in_progress`, `completed`, or `incomplete`.
                 * Populated when items are returned via API.
                 */
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
                 * .output()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FunctionCallOutput =
                    FunctionCallOutput(
                        checkRequired("output", output),
                        type,
                        id,
                        callId,
                        caller,
                        name,
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
            fun validate(): FunctionCallOutput = apply {
                if (validated) {
                    return@apply
                }

                output().validate()
                _type().let {
                    if (it != JsonValue.from("function_call_output")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                id()
                callId()
                caller().ifPresent { it.validate() }
                name()
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
                (output.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("function_call_output")) 1 else 0 } +
                    (if (id.asKnown().isPresent) 1 else 0) +
                    (if (callId.asKnown().isPresent) 1 else 0) +
                    (caller.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (namespace.asKnown().isPresent) 1 else 0) +
                    (status.asKnown().getOrNull()?.validity() ?: 0)

            /** Text, image, or file output of the function tool call. */
            @JsonDeserialize(using = Output.Deserializer::class)
            @JsonSerialize(using = Output.Serializer::class)
            class Output
            private constructor(
                private val string: String? = null,
                private val responseFunctionCallOutputItemList:
                    List<ResponseFunctionCallOutputItem>? =
                    null,
                private val _json: JsonValue? = null,
            ) {

                /** A JSON string of the output of the function tool call. */
                fun string(): Optional<String> = Optional.ofNullable(string)

                /** An array of content outputs (text, image, file) for the function tool call. */
                fun responseFunctionCallOutputItemList():
                    Optional<List<ResponseFunctionCallOutputItem>> =
                    Optional.ofNullable(responseFunctionCallOutputItemList)

                fun isString(): Boolean = string != null

                fun isResponseFunctionCallOutputItemList(): Boolean =
                    responseFunctionCallOutputItemList != null

                /** A JSON string of the output of the function tool call. */
                fun asString(): String = string.getOrThrow("string")

                /** An array of content outputs (text, image, file) for the function tool call. */
                fun asResponseFunctionCallOutputItemList(): List<ResponseFunctionCallOutputItem> =
                    responseFunctionCallOutputItemList.getOrThrow(
                        "responseFunctionCallOutputItemList"
                    )

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
                        responseFunctionCallOutputItemList != null ->
                            visitor.visitResponseFunctionCallOutputItemList(
                                responseFunctionCallOutputItemList
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Output = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitString(string: String) {}

                            override fun visitResponseFunctionCallOutputItemList(
                                responseFunctionCallOutputItemList:
                                    List<ResponseFunctionCallOutputItem>
                            ) {
                                responseFunctionCallOutputItemList.forEach { it.validate() }
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

                            override fun visitResponseFunctionCallOutputItemList(
                                responseFunctionCallOutputItemList:
                                    List<ResponseFunctionCallOutputItem>
                            ) = responseFunctionCallOutputItemList.sumOf { it.validity().toInt() }

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Output &&
                        string == other.string &&
                        responseFunctionCallOutputItemList ==
                            other.responseFunctionCallOutputItemList
                }

                override fun hashCode(): Int =
                    Objects.hash(string, responseFunctionCallOutputItemList)

                override fun toString(): String =
                    when {
                        string != null -> "Output{string=$string}"
                        responseFunctionCallOutputItemList != null ->
                            "Output{responseFunctionCallOutputItemList=$responseFunctionCallOutputItemList}"
                        _json != null -> "Output{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Output")
                    }

                companion object {

                    /** A JSON string of the output of the function tool call. */
                    @JvmStatic fun ofString(string: String) = Output(string = string)

                    /**
                     * An array of content outputs (text, image, file) for the function tool call.
                     */
                    @JvmStatic
                    fun ofResponseFunctionCallOutputItemList(
                        responseFunctionCallOutputItemList: List<ResponseFunctionCallOutputItem>
                    ) =
                        Output(
                            responseFunctionCallOutputItemList =
                                responseFunctionCallOutputItemList.toImmutable()
                        )
                }

                /**
                 * An interface that defines how to map each variant of [Output] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    /** A JSON string of the output of the function tool call. */
                    fun visitString(string: String): T

                    /**
                     * An array of content outputs (text, image, file) for the function tool call.
                     */
                    fun visitResponseFunctionCallOutputItemList(
                        responseFunctionCallOutputItemList: List<ResponseFunctionCallOutputItem>
                    ): T

                    /**
                     * Maps an unknown variant of [Output] to a value of type [T].
                     *
                     * An instance of [Output] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Output: $json")
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
                                            jacksonTypeRef<List<ResponseFunctionCallOutputItem>>(),
                                        )
                                        ?.let {
                                            Output(
                                                responseFunctionCallOutputItemList = it,
                                                _json = json,
                                            )
                                        },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // boolean).
                            0 -> Output(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
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
                            value.responseFunctionCallOutputItemList != null ->
                                generator.writeObject(value.responseFunctionCallOutputItemList)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Output")
                        }
                    }
                }
            }

            /** The execution context that produced this tool call. */
            @JsonDeserialize(using = Caller.Deserializer::class)
            @JsonSerialize(using = Caller.Serializer::class)
            class Caller
            private constructor(
                private val direct: JsonValue? = null,
                private val program: Program? = null,
                private val _json: JsonValue? = null,
            ) {

                fun direct(): Optional<JsonValue> = Optional.ofNullable(direct)

                fun program(): Optional<Program> = Optional.ofNullable(program)

                fun isDirect(): Boolean = direct != null

                fun isProgram(): Boolean = program != null

                fun asDirect(): JsonValue = direct.getOrThrow("direct")

                fun asProgram(): Program = program.getOrThrow("program")

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
                 * Optional<String> result = caller.accept(new Caller.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitDirect(JsonValue direct) {
                 *         return Optional.of(direct.toString());
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
                        direct != null -> visitor.visitDirect(direct)
                        program != null -> visitor.visitProgram(program)
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
                fun validate(): Caller = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitDirect(direct: JsonValue) {
                                direct.let {
                                    if (it != JsonValue.from(mapOf("type" to "direct"))) {
                                        throw OpenAIInvalidDataException(
                                            "'direct' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitProgram(program: Program) {
                                program.validate()
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
                            override fun visitDirect(direct: JsonValue) =
                                direct.let {
                                    if (it == JsonValue.from(mapOf("type" to "direct"))) 1 else 0
                                }

                            override fun visitProgram(program: Program) = program.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Caller && direct == other.direct && program == other.program
                }

                override fun hashCode(): Int = Objects.hash(direct, program)

                override fun toString(): String =
                    when {
                        direct != null -> "Caller{direct=$direct}"
                        program != null -> "Caller{program=$program}"
                        _json != null -> "Caller{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Caller")
                    }

                companion object {

                    @JvmStatic
                    fun ofDirect() = Caller(direct = JsonValue.from(mapOf("type" to "direct")))

                    @JvmStatic fun ofProgram(program: Program) = Caller(program = program)
                }

                /**
                 * An interface that defines how to map each variant of [Caller] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitDirect(direct: JsonValue): T

                    fun visitProgram(program: Program): T

                    /**
                     * Maps an unknown variant of [Caller] to a value of type [T].
                     *
                     * An instance of [Caller] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Caller: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Caller>(Caller::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Caller {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "direct" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Caller(direct = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Caller(_json = json)
                            }
                            "program" -> {
                                return tryDeserialize(node, jacksonTypeRef<Program>())?.let {
                                    Caller(program = it, _json = json)
                                } ?: Caller(_json = json)
                            }
                        }

                        return Caller(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Caller>(Caller::class) {

                    override fun serialize(
                        value: Caller,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.direct != null -> generator.writeObject(value.direct)
                            value.program != null -> generator.writeObject(value.program)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Caller")
                        }
                    }
                }

                class Program
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val callerId: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("caller_id")
                        @ExcludeMissing
                        callerId: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(callerId, type, mutableMapOf())

                    /**
                     * The call ID of the program item that produced this tool call.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun callerId(): String = callerId.getRequired("caller_id")

                    /**
                     * The caller type. Always `program`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("program")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [callerId].
                     *
                     * Unlike [callerId], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("caller_id")
                    @ExcludeMissing
                    fun _callerId(): JsonField<String> = callerId

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
                         * Returns a mutable builder for constructing an instance of [Program].
                         *
                         * The following fields are required:
                         * ```java
                         * .callerId()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Program]. */
                    class Builder internal constructor() {

                        private var callerId: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("program")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(program: Program) = apply {
                            callerId = program.callerId
                            type = program.type
                            additionalProperties = program.additionalProperties.toMutableMap()
                        }

                        /** The call ID of the program item that produced this tool call. */
                        fun callerId(callerId: String) = callerId(JsonField.of(callerId))

                        /**
                         * Sets [Builder.callerId] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.callerId] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun callerId(callerId: JsonField<String>) = apply {
                            this.callerId = callerId
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("program")
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
                         * Returns an immutable instance of [Program].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .callerId()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Program =
                            Program(
                                checkRequired("callerId", callerId),
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
                    fun validate(): Program = apply {
                        if (validated) {
                            return@apply
                        }

                        callerId()
                        _type().let {
                            if (it != JsonValue.from("program")) {
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
                        (if (callerId.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("program")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Program &&
                            callerId == other.callerId &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(callerId, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Program{callerId=$callerId, type=$type, additionalProperties=$additionalProperties}"
                }
            }

            /**
             * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
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
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    IN_PROGRESS,
                    COMPLETED,
                    INCOMPLETE,
                    /**
                     * An enum member indicating that [Status] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
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
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
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
                    output == other.output &&
                    type == other.type &&
                    id == other.id &&
                    callId == other.callId &&
                    caller == other.caller &&
                    name == other.name &&
                    namespace == other.namespace &&
                    status == other.status &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    output,
                    type,
                    id,
                    callId,
                    caller,
                    name,
                    namespace,
                    status,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FunctionCallOutput{output=$output, type=$type, id=$id, callId=$callId, caller=$caller, name=$name, namespace=$namespace, status=$status, additionalProperties=$additionalProperties}"
        }
    }
}
