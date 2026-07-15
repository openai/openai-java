// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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
import com.openai.models.completions.CompletionUsage
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents a chat completion response returned by model, based on the provided input. */
class ChatCompletion
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val choices: JsonField<List<Choice>>,
    private val created: JsonField<Long>,
    private val model: JsonField<String>,
    private val object_: JsonValue,
    private val moderation: JsonField<Moderation>,
    private val serviceTier: JsonField<ServiceTier>,
    private val systemFingerprint: JsonField<String>,
    private val usage: JsonField<CompletionUsage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("choices")
        @ExcludeMissing
        choices: JsonField<List<Choice>> = JsonMissing.of(),
        @JsonProperty("created") @ExcludeMissing created: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("moderation")
        @ExcludeMissing
        moderation: JsonField<Moderation> = JsonMissing.of(),
        @JsonProperty("service_tier")
        @ExcludeMissing
        serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
        @JsonProperty("system_fingerprint")
        @ExcludeMissing
        systemFingerprint: JsonField<String> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<CompletionUsage> = JsonMissing.of(),
    ) : this(
        id,
        choices,
        created,
        model,
        object_,
        moderation,
        serviceTier,
        systemFingerprint,
        usage,
        mutableMapOf(),
    )

    /**
     * A unique identifier for the chat completion.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * A list of chat completion choices. Can be more than one if `n` is greater than 1.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun choices(): List<Choice> = choices.getRequired("choices")

    /**
     * The Unix timestamp (in seconds) of when the chat completion was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun created(): Long = created.getRequired("created")

    /**
     * The model used for the chat completion.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The object type, which is always `chat.completion`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("chat.completion")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Moderation results for the request input and generated output, if moderated completions were
     * requested.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun moderation(): Optional<Moderation> = moderation.getOptional("moderation")

    /**
     * Specifies the processing type used for serving the request.
     * - If set to 'auto', then the request will be processed with the service tier configured in
     *   the Project settings. Unless otherwise configured, the Project will use 'default'.
     * - If set to 'default', then the request will be processed with the standard pricing and
     *   performance for the selected model.
     * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or
     *   '[priority](https://openai.com/api-priority-processing/)', then the request will be
     *   processed with the corresponding service tier.
     * - When not set, the default behavior is 'auto'.
     *
     *   When the `service_tier` parameter is set, the response body will include the `service_tier`
     *   value based on the processing mode actually used to serve the request. This response value
     *   may be different from the value set in the parameter.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serviceTier(): Optional<ServiceTier> = serviceTier.getOptional("service_tier")

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    @Deprecated("deprecated")
    fun systemFingerprint(): Optional<String> = systemFingerprint.getOptional("system_fingerprint")

    /**
     * Usage statistics for the completion request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<CompletionUsage> = usage.getOptional("usage")

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
     * Returns the raw JSON value of [moderation].
     *
     * Unlike [moderation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("moderation")
    @ExcludeMissing
    fun _moderation(): JsonField<Moderation> = moderation

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
    @Deprecated("deprecated")
    @JsonProperty("system_fingerprint")
    @ExcludeMissing
    fun _systemFingerprint(): JsonField<String> = systemFingerprint

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<CompletionUsage> = usage

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
         * Returns a mutable builder for constructing an instance of [ChatCompletion].
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

    /** A builder for [ChatCompletion]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var choices: JsonField<MutableList<Choice>>? = null
        private var created: JsonField<Long>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("chat.completion")
        private var moderation: JsonField<Moderation> = JsonMissing.of()
        private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
        private var systemFingerprint: JsonField<String> = JsonMissing.of()
        private var usage: JsonField<CompletionUsage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletion: ChatCompletion) = apply {
            id = chatCompletion.id
            choices = chatCompletion.choices.map { it.toMutableList() }
            created = chatCompletion.created
            model = chatCompletion.model
            object_ = chatCompletion.object_
            moderation = chatCompletion.moderation
            serviceTier = chatCompletion.serviceTier
            systemFingerprint = chatCompletion.systemFingerprint
            usage = chatCompletion.usage
            additionalProperties = chatCompletion.additionalProperties.toMutableMap()
        }

        /** A unique identifier for the chat completion. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
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

        /** The Unix timestamp (in seconds) of when the chat completion was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /**
         * Sets [Builder.created] to an arbitrary JSON value.
         *
         * You should usually call [Builder.created] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The model used for the chat completion. */
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
         * JsonValue.from("chat.completion")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * Moderation results for the request input and generated output, if moderated completions
         * were requested.
         */
        fun moderation(moderation: Moderation?) = moderation(JsonField.ofNullable(moderation))

        /** Alias for calling [Builder.moderation] with `moderation.orElse(null)`. */
        fun moderation(moderation: Optional<Moderation>) = moderation(moderation.getOrNull())

        /**
         * Sets [Builder.moderation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.moderation] with a well-typed [Moderation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun moderation(moderation: JsonField<Moderation>) = apply { this.moderation = moderation }

        /**
         * Specifies the processing type used for serving the request.
         * - If set to 'auto', then the request will be processed with the service tier configured
         *   in the Project settings. Unless otherwise configured, the Project will use 'default'.
         * - If set to 'default', then the request will be processed with the standard pricing and
         *   performance for the selected model.
         * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or
         *   '[priority](https://openai.com/api-priority-processing/)', then the request will be
         *   processed with the corresponding service tier.
         * - When not set, the default behavior is 'auto'.
         *
         *   When the `service_tier` parameter is set, the response body will include the
         *   `service_tier` value based on the processing mode actually used to serve the request.
         *   This response value may be different from the value set in the parameter.
         */
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
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        @Deprecated("deprecated")
        fun systemFingerprint(systemFingerprint: String) =
            systemFingerprint(JsonField.of(systemFingerprint))

        /**
         * Sets [Builder.systemFingerprint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.systemFingerprint] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        @Deprecated("deprecated")
        fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
            this.systemFingerprint = systemFingerprint
        }

        /** Usage statistics for the completion request. */
        fun usage(usage: CompletionUsage) = usage(JsonField.of(usage))

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
         * Returns an immutable instance of [ChatCompletion].
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
        fun build(): ChatCompletion =
            ChatCompletion(
                checkRequired("id", id),
                checkRequired("choices", choices).map { it.toImmutable() },
                checkRequired("created", created),
                checkRequired("model", model),
                object_,
                moderation,
                serviceTier,
                systemFingerprint,
                usage,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ChatCompletion = apply {
        if (validated) {
            return@apply
        }

        id()
        choices().forEach { it.validate() }
        created()
        model()
        _object_().let {
            if (it != JsonValue.from("chat.completion")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        moderation().ifPresent { it.validate() }
        serviceTier().ifPresent { it.validate() }
        systemFingerprint()
        usage().ifPresent { it.validate() }
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
            (choices.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (created.asKnown().isPresent) 1 else 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("chat.completion")) 1 else 0 } +
            (moderation.asKnown().getOrNull()?.validity() ?: 0) +
            (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
            (if (systemFingerprint.asKnown().isPresent) 1 else 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0)

    class Choice
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val finishReason: JsonField<FinishReason>,
        private val index: JsonField<Long>,
        private val logprobs: JsonField<Logprobs>,
        private val message: JsonField<ChatCompletionMessage>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("finish_reason")
            @ExcludeMissing
            finishReason: JsonField<FinishReason> = JsonMissing.of(),
            @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("logprobs")
            @ExcludeMissing
            logprobs: JsonField<Logprobs> = JsonMissing.of(),
            @JsonProperty("message")
            @ExcludeMissing
            message: JsonField<ChatCompletionMessage> = JsonMissing.of(),
        ) : this(finishReason, index, logprobs, message, mutableMapOf())

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function. Read the
         * [Model Spec](https://model-spec.openai.com/2025-12-18.html) for more.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun finishReason(): FinishReason = finishReason.getRequired("finish_reason")

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
        fun logprobs(): Optional<Logprobs> = logprobs.getOptional("logprobs")

        /**
         * A chat completion message generated by the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): ChatCompletionMessage = message.getRequired("message")

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

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message")
        @ExcludeMissing
        fun _message(): JsonField<ChatCompletionMessage> = message

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
             * .finishReason()
             * .index()
             * .logprobs()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Choice]. */
        class Builder internal constructor() {

            private var finishReason: JsonField<FinishReason>? = null
            private var index: JsonField<Long>? = null
            private var logprobs: JsonField<Logprobs>? = null
            private var message: JsonField<ChatCompletionMessage>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(choice: Choice) = apply {
                finishReason = choice.finishReason
                index = choice.index
                logprobs = choice.logprobs
                message = choice.message
                additionalProperties = choice.additionalProperties.toMutableMap()
            }

            /**
             * The reason the model stopped generating tokens. This will be `stop` if the model hit
             * a natural stop point or a provided stop sequence, `length` if the maximum number of
             * tokens specified in the request was reached, `content_filter` if content was omitted
             * due to a flag from our content filters, `tool_calls` if the model called a tool, or
             * `function_call` (deprecated) if the model called a function. Read the
             * [Model Spec](https://model-spec.openai.com/2025-12-18.html) for more.
             */
            fun finishReason(finishReason: FinishReason) = finishReason(JsonField.of(finishReason))

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

            /** A chat completion message generated by the model. */
            fun message(message: ChatCompletionMessage) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [ChatCompletionMessage]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun message(message: JsonField<ChatCompletionMessage>) = apply {
                this.message = message
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
             * Returns an immutable instance of [Choice].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .finishReason()
             * .index()
             * .logprobs()
             * .message()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Choice =
                Choice(
                    checkRequired("finishReason", finishReason),
                    checkRequired("index", index),
                    checkRequired("logprobs", logprobs),
                    checkRequired("message", message),
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
        fun validate(): Choice = apply {
            if (validated) {
                return@apply
            }

            finishReason().validate()
            index()
            logprobs().ifPresent { it.validate() }
            message().validate()
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
            (finishReason.asKnown().getOrNull()?.validity() ?: 0) +
                (if (index.asKnown().isPresent) 1 else 0) +
                (logprobs.asKnown().getOrNull()?.validity() ?: 0) +
                (message.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function. Read the
         * [Model Spec](https://model-spec.openai.com/2025-12-18.html) for more.
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
            fun validate(): FinishReason = apply {
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

                return other is FinishReason && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Log probability information for the choice. */
        class Logprobs
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val content: JsonField<List<ChatCompletionTokenLogprob>>,
            private val refusal: JsonField<List<ChatCompletionTokenLogprob>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("content")
                @ExcludeMissing
                content: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of(),
                @JsonProperty("refusal")
                @ExcludeMissing
                refusal: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of(),
            ) : this(content, refusal, mutableMapOf())

            /**
             * A list of message content tokens with log probability information.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun content(): Optional<List<ChatCompletionTokenLogprob>> =
                content.getOptional("content")

            /**
             * A list of message refusal tokens with log probability information.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun refusal(): Optional<List<ChatCompletionTokenLogprob>> =
                refusal.getOptional("refusal")

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
            fun validate(): Logprobs = apply {
                if (validated) {
                    return@apply
                }

                content().ifPresent { it.forEach { it.validate() } }
                refusal().ifPresent { it.forEach { it.validate() } }
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
                (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (refusal.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Logprobs &&
                    content == other.content &&
                    refusal == other.refusal &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(content, refusal, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Logprobs{content=$content, refusal=$refusal, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Choice &&
                finishReason == other.finishReason &&
                index == other.index &&
                logprobs == other.logprobs &&
                message == other.message &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(finishReason, index, logprobs, message, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Choice{finishReason=$finishReason, index=$index, logprobs=$logprobs, message=$message, additionalProperties=$additionalProperties}"
    }

    /**
     * Moderation results for the request input and generated output, if moderated completions were
     * requested.
     */
    class Moderation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val input: JsonField<Input>,
        private val output: JsonField<Output>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<Output> = JsonMissing.of(),
        ) : this(input, output, mutableMapOf())

        /**
         * Moderation for the request input.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): Input = input.getRequired("input")

        /**
         * Moderation for the generated output.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun output(): Output = output.getRequired("output")

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<Output> = output

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
             * Returns a mutable builder for constructing an instance of [Moderation].
             *
             * The following fields are required:
             * ```java
             * .input()
             * .output()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Moderation]. */
        class Builder internal constructor() {

            private var input: JsonField<Input>? = null
            private var output: JsonField<Output>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(moderation: Moderation) = apply {
                input = moderation.input
                output = moderation.output
                additionalProperties = moderation.additionalProperties.toMutableMap()
            }

            /** Moderation for the request input. */
            fun input(input: Input) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [Input] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** Alias for calling [input] with `Input.ofModerationResults(moderationResults)`. */
            fun input(moderationResults: Input.ModerationResults) =
                input(Input.ofModerationResults(moderationResults))

            /** Alias for calling [input] with `Input.ofError(error)`. */
            fun input(error: Input.Error) = input(Input.ofError(error))

            /** Moderation for the generated output. */
            fun output(output: Output) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [Output] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<Output>) = apply { this.output = output }

            /** Alias for calling [output] with `Output.ofModerationResults(moderationResults)`. */
            fun output(moderationResults: Output.ModerationResults) =
                output(Output.ofModerationResults(moderationResults))

            /** Alias for calling [output] with `Output.ofError(error)`. */
            fun output(error: Output.Error) = output(Output.ofError(error))

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
             * Returns an immutable instance of [Moderation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .input()
             * .output()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Moderation =
                Moderation(
                    checkRequired("input", input),
                    checkRequired("output", output),
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
        fun validate(): Moderation = apply {
            if (validated) {
                return@apply
            }

            input().validate()
            output().validate()
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
                (output.asKnown().getOrNull()?.validity() ?: 0)

        /** Moderation for the request input. */
        @JsonDeserialize(using = Input.Deserializer::class)
        @JsonSerialize(using = Input.Serializer::class)
        class Input
        private constructor(
            private val moderationResults: ModerationResults? = null,
            private val error: Error? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Successful moderation results for the request input or generated output. */
            fun moderationResults(): Optional<ModerationResults> =
                Optional.ofNullable(moderationResults)

            /** An error produced while attempting moderation. */
            fun error(): Optional<Error> = Optional.ofNullable(error)

            fun isModerationResults(): Boolean = moderationResults != null

            fun isError(): Boolean = error != null

            /** Successful moderation results for the request input or generated output. */
            fun asModerationResults(): ModerationResults =
                moderationResults.getOrThrow("moderationResults")

            /** An error produced while attempting moderation. */
            fun asError(): Error = error.getOrThrow("error")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = input.accept(new Input.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitModerationResults(ModerationResults moderationResults) {
             *         return Optional.of(moderationResults.toString());
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
                    moderationResults != null -> visitor.visitModerationResults(moderationResults)
                    error != null -> visitor.visitError(error)
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Input = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitModerationResults(moderationResults: ModerationResults) {
                            moderationResults.validate()
                        }

                        override fun visitError(error: Error) {
                            error.validate()
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
                        override fun visitModerationResults(moderationResults: ModerationResults) =
                            moderationResults.validity()

                        override fun visitError(error: Error) = error.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Input &&
                    moderationResults == other.moderationResults &&
                    error == other.error
            }

            override fun hashCode(): Int = Objects.hash(moderationResults, error)

            override fun toString(): String =
                when {
                    moderationResults != null -> "Input{moderationResults=$moderationResults}"
                    error != null -> "Input{error=$error}"
                    _json != null -> "Input{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Input")
                }

            companion object {

                /** Successful moderation results for the request input or generated output. */
                @JvmStatic
                fun ofModerationResults(moderationResults: ModerationResults) =
                    Input(moderationResults = moderationResults)

                /** An error produced while attempting moderation. */
                @JvmStatic fun ofError(error: Error) = Input(error = error)
            }

            /**
             * An interface that defines how to map each variant of [Input] to a value of type [T].
             */
            interface Visitor<out T> {

                /** Successful moderation results for the request input or generated output. */
                fun visitModerationResults(moderationResults: ModerationResults): T

                /** An error produced while attempting moderation. */
                fun visitError(error: Error): T

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
                    throw OpenAIInvalidDataException("Unknown Input: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Input>(Input::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Input {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "moderation_results" -> {
                            return tryDeserialize(node, jacksonTypeRef<ModerationResults>())?.let {
                                Input(moderationResults = it, _json = json)
                            } ?: Input(_json = json)
                        }
                        "error" -> {
                            return tryDeserialize(node, jacksonTypeRef<Error>())?.let {
                                Input(error = it, _json = json)
                            } ?: Input(_json = json)
                        }
                    }

                    return Input(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Input>(Input::class) {

                override fun serialize(
                    value: Input,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.moderationResults != null ->
                            generator.writeObject(value.moderationResults)
                        value.error != null -> generator.writeObject(value.error)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Input")
                    }
                }
            }

            /** Successful moderation results for the request input or generated output. */
            class ModerationResults
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val model: JsonField<String>,
                private val results: JsonField<List<Result>>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("results")
                    @ExcludeMissing
                    results: JsonField<List<Result>> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(model, results, type, mutableMapOf())

                /**
                 * The moderation model used to generate the results.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun model(): String = model.getRequired("model")

                /**
                 * A list of moderation results.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun results(): List<Result> = results.getRequired("results")

                /**
                 * The object type, which is always `moderation_results`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("moderation_results")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

                /**
                 * Returns the raw JSON value of [results].
                 *
                 * Unlike [results], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("results")
                @ExcludeMissing
                fun _results(): JsonField<List<Result>> = results

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
                     * Returns a mutable builder for constructing an instance of
                     * [ModerationResults].
                     *
                     * The following fields are required:
                     * ```java
                     * .model()
                     * .results()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ModerationResults]. */
                class Builder internal constructor() {

                    private var model: JsonField<String>? = null
                    private var results: JsonField<MutableList<Result>>? = null
                    private var type: JsonValue = JsonValue.from("moderation_results")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(moderationResults: ModerationResults) = apply {
                        model = moderationResults.model
                        results = moderationResults.results.map { it.toMutableList() }
                        type = moderationResults.type
                        additionalProperties = moderationResults.additionalProperties.toMutableMap()
                    }

                    /** The moderation model used to generate the results. */
                    fun model(model: String) = model(JsonField.of(model))

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    /** A list of moderation results. */
                    fun results(results: List<Result>) = results(JsonField.of(results))

                    /**
                     * Sets [Builder.results] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.results] with a well-typed `List<Result>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun results(results: JsonField<List<Result>>) = apply {
                        this.results = results.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Result] to [results].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addResult(result: Result) = apply {
                        results =
                            (results ?: JsonField.of(mutableListOf())).also {
                                checkKnown("results", it).add(result)
                            }
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("moderation_results")
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
                     * Returns an immutable instance of [ModerationResults].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .model()
                     * .results()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ModerationResults =
                        ModerationResults(
                            checkRequired("model", model),
                            checkRequired("results", results).map { it.toImmutable() },
                            type,
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
                fun validate(): ModerationResults = apply {
                    if (validated) {
                        return@apply
                    }

                    model()
                    results().forEach { it.validate() }
                    _type().let {
                        if (it != JsonValue.from("moderation_results")) {
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
                    (if (model.asKnown().isPresent) 1 else 0) +
                        (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                        type.let { if (it == JsonValue.from("moderation_results")) 1 else 0 }

                /** A moderation result produced for the response input or output. */
                class Result
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val categories: JsonField<Categories>,
                    private val categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>,
                    private val categoryScores: JsonField<CategoryScores>,
                    private val flagged: JsonField<Boolean>,
                    private val model: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("categories")
                        @ExcludeMissing
                        categories: JsonField<Categories> = JsonMissing.of(),
                        @JsonProperty("category_applied_input_types")
                        @ExcludeMissing
                        categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes> =
                            JsonMissing.of(),
                        @JsonProperty("category_scores")
                        @ExcludeMissing
                        categoryScores: JsonField<CategoryScores> = JsonMissing.of(),
                        @JsonProperty("flagged")
                        @ExcludeMissing
                        flagged: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("model")
                        @ExcludeMissing
                        model: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(
                        categories,
                        categoryAppliedInputTypes,
                        categoryScores,
                        flagged,
                        model,
                        type,
                        mutableMapOf(),
                    )

                    /**
                     * A dictionary of moderation categories to booleans, True if the input is
                     * flagged under this category.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun categories(): Categories = categories.getRequired("categories")

                    /**
                     * Which modalities of input are reflected by the score for each category.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun categoryAppliedInputTypes(): CategoryAppliedInputTypes =
                        categoryAppliedInputTypes.getRequired("category_applied_input_types")

                    /**
                     * A dictionary of moderation categories to scores.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun categoryScores(): CategoryScores =
                        categoryScores.getRequired("category_scores")

                    /**
                     * A boolean indicating whether the content was flagged by any category.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun flagged(): Boolean = flagged.getRequired("flagged")

                    /**
                     * The moderation model that produced this result.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun model(): String = model.getRequired("model")

                    /**
                     * The object type, which was always `moderation_result` for successful
                     * moderation results.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("moderation_result")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [categories].
                     *
                     * Unlike [categories], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("categories")
                    @ExcludeMissing
                    fun _categories(): JsonField<Categories> = categories

                    /**
                     * Returns the raw JSON value of [categoryAppliedInputTypes].
                     *
                     * Unlike [categoryAppliedInputTypes], this method doesn't throw if the JSON
                     * field has an unexpected type.
                     */
                    @JsonProperty("category_applied_input_types")
                    @ExcludeMissing
                    fun _categoryAppliedInputTypes(): JsonField<CategoryAppliedInputTypes> =
                        categoryAppliedInputTypes

                    /**
                     * Returns the raw JSON value of [categoryScores].
                     *
                     * Unlike [categoryScores], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("category_scores")
                    @ExcludeMissing
                    fun _categoryScores(): JsonField<CategoryScores> = categoryScores

                    /**
                     * Returns the raw JSON value of [flagged].
                     *
                     * Unlike [flagged], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("flagged")
                    @ExcludeMissing
                    fun _flagged(): JsonField<Boolean> = flagged

                    /**
                     * Returns the raw JSON value of [model].
                     *
                     * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                         * Returns a mutable builder for constructing an instance of [Result].
                         *
                         * The following fields are required:
                         * ```java
                         * .categories()
                         * .categoryAppliedInputTypes()
                         * .categoryScores()
                         * .flagged()
                         * .model()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Result]. */
                    class Builder internal constructor() {

                        private var categories: JsonField<Categories>? = null
                        private var categoryAppliedInputTypes:
                            JsonField<CategoryAppliedInputTypes>? =
                            null
                        private var categoryScores: JsonField<CategoryScores>? = null
                        private var flagged: JsonField<Boolean>? = null
                        private var model: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("moderation_result")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(result: Result) = apply {
                            categories = result.categories
                            categoryAppliedInputTypes = result.categoryAppliedInputTypes
                            categoryScores = result.categoryScores
                            flagged = result.flagged
                            model = result.model
                            type = result.type
                            additionalProperties = result.additionalProperties.toMutableMap()
                        }

                        /**
                         * A dictionary of moderation categories to booleans, True if the input is
                         * flagged under this category.
                         */
                        fun categories(categories: Categories) =
                            categories(JsonField.of(categories))

                        /**
                         * Sets [Builder.categories] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.categories] with a well-typed
                         * [Categories] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun categories(categories: JsonField<Categories>) = apply {
                            this.categories = categories
                        }

                        /**
                         * Which modalities of input are reflected by the score for each category.
                         */
                        fun categoryAppliedInputTypes(
                            categoryAppliedInputTypes: CategoryAppliedInputTypes
                        ) = categoryAppliedInputTypes(JsonField.of(categoryAppliedInputTypes))

                        /**
                         * Sets [Builder.categoryAppliedInputTypes] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.categoryAppliedInputTypes] with a
                         * well-typed [CategoryAppliedInputTypes] value instead. This method is
                         * primarily for setting the field to an undocumented or not yet supported
                         * value.
                         */
                        fun categoryAppliedInputTypes(
                            categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>
                        ) = apply { this.categoryAppliedInputTypes = categoryAppliedInputTypes }

                        /** A dictionary of moderation categories to scores. */
                        fun categoryScores(categoryScores: CategoryScores) =
                            categoryScores(JsonField.of(categoryScores))

                        /**
                         * Sets [Builder.categoryScores] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.categoryScores] with a well-typed
                         * [CategoryScores] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun categoryScores(categoryScores: JsonField<CategoryScores>) = apply {
                            this.categoryScores = categoryScores
                        }

                        /** A boolean indicating whether the content was flagged by any category. */
                        fun flagged(flagged: Boolean) = flagged(JsonField.of(flagged))

                        /**
                         * Sets [Builder.flagged] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.flagged] with a well-typed [Boolean]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun flagged(flagged: JsonField<Boolean>) = apply { this.flagged = flagged }

                        /** The moderation model that produced this result. */
                        fun model(model: String) = model(JsonField.of(model))

                        /**
                         * Sets [Builder.model] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.model] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun model(model: JsonField<String>) = apply { this.model = model }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("moderation_result")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

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
                         * Returns an immutable instance of [Result].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .categories()
                         * .categoryAppliedInputTypes()
                         * .categoryScores()
                         * .flagged()
                         * .model()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Result =
                            Result(
                                checkRequired("categories", categories),
                                checkRequired(
                                    "categoryAppliedInputTypes",
                                    categoryAppliedInputTypes,
                                ),
                                checkRequired("categoryScores", categoryScores),
                                checkRequired("flagged", flagged),
                                checkRequired("model", model),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Result = apply {
                        if (validated) {
                            return@apply
                        }

                        categories().validate()
                        categoryAppliedInputTypes().validate()
                        categoryScores().validate()
                        flagged()
                        model()
                        _type().let {
                            if (it != JsonValue.from("moderation_result")) {
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
                        (categories.asKnown().getOrNull()?.validity() ?: 0) +
                            (categoryAppliedInputTypes.asKnown().getOrNull()?.validity() ?: 0) +
                            (categoryScores.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (flagged.asKnown().isPresent) 1 else 0) +
                            (if (model.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("moderation_result")) 1 else 0 }

                    /**
                     * A dictionary of moderation categories to booleans, True if the input is
                     * flagged under this category.
                     */
                    class Categories
                    @JsonCreator
                    private constructor(
                        @com.fasterxml.jackson.annotation.JsonValue
                        private val additionalProperties: Map<String, JsonValue>
                    ) {

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [Categories].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Categories]. */
                        class Builder internal constructor() {

                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(categories: Categories) = apply {
                                additionalProperties =
                                    categories.additionalProperties.toMutableMap()
                            }

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
                             * Returns an immutable instance of [Categories].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Categories = Categories(additionalProperties.toImmutable())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Categories = apply {
                            if (validated) {
                                return@apply
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            additionalProperties.count { (_, value) ->
                                !value.isNull() && !value.isMissing()
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Categories &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Categories{additionalProperties=$additionalProperties}"
                    }

                    /** Which modalities of input are reflected by the score for each category. */
                    class CategoryAppliedInputTypes
                    @JsonCreator
                    private constructor(
                        @com.fasterxml.jackson.annotation.JsonValue
                        private val additionalProperties: Map<String, JsonValue>
                    ) {

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [CategoryAppliedInputTypes].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [CategoryAppliedInputTypes]. */
                        class Builder internal constructor() {

                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(
                                categoryAppliedInputTypes: CategoryAppliedInputTypes
                            ) = apply {
                                additionalProperties =
                                    categoryAppliedInputTypes.additionalProperties.toMutableMap()
                            }

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
                             * Returns an immutable instance of [CategoryAppliedInputTypes].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): CategoryAppliedInputTypes =
                                CategoryAppliedInputTypes(additionalProperties.toImmutable())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): CategoryAppliedInputTypes = apply {
                            if (validated) {
                                return@apply
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            additionalProperties.count { (_, value) ->
                                !value.isNull() && !value.isMissing()
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is CategoryAppliedInputTypes &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "CategoryAppliedInputTypes{additionalProperties=$additionalProperties}"
                    }

                    /** A dictionary of moderation categories to scores. */
                    class CategoryScores
                    @JsonCreator
                    private constructor(
                        @com.fasterxml.jackson.annotation.JsonValue
                        private val additionalProperties: Map<String, JsonValue>
                    ) {

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [CategoryScores].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [CategoryScores]. */
                        class Builder internal constructor() {

                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(categoryScores: CategoryScores) = apply {
                                additionalProperties =
                                    categoryScores.additionalProperties.toMutableMap()
                            }

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
                             * Returns an immutable instance of [CategoryScores].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): CategoryScores =
                                CategoryScores(additionalProperties.toImmutable())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): CategoryScores = apply {
                            if (validated) {
                                return@apply
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            additionalProperties.count { (_, value) ->
                                !value.isNull() && !value.isMissing()
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is CategoryScores &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "CategoryScores{additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Result &&
                            categories == other.categories &&
                            categoryAppliedInputTypes == other.categoryAppliedInputTypes &&
                            categoryScores == other.categoryScores &&
                            flagged == other.flagged &&
                            model == other.model &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            categories,
                            categoryAppliedInputTypes,
                            categoryScores,
                            flagged,
                            model,
                            type,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Result{categories=$categories, categoryAppliedInputTypes=$categoryAppliedInputTypes, categoryScores=$categoryScores, flagged=$flagged, model=$model, type=$type, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ModerationResults &&
                        model == other.model &&
                        results == other.results &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(model, results, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ModerationResults{model=$model, results=$results, type=$type, additionalProperties=$additionalProperties}"
            }

            /** An error produced while attempting moderation. */
            class Error
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val code: JsonField<String>,
                private val message: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("code")
                    @ExcludeMissing
                    code: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("message")
                    @ExcludeMissing
                    message: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(code, message, type, mutableMapOf())

                /**
                 * The error code.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun code(): String = code.getRequired("code")

                /**
                 * The error message.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun message(): String = message.getRequired("message")

                /**
                 * The object type, which is always `error`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("error")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [code].
                 *
                 * Unlike [code], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
                     * Returns a mutable builder for constructing an instance of [Error].
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * .message()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Error]. */
                class Builder internal constructor() {

                    private var code: JsonField<String>? = null
                    private var message: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("error")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(error: Error) = apply {
                        code = error.code
                        message = error.message
                        type = error.type
                        additionalProperties = error.additionalProperties.toMutableMap()
                    }

                    /** The error code. */
                    fun code(code: String) = code(JsonField.of(code))

                    /**
                     * Sets [Builder.code] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.code] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun code(code: JsonField<String>) = apply { this.code = code }

                    /** The error message. */
                    fun message(message: String) = message(JsonField.of(message))

                    /**
                     * Sets [Builder.message] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.message] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun message(message: JsonField<String>) = apply { this.message = message }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("error")
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
                     * Returns an immutable instance of [Error].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * .message()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Error =
                        Error(
                            checkRequired("code", code),
                            checkRequired("message", message),
                            type,
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
                fun validate(): Error = apply {
                    if (validated) {
                        return@apply
                    }

                    code()
                    message()
                    _type().let {
                        if (it != JsonValue.from("error")) {
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
                    (if (code.asKnown().isPresent) 1 else 0) +
                        (if (message.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("error")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Error &&
                        code == other.code &&
                        message == other.message &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(code, message, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Error{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        /** Moderation for the generated output. */
        @JsonDeserialize(using = Output.Deserializer::class)
        @JsonSerialize(using = Output.Serializer::class)
        class Output
        private constructor(
            private val moderationResults: ModerationResults? = null,
            private val error: Error? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Successful moderation results for the request input or generated output. */
            fun moderationResults(): Optional<ModerationResults> =
                Optional.ofNullable(moderationResults)

            /** An error produced while attempting moderation. */
            fun error(): Optional<Error> = Optional.ofNullable(error)

            fun isModerationResults(): Boolean = moderationResults != null

            fun isError(): Boolean = error != null

            /** Successful moderation results for the request input or generated output. */
            fun asModerationResults(): ModerationResults =
                moderationResults.getOrThrow("moderationResults")

            /** An error produced while attempting moderation. */
            fun asError(): Error = error.getOrThrow("error")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = output.accept(new Output.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitModerationResults(ModerationResults moderationResults) {
             *         return Optional.of(moderationResults.toString());
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
                    moderationResults != null -> visitor.visitModerationResults(moderationResults)
                    error != null -> visitor.visitError(error)
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Output = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitModerationResults(moderationResults: ModerationResults) {
                            moderationResults.validate()
                        }

                        override fun visitError(error: Error) {
                            error.validate()
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
                        override fun visitModerationResults(moderationResults: ModerationResults) =
                            moderationResults.validity()

                        override fun visitError(error: Error) = error.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Output &&
                    moderationResults == other.moderationResults &&
                    error == other.error
            }

            override fun hashCode(): Int = Objects.hash(moderationResults, error)

            override fun toString(): String =
                when {
                    moderationResults != null -> "Output{moderationResults=$moderationResults}"
                    error != null -> "Output{error=$error}"
                    _json != null -> "Output{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Output")
                }

            companion object {

                /** Successful moderation results for the request input or generated output. */
                @JvmStatic
                fun ofModerationResults(moderationResults: ModerationResults) =
                    Output(moderationResults = moderationResults)

                /** An error produced while attempting moderation. */
                @JvmStatic fun ofError(error: Error) = Output(error = error)
            }

            /**
             * An interface that defines how to map each variant of [Output] to a value of type [T].
             */
            interface Visitor<out T> {

                /** Successful moderation results for the request input or generated output. */
                fun visitModerationResults(moderationResults: ModerationResults): T

                /** An error produced while attempting moderation. */
                fun visitError(error: Error): T

                /**
                 * Maps an unknown variant of [Output] to a value of type [T].
                 *
                 * An instance of [Output] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Output: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Output>(Output::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Output {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "moderation_results" -> {
                            return tryDeserialize(node, jacksonTypeRef<ModerationResults>())?.let {
                                Output(moderationResults = it, _json = json)
                            } ?: Output(_json = json)
                        }
                        "error" -> {
                            return tryDeserialize(node, jacksonTypeRef<Error>())?.let {
                                Output(error = it, _json = json)
                            } ?: Output(_json = json)
                        }
                    }

                    return Output(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Output>(Output::class) {

                override fun serialize(
                    value: Output,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.moderationResults != null ->
                            generator.writeObject(value.moderationResults)
                        value.error != null -> generator.writeObject(value.error)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Output")
                    }
                }
            }

            /** Successful moderation results for the request input or generated output. */
            class ModerationResults
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val model: JsonField<String>,
                private val results: JsonField<List<Result>>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("results")
                    @ExcludeMissing
                    results: JsonField<List<Result>> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(model, results, type, mutableMapOf())

                /**
                 * The moderation model used to generate the results.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun model(): String = model.getRequired("model")

                /**
                 * A list of moderation results.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun results(): List<Result> = results.getRequired("results")

                /**
                 * The object type, which is always `moderation_results`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("moderation_results")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

                /**
                 * Returns the raw JSON value of [results].
                 *
                 * Unlike [results], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("results")
                @ExcludeMissing
                fun _results(): JsonField<List<Result>> = results

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
                     * Returns a mutable builder for constructing an instance of
                     * [ModerationResults].
                     *
                     * The following fields are required:
                     * ```java
                     * .model()
                     * .results()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ModerationResults]. */
                class Builder internal constructor() {

                    private var model: JsonField<String>? = null
                    private var results: JsonField<MutableList<Result>>? = null
                    private var type: JsonValue = JsonValue.from("moderation_results")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(moderationResults: ModerationResults) = apply {
                        model = moderationResults.model
                        results = moderationResults.results.map { it.toMutableList() }
                        type = moderationResults.type
                        additionalProperties = moderationResults.additionalProperties.toMutableMap()
                    }

                    /** The moderation model used to generate the results. */
                    fun model(model: String) = model(JsonField.of(model))

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    /** A list of moderation results. */
                    fun results(results: List<Result>) = results(JsonField.of(results))

                    /**
                     * Sets [Builder.results] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.results] with a well-typed `List<Result>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun results(results: JsonField<List<Result>>) = apply {
                        this.results = results.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Result] to [results].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addResult(result: Result) = apply {
                        results =
                            (results ?: JsonField.of(mutableListOf())).also {
                                checkKnown("results", it).add(result)
                            }
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("moderation_results")
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
                     * Returns an immutable instance of [ModerationResults].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .model()
                     * .results()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ModerationResults =
                        ModerationResults(
                            checkRequired("model", model),
                            checkRequired("results", results).map { it.toImmutable() },
                            type,
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
                fun validate(): ModerationResults = apply {
                    if (validated) {
                        return@apply
                    }

                    model()
                    results().forEach { it.validate() }
                    _type().let {
                        if (it != JsonValue.from("moderation_results")) {
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
                    (if (model.asKnown().isPresent) 1 else 0) +
                        (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                        type.let { if (it == JsonValue.from("moderation_results")) 1 else 0 }

                /** A moderation result produced for the response input or output. */
                class Result
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val categories: JsonField<Categories>,
                    private val categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>,
                    private val categoryScores: JsonField<CategoryScores>,
                    private val flagged: JsonField<Boolean>,
                    private val model: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("categories")
                        @ExcludeMissing
                        categories: JsonField<Categories> = JsonMissing.of(),
                        @JsonProperty("category_applied_input_types")
                        @ExcludeMissing
                        categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes> =
                            JsonMissing.of(),
                        @JsonProperty("category_scores")
                        @ExcludeMissing
                        categoryScores: JsonField<CategoryScores> = JsonMissing.of(),
                        @JsonProperty("flagged")
                        @ExcludeMissing
                        flagged: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("model")
                        @ExcludeMissing
                        model: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(
                        categories,
                        categoryAppliedInputTypes,
                        categoryScores,
                        flagged,
                        model,
                        type,
                        mutableMapOf(),
                    )

                    /**
                     * A dictionary of moderation categories to booleans, True if the input is
                     * flagged under this category.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun categories(): Categories = categories.getRequired("categories")

                    /**
                     * Which modalities of input are reflected by the score for each category.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun categoryAppliedInputTypes(): CategoryAppliedInputTypes =
                        categoryAppliedInputTypes.getRequired("category_applied_input_types")

                    /**
                     * A dictionary of moderation categories to scores.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun categoryScores(): CategoryScores =
                        categoryScores.getRequired("category_scores")

                    /**
                     * A boolean indicating whether the content was flagged by any category.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun flagged(): Boolean = flagged.getRequired("flagged")

                    /**
                     * The moderation model that produced this result.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun model(): String = model.getRequired("model")

                    /**
                     * The object type, which was always `moderation_result` for successful
                     * moderation results.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("moderation_result")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [categories].
                     *
                     * Unlike [categories], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("categories")
                    @ExcludeMissing
                    fun _categories(): JsonField<Categories> = categories

                    /**
                     * Returns the raw JSON value of [categoryAppliedInputTypes].
                     *
                     * Unlike [categoryAppliedInputTypes], this method doesn't throw if the JSON
                     * field has an unexpected type.
                     */
                    @JsonProperty("category_applied_input_types")
                    @ExcludeMissing
                    fun _categoryAppliedInputTypes(): JsonField<CategoryAppliedInputTypes> =
                        categoryAppliedInputTypes

                    /**
                     * Returns the raw JSON value of [categoryScores].
                     *
                     * Unlike [categoryScores], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("category_scores")
                    @ExcludeMissing
                    fun _categoryScores(): JsonField<CategoryScores> = categoryScores

                    /**
                     * Returns the raw JSON value of [flagged].
                     *
                     * Unlike [flagged], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("flagged")
                    @ExcludeMissing
                    fun _flagged(): JsonField<Boolean> = flagged

                    /**
                     * Returns the raw JSON value of [model].
                     *
                     * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                         * Returns a mutable builder for constructing an instance of [Result].
                         *
                         * The following fields are required:
                         * ```java
                         * .categories()
                         * .categoryAppliedInputTypes()
                         * .categoryScores()
                         * .flagged()
                         * .model()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Result]. */
                    class Builder internal constructor() {

                        private var categories: JsonField<Categories>? = null
                        private var categoryAppliedInputTypes:
                            JsonField<CategoryAppliedInputTypes>? =
                            null
                        private var categoryScores: JsonField<CategoryScores>? = null
                        private var flagged: JsonField<Boolean>? = null
                        private var model: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("moderation_result")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(result: Result) = apply {
                            categories = result.categories
                            categoryAppliedInputTypes = result.categoryAppliedInputTypes
                            categoryScores = result.categoryScores
                            flagged = result.flagged
                            model = result.model
                            type = result.type
                            additionalProperties = result.additionalProperties.toMutableMap()
                        }

                        /**
                         * A dictionary of moderation categories to booleans, True if the input is
                         * flagged under this category.
                         */
                        fun categories(categories: Categories) =
                            categories(JsonField.of(categories))

                        /**
                         * Sets [Builder.categories] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.categories] with a well-typed
                         * [Categories] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun categories(categories: JsonField<Categories>) = apply {
                            this.categories = categories
                        }

                        /**
                         * Which modalities of input are reflected by the score for each category.
                         */
                        fun categoryAppliedInputTypes(
                            categoryAppliedInputTypes: CategoryAppliedInputTypes
                        ) = categoryAppliedInputTypes(JsonField.of(categoryAppliedInputTypes))

                        /**
                         * Sets [Builder.categoryAppliedInputTypes] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.categoryAppliedInputTypes] with a
                         * well-typed [CategoryAppliedInputTypes] value instead. This method is
                         * primarily for setting the field to an undocumented or not yet supported
                         * value.
                         */
                        fun categoryAppliedInputTypes(
                            categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>
                        ) = apply { this.categoryAppliedInputTypes = categoryAppliedInputTypes }

                        /** A dictionary of moderation categories to scores. */
                        fun categoryScores(categoryScores: CategoryScores) =
                            categoryScores(JsonField.of(categoryScores))

                        /**
                         * Sets [Builder.categoryScores] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.categoryScores] with a well-typed
                         * [CategoryScores] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun categoryScores(categoryScores: JsonField<CategoryScores>) = apply {
                            this.categoryScores = categoryScores
                        }

                        /** A boolean indicating whether the content was flagged by any category. */
                        fun flagged(flagged: Boolean) = flagged(JsonField.of(flagged))

                        /**
                         * Sets [Builder.flagged] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.flagged] with a well-typed [Boolean]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun flagged(flagged: JsonField<Boolean>) = apply { this.flagged = flagged }

                        /** The moderation model that produced this result. */
                        fun model(model: String) = model(JsonField.of(model))

                        /**
                         * Sets [Builder.model] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.model] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun model(model: JsonField<String>) = apply { this.model = model }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("moderation_result")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

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
                         * Returns an immutable instance of [Result].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .categories()
                         * .categoryAppliedInputTypes()
                         * .categoryScores()
                         * .flagged()
                         * .model()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Result =
                            Result(
                                checkRequired("categories", categories),
                                checkRequired(
                                    "categoryAppliedInputTypes",
                                    categoryAppliedInputTypes,
                                ),
                                checkRequired("categoryScores", categoryScores),
                                checkRequired("flagged", flagged),
                                checkRequired("model", model),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Result = apply {
                        if (validated) {
                            return@apply
                        }

                        categories().validate()
                        categoryAppliedInputTypes().validate()
                        categoryScores().validate()
                        flagged()
                        model()
                        _type().let {
                            if (it != JsonValue.from("moderation_result")) {
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
                        (categories.asKnown().getOrNull()?.validity() ?: 0) +
                            (categoryAppliedInputTypes.asKnown().getOrNull()?.validity() ?: 0) +
                            (categoryScores.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (flagged.asKnown().isPresent) 1 else 0) +
                            (if (model.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("moderation_result")) 1 else 0 }

                    /**
                     * A dictionary of moderation categories to booleans, True if the input is
                     * flagged under this category.
                     */
                    class Categories
                    @JsonCreator
                    private constructor(
                        @com.fasterxml.jackson.annotation.JsonValue
                        private val additionalProperties: Map<String, JsonValue>
                    ) {

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [Categories].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Categories]. */
                        class Builder internal constructor() {

                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(categories: Categories) = apply {
                                additionalProperties =
                                    categories.additionalProperties.toMutableMap()
                            }

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
                             * Returns an immutable instance of [Categories].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Categories = Categories(additionalProperties.toImmutable())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Categories = apply {
                            if (validated) {
                                return@apply
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            additionalProperties.count { (_, value) ->
                                !value.isNull() && !value.isMissing()
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Categories &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Categories{additionalProperties=$additionalProperties}"
                    }

                    /** Which modalities of input are reflected by the score for each category. */
                    class CategoryAppliedInputTypes
                    @JsonCreator
                    private constructor(
                        @com.fasterxml.jackson.annotation.JsonValue
                        private val additionalProperties: Map<String, JsonValue>
                    ) {

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [CategoryAppliedInputTypes].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [CategoryAppliedInputTypes]. */
                        class Builder internal constructor() {

                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(
                                categoryAppliedInputTypes: CategoryAppliedInputTypes
                            ) = apply {
                                additionalProperties =
                                    categoryAppliedInputTypes.additionalProperties.toMutableMap()
                            }

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
                             * Returns an immutable instance of [CategoryAppliedInputTypes].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): CategoryAppliedInputTypes =
                                CategoryAppliedInputTypes(additionalProperties.toImmutable())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): CategoryAppliedInputTypes = apply {
                            if (validated) {
                                return@apply
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            additionalProperties.count { (_, value) ->
                                !value.isNull() && !value.isMissing()
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is CategoryAppliedInputTypes &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "CategoryAppliedInputTypes{additionalProperties=$additionalProperties}"
                    }

                    /** A dictionary of moderation categories to scores. */
                    class CategoryScores
                    @JsonCreator
                    private constructor(
                        @com.fasterxml.jackson.annotation.JsonValue
                        private val additionalProperties: Map<String, JsonValue>
                    ) {

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [CategoryScores].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [CategoryScores]. */
                        class Builder internal constructor() {

                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(categoryScores: CategoryScores) = apply {
                                additionalProperties =
                                    categoryScores.additionalProperties.toMutableMap()
                            }

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
                             * Returns an immutable instance of [CategoryScores].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): CategoryScores =
                                CategoryScores(additionalProperties.toImmutable())
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): CategoryScores = apply {
                            if (validated) {
                                return@apply
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            additionalProperties.count { (_, value) ->
                                !value.isNull() && !value.isMissing()
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is CategoryScores &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "CategoryScores{additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Result &&
                            categories == other.categories &&
                            categoryAppliedInputTypes == other.categoryAppliedInputTypes &&
                            categoryScores == other.categoryScores &&
                            flagged == other.flagged &&
                            model == other.model &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            categories,
                            categoryAppliedInputTypes,
                            categoryScores,
                            flagged,
                            model,
                            type,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Result{categories=$categories, categoryAppliedInputTypes=$categoryAppliedInputTypes, categoryScores=$categoryScores, flagged=$flagged, model=$model, type=$type, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ModerationResults &&
                        model == other.model &&
                        results == other.results &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(model, results, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ModerationResults{model=$model, results=$results, type=$type, additionalProperties=$additionalProperties}"
            }

            /** An error produced while attempting moderation. */
            class Error
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val code: JsonField<String>,
                private val message: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("code")
                    @ExcludeMissing
                    code: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("message")
                    @ExcludeMissing
                    message: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(code, message, type, mutableMapOf())

                /**
                 * The error code.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun code(): String = code.getRequired("code")

                /**
                 * The error message.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun message(): String = message.getRequired("message")

                /**
                 * The object type, which is always `error`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("error")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [code].
                 *
                 * Unlike [code], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
                     * Returns a mutable builder for constructing an instance of [Error].
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * .message()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Error]. */
                class Builder internal constructor() {

                    private var code: JsonField<String>? = null
                    private var message: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("error")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(error: Error) = apply {
                        code = error.code
                        message = error.message
                        type = error.type
                        additionalProperties = error.additionalProperties.toMutableMap()
                    }

                    /** The error code. */
                    fun code(code: String) = code(JsonField.of(code))

                    /**
                     * Sets [Builder.code] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.code] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun code(code: JsonField<String>) = apply { this.code = code }

                    /** The error message. */
                    fun message(message: String) = message(JsonField.of(message))

                    /**
                     * Sets [Builder.message] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.message] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun message(message: JsonField<String>) = apply { this.message = message }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("error")
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
                     * Returns an immutable instance of [Error].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * .message()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Error =
                        Error(
                            checkRequired("code", code),
                            checkRequired("message", message),
                            type,
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
                fun validate(): Error = apply {
                    if (validated) {
                        return@apply
                    }

                    code()
                    message()
                    _type().let {
                        if (it != JsonValue.from("error")) {
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
                    (if (code.asKnown().isPresent) 1 else 0) +
                        (if (message.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("error")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Error &&
                        code == other.code &&
                        message == other.message &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(code, message, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Error{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Moderation &&
                input == other.input &&
                output == other.output &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(input, output, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Moderation{input=$input, output=$output, additionalProperties=$additionalProperties}"
    }

    /**
     * Specifies the processing type used for serving the request.
     * - If set to 'auto', then the request will be processed with the service tier configured in
     *   the Project settings. Unless otherwise configured, the Project will use 'default'.
     * - If set to 'default', then the request will be processed with the standard pricing and
     *   performance for the selected model.
     * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or
     *   '[priority](https://openai.com/api-priority-processing/)', then the request will be
     *   processed with the corresponding service tier.
     * - When not set, the default behavior is 'auto'.
     *
     *   When the `service_tier` parameter is set, the response body will include the `service_tier`
     *   value based on the processing mode actually used to serve the request. This response value
     *   may be different from the value set in the parameter.
     */
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

            @JvmField val AUTO = of("auto")

            @JvmField val DEFAULT = of("default")

            @JvmField val FLEX = of("flex")

            @JvmField val SCALE = of("scale")

            @JvmField val PRIORITY = of("priority")

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        /** An enum containing [ServiceTier]'s known values. */
        enum class Known {
            AUTO,
            DEFAULT,
            FLEX,
            SCALE,
            PRIORITY,
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
            AUTO,
            DEFAULT,
            FLEX,
            SCALE,
            PRIORITY,
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
                AUTO -> Value.AUTO
                DEFAULT -> Value.DEFAULT
                FLEX -> Value.FLEX
                SCALE -> Value.SCALE
                PRIORITY -> Value.PRIORITY
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
                AUTO -> Known.AUTO
                DEFAULT -> Known.DEFAULT
                FLEX -> Known.FLEX
                SCALE -> Known.SCALE
                PRIORITY -> Known.PRIORITY
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
        fun validate(): ServiceTier = apply {
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

            return other is ServiceTier && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletion &&
            id == other.id &&
            choices == other.choices &&
            created == other.created &&
            model == other.model &&
            object_ == other.object_ &&
            moderation == other.moderation &&
            serviceTier == other.serviceTier &&
            systemFingerprint == other.systemFingerprint &&
            usage == other.usage &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            choices,
            created,
            model,
            object_,
            moderation,
            serviceTier,
            systemFingerprint,
            usage,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletion{id=$id, choices=$choices, created=$created, model=$model, object_=$object_, moderation=$moderation, serviceTier=$serviceTier, systemFingerprint=$systemFingerprint, usage=$usage, additionalProperties=$additionalProperties}"
}
