// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BetaLocalEnvironment
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val skills: JsonField<List<BetaLocalSkill>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("skills")
        @ExcludeMissing
        skills: JsonField<List<BetaLocalSkill>> = JsonMissing.of(),
    ) : this(type, skills, mutableMapOf())

    /**
     * Use a local computer environment.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("local")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * An optional list of skills.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun skills(): Optional<List<BetaLocalSkill>> = skills.getOptional("skills")

    /**
     * Returns the raw JSON value of [skills].
     *
     * Unlike [skills], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("skills") @ExcludeMissing fun _skills(): JsonField<List<BetaLocalSkill>> = skills

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

        /** Returns a mutable builder for constructing an instance of [BetaLocalEnvironment]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaLocalEnvironment]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("local")
        private var skills: JsonField<MutableList<BetaLocalSkill>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaLocalEnvironment: BetaLocalEnvironment) = apply {
            type = betaLocalEnvironment.type
            skills = betaLocalEnvironment.skills.map { it.toMutableList() }
            additionalProperties = betaLocalEnvironment.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("local")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** An optional list of skills. */
        fun skills(skills: List<BetaLocalSkill>) = skills(JsonField.of(skills))

        /**
         * Sets [Builder.skills] to an arbitrary JSON value.
         *
         * You should usually call [Builder.skills] with a well-typed `List<BetaLocalSkill>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun skills(skills: JsonField<List<BetaLocalSkill>>) = apply {
            this.skills = skills.map { it.toMutableList() }
        }

        /**
         * Adds a single [BetaLocalSkill] to [skills].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSkill(skill: BetaLocalSkill) = apply {
            skills =
                (skills ?: JsonField.of(mutableListOf())).also {
                    checkKnown("skills", it).add(skill)
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
         * Returns an immutable instance of [BetaLocalEnvironment].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BetaLocalEnvironment =
            BetaLocalEnvironment(
                type,
                (skills ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): BetaLocalEnvironment = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("local")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        skills().ifPresent { it.forEach { it.validate() } }
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
        type.let { if (it == JsonValue.from("local")) 1 else 0 } +
            (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaLocalEnvironment &&
            type == other.type &&
            skills == other.skills &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(type, skills, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaLocalEnvironment{type=$type, skills=$skills, additionalProperties=$additionalProperties}"
}
