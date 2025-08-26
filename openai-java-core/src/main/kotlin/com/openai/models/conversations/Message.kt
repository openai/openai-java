// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Message
private constructor(
    private val id: JsonField<String>,
    private val content: JsonField<List<Content>>,
    private val role: JsonField<Role>,
    private val status: JsonField<Status>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("content")
        @ExcludeMissing
        content: JsonField<List<Content>> = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing role: JsonField<Role> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, content, role, status, type, mutableMapOf())

    /**
     * The unique ID of the message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The content of the message
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun content(): List<Content> = content.getRequired("content")

    /**
     * The role of the message. One of `unknown`, `user`, `assistant`, `system`, `critic`,
     * `discriminator`, `developer`, or `tool`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun role(): Role = role.getRequired("role")

    /**
     * The status of item. One of `in_progress`, `completed`, or `incomplete`. Populated when items
     * are returned via API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The type of the message. Always set to `message`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("message")
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
     * Returns the raw JSON value of [content].
     *
     * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<Content>> = content

    /**
     * Returns the raw JSON value of [role].
     *
     * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

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
         * Returns a mutable builder for constructing an instance of [Message].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .role()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Message]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var content: JsonField<MutableList<Content>>? = null
        private var role: JsonField<Role>? = null
        private var status: JsonField<Status>? = null
        private var type: JsonValue = JsonValue.from("message")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(message: Message) = apply {
            id = message.id
            content = message.content.map { it.toMutableList() }
            role = message.role
            status = message.status
            type = message.type
            additionalProperties = message.additionalProperties.toMutableMap()
        }

        /** The unique ID of the message. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The content of the message */
        fun content(content: List<Content>) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed `List<Content>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun content(content: JsonField<List<Content>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /**
         * Adds a single [Content] to [Builder.content].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContent(content: Content) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).also {
                    checkKnown("content", it).add(content)
                }
        }

        /** Alias for calling [addContent] with `Content.ofInputText(inputText)`. */
        fun addContent(inputText: InputTextContent) = addContent(Content.ofInputText(inputText))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * InputTextContent.builder()
         *     .text(text)
         *     .build()
         * ```
         */
        fun addInputTextContent(text: String) =
            addContent(InputTextContent.builder().text(text).build())

        /** Alias for calling [addContent] with `Content.ofOutputText(outputText)`. */
        fun addContent(outputText: OutputTextContent) = addContent(Content.ofOutputText(outputText))

        /** Alias for calling [addContent] with `Content.ofText(text)`. */
        fun addContent(text: TextContent) = addContent(Content.ofText(text))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * TextContent.builder()
         *     .text(text)
         *     .build()
         * ```
         */
        fun addTextContent(text: String) = addContent(TextContent.builder().text(text).build())

        /** Alias for calling [addContent] with `Content.ofSummaryText(summaryText)`. */
        fun addContent(summaryText: SummaryTextContent) =
            addContent(Content.ofSummaryText(summaryText))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * SummaryTextContent.builder()
         *     .text(text)
         *     .build()
         * ```
         */
        fun addSummaryTextContent(text: String) =
            addContent(SummaryTextContent.builder().text(text).build())

        /** Alias for calling [addContent] with `Content.ofRefusal(refusal)`. */
        fun addContent(refusal: RefusalContent) = addContent(Content.ofRefusal(refusal))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * RefusalContent.builder()
         *     .refusal(refusal)
         *     .build()
         * ```
         */
        fun addRefusalContent(refusal: String) =
            addContent(RefusalContent.builder().refusal(refusal).build())

        /** Alias for calling [addContent] with `Content.ofInputImage(inputImage)`. */
        fun addContent(inputImage: InputImageContent) = addContent(Content.ofInputImage(inputImage))

        /**
         * Alias for calling [addContent] with `Content.ofComputerScreenshot(computerScreenshot)`.
         */
        fun addContent(computerScreenshot: ComputerScreenshotContent) =
            addContent(Content.ofComputerScreenshot(computerScreenshot))

        /** Alias for calling [addContent] with `Content.ofInputFile(inputFile)`. */
        fun addContent(inputFile: InputFileContent) = addContent(Content.ofInputFile(inputFile))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * InputFileContent.builder()
         *     .fileId(fileId)
         *     .build()
         * ```
         */
        fun addInputFileContent(fileId: String?) =
            addContent(InputFileContent.builder().fileId(fileId).build())

        /** Alias for calling [addInputFileContent] with `fileId.orElse(null)`. */
        fun addInputFileContent(fileId: Optional<String>) = addInputFileContent(fileId.getOrNull())

        /**
         * The role of the message. One of `unknown`, `user`, `assistant`, `system`, `critic`,
         * `discriminator`, `developer`, or `tool`.
         */
        fun role(role: Role) = role(JsonField.of(role))

        /**
         * Sets [Builder.role] to an arbitrary JSON value.
         *
         * You should usually call [Builder.role] with a well-typed [Role] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /**
         * The status of item. One of `in_progress`, `completed`, or `incomplete`. Populated when
         * items are returned via API.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("message")
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
         * Returns an immutable instance of [Message].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .role()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Message =
            Message(
                checkRequired("id", id),
                checkRequired("content", content).map { it.toImmutable() },
                checkRequired("role", role),
                checkRequired("status", status),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Message = apply {
        if (validated) {
            return@apply
        }

        id()
        content().forEach { it.validate() }
        role().validate()
        status().validate()
        _type().let {
            if (it != JsonValue.from("message")) {
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
            (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (role.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("message")) 1 else 0 }

    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val inputText: InputTextContent? = null,
        private val outputText: OutputTextContent? = null,
        private val text: TextContent? = null,
        private val summaryText: SummaryTextContent? = null,
        private val refusal: RefusalContent? = null,
        private val inputImage: InputImageContent? = null,
        private val computerScreenshot: ComputerScreenshotContent? = null,
        private val inputFile: InputFileContent? = null,
        private val _json: JsonValue? = null,
    ) {

        fun inputText(): Optional<InputTextContent> = Optional.ofNullable(inputText)

        fun outputText(): Optional<OutputTextContent> = Optional.ofNullable(outputText)

        fun text(): Optional<TextContent> = Optional.ofNullable(text)

        fun summaryText(): Optional<SummaryTextContent> = Optional.ofNullable(summaryText)

        fun refusal(): Optional<RefusalContent> = Optional.ofNullable(refusal)

        fun inputImage(): Optional<InputImageContent> = Optional.ofNullable(inputImage)

        fun computerScreenshot(): Optional<ComputerScreenshotContent> =
            Optional.ofNullable(computerScreenshot)

        fun inputFile(): Optional<InputFileContent> = Optional.ofNullable(inputFile)

        fun isInputText(): Boolean = inputText != null

        fun isOutputText(): Boolean = outputText != null

        fun isText(): Boolean = text != null

        fun isSummaryText(): Boolean = summaryText != null

        fun isRefusal(): Boolean = refusal != null

        fun isInputImage(): Boolean = inputImage != null

        fun isComputerScreenshot(): Boolean = computerScreenshot != null

        fun isInputFile(): Boolean = inputFile != null

        fun asInputText(): InputTextContent = inputText.getOrThrow("inputText")

        fun asOutputText(): OutputTextContent = outputText.getOrThrow("outputText")

        fun asText(): TextContent = text.getOrThrow("text")

        fun asSummaryText(): SummaryTextContent = summaryText.getOrThrow("summaryText")

        fun asRefusal(): RefusalContent = refusal.getOrThrow("refusal")

        fun asInputImage(): InputImageContent = inputImage.getOrThrow("inputImage")

        fun asComputerScreenshot(): ComputerScreenshotContent =
            computerScreenshot.getOrThrow("computerScreenshot")

        fun asInputFile(): InputFileContent = inputFile.getOrThrow("inputFile")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                inputText != null -> visitor.visitInputText(inputText)
                outputText != null -> visitor.visitOutputText(outputText)
                text != null -> visitor.visitText(text)
                summaryText != null -> visitor.visitSummaryText(summaryText)
                refusal != null -> visitor.visitRefusal(refusal)
                inputImage != null -> visitor.visitInputImage(inputImage)
                computerScreenshot != null -> visitor.visitComputerScreenshot(computerScreenshot)
                inputFile != null -> visitor.visitInputFile(inputFile)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Content = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitInputText(inputText: InputTextContent) {
                        inputText.validate()
                    }

                    override fun visitOutputText(outputText: OutputTextContent) {
                        outputText.validate()
                    }

                    override fun visitText(text: TextContent) {
                        text.validate()
                    }

                    override fun visitSummaryText(summaryText: SummaryTextContent) {
                        summaryText.validate()
                    }

                    override fun visitRefusal(refusal: RefusalContent) {
                        refusal.validate()
                    }

                    override fun visitInputImage(inputImage: InputImageContent) {
                        inputImage.validate()
                    }

                    override fun visitComputerScreenshot(
                        computerScreenshot: ComputerScreenshotContent
                    ) {
                        computerScreenshot.validate()
                    }

                    override fun visitInputFile(inputFile: InputFileContent) {
                        inputFile.validate()
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
                    override fun visitInputText(inputText: InputTextContent) = inputText.validity()

                    override fun visitOutputText(outputText: OutputTextContent) =
                        outputText.validity()

                    override fun visitText(text: TextContent) = text.validity()

                    override fun visitSummaryText(summaryText: SummaryTextContent) =
                        summaryText.validity()

                    override fun visitRefusal(refusal: RefusalContent) = refusal.validity()

                    override fun visitInputImage(inputImage: InputImageContent) =
                        inputImage.validity()

                    override fun visitComputerScreenshot(
                        computerScreenshot: ComputerScreenshotContent
                    ) = computerScreenshot.validity()

                    override fun visitInputFile(inputFile: InputFileContent) = inputFile.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Content &&
                inputText == other.inputText &&
                outputText == other.outputText &&
                text == other.text &&
                summaryText == other.summaryText &&
                refusal == other.refusal &&
                inputImage == other.inputImage &&
                computerScreenshot == other.computerScreenshot &&
                inputFile == other.inputFile
        }

        override fun hashCode(): Int =
            Objects.hash(
                inputText,
                outputText,
                text,
                summaryText,
                refusal,
                inputImage,
                computerScreenshot,
                inputFile,
            )

        override fun toString(): String =
            when {
                inputText != null -> "Content{inputText=$inputText}"
                outputText != null -> "Content{outputText=$outputText}"
                text != null -> "Content{text=$text}"
                summaryText != null -> "Content{summaryText=$summaryText}"
                refusal != null -> "Content{refusal=$refusal}"
                inputImage != null -> "Content{inputImage=$inputImage}"
                computerScreenshot != null -> "Content{computerScreenshot=$computerScreenshot}"
                inputFile != null -> "Content{inputFile=$inputFile}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }

        companion object {

            @JvmStatic fun ofInputText(inputText: InputTextContent) = Content(inputText = inputText)

            @JvmStatic
            fun ofOutputText(outputText: OutputTextContent) = Content(outputText = outputText)

            @JvmStatic fun ofText(text: TextContent) = Content(text = text)

            @JvmStatic
            fun ofSummaryText(summaryText: SummaryTextContent) = Content(summaryText = summaryText)

            @JvmStatic fun ofRefusal(refusal: RefusalContent) = Content(refusal = refusal)

            @JvmStatic
            fun ofInputImage(inputImage: InputImageContent) = Content(inputImage = inputImage)

            @JvmStatic
            fun ofComputerScreenshot(computerScreenshot: ComputerScreenshotContent) =
                Content(computerScreenshot = computerScreenshot)

            @JvmStatic fun ofInputFile(inputFile: InputFileContent) = Content(inputFile = inputFile)
        }

        /**
         * An interface that defines how to map each variant of [Content] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitInputText(inputText: InputTextContent): T

            fun visitOutputText(outputText: OutputTextContent): T

            fun visitText(text: TextContent): T

            fun visitSummaryText(summaryText: SummaryTextContent): T

            fun visitRefusal(refusal: RefusalContent): T

            fun visitInputImage(inputImage: InputImageContent): T

            fun visitComputerScreenshot(computerScreenshot: ComputerScreenshotContent): T

            fun visitInputFile(inputFile: InputFileContent): T

            /**
             * Maps an unknown variant of [Content] to a value of type [T].
             *
             * An instance of [Content] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
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
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "input_text" -> {
                        return tryDeserialize(node, jacksonTypeRef<InputTextContent>())?.let {
                            Content(inputText = it, _json = json)
                        } ?: Content(_json = json)
                    }
                    "output_text" -> {
                        return tryDeserialize(node, jacksonTypeRef<OutputTextContent>())?.let {
                            Content(outputText = it, _json = json)
                        } ?: Content(_json = json)
                    }
                    "text" -> {
                        return tryDeserialize(node, jacksonTypeRef<TextContent>())?.let {
                            Content(text = it, _json = json)
                        } ?: Content(_json = json)
                    }
                    "summary_text" -> {
                        return tryDeserialize(node, jacksonTypeRef<SummaryTextContent>())?.let {
                            Content(summaryText = it, _json = json)
                        } ?: Content(_json = json)
                    }
                    "refusal" -> {
                        return tryDeserialize(node, jacksonTypeRef<RefusalContent>())?.let {
                            Content(refusal = it, _json = json)
                        } ?: Content(_json = json)
                    }
                    "input_image" -> {
                        return tryDeserialize(node, jacksonTypeRef<InputImageContent>())?.let {
                            Content(inputImage = it, _json = json)
                        } ?: Content(_json = json)
                    }
                    "computer_screenshot" -> {
                        return tryDeserialize(node, jacksonTypeRef<ComputerScreenshotContent>())
                            ?.let { Content(computerScreenshot = it, _json = json) }
                            ?: Content(_json = json)
                    }
                    "input_file" -> {
                        return tryDeserialize(node, jacksonTypeRef<InputFileContent>())?.let {
                            Content(inputFile = it, _json = json)
                        } ?: Content(_json = json)
                    }
                }

                return Content(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Content>(Content::class) {

            override fun serialize(
                value: Content,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.inputText != null -> generator.writeObject(value.inputText)
                    value.outputText != null -> generator.writeObject(value.outputText)
                    value.text != null -> generator.writeObject(value.text)
                    value.summaryText != null -> generator.writeObject(value.summaryText)
                    value.refusal != null -> generator.writeObject(value.refusal)
                    value.inputImage != null -> generator.writeObject(value.inputImage)
                    value.computerScreenshot != null ->
                        generator.writeObject(value.computerScreenshot)
                    value.inputFile != null -> generator.writeObject(value.inputFile)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }
    }

    /**
     * The role of the message. One of `unknown`, `user`, `assistant`, `system`, `critic`,
     * `discriminator`, `developer`, or `tool`.
     */
    class Role @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val UNKNOWN = of("unknown")

            @JvmField val USER = of("user")

            @JvmField val ASSISTANT = of("assistant")

            @JvmField val SYSTEM = of("system")

            @JvmField val CRITIC = of("critic")

            @JvmField val DISCRIMINATOR = of("discriminator")

            @JvmField val DEVELOPER = of("developer")

            @JvmField val TOOL = of("tool")

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        /** An enum containing [Role]'s known values. */
        enum class Known {
            UNKNOWN,
            USER,
            ASSISTANT,
            SYSTEM,
            CRITIC,
            DISCRIMINATOR,
            DEVELOPER,
            TOOL,
        }

        /**
         * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Role] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            UNKNOWN,
            USER,
            ASSISTANT,
            SYSTEM,
            CRITIC,
            DISCRIMINATOR,
            DEVELOPER,
            TOOL,
            /** An enum member indicating that [Role] was instantiated with an unknown value. */
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
                UNKNOWN -> Value.UNKNOWN
                USER -> Value.USER
                ASSISTANT -> Value.ASSISTANT
                SYSTEM -> Value.SYSTEM
                CRITIC -> Value.CRITIC
                DISCRIMINATOR -> Value.DISCRIMINATOR
                DEVELOPER -> Value.DEVELOPER
                TOOL -> Value.TOOL
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
                UNKNOWN -> Known.UNKNOWN
                USER -> Known.USER
                ASSISTANT -> Known.ASSISTANT
                SYSTEM -> Known.SYSTEM
                CRITIC -> Known.CRITIC
                DISCRIMINATOR -> Known.DISCRIMINATOR
                DEVELOPER -> Known.DEVELOPER
                TOOL -> Known.TOOL
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
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

        fun validate(): Role = apply {
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

            return other is Role && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The status of item. One of `in_progress`, `completed`, or `incomplete`. Populated when items
     * are returned via API.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IN_PROGRESS,
            COMPLETED,
            INCOMPLETE,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                INCOMPLETE -> Value.INCOMPLETE
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
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                INCOMPLETE -> Known.INCOMPLETE
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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

        return other is Message &&
            id == other.id &&
            content == other.content &&
            role == other.role &&
            status == other.status &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, content, role, status, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Message{id=$id, content=$content, role=$role, status=$status, type=$type, additionalProperties=$additionalProperties}"
}
