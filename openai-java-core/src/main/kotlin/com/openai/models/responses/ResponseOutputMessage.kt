// File generated from our OpenAPI spec by Stainless.

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
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** An output message from the model. */
@NoAutoDetect
class ResponseOutputMessage
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<List<Content>> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonValue = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The unique ID of the output message. */
    fun id(): String = id.getRequired("id")

    /** The content of the output message. */
    fun content(): List<Content> = content.getRequired("content")

    /** The role of the output message. Always `assistant`. */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

    /**
     * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
     * Populated when input items are returned via API.
     */
    fun status(): Status = status.getRequired("status")

    /** The type of the output message. Always `message`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The unique ID of the output message. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The content of the output message. */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<Content>> = content

    /**
     * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
     * Populated when input items are returned via API.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseOutputMessage = apply {
        if (validated) {
            return@apply
        }

        id()
        content().forEach { it.validate() }
        _role().let {
            if (it != JsonValue.from("assistant")) {
                throw OpenAIInvalidDataException("'role' is invalid, received $it")
            }
        }
        status()
        _type().let {
            if (it != JsonValue.from("message")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseOutputMessage].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseOutputMessage]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var content: JsonField<MutableList<Content>>? = null
        private var role: JsonValue = JsonValue.from("assistant")
        private var status: JsonField<Status>? = null
        private var type: JsonValue = JsonValue.from("message")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseOutputMessage: ResponseOutputMessage) = apply {
            id = responseOutputMessage.id
            content = responseOutputMessage.content.map { it.toMutableList() }
            role = responseOutputMessage.role
            status = responseOutputMessage.status
            type = responseOutputMessage.type
            additionalProperties = responseOutputMessage.additionalProperties.toMutableMap()
        }

        /** The unique ID of the output message. */
        fun id(id: String) = id(JsonField.of(id))

        /** The unique ID of the output message. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The content of the output message. */
        fun content(content: List<Content>) = content(JsonField.of(content))

        /** The content of the output message. */
        fun content(content: JsonField<List<Content>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /** The content of the output message. */
        fun addContent(content: Content) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).also {
                    checkKnown("content", it).add(content)
                }
        }

        /** A text output from the model. */
        fun addContent(outputText: ResponseOutputText) =
            addContent(Content.ofOutputText(outputText))

        /** A refusal from the model. */
        fun addContent(refusal: ResponseOutputRefusal) = addContent(Content.ofRefusal(refusal))

        /** A refusal from the model. */
        fun addRefusalContent(refusal: String) =
            addContent(ResponseOutputRefusal.builder().refusal(refusal).build())

        /** The role of the output message. Always `assistant`. */
        fun role(role: JsonValue) = apply { this.role = role }

        /**
         * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
         * Populated when input items are returned via API.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
         * Populated when input items are returned via API.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The type of the output message. Always `message`. */
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

        fun build(): ResponseOutputMessage =
            ResponseOutputMessage(
                checkRequired("id", id),
                checkRequired("content", content).map { it.toImmutable() },
                role,
                checkRequired("status", status),
                type,
                additionalProperties.toImmutable(),
            )
    }

    /** A text output from the model. */
    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val outputText: ResponseOutputText? = null,
        private val refusal: ResponseOutputRefusal? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A text output from the model. */
        fun outputText(): Optional<ResponseOutputText> = Optional.ofNullable(outputText)

        /** A refusal from the model. */
        fun refusal(): Optional<ResponseOutputRefusal> = Optional.ofNullable(refusal)

        fun isOutputText(): Boolean = outputText != null

        fun isRefusal(): Boolean = refusal != null

        /** A text output from the model. */
        fun asOutputText(): ResponseOutputText = outputText.getOrThrow("outputText")

        /** A refusal from the model. */
        fun asRefusal(): ResponseOutputRefusal = refusal.getOrThrow("refusal")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                outputText != null -> visitor.visitOutputText(outputText)
                refusal != null -> visitor.visitRefusal(refusal)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Content = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitOutputText(outputText: ResponseOutputText) {
                        outputText.validate()
                    }

                    override fun visitRefusal(refusal: ResponseOutputRefusal) {
                        refusal.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Content && outputText == other.outputText && refusal == other.refusal /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(outputText, refusal) /* spotless:on */

        override fun toString(): String =
            when {
                outputText != null -> "Content{outputText=$outputText}"
                refusal != null -> "Content{refusal=$refusal}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }

        companion object {

            /** A text output from the model. */
            @JvmStatic
            fun ofOutputText(outputText: ResponseOutputText) = Content(outputText = outputText)

            /** A refusal from the model. */
            @JvmStatic fun ofRefusal(refusal: ResponseOutputRefusal) = Content(refusal = refusal)
        }

        /**
         * An interface that defines how to map each variant of [Content] to a value of type [T].
         */
        interface Visitor<out T> {

            /** A text output from the model. */
            fun visitOutputText(outputText: ResponseOutputText): T

            /** A refusal from the model. */
            fun visitRefusal(refusal: ResponseOutputRefusal): T

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
                    "output_text" -> {
                        tryDeserialize(node, jacksonTypeRef<ResponseOutputText>()) { it.validate() }
                            ?.let {
                                return Content(outputText = it, _json = json)
                            }
                    }
                    "refusal" -> {
                        tryDeserialize(node, jacksonTypeRef<ResponseOutputRefusal>()) {
                                it.validate()
                            }
                            ?.let {
                                return Content(refusal = it, _json = json)
                            }
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
                    value.outputText != null -> generator.writeObject(value.outputText)
                    value.refusal != null -> generator.writeObject(value.refusal)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }
    }

    /**
     * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
     * Populated when input items are returned via API.
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseOutputMessage && id == other.id && content == other.content && role == other.role && status == other.status && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, content, role, status, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseOutputMessage{id=$id, content=$content, role=$role, status=$status, type=$type, additionalProperties=$additionalProperties}"
}
