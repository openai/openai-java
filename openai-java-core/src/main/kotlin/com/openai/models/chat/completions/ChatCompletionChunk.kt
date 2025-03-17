// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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
import com.openai.models.completions.CompletionUsage
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents a streamed chunk of a chat completion response returned by the model, based on the
 * provided input. [Learn more](https://platform.openai.com/docs/guides/streaming-responses).
 */
@NoAutoDetect
class ChatCompletionChunk
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("choices")
    @ExcludeMissing
    private val choices: JsonField<List<Choice>> = JsonMissing.of(),
    @JsonProperty("created")
    @ExcludeMissing
    private val created: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("service_tier")
    @ExcludeMissing
    private val serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
    @JsonProperty("system_fingerprint")
    @ExcludeMissing
    private val systemFingerprint: JsonField<String> = JsonMissing.of(),
    @JsonProperty("usage")
    @ExcludeMissing
    private val usage: JsonField<CompletionUsage> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * A unique identifier for the chat completion. Each chunk has the same ID.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * A list of chat completion choices. Can contain more than one elements if `n` is greater
     * than 1. Can also be empty for the last chunk if you set `stream_options: {"include_usage":
     * true}`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun choices(): List<Choice> = choices.getRequired("choices")

    /**
     * The Unix timestamp (in seconds) of when the chat completion was created. Each chunk has the
     * same timestamp.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun created(): Long = created.getRequired("created")

    /**
     * The model to generate the completion.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The object type, which is always `chat.completion.chunk`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("chat.completion.chunk")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The service tier used for processing the request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serviceTier(): Optional<ServiceTier> =
        Optional.ofNullable(serviceTier.getNullable("service_tier"))

    /**
     * This fingerprint represents the backend configuration that the model runs with. Can be used
     * in conjunction with the `seed` request parameter to understand when backend changes have been
     * made that might impact determinism.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun systemFingerprint(): Optional<String> =
        Optional.ofNullable(systemFingerprint.getNullable("system_fingerprint"))

    /**
     * An optional field that will only be present when you set `stream_options: {"include_usage":
     * true}` in your request. When present, it contains a null value except for the last chunk
     * which contains the token usage statistics for the entire request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<CompletionUsage> = Optional.ofNullable(usage.getNullable("usage"))

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [choices].
     *
     * Unlike [choices], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("choices") @ExcludeMissing fun _choices(): JsonField<List<Choice>> = choices

    /**
     * Returns the raw JSON value of [created].
     *
     * Unlike [created], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<Long> = created

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [serviceTier].
     *
     * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("service_tier")
    @ExcludeMissing
    fun _serviceTier(): JsonField<ServiceTier> = serviceTier

    /**
     * Returns the raw JSON value of [systemFingerprint].
     *
     * Unlike [systemFingerprint], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("system_fingerprint")
    @ExcludeMissing
    fun _systemFingerprint(): JsonField<String> = systemFingerprint

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<CompletionUsage> = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionChunk = apply {
        if (validated) {
            return@apply
        }

        id()
        choices().forEach { it.validate() }
        created()
        model()
        _object_().let {
            if (it != JsonValue.from("chat.completion.chunk")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        serviceTier()
        systemFingerprint()
        usage().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ChatCompletionChunk].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .choices()
         * .created()
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionChunk]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var choices: JsonField<MutableList<Choice>>? = null
        private var created: JsonField<Long>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("chat.completion.chunk")
        private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
        private var systemFingerprint: JsonField<String> = JsonMissing.of()
        private var usage: JsonField<CompletionUsage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionChunk: ChatCompletionChunk) = apply {
            id = chatCompletionChunk.id
            choices = chatCompletionChunk.choices.map { it.toMutableList() }
            created = chatCompletionChunk.created
            model = chatCompletionChunk.model
            object_ = chatCompletionChunk.object_
            serviceTier = chatCompletionChunk.serviceTier
            systemFingerprint = chatCompletionChunk.systemFingerprint
            usage = chatCompletionChunk.usage
            additionalProperties = chatCompletionChunk.additionalProperties.toMutableMap()
        }

        /** A unique identifier for the chat completion. Each chunk has the same ID. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * A list of chat completion choices. Can contain more than one elements if `n` is greater
         * than 1. Can also be empty for the last chunk if you set `stream_options:
         * {"include_usage": true}`.
         */
        fun choices(choices: List<Choice>) = choices(JsonField.of(choices))

        /**
         * Sets [Builder.choices] to an arbitrary JSON value.
         *
         * You should usually call [Builder.choices] with a well-typed `List<Choice>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun choices(choices: JsonField<List<Choice>>) = apply {
            this.choices = choices.map { it.toMutableList() }
        }

        /**
         * Adds a single [Choice] to [choices].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addChoice(choice: Choice) = apply {
            choices =
                (choices ?: JsonField.of(mutableListOf())).also {
                    checkKnown("choices", it).add(choice)
                }
        }

        /**
         * The Unix timestamp (in seconds) of when the chat completion was created. Each chunk has
         * the same timestamp.
         */
        fun created(created: Long) = created(JsonField.of(created))

        /**
         * Sets [Builder.created] to an arbitrary JSON value.
         *
         * You should usually call [Builder.created] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The model to generate the completion. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("chat.completion.chunk")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The service tier used for processing the request. */
        fun serviceTier(serviceTier: ServiceTier?) = serviceTier(JsonField.ofNullable(serviceTier))

        /** Alias for calling [Builder.serviceTier] with `serviceTier.orElse(null)`. */
        fun serviceTier(serviceTier: Optional<ServiceTier>) = serviceTier(serviceTier.getOrNull())

        /**
         * Sets [Builder.serviceTier] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serviceTier] with a well-typed [ServiceTier] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun serviceTier(serviceTier: JsonField<ServiceTier>) = apply {
            this.serviceTier = serviceTier
        }

        /**
         * This fingerprint represents the backend configuration that the model runs with. Can be
         * used in conjunction with the `seed` request parameter to understand when backend changes
         * have been made that might impact determinism.
         */
        fun systemFingerprint(systemFingerprint: String) =
            systemFingerprint(JsonField.of(systemFingerprint))

        /**
         * Sets [Builder.systemFingerprint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.systemFingerprint] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
            this.systemFingerprint = systemFingerprint
        }

        /**
         * An optional field that will only be present when you set `stream_options:
         * {"include_usage": true}` in your request. When present, it contains a null value except
         * for the last chunk which contains the token usage statistics for the entire request.
         */
        fun usage(usage: CompletionUsage?) = usage(JsonField.ofNullable(usage))

        /** Alias for calling [Builder.usage] with `usage.orElse(null)`. */
        fun usage(usage: Optional<CompletionUsage>) = usage(usage.getOrNull())

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [CompletionUsage] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun usage(usage: JsonField<CompletionUsage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [ChatCompletionChunk].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .choices()
         * .created()
         * .model()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatCompletionChunk =
            ChatCompletionChunk(
                checkRequired("id", id),
                checkRequired("choices", choices).map { it.toImmutable() },
                checkRequired("created", created),
                checkRequired("model", model),
                object_,
                serviceTier,
                systemFingerprint,
                usage,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class Choice
    @JsonCreator
    private constructor(
        @JsonProperty("delta")
        @ExcludeMissing
        private val delta: JsonField<Delta> = JsonMissing.of(),
        @JsonProperty("finish_reason")
        @ExcludeMissing
        private val finishReason: JsonField<FinishReason> = JsonMissing.of(),
        @JsonProperty("index")
        @ExcludeMissing
        private val index: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("logprobs")
        @ExcludeMissing
        private val logprobs: JsonField<Logprobs> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A chat completion delta generated by streamed model responses.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): Delta = delta.getRequired("delta")

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun finishReason(): Optional<FinishReason> =
            Optional.ofNullable(finishReason.getNullable("finish_reason"))

        /**
         * The index of the choice in the list of choices.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun index(): Long = index.getRequired("index")

        /**
         * Log probability information for the choice.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun logprobs(): Optional<Logprobs> = Optional.ofNullable(logprobs.getNullable("logprobs"))

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<Delta> = delta

        /**
         * Returns the raw JSON value of [finishReason].
         *
         * Unlike [finishReason], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("finish_reason")
        @ExcludeMissing
        fun _finishReason(): JsonField<FinishReason> = finishReason

        /**
         * Returns the raw JSON value of [index].
         *
         * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

        /**
         * Returns the raw JSON value of [logprobs].
         *
         * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<Logprobs> = logprobs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Choice = apply {
            if (validated) {
                return@apply
            }

            delta().validate()
            finishReason()
            index()
            logprobs().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Choice].
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .finishReason()
             * .index()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Choice]. */
        class Builder internal constructor() {

            private var delta: JsonField<Delta>? = null
            private var finishReason: JsonField<FinishReason>? = null
            private var index: JsonField<Long>? = null
            private var logprobs: JsonField<Logprobs> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(choice: Choice) = apply {
                delta = choice.delta
                finishReason = choice.finishReason
                index = choice.index
                logprobs = choice.logprobs
                additionalProperties = choice.additionalProperties.toMutableMap()
            }

            /** A chat completion delta generated by streamed model responses. */
            fun delta(delta: Delta) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [Delta] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun delta(delta: JsonField<Delta>) = apply { this.delta = delta }

            /**
             * The reason the model stopped generating tokens. This will be `stop` if the model hit
             * a natural stop point or a provided stop sequence, `length` if the maximum number of
             * tokens specified in the request was reached, `content_filter` if content was omitted
             * due to a flag from our content filters, `tool_calls` if the model called a tool, or
             * `function_call` (deprecated) if the model called a function.
             */
            fun finishReason(finishReason: FinishReason?) =
                finishReason(JsonField.ofNullable(finishReason))

            /** Alias for calling [Builder.finishReason] with `finishReason.orElse(null)`. */
            fun finishReason(finishReason: Optional<FinishReason>) =
                finishReason(finishReason.getOrNull())

            /**
             * Sets [Builder.finishReason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.finishReason] with a well-typed [FinishReason] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun finishReason(finishReason: JsonField<FinishReason>) = apply {
                this.finishReason = finishReason
            }

            /** The index of the choice in the list of choices. */
            fun index(index: Long) = index(JsonField.of(index))

            /**
             * Sets [Builder.index] to an arbitrary JSON value.
             *
             * You should usually call [Builder.index] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun index(index: JsonField<Long>) = apply { this.index = index }

            /** Log probability information for the choice. */
            fun logprobs(logprobs: Logprobs?) = logprobs(JsonField.ofNullable(logprobs))

            /** Alias for calling [Builder.logprobs] with `logprobs.orElse(null)`. */
            fun logprobs(logprobs: Optional<Logprobs>) = logprobs(logprobs.getOrNull())

            /**
             * Sets [Builder.logprobs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logprobs] with a well-typed [Logprobs] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logprobs(logprobs: JsonField<Logprobs>) = apply { this.logprobs = logprobs }

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
             * Returns an immutable instance of [Choice].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .finishReason()
             * .index()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Choice =
                Choice(
                    checkRequired("delta", delta),
                    checkRequired("finishReason", finishReason),
                    checkRequired("index", index),
                    logprobs,
                    additionalProperties.toImmutable(),
                )
        }

        /** A chat completion delta generated by streamed model responses. */
        @NoAutoDetect
        class Delta
        @JsonCreator
        private constructor(
            @JsonProperty("content")
            @ExcludeMissing
            private val content: JsonField<String> = JsonMissing.of(),
            @JsonProperty("function_call")
            @ExcludeMissing
            private val functionCall: JsonField<FunctionCall> = JsonMissing.of(),
            @JsonProperty("refusal")
            @ExcludeMissing
            private val refusal: JsonField<String> = JsonMissing.of(),
            @JsonProperty("role")
            @ExcludeMissing
            private val role: JsonField<Role> = JsonMissing.of(),
            @JsonProperty("tool_calls")
            @ExcludeMissing
            private val toolCalls: JsonField<List<ToolCall>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The contents of the chunk message.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

            /**
             * Deprecated and replaced by `tool_calls`. The name and arguments of a function that
             * should be called, as generated by the model.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            @Deprecated("deprecated")
            fun functionCall(): Optional<FunctionCall> =
                Optional.ofNullable(functionCall.getNullable("function_call"))

            /**
             * The refusal message generated by the model.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun refusal(): Optional<String> = Optional.ofNullable(refusal.getNullable("refusal"))

            /**
             * The role of the author of this message.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<Role> = Optional.ofNullable(role.getNullable("role"))

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun toolCalls(): Optional<List<ToolCall>> =
                Optional.ofNullable(toolCalls.getNullable("tool_calls"))

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

            /**
             * Returns the raw JSON value of [functionCall].
             *
             * Unlike [functionCall], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @Deprecated("deprecated")
            @JsonProperty("function_call")
            @ExcludeMissing
            fun _functionCall(): JsonField<FunctionCall> = functionCall

            /**
             * Returns the raw JSON value of [refusal].
             *
             * Unlike [refusal], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("refusal") @ExcludeMissing fun _refusal(): JsonField<String> = refusal

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

            /**
             * Returns the raw JSON value of [toolCalls].
             *
             * Unlike [toolCalls], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("tool_calls")
            @ExcludeMissing
            fun _toolCalls(): JsonField<List<ToolCall>> = toolCalls

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Delta = apply {
                if (validated) {
                    return@apply
                }

                content()
                functionCall().ifPresent { it.validate() }
                refusal()
                role()
                toolCalls().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Delta]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Delta]. */
            class Builder internal constructor() {

                private var content: JsonField<String> = JsonMissing.of()
                private var functionCall: JsonField<FunctionCall> = JsonMissing.of()
                private var refusal: JsonField<String> = JsonMissing.of()
                private var role: JsonField<Role> = JsonMissing.of()
                private var toolCalls: JsonField<MutableList<ToolCall>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(delta: Delta) = apply {
                    content = delta.content
                    functionCall = delta.functionCall
                    refusal = delta.refusal
                    role = delta.role
                    toolCalls = delta.toolCalls.map { it.toMutableList() }
                    additionalProperties = delta.additionalProperties.toMutableMap()
                }

                /** The contents of the chunk message. */
                fun content(content: String?) = content(JsonField.ofNullable(content))

                /** Alias for calling [Builder.content] with `content.orElse(null)`. */
                fun content(content: Optional<String>) = content(content.getOrNull())

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun content(content: JsonField<String>) = apply { this.content = content }

                /**
                 * Deprecated and replaced by `tool_calls`. The name and arguments of a function
                 * that should be called, as generated by the model.
                 */
                @Deprecated("deprecated")
                fun functionCall(functionCall: FunctionCall) =
                    functionCall(JsonField.of(functionCall))

                /**
                 * Sets [Builder.functionCall] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.functionCall] with a well-typed [FunctionCall]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                @Deprecated("deprecated")
                fun functionCall(functionCall: JsonField<FunctionCall>) = apply {
                    this.functionCall = functionCall
                }

                /** The refusal message generated by the model. */
                fun refusal(refusal: String?) = refusal(JsonField.ofNullable(refusal))

                /** Alias for calling [Builder.refusal] with `refusal.orElse(null)`. */
                fun refusal(refusal: Optional<String>) = refusal(refusal.getOrNull())

                /**
                 * Sets [Builder.refusal] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.refusal] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

                /** The role of the author of this message. */
                fun role(role: Role) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [Role] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<Role>) = apply { this.role = role }

                fun toolCalls(toolCalls: List<ToolCall>) = toolCalls(JsonField.of(toolCalls))

                /**
                 * Sets [Builder.toolCalls] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.toolCalls] with a well-typed `List<ToolCall>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun toolCalls(toolCalls: JsonField<List<ToolCall>>) = apply {
                    this.toolCalls = toolCalls.map { it.toMutableList() }
                }

                /**
                 * Adds a single [ToolCall] to [toolCalls].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addToolCall(toolCall: ToolCall) = apply {
                    toolCalls =
                        (toolCalls ?: JsonField.of(mutableListOf())).also {
                            checkKnown("toolCalls", it).add(toolCall)
                        }
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

                /**
                 * Returns an immutable instance of [Delta].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Delta =
                    Delta(
                        content,
                        functionCall,
                        refusal,
                        role,
                        (toolCalls ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            /**
             * Deprecated and replaced by `tool_calls`. The name and arguments of a function that
             * should be called, as generated by the model.
             */
            @Deprecated("deprecated")
            @NoAutoDetect
            class FunctionCall
            @JsonCreator
            private constructor(
                @JsonProperty("arguments")
                @ExcludeMissing
                private val arguments: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name")
                @ExcludeMissing
                private val name: JsonField<String> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * The arguments to call the function with, as generated by the model in JSON
                 * format. Note that the model does not always generate valid JSON, and may
                 * hallucinate parameters not defined by your function schema. Validate the
                 * arguments in your code before calling your function.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun arguments(): Optional<String> =
                    Optional.ofNullable(arguments.getNullable("arguments"))

                /**
                 * The name of the function to call.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

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
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): FunctionCall = apply {
                    if (validated) {
                        return@apply
                    }

                    arguments()
                    name()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [FunctionCall]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [FunctionCall]. */
                class Builder internal constructor() {

                    private var arguments: JsonField<String> = JsonMissing.of()
                    private var name: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(functionCall: FunctionCall) = apply {
                        arguments = functionCall.arguments
                        name = functionCall.name
                        additionalProperties = functionCall.additionalProperties.toMutableMap()
                    }

                    /**
                     * The arguments to call the function with, as generated by the model in JSON
                     * format. Note that the model does not always generate valid JSON, and may
                     * hallucinate parameters not defined by your function schema. Validate the
                     * arguments in your code before calling your function.
                     */
                    fun arguments(arguments: String) = arguments(JsonField.of(arguments))

                    /**
                     * Sets [Builder.arguments] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.arguments] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun arguments(arguments: JsonField<String>) = apply {
                        this.arguments = arguments
                    }

                    /** The name of the function to call. */
                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

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
                     */
                    fun build(): FunctionCall =
                        FunctionCall(arguments, name, additionalProperties.toImmutable())
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is FunctionCall && arguments == other.arguments && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(arguments, name, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "FunctionCall{arguments=$arguments, name=$name, additionalProperties=$additionalProperties}"
            }

            /** The role of the author of this message. */
            class Role @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val DEVELOPER = of("developer")

                    @JvmField val SYSTEM = of("system")

                    @JvmField val USER = of("user")

                    @JvmField val ASSISTANT = of("assistant")

                    @JvmField val TOOL = of("tool")

                    @JvmStatic fun of(value: String) = Role(JsonField.of(value))
                }

                /** An enum containing [Role]'s known values. */
                enum class Known {
                    DEVELOPER,
                    SYSTEM,
                    USER,
                    ASSISTANT,
                    TOOL,
                }

                /**
                 * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Role] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    DEVELOPER,
                    SYSTEM,
                    USER,
                    ASSISTANT,
                    TOOL,
                    /**
                     * An enum member indicating that [Role] was instantiated with an unknown value.
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
                        DEVELOPER -> Value.DEVELOPER
                        SYSTEM -> Value.SYSTEM
                        USER -> Value.USER
                        ASSISTANT -> Value.ASSISTANT
                        TOOL -> Value.TOOL
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
                        DEVELOPER -> Known.DEVELOPER
                        SYSTEM -> Known.SYSTEM
                        USER -> Known.USER
                        ASSISTANT -> Known.ASSISTANT
                        TOOL -> Known.TOOL
                        else -> throw OpenAIInvalidDataException("Unknown Role: $value")
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

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Role && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            @NoAutoDetect
            class ToolCall
            @JsonCreator
            private constructor(
                @JsonProperty("index")
                @ExcludeMissing
                private val index: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("id")
                @ExcludeMissing
                private val id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("function")
                @ExcludeMissing
                private val function: JsonField<Function> = JsonMissing.of(),
                @JsonProperty("type")
                @ExcludeMissing
                private val type: JsonField<Type> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun index(): Long = index.getRequired("index")

                /**
                 * The ID of the tool call.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun function(): Optional<Function> =
                    Optional.ofNullable(function.getNullable("function"))

                /**
                 * The type of the tool. Currently, only `function` is supported.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<Type> = Optional.ofNullable(type.getNullable("type"))

                /**
                 * Returns the raw JSON value of [index].
                 *
                 * Unlike [index], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [function].
                 *
                 * Unlike [function], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("function")
                @ExcludeMissing
                fun _function(): JsonField<Function> = function

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): ToolCall = apply {
                    if (validated) {
                        return@apply
                    }

                    index()
                    id()
                    function().ifPresent { it.validate() }
                    type()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [ToolCall].
                     *
                     * The following fields are required:
                     * ```java
                     * .index()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ToolCall]. */
                class Builder internal constructor() {

                    private var index: JsonField<Long>? = null
                    private var id: JsonField<String> = JsonMissing.of()
                    private var function: JsonField<Function> = JsonMissing.of()
                    private var type: JsonField<Type> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(toolCall: ToolCall) = apply {
                        index = toolCall.index
                        id = toolCall.id
                        function = toolCall.function
                        type = toolCall.type
                        additionalProperties = toolCall.additionalProperties.toMutableMap()
                    }

                    fun index(index: Long) = index(JsonField.of(index))

                    /**
                     * Sets [Builder.index] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.index] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun index(index: JsonField<Long>) = apply { this.index = index }

                    /** The ID of the tool call. */
                    fun id(id: String) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    fun function(function: Function) = function(JsonField.of(function))

                    /**
                     * Sets [Builder.function] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.function] with a well-typed [Function] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun function(function: JsonField<Function>) = apply { this.function = function }

                    /** The type of the tool. Currently, only `function` is supported. */
                    fun type(type: Type) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

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
                     * Returns an immutable instance of [ToolCall].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .index()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ToolCall =
                        ToolCall(
                            checkRequired("index", index),
                            id,
                            function,
                            type,
                            additionalProperties.toImmutable(),
                        )
                }

                @NoAutoDetect
                class Function
                @JsonCreator
                private constructor(
                    @JsonProperty("arguments")
                    @ExcludeMissing
                    private val arguments: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    private val name: JsonField<String> = JsonMissing.of(),
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    /**
                     * The arguments to call the function with, as generated by the model in JSON
                     * format. Note that the model does not always generate valid JSON, and may
                     * hallucinate parameters not defined by your function schema. Validate the
                     * arguments in your code before calling your function.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun arguments(): Optional<String> =
                        Optional.ofNullable(arguments.getNullable("arguments"))

                    /**
                     * The name of the function to call.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

                    /**
                     * Returns the raw JSON value of [arguments].
                     *
                     * Unlike [arguments], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("arguments")
                    @ExcludeMissing
                    fun _arguments(): JsonField<String> = arguments

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    private var validated: Boolean = false

                    fun validate(): Function = apply {
                        if (validated) {
                            return@apply
                        }

                        arguments()
                        name()
                        validated = true
                    }

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /** Returns a mutable builder for constructing an instance of [Function]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Function]. */
                    class Builder internal constructor() {

                        private var arguments: JsonField<String> = JsonMissing.of()
                        private var name: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(function: Function) = apply {
                            arguments = function.arguments
                            name = function.name
                            additionalProperties = function.additionalProperties.toMutableMap()
                        }

                        /**
                         * The arguments to call the function with, as generated by the model in
                         * JSON format. Note that the model does not always generate valid JSON, and
                         * may hallucinate parameters not defined by your function schema. Validate
                         * the arguments in your code before calling your function.
                         */
                        fun arguments(arguments: String) = arguments(JsonField.of(arguments))

                        /**
                         * Sets [Builder.arguments] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.arguments] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun arguments(arguments: JsonField<String>) = apply {
                            this.arguments = arguments
                        }

                        /** The name of the function to call. */
                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

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
                         * Returns an immutable instance of [Function].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Function =
                            Function(arguments, name, additionalProperties.toImmutable())
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Function && arguments == other.arguments && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(arguments, name, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Function{arguments=$arguments, name=$name, additionalProperties=$additionalProperties}"
                }

                /** The type of the tool. Currently, only `function` is supported. */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val FUNCTION = of("function")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        FUNCTION
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        FUNCTION,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            FUNCTION -> Value.FUNCTION
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            FUNCTION -> Known.FUNCTION
                            else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
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

                    return /* spotless:off */ other is ToolCall && index == other.index && id == other.id && function == other.function && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(index, id, function, type, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ToolCall{index=$index, id=$id, function=$function, type=$type, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Delta && content == other.content && functionCall == other.functionCall && refusal == other.refusal && role == other.role && toolCalls == other.toolCalls && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, functionCall, refusal, role, toolCalls, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Delta{content=$content, functionCall=$functionCall, refusal=$refusal, role=$role, toolCalls=$toolCalls, additionalProperties=$additionalProperties}"
        }

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         */
        class FinishReason @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val STOP = of("stop")

                @JvmField val LENGTH = of("length")

                @JvmField val TOOL_CALLS = of("tool_calls")

                @JvmField val CONTENT_FILTER = of("content_filter")

                @JvmField val FUNCTION_CALL = of("function_call")

                @JvmStatic fun of(value: String) = FinishReason(JsonField.of(value))
            }

            /** An enum containing [FinishReason]'s known values. */
            enum class Known {
                STOP,
                LENGTH,
                TOOL_CALLS,
                CONTENT_FILTER,
                FUNCTION_CALL,
            }

            /**
             * An enum containing [FinishReason]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [FinishReason] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                STOP,
                LENGTH,
                TOOL_CALLS,
                CONTENT_FILTER,
                FUNCTION_CALL,
                /**
                 * An enum member indicating that [FinishReason] was instantiated with an unknown
                 * value.
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
                    STOP -> Value.STOP
                    LENGTH -> Value.LENGTH
                    TOOL_CALLS -> Value.TOOL_CALLS
                    CONTENT_FILTER -> Value.CONTENT_FILTER
                    FUNCTION_CALL -> Value.FUNCTION_CALL
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
                    STOP -> Known.STOP
                    LENGTH -> Known.LENGTH
                    TOOL_CALLS -> Known.TOOL_CALLS
                    CONTENT_FILTER -> Known.CONTENT_FILTER
                    FUNCTION_CALL -> Known.FUNCTION_CALL
                    else -> throw OpenAIInvalidDataException("Unknown FinishReason: $value")
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

                return /* spotless:off */ other is FinishReason && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Log probability information for the choice. */
        @NoAutoDetect
        class Logprobs
        @JsonCreator
        private constructor(
            @JsonProperty("content")
            @ExcludeMissing
            private val content: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of(),
            @JsonProperty("refusal")
            @ExcludeMissing
            private val refusal: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * A list of message content tokens with log probability information.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun content(): Optional<List<ChatCompletionTokenLogprob>> =
                Optional.ofNullable(content.getNullable("content"))

            /**
             * A list of message refusal tokens with log probability information.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun refusal(): Optional<List<ChatCompletionTokenLogprob>> =
                Optional.ofNullable(refusal.getNullable("refusal"))

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content")
            @ExcludeMissing
            fun _content(): JsonField<List<ChatCompletionTokenLogprob>> = content

            /**
             * Returns the raw JSON value of [refusal].
             *
             * Unlike [refusal], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("refusal")
            @ExcludeMissing
            fun _refusal(): JsonField<List<ChatCompletionTokenLogprob>> = refusal

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Logprobs = apply {
                if (validated) {
                    return@apply
                }

                content().ifPresent { it.forEach { it.validate() } }
                refusal().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Logprobs].
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * .refusal()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Logprobs]. */
            class Builder internal constructor() {

                private var content: JsonField<MutableList<ChatCompletionTokenLogprob>>? = null
                private var refusal: JsonField<MutableList<ChatCompletionTokenLogprob>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(logprobs: Logprobs) = apply {
                    content = logprobs.content.map { it.toMutableList() }
                    refusal = logprobs.refusal.map { it.toMutableList() }
                    additionalProperties = logprobs.additionalProperties.toMutableMap()
                }

                /** A list of message content tokens with log probability information. */
                fun content(content: List<ChatCompletionTokenLogprob>?) =
                    content(JsonField.ofNullable(content))

                /** Alias for calling [Builder.content] with `content.orElse(null)`. */
                fun content(content: Optional<List<ChatCompletionTokenLogprob>>) =
                    content(content.getOrNull())

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed
                 * `List<ChatCompletionTokenLogprob>` value instead. This method is primarily for
                 * setting the field to an undocumented or not yet supported value.
                 */
                fun content(content: JsonField<List<ChatCompletionTokenLogprob>>) = apply {
                    this.content = content.map { it.toMutableList() }
                }

                /**
                 * Adds a single [ChatCompletionTokenLogprob] to [Builder.content].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addContent(content: ChatCompletionTokenLogprob) = apply {
                    this.content =
                        (this.content ?: JsonField.of(mutableListOf())).also {
                            checkKnown("content", it).add(content)
                        }
                }

                /** A list of message refusal tokens with log probability information. */
                fun refusal(refusal: List<ChatCompletionTokenLogprob>?) =
                    refusal(JsonField.ofNullable(refusal))

                /** Alias for calling [Builder.refusal] with `refusal.orElse(null)`. */
                fun refusal(refusal: Optional<List<ChatCompletionTokenLogprob>>) =
                    refusal(refusal.getOrNull())

                /**
                 * Sets [Builder.refusal] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.refusal] with a well-typed
                 * `List<ChatCompletionTokenLogprob>` value instead. This method is primarily for
                 * setting the field to an undocumented or not yet supported value.
                 */
                fun refusal(refusal: JsonField<List<ChatCompletionTokenLogprob>>) = apply {
                    this.refusal = refusal.map { it.toMutableList() }
                }

                /**
                 * Adds a single [ChatCompletionTokenLogprob] to [Builder.refusal].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addRefusal(refusal: ChatCompletionTokenLogprob) = apply {
                    this.refusal =
                        (this.refusal ?: JsonField.of(mutableListOf())).also {
                            checkKnown("refusal", it).add(refusal)
                        }
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

                /**
                 * Returns an immutable instance of [Logprobs].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * .refusal()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Logprobs =
                    Logprobs(
                        checkRequired("content", content).map { it.toImmutable() },
                        checkRequired("refusal", refusal).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Logprobs && content == other.content && refusal == other.refusal && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, refusal, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Logprobs{content=$content, refusal=$refusal, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Choice && delta == other.delta && finishReason == other.finishReason && index == other.index && logprobs == other.logprobs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(delta, finishReason, index, logprobs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Choice{delta=$delta, finishReason=$finishReason, index=$index, logprobs=$logprobs, additionalProperties=$additionalProperties}"
    }

    /** The service tier used for processing the request. */
    class ServiceTier @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val SCALE = of("scale")

            @JvmField val DEFAULT = of("default")

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        /** An enum containing [ServiceTier]'s known values. */
        enum class Known {
            SCALE,
            DEFAULT,
        }

        /**
         * An enum containing [ServiceTier]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ServiceTier] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SCALE,
            DEFAULT,
            /**
             * An enum member indicating that [ServiceTier] was instantiated with an unknown value.
             */
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
                SCALE -> Value.SCALE
                DEFAULT -> Value.DEFAULT
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
                SCALE -> Known.SCALE
                DEFAULT -> Known.DEFAULT
                else -> throw OpenAIInvalidDataException("Unknown ServiceTier: $value")
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

            return /* spotless:off */ other is ServiceTier && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionChunk && id == other.id && choices == other.choices && created == other.created && model == other.model && object_ == other.object_ && serviceTier == other.serviceTier && systemFingerprint == other.systemFingerprint && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, choices, created, model, object_, serviceTier, systemFingerprint, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionChunk{id=$id, choices=$choices, created=$created, model=$model, object_=$object_, serviceTier=$serviceTier, systemFingerprint=$systemFingerprint, usage=$usage, additionalProperties=$additionalProperties}"
}
