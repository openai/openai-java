// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalkeys

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
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ExternalKey
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val apiProjectIds: JsonField<List<String>>,
    private val createdAt: JsonField<Long>,
    private val name: JsonField<String>,
    private val object_: JsonField<String>,
    private val type: JsonField<String>,
    private val workspaceId: JsonField<String>,
    private val audience: JsonField<String>,
    private val externalId: JsonField<String>,
    private val keyName: JsonField<String>,
    private val keyVersion: JsonField<String>,
    private val kmsArn: JsonField<String>,
    private val kmsKeyLocation: JsonField<String>,
    private val kmsKeyName: JsonField<String>,
    private val kmsKeyRingName: JsonField<String>,
    private val kmsKeyVersion: JsonField<String>,
    private val kmsProjectId: JsonField<String>,
    private val purpose: JsonField<Purpose>,
    private val roleArn: JsonField<String>,
    private val tenantId: JsonField<String>,
    private val vaultUri: JsonField<String>,
    private val workloadIdentityPoolId: JsonField<String>,
    private val workloadIdentityProjectNumber: JsonField<String>,
    private val workloadIdentityProviderId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("api_project_ids")
        @ExcludeMissing
        apiProjectIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("workspace_id")
        @ExcludeMissing
        workspaceId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("audience") @ExcludeMissing audience: JsonField<String> = JsonMissing.of(),
        @JsonProperty("external_id")
        @ExcludeMissing
        externalId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("key_name") @ExcludeMissing keyName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("key_version")
        @ExcludeMissing
        keyVersion: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kms_arn") @ExcludeMissing kmsArn: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kms_key_location")
        @ExcludeMissing
        kmsKeyLocation: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kms_key_name")
        @ExcludeMissing
        kmsKeyName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kms_key_ring_name")
        @ExcludeMissing
        kmsKeyRingName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kms_key_version")
        @ExcludeMissing
        kmsKeyVersion: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kms_project_id")
        @ExcludeMissing
        kmsProjectId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("purpose") @ExcludeMissing purpose: JsonField<Purpose> = JsonMissing.of(),
        @JsonProperty("role_arn") @ExcludeMissing roleArn: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tenant_id") @ExcludeMissing tenantId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("vault_uri") @ExcludeMissing vaultUri: JsonField<String> = JsonMissing.of(),
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
        id,
        apiProjectIds,
        createdAt,
        name,
        object_,
        type,
        workspaceId,
        audience,
        externalId,
        keyName,
        keyVersion,
        kmsArn,
        kmsKeyLocation,
        kmsKeyName,
        kmsKeyRingName,
        kmsKeyVersion,
        kmsProjectId,
        purpose,
        roleArn,
        tenantId,
        vaultUri,
        workloadIdentityPoolId,
        workloadIdentityProjectNumber,
        workloadIdentityProviderId,
        mutableMapOf(),
    )

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun apiProjectIds(): List<String> = apiProjectIds.getRequired("api_project_ids")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): String = object_.getRequired("object")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun workspaceId(): String = workspaceId.getRequired("workspace_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audience(): Optional<String> = audience.getOptional("audience")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun externalId(): Optional<String> = externalId.getOptional("external_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun keyName(): Optional<String> = keyName.getOptional("key_name")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun keyVersion(): Optional<String> = keyVersion.getOptional("key_version")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun kmsArn(): Optional<String> = kmsArn.getOptional("kms_arn")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun kmsKeyLocation(): Optional<String> = kmsKeyLocation.getOptional("kms_key_location")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun kmsKeyName(): Optional<String> = kmsKeyName.getOptional("kms_key_name")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun kmsKeyRingName(): Optional<String> = kmsKeyRingName.getOptional("kms_key_ring_name")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun kmsKeyVersion(): Optional<String> = kmsKeyVersion.getOptional("kms_key_version")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun kmsProjectId(): Optional<String> = kmsProjectId.getOptional("kms_project_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun purpose(): Optional<Purpose> = purpose.getOptional("purpose")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun roleArn(): Optional<String> = roleArn.getOptional("role_arn")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tenantId(): Optional<String> = tenantId.getOptional("tenant_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vaultUri(): Optional<String> = vaultUri.getOptional("vault_uri")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun workloadIdentityPoolId(): Optional<String> =
        workloadIdentityPoolId.getOptional("workload_identity_pool_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun workloadIdentityProjectNumber(): Optional<String> =
        workloadIdentityProjectNumber.getOptional("workload_identity_project_number")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun workloadIdentityProviderId(): Optional<String> =
        workloadIdentityProviderId.getOptional("workload_identity_provider_id")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [apiProjectIds].
     *
     * Unlike [apiProjectIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("api_project_ids")
    @ExcludeMissing
    fun _apiProjectIds(): JsonField<List<String>> = apiProjectIds

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /**
     * Returns the raw JSON value of [workspaceId].
     *
     * Unlike [workspaceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("workspace_id")
    @ExcludeMissing
    fun _workspaceId(): JsonField<String> = workspaceId

    /**
     * Returns the raw JSON value of [audience].
     *
     * Unlike [audience], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audience") @ExcludeMissing fun _audience(): JsonField<String> = audience

    /**
     * Returns the raw JSON value of [externalId].
     *
     * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("external_id") @ExcludeMissing fun _externalId(): JsonField<String> = externalId

    /**
     * Returns the raw JSON value of [keyName].
     *
     * Unlike [keyName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("key_name") @ExcludeMissing fun _keyName(): JsonField<String> = keyName

    /**
     * Returns the raw JSON value of [keyVersion].
     *
     * Unlike [keyVersion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("key_version") @ExcludeMissing fun _keyVersion(): JsonField<String> = keyVersion

    /**
     * Returns the raw JSON value of [kmsArn].
     *
     * Unlike [kmsArn], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kms_arn") @ExcludeMissing fun _kmsArn(): JsonField<String> = kmsArn

    /**
     * Returns the raw JSON value of [kmsKeyLocation].
     *
     * Unlike [kmsKeyLocation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kms_key_location")
    @ExcludeMissing
    fun _kmsKeyLocation(): JsonField<String> = kmsKeyLocation

    /**
     * Returns the raw JSON value of [kmsKeyName].
     *
     * Unlike [kmsKeyName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kms_key_name") @ExcludeMissing fun _kmsKeyName(): JsonField<String> = kmsKeyName

    /**
     * Returns the raw JSON value of [kmsKeyRingName].
     *
     * Unlike [kmsKeyRingName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kms_key_ring_name")
    @ExcludeMissing
    fun _kmsKeyRingName(): JsonField<String> = kmsKeyRingName

    /**
     * Returns the raw JSON value of [kmsKeyVersion].
     *
     * Unlike [kmsKeyVersion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kms_key_version")
    @ExcludeMissing
    fun _kmsKeyVersion(): JsonField<String> = kmsKeyVersion

    /**
     * Returns the raw JSON value of [kmsProjectId].
     *
     * Unlike [kmsProjectId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kms_project_id")
    @ExcludeMissing
    fun _kmsProjectId(): JsonField<String> = kmsProjectId

    /**
     * Returns the raw JSON value of [purpose].
     *
     * Unlike [purpose], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("purpose") @ExcludeMissing fun _purpose(): JsonField<Purpose> = purpose

    /**
     * Returns the raw JSON value of [roleArn].
     *
     * Unlike [roleArn], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role_arn") @ExcludeMissing fun _roleArn(): JsonField<String> = roleArn

    /**
     * Returns the raw JSON value of [tenantId].
     *
     * Unlike [tenantId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tenant_id") @ExcludeMissing fun _tenantId(): JsonField<String> = tenantId

    /**
     * Returns the raw JSON value of [vaultUri].
     *
     * Unlike [vaultUri], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vault_uri") @ExcludeMissing fun _vaultUri(): JsonField<String> = vaultUri

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
            "id" to this.id,
            "api_project_ids" to this.apiProjectIds,
            "created_at" to this.createdAt,
            "name" to this.name,
            "object" to this.object_,
            "type" to this.type,
            "workspace_id" to this.workspaceId,
            "audience" to this.audience,
            "external_id" to this.externalId,
            "key_name" to this.keyName,
            "key_version" to this.keyVersion,
            "kms_arn" to this.kmsArn,
            "kms_key_location" to this.kmsKeyLocation,
            "kms_key_name" to this.kmsKeyName,
            "kms_key_ring_name" to this.kmsKeyRingName,
            "kms_key_version" to this.kmsKeyVersion,
            "kms_project_id" to this.kmsProjectId,
            "purpose" to this.purpose,
            "role_arn" to this.roleArn,
            "tenant_id" to this.tenantId,
            "vault_uri" to this.vaultUri,
            "workload_identity_pool_id" to this.workloadIdentityPoolId,
            "workload_identity_project_number" to this.workloadIdentityProjectNumber,
            "workload_identity_provider_id" to this.workloadIdentityProviderId,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExternalKey].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .apiProjectIds()
         * .createdAt()
         * .name()
         * .object_()
         * .type()
         * .workspaceId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExternalKey]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var apiProjectIds: JsonField<MutableList<String>>? = null
        private var createdAt: JsonField<Long>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonField<String>? = null
        private var type: JsonField<String>? = null
        private var workspaceId: JsonField<String>? = null
        private var audience: JsonField<String> = JsonMissing.of()
        private var externalId: JsonField<String> = JsonMissing.of()
        private var keyName: JsonField<String> = JsonMissing.of()
        private var keyVersion: JsonField<String> = JsonMissing.of()
        private var kmsArn: JsonField<String> = JsonMissing.of()
        private var kmsKeyLocation: JsonField<String> = JsonMissing.of()
        private var kmsKeyName: JsonField<String> = JsonMissing.of()
        private var kmsKeyRingName: JsonField<String> = JsonMissing.of()
        private var kmsKeyVersion: JsonField<String> = JsonMissing.of()
        private var kmsProjectId: JsonField<String> = JsonMissing.of()
        private var purpose: JsonField<Purpose> = JsonMissing.of()
        private var roleArn: JsonField<String> = JsonMissing.of()
        private var tenantId: JsonField<String> = JsonMissing.of()
        private var vaultUri: JsonField<String> = JsonMissing.of()
        private var workloadIdentityPoolId: JsonField<String> = JsonMissing.of()
        private var workloadIdentityProjectNumber: JsonField<String> = JsonMissing.of()
        private var workloadIdentityProviderId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(externalKey: ExternalKey) = apply {
            id = externalKey.id
            apiProjectIds = externalKey.apiProjectIds.map { it.toMutableList() }
            createdAt = externalKey.createdAt
            name = externalKey.name
            object_ = externalKey.object_
            type = externalKey.type
            workspaceId = externalKey.workspaceId
            audience = externalKey.audience
            externalId = externalKey.externalId
            keyName = externalKey.keyName
            keyVersion = externalKey.keyVersion
            kmsArn = externalKey.kmsArn
            kmsKeyLocation = externalKey.kmsKeyLocation
            kmsKeyName = externalKey.kmsKeyName
            kmsKeyRingName = externalKey.kmsKeyRingName
            kmsKeyVersion = externalKey.kmsKeyVersion
            kmsProjectId = externalKey.kmsProjectId
            purpose = externalKey.purpose
            roleArn = externalKey.roleArn
            tenantId = externalKey.tenantId
            vaultUri = externalKey.vaultUri
            workloadIdentityPoolId = externalKey.workloadIdentityPoolId
            workloadIdentityProjectNumber = externalKey.workloadIdentityProjectNumber
            workloadIdentityProviderId = externalKey.workloadIdentityProviderId
            additionalProperties = externalKey.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun apiProjectIds(apiProjectIds: List<String>) = apiProjectIds(JsonField.of(apiProjectIds))

        /**
         * Sets [Builder.apiProjectIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apiProjectIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun apiProjectIds(apiProjectIds: JsonField<List<String>>) = apply {
            this.apiProjectIds = apiProjectIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [apiProjectIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addApiProjectId(apiProjectId: String) = apply {
            apiProjectIds =
                (apiProjectIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("apiProjectIds", it).add(apiProjectId)
                }
        }

        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun object_(object_: String) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        fun workspaceId(workspaceId: String) = workspaceId(JsonField.of(workspaceId))

        /**
         * Sets [Builder.workspaceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workspaceId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun workspaceId(workspaceId: JsonField<String>) = apply { this.workspaceId = workspaceId }

        fun audience(audience: String) = audience(JsonField.of(audience))

        /**
         * Sets [Builder.audience] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audience] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audience(audience: JsonField<String>) = apply { this.audience = audience }

        fun externalId(externalId: String) = externalId(JsonField.of(externalId))

        /**
         * Sets [Builder.externalId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.externalId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun externalId(externalId: JsonField<String>) = apply { this.externalId = externalId }

        fun keyName(keyName: String) = keyName(JsonField.of(keyName))

        /**
         * Sets [Builder.keyName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.keyName] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun keyName(keyName: JsonField<String>) = apply { this.keyName = keyName }

        fun keyVersion(keyVersion: String) = keyVersion(JsonField.of(keyVersion))

        /**
         * Sets [Builder.keyVersion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.keyVersion] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun keyVersion(keyVersion: JsonField<String>) = apply { this.keyVersion = keyVersion }

        fun kmsArn(kmsArn: String) = kmsArn(JsonField.of(kmsArn))

        /**
         * Sets [Builder.kmsArn] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kmsArn] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun kmsArn(kmsArn: JsonField<String>) = apply { this.kmsArn = kmsArn }

        fun kmsKeyLocation(kmsKeyLocation: String) = kmsKeyLocation(JsonField.of(kmsKeyLocation))

        /**
         * Sets [Builder.kmsKeyLocation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kmsKeyLocation] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun kmsKeyLocation(kmsKeyLocation: JsonField<String>) = apply {
            this.kmsKeyLocation = kmsKeyLocation
        }

        fun kmsKeyName(kmsKeyName: String) = kmsKeyName(JsonField.of(kmsKeyName))

        /**
         * Sets [Builder.kmsKeyName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kmsKeyName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun kmsKeyName(kmsKeyName: JsonField<String>) = apply { this.kmsKeyName = kmsKeyName }

        fun kmsKeyRingName(kmsKeyRingName: String) = kmsKeyRingName(JsonField.of(kmsKeyRingName))

        /**
         * Sets [Builder.kmsKeyRingName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kmsKeyRingName] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun kmsKeyRingName(kmsKeyRingName: JsonField<String>) = apply {
            this.kmsKeyRingName = kmsKeyRingName
        }

        fun kmsKeyVersion(kmsKeyVersion: String) = kmsKeyVersion(JsonField.of(kmsKeyVersion))

        /**
         * Sets [Builder.kmsKeyVersion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kmsKeyVersion] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun kmsKeyVersion(kmsKeyVersion: JsonField<String>) = apply {
            this.kmsKeyVersion = kmsKeyVersion
        }

        fun kmsProjectId(kmsProjectId: String) = kmsProjectId(JsonField.of(kmsProjectId))

        /**
         * Sets [Builder.kmsProjectId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kmsProjectId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun kmsProjectId(kmsProjectId: JsonField<String>) = apply {
            this.kmsProjectId = kmsProjectId
        }

        fun purpose(purpose: Purpose) = purpose(JsonField.of(purpose))

        /**
         * Sets [Builder.purpose] to an arbitrary JSON value.
         *
         * You should usually call [Builder.purpose] with a well-typed [Purpose] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun purpose(purpose: JsonField<Purpose>) = apply { this.purpose = purpose }

        fun roleArn(roleArn: String) = roleArn(JsonField.of(roleArn))

        /**
         * Sets [Builder.roleArn] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roleArn] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun roleArn(roleArn: JsonField<String>) = apply { this.roleArn = roleArn }

        fun tenantId(tenantId: String) = tenantId(JsonField.of(tenantId))

        /**
         * Sets [Builder.tenantId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenantId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tenantId(tenantId: JsonField<String>) = apply { this.tenantId = tenantId }

        fun vaultUri(vaultUri: String) = vaultUri(JsonField.of(vaultUri))

        /**
         * Sets [Builder.vaultUri] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vaultUri] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun vaultUri(vaultUri: JsonField<String>) = apply { this.vaultUri = vaultUri }

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
         * Returns an immutable instance of [ExternalKey].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .apiProjectIds()
         * .createdAt()
         * .name()
         * .object_()
         * .type()
         * .workspaceId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExternalKey =
            ExternalKey(
                checkRequired("id", id),
                checkRequired("apiProjectIds", apiProjectIds).map { it.toImmutable() },
                checkRequired("createdAt", createdAt),
                checkRequired("name", name),
                checkRequired("object_", object_),
                checkRequired("type", type),
                checkRequired("workspaceId", workspaceId),
                audience,
                externalId,
                keyName,
                keyVersion,
                kmsArn,
                kmsKeyLocation,
                kmsKeyName,
                kmsKeyRingName,
                kmsKeyVersion,
                kmsProjectId,
                purpose,
                roleArn,
                tenantId,
                vaultUri,
                workloadIdentityPoolId,
                workloadIdentityProjectNumber,
                workloadIdentityProviderId,
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
    fun validate(): ExternalKey = apply {
        if (validated) {
            return@apply
        }

        id()
        apiProjectIds()
        createdAt()
        name()
        object_()
        type()
        workspaceId()
        audience()
        externalId()
        keyName()
        keyVersion()
        kmsArn()
        kmsKeyLocation()
        kmsKeyName()
        kmsKeyRingName()
        kmsKeyVersion()
        kmsProjectId()
        purpose().ifPresent { it.validate() }
        roleArn()
        tenantId()
        vaultUri()
        workloadIdentityPoolId()
        workloadIdentityProjectNumber()
        workloadIdentityProviderId()
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
            (apiProjectIds.asKnown().getOrNull()?.size ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (object_.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (workspaceId.asKnown().isPresent) 1 else 0) +
            (if (audience.asKnown().isPresent) 1 else 0) +
            (if (externalId.asKnown().isPresent) 1 else 0) +
            (if (keyName.asKnown().isPresent) 1 else 0) +
            (if (keyVersion.asKnown().isPresent) 1 else 0) +
            (if (kmsArn.asKnown().isPresent) 1 else 0) +
            (if (kmsKeyLocation.asKnown().isPresent) 1 else 0) +
            (if (kmsKeyName.asKnown().isPresent) 1 else 0) +
            (if (kmsKeyRingName.asKnown().isPresent) 1 else 0) +
            (if (kmsKeyVersion.asKnown().isPresent) 1 else 0) +
            (if (kmsProjectId.asKnown().isPresent) 1 else 0) +
            (purpose.asKnown().getOrNull()?.validity() ?: 0) +
            (if (roleArn.asKnown().isPresent) 1 else 0) +
            (if (tenantId.asKnown().isPresent) 1 else 0) +
            (if (vaultUri.asKnown().isPresent) 1 else 0) +
            (if (workloadIdentityPoolId.asKnown().isPresent) 1 else 0) +
            (if (workloadIdentityProjectNumber.asKnown().isPresent) 1 else 0) +
            (if (workloadIdentityProviderId.asKnown().isPresent) 1 else 0)

    class Purpose @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val EKM = of("ekm")

            @JvmField val PSP_DECRYPTION = of("psp_decryption")

            @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
        }

        /** An enum containing [Purpose]'s known values. */
        enum class Known {
            EKM,
            PSP_DECRYPTION,
        }

        /**
         * An enum containing [Purpose]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Purpose] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EKM,
            PSP_DECRYPTION,
            /** An enum member indicating that [Purpose] was instantiated with an unknown value. */
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
                EKM -> Value.EKM
                PSP_DECRYPTION -> Value.PSP_DECRYPTION
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
                EKM -> Known.EKM
                PSP_DECRYPTION -> Known.PSP_DECRYPTION
                else -> throw OpenAIInvalidDataException("Unknown Purpose: $value")
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
        fun validate(): Purpose = apply {
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

            return other is Purpose && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExternalKey &&
            id == other.id &&
            apiProjectIds == other.apiProjectIds &&
            createdAt == other.createdAt &&
            name == other.name &&
            object_ == other.object_ &&
            type == other.type &&
            workspaceId == other.workspaceId &&
            audience == other.audience &&
            externalId == other.externalId &&
            keyName == other.keyName &&
            keyVersion == other.keyVersion &&
            kmsArn == other.kmsArn &&
            kmsKeyLocation == other.kmsKeyLocation &&
            kmsKeyName == other.kmsKeyName &&
            kmsKeyRingName == other.kmsKeyRingName &&
            kmsKeyVersion == other.kmsKeyVersion &&
            kmsProjectId == other.kmsProjectId &&
            purpose == other.purpose &&
            roleArn == other.roleArn &&
            tenantId == other.tenantId &&
            vaultUri == other.vaultUri &&
            workloadIdentityPoolId == other.workloadIdentityPoolId &&
            workloadIdentityProjectNumber == other.workloadIdentityProjectNumber &&
            workloadIdentityProviderId == other.workloadIdentityProviderId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            apiProjectIds,
            createdAt,
            name,
            object_,
            type,
            workspaceId,
            audience,
            externalId,
            keyName,
            keyVersion,
            kmsArn,
            kmsKeyLocation,
            kmsKeyName,
            kmsKeyRingName,
            kmsKeyVersion,
            kmsProjectId,
            purpose,
            roleArn,
            tenantId,
            vaultUri,
            workloadIdentityPoolId,
            workloadIdentityProjectNumber,
            workloadIdentityProviderId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExternalKey{id=$id, apiProjectIds=$apiProjectIds, createdAt=$createdAt, name=$name, object_=$object_, type=$type, workspaceId=$workspaceId, audience=$audience, externalId=$externalId, keyName=$keyName, keyVersion=$keyVersion, kmsArn=$kmsArn, kmsKeyLocation=$kmsKeyLocation, kmsKeyName=$kmsKeyName, kmsKeyRingName=$kmsKeyRingName, kmsKeyVersion=$kmsKeyVersion, kmsProjectId=$kmsProjectId, purpose=$purpose, roleArn=$roleArn, tenantId=$tenantId, vaultUri=$vaultUri, workloadIdentityPoolId=$workloadIdentityPoolId, workloadIdentityProjectNumber=$workloadIdentityProjectNumber, workloadIdentityProviderId=$workloadIdentityProviderId, additionalProperties=$additionalProperties}"
}
