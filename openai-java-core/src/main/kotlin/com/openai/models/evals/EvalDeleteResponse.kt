// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

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

class EvalDeleteResponse
private constructor(
    private val deleted: JsonField<Boolean>,
    private val evalId: JsonField<String>,
    private val object_: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("deleted") @ExcludeMissing deleted: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("eval_id") @ExcludeMissing evalId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
    ) : this(deleted, evalId, object_, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun deleted(): Boolean = deleted.getRequired("deleted")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun evalId(): String = evalId.getRequired("eval_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): String = object_.getRequired("object")

    /**
     * Returns the raw JSON value of [deleted].
     *
     * Unlike [deleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deleted") @ExcludeMissing fun _deleted(): JsonField<Boolean> = deleted

    /**
     * Returns the raw JSON value of [evalId].
     *
     * Unlike [evalId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eval_id") @ExcludeMissing fun _evalId(): JsonField<String> = evalId

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

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
         * Returns a mutable builder for constructing an instance of [EvalDeleteResponse].
         *
         * The following fields are required:
         * ```java
         * .deleted()
         * .evalId()
         * .object_()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EvalDeleteResponse]. */
    class Builder internal constructor() {

        private var deleted: JsonField<Boolean>? = null
        private var evalId: JsonField<String>? = null
        private var object_: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(evalDeleteResponse: EvalDeleteResponse) = apply {
            deleted = evalDeleteResponse.deleted
            evalId = evalDeleteResponse.evalId
            object_ = evalDeleteResponse.object_
            additionalProperties = evalDeleteResponse.additionalProperties.toMutableMap()
        }

        fun deleted(deleted: Boolean) = deleted(JsonField.of(deleted))

        /**
         * Sets [Builder.deleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deleted] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun deleted(deleted: JsonField<Boolean>) = apply { this.deleted = deleted }

        fun evalId(evalId: String) = evalId(JsonField.of(evalId))

        /**
         * Sets [Builder.evalId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.evalId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun evalId(evalId: JsonField<String>) = apply { this.evalId = evalId }

        fun object_(object_: String) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

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
         * Returns an immutable instance of [EvalDeleteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .deleted()
         * .evalId()
         * .object_()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EvalDeleteResponse =
            EvalDeleteResponse(
                checkRequired("deleted", deleted),
                checkRequired("evalId", evalId),
                checkRequired("object_", object_),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EvalDeleteResponse = apply {
        if (validated) {
            return@apply
        }

        deleted()
        evalId()
        object_()
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
        (if (deleted.asKnown().isPresent) 1 else 0) +
            (if (evalId.asKnown().isPresent) 1 else 0) +
            (if (object_.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EvalDeleteResponse && deleted == other.deleted && evalId == other.evalId && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(deleted, evalId, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EvalDeleteResponse{deleted=$deleted, evalId=$evalId, object_=$object_, additionalProperties=$additionalProperties}"
}
