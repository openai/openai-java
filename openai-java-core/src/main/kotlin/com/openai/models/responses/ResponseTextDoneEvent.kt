// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/** Emitted when text content is finalized. */
class ResponseTextDoneEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val contentIndex: JsonField<Long>,
    private val itemId: JsonField<String>,
    private val logprobs: JsonField<List<Logprob>>,
    private val outputIndex: JsonField<Long>,
    private val sequenceNumber: JsonField<Long>,
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("content_index")
        @ExcludeMissing
        contentIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("logprobs")
        @ExcludeMissing
        logprobs: JsonField<List<Logprob>> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(
        contentIndex,
        itemId,
        logprobs,
        outputIndex,
        sequenceNumber,
        text,
        type,
        mutableMapOf(),
    )

    /**
     * The index of the content part that the text content is finalized.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /**
     * The ID of the output item that the text content is finalized.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The log probabilities of the tokens in the delta.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun logprobs(): List<Logprob> = logprobs.getRequired("logprobs")

    /**
     * The index of the output item that the text content is finalized.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The sequence number for this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The text content that is finalized.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * The type of the event. Always `response.output_text.done`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.output_text.done")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [contentIndex].
     *
     * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /**
     * Returns the raw JSON value of [itemId].
     *
     * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /**
     * Returns the raw JSON value of [logprobs].
     *
     * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<List<Logprob>> = logprobs

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

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
         * Returns a mutable builder for constructing an instance of [ResponseTextDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .itemId()
         * .logprobs()
         * .outputIndex()
         * .sequenceNumber()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseTextDoneEvent]. */
    class Builder internal constructor() {

        private var contentIndex: JsonField<Long>? = null
        private var itemId: JsonField<String>? = null
        private var logprobs: JsonField<MutableList<Logprob>>? = null
        private var outputIndex: JsonField<Long>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.output_text.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseTextDoneEvent: ResponseTextDoneEvent) = apply {
            contentIndex = responseTextDoneEvent.contentIndex
            itemId = responseTextDoneEvent.itemId
            logprobs = responseTextDoneEvent.logprobs.map { it.toMutableList() }
            outputIndex = responseTextDoneEvent.outputIndex
            sequenceNumber = responseTextDoneEvent.sequenceNumber
            text = responseTextDoneEvent.text
            type = responseTextDoneEvent.type
            additionalProperties = responseTextDoneEvent.additionalProperties.toMutableMap()
        }

        /** The index of the content part that the text content is finalized. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /**
         * Sets [Builder.contentIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The ID of the output item that the text content is finalized. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The log probabilities of the tokens in the delta. */
        fun logprobs(logprobs: List<Logprob>) = logprobs(JsonField.of(logprobs))

        /**
         * Sets [Builder.logprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprobs] with a well-typed `List<Logprob>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun logprobs(logprobs: JsonField<List<Logprob>>) = apply {
            this.logprobs = logprobs.map { it.toMutableList() }
        }

        /**
         * Adds a single [Logprob] to [logprobs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLogprob(logprob: Logprob) = apply {
            logprobs =
                (logprobs ?: JsonField.of(mutableListOf())).also {
                    checkKnown("logprobs", it).add(logprob)
                }
        }

        /** The index of the output item that the text content is finalized. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The sequence number for this event. */
        fun sequenceNumber(sequenceNumber: Long) = sequenceNumber(JsonField.of(sequenceNumber))

        /**
         * Sets [Builder.sequenceNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sequenceNumber] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sequenceNumber(sequenceNumber: JsonField<Long>) = apply {
            this.sequenceNumber = sequenceNumber
        }

        /** The text content that is finalized. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.output_text.done")
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
         * Returns an immutable instance of [ResponseTextDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .itemId()
         * .logprobs()
         * .outputIndex()
         * .sequenceNumber()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseTextDoneEvent =
            ResponseTextDoneEvent(
                checkRequired("contentIndex", contentIndex),
                checkRequired("itemId", itemId),
                checkRequired("logprobs", logprobs).map { it.toImmutable() },
                checkRequired("outputIndex", outputIndex),
                checkRequired("sequenceNumber", sequenceNumber),
                checkRequired("text", text),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseTextDoneEvent = apply {
        if (validated) {
            return@apply
        }

        contentIndex()
        itemId()
        logprobs().forEach { it.validate() }
        outputIndex()
        sequenceNumber()
        text()
        _type().let {
            if (it != JsonValue.from("response.output_text.done")) {
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
        (if (contentIndex.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            (logprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.output_text.done")) 1 else 0 }

    /**
     * A logprob is the logarithmic probability that the model assigns to producing a particular
     * token at a given position in the sequence. Less-negative (higher) logprob values indicate
     * greater model confidence in that token choice.
     */
    class Logprob
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val token: JsonField<String>,
        private val logprob: JsonField<Double>,
        private val topLogprobs: JsonField<List<TopLogprob>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logprob") @ExcludeMissing logprob: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("top_logprobs")
            @ExcludeMissing
            topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of(),
        ) : this(token, logprob, topLogprobs, mutableMapOf())

        /**
         * A possible text token.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun token(): String = token.getRequired("token")

        /**
         * The log probability of this token.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun logprob(): Double = logprob.getRequired("logprob")

        /**
         * The log probability of the top 20 most likely tokens.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topLogprobs(): Optional<List<TopLogprob>> = topLogprobs.getOptional("top_logprobs")

        /**
         * Returns the raw JSON value of [token].
         *
         * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

        /**
         * Returns the raw JSON value of [logprob].
         *
         * Unlike [logprob], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logprob") @ExcludeMissing fun _logprob(): JsonField<Double> = logprob

        /**
         * Returns the raw JSON value of [topLogprobs].
         *
         * Unlike [topLogprobs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_logprobs")
        @ExcludeMissing
        fun _topLogprobs(): JsonField<List<TopLogprob>> = topLogprobs

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
             * Returns a mutable builder for constructing an instance of [Logprob].
             *
             * The following fields are required:
             * ```java
             * .token()
             * .logprob()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Logprob]. */
        class Builder internal constructor() {

            private var token: JsonField<String>? = null
            private var logprob: JsonField<Double>? = null
            private var topLogprobs: JsonField<MutableList<TopLogprob>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logprob: Logprob) = apply {
                token = logprob.token
                this.logprob = logprob.logprob
                topLogprobs = logprob.topLogprobs.map { it.toMutableList() }
                additionalProperties = logprob.additionalProperties.toMutableMap()
            }

            /** A possible text token. */
            fun token(token: String) = token(JsonField.of(token))

            /**
             * Sets [Builder.token] to an arbitrary JSON value.
             *
             * You should usually call [Builder.token] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun token(token: JsonField<String>) = apply { this.token = token }

            /** The log probability of this token. */
            fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

            /**
             * Sets [Builder.logprob] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logprob] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

            /** The log probability of the top 20 most likely tokens. */
            fun topLogprobs(topLogprobs: List<TopLogprob>) = topLogprobs(JsonField.of(topLogprobs))

            /**
             * Sets [Builder.topLogprobs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topLogprobs] with a well-typed `List<TopLogprob>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun topLogprobs(topLogprobs: JsonField<List<TopLogprob>>) = apply {
                this.topLogprobs = topLogprobs.map { it.toMutableList() }
            }

            /**
             * Adds a single [TopLogprob] to [topLogprobs].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTopLogprob(topLogprob: TopLogprob) = apply {
                topLogprobs =
                    (topLogprobs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("topLogprobs", it).add(topLogprob)
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

            /**
             * Returns an immutable instance of [Logprob].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .token()
             * .logprob()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Logprob =
                Logprob(
                    checkRequired("token", token),
                    checkRequired("logprob", logprob),
                    (topLogprobs ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Logprob = apply {
            if (validated) {
                return@apply
            }

            token()
            logprob()
            topLogprobs().ifPresent { it.forEach { it.validate() } }
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
            (if (token.asKnown().isPresent) 1 else 0) +
                (if (logprob.asKnown().isPresent) 1 else 0) +
                (topLogprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class TopLogprob
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val token: JsonField<String>,
            private val logprob: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
                @JsonProperty("logprob")
                @ExcludeMissing
                logprob: JsonField<Double> = JsonMissing.of(),
            ) : this(token, logprob, mutableMapOf())

            /**
             * A possible text token.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun token(): Optional<String> = token.getOptional("token")

            /**
             * The log probability of this token.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun logprob(): Optional<Double> = logprob.getOptional("logprob")

            /**
             * Returns the raw JSON value of [token].
             *
             * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

            /**
             * Returns the raw JSON value of [logprob].
             *
             * Unlike [logprob], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("logprob") @ExcludeMissing fun _logprob(): JsonField<Double> = logprob

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

                /** Returns a mutable builder for constructing an instance of [TopLogprob]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TopLogprob]. */
            class Builder internal constructor() {

                private var token: JsonField<String> = JsonMissing.of()
                private var logprob: JsonField<Double> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(topLogprob: TopLogprob) = apply {
                    token = topLogprob.token
                    logprob = topLogprob.logprob
                    additionalProperties = topLogprob.additionalProperties.toMutableMap()
                }

                /** A possible text token. */
                fun token(token: String) = token(JsonField.of(token))

                /**
                 * Sets [Builder.token] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.token] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun token(token: JsonField<String>) = apply { this.token = token }

                /** The log probability of this token. */
                fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

                /**
                 * Sets [Builder.logprob] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.logprob] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

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
                 * Returns an immutable instance of [TopLogprob].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): TopLogprob =
                    TopLogprob(token, logprob, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): TopLogprob = apply {
                if (validated) {
                    return@apply
                }

                token()
                logprob()
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
                (if (token.asKnown().isPresent) 1 else 0) +
                    (if (logprob.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is TopLogprob &&
                    token == other.token &&
                    logprob == other.logprob &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(token, logprob, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TopLogprob{token=$token, logprob=$logprob, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Logprob &&
                token == other.token &&
                logprob == other.logprob &&
                topLogprobs == other.topLogprobs &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(token, logprob, topLogprobs, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Logprob{token=$token, logprob=$logprob, topLogprobs=$topLogprobs, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseTextDoneEvent &&
            contentIndex == other.contentIndex &&
            itemId == other.itemId &&
            logprobs == other.logprobs &&
            outputIndex == other.outputIndex &&
            sequenceNumber == other.sequenceNumber &&
            text == other.text &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            contentIndex,
            itemId,
            logprobs,
            outputIndex,
            sequenceNumber,
            text,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseTextDoneEvent{contentIndex=$contentIndex, itemId=$itemId, logprobs=$logprobs, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, text=$text, type=$type, additionalProperties=$additionalProperties}"
}
