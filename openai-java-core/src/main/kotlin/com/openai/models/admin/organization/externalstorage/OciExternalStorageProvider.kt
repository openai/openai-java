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

class OciExternalStorageProvider
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val bucket: JsonField<String>,
    private val region: JsonField<String>,
    private val tenancyOcid: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("bucket") @ExcludeMissing bucket: JsonField<String> = JsonMissing.of(),
        @JsonProperty("region") @ExcludeMissing region: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tenancy_ocid")
        @ExcludeMissing
        tenancyOcid: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(bucket, region, tenancyOcid, type, mutableMapOf())

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
    fun tenancyOcid(): java.util.Optional<String> = tenancyOcid.getOptional("tenancy_ocid")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun tenancyOcidOrThrow(): String = tenancyOcid.getRequired("tenancy_ocid")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("oci")) -> throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

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
     * Returns the raw JSON value of [tenancyOcid].
     *
     * Unlike [tenancyOcid], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tenancy_ocid")
    @ExcludeMissing
    fun _tenancyOcid(): JsonField<String> = tenancyOcid

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
            "bucket" to this.bucket,
            "region" to this.region,
            "tenancy_ocid" to this.tenancyOcid,
            "type" to this.type,
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
         * Returns a mutable builder for constructing an instance of [OciExternalStorageProvider].
         *
         * The following fields are required:
         * ```java
         * .bucket()
         * .region()
         * .tenancyOcid()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OciExternalStorageProvider]. */
    class Builder internal constructor() {

        private var bucket: JsonField<String>? = null
        private var region: JsonField<String>? = null
        private var tenancyOcid: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("oci")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(ociExternalStorageProvider: OciExternalStorageProvider) = apply {
            bucket = ociExternalStorageProvider.bucket
            region = ociExternalStorageProvider.region
            tenancyOcid = ociExternalStorageProvider.tenancyOcid
            type = ociExternalStorageProvider.type
            additionalProperties = ociExternalStorageProvider.additionalProperties.toMutableMap()
        }

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

        fun tenancyOcid(tenancyOcid: String) = tenancyOcid(JsonField.of(tenancyOcid))

        /**
         * Sets [Builder.tenancyOcid] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenancyOcid] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tenancyOcid(tenancyOcid: JsonField<String>) = apply { this.tenancyOcid = tenancyOcid }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("oci")
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
         * Returns an immutable instance of [OciExternalStorageProvider].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .bucket()
         * .region()
         * .tenancyOcid()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OciExternalStorageProvider =
            OciExternalStorageProvider(
                checkRequired("bucket", bucket),
                checkRequired("region", region),
                checkRequired("tenancyOcid", tenancyOcid),
                type,
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
    fun validate(): OciExternalStorageProvider = apply {
        if (validated) {
            return@apply
        }

        bucketOrThrow()
        regionOrThrow()
        tenancyOcidOrThrow()
        typeOrThrow()
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
        (if (bucket.asKnown().isPresent) 1 else 0) +
            (if (region.asKnown().isPresent) 1 else 0) +
            (if (tenancyOcid.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("oci")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OciExternalStorageProvider &&
            bucket == other.bucket &&
            region == other.region &&
            tenancyOcid == other.tenancyOcid &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(bucket, region, tenancyOcid, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OciExternalStorageProvider{bucket=$bucket, region=$region, tenancyOcid=$tenancyOcid, type=$type, additionalProperties=$additionalProperties}"
}
