// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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

/** Represents an individual `certificate` uploaded to the organization. */
class Certificate
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val certificateDetails: JsonField<CertificateDetails>,
    private val createdAt: JsonField<Long>,
    private val name: JsonField<String>,
    private val object_: JsonField<Object>,
    private val active: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("certificate_details")
        @ExcludeMissing
        certificateDetails: JsonField<CertificateDetails> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("active") @ExcludeMissing active: JsonField<Boolean> = JsonMissing.of(),
    ) : this(id, certificateDetails, createdAt, name, object_, active, mutableMapOf())

    /**
     * The identifier, which can be referenced in API endpoints
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

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
     * The object type.
     * - If creating, updating, or getting a specific certificate, the object type is `certificate`.
     * - If listing, activating, or deactivating certificates for the organization, the object type
     *   is `organization.certificate`.
     * - If listing, activating, or deactivating certificates for a project, the object type is
     *   `organization.project.certificate`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): Object = object_.getRequired("object")

    /**
     * Whether the certificate is currently active at the specified scope. Not returned when getting
     * details for a specific certificate.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun active(): Optional<Boolean> = active.getOptional("active")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [active].
     *
     * Unlike [active], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("active") @ExcludeMissing fun _active(): JsonField<Boolean> = active

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
         * Returns a mutable builder for constructing an instance of [Certificate].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .certificateDetails()
         * .createdAt()
         * .name()
         * .object_()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Certificate]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var certificateDetails: JsonField<CertificateDetails>? = null
        private var createdAt: JsonField<Long>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonField<Object>? = null
        private var active: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(certificate: Certificate) = apply {
            id = certificate.id
            certificateDetails = certificate.certificateDetails
            createdAt = certificate.createdAt
            name = certificate.name
            object_ = certificate.object_
            active = certificate.active
            additionalProperties = certificate.additionalProperties.toMutableMap()
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
         * The object type.
         * - If creating, updating, or getting a specific certificate, the object type is
         *   `certificate`.
         * - If listing, activating, or deactivating certificates for the organization, the object
         *   type is `organization.certificate`.
         * - If listing, activating, or deactivating certificates for a project, the object type is
         *   `organization.project.certificate`.
         */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /**
         * Whether the certificate is currently active at the specified scope. Not returned when
         * getting details for a specific certificate.
         */
        fun active(active: Boolean) = active(JsonField.of(active))

        /**
         * Sets [Builder.active] to an arbitrary JSON value.
         *
         * You should usually call [Builder.active] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun active(active: JsonField<Boolean>) = apply { this.active = active }

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
         * Returns an immutable instance of [Certificate].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .certificateDetails()
         * .createdAt()
         * .name()
         * .object_()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Certificate =
            Certificate(
                checkRequired("id", id),
                checkRequired("certificateDetails", certificateDetails),
                checkRequired("createdAt", createdAt),
                checkRequired("name", name),
                checkRequired("object_", object_),
                active,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Certificate = apply {
        if (validated) {
            return@apply
        }

        id()
        certificateDetails().validate()
        createdAt()
        name()
        object_().validate()
        active()
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
            (certificateDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (active.asKnown().isPresent) 1 else 0)

    class CertificateDetails
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonField<String>,
        private val expiresAt: JsonField<Long>,
        private val validAt: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content") @ExcludeMissing content: JsonField<String> = JsonMissing.of(),
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("valid_at") @ExcludeMissing validAt: JsonField<Long> = JsonMissing.of(),
        ) : this(content, expiresAt, validAt, mutableMapOf())

        /**
         * The content of the certificate in PEM format.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun content(): Optional<String> = content.getOptional("content")

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
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

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

            private var content: JsonField<String> = JsonMissing.of()
            private var expiresAt: JsonField<Long> = JsonMissing.of()
            private var validAt: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(certificateDetails: CertificateDetails) = apply {
                content = certificateDetails.content
                expiresAt = certificateDetails.expiresAt
                validAt = certificateDetails.validAt
                additionalProperties = certificateDetails.additionalProperties.toMutableMap()
            }

            /** The content of the certificate in PEM format. */
            fun content(content: String) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<String>) = apply { this.content = content }

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
                CertificateDetails(content, expiresAt, validAt, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): CertificateDetails = apply {
            if (validated) {
                return@apply
            }

            content()
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
            (if (content.asKnown().isPresent) 1 else 0) +
                (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (if (validAt.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CertificateDetails &&
                content == other.content &&
                expiresAt == other.expiresAt &&
                validAt == other.validAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(content, expiresAt, validAt, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CertificateDetails{content=$content, expiresAt=$expiresAt, validAt=$validAt, additionalProperties=$additionalProperties}"
    }

    /**
     * The object type.
     * - If creating, updating, or getting a specific certificate, the object type is `certificate`.
     * - If listing, activating, or deactivating certificates for the organization, the object type
     *   is `organization.certificate`.
     * - If listing, activating, or deactivating certificates for a project, the object type is
     *   `organization.project.certificate`.
     */
    class Object @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val CERTIFICATE = of("certificate")

            @JvmField val ORGANIZATION_CERTIFICATE = of("organization.certificate")

            @JvmField val ORGANIZATION_PROJECT_CERTIFICATE = of("organization.project.certificate")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            CERTIFICATE,
            ORGANIZATION_CERTIFICATE,
            ORGANIZATION_PROJECT_CERTIFICATE,
        }

        /**
         * An enum containing [Object]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Object] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CERTIFICATE,
            ORGANIZATION_CERTIFICATE,
            ORGANIZATION_PROJECT_CERTIFICATE,
            /** An enum member indicating that [Object] was instantiated with an unknown value. */
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
                CERTIFICATE -> Value.CERTIFICATE
                ORGANIZATION_CERTIFICATE -> Value.ORGANIZATION_CERTIFICATE
                ORGANIZATION_PROJECT_CERTIFICATE -> Value.ORGANIZATION_PROJECT_CERTIFICATE
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
                CERTIFICATE -> Known.CERTIFICATE
                ORGANIZATION_CERTIFICATE -> Known.ORGANIZATION_CERTIFICATE
                ORGANIZATION_PROJECT_CERTIFICATE -> Known.ORGANIZATION_PROJECT_CERTIFICATE
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
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

        fun validate(): Object = apply {
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

            return other is Object && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Certificate &&
            id == other.id &&
            certificateDetails == other.certificateDetails &&
            createdAt == other.createdAt &&
            name == other.name &&
            object_ == other.object_ &&
            active == other.active &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, certificateDetails, createdAt, name, object_, active, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Certificate{id=$id, certificateDetails=$certificateDetails, createdAt=$createdAt, name=$name, object_=$object_, active=$active, additionalProperties=$additionalProperties}"
}
