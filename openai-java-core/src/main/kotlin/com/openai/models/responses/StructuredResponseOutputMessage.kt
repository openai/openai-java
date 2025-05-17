package com.openai.models.responses

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.responseTypeFromJson
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

/**
 * A wrapper for [ResponseOutputMessage] that provides type-safe access to the [content] when using
 * the _Structured Outputs_ feature to deserialize a JSON response to an instance of an arbitrary
 * class. See the SDK documentation for more details on _Structured Outputs_.
 *
 * @param T The type of the class to which the JSON data in the content will be deserialized when
 *   the output text of the [content] is retrieved.
 */
class StructuredResponseOutputMessage<T : Any>(
    @get:JvmName("responseType") val responseType: Class<T>,
    @get:JvmName("rawMessage") val rawMessage: ResponseOutputMessage,
) {
    /** @see ResponseOutputMessage.id */
    fun id(): String = rawMessage.id()

    private val content by lazy {
        rawMessage._content().map { contents -> contents.map { Content<T>(responseType, it) } }
    }

    /** @see ResponseOutputMessage.content */
    fun content(): List<Content<T>> = content.getRequired("content")

    /** @see ResponseOutputMessage._role */
    fun _role(): JsonValue = rawMessage._role()

    /** @see ResponseOutputMessage.status */
    fun status(): ResponseOutputMessage.Status = rawMessage.status()

    /** @see ResponseOutputMessage._type */
    fun _type(): JsonValue = rawMessage._type()

    /** @see ResponseOutputMessage._id */
    fun _id(): JsonField<String> = rawMessage._id()

    /** @see ResponseOutputMessage._content */
    fun _content(): JsonField<List<Content<T>>> = content

    /** @see ResponseOutputMessage._status */
    fun _status(): JsonField<ResponseOutputMessage.Status> = rawMessage._status()

    /** @see ResponseOutputMessage._additionalProperties */
    fun _additionalProperties(): Map<String, JsonValue> = rawMessage._additionalProperties()

    /** @see ResponseOutputMessage.validate */
    fun validate(): StructuredResponseOutputMessage<T> = apply {
        // `content()` is a different type to that in the delegate class.
        content().forEach { it.validate() }
        rawMessage.validate()
    }

    /** @see ResponseOutputMessage.isValid */
    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (_: OpenAIInvalidDataException) {
            false
        }

    /** @see ResponseOutputMessage.Content */
    class Content<T : Any>(
        @get:JvmName("responseType") val responseType: Class<T>,
        @get:JvmName("rawContent") val rawContent: ResponseOutputMessage.Content,
    ) {
        private val outputText by lazy {
            rawContent.outputText().map { responseTypeFromJson(it.text(), responseType) }
        }

        /**
         * Gets the output text, but deserialized to an instance of the response type class.
         *
         * @see ResponseOutputMessage.Content.outputText
         */
        fun outputText(): Optional<T> = outputText

        /** @see ResponseOutputMessage.Content.refusal */
        fun refusal(): Optional<ResponseOutputRefusal> = rawContent.refusal()

        /** @see ResponseOutputMessage.Content.isOutputText */
        // No need to check `outputText`; the delegate can just check the source value is present.
        fun isOutputText(): Boolean = rawContent.isOutputText()

        /** @see ResponseOutputMessage.Content.isRefusal */
        fun isRefusal(): Boolean = rawContent.isRefusal()

        /** @see ResponseOutputMessage.Content.asOutputText */
        fun asOutputText(): T =
            outputText.getOrElse {
                // Same behavior as `com.openai.core.getOrThrow` used by the delegate class.
                throw OpenAIInvalidDataException("`outputText` is not present")
            }

        /** @see ResponseOutputMessage.Content.asRefusal */
        fun asRefusal(): ResponseOutputRefusal = rawContent.asRefusal()

        /** @see ResponseOutputMessage.Content._json */
        fun _json(): Optional<JsonValue> = rawContent._json()

        /** @see ResponseOutputMessage.Content.accept */
        fun <R> accept(visitor: Visitor<T, R>): R =
            when {
                outputText.isPresent -> visitor.visitOutputText(outputText.get())
                refusal().isPresent -> visitor.visitRefusal(refusal().get())
                else -> visitor.unknown(_json().getOrNull())
            }

        /** @see ResponseOutputMessage.Content.validate */
        fun validate(): Content<T> = apply {
            // The `outputText` object, as it is a user-defined type that is unlikely to have a
            // `validate()` function/method, so validate the underlying `ResponseOutputText` from
            // which it is derived. That can be done by the delegate class.
            rawContent.validate()
        }

        /** @see ResponseOutputMessage.Content.isValid */
        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (_: OpenAIInvalidDataException) {
                false
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Content<*> &&
                rawContent == other.rawContent &&
                responseType == other.responseType
        }

        override fun hashCode(): Int = Objects.hash(rawContent, responseType)

        override fun toString(): String =
            "${javaClass.simpleName}{responseType=$responseType, rawContent=$rawContent}"

        /** @see ResponseOutputMessage.Content.Visitor */
        interface Visitor<T : Any, out R> {
            /** @see ResponseOutputMessage.Content.Visitor.visitOutputText */
            fun visitOutputText(outputText: T): R

            /** @see ResponseOutputMessage.Content.Visitor.visitRefusal */
            fun visitRefusal(refusal: ResponseOutputRefusal): R

            /** @see ResponseOutputMessage.Content.Visitor.unknown */
            fun unknown(json: JsonValue?): R {
                throw OpenAIInvalidDataException("Unknown Content: $json")
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StructuredResponseOutputMessage<*> &&
            responseType == other.responseType &&
            rawMessage == other.rawMessage
    }

    private val hashCode: Int by lazy { Objects.hash(responseType, rawMessage) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "${javaClass.simpleName}{responseType=$responseType, rawMessage=$rawMessage}"
}
