// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@NoAutoDetect
class VectorStoreSearchResponse
@JsonCreator
private constructor(
    @JsonProperty("attributes")
    @ExcludeMissing
    private val attributes: JsonField<Attributes> = JsonMissing.of(),
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<List<Content>> = JsonMissing.of(),
    @JsonProperty("file_id")
    @ExcludeMissing
    private val fileId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("filename")
    @ExcludeMissing
    private val filename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("score") @ExcludeMissing private val score: JsonField<Double> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard. Keys are strings with a maximum length of 64 characters. Values are
     * strings with a maximum length of 512 characters, booleans, or numbers.
     */
    fun attributes(): Optional<Attributes> =
        Optional.ofNullable(attributes.getNullable("attributes"))

    /** Content chunks from the file. */
    fun content(): List<Content> = content.getRequired("content")

    /** The ID of the vector store file. */
    fun fileId(): String = fileId.getRequired("file_id")

    /** The name of the vector store file. */
    fun filename(): String = filename.getRequired("filename")

    /** The similarity score for the result. */
    fun score(): Double = score.getRequired("score")

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard. Keys are strings with a maximum length of 64 characters. Values are
     * strings with a maximum length of 512 characters, booleans, or numbers.
     */
    @JsonProperty("attributes")
    @ExcludeMissing
    fun _attributes(): JsonField<Attributes> = attributes

    /** Content chunks from the file. */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<Content>> = content

    /** The ID of the vector store file. */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    /** The name of the vector store file. */
    @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

    /** The similarity score for the result. */
    @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): VectorStoreSearchResponse = apply {
        if (validated) {
            return@apply
        }

        attributes().ifPresent { it.validate() }
        content().forEach { it.validate() }
        fileId()
        filename()
        score()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreSearchResponse].
         *
         * The following fields are required:
         * ```java
         * .attributes()
         * .content()
         * .fileId()
         * .filename()
         * .score()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VectorStoreSearchResponse]. */
    class Builder internal constructor() {

        private var attributes: JsonField<Attributes>? = null
        private var content: JsonField<MutableList<Content>>? = null
        private var fileId: JsonField<String>? = null
        private var filename: JsonField<String>? = null
        private var score: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vectorStoreSearchResponse: VectorStoreSearchResponse) = apply {
            attributes = vectorStoreSearchResponse.attributes
            content = vectorStoreSearchResponse.content.map { it.toMutableList() }
            fileId = vectorStoreSearchResponse.fileId
            filename = vectorStoreSearchResponse.filename
            score = vectorStoreSearchResponse.score
            additionalProperties = vectorStoreSearchResponse.additionalProperties.toMutableMap()
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard. Keys are strings with a maximum length of 64
         * characters. Values are strings with a maximum length of 512 characters, booleans, or
         * numbers.
         */
        fun attributes(attributes: Attributes?) = attributes(JsonField.ofNullable(attributes))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard. Keys are strings with a maximum length of 64
         * characters. Values are strings with a maximum length of 512 characters, booleans, or
         * numbers.
         */
        fun attributes(attributes: Optional<Attributes>) = attributes(attributes.getOrNull())

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard. Keys are strings with a maximum length of 64
         * characters. Values are strings with a maximum length of 512 characters, booleans, or
         * numbers.
         */
        fun attributes(attributes: JsonField<Attributes>) = apply { this.attributes = attributes }

        /** Content chunks from the file. */
        fun content(content: List<Content>) = content(JsonField.of(content))

        /** Content chunks from the file. */
        fun content(content: JsonField<List<Content>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /** Content chunks from the file. */
        fun addContent(content: Content) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).also {
                    checkKnown("content", it).add(content)
                }
        }

        /** The ID of the vector store file. */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /** The ID of the vector store file. */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /** The name of the vector store file. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /** The name of the vector store file. */
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        /** The similarity score for the result. */
        fun score(score: Double) = score(JsonField.of(score))

        /** The similarity score for the result. */
        fun score(score: JsonField<Double>) = apply { this.score = score }

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

        fun build(): VectorStoreSearchResponse =
            VectorStoreSearchResponse(
                checkRequired("attributes", attributes),
                checkRequired("content", content).map { it.toImmutable() },
                checkRequired("fileId", fileId),
                checkRequired("filename", filename),
                checkRequired("score", score),
                additionalProperties.toImmutable(),
            )
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard. Keys are strings with a maximum length of 64 characters. Values are
     * strings with a maximum length of 512 characters, booleans, or numbers.
     */
    @NoAutoDetect
    class Attributes
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Attributes = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Attributes]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Attributes]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attributes: Attributes) = apply {
                additionalProperties = attributes.additionalProperties.toMutableMap()
            }

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

            fun build(): Attributes = Attributes(additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Attributes && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Attributes{additionalProperties=$additionalProperties}"
    }

    @NoAutoDetect
    class Content
    @JsonCreator
    private constructor(
        @JsonProperty("text")
        @ExcludeMissing
        private val text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The text content returned from search. */
        fun text(): String = text.getRequired("text")

        /** The type of content. */
        fun type(): Type = type.getRequired("type")

        /** The text content returned from search. */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /** The type of content. */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Content = apply {
            if (validated) {
                return@apply
            }

            text()
            type()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Content].
             *
             * The following fields are required:
             * ```java
             * .text()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Content]. */
        class Builder internal constructor() {

            private var text: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(content: Content) = apply {
                text = content.text
                type = content.type
                additionalProperties = content.additionalProperties.toMutableMap()
            }

            /** The text content returned from search. */
            fun text(text: String) = text(JsonField.of(text))

            /** The text content returned from search. */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /** The type of content. */
            fun type(type: Type) = type(JsonField.of(type))

            /** The type of content. */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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

            fun build(): Content =
                Content(
                    checkRequired("text", text),
                    checkRequired("type", type),
                    additionalProperties.toImmutable(),
                )
        }

        /** The type of content. */
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

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                TEXT
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
            enum class Value {
                TEXT,
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
            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
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

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Type && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Content && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Content{text=$text, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreSearchResponse && attributes == other.attributes && content == other.content && fileId == other.fileId && filename == other.filename && score == other.score && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(attributes, content, fileId, filename, score, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VectorStoreSearchResponse{attributes=$attributes, content=$content, fileId=$fileId, filename=$filename, score=$score, additionalProperties=$additionalProperties}"
}
