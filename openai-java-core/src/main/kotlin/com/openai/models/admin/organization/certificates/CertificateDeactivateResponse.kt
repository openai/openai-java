// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

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

/** Represents an individual certificate configured at the organization level. */
class CertificateDeactivateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val active: JsonField<Boolean>,
    private val certificateDetails: JsonField<CertificateDetails>,
    private val createdAt: JsonField<Long>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("active") @ExcludeMissing active: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("certificate_details")
        @ExcludeMissing
        certificateDetails: JsonField<CertificateDetails> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(id, active, certificateDetails, createdAt, name, object_, mutableMapOf())

    /**
     * The identifier, which can be referenced in API endpoints
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Whether the certificate is currently active at the organization level.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun active(): Boolean = active.getRequired("active")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun certificateDetails(): CertificateDetails =
        certificateDetails.getRequired("certificate_details")

    /**
     * The Unix timestamp (in seconds) of when the certificate was uploaded.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The name of the certificate.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The object type, which is always `organization.certificate`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("organization.certificate")
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
     * Returns the raw JSON value of [active].
     *
     * Unlike [active], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("active") @ExcludeMissing fun _active(): JsonField<Boolean> = active

    /**
     * Returns the raw JSON value of [certificateDetails].
     *
     * Unlike [certificateDetails], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("certificate_details")
    @ExcludeMissing
    fun _certificateDetails(): JsonField<CertificateDetails> = certificateDetails

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
         * Returns a mutable builder for constructing an instance of
         * [CertificateDeactivateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .active()
         * .certificateDetails()
         * .createdAt()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CertificateDeactivateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var active: JsonField<Boolean>? = null
        private var certificateDetails: JsonField<CertificateDetails>? = null
        private var createdAt: JsonField<Long>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("organization.certificate")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(certificateDeactivateResponse: CertificateDeactivateResponse) = apply {
            id = certificateDeactivateResponse.id
            active = certificateDeactivateResponse.active
            certificateDetails = certificateDeactivateResponse.certificateDetails
            createdAt = certificateDeactivateResponse.createdAt
            name = certificateDeactivateResponse.name
            object_ = certificateDeactivateResponse.object_
            additionalProperties = certificateDeactivateResponse.additionalProperties.toMutableMap()
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

        /** Whether the certificate is currently active at the organization level. */
        fun active(active: Boolean) = active(JsonField.of(active))

        /**
         * Sets [Builder.active] to an arbitrary JSON value.
         *
         * You should usually call [Builder.active] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun active(active: JsonField<Boolean>) = apply { this.active = active }

        fun certificateDetails(certificateDetails: CertificateDetails) =
            certificateDetails(JsonField.of(certificateDetails))

        /**
         * Sets [Builder.certificateDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.certificateDetails] with a well-typed
         * [CertificateDetails] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun certificateDetails(certificateDetails: JsonField<CertificateDetails>) = apply {
            this.certificateDetails = certificateDetails
        }

        /** The Unix timestamp (in seconds) of when the certificate was uploaded. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the certificate. */
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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("organization.certificate")
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
         * Returns an immutable instance of [CertificateDeactivateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .active()
         * .certificateDetails()
         * .createdAt()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CertificateDeactivateResponse =
            CertificateDeactivateResponse(
                checkRequired("id", id),
                checkRequired("active", active),
                checkRequired("certificateDetails", certificateDetails),
                checkRequired("createdAt", createdAt),
                checkRequired("name", name),
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
    fun validate(): CertificateDeactivateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        active()
        certificateDetails().validate()
        createdAt()
        name()
        _object_().let {
            if (it != JsonValue.from("organization.certificate")) {
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
            (if (active.asKnown().isPresent) 1 else 0) +
            (certificateDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("organization.certificate")) 1 else 0 }

    class CertificateDetails
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val expiresAt: JsonField<Long>,
        private val validAt: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("valid_at") @ExcludeMissing validAt: JsonField<Long> = JsonMissing.of(),
        ) : this(expiresAt, validAt, mutableMapOf())

        /**
         * The Unix timestamp (in seconds) of when the certificate expires.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAt(): Optional<Long> = expiresAt.getOptional("expires_at")

        /**
         * The Unix timestamp (in seconds) of when the certificate becomes valid.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun validAt(): Optional<Long> = validAt.getOptional("valid_at")

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

        /**
         * Returns the raw JSON value of [validAt].
         *
         * Unlike [validAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("valid_at") @ExcludeMissing fun _validAt(): JsonField<Long> = validAt

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

            /** Returns a mutable builder for constructing an instance of [CertificateDetails]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CertificateDetails]. */
        class Builder internal constructor() {

            private var expiresAt: JsonField<Long> = JsonMissing.of()
            private var validAt: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(certificateDetails: CertificateDetails) = apply {
                expiresAt = certificateDetails.expiresAt
                validAt = certificateDetails.validAt
                additionalProperties = certificateDetails.additionalProperties.toMutableMap()
            }

            /** The Unix timestamp (in seconds) of when the certificate expires. */
            fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

            /** The Unix timestamp (in seconds) of when the certificate becomes valid. */
            fun validAt(validAt: Long) = validAt(JsonField.of(validAt))

            /**
             * Sets [Builder.validAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.validAt] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun validAt(validAt: JsonField<Long>) = apply { this.validAt = validAt }

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
             * Returns an immutable instance of [CertificateDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CertificateDetails =
                CertificateDetails(expiresAt, validAt, additionalProperties.toMutableMap())
        }

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
        fun validate(): CertificateDetails = apply {
            if (validated) {
                return@apply
            }

            expiresAt()
            validAt()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (if (validAt.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CertificateDetails &&
                expiresAt == other.expiresAt &&
                validAt == other.validAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(expiresAt, validAt, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CertificateDetails{expiresAt=$expiresAt, validAt=$validAt, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CertificateDeactivateResponse &&
            id == other.id &&
            active == other.active &&
            certificateDetails == other.certificateDetails &&
            createdAt == other.createdAt &&
            name == other.name &&
            object_ == other.object_ &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, active, certificateDetails, createdAt, name, object_, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CertificateDeactivateResponse{id=$id, active=$active, certificateDetails=$certificateDetails, createdAt=$createdAt, name=$name, object_=$object_, additionalProperties=$additionalProperties}"
}
