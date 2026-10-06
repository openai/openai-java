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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Evaluate ordered classification and scoring questions against shared input. Answers are returned
 * in question order.
 *
 * Supply input as a string or user messages containing text and inline images. Only user messages
 * with `input_text` and `input_image` parts are supported; non-user roles, function calls, files,
 * audio, and item references are not supported. Images require a data URL, not an external URL or
 * file ID. At most 128 images are allowed across the request.
 *
 * Each question can return a refusal instead of a scored answer. A refusal has type `refusal` and
 * the corresponding question name, or null if unnamed.
 */
class DecisionCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Shared evidence, as a string or an array of user messages containing text and inline images.
     * Non-user roles, function calls, function-call outputs, files, audio, and item references are
     * not supported. At most 128 image parts are allowed across all messages in one request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): Input = body.input()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = body.model()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun questions(): List<Question> = body.questions()

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
         * - [safetyIdentifier]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Shared evidence, as a string or an array of user messages containing text and inline
         * images. Non-user roles, function calls, function-call outputs, files, audio, and item
         * references are not supported. At most 128 image parts are allowed across all messages in
         * one request.
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

        /**
         * Alias for calling [input] with `Input.ofDecisionInputMessages(decisionInputMessages)`.
         */
        fun inputOfDecisionInputMessages(decisionInputMessages: List<DecisionInputMessage>) =
            apply {
                body.inputOfDecisionInputMessages(decisionInputMessages)
            }

        fun model(model: String) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { body.model(model) }

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
        fun addPredicateQuestion(instructions: String) = apply {
            body.addPredicateQuestion(instructions)
        }

        /** Alias for calling [addQuestion] with `Question.ofChoice(choice)`. */
        fun addQuestion(choice: Question.Choice) = apply { body.addQuestion(choice) }

        /** Alias for calling [addQuestion] with `Question.ofScore(score)`. */
        fun addQuestion(score: Question.Score) = apply { body.addQuestion(score) }

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
            @JsonProperty("safety_identifier")
            @ExcludeMissing
            safetyIdentifier: JsonField<String> = JsonMissing.of(),
        ) : this(input, model, questions, safetyIdentifier, mutableMapOf())

        /**
         * Shared evidence, as a string or an array of user messages containing text and inline
         * images. Non-user roles, function calls, function-call outputs, files, audio, and item
         * references are not supported. At most 128 image parts are allowed across all messages in
         * one request.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): Input = input.getRequired("input")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): String = model.getRequired("model")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun questions(): List<Question> = questions.getRequired("questions")

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
            private var safetyIdentifier: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                input = body.input
                model = body.model
                questions = body.questions.map { it.toMutableList() }
                safetyIdentifier = body.safetyIdentifier
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Shared evidence, as a string or an array of user messages containing text and inline
             * images. Non-user roles, function calls, function-call outputs, files, audio, and item
             * references are not supported. At most 128 image parts are allowed across all messages
             * in one request.
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

            /**
             * Alias for calling [input] with
             * `Input.ofDecisionInputMessages(decisionInputMessages)`.
             */
            fun inputOfDecisionInputMessages(decisionInputMessages: List<DecisionInputMessage>) =
                input(Input.ofDecisionInputMessages(decisionInputMessages))

            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

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
                    (questions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("questions", it).add(question)
                    }
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
            fun addPredicateQuestion(instructions: String) =
                addQuestion(Question.Predicate.builder().instructions(instructions).build())

            /** Alias for calling [addQuestion] with `Question.ofChoice(choice)`. */
            fun addQuestion(choice: Question.Choice) = addQuestion(Question.ofChoice(choice))

            /** Alias for calling [addQuestion] with `Question.ofScore(score)`. */
            fun addQuestion(score: Question.Score) = addQuestion(Question.ofScore(score))

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
                (if (safetyIdentifier.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                input == other.input &&
                model == other.model &&
                questions == other.questions &&
                safetyIdentifier == other.safetyIdentifier &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(input, model, questions, safetyIdentifier, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{input=$input, model=$model, questions=$questions, safetyIdentifier=$safetyIdentifier, additionalProperties=$additionalProperties}"
    }

    /**
     * Shared evidence, as a string or an array of user messages containing text and inline images.
     * Non-user roles, function calls, function-call outputs, files, audio, and item references are
     * not supported. At most 128 image parts are allowed across all messages in one request.
     */
    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val string: String? = null,
        private val decisionInputMessages: List<DecisionInputMessage>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun decisionInputMessages(): Optional<List<DecisionInputMessage>> =
            Optional.ofNullable(decisionInputMessages)

        fun isString(): Boolean = string != null

        fun isDecisionInputMessages(): Boolean = decisionInputMessages != null

        fun asString(): String = string.getOrThrow("string")

        fun asDecisionInputMessages(): List<DecisionInputMessage> =
            decisionInputMessages.getOrThrow("decisionInputMessages")

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
                decisionInputMessages != null ->
                    visitor.visitDecisionInputMessages(decisionInputMessages)
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

                    override fun visitDecisionInputMessages(
                        decisionInputMessages: List<DecisionInputMessage>
                    ) {
                        decisionInputMessages.forEach { it.validate() }
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

                    override fun visitDecisionInputMessages(
                        decisionInputMessages: List<DecisionInputMessage>
                    ) = decisionInputMessages.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input &&
                string == other.string &&
                decisionInputMessages == other.decisionInputMessages
        }

        override fun hashCode(): Int = Objects.hash(string, decisionInputMessages)

        override fun toString(): String =
            when {
                string != null -> "Input{string=$string}"
                decisionInputMessages != null ->
                    "Input{decisionInputMessages=$decisionInputMessages}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Input(string = string)

            @JvmStatic
            fun ofDecisionInputMessages(decisionInputMessages: List<DecisionInputMessage>) =
                Input(decisionInputMessages = decisionInputMessages.toImmutable())
        }

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitDecisionInputMessages(decisionInputMessages: List<DecisionInputMessage>): T

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
                            tryDeserialize(node, jacksonTypeRef<List<DecisionInputMessage>>())
                                ?.let { Input(decisionInputMessages = it, _json = json) },
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
                    value.decisionInputMessages != null ->
                        generator.writeObject(value.decisionInputMessages)
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

        fun predicate(): Optional<Predicate> = Optional.ofNullable(predicate)

        fun choice(): Optional<Choice> = Optional.ofNullable(choice)

        fun score(): Optional<Score> = Optional.ofNullable(score)

        fun isPredicate(): Boolean = predicate != null

        fun isChoice(): Boolean = choice != null

        fun isScore(): Boolean = score != null

        fun asPredicate(): Predicate = predicate.getOrThrow("predicate")

        fun asChoice(): Choice = choice.getOrThrow("choice")

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
                score == other.score
        }

        override fun hashCode(): Int = Objects.hash(predicate, choice, score)

        override fun toString(): String =
            when {
                predicate != null -> "Question{predicate=$predicate}"
                choice != null -> "Question{choice=$choice}"
                score != null -> "Question{score=$score}"
                _json != null -> "Question{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Question")
            }

        companion object {

            @JvmStatic fun ofPredicate(predicate: Predicate) = Question(predicate = predicate)

            @JvmStatic fun ofChoice(choice: Choice) = Question(choice = choice)

            @JvmStatic fun ofScore(score: Score) = Question(score = score)
        }

        /**
         * An interface that defines how to map each variant of [Question] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitPredicate(predicate: Predicate): T

            fun visitChoice(choice: Choice): T

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

        class Predicate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val instructions: JsonField<String>,
            private val type: JsonValue,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("instructions")
                @ExcludeMissing
                instructions: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(instructions, type, name, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun instructions(): String = instructions.getRequired("instructions")

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
            fun _instructions(): JsonField<String> = instructions

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

                private var instructions: JsonField<String>? = null
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

                fun instructions(instructions: String) = instructions(JsonField.of(instructions))

                /**
                 * Sets [Builder.instructions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.instructions] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun instructions(instructions: JsonField<String>) = apply {
                    this.instructions = instructions
                }

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

                instructions()
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
                (if (instructions.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("predicate")) 1 else 0 } +
                    (if (name.asKnown().isPresent) 1 else 0)

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

        class Choice
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val choices: JsonField<List<DecisionChoiceOption>>,
            private val instructions: JsonField<String>,
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
                instructions: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(choices, instructions, type, name, mutableMapOf())

            /**
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
            fun instructions(): String = instructions.getRequired("instructions")

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
            fun _instructions(): JsonField<String> = instructions

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
                private var instructions: JsonField<String>? = null
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

                fun instructions(instructions: String) = instructions(JsonField.of(instructions))

                /**
                 * Sets [Builder.instructions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.instructions] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun instructions(instructions: JsonField<String>) = apply {
                    this.instructions = instructions
                }

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
                instructions()
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
                    (if (instructions.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("choice")) 1 else 0 } +
                    (if (name.asKnown().isPresent) 1 else 0)

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

        class Score
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val instructions: JsonField<String>,
            private val levels: JsonField<List<Level>>,
            private val type: JsonValue,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("instructions")
                @ExcludeMissing
                instructions: JsonField<String> = JsonMissing.of(),
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
            fun instructions(): String = instructions.getRequired("instructions")

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
            fun _instructions(): JsonField<String> = instructions

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

                private var instructions: JsonField<String>? = null
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

                fun instructions(instructions: String) = instructions(JsonField.of(instructions))

                /**
                 * Sets [Builder.instructions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.instructions] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun instructions(instructions: JsonField<String>) = apply {
                    this.instructions = instructions
                }

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

                instructions()
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
                (if (instructions.asKnown().isPresent) 1 else 0) +
                    (levels.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    type.let { if (it == JsonValue.from("score")) 1 else 0 } +
                    (if (name.asKnown().isPresent) 1 else 0)

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
