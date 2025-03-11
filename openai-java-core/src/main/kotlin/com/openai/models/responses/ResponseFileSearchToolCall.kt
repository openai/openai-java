// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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

/**
 * The results of a file search tool call. See the
 * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
 * information.
 */
@NoAutoDetect
class ResponseFileSearchToolCall
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("queries")
    @ExcludeMissing
    private val queries: JsonField<List<String>> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("results")
    @ExcludeMissing
    private val results: JsonField<List<Result>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The unique ID of the file search tool call. */
    fun id(): String = id.getRequired("id")

    /** The queries used to search for files. */
    fun queries(): List<String> = queries.getRequired("queries")

    /**
     * The status of the file search tool call. One of `in_progress`, `searching`, `incomplete` or
     * `failed`,
     */
    fun status(): Status = status.getRequired("status")

    /** The type of the file search tool call. Always `file_search_call`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The results of the file search tool call. */
    fun results(): Optional<List<Result>> = Optional.ofNullable(results.getNullable("results"))

    /** The unique ID of the file search tool call. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The queries used to search for files. */
    @JsonProperty("queries") @ExcludeMissing fun _queries(): JsonField<List<String>> = queries

    /**
     * The status of the file search tool call. One of `in_progress`, `searching`, `incomplete` or
     * `failed`,
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /** The results of the file search tool call. */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseFileSearchToolCall = apply {
        if (validated) {
            return@apply
        }

        id()
        queries()
        status()
        _type().let {
            if (it != JsonValue.from("file_search_call")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        results().ifPresent { it.forEach { it.validate() } }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseFileSearchToolCall].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .queries()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFileSearchToolCall]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var queries: JsonField<MutableList<String>>? = null
        private var status: JsonField<Status>? = null
        private var type: JsonValue = JsonValue.from("file_search_call")
        private var results: JsonField<MutableList<Result>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseFileSearchToolCall: ResponseFileSearchToolCall) = apply {
            id = responseFileSearchToolCall.id
            queries = responseFileSearchToolCall.queries.map { it.toMutableList() }
            status = responseFileSearchToolCall.status
            type = responseFileSearchToolCall.type
            results = responseFileSearchToolCall.results.map { it.toMutableList() }
            additionalProperties = responseFileSearchToolCall.additionalProperties.toMutableMap()
        }

        /** The unique ID of the file search tool call. */
        fun id(id: String) = id(JsonField.of(id))

        /** The unique ID of the file search tool call. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The queries used to search for files. */
        fun queries(queries: List<String>) = queries(JsonField.of(queries))

        /** The queries used to search for files. */
        fun queries(queries: JsonField<List<String>>) = apply {
            this.queries = queries.map { it.toMutableList() }
        }

        /** The queries used to search for files. */
        fun addQuery(query: String) = apply {
            queries =
                (queries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("queries", it).add(query)
                }
        }

        /**
         * The status of the file search tool call. One of `in_progress`, `searching`, `incomplete`
         * or `failed`,
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The status of the file search tool call. One of `in_progress`, `searching`, `incomplete`
         * or `failed`,
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The type of the file search tool call. Always `file_search_call`. */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The results of the file search tool call. */
        fun results(results: List<Result>?) = results(JsonField.ofNullable(results))

        /** The results of the file search tool call. */
        fun results(results: Optional<List<Result>>) = results(results.getOrNull())

        /** The results of the file search tool call. */
        fun results(results: JsonField<List<Result>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /** The results of the file search tool call. */
        fun addResult(result: Result) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
                }
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

        fun build(): ResponseFileSearchToolCall =
            ResponseFileSearchToolCall(
                checkRequired("id", id),
                checkRequired("queries", queries).map { it.toImmutable() },
                checkRequired("status", status),
                type,
                (results ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The status of the file search tool call. One of `in_progress`, `searching`, `incomplete` or
     * `failed`,
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

            @JvmField val SEARCHING = of("searching")

            @JvmField val COMPLETED = of("completed")

            @JvmField val INCOMPLETE = of("incomplete")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            IN_PROGRESS,
            SEARCHING,
            COMPLETED,
            INCOMPLETE,
            FAILED,
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
            SEARCHING,
            COMPLETED,
            INCOMPLETE,
            FAILED,
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
                SEARCHING -> Value.SEARCHING
                COMPLETED -> Value.COMPLETED
                INCOMPLETE -> Value.INCOMPLETE
                FAILED -> Value.FAILED
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
                SEARCHING -> Known.SEARCHING
                COMPLETED -> Known.COMPLETED
                INCOMPLETE -> Known.INCOMPLETE
                FAILED -> Known.FAILED
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

    @NoAutoDetect
    class Result
    @JsonCreator
    private constructor(
        @JsonProperty("attributes")
        @ExcludeMissing
        private val attributes: JsonField<Attributes> = JsonMissing.of(),
        @JsonProperty("file_id")
        @ExcludeMissing
        private val fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("filename")
        @ExcludeMissing
        private val filename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("score")
        @ExcludeMissing
        private val score: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("text")
        @ExcludeMissing
        private val text: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard. Keys are strings with a maximum length of 64
         * characters. Values are strings with a maximum length of 512 characters, booleans, or
         * numbers.
         */
        fun attributes(): Optional<Attributes> =
            Optional.ofNullable(attributes.getNullable("attributes"))

        /** The unique ID of the file. */
        fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

        /** The name of the file. */
        fun filename(): Optional<String> = Optional.ofNullable(filename.getNullable("filename"))

        /** The relevance score of the file - a value between 0 and 1. */
        fun score(): Optional<Double> = Optional.ofNullable(score.getNullable("score"))

        /** The text that was retrieved from the file. */
        fun text(): Optional<String> = Optional.ofNullable(text.getNullable("text"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard. Keys are strings with a maximum length of 64
         * characters. Values are strings with a maximum length of 512 characters, booleans, or
         * numbers.
         */
        @JsonProperty("attributes")
        @ExcludeMissing
        fun _attributes(): JsonField<Attributes> = attributes

        /** The unique ID of the file. */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        /** The name of the file. */
        @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

        /** The relevance score of the file - a value between 0 and 1. */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

        /** The text that was retrieved from the file. */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            attributes().ifPresent { it.validate() }
            fileId()
            filename()
            score()
            text()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Result]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Result]. */
        class Builder internal constructor() {

            private var attributes: JsonField<Attributes> = JsonMissing.of()
            private var fileId: JsonField<String> = JsonMissing.of()
            private var filename: JsonField<String> = JsonMissing.of()
            private var score: JsonField<Double> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                attributes = result.attributes
                fileId = result.fileId
                filename = result.filename
                score = result.score
                text = result.text
                additionalProperties = result.additionalProperties.toMutableMap()
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard. Keys are strings with a maximum length of 64
             * characters. Values are strings with a maximum length of 512 characters, booleans, or
             * numbers.
             */
            fun attributes(attributes: Attributes?) = attributes(JsonField.ofNullable(attributes))

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard. Keys are strings with a maximum length of 64
             * characters. Values are strings with a maximum length of 512 characters, booleans, or
             * numbers.
             */
            fun attributes(attributes: Optional<Attributes>) = attributes(attributes.getOrNull())

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard. Keys are strings with a maximum length of 64
             * characters. Values are strings with a maximum length of 512 characters, booleans, or
             * numbers.
             */
            fun attributes(attributes: JsonField<Attributes>) = apply {
                this.attributes = attributes
            }

            /** The unique ID of the file. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /** The unique ID of the file. */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

            /** The name of the file. */
            fun filename(filename: String) = filename(JsonField.of(filename))

            /** The name of the file. */
            fun filename(filename: JsonField<String>) = apply { this.filename = filename }

            /** The relevance score of the file - a value between 0 and 1. */
            fun score(score: Double) = score(JsonField.of(score))

            /** The relevance score of the file - a value between 0 and 1. */
            fun score(score: JsonField<Double>) = apply { this.score = score }

            /** The text that was retrieved from the file. */
            fun text(text: String) = text(JsonField.of(text))

            /** The text that was retrieved from the file. */
            fun text(text: JsonField<String>) = apply { this.text = text }

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

            fun build(): Result =
                Result(
                    attributes,
                    fileId,
                    filename,
                    score,
                    text,
                    additionalProperties.toImmutable(),
                )
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard. Keys are strings with a maximum length of 64
         * characters. Values are strings with a maximum length of 512 characters, booleans, or
         * numbers.
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Result && attributes == other.attributes && fileId == other.fileId && filename == other.filename && score == other.score && text == other.text && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(attributes, fileId, filename, score, text, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Result{attributes=$attributes, fileId=$fileId, filename=$filename, score=$score, text=$text, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseFileSearchToolCall && id == other.id && queries == other.queries && status == other.status && type == other.type && results == other.results && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, queries, status, type, results, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFileSearchToolCall{id=$id, queries=$queries, status=$status, type=$type, results=$results, additionalProperties=$additionalProperties}"
}
