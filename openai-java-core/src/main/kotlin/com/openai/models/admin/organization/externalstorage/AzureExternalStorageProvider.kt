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

class AzureExternalStorageProvider
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val accountName: JsonField<String>,
    private val container: JsonField<String>,
    private val region: JsonField<String>,
    private val resourceGroup: JsonField<String>,
    private val subscriptionId: JsonField<String>,
    private val tenantId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("account_name")
        @ExcludeMissing
        accountName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("container") @ExcludeMissing container: JsonField<String> = JsonMissing.of(),
        @JsonProperty("region") @ExcludeMissing region: JsonField<String> = JsonMissing.of(),
        @JsonProperty("resource_group")
        @ExcludeMissing
        resourceGroup: JsonField<String> = JsonMissing.of(),
        @JsonProperty("subscription_id")
        @ExcludeMissing
        subscriptionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tenant_id") @ExcludeMissing tenantId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(
        accountName,
        container,
        region,
        resourceGroup,
        subscriptionId,
        tenantId,
        type,
        mutableMapOf(),
    )

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun accountName(): java.util.Optional<String> = accountName.getOptional("account_name")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun accountNameOrThrow(): String = accountName.getRequired("account_name")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun container(): java.util.Optional<String> = container.getOptional("container")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun containerOrThrow(): String = container.getRequired("container")

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
    fun resourceGroup(): java.util.Optional<String> = resourceGroup.getOptional("resource_group")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun resourceGroupOrThrow(): String = resourceGroup.getRequired("resource_group")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun subscriptionId(): java.util.Optional<String> = subscriptionId.getOptional("subscription_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun subscriptionIdOrThrow(): String = subscriptionId.getRequired("subscription_id")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun tenantId(): java.util.Optional<String> = tenantId.getOptional("tenant_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun tenantIdOrThrow(): String = tenantId.getRequired("tenant_id")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("azure")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

    /**
     * Returns the raw JSON value of [accountName].
     *
     * Unlike [accountName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account_name")
    @ExcludeMissing
    fun _accountName(): JsonField<String> = accountName

    /**
     * Returns the raw JSON value of [container].
     *
     * Unlike [container], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("container") @ExcludeMissing fun _container(): JsonField<String> = container

    /**
     * Returns the raw JSON value of [region].
     *
     * Unlike [region], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("region") @ExcludeMissing fun _region(): JsonField<String> = region

    /**
     * Returns the raw JSON value of [resourceGroup].
     *
     * Unlike [resourceGroup], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("resource_group")
    @ExcludeMissing
    fun _resourceGroup(): JsonField<String> = resourceGroup

    /**
     * Returns the raw JSON value of [subscriptionId].
     *
     * Unlike [subscriptionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subscription_id")
    @ExcludeMissing
    fun _subscriptionId(): JsonField<String> = subscriptionId

    /**
     * Returns the raw JSON value of [tenantId].
     *
     * Unlike [tenantId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tenant_id") @ExcludeMissing fun _tenantId(): JsonField<String> = tenantId

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
            "account_name" to this.accountName,
            "container" to this.container,
            "region" to this.region,
            "resource_group" to this.resourceGroup,
            "subscription_id" to this.subscriptionId,
            "tenant_id" to this.tenantId,
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
         * Returns a mutable builder for constructing an instance of [AzureExternalStorageProvider].
         *
         * The following fields are required:
         * ```java
         * .accountName()
         * .container()
         * .region()
         * .resourceGroup()
         * .subscriptionId()
         * .tenantId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AzureExternalStorageProvider]. */
    class Builder internal constructor() {

        private var accountName: JsonField<String>? = null
        private var container: JsonField<String>? = null
        private var region: JsonField<String>? = null
        private var resourceGroup: JsonField<String>? = null
        private var subscriptionId: JsonField<String>? = null
        private var tenantId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("azure")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(azureExternalStorageProvider: AzureExternalStorageProvider) = apply {
            accountName = azureExternalStorageProvider.accountName
            container = azureExternalStorageProvider.container
            region = azureExternalStorageProvider.region
            resourceGroup = azureExternalStorageProvider.resourceGroup
            subscriptionId = azureExternalStorageProvider.subscriptionId
            tenantId = azureExternalStorageProvider.tenantId
            type = azureExternalStorageProvider.type
            additionalProperties = azureExternalStorageProvider.additionalProperties.toMutableMap()
        }

        fun accountName(accountName: String) = accountName(JsonField.of(accountName))

        /**
         * Sets [Builder.accountName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountName(accountName: JsonField<String>) = apply { this.accountName = accountName }

        fun container(container: String) = container(JsonField.of(container))

        /**
         * Sets [Builder.container] to an arbitrary JSON value.
         *
         * You should usually call [Builder.container] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun container(container: JsonField<String>) = apply { this.container = container }

        fun region(region: String) = region(JsonField.of(region))

        /**
         * Sets [Builder.region] to an arbitrary JSON value.
         *
         * You should usually call [Builder.region] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun region(region: JsonField<String>) = apply { this.region = region }

        fun resourceGroup(resourceGroup: String) = resourceGroup(JsonField.of(resourceGroup))

        /**
         * Sets [Builder.resourceGroup] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resourceGroup] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun resourceGroup(resourceGroup: JsonField<String>) = apply {
            this.resourceGroup = resourceGroup
        }

        fun subscriptionId(subscriptionId: String) = subscriptionId(JsonField.of(subscriptionId))

        /**
         * Sets [Builder.subscriptionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriptionId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subscriptionId(subscriptionId: JsonField<String>) = apply {
            this.subscriptionId = subscriptionId
        }

        fun tenantId(tenantId: String) = tenantId(JsonField.of(tenantId))

        /**
         * Sets [Builder.tenantId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenantId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tenantId(tenantId: JsonField<String>) = apply { this.tenantId = tenantId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("azure")
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
         * Returns an immutable instance of [AzureExternalStorageProvider].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .accountName()
         * .container()
         * .region()
         * .resourceGroup()
         * .subscriptionId()
         * .tenantId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AzureExternalStorageProvider =
            AzureExternalStorageProvider(
                checkRequired("accountName", accountName),
                checkRequired("container", container),
                checkRequired("region", region),
                checkRequired("resourceGroup", resourceGroup),
                checkRequired("subscriptionId", subscriptionId),
                checkRequired("tenantId", tenantId),
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
    fun validate(): AzureExternalStorageProvider = apply {
        if (validated) {
            return@apply
        }

        accountNameOrThrow()
        containerOrThrow()
        regionOrThrow()
        resourceGroupOrThrow()
        subscriptionIdOrThrow()
        tenantIdOrThrow()
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
        (if (accountName.asKnown().isPresent) 1 else 0) +
            (if (container.asKnown().isPresent) 1 else 0) +
            (if (region.asKnown().isPresent) 1 else 0) +
            (if (resourceGroup.asKnown().isPresent) 1 else 0) +
            (if (subscriptionId.asKnown().isPresent) 1 else 0) +
            (if (tenantId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("azure")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AzureExternalStorageProvider &&
            accountName == other.accountName &&
            container == other.container &&
            region == other.region &&
            resourceGroup == other.resourceGroup &&
            subscriptionId == other.subscriptionId &&
            tenantId == other.tenantId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            accountName,
            container,
            region,
            resourceGroup,
            subscriptionId,
            tenantId,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AzureExternalStorageProvider{accountName=$accountName, container=$container, region=$region, resourceGroup=$resourceGroup, subscriptionId=$subscriptionId, tenantId=$tenantId, type=$type, additionalProperties=$additionalProperties}"
}
