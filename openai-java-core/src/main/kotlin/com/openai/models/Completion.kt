// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Represents a completion response from the API. Note: both the streamed and non-streamed response
 * objects share the same shape (unlike the chat endpoint).
 */
@JsonDeserialize(builder = Completion.Builder::class)
@NoAutoDetect
class Completion
private constructor(
    private val id: JsonField<String>,
    private val choices: JsonField<List<CompletionChoice>>,
    private val created: JsonField<Long>,
    private val model: JsonField<String>,
    private val systemFingerprint: JsonField<String>,
    private val object_: JsonField<Object>,
    private val usage: JsonField<CompletionUsage>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** A unique identifier for the completion. */
    fun id(): String = id.getRequired("id")

    /** The list of completion choices the model generated for the input prompt. */
    fun choices(): List<CompletionChoice> = choices.getRequired("choices")

    /** The Unix timestamp (in seconds) of when the completion was created. */
    fun created(): Long = created.getRequired("created")

    /** The model used for completion. */
    fun model(): String = model.getRequired("model")

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     */
    fun systemFingerprint(): Optional<String> =
        Optional.ofNullable(systemFingerprint.getNullable("system_fingerprint"))

    /** The object type, which is always "text_completion" */
    fun object_(): Object = object_.getRequired("object")

    /** Usage statistics for the completion request. */
    fun usage(): Optional<CompletionUsage> = Optional.ofNullable(usage.getNullable("usage"))

    /** A unique identifier for the completion. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The list of completion choices the model generated for the input prompt. */
    @JsonProperty("choices") @ExcludeMissing fun _choices() = choices

    /** The Unix timestamp (in seconds) of when the completion was created. */
    @JsonProperty("created") @ExcludeMissing fun _created() = created

    /** The model used for completion. */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     */
    @JsonProperty("system_fingerprint") @ExcludeMissing fun _systemFingerprint() = systemFingerprint

    /** The object type, which is always "text_completion" */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** Usage statistics for the completion request. */
    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Completion = apply {
        if (!validated) {
            id()
            choices().forEach { it.validate() }
            created()
            model()
            systemFingerprint()
            object_()
            usage().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var choices: JsonField<List<CompletionChoice>> = JsonMissing.of()
        private var created: JsonField<Long> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var systemFingerprint: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var usage: JsonField<CompletionUsage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completion: Completion) = apply {
            this.id = completion.id
            this.choices = completion.choices
            this.created = completion.created
            this.model = completion.model
            this.systemFingerprint = completion.systemFingerprint
            this.object_ = completion.object_
            this.usage = completion.usage
            additionalProperties(completion.additionalProperties)
        }

        /** A unique identifier for the completion. */
        fun id(id: String) = id(JsonField.of(id))

        /** A unique identifier for the completion. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The list of completion choices the model generated for the input prompt. */
        fun choices(choices: List<CompletionChoice>) = choices(JsonField.of(choices))

        /** The list of completion choices the model generated for the input prompt. */
        @JsonProperty("choices")
        @ExcludeMissing
        fun choices(choices: JsonField<List<CompletionChoice>>) = apply { this.choices = choices }

        /** The Unix timestamp (in seconds) of when the completion was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /** The Unix timestamp (in seconds) of when the completion was created. */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The model used for completion. */
        fun model(model: String) = model(JsonField.of(model))

        /** The model used for completion. */
        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        fun systemFingerprint(systemFingerprint: String) =
            systemFingerprint(JsonField.of(systemFingerprint))

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        @JsonProperty("system_fingerprint")
        @ExcludeMissing
        fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
            this.systemFingerprint = systemFingerprint
        }

        /** The object type, which is always "text_completion" */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "text_completion" */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** Usage statistics for the completion request. */
        fun usage(usage: CompletionUsage) = usage(JsonField.of(usage))

        /** Usage statistics for the completion request. */
        @JsonProperty("usage")
        @ExcludeMissing
        fun usage(usage: JsonField<CompletionUsage>) = apply { this.usage = usage }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): Completion =
            Completion(
                id,
                choices.map { it.toImmutable() },
                created,
                model,
                systemFingerprint,
                object_,
                usage,
                additionalProperties.toImmutable(),
            )
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val TEXT_COMPLETION = Object(JsonField.of("text_completion"))

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            TEXT_COMPLETION,
        }

        enum class Value {
            TEXT_COMPLETION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TEXT_COMPLETION -> Value.TEXT_COMPLETION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TEXT_COMPLETION -> Known.TEXT_COMPLETION
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Completion && id == other.id && choices == other.choices && created == other.created && model == other.model && systemFingerprint == other.systemFingerprint && object_ == other.object_ && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, choices, created, model, systemFingerprint, object_, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Completion{id=$id, choices=$choices, created=$created, model=$model, systemFingerprint=$systemFingerprint, object_=$object_, usage=$usage, additionalProperties=$additionalProperties}"
}
