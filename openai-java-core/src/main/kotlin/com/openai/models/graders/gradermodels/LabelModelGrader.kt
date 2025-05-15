// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

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
import com.openai.models.EvalItem
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** A LabelModelGrader object which uses a model to assign labels to each item in the evaluation. */
class LabelModelGrader
private constructor(
    private val input: JsonField<List<EvalItem>>,
    private val labels: JsonField<List<String>>,
    private val model: JsonField<String>,
    private val name: JsonField<String>,
    private val passingLabels: JsonField<List<String>>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input") @ExcludeMissing input: JsonField<List<EvalItem>> = JsonMissing.of(),
        @JsonProperty("labels") @ExcludeMissing labels: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("passing_labels")
        @ExcludeMissing
        passingLabels: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(input, labels, model, name, passingLabels, type, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): List<EvalItem> = input.getRequired("input")

    /**
     * The labels to assign to each item in the evaluation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun labels(): List<String> = labels.getRequired("labels")

    /**
     * The model to use for the evaluation. Must support structured outputs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The name of the grader.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The labels that indicate a passing result. Must be a subset of labels.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun passingLabels(): List<String> = passingLabels.getRequired("passing_labels")

    /**
     * The object type, which is always `label_model`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("label_model")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<List<EvalItem>> = input

    /**
     * Returns the raw JSON value of [labels].
     *
     * Unlike [labels], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("labels") @ExcludeMissing fun _labels(): JsonField<List<String>> = labels

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [passingLabels].
     *
     * Unlike [passingLabels], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("passing_labels")
    @ExcludeMissing
    fun _passingLabels(): JsonField<List<String>> = passingLabels

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
         * Returns a mutable builder for constructing an instance of [LabelModelGrader].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .labels()
         * .model()
         * .name()
         * .passingLabels()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LabelModelGrader]. */
    class Builder internal constructor() {

        private var input: JsonField<MutableList<EvalItem>>? = null
        private var labels: JsonField<MutableList<String>>? = null
        private var model: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var passingLabels: JsonField<MutableList<String>>? = null
        private var type: JsonValue = JsonValue.from("label_model")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(labelModelGrader: LabelModelGrader) = apply {
            input = labelModelGrader.input.map { it.toMutableList() }
            labels = labelModelGrader.labels.map { it.toMutableList() }
            model = labelModelGrader.model
            name = labelModelGrader.name
            passingLabels = labelModelGrader.passingLabels.map { it.toMutableList() }
            type = labelModelGrader.type
            additionalProperties = labelModelGrader.additionalProperties.toMutableMap()
        }

        fun input(input: List<EvalItem>) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed `List<EvalItem>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun input(input: JsonField<List<EvalItem>>) = apply {
            this.input = input.map { it.toMutableList() }
        }

        /**
         * Adds a single [EvalItem] to [Builder.input].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInput(input: EvalItem) = apply {
            this.input =
                (this.input ?: JsonField.of(mutableListOf())).also {
                    checkKnown("input", it).add(input)
                }
        }

        /** The labels to assign to each item in the evaluation. */
        fun labels(labels: List<String>) = labels(JsonField.of(labels))

        /**
         * Sets [Builder.labels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.labels] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun labels(labels: JsonField<List<String>>) = apply {
            this.labels = labels.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [labels].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLabel(label: String) = apply {
            labels =
                (labels ?: JsonField.of(mutableListOf())).also {
                    checkKnown("labels", it).add(label)
                }
        }

        /** The model to use for the evaluation. Must support structured outputs. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The name of the grader. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The labels that indicate a passing result. Must be a subset of labels. */
        fun passingLabels(passingLabels: List<String>) = passingLabels(JsonField.of(passingLabels))

        /**
         * Sets [Builder.passingLabels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.passingLabels] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun passingLabels(passingLabels: JsonField<List<String>>) = apply {
            this.passingLabels = passingLabels.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [passingLabels].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPassingLabel(passingLabel: String) = apply {
            passingLabels =
                (passingLabels ?: JsonField.of(mutableListOf())).also {
                    checkKnown("passingLabels", it).add(passingLabel)
                }
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("label_model")
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
         * Returns an immutable instance of [LabelModelGrader].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .labels()
         * .model()
         * .name()
         * .passingLabels()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): LabelModelGrader =
            LabelModelGrader(
                checkRequired("input", input).map { it.toImmutable() },
                checkRequired("labels", labels).map { it.toImmutable() },
                checkRequired("model", model),
                checkRequired("name", name),
                checkRequired("passingLabels", passingLabels).map { it.toImmutable() },
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): LabelModelGrader = apply {
        if (validated) {
            return@apply
        }

        input().forEach { it.validate() }
        labels()
        model()
        name()
        passingLabels()
        _type().let {
            if (it != JsonValue.from("label_model")) {
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
        (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (labels.asKnown().getOrNull()?.size ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (passingLabels.asKnown().getOrNull()?.size ?: 0) +
            type.let { if (it == JsonValue.from("label_model")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is LabelModelGrader && input == other.input && labels == other.labels && model == other.model && name == other.name && passingLabels == other.passingLabels && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(input, labels, model, name, passingLabels, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "LabelModelGrader{input=$input, labels=$labels, model=$model, name=$name, passingLabels=$passingLabels, type=$type, additionalProperties=$additionalProperties}"
}
