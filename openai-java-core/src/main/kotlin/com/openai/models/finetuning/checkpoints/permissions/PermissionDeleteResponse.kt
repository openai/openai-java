// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

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

class PermissionDeleteResponse
private constructor(
    private val id: JsonField<String>,
    private val deleted: JsonField<Boolean>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("deleted") @ExcludeMissing deleted: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(id, deleted, object_, mutableMapOf())

    /**
     * The ID of the fine-tuned model checkpoint permission that was deleted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Whether the fine-tuned model checkpoint permission was successfully deleted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun deleted(): Boolean = deleted.getRequired("deleted")

    /**
     * The object type, which is always "checkpoint.permission".
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("checkpoint.permission")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [deleted].
     *
     * Unlike [deleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deleted") @ExcludeMissing fun _deleted(): JsonField<Boolean> = deleted

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
         * Returns a mutable builder for constructing an instance of [PermissionDeleteResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .deleted()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PermissionDeleteResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var deleted: JsonField<Boolean>? = null
        private var object_: JsonValue = JsonValue.from("checkpoint.permission")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(permissionDeleteResponse: PermissionDeleteResponse) = apply {
            id = permissionDeleteResponse.id
            deleted = permissionDeleteResponse.deleted
            object_ = permissionDeleteResponse.object_
            additionalProperties = permissionDeleteResponse.additionalProperties.toMutableMap()
        }

        /** The ID of the fine-tuned model checkpoint permission that was deleted. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Whether the fine-tuned model checkpoint permission was successfully deleted. */
        fun deleted(deleted: Boolean) = deleted(JsonField.of(deleted))

        /**
         * Sets [Builder.deleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deleted] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun deleted(deleted: JsonField<Boolean>) = apply { this.deleted = deleted }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("checkpoint.permission")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [PermissionDeleteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .deleted()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PermissionDeleteResponse =
            PermissionDeleteResponse(
                checkRequired("id", id),
                checkRequired("deleted", deleted),
                object_,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PermissionDeleteResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        deleted()
        _object_().let {
            if (it != JsonValue.from("checkpoint.permission")) {
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (deleted.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("checkpoint.permission")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PermissionDeleteResponse &&
            id == other.id &&
            deleted == other.deleted &&
            object_ == other.object_ &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, deleted, object_, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PermissionDeleteResponse{id=$id, deleted=$deleted, object_=$object_, additionalProperties=$additionalProperties}"
}
