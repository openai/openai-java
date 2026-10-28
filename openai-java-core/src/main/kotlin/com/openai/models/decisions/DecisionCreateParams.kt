// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

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
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.DecisionQuestionInputPart
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Use this endpoint to quickly answer classification or scoring questions about some input. You can
 * ask multiple questions in one request.
 */
class DecisionCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The input to evaluate for every question. Provide a text string or an ordered array of
     * messages, function calls and outputs, or custom tool calls and outputs. Each tool output must
     * identify a matching call by call ID.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): Input = body.input()

    /**
     * The model to use. Only `gpt-6-luna` is supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = body.model()

    /**
     * Ask 1–400 questions about the input. Each question can be a predicate, choice, or score.
     * Answers come back in the same order.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun questions(): List<Question> = body.questions()

    /**
     * Partition prompt cache reuse by caller-provided key.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun promptCacheKey(): Optional<String> = body.promptCacheKey()

    /**
     * Options for prompt caching. Supported for `gpt-5.6` and later models. By default, OpenAI
     * automatically chooses one implicit cache breakpoint. You can add explicit breakpoints to
     * content blocks with `prompt_cache_breakpoint`. Each request can write up to four breakpoints.
     * For cache matching, OpenAI considers up to the latest 80 breakpoints in the conversation,
     * without a content-block lookback limit. Set `mode` to `explicit` to disable the implicit
     * breakpoint. The `ttl` defaults to `30m`, which is currently the only supported value. See the
     * [prompt caching guide](https://developers.openai.com/api/docs/guides/prompt-caching) for
     * current details.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun promptCacheOptions(): Optional<PromptCacheOptions> = body.promptCacheOptions()

    /**
     * Opaque caller-provided end-user identifier, scoped by the verified org. Match Responses'
     * limit; this is never the authenticated user identity.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun safetyIdentifier(): Optional<String> = body.safetyIdentifier()

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _input(): JsonField<Input> = body._input()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<String> = body._model()

    /**
     * Returns the raw JSON value of [questions].
     *
     * Unlike [questions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _questions(): JsonField<List<Question>> = body._questions()

    /**
     * Returns the raw JSON value of [promptCacheKey].
     *
     * Unlike [promptCacheKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _promptCacheKey(): JsonField<String> = body._promptCacheKey()

    /**
     * Returns the raw JSON value of [promptCacheOptions].
     *
     * Unlike [promptCacheOptions], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _promptCacheOptions(): JsonField<PromptCacheOptions> = body._promptCacheOptions()

    /**
     * Returns the raw JSON value of [safetyIdentifier].
     *
     * Unlike [safetyIdentifier], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _safetyIdentifier(): JsonField<String> = body._safetyIdentifier()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DecisionCreateParams].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .model()
         * .questions()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(decisionCreateParams: DecisionCreateParams) = apply {
            body = decisionCreateParams.body.toBuilder()
            additionalHeaders = decisionCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = decisionCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [input]
         * - [model]
         * - [questions]
         * - [promptCacheKey]
         * - [promptCacheOptions]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The input to evaluate for every question. Provide a text string or an ordered array of
         * messages, function calls and outputs, or custom tool calls and outputs. Each tool output
         * must identify a matching call by call ID.
         */
        fun input(input: Input) = apply { body.input(input) }

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [Input] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<Input>) = apply { body.input(input) }

        /** Alias for calling [input] with `Input.ofString(string)`. */
        fun input(string: String) = apply { body.input(string) }

        /** Alias for calling [input] with `Input.ofDecisionInputItems(decisionInputItems)`. */
        fun inputOfDecisionInputItems(decisionInputItems: List<DecisionInputItem>) = apply {
            body.inputOfDecisionInputItems(decisionInputItems)
        }

        /** The model to use. Only `gpt-6-luna` is supported. */
        fun model(model: String) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { body.model(model) }

        /**
         * Ask 1–400 questions about the input. Each question can be a predicate, choice, or score.
         * Answers come back in the same order.
         */
        fun questions(questions: List<Question>) = apply { body.questions(questions) }

        /**
         * Sets [Builder.questions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.questions] with a well-typed `List<Question>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun questions(questions: JsonField<List<Question>>) = apply { body.questions(questions) }

        /**
         * Adds a single [Question] to [questions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addQuestion(question: Question) = apply { body.addQuestion(question) }

        /** Alias for calling [addQuestion] with `Question.ofPredicate(predicate)`. */
        fun addQuestion(predicate: Question.Predicate) = apply { body.addQuestion(predicate) }

        /**
         * Alias for calling [addQuestion] with the following:
         * ```java
         * Question.Predicate.builder()
         *     .instructions(instructions)
         *     .build()
         * ```
         */
        fun addPredicateQuestion(instructions: Question.Predicate.Instructions) = apply {
            body.addPredicateQuestion(instructions)
        }

        /**
         * Alias for calling [addPredicateQuestion] with
         * `Question.Predicate.Instructions.ofString(string)`.
         */
        fun addPredicateQuestion(string: String) = apply { body.addPredicateQuestion(string) }

        /**
         * Alias for calling [addPredicateQuestion] with
         * `Question.Predicate.Instructions.ofDecisionQuestionInputParts(decisionQuestionInputParts)`.
         */
        fun addPredicateQuestionOfDecisionQuestionInputParts(
            decisionQuestionInputParts: List<DecisionQuestionInputPart>
        ) = apply {
            body.addPredicateQuestionOfDecisionQuestionInputParts(decisionQuestionInputParts)
        }

        /** Alias for calling [addQuestion] with `Question.ofChoice(choice)`. */
        fun addQuestion(choice: Question.Choice) = apply { body.addQuestion(choice) }

        /** Alias for calling [addQuestion] with `Question.ofScore(score)`. */
        fun addQuestion(score: Question.Score) = apply { body.addQuestion(score) }

        /** Partition prompt cache reuse by caller-provided key. */
        fun promptCacheKey(promptCacheKey: String?) = apply { body.promptCacheKey(promptCacheKey) }

        /** Alias for calling [Builder.promptCacheKey] with `promptCacheKey.orElse(null)`. */
        fun promptCacheKey(promptCacheKey: Optional<String>) =
            promptCacheKey(promptCacheKey.getOrNull())

        /**
         * Sets [Builder.promptCacheKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheKey] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun promptCacheKey(promptCacheKey: JsonField<String>) = apply {
            body.promptCacheKey(promptCacheKey)
        }

        /**
         * Options for prompt caching. Supported for `gpt-5.6` and later models. By default, OpenAI
         * automatically chooses one implicit cache breakpoint. You can add explicit breakpoints to
         * content blocks with `prompt_cache_breakpoint`. Each request can write up to four
         * breakpoints. For cache matching, OpenAI considers up to the latest 80 breakpoints in the
         * conversation, without a content-block lookback limit. Set `mode` to `explicit` to disable
         * the implicit breakpoint. The `ttl` defaults to `30m`, which is currently the only
         * supported value. See the
         * [prompt caching guide](https://developers.openai.com/api/docs/guides/prompt-caching) for
         * current details.
         */
        fun promptCacheOptions(promptCacheOptions: PromptCacheOptions?) = apply {
            body.promptCacheOptions(promptCacheOptions)
        }

        /**
         * Alias for calling [Builder.promptCacheOptions] with `promptCacheOptions.orElse(null)`.
         */
        fun promptCacheOptions(promptCacheOptions: Optional<PromptCacheOptions>) =
            promptCacheOptions(promptCacheOptions.getOrNull())

        /**
         * Sets [Builder.promptCacheOptions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheOptions] with a well-typed
         * [PromptCacheOptions] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun promptCacheOptions(promptCacheOptions: JsonField<PromptCacheOptions>) = apply {
            body.promptCacheOptions(promptCacheOptions)
        }

        /**
         * Opaque caller-provided end-user identifier, scoped by the verified org. Match Responses'
         * limit; this is never the authenticated user identity.
         */
        fun safetyIdentifier(safetyIdentifier: String?) = apply {
            body.safetyIdentifier(safetyIdentifier)
        }

        /** Alias for calling [Builder.safetyIdentifier] with `safetyIdentifier.orElse(null)`. */
        fun safetyIdentifier(safetyIdentifier: Optional<String>) =
            safetyIdentifier(safetyIdentifier.getOrNull())

        /**
         * Sets [Builder.safetyIdentifier] to an arbitrary JSON value.
         *
         * You should usually call [Builder.safetyIdentifier] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun safetyIdentifier(safetyIdentifier: JsonField<String>) = apply {
            body.safetyIdentifier(safetyIdentifier)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [DecisionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .model()
         * .questions()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DecisionCreateParams =
            DecisionCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val input: JsonField<Input>,
        private val model: JsonField<String>,
        private val questions: JsonField<List<Question>>,
        private val promptCacheKey: JsonField<String>,
        private val promptCacheOptions: JsonField<PromptCacheOptions>,
        private val safetyIdentifier: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            @JsonProperty("questions")
            @ExcludeMissing
            questions: JsonField<List<Question>> = JsonMissing.of(),
            @JsonProperty("prompt_cache_key")
            @ExcludeMissing
            promptCacheKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prompt_cache_options")
            @ExcludeMissing
            promptCacheOptions: JsonField<PromptCacheOptions> = JsonMissing.of(),
            @JsonProperty("safety_identifier")
            @ExcludeMissing
            safetyIdentifier: JsonField<String> = JsonMissing.of(),
        ) : this(
            input,
            model,
            questions,
            promptCacheKey,
            promptCacheOptions,
            safetyIdentifier,
            mutableMapOf(),
        )

        /**
         * The input to evaluate for every question. Provide a text string or an ordered array of
         * messages, function calls and outputs, or custom tool calls and outputs. Each tool output
         * must identify a matching call by call ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): Input = input.getRequired("input")

        /**
         * The model to use. Only `gpt-6-luna` is supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): String = model.getRequired("model")

        /**
         * Ask 1–400 questions about the input. Each question can be a predicate, choice, or score.
         * Answers come back in the same order.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun questions(): List<Question> = questions.getRequired("questions")

        /**
         * Partition prompt cache reuse by caller-provided key.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun promptCacheKey(): Optional<String> = promptCacheKey.getOptional("prompt_cache_key")

        /**
         * Options for prompt caching. Supported for `gpt-5.6` and later models. By default, OpenAI
         * automatically chooses one implicit cache breakpoint. You can add explicit breakpoints to
         * content blocks with `prompt_cache_breakpoint`. Each request can write up to four
         * breakpoints. For cache matching, OpenAI considers up to the latest 80 breakpoints in the
         * conversation, without a content-block lookback limit. Set `mode` to `explicit` to disable
         * the implicit breakpoint. The `ttl` defaults to `30m`, which is currently the only
         * supported value. See the
         * [prompt caching guide](https://developers.openai.com/api/docs/guides/prompt-caching) for
         * current details.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun promptCacheOptions(): Optional<PromptCacheOptions> =
            promptCacheOptions.getOptional("prompt_cache_options")

        /**
         * Opaque caller-provided end-user identifier, scoped by the verified org. Match Responses'
         * limit; this is never the authenticated user identity.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun safetyIdentifier(): Optional<String> = safetyIdentifier.getOptional("safety_identifier")

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

        /**
         * Returns the raw JSON value of [questions].
         *
         * Unlike [questions], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("questions")
        @ExcludeMissing
        fun _questions(): JsonField<List<Question>> = questions

        /**
         * Returns the raw JSON value of [promptCacheKey].
         *
         * Unlike [promptCacheKey], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("prompt_cache_key")
        @ExcludeMissing
        fun _promptCacheKey(): JsonField<String> = promptCacheKey

        /**
         * Returns the raw JSON value of [promptCacheOptions].
         *
         * Unlike [promptCacheOptions], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("prompt_cache_options")
        @ExcludeMissing
        fun _promptCacheOptions(): JsonField<PromptCacheOptions> = promptCacheOptions

        /**
         * Returns the raw JSON value of [safetyIdentifier].
         *
         * Unlike [safetyIdentifier], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("safety_identifier")
        @ExcludeMissing
        fun _safetyIdentifier(): JsonField<String> = safetyIdentifier

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
                "input" to this.input,
                "model" to this.model,
                "questions" to this.questions,
                "prompt_cache_key" to this.promptCacheKey,
                "prompt_cache_options" to this.promptCacheOptions,
                "safety_identifier" to this.safetyIdentifier,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .input()
             * .model()
             * .questions()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var input: JsonField<Input>? = null
            private var model: JsonField<String>? = null
            private var questions: JsonField<MutableList<Question>>? = null
            private var promptCacheKey: JsonField<String> = JsonMissing.of()
            private var promptCacheOptions: JsonField<PromptCacheOptions> = JsonMissing.of()
            private var safetyIdentifier: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                input = body.input
                model = body.model
                questions = body.questions.map { it.toMutableList() }
                promptCacheKey = body.promptCacheKey
                promptCacheOptions = body.promptCacheOptions
                safetyIdentifier = body.safetyIdentifier
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The input to evaluate for every question. Provide a text string or an ordered array
             * of messages, function calls and outputs, or custom tool calls and outputs. Each tool
             * output must identify a matching call by call ID.
             */
            fun input(input: Input) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [Input] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** Alias for calling [input] with `Input.ofString(string)`. */
            fun input(string: String) = input(Input.ofString(string))

            /** Alias for calling [input] with `Input.ofDecisionInputItems(decisionInputItems)`. */
            fun inputOfDecisionInputItems(decisionInputItems: List<DecisionInputItem>) =
                input(Input.ofDecisionInputItems(decisionInputItems))

            /** The model to use. Only `gpt-6-luna` is supported. */
            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

            /**
             * Ask 1–400 questions about the input. Each question can be a predicate, choice, or
             * score. Answers come back in the same order.
             */
            fun questions(questions: List<Question>) = questions(JsonField.of(questions))

            /**
             * Sets [Builder.questions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.questions] with a well-typed `List<Question>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun questions(questions: JsonField<List<Question>>) = apply {
                this.questions = questions.map { it.toMutableList() }
            }

            /**
             * Adds a single [Question] to [questions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addQuestion(question: Question) = apply {
                questions =
                    (questions?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf()))
                        .also { checkKnown("questions", it).add(question) }
            }

            /** Alias for calling [addQuestion] with `Question.ofPredicate(predicate)`. */
            fun addQuestion(predicate: Question.Predicate) =
                addQuestion(Question.ofPredicate(predicate))

            /**
             * Alias for calling [addQuestion] with the following:
             * ```java
             * Question.Predicate.builder()
             *     .instructions(instructions)
             *     .build()
             * ```
             */
            fun addPredicateQuestion(instructions: Question.Predicate.Instructions) =
                addQuestion(Question.Predicate.builder().instructions(instructions).build())

            /**
             * Alias for calling [addPredicateQuestion] with
             * `Question.Predicate.Instructions.ofString(string)`.
             */
            fun addPredicateQuestion(string: String) =
                addPredicateQuestion(Question.Predicate.Instructions.ofString(string))

            /**
             * Alias for calling [addPredicateQuestion] with
             * `Question.Predicate.Instructions.ofDecisionQuestionInputParts(decisionQuestionInputParts)`.
             */
            fun addPredicateQuestionOfDecisionQuestionInputParts(
                decisionQuestionInputParts: List<DecisionQuestionInputPart>
            ) =
                addPredicateQuestion(
                    Question.Predicate.Instructions.ofDecisionQuestionInputParts(
                        decisionQuestionInputParts
                    )
                )

            /** Alias for calling [addQuestion] with `Question.ofChoice(choice)`. */
            fun addQuestion(choice: Question.Choice) = addQuestion(Question.ofChoice(choice))

            /** Alias for calling [addQuestion] with `Question.ofScore(score)`. */
            fun addQuestion(score: Question.Score) = addQuestion(Question.ofScore(score))

            /** Partition prompt cache reuse by caller-provided key. */
            fun promptCacheKey(promptCacheKey: String?) =
                promptCacheKey(JsonField.ofNullable(promptCacheKey))

            /** Alias for calling [Builder.promptCacheKey] with `promptCacheKey.orElse(null)`. */
            fun promptCacheKey(promptCacheKey: Optional<String>) =
                promptCacheKey(promptCacheKey.getOrNull())

            /**
             * Sets [Builder.promptCacheKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.promptCacheKey] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun promptCacheKey(promptCacheKey: JsonField<String>) = apply {
                this.promptCacheKey = promptCacheKey
            }

            /**
             * Options for prompt caching. Supported for `gpt-5.6` and later models. By default,
             * OpenAI automatically chooses one implicit cache breakpoint. You can add explicit
             * breakpoints to content blocks with `prompt_cache_breakpoint`. Each request can write
             * up to four breakpoints. For cache matching, OpenAI considers up to the latest 80
             * breakpoints in the conversation, without a content-block lookback limit. Set `mode`
             * to `explicit` to disable the implicit breakpoint. The `ttl` defaults to `30m`, which
             * is currently the only supported value. See the
             * [prompt caching guide](https://developers.openai.com/api/docs/guides/prompt-caching)
             * for current details.
             */
            fun promptCacheOptions(promptCacheOptions: PromptCacheOptions?) =
                promptCacheOptions(JsonField.ofNullable(promptCacheOptions))

            /**
             * Alias for calling [Builder.promptCacheOptions] with
             * `promptCacheOptions.orElse(null)`.
             */
            fun promptCacheOptions(promptCacheOptions: Optional<PromptCacheOptions>) =
                promptCacheOptions(promptCacheOptions.getOrNull())

            /**
             * Sets [Builder.promptCacheOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.promptCacheOptions] with a well-typed
             * [PromptCacheOptions] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun promptCacheOptions(promptCacheOptions: JsonField<PromptCacheOptions>) = apply {
                this.promptCacheOptions = promptCacheOptions
            }

            /**
             * Opaque caller-provided end-user identifier, scoped by the verified org. Match
             * Responses' limit; this is never the authenticated user identity.
             */
            fun safetyIdentifier(safetyIdentifier: String?) =
                safetyIdentifier(JsonField.ofNullable(safetyIdentifier))

            /**
             * Alias for calling [Builder.safetyIdentifier] with `safetyIdentifier.orElse(null)`.
             */
            fun safetyIdentifier(safetyIdentifier: Optional<String>) =
                safetyIdentifier(safetyIdentifier.getOrNull())

            /**
             * Sets [Builder.safetyIdentifier] to an arbitrary JSON value.
             *
             * You should usually call [Builder.safetyIdentifier] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun safetyIdentifier(safetyIdentifier: JsonField<String>) = apply {
                this.safetyIdentifier = safetyIdentifier
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .input()
             * .model()
             * .questions()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("input", input),
                    checkRequired("model", model),
                    checkRequired("questions", questions).map { it.toImmutable() },
                    promptCacheKey,
                    promptCacheOptions,
                    safetyIdentifier,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            input().validate()
            model()
            questions().forEach { it.validate() }
            promptCacheKey()
            promptCacheOptions().ifPresent { it.validate() }
            safetyIdentifier()
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
            (input.asKnown().getOrNull()?.validity() ?: 0) +
                (if (model.asKnown().isPresent) 1 else 0) +
                (questions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (promptCacheKey.asKnown().isPresent) 1 else 0) +
                (promptCacheOptions.asKnown().getOrNull()?.validity() ?: 0) +
                (if (safetyIdentifier.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                input == other.input &&
                model == other.model &&
                questions == other.questions &&
                promptCacheKey == other.promptCacheKey &&
                promptCacheOptions == other.promptCacheOptions &&
                safetyIdentifier == other.safetyIdentifier &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                input,
                model,
                questions,
                promptCacheKey,
                promptCacheOptions,
                safetyIdentifier,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{input=$input, model=$model, questions=$questions, promptCacheKey=$promptCacheKey, promptCacheOptions=$promptCacheOptions, safetyIdentifier=$safetyIdentifier, additionalProperties=$additionalProperties}"
    }

    /**
     * The input to evaluate for every question. Provide a text string or an ordered array of
     * messages, function calls and outputs, or custom tool calls and outputs. Each tool output must
     * identify a matching call by call ID.
     */
    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val string: String? = null,
        private val decisionInputItems: List<DecisionInputItem>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun decisionInputItems(): Optional<List<DecisionInputItem>> =
            Optional.ofNullable(decisionInputItems)

        fun isString(): Boolean = string != null

        fun isDecisionInputItems(): Boolean = decisionInputItems != null

        fun asString(): String = string.getOrThrow("string")

        fun asDecisionInputItems(): List<DecisionInputItem> =
            decisionInputItems.getOrThrow("decisionInputItems")

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
         * Optional<String> result = input.accept(new Input.Visitor<Optional<String>>() {
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                decisionInputItems != null -> visitor.visitDecisionInputItems(decisionInputItems)
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
        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitDecisionInputItems(
                        decisionInputItems: List<DecisionInputItem>
                    ) {
                        decisionInputItems.forEach { it.validate() }
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

                    override fun visitDecisionInputItems(
                        decisionInputItems: List<DecisionInputItem>
                    ) = decisionInputItems.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input &&
                string == other.string &&
                decisionInputItems == other.decisionInputItems &&
                (string != null || decisionInputItems != null || _json == other._json)
        }

        override fun hashCode(): Int =
            if (string == null && decisionInputItems == null) Objects.hash(_json)
            else Objects.hash(string, decisionInputItems)

        override fun toString(): String =
            when {
                string != null -> "Input{string=$string}"
                decisionInputItems != null -> "Input{decisionInputItems=$decisionInputItems}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Input(string = string)

            @JvmStatic
            fun ofDecisionInputItems(decisionInputItems: List<DecisionInputItem>) =
                Input(decisionInputItems = decisionInputItems.toImmutable())
        }

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitDecisionInputItems(decisionInputItems: List<DecisionInputItem>): T

            /**
             * Maps an unknown variant of [Input] to a value of type [T].
             *
             * An instance of [Input] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Input")
            }
        }

        internal class Deserializer : BaseDeserializer<Input>(Input::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Input {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Input(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<DecisionInputItem>>())?.let {
                                Input(decisionInputItems = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Input(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.decisionInputItems != null ->
                        generator.writeObject(value.decisionInputItems)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
    }

    /** A question about the request's input, with an optional correlation name. */
    @JsonDeserialize(using = Question.Deserializer::class)
    @JsonSerialize(using = Question.Serializer::class)
    class Question
    private constructor(
        private val predicate: Predicate? = null,
        private val choice: Choice? = null,
        private val score: Score? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Estimate how likely it is that a statement about the input is true. */
        fun predicate(): Optional<Predicate> = Optional.ofNullable(predicate)

        /** Choose from the supplied options based on the input. */
        fun choice(): Optional<Choice> = Optional.ofNullable(choice)

        /** Rate the input against the supplied ordered levels. */
        fun score(): Optional<Score> = Optional.ofNullable(score)

        fun isPredicate(): Boolean = predicate != null

        fun isChoice(): Boolean = choice != null

        fun isScore(): Boolean = score != null

        /** Estimate how likely it is that a statement about the input is true. */
        fun asPredicate(): Predicate = predicate.getOrThrow("predicate")

        /** Choose from the supplied options based on the input. */
        fun asChoice(): Choice = choice.getOrThrow("choice")

        /** Rate the input against the supplied ordered levels. */
        fun asScore(): Score = score.getOrThrow("score")

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
         * Optional<String> result = question.accept(new Question.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitPredicate(Predicate predicate) {
         *         return Optional.of(predicate.toString());
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
                predicate != null -> visitor.visitPredicate(predicate)
                choice != null -> visitor.visitChoice(choice)
                score != null -> visitor.visitScore(score)
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
        fun validate(): Question = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitPredicate(predicate: Predicate) {
                        predicate.validate()
                    }

                    override fun visitChoice(choice: Choice) {
                        choice.validate()
                    }

                    override fun visitScore(score: Score) {
                        score.validate()
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
                    override fun visitPredicate(predicate: Predicate) = predicate.validity()

                    override fun visitChoice(choice: Choice) = choice.validity()

                    override fun visitScore(score: Score) = score.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Question &&
                predicate == other.predicate &&
                choice == other.choice &&
                score == other.score &&
                (predicate != null || choice != null || score != null || _json == other._json)
        }

        override fun hashCode(): Int =
            if (predicate == null && choice == null && score == null) Objects.hash(_json)
            else Objects.hash(predicate, choice, score)

        override fun toString(): String =
            when {
                predicate != null -> "Question{predicate=$predicate}"
                choice != null -> "Question{choice=$choice}"
                score != null -> "Question{score=$score}"
                _json != null -> "Question{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Question")
            }

        companion object {

            /** Estimate how likely it is that a statement about the input is true. */
            @JvmStatic fun ofPredicate(predicate: Predicate) = Question(predicate = predicate)

            /** Choose from the supplied options based on the input. */
            @JvmStatic fun ofChoice(choice: Choice) = Question(choice = choice)

            /** Rate the input against the supplied ordered levels. */
            @JvmStatic fun ofScore(score: Score) = Question(score = score)
        }

        /**
         * An interface that defines how to map each variant of [Question] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Estimate how likely it is that a statement about the input is true. */
            fun visitPredicate(predicate: Predicate): T

            /** Choose from the supplied options based on the input. */
            fun visitChoice(choice: Choice): T

            /** Rate the input against the supplied ordered levels. */
            fun visitScore(score: Score): T

            /**
             * Maps an unknown variant of [Question] to a value of type [T].
             *
             * An instance of [Question] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Question")
            }
        }

        internal class Deserializer : BaseDeserializer<Question>(Question::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Question {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "predicate" -> {
                        return tryDeserialize(node, jacksonTypeRef<Predicate>())?.let {
                            Question(predicate = it, _json = json)
                        } ?: Question(_json = json)
                    }
                    "choice" -> {
                        return tryDeserialize(node, jacksonTypeRef<Choice>())?.let {
                            Question(choice = it, _json = json)
                        } ?: Question(_json = json)
                    }
                    "score" -> {
                        return tryDeserialize(node, jacksonTypeRef<Score>())?.let {
                            Question(score = it, _json = json)
                        } ?: Question(_json = json)
                    }
                }

                return Question(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Question>(Question::class) {

            override fun serialize(
                value: Question,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.predicate != null -> generator.writeObject(value.predicate)
                    value.choice != null -> generator.writeObject(value.choice)
                    value.score != null -> generator.writeObject(value.score)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Question")
                }
            }
        }

        /** Estimate how likely it is that a statement about the input is true. */
        class Predicate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val instructions: JsonField<Instructions>,
            private val type: JsonValue,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("instructions")
                @ExcludeMissing
                instructions: JsonField<Instructions> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(instructions, type, name, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun instructions(): Instructions = instructions.getRequired("instructions")

            /**
             * The type of the object. Always `predicate`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("predicate")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [instructions].
             *
             * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("instructions")
            @ExcludeMissing
            fun _instructions(): JsonField<Instructions> = instructions

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                    "instructions" to this.instructions,
                    "type" to this.type,
                    "name" to this.name,
                )

            /**
             * Returns the legacy additional-properties view.
             *
             * @deprecated Use [_allProperties] to access both declared and additional JSON
             *   properties. This accessor retains its legacy additional-properties behavior.
             */
            @Deprecated(
                "Use _allProperties() to access both declared and additional JSON properties."
            )
            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Predicate].
                 *
                 * The following fields are required:
                 * ```java
                 * .instructions()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Predicate]. */
            class Builder internal constructor() {

                private var instructions: JsonField<Instructions>? = null
                private var type: JsonValue = JsonValue.from("predicate")
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(predicate: Predicate) = apply {
                    instructions = predicate.instructions
                    type = predicate.type
                    name = predicate.name
                    additionalProperties = predicate.additionalProperties.toMutableMap()
                }

                fun instructions(instructions: Instructions) =
                    instructions(JsonField.of(instructions))

                /**
                 * Sets [Builder.instructions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.instructions] with a well-typed [Instructions]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun instructions(instructions: JsonField<Instructions>) = apply {
                    this.instructions = instructions
                }

                /** Alias for calling [instructions] with `Instructions.ofString(string)`. */
                fun instructions(string: String) = instructions(Instructions.ofString(string))

                /**
                 * Alias for calling [instructions] with
                 * `Instructions.ofDecisionQuestionInputParts(decisionQuestionInputParts)`.
                 */
                fun instructionsOfDecisionQuestionInputParts(
                    decisionQuestionInputParts: List<DecisionQuestionInputPart>
                ) =
                    instructions(
                        Instructions.ofDecisionQuestionInputParts(decisionQuestionInputParts)
                    )

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("predicate")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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
                 * Returns an immutable instance of [Predicate].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .instructions()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Predicate =
                    Predicate(
                        checkRequired("instructions", instructions),
                        type,
                        name,
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
            fun validate(): Predicate = apply {
                if (validated) {
                    return@apply
                }

                instructions().validate()
                _type().let {
                    if (it != JsonValue.from("predicate")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                name()
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
                (instructions.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("predicate")) 1 else 0 } +
                    (if (name.asKnown().isPresent) 1 else 0)

            @JsonDeserialize(using = Instructions.Deserializer::class)
            @JsonSerialize(using = Instructions.Serializer::class)
            class Instructions
            private constructor(
                private val string: String? = null,
                private val decisionQuestionInputParts: List<DecisionQuestionInputPart>? = null,
                private val _json: JsonValue? = null,
            ) {

                fun string(): Optional<String> = Optional.ofNullable(string)

                fun decisionQuestionInputParts(): Optional<List<DecisionQuestionInputPart>> =
                    Optional.ofNullable(decisionQuestionInputParts)

                fun isString(): Boolean = string != null

                fun isDecisionQuestionInputParts(): Boolean = decisionQuestionInputParts != null

                fun asString(): String = string.getOrThrow("string")

                fun asDecisionQuestionInputParts(): List<DecisionQuestionInputPart> =
                    decisionQuestionInputParts.getOrThrow("decisionQuestionInputParts")

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
                 * Optional<String> result = instructions.accept(new Instructions.Visitor<Optional<String>>() {
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
                        decisionQuestionInputParts != null ->
                            visitor.visitDecisionQuestionInputParts(decisionQuestionInputParts)
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
                fun validate(): Instructions = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitString(string: String) {}

                            override fun visitDecisionQuestionInputParts(
                                decisionQuestionInputParts: List<DecisionQuestionInputPart>
                            ) {
                                decisionQuestionInputParts.forEach { it.validate() }
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

                            override fun visitDecisionQuestionInputParts(
                                decisionQuestionInputParts: List<DecisionQuestionInputPart>
                            ) = decisionQuestionInputParts.sumOf { it.validity().toInt() }

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Instructions &&
                        string == other.string &&
                        decisionQuestionInputParts == other.decisionQuestionInputParts &&
                        (string != null ||
                            decisionQuestionInputParts != null ||
                            _json == other._json)
                }

                override fun hashCode(): Int =
                    if (string == null && decisionQuestionInputParts == null) Objects.hash(_json)
                    else Objects.hash(string, decisionQuestionInputParts)

                override fun toString(): String =
                    when {
                        string != null -> "Instructions{string=$string}"
                        decisionQuestionInputParts != null ->
                            "Instructions{decisionQuestionInputParts=$decisionQuestionInputParts}"
                        _json != null -> "Instructions{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Instructions")
                    }

                companion object {

                    @JvmStatic fun ofString(string: String) = Instructions(string = string)

                    @JvmStatic
                    fun ofDecisionQuestionInputParts(
                        decisionQuestionInputParts: List<DecisionQuestionInputPart>
                    ) =
                        Instructions(
                            decisionQuestionInputParts = decisionQuestionInputParts.toImmutable()
                        )
                }

                /**
                 * An interface that defines how to map each variant of [Instructions] to a value of
                 * type [T].
                 */
                interface Visitor<out T> {

                    fun visitString(string: String): T

                    fun visitDecisionQuestionInputParts(
                        decisionQuestionInputParts: List<DecisionQuestionInputPart>
                    ): T

                    /**
                     * Maps an unknown variant of [Instructions] to a value of type [T].
                     *
                     * An instance of [Instructions] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Instructions")
                    }
                }

                internal class Deserializer : BaseDeserializer<Instructions>(Instructions::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Instructions {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        Instructions(string = it, _json = json)
                                    },
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<List<DecisionQuestionInputPart>>(),
                                        )
                                        ?.let {
                                            Instructions(
                                                decisionQuestionInputParts = it,
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
                            0 -> Instructions(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<Instructions>(Instructions::class) {

                    override fun serialize(
                        value: Instructions,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.string != null -> generator.writeObject(value.string)
                            value.decisionQuestionInputParts != null ->
                                generator.writeObject(value.decisionQuestionInputParts)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Instructions")
                        }
                    }
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Predicate &&
                    instructions == other.instructions &&
                    type == other.type &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(instructions, type, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Predicate{instructions=$instructions, type=$type, name=$name, additionalProperties=$additionalProperties}"
        }

        /** Choose from the supplied options based on the input. */
        class Choice
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val choices: JsonField<List<DecisionChoiceOption>>,
            private val instructions: JsonField<Instructions>,
            private val type: JsonValue,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("choices")
                @ExcludeMissing
                choices: JsonField<List<DecisionChoiceOption>> = JsonMissing.of(),
                @JsonProperty("instructions")
                @ExcludeMissing
                instructions: JsonField<Instructions> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(choices, instructions, type, name, mutableMapOf())

            /**
             * Provide between 2 and 255 choices. Each choice must be unique.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun choices(): List<DecisionChoiceOption> = choices.getRequired("choices")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun instructions(): Instructions = instructions.getRequired("instructions")

            /**
             * The type of the object. Always `choice`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("choice")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [choices].
             *
             * Unlike [choices], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("choices")
            @ExcludeMissing
            fun _choices(): JsonField<List<DecisionChoiceOption>> = choices

            /**
             * Returns the raw JSON value of [instructions].
             *
             * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("instructions")
            @ExcludeMissing
            fun _instructions(): JsonField<Instructions> = instructions

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                    "choices" to this.choices,
                    "instructions" to this.instructions,
                    "type" to this.type,
                    "name" to this.name,
                )

            /**
             * Returns the legacy additional-properties view.
             *
             * @deprecated Use [_allProperties] to access both declared and additional JSON
             *   properties. This accessor retains its legacy additional-properties behavior.
             */
            @Deprecated(
                "Use _allProperties() to access both declared and additional JSON properties."
            )
            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Choice].
                 *
                 * The following fields are required:
                 * ```java
                 * .choices()
                 * .instructions()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Choice]. */
            class Builder internal constructor() {

                private var choices: JsonField<MutableList<DecisionChoiceOption>>? = null
                private var instructions: JsonField<Instructions>? = null
                private var type: JsonValue = JsonValue.from("choice")
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(choice: Choice) = apply {
                    choices = choice.choices.map { it.toMutableList() }
                    instructions = choice.instructions
                    type = choice.type
                    name = choice.name
                    additionalProperties = choice.additionalProperties.toMutableMap()
                }

                /** Provide between 2 and 255 choices. Each choice must be unique. */
                fun choices(choices: List<DecisionChoiceOption>) = choices(JsonField.of(choices))

                /**
                 * Sets [Builder.choices] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.choices] with a well-typed
                 * `List<DecisionChoiceOption>` value instead. This method is primarily for setting
                 * the field to an undocumented or not yet supported value.
                 */
                fun choices(choices: JsonField<List<DecisionChoiceOption>>) = apply {
                    this.choices = choices.map { it.toMutableList() }
                }

                /**
                 * Adds a single [DecisionChoiceOption] to [choices].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addChoice(choice: DecisionChoiceOption) = apply {
                    choices =
                        (choices ?: JsonField.of(mutableListOf())).also {
                            checkKnown("choices", it).add(choice)
                        }
                }

                fun instructions(instructions: Instructions) =
                    instructions(JsonField.of(instructions))

                /**
                 * Sets [Builder.instructions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.instructions] with a well-typed [Instructions]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun instructions(instructions: JsonField<Instructions>) = apply {
                    this.instructions = instructions
                }

                /** Alias for calling [instructions] with `Instructions.ofString(string)`. */
                fun instructions(string: String) = instructions(Instructions.ofString(string))

                /**
                 * Alias for calling [instructions] with
                 * `Instructions.ofDecisionQuestionInputParts(decisionQuestionInputParts)`.
                 */
                fun instructionsOfDecisionQuestionInputParts(
                    decisionQuestionInputParts: List<DecisionQuestionInputPart>
                ) =
                    instructions(
                        Instructions.ofDecisionQuestionInputParts(decisionQuestionInputParts)
                    )

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("choice")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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
                 * Returns an immutable instance of [Choice].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .choices()
                 * .instructions()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Choice =
                    Choice(
                        checkRequired("choices", choices).map { it.toImmutable() },
                        checkRequired("instructions", instructions),
                        type,
                        name,
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
            fun validate(): Choice = apply {
                if (validated) {
                    return@apply
                }

                choices().forEach { it.validate() }
                instructions().validate()
                _type().let {
                    if (it != JsonValue.from("choice")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                name()
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
                (choices.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (instructions.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("choice")) 1 else 0 } +
                    (if (name.asKnown().isPresent) 1 else 0)

            @JsonDeserialize(using = Instructions.Deserializer::class)
            @JsonSerialize(using = Instructions.Serializer::class)
            class Instructions
            private constructor(
                private val string: String? = null,
                private val decisionQuestionInputParts: List<DecisionQuestionInputPart>? = null,
                private val _json: JsonValue? = null,
            ) {

                fun string(): Optional<String> = Optional.ofNullable(string)

                fun decisionQuestionInputParts(): Optional<List<DecisionQuestionInputPart>> =
                    Optional.ofNullable(decisionQuestionInputParts)

                fun isString(): Boolean = string != null

                fun isDecisionQuestionInputParts(): Boolean = decisionQuestionInputParts != null

                fun asString(): String = string.getOrThrow("string")

                fun asDecisionQuestionInputParts(): List<DecisionQuestionInputPart> =
                    decisionQuestionInputParts.getOrThrow("decisionQuestionInputParts")

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
                 * Optional<String> result = instructions.accept(new Instructions.Visitor<Optional<String>>() {
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
                        decisionQuestionInputParts != null ->
                            visitor.visitDecisionQuestionInputParts(decisionQuestionInputParts)
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
                fun validate(): Instructions = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitString(string: String) {}

                            override fun visitDecisionQuestionInputParts(
                                decisionQuestionInputParts: List<DecisionQuestionInputPart>
                            ) {
                                decisionQuestionInputParts.forEach { it.validate() }
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

                            override fun visitDecisionQuestionInputParts(
                                decisionQuestionInputParts: List<DecisionQuestionInputPart>
                            ) = decisionQuestionInputParts.sumOf { it.validity().toInt() }

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Instructions &&
                        string == other.string &&
                        decisionQuestionInputParts == other.decisionQuestionInputParts &&
                        (string != null ||
                            decisionQuestionInputParts != null ||
                            _json == other._json)
                }

                override fun hashCode(): Int =
                    if (string == null && decisionQuestionInputParts == null) Objects.hash(_json)
                    else Objects.hash(string, decisionQuestionInputParts)

                override fun toString(): String =
                    when {
                        string != null -> "Instructions{string=$string}"
                        decisionQuestionInputParts != null ->
                            "Instructions{decisionQuestionInputParts=$decisionQuestionInputParts}"
                        _json != null -> "Instructions{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Instructions")
                    }

                companion object {

                    @JvmStatic fun ofString(string: String) = Instructions(string = string)

                    @JvmStatic
                    fun ofDecisionQuestionInputParts(
                        decisionQuestionInputParts: List<DecisionQuestionInputPart>
                    ) =
                        Instructions(
                            decisionQuestionInputParts = decisionQuestionInputParts.toImmutable()
                        )
                }

                /**
                 * An interface that defines how to map each variant of [Instructions] to a value of
                 * type [T].
                 */
                interface Visitor<out T> {

                    fun visitString(string: String): T

                    fun visitDecisionQuestionInputParts(
                        decisionQuestionInputParts: List<DecisionQuestionInputPart>
                    ): T

                    /**
                     * Maps an unknown variant of [Instructions] to a value of type [T].
                     *
                     * An instance of [Instructions] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Instructions")
                    }
                }

                internal class Deserializer : BaseDeserializer<Instructions>(Instructions::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Instructions {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        Instructions(string = it, _json = json)
                                    },
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<List<DecisionQuestionInputPart>>(),
                                        )
                                        ?.let {
                                            Instructions(
                                                decisionQuestionInputParts = it,
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
                            0 -> Instructions(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<Instructions>(Instructions::class) {

                    override fun serialize(
                        value: Instructions,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.string != null -> generator.writeObject(value.string)
                            value.decisionQuestionInputParts != null ->
                                generator.writeObject(value.decisionQuestionInputParts)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Instructions")
                        }
                    }
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Choice &&
                    choices == other.choices &&
                    instructions == other.instructions &&
                    type == other.type &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(choices, instructions, type, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Choice{choices=$choices, instructions=$instructions, type=$type, name=$name, additionalProperties=$additionalProperties}"
        }

        /** Rate the input against the supplied ordered levels. */
        class Score
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val instructions: JsonField<Instructions>,
            private val levels: JsonField<List<Level>>,
            private val type: JsonValue,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("instructions")
                @ExcludeMissing
                instructions: JsonField<Instructions> = JsonMissing.of(),
                @JsonProperty("levels")
                @ExcludeMissing
                levels: JsonField<List<Level>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(instructions, levels, type, name, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun instructions(): Instructions = instructions.getRequired("instructions")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun levels(): List<Level> = levels.getRequired("levels")

            /**
             * The type of the object. Always `score`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("score")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [instructions].
             *
             * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("instructions")
            @ExcludeMissing
            fun _instructions(): JsonField<Instructions> = instructions

            /**
             * Returns the raw JSON value of [levels].
             *
             * Unlike [levels], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("levels") @ExcludeMissing fun _levels(): JsonField<List<Level>> = levels

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                    "instructions" to this.instructions,
                    "levels" to this.levels,
                    "type" to this.type,
                    "name" to this.name,
                )

            /**
             * Returns the legacy additional-properties view.
             *
             * @deprecated Use [_allProperties] to access both declared and additional JSON
             *   properties. This accessor retains its legacy additional-properties behavior.
             */
            @Deprecated(
                "Use _allProperties() to access both declared and additional JSON properties."
            )
            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Score].
                 *
                 * The following fields are required:
                 * ```java
                 * .instructions()
                 * .levels()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Score]. */
            class Builder internal constructor() {

                private var instructions: JsonField<Instructions>? = null
                private var levels: JsonField<MutableList<Level>>? = null
                private var type: JsonValue = JsonValue.from("score")
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(score: Score) = apply {
                    instructions = score.instructions
                    levels = score.levels.map { it.toMutableList() }
                    type = score.type
                    name = score.name
                    additionalProperties = score.additionalProperties.toMutableMap()
                }

                fun instructions(instructions: Instructions) =
                    instructions(JsonField.of(instructions))

                /**
                 * Sets [Builder.instructions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.instructions] with a well-typed [Instructions]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun instructions(instructions: JsonField<Instructions>) = apply {
                    this.instructions = instructions
                }

                /** Alias for calling [instructions] with `Instructions.ofString(string)`. */
                fun instructions(string: String) = instructions(Instructions.ofString(string))

                /**
                 * Alias for calling [instructions] with
                 * `Instructions.ofDecisionQuestionInputParts(decisionQuestionInputParts)`.
                 */
                fun instructionsOfDecisionQuestionInputParts(
                    decisionQuestionInputParts: List<DecisionQuestionInputPart>
                ) =
                    instructions(
                        Instructions.ofDecisionQuestionInputParts(decisionQuestionInputParts)
                    )

                fun levels(levels: List<Level>) = levels(JsonField.of(levels))

                /**
                 * Sets [Builder.levels] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.levels] with a well-typed `List<Level>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun levels(levels: JsonField<List<Level>>) = apply {
                    this.levels = levels.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Level] to [levels].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addLevel(level: Level) = apply {
                    levels =
                        (levels ?: JsonField.of(mutableListOf())).also {
                            checkKnown("levels", it).add(level)
                        }
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("score")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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
                 * Returns an immutable instance of [Score].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .instructions()
                 * .levels()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Score =
                    Score(
                        checkRequired("instructions", instructions),
                        checkRequired("levels", levels).map { it.toImmutable() },
                        type,
                        name,
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
            fun validate(): Score = apply {
                if (validated) {
                    return@apply
                }

                instructions().validate()
                levels().forEach { it.validate() }
                _type().let {
                    if (it != JsonValue.from("score")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                name()
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
                (instructions.asKnown().getOrNull()?.validity() ?: 0) +
                    (levels.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    type.let { if (it == JsonValue.from("score")) 1 else 0 } +
                    (if (name.asKnown().isPresent) 1 else 0)

            @JsonDeserialize(using = Instructions.Deserializer::class)
            @JsonSerialize(using = Instructions.Serializer::class)
            class Instructions
            private constructor(
                private val string: String? = null,
                private val decisionQuestionInputParts: List<DecisionQuestionInputPart>? = null,
                private val _json: JsonValue? = null,
            ) {

                fun string(): Optional<String> = Optional.ofNullable(string)

                fun decisionQuestionInputParts(): Optional<List<DecisionQuestionInputPart>> =
                    Optional.ofNullable(decisionQuestionInputParts)

                fun isString(): Boolean = string != null

                fun isDecisionQuestionInputParts(): Boolean = decisionQuestionInputParts != null

                fun asString(): String = string.getOrThrow("string")

                fun asDecisionQuestionInputParts(): List<DecisionQuestionInputPart> =
                    decisionQuestionInputParts.getOrThrow("decisionQuestionInputParts")

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
                 * Optional<String> result = instructions.accept(new Instructions.Visitor<Optional<String>>() {
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
                        decisionQuestionInputParts != null ->
                            visitor.visitDecisionQuestionInputParts(decisionQuestionInputParts)
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
                fun validate(): Instructions = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitString(string: String) {}

                            override fun visitDecisionQuestionInputParts(
                                decisionQuestionInputParts: List<DecisionQuestionInputPart>
                            ) {
                                decisionQuestionInputParts.forEach { it.validate() }
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

                            override fun visitDecisionQuestionInputParts(
                                decisionQuestionInputParts: List<DecisionQuestionInputPart>
                            ) = decisionQuestionInputParts.sumOf { it.validity().toInt() }

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Instructions &&
                        string == other.string &&
                        decisionQuestionInputParts == other.decisionQuestionInputParts &&
                        (string != null ||
                            decisionQuestionInputParts != null ||
                            _json == other._json)
                }

                override fun hashCode(): Int =
                    if (string == null && decisionQuestionInputParts == null) Objects.hash(_json)
                    else Objects.hash(string, decisionQuestionInputParts)

                override fun toString(): String =
                    when {
                        string != null -> "Instructions{string=$string}"
                        decisionQuestionInputParts != null ->
                            "Instructions{decisionQuestionInputParts=$decisionQuestionInputParts}"
                        _json != null -> "Instructions{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Instructions")
                    }

                companion object {

                    @JvmStatic fun ofString(string: String) = Instructions(string = string)

                    @JvmStatic
                    fun ofDecisionQuestionInputParts(
                        decisionQuestionInputParts: List<DecisionQuestionInputPart>
                    ) =
                        Instructions(
                            decisionQuestionInputParts = decisionQuestionInputParts.toImmutable()
                        )
                }

                /**
                 * An interface that defines how to map each variant of [Instructions] to a value of
                 * type [T].
                 */
                interface Visitor<out T> {

                    fun visitString(string: String): T

                    fun visitDecisionQuestionInputParts(
                        decisionQuestionInputParts: List<DecisionQuestionInputPart>
                    ): T

                    /**
                     * Maps an unknown variant of [Instructions] to a value of type [T].
                     *
                     * An instance of [Instructions] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Instructions")
                    }
                }

                internal class Deserializer : BaseDeserializer<Instructions>(Instructions::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Instructions {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        Instructions(string = it, _json = json)
                                    },
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<List<DecisionQuestionInputPart>>(),
                                        )
                                        ?.let {
                                            Instructions(
                                                decisionQuestionInputParts = it,
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
                            0 -> Instructions(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<Instructions>(Instructions::class) {

                    override fun serialize(
                        value: Instructions,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.string != null -> generator.writeObject(value.string)
                            value.decisionQuestionInputParts != null ->
                                generator.writeObject(value.decisionQuestionInputParts)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Instructions")
                        }
                    }
                }
            }

            class Level
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val label: JsonField<String>,
                private val description: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("label")
                    @ExcludeMissing
                    label: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("description")
                    @ExcludeMissing
                    description: JsonField<String> = JsonMissing.of(),
                ) : this(label, description, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun label(): String = label.getRequired("label")

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun description(): Optional<String> = description.getOptional("description")

                /**
                 * Returns the raw JSON value of [label].
                 *
                 * Unlike [label], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

                /**
                 * Returns the raw JSON value of [description].
                 *
                 * Unlike [description], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("description")
                @ExcludeMissing
                fun _description(): JsonField<String> = description

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "label" to this.label,
                        "description" to this.description,
                    )

                /**
                 * Returns the legacy additional-properties view.
                 *
                 * @deprecated Use [_allProperties] to access both declared and additional JSON
                 *   properties. This accessor retains its legacy additional-properties behavior.
                 */
                @Deprecated(
                    "Use _allProperties() to access both declared and additional JSON properties."
                )
                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [Level].
                     *
                     * The following fields are required:
                     * ```java
                     * .label()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Level]. */
                class Builder internal constructor() {

                    private var label: JsonField<String>? = null
                    private var description: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(level: Level) = apply {
                        label = level.label
                        description = level.description
                        additionalProperties = level.additionalProperties.toMutableMap()
                    }

                    fun label(label: String) = label(JsonField.of(label))

                    /**
                     * Sets [Builder.label] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.label] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun label(label: JsonField<String>) = apply { this.label = label }

                    fun description(description: String) = description(JsonField.of(description))

                    /**
                     * Sets [Builder.description] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.description] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun description(description: JsonField<String>) = apply {
                        this.description = description
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
                     * Returns an immutable instance of [Level].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .label()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Level =
                        Level(
                            checkRequired("label", label),
                            description,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Level = apply {
                    if (validated) {
                        return@apply
                    }

                    label()
                    description()
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
                    (if (label.asKnown().isPresent) 1 else 0) +
                        (if (description.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Level &&
                        label == other.label &&
                        description == other.description &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(label, description, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Level{label=$label, description=$description, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Score &&
                    instructions == other.instructions &&
                    levels == other.levels &&
                    type == other.type &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(instructions, levels, type, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Score{instructions=$instructions, levels=$levels, type=$type, name=$name, additionalProperties=$additionalProperties}"
        }
    }

    /**
     * Options for prompt caching. Supported for `gpt-5.6` and later models. By default, OpenAI
     * automatically chooses one implicit cache breakpoint. You can add explicit breakpoints to
     * content blocks with `prompt_cache_breakpoint`. Each request can write up to four breakpoints.
     * For cache matching, OpenAI considers up to the latest 80 breakpoints in the conversation,
     * without a content-block lookback limit. Set `mode` to `explicit` to disable the implicit
     * breakpoint. The `ttl` defaults to `30m`, which is currently the only supported value. See the
     * [prompt caching guide](https://developers.openai.com/api/docs/guides/prompt-caching) for
     * current details.
     */
    class PromptCacheOptions
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val mode: JsonField<Mode>,
        private val ttl: JsonField<Ttl>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
            @JsonProperty("ttl") @ExcludeMissing ttl: JsonField<Ttl> = JsonMissing.of(),
        ) : this(mode, ttl, mutableMapOf())

        /**
         * Controls whether OpenAI automatically creates an implicit cache breakpoint. Defaults to
         * `implicit`. With `implicit`, OpenAI creates one implicit breakpoint and writes up to the
         * latest three explicit breakpoints in the request. With `explicit`, OpenAI does not create
         * an implicit breakpoint and writes up to the latest four explicit breakpoints. If there
         * are no explicit breakpoints, the request does not use prompt caching.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mode(): Optional<Mode> = mode.getOptional("mode")

        /**
         * The minimum lifetime applied to every implicit and explicit cache breakpoint written by
         * the request. Defaults to `30m`, which is currently the only supported value. The backend
         * may retain cache entries for longer.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun ttl(): Optional<Ttl> = ttl.getOptional("ttl")

        /**
         * Returns the raw JSON value of [mode].
         *
         * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

        /**
         * Returns the raw JSON value of [ttl].
         *
         * Unlike [ttl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ttl") @ExcludeMissing fun _ttl(): JsonField<Ttl> = ttl

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
            collectAllProperties(additionalProperties, "mode" to this.mode, "ttl" to this.ttl)

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [PromptCacheOptions]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PromptCacheOptions]. */
        class Builder internal constructor() {

            private var mode: JsonField<Mode> = JsonMissing.of()
            private var ttl: JsonField<Ttl> = JsonField.of(Ttl._30M)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(promptCacheOptions: PromptCacheOptions) = apply {
                mode = promptCacheOptions.mode
                ttl = promptCacheOptions.ttl
                additionalProperties = promptCacheOptions.additionalProperties.toMutableMap()
            }

            /**
             * Controls whether OpenAI automatically creates an implicit cache breakpoint. Defaults
             * to `implicit`. With `implicit`, OpenAI creates one implicit breakpoint and writes up
             * to the latest three explicit breakpoints in the request. With `explicit`, OpenAI does
             * not create an implicit breakpoint and writes up to the latest four explicit
             * breakpoints. If there are no explicit breakpoints, the request does not use prompt
             * caching.
             */
            fun mode(mode: Mode?) = mode(JsonField.ofNullable(mode))

            /** Alias for calling [Builder.mode] with `mode.orElse(null)`. */
            fun mode(mode: Optional<Mode>) = mode(mode.getOrNull())

            /**
             * Sets [Builder.mode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mode] with a well-typed [Mode] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

            /**
             * The minimum lifetime applied to every implicit and explicit cache breakpoint written
             * by the request. Defaults to `30m`, which is currently the only supported value. The
             * backend may retain cache entries for longer.
             */
            fun ttl(ttl: Ttl) = ttl(JsonField.of(ttl))

            /**
             * Sets [Builder.ttl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ttl] with a well-typed [Ttl] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun ttl(ttl: JsonField<Ttl>) = apply { this.ttl = ttl }

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
             * Returns an immutable instance of [PromptCacheOptions].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): PromptCacheOptions =
                PromptCacheOptions(mode, ttl, additionalProperties.toMutableMap())
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
        fun validate(): PromptCacheOptions = apply {
            if (validated) {
                return@apply
            }

            mode().ifPresent { it.validate() }
            ttl().ifPresent { it.validate() }
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
            (mode.asKnown().getOrNull()?.validity() ?: 0) +
                (ttl.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Controls whether OpenAI automatically creates an implicit cache breakpoint. Defaults to
         * `implicit`. With `implicit`, OpenAI creates one implicit breakpoint and writes up to the
         * latest three explicit breakpoints in the request. With `explicit`, OpenAI does not create
         * an implicit breakpoint and writes up to the latest four explicit breakpoints. If there
         * are no explicit breakpoints, the request does not use prompt caching.
         */
        class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val IMPLICIT = of("implicit")

                @JvmField val EXPLICIT = of("explicit")

                @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
            }

            /** An enum containing [Mode]'s known values. */
            enum class Known {
                IMPLICIT,
                EXPLICIT,
            }

            /**
             * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Mode] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IMPLICIT,
                EXPLICIT,
                /** An enum member indicating that [Mode] was instantiated with an unknown value. */
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
                    IMPLICIT -> Value.IMPLICIT
                    EXPLICIT -> Value.EXPLICIT
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
                    IMPLICIT -> Known.IMPLICIT
                    EXPLICIT -> Known.EXPLICIT
                    else -> throw OpenAIInvalidDataException("Unknown Mode: $value")
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
            fun validate(): Mode = apply {
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

                return other is Mode && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * The minimum lifetime applied to every implicit and explicit cache breakpoint written by
         * the request. Defaults to `30m`, which is currently the only supported value. The backend
         * may retain cache entries for longer.
         */
        class Ttl @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val _30M = of("30m")

                @JvmStatic fun of(value: String) = Ttl(JsonField.of(value))
            }

            /** An enum containing [Ttl]'s known values. */
            enum class Known {
                _30M
            }

            /**
             * An enum containing [Ttl]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Ttl] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                _30M,
                /** An enum member indicating that [Ttl] was instantiated with an unknown value. */
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
                    _30M -> Value._30M
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
                    _30M -> Known._30M
                    else -> throw OpenAIInvalidDataException("Unknown Ttl: $value")
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
            fun validate(): Ttl = apply {
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

                return other is Ttl && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PromptCacheOptions &&
                mode == other.mode &&
                ttl == other.ttl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(mode, ttl, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PromptCacheOptions{mode=$mode, ttl=$ttl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "DecisionCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
