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
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** A MultiGrader object combines the output of multiple graders to produce a single score. */
class MultiGrader
private constructor(
    private val calculateOutput: JsonField<String>,
    private val graders: JsonField<Graders>,
    private val name: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("calculate_output")
        @ExcludeMissing
        calculateOutput: JsonField<String> = JsonMissing.of(),
        @JsonProperty("graders") @ExcludeMissing graders: JsonField<Graders> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(calculateOutput, graders, name, type, mutableMapOf())

    /**
     * A formula to calculate the output based on grader results.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun calculateOutput(): String = calculateOutput.getRequired("calculate_output")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun graders(): Graders = graders.getRequired("graders")

    /**
     * The name of the grader.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The type of grader.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("multi")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [calculateOutput].
     *
     * Unlike [calculateOutput], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("calculate_output")
    @ExcludeMissing
    fun _calculateOutput(): JsonField<String> = calculateOutput

    /**
     * Returns the raw JSON value of [graders].
     *
     * Unlike [graders], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("graders") @ExcludeMissing fun _graders(): JsonField<Graders> = graders

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
         * Returns a mutable builder for constructing an instance of [MultiGrader].
         *
         * The following fields are required:
         * ```java
         * .calculateOutput()
         * .graders()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MultiGrader]. */
    class Builder internal constructor() {

        private var calculateOutput: JsonField<String>? = null
        private var graders: JsonField<Graders>? = null
        private var name: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("multi")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(multiGrader: MultiGrader) = apply {
            calculateOutput = multiGrader.calculateOutput
            graders = multiGrader.graders
            name = multiGrader.name
            type = multiGrader.type
            additionalProperties = multiGrader.additionalProperties.toMutableMap()
        }

        /** A formula to calculate the output based on grader results. */
        fun calculateOutput(calculateOutput: String) =
            calculateOutput(JsonField.of(calculateOutput))

        /**
         * Sets [Builder.calculateOutput] to an arbitrary JSON value.
         *
         * You should usually call [Builder.calculateOutput] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun calculateOutput(calculateOutput: JsonField<String>) = apply {
            this.calculateOutput = calculateOutput
        }

        fun graders(graders: Graders) = graders(JsonField.of(graders))

        /**
         * Sets [Builder.graders] to an arbitrary JSON value.
         *
         * You should usually call [Builder.graders] with a well-typed [Graders] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun graders(graders: JsonField<Graders>) = apply { this.graders = graders }

        /** The name of the grader. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("multi")
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
         * Returns an immutable instance of [MultiGrader].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .calculateOutput()
         * .graders()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MultiGrader =
            MultiGrader(
                checkRequired("calculateOutput", calculateOutput),
                checkRequired("graders", graders),
                checkRequired("name", name),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MultiGrader = apply {
        if (validated) {
            return@apply
        }

        calculateOutput()
        graders().validate()
        name()
        _type().let {
            if (it != JsonValue.from("multi")) {
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
        (if (calculateOutput.asKnown().isPresent) 1 else 0) +
            (graders.asKnown().getOrNull()?.validity() ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("multi")) 1 else 0 }

    class Graders
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

            /** Returns a mutable builder for constructing an instance of [Graders]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Graders]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(graders: Graders) = apply {
                additionalProperties = graders.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Graders].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Graders = Graders(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Graders = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Graders && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Graders{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MultiGrader && calculateOutput == other.calculateOutput && graders == other.graders && name == other.name && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(calculateOutput, graders, name, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MultiGrader{calculateOutput=$calculateOutput, graders=$graders, name=$name, type=$type, additionalProperties=$additionalProperties}"
}
