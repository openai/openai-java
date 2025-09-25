// File generated from our OpenAPI spec by Stainless.

package com.openai.models.completions

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

/**
 * Represents a completion response from the API. Note: both the streamed and non-streamed response
 * objects share the same shape (unlike the chat endpoint).
 */
class Completion
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val choices: JsonField<List<CompletionChoice>>,
    private val created: JsonField<Long>,
    private val model: JsonField<String>,
    private val object_: JsonValue,
    private val systemFingerprint: JsonField<String>,
    private val usage: JsonField<CompletionUsage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("choices")
        @ExcludeMissing
        choices: JsonField<List<CompletionChoice>> = JsonMissing.of(),
        @JsonProperty("created") @ExcludeMissing created: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("system_fingerprint")
        @ExcludeMissing
        systemFingerprint: JsonField<String> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<CompletionUsage> = JsonMissing.of(),
    ) : this(id, choices, created, model, object_, systemFingerprint, usage, mutableMapOf())

    /**
     * A unique identifier for the completion.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The list of completion choices the model generated for the input prompt.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun choices(): List<CompletionChoice> = choices.getRequired("choices")

    /**
     * The Unix timestamp (in seconds) of when the completion was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun created(): Long = created.getRequired("created")

    /**
     * The model used for completion.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The object type, which is always "text_completion"
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("text_completion")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
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
    @JsonProperty("choices")
    @ExcludeMissing
    fun _choices(): JsonField<List<CompletionChoice>> = choices

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
         * Returns a mutable builder for constructing an instance of [Completion].
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

    /** A builder for [Completion]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var choices: JsonField<MutableList<CompletionChoice>>? = null
        private var created: JsonField<Long>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("text_completion")
        private var systemFingerprint: JsonField<String> = JsonMissing.of()
        private var usage: JsonField<CompletionUsage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completion: Completion) = apply {
            id = completion.id
            choices = completion.choices.map { it.toMutableList() }
            created = completion.created
            model = completion.model
            object_ = completion.object_
            systemFingerprint = completion.systemFingerprint
            usage = completion.usage
            additionalProperties = completion.additionalProperties.toMutableMap()
        }

        /** A unique identifier for the completion. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The list of completion choices the model generated for the input prompt. */
        fun choices(choices: List<CompletionChoice>) = choices(JsonField.of(choices))

        /**
         * Sets [Builder.choices] to an arbitrary JSON value.
         *
         * You should usually call [Builder.choices] with a well-typed `List<CompletionChoice>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun choices(choices: JsonField<List<CompletionChoice>>) = apply {
            this.choices = choices.map { it.toMutableList() }
        }

        /**
         * Adds a single [CompletionChoice] to [choices].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addChoice(choice: CompletionChoice) = apply {
            choices =
                (choices ?: JsonField.of(mutableListOf())).also {
                    checkKnown("choices", it).add(choice)
                }
        }

        /** The Unix timestamp (in seconds) of when the completion was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /**
         * Sets [Builder.created] to an arbitrary JSON value.
         *
         * You should usually call [Builder.created] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The model used for completion. */
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
         * JsonValue.from("text_completion")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
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
         * Returns an immutable instance of [Completion].
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
        fun build(): Completion =
            Completion(
                checkRequired("id", id),
                checkRequired("choices", choices).map { it.toImmutable() },
                checkRequired("created", created),
                checkRequired("model", model),
                object_,
                systemFingerprint,
                usage,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Completion = apply {
        if (validated) {
            return@apply
        }

        id()
        choices().forEach { it.validate() }
        created()
        model()
        _object_().let {
            if (it != JsonValue.from("text_completion")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
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
            object_.let { if (it == JsonValue.from("text_completion")) 1 else 0 } +
            (if (systemFingerprint.asKnown().isPresent) 1 else 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Completion &&
            id == other.id &&
            choices == other.choices &&
            created == other.created &&
            model == other.model &&
            object_ == other.object_ &&
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
            systemFingerprint,
            usage,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Completion{id=$id, choices=$choices, created=$created, model=$model, object_=$object_, systemFingerprint=$systemFingerprint, usage=$usage, additionalProperties=$additionalProperties}"
}
