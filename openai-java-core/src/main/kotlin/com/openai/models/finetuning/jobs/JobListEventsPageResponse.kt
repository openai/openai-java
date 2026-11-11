// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.jobs

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
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class JobListEventsPageResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<List<FineTuningJobEvent>>,
    private val hasMore: JsonField<Boolean>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        data: JsonField<List<FineTuningJobEvent>> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(data, hasMore, object_, mutableMapOf())

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun data(): java.util.Optional<List<FineTuningJobEvent>> = data.getOptional("data")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun dataOrThrow(): List<FineTuningJobEvent> = data.getRequired("data")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun hasMore(): java.util.Optional<Boolean> = hasMore.getOptional("has_more")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun hasMoreOrThrow(): Boolean = hasMore.getRequired("has_more")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("list")) ->
                throw OpenAIInvalidDataException("`object` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun object_OrThrow(): JsonValue = object_().orElseGet { object_.getRequired("object") }

    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<JsonValue> = object_

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<FineTuningJobEvent>> = data

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "data" to this.data,
            "has_more" to this.hasMore,
            "object" to this.object_,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [JobListEventsPageResponse].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .hasMore()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [JobListEventsPageResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<FineTuningJobEvent>>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var object_: JsonValue = JsonValue.from("list")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(jobListEventsPageResponse: JobListEventsPageResponse) = apply {
            data = jobListEventsPageResponse.data.map { it.toMutableList() }
            hasMore = jobListEventsPageResponse.hasMore
            object_ = jobListEventsPageResponse.object_
            additionalProperties = jobListEventsPageResponse.additionalProperties.toMutableMap()
        }

        fun data(data: List<FineTuningJobEvent>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<FineTuningJobEvent>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun data(data: JsonField<List<FineTuningJobEvent>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [FineTuningJobEvent] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: FineTuningJobEvent) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("list")
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
         * Returns an immutable instance of [JobListEventsPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .data()
         * .hasMore()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): JobListEventsPageResponse =
            JobListEventsPageResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("hasMore", hasMore),
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
    fun validate(): JobListEventsPageResponse = apply {
        if (validated) {
            return@apply
        }

        dataOrThrow().forEach { it.validate() }
        hasMoreOrThrow()
        object_OrThrow()
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
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("list")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JobListEventsPageResponse &&
            data == other.data &&
            hasMore == other.hasMore &&
            object_ == other.object_ &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(data, hasMore, object_, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "JobListEventsPageResponse{data=$data, hasMore=$hasMore, object_=$object_, additionalProperties=$additionalProperties}"
}
