// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents an individual Admin API key in an org. */
class AdminApiKeyCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val object_: JsonValue,
    private val owner: JsonField<AdminApiKey.Owner>,
    private val redactedValue: JsonField<String>,
    private val lastUsedAt: JsonField<Long>,
    private val name: JsonField<String>,
    private val value: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("owner")
        @ExcludeMissing
        owner: JsonField<AdminApiKey.Owner> = JsonMissing.of(),
        @JsonProperty("redacted_value")
        @ExcludeMissing
        redactedValue: JsonField<String> = JsonMissing.of(),
        @JsonProperty("last_used_at")
        @ExcludeMissing
        lastUsedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
    ) : this(id, createdAt, object_, owner, redactedValue, lastUsedAt, name, value, mutableMapOf())

    fun toAdminApiKey(): AdminApiKey =
        AdminApiKey.builder()
            .id(id)
            .createdAt(createdAt)
            .object_(object_)
            .owner(owner)
            .redactedValue(redactedValue)
            .lastUsedAt(lastUsedAt)
            .name(name)
            .build()

    /**
     * The identifier, which can be referenced in API endpoints
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) of when the API key was created
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The object type, which is always `organization.admin_api_key`
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("organization.admin_api_key")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun owner(): AdminApiKey.Owner = owner.getRequired("owner")

    /**
     * The redacted value of the API key
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun redactedValue(): String = redactedValue.getRequired("redacted_value")

    /**
     * The Unix timestamp (in seconds) of when the API key was last used
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastUsedAt(): Optional<Long> = lastUsedAt.getOptional("last_used_at")

    /**
     * The name of the API key
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The value of the API key. Only shown on create.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun value(): String = value.getRequired("value")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [owner].
     *
     * Unlike [owner], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("owner") @ExcludeMissing fun _owner(): JsonField<AdminApiKey.Owner> = owner

    /**
     * Returns the raw JSON value of [redactedValue].
     *
     * Unlike [redactedValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("redacted_value")
    @ExcludeMissing
    fun _redactedValue(): JsonField<String> = redactedValue

    /**
     * Returns the raw JSON value of [lastUsedAt].
     *
     * Unlike [lastUsedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_used_at") @ExcludeMissing fun _lastUsedAt(): JsonField<Long> = lastUsedAt

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [value].
     *
     * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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
         * Returns a mutable builder for constructing an instance of [AdminApiKeyCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .owner()
         * .redactedValue()
         * .value()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AdminApiKeyCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("organization.admin_api_key")
        private var owner: JsonField<AdminApiKey.Owner>? = null
        private var redactedValue: JsonField<String>? = null
        private var lastUsedAt: JsonField<Long> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var value: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(adminApiKeyCreateResponse: AdminApiKeyCreateResponse) = apply {
            id = adminApiKeyCreateResponse.id
            createdAt = adminApiKeyCreateResponse.createdAt
            object_ = adminApiKeyCreateResponse.object_
            owner = adminApiKeyCreateResponse.owner
            redactedValue = adminApiKeyCreateResponse.redactedValue
            lastUsedAt = adminApiKeyCreateResponse.lastUsedAt
            name = adminApiKeyCreateResponse.name
            value = adminApiKeyCreateResponse.value
            additionalProperties = adminApiKeyCreateResponse.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) of when the API key was created */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("organization.admin_api_key")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        fun owner(owner: AdminApiKey.Owner) = owner(JsonField.of(owner))

        /**
         * Sets [Builder.owner] to an arbitrary JSON value.
         *
         * You should usually call [Builder.owner] with a well-typed [AdminApiKey.Owner] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun owner(owner: JsonField<AdminApiKey.Owner>) = apply { this.owner = owner }

        /** The redacted value of the API key */
        fun redactedValue(redactedValue: String) = redactedValue(JsonField.of(redactedValue))

        /**
         * Sets [Builder.redactedValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.redactedValue] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun redactedValue(redactedValue: JsonField<String>) = apply {
            this.redactedValue = redactedValue
        }

        /** The Unix timestamp (in seconds) of when the API key was last used */
        fun lastUsedAt(lastUsedAt: Long?) = lastUsedAt(JsonField.ofNullable(lastUsedAt))

        /**
         * Alias for [Builder.lastUsedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun lastUsedAt(lastUsedAt: Long) = lastUsedAt(lastUsedAt as Long?)

        /** Alias for calling [Builder.lastUsedAt] with `lastUsedAt.orElse(null)`. */
        fun lastUsedAt(lastUsedAt: Optional<Long>) = lastUsedAt(lastUsedAt.getOrNull())

        /**
         * Sets [Builder.lastUsedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastUsedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lastUsedAt(lastUsedAt: JsonField<Long>) = apply { this.lastUsedAt = lastUsedAt }

        /** The name of the API key */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The value of the API key. Only shown on create. */
        fun value(value: String) = value(JsonField.of(value))

        /**
         * Sets [Builder.value] to an arbitrary JSON value.
         *
         * You should usually call [Builder.value] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun value(value: JsonField<String>) = apply { this.value = value }

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
         * Returns an immutable instance of [AdminApiKeyCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .owner()
         * .redactedValue()
         * .value()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AdminApiKeyCreateResponse =
            AdminApiKeyCreateResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                object_,
                checkRequired("owner", owner),
                checkRequired("redactedValue", redactedValue),
                lastUsedAt,
                name,
                checkRequired("value", value),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AdminApiKeyCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        _object_().let {
            if (it != JsonValue.from("organization.admin_api_key")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        owner().validate()
        redactedValue()
        lastUsedAt()
        name()
        value()
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("organization.admin_api_key")) 1 else 0 } +
            (owner.asKnown().getOrNull()?.validity() ?: 0) +
            (if (redactedValue.asKnown().isPresent) 1 else 0) +
            (if (lastUsedAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (value.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AdminApiKeyCreateResponse &&
            id == other.id &&
            createdAt == other.createdAt &&
            object_ == other.object_ &&
            owner == other.owner &&
            redactedValue == other.redactedValue &&
            lastUsedAt == other.lastUsedAt &&
            name == other.name &&
            value == other.value &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            object_,
            owner,
            redactedValue,
            lastUsedAt,
            name,
            value,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AdminApiKeyCreateResponse{id=$id, createdAt=$createdAt, object_=$object_, owner=$owner, redactedValue=$redactedValue, lastUsedAt=$lastUsedAt, name=$name, value=$value, additionalProperties=$additionalProperties}"
}
