// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

class GcpExternalStorageProvider
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val audience: JsonField<String>,
    private val bucket: JsonField<String>,
    private val region: JsonField<String>,
    private val type: JsonValue,
    private val workloadIdentityPoolId: JsonField<String>,
    private val workloadIdentityProjectNumber: JsonField<String>,
    private val workloadIdentityProviderId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audience") @ExcludeMissing audience: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bucket") @ExcludeMissing bucket: JsonField<String> = JsonMissing.of(),
        @JsonProperty("region") @ExcludeMissing region: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("workload_identity_pool_id")
        @ExcludeMissing
        workloadIdentityPoolId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("workload_identity_project_number")
        @ExcludeMissing
        workloadIdentityProjectNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("workload_identity_provider_id")
        @ExcludeMissing
        workloadIdentityProviderId: JsonField<String> = JsonMissing.of(),
    ) : this(
        audience,
        bucket,
        region,
        type,
        workloadIdentityPoolId,
        workloadIdentityProjectNumber,
        workloadIdentityProviderId,
        mutableMapOf(),
    )

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun audience(): java.util.Optional<String> = audience.getOptional("audience")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun audienceOrThrow(): String = audience.getRequired("audience")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun bucket(): java.util.Optional<String> = bucket.getOptional("bucket")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun bucketOrThrow(): String = bucket.getRequired("bucket")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun region(): java.util.Optional<String> = region.getOptional("region")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun regionOrThrow(): String = region.getRequired("region")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("gcp")) -> throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun workloadIdentityPoolId(): java.util.Optional<String> =
        workloadIdentityPoolId.getOptional("workload_identity_pool_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun workloadIdentityPoolIdOrThrow(): String =
        workloadIdentityPoolId.getRequired("workload_identity_pool_id")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun workloadIdentityProjectNumber(): java.util.Optional<String> =
        workloadIdentityProjectNumber.getOptional("workload_identity_project_number")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun workloadIdentityProjectNumberOrThrow(): String =
        workloadIdentityProjectNumber.getRequired("workload_identity_project_number")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun workloadIdentityProviderId(): java.util.Optional<String> =
        workloadIdentityProviderId.getOptional("workload_identity_provider_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun workloadIdentityProviderIdOrThrow(): String =
        workloadIdentityProviderId.getRequired("workload_identity_provider_id")

    /**
     * Returns the raw JSON value of [audience].
     *
     * Unlike [audience], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audience") @ExcludeMissing fun _audience(): JsonField<String> = audience

    /**
     * Returns the raw JSON value of [bucket].
     *
     * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

    /**
     * Returns the raw JSON value of [region].
     *
     * Unlike [region], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("region") @ExcludeMissing fun _region(): JsonField<String> = region

    /**
     * Returns the raw JSON value of [workloadIdentityPoolId].
     *
     * Unlike [workloadIdentityPoolId], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("workload_identity_pool_id")
    @ExcludeMissing
    fun _workloadIdentityPoolId(): JsonField<String> = workloadIdentityPoolId

    /**
     * Returns the raw JSON value of [workloadIdentityProjectNumber].
     *
     * Unlike [workloadIdentityProjectNumber], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("workload_identity_project_number")
    @ExcludeMissing
    fun _workloadIdentityProjectNumber(): JsonField<String> = workloadIdentityProjectNumber

    /**
     * Returns the raw JSON value of [workloadIdentityProviderId].
     *
     * Unlike [workloadIdentityProviderId], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("workload_identity_provider_id")
    @ExcludeMissing
    fun _workloadIdentityProviderId(): JsonField<String> = workloadIdentityProviderId

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
            "audience" to this.audience,
            "bucket" to this.bucket,
            "region" to this.region,
            "type" to this.type,
            "workload_identity_pool_id" to this.workloadIdentityPoolId,
            "workload_identity_project_number" to this.workloadIdentityProjectNumber,
            "workload_identity_provider_id" to this.workloadIdentityProviderId,
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
         * Returns a mutable builder for constructing an instance of [GcpExternalStorageProvider].
         *
         * The following fields are required:
         * ```java
         * .audience()
         * .bucket()
         * .region()
         * .workloadIdentityPoolId()
         * .workloadIdentityProjectNumber()
         * .workloadIdentityProviderId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GcpExternalStorageProvider]. */
    class Builder internal constructor() {

        private var audience: JsonField<String>? = null
        private var bucket: JsonField<String>? = null
        private var region: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("gcp")
        private var workloadIdentityPoolId: JsonField<String>? = null
        private var workloadIdentityProjectNumber: JsonField<String>? = null
        private var workloadIdentityProviderId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(gcpExternalStorageProvider: GcpExternalStorageProvider) = apply {
            audience = gcpExternalStorageProvider.audience
            bucket = gcpExternalStorageProvider.bucket
            region = gcpExternalStorageProvider.region
            type = gcpExternalStorageProvider.type
            workloadIdentityPoolId = gcpExternalStorageProvider.workloadIdentityPoolId
            workloadIdentityProjectNumber = gcpExternalStorageProvider.workloadIdentityProjectNumber
            workloadIdentityProviderId = gcpExternalStorageProvider.workloadIdentityProviderId
            additionalProperties = gcpExternalStorageProvider.additionalProperties.toMutableMap()
        }

        fun audience(audience: String) = audience(JsonField.of(audience))

        /**
         * Sets [Builder.audience] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audience] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audience(audience: JsonField<String>) = apply { this.audience = audience }

        fun bucket(bucket: String) = bucket(JsonField.of(bucket))

        /**
         * Sets [Builder.bucket] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bucket] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

        fun region(region: String) = region(JsonField.of(region))

        /**
         * Sets [Builder.region] to an arbitrary JSON value.
         *
         * You should usually call [Builder.region] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun region(region: JsonField<String>) = apply { this.region = region }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("gcp")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun workloadIdentityPoolId(workloadIdentityPoolId: String) =
            workloadIdentityPoolId(JsonField.of(workloadIdentityPoolId))

        /**
         * Sets [Builder.workloadIdentityPoolId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workloadIdentityPoolId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun workloadIdentityPoolId(workloadIdentityPoolId: JsonField<String>) = apply {
            this.workloadIdentityPoolId = workloadIdentityPoolId
        }

        fun workloadIdentityProjectNumber(workloadIdentityProjectNumber: String) =
            workloadIdentityProjectNumber(JsonField.of(workloadIdentityProjectNumber))

        /**
         * Sets [Builder.workloadIdentityProjectNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workloadIdentityProjectNumber] with a well-typed
         * [String] value instead. This method is primarily for setting the field to an undocumented
         * or not yet supported value.
         */
        fun workloadIdentityProjectNumber(workloadIdentityProjectNumber: JsonField<String>) =
            apply {
                this.workloadIdentityProjectNumber = workloadIdentityProjectNumber
            }

        fun workloadIdentityProviderId(workloadIdentityProviderId: String) =
            workloadIdentityProviderId(JsonField.of(workloadIdentityProviderId))

        /**
         * Sets [Builder.workloadIdentityProviderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workloadIdentityProviderId] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun workloadIdentityProviderId(workloadIdentityProviderId: JsonField<String>) = apply {
            this.workloadIdentityProviderId = workloadIdentityProviderId
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
         * Returns an immutable instance of [GcpExternalStorageProvider].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .audience()
         * .bucket()
         * .region()
         * .workloadIdentityPoolId()
         * .workloadIdentityProjectNumber()
         * .workloadIdentityProviderId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GcpExternalStorageProvider =
            GcpExternalStorageProvider(
                checkRequired("audience", audience),
                checkRequired("bucket", bucket),
                checkRequired("region", region),
                type,
                checkRequired("workloadIdentityPoolId", workloadIdentityPoolId),
                checkRequired("workloadIdentityProjectNumber", workloadIdentityProjectNumber),
                checkRequired("workloadIdentityProviderId", workloadIdentityProviderId),
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
    fun validate(): GcpExternalStorageProvider = apply {
        if (validated) {
            return@apply
        }

        audienceOrThrow()
        bucketOrThrow()
        regionOrThrow()
        typeOrThrow()
        workloadIdentityPoolIdOrThrow()
        workloadIdentityProjectNumberOrThrow()
        workloadIdentityProviderIdOrThrow()
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
        (if (audience.asKnown().isPresent) 1 else 0) +
            (if (bucket.asKnown().isPresent) 1 else 0) +
            (if (region.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("gcp")) 1 else 0 } +
            (if (workloadIdentityPoolId.asKnown().isPresent) 1 else 0) +
            (if (workloadIdentityProjectNumber.asKnown().isPresent) 1 else 0) +
            (if (workloadIdentityProviderId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GcpExternalStorageProvider &&
            audience == other.audience &&
            bucket == other.bucket &&
            region == other.region &&
            type == other.type &&
            workloadIdentityPoolId == other.workloadIdentityPoolId &&
            workloadIdentityProjectNumber == other.workloadIdentityProjectNumber &&
            workloadIdentityProviderId == other.workloadIdentityProviderId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            audience,
            bucket,
            region,
            type,
            workloadIdentityPoolId,
            workloadIdentityProjectNumber,
            workloadIdentityProviderId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GcpExternalStorageProvider{audience=$audience, bucket=$bucket, region=$region, type=$type, workloadIdentityPoolId=$workloadIdentityPoolId, workloadIdentityProjectNumber=$workloadIdentityProjectNumber, workloadIdentityProviderId=$workloadIdentityProviderId, additionalProperties=$additionalProperties}"
}
