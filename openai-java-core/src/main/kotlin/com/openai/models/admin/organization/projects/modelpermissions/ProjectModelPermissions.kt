// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.modelpermissions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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
import kotlin.jvm.optionals.getOrNull

/** Represents the model allowlist or denylist policy for a project. */
class ProjectModelPermissions
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val mode: JsonField<Mode>,
    private val modelIds: JsonField<List<String>>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
        @JsonProperty("model_ids")
        @ExcludeMissing
        modelIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(mode, modelIds, object_, mutableMapOf())

    /**
     * Whether the project uses an allowlist or a denylist.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun mode(): Mode = mode.getRequired("mode")

    /**
     * The model IDs included in the model permissions policy.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun modelIds(): List<String> = modelIds.getRequired("model_ids")

    /**
     * The object type, which is always `project.model_permissions`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("project.model_permissions")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Returns the raw JSON value of [mode].
     *
     * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

    /**
     * Returns the raw JSON value of [modelIds].
     *
     * Unlike [modelIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model_ids") @ExcludeMissing fun _modelIds(): JsonField<List<String>> = modelIds

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
         * Returns a mutable builder for constructing an instance of [ProjectModelPermissions].
         *
         * The following fields are required:
         * ```java
         * .mode()
         * .modelIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProjectModelPermissions]. */
    class Builder internal constructor() {

        private var mode: JsonField<Mode>? = null
        private var modelIds: JsonField<MutableList<String>>? = null
        private var object_: JsonValue = JsonValue.from("project.model_permissions")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(projectModelPermissions: ProjectModelPermissions) = apply {
            mode = projectModelPermissions.mode
            modelIds = projectModelPermissions.modelIds.map { it.toMutableList() }
            object_ = projectModelPermissions.object_
            additionalProperties = projectModelPermissions.additionalProperties.toMutableMap()
        }

        /** Whether the project uses an allowlist or a denylist. */
        fun mode(mode: Mode) = mode(JsonField.of(mode))

        /**
         * Sets [Builder.mode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mode] with a well-typed [Mode] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

        /** The model IDs included in the model permissions policy. */
        fun modelIds(modelIds: List<String>) = modelIds(JsonField.of(modelIds))

        /**
         * Sets [Builder.modelIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.modelIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun modelIds(modelIds: JsonField<List<String>>) = apply {
            this.modelIds = modelIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [modelIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addModelId(modelId: String) = apply {
            modelIds =
                (modelIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("modelIds", it).add(modelId)
                }
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("project.model_permissions")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
         * Returns an immutable instance of [ProjectModelPermissions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .mode()
         * .modelIds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProjectModelPermissions =
            ProjectModelPermissions(
                checkRequired("mode", mode),
                checkRequired("modelIds", modelIds).map { it.toImmutable() },
                object_,
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
    fun validate(): ProjectModelPermissions = apply {
        if (validated) {
            return@apply
        }

        mode().validate()
        modelIds()
        _object_().let {
            if (it != JsonValue.from("project.model_permissions")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
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
        (mode.asKnown().getOrNull()?.validity() ?: 0) +
            (modelIds.asKnown().getOrNull()?.size ?: 0) +
            object_.let { if (it == JsonValue.from("project.model_permissions")) 1 else 0 }

    /** Whether the project uses an allowlist or a denylist. */
    class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ALLOW_LIST = of("allow_list")

            @JvmField val DENY_LIST = of("deny_list")

            @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
        }

        /** An enum containing [Mode]'s known values. */
        enum class Known {
            ALLOW_LIST,
            DENY_LIST,
        }

        /**
         * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Mode] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ALLOW_LIST,
            DENY_LIST,
            /** An enum member indicating that [Mode] was instantiated with an unknown value. */
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
                ALLOW_LIST -> Value.ALLOW_LIST
                DENY_LIST -> Value.DENY_LIST
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
                ALLOW_LIST -> Known.ALLOW_LIST
                DENY_LIST -> Known.DENY_LIST
                else -> throw OpenAIInvalidDataException("Unknown Mode: $value")
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectModelPermissions &&
            mode == other.mode &&
            modelIds == other.modelIds &&
            object_ == other.object_ &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(mode, modelIds, object_, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProjectModelPermissions{mode=$mode, modelIds=$modelIds, object_=$object_, additionalProperties=$additionalProperties}"
}
