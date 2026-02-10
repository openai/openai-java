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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class SkillReference
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val skillId: JsonField<String>,
    private val type: JsonValue,
    private val version: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("skill_id") @ExcludeMissing skillId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("version") @ExcludeMissing version: JsonField<String> = JsonMissing.of(),
    ) : this(skillId, type, version, mutableMapOf())

    /**
     * The ID of the referenced skill.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun skillId(): String = skillId.getRequired("skill_id")

    /**
     * References a skill created with the /v1/skills endpoint.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("skill_reference")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional skill version. Use a positive integer or 'latest'. Omit for default.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun version(): Optional<String> = version.getOptional("version")

    /**
     * Returns the raw JSON value of [skillId].
     *
     * Unlike [skillId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("skill_id") @ExcludeMissing fun _skillId(): JsonField<String> = skillId

    /**
     * Returns the raw JSON value of [version].
     *
     * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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
         * Returns a mutable builder for constructing an instance of [SkillReference].
         *
         * The following fields are required:
         * ```java
         * .skillId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SkillReference]. */
    class Builder internal constructor() {

        private var skillId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("skill_reference")
        private var version: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(skillReference: SkillReference) = apply {
            skillId = skillReference.skillId
            type = skillReference.type
            version = skillReference.version
            additionalProperties = skillReference.additionalProperties.toMutableMap()
        }

        /** The ID of the referenced skill. */
        fun skillId(skillId: String) = skillId(JsonField.of(skillId))

        /**
         * Sets [Builder.skillId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.skillId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun skillId(skillId: JsonField<String>) = apply { this.skillId = skillId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("skill_reference")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Optional skill version. Use a positive integer or 'latest'. Omit for default. */
        fun version(version: String) = version(JsonField.of(version))

        /**
         * Sets [Builder.version] to an arbitrary JSON value.
         *
         * You should usually call [Builder.version] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun version(version: JsonField<String>) = apply { this.version = version }

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
         * Returns an immutable instance of [SkillReference].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .skillId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SkillReference =
            SkillReference(
                checkRequired("skillId", skillId),
                type,
                version,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SkillReference = apply {
        if (validated) {
            return@apply
        }

        skillId()
        _type().let {
            if (it != JsonValue.from("skill_reference")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        version()
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
        (if (skillId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("skill_reference")) 1 else 0 } +
            (if (version.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SkillReference &&
            skillId == other.skillId &&
            type == other.type &&
            version == other.version &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(skillId, type, version, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SkillReference{skillId=$skillId, type=$type, version=$version, additionalProperties=$additionalProperties}"
}
