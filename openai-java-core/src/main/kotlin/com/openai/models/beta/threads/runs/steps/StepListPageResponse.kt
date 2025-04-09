// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

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
import kotlin.jvm.optionals.getOrNull

class StepListPageResponse
private constructor(
    private val data: JsonField<List<RunStep>>,
    private val firstId: JsonField<String>,
    private val hasMore: JsonField<Boolean>,
    private val lastId: JsonField<String>,
    private val object_: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<List<RunStep>> = JsonMissing.of(),
        @JsonProperty("first_id") @ExcludeMissing firstId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("last_id") @ExcludeMissing lastId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
    ) : this(data, firstId, hasMore, lastId, object_, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<RunStep> = data.getRequired("data")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun firstId(): String = firstId.getRequired("first_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("has_more")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lastId(): String = lastId.getRequired("last_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): String = object_.getRequired("object")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<RunStep>> = data

    /**
     * Returns the raw JSON value of [firstId].
     *
     * Unlike [firstId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("first_id") @ExcludeMissing fun _firstId(): JsonField<String> = firstId

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [lastId].
     *
     * Unlike [lastId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_id") @ExcludeMissing fun _lastId(): JsonField<String> = lastId

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
         * Returns a mutable builder for constructing an instance of [StepListPageResponse].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * .object_()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StepListPageResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<RunStep>>? = null
        private var firstId: JsonField<String>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var lastId: JsonField<String>? = null
        private var object_: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(stepListPageResponse: StepListPageResponse) = apply {
            data = stepListPageResponse.data.map { it.toMutableList() }
            firstId = stepListPageResponse.firstId
            hasMore = stepListPageResponse.hasMore
            lastId = stepListPageResponse.lastId
            object_ = stepListPageResponse.object_
            additionalProperties = stepListPageResponse.additionalProperties.toMutableMap()
        }

        fun data(data: List<RunStep>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<RunStep>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun data(data: JsonField<List<RunStep>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [RunStep] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: RunStep) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        fun firstId(firstId: String) = firstId(JsonField.of(firstId))

        /**
         * Sets [Builder.firstId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.firstId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun firstId(firstId: JsonField<String>) = apply { this.firstId = firstId }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        fun lastId(lastId: String) = lastId(JsonField.of(lastId))

        /**
         * Sets [Builder.lastId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lastId(lastId: JsonField<String>) = apply { this.lastId = lastId }

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
         * Returns an immutable instance of [StepListPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * .object_()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StepListPageResponse =
            StepListPageResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("firstId", firstId),
                checkRequired("hasMore", hasMore),
                checkRequired("lastId", lastId),
                checkRequired("object_", object_),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StepListPageResponse = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        firstId()
        hasMore()
        lastId()
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
        (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (firstId.asKnown().isPresent) 1 else 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (lastId.asKnown().isPresent) 1 else 0) +
            (if (object_.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StepListPageResponse && data == other.data && firstId == other.firstId && hasMore == other.hasMore && lastId == other.lastId && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, firstId, hasMore, lastId, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StepListPageResponse{data=$data, firstId=$firstId, hasMore=$hasMore, lastId=$lastId, object_=$object_, additionalProperties=$additionalProperties}"
}
