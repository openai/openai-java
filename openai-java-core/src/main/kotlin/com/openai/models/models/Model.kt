// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

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

/** Describes an OpenAI model offering that can be used with the API. */
class Model
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val created: JsonField<Long>,
    private val object_: JsonValue,
    private val ownedBy: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created") @ExcludeMissing created: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("owned_by") @ExcludeMissing ownedBy: JsonField<String> = JsonMissing.of(),
    ) : this(id, created, object_, ownedBy, mutableMapOf())

    /**
     * The model identifier, which can be referenced in the API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) when the model was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun created(): Long = created.getRequired("created")

    /**
     * The object type, which is always "model".
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("model")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The organization that owns the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun ownedBy(): String = ownedBy.getRequired("owned_by")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [created].
     *
     * Unlike [created], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<Long> = created

    /**
     * Returns the raw JSON value of [ownedBy].
     *
     * Unlike [ownedBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("owned_by") @ExcludeMissing fun _ownedBy(): JsonField<String> = ownedBy

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
         * Returns a mutable builder for constructing an instance of [Model].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .created()
         * .ownedBy()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Model]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var created: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("model")
        private var ownedBy: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(model: Model) = apply {
            id = model.id
            created = model.created
            object_ = model.object_
            ownedBy = model.ownedBy
            additionalProperties = model.additionalProperties.toMutableMap()
        }

        /** The model identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) when the model was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /**
         * Sets [Builder.created] to an arbitrary JSON value.
         *
         * You should usually call [Builder.created] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("model")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The organization that owns the model. */
        fun ownedBy(ownedBy: String) = ownedBy(JsonField.of(ownedBy))

        /**
         * Sets [Builder.ownedBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ownedBy] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ownedBy(ownedBy: JsonField<String>) = apply { this.ownedBy = ownedBy }

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
         * Returns an immutable instance of [Model].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .created()
         * .ownedBy()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Model =
            Model(
                checkRequired("id", id),
                checkRequired("created", created),
                object_,
                checkRequired("ownedBy", ownedBy),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Model = apply {
        if (validated) {
            return@apply
        }

        id()
        created()
        _object_().let {
            if (it != JsonValue.from("model")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        ownedBy()
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
            (if (created.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("model")) 1 else 0 } +
            (if (ownedBy.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Model &&
            id == other.id &&
            created == other.created &&
            object_ == other.object_ &&
            ownedBy == other.ownedBy &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, created, object_, ownedBy, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Model{id=$id, created=$created, object_=$object_, ownedBy=$ownedBy, additionalProperties=$additionalProperties}"
}
