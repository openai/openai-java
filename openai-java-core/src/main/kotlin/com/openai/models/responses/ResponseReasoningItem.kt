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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A description of the chain of thought used by a reasoning model while generating a response. */
class ResponseReasoningItem
private constructor(
    private val id: JsonField<String>,
    private val summary: JsonField<List<Summary>>,
    private val type: JsonValue,
    private val status: JsonField<Status>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("summary")
        @ExcludeMissing
        summary: JsonField<List<Summary>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(id, summary, type, status, mutableMapOf())

    /**
     * The unique identifier of the reasoning content.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Reasoning text contents.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun summary(): List<Summary> = summary.getRequired("summary")

    /**
     * The type of the object. Always `reasoning`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("reasoning")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated when
     * items are returned via API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [summary].
     *
     * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<List<Summary>> = summary

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
         * Returns a mutable builder for constructing an instance of [ResponseReasoningItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .summary()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseReasoningItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var summary: JsonField<MutableList<Summary>>? = null
        private var type: JsonValue = JsonValue.from("reasoning")
        private var status: JsonField<Status> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseReasoningItem: ResponseReasoningItem) = apply {
            id = responseReasoningItem.id
            summary = responseReasoningItem.summary.map { it.toMutableList() }
            type = responseReasoningItem.type
            status = responseReasoningItem.status
            additionalProperties = responseReasoningItem.additionalProperties.toMutableMap()
        }

        /** The unique identifier of the reasoning content. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Reasoning text contents. */
        fun summary(summary: List<Summary>) = summary(JsonField.of(summary))

        /**
         * Sets [Builder.summary] to an arbitrary JSON value.
         *
         * You should usually call [Builder.summary] with a well-typed `List<Summary>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun summary(summary: JsonField<List<Summary>>) = apply {
            this.summary = summary.map { it.toMutableList() }
        }

        /**
         * Adds a single [Summary] to [Builder.summary].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSummary(summary: Summary) = apply {
            this.summary =
                (this.summary ?: JsonField.of(mutableListOf())).also {
                    checkKnown("summary", it).add(summary)
                }
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("reasoning")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
         * when items are returned via API.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [ResponseReasoningItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .summary()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseReasoningItem =
            ResponseReasoningItem(
                checkRequired("id", id),
                checkRequired("summary", summary).map { it.toImmutable() },
                type,
                status,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseReasoningItem = apply {
        if (validated) {
            return@apply
        }

        id()
        summary().forEach { it.validate() }
        _type().let {
            if (it != JsonValue.from("reasoning")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (summary.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            type.let { if (it == JsonValue.from("reasoning")) 1 else 0 } +
            (status.asKnown().getOrNull()?.validity() ?: 0)

    class Summary
    private constructor(
        private val text: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(text, type, mutableMapOf())

        /**
         * A short summary of the reasoning used by the model when generating the response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * The type of the object. Always `summary_text`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("summary_text")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
             * Returns a mutable builder for constructing an instance of [Summary].
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Summary]. */
        class Builder internal constructor() {

            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("summary_text")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(summary: Summary) = apply {
                text = summary.text
                type = summary.type
                additionalProperties = summary.additionalProperties.toMutableMap()
            }

            /** A short summary of the reasoning used by the model when generating the response. */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("summary_text")
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
             * Returns an immutable instance of [Summary].
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
            fun build(): Summary =
                Summary(checkRequired("text", text), type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Summary = apply {
            if (validated) {
                return@apply
            }

            text()
            _type().let {
                if (it != JsonValue.from("summary_text")) {
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
            (if (text.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("summary_text")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Summary && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Summary{text=$text, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated when
     * items are returned via API.
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

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseReasoningItem && id == other.id && summary == other.summary && type == other.type && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, summary, type, status, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseReasoningItem{id=$id, summary=$summary, type=$type, status=$status, additionalProperties=$additionalProperties}"
}
