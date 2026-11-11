// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonNull
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

class WebhookEndpointWithSecret
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val eventTypes: JsonField<List<String>>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val signingSecret: JsonField<String>,
    private val signingSecretHint: JsonField<String>,
    private val url: JsonField<String>,
    private val updatedAt: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("event_types")
        @ExcludeMissing
        eventTypes: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("signing_secret")
        @ExcludeMissing
        signingSecret: JsonField<String> = JsonMissing.of(),
        @JsonProperty("signing_secret_hint")
        @ExcludeMissing
        signingSecretHint: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<Long> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        eventTypes,
        name,
        object_,
        signingSecret,
        signingSecretHint,
        url,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The unique ID of the webhook endpoint. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun id(): java.util.Optional<String> = id.getOptional("id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun idOrThrow(): String = id.getRequired("id")

    /**
     * The Unix timestamp when the endpoint was created. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun createdAt(): java.util.Optional<Long> = createdAt.getOptional("created_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun createdAtOrThrow(): Long = createdAt.getRequired("created_at")

    /**
     * The event types that trigger deliveries to this endpoint. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun eventTypes(): java.util.Optional<List<String>> = eventTypes.getOptional("event_types")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun eventTypesOrThrow(): List<String> = eventTypes.getRequired("event_types")

    /**
     * The human-readable name of the endpoint. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun name(): java.util.Optional<String> = name.getOptional("name")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun nameOrThrow(): String = name.getRequired("name")

    /**
     * The object type, which is always webhook_endpoint. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("webhook_endpoint")) ->
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
     * The endpoint's signing secret. This is returned only when the endpoint is created or the
     * secret is rotated. The schema requires this property. Returns empty if the JSON property is
     * missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun signingSecret(): java.util.Optional<String> = signingSecret.getOptional("signing_secret")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun signingSecretOrThrow(): String = signingSecret.getRequired("signing_secret")

    /**
     * A masked hint for the endpoint's signing secret. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun signingSecretHint(): java.util.Optional<String> =
        signingSecretHint.getOptional("signing_secret_hint")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun signingSecretHintOrThrow(): String = signingSecretHint.getRequired("signing_secret_hint")

    /**
     * The HTTPS URL that receives webhook deliveries. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun url(): java.util.Optional<String> = url.getOptional("url")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun urlOrThrow(): String = url.getRequired("url")

    /**
     * The Unix timestamp of the last endpoint configuration or signing-secret change. Initialized
     * at creation; tests and unchanged updates do not advance it. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun updatedAt(): java.util.Optional<Long> = updatedAt.getOptional("updated_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun updatedAtOrThrow(): Long = updatedAt.getRequired("updated_at")

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
     * Returns the raw JSON value of [eventTypes].
     *
     * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_types")
    @ExcludeMissing
    fun _eventTypes(): JsonField<List<String>> = eventTypes

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [signingSecret].
     *
     * Unlike [signingSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("signing_secret")
    @ExcludeMissing
    fun _signingSecret(): JsonField<String> = signingSecret

    /**
     * Returns the raw JSON value of [signingSecretHint].
     *
     * Unlike [signingSecretHint], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("signing_secret_hint")
    @ExcludeMissing
    fun _signingSecretHint(): JsonField<String> = signingSecretHint

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<Long> = updatedAt

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
            "created_at" to this.createdAt,
            "event_types" to this.eventTypes,
            "name" to this.name,
            "object" to this.object_,
            "signing_secret" to this.signingSecret,
            "signing_secret_hint" to this.signingSecretHint,
            "url" to this.url,
            "updated_at" to this.updatedAt,
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
         * Returns a mutable builder for constructing an instance of [WebhookEndpointWithSecret].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .eventTypes()
         * .name()
         * .signingSecret()
         * .url()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookEndpointWithSecret]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var eventTypes: JsonField<MutableList<String>>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("webhook_endpoint")
        private var signingSecret: JsonField<String>? = null
        private var signingSecretHint: JsonField<String>? = JsonNull.of()
        private var url: JsonField<String>? = null
        private var updatedAt: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookEndpointWithSecret: WebhookEndpointWithSecret) = apply {
            id = webhookEndpointWithSecret.id
            createdAt = webhookEndpointWithSecret.createdAt
            eventTypes = webhookEndpointWithSecret.eventTypes.map { it.toMutableList() }
            name = webhookEndpointWithSecret.name
            object_ = webhookEndpointWithSecret.object_
            signingSecret = webhookEndpointWithSecret.signingSecret
            signingSecretHint = webhookEndpointWithSecret.signingSecretHint
            url = webhookEndpointWithSecret.url
            updatedAt = webhookEndpointWithSecret.updatedAt
            additionalProperties = webhookEndpointWithSecret.additionalProperties.toMutableMap()
        }

        /** The unique ID of the webhook endpoint. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp when the endpoint was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The event types that trigger deliveries to this endpoint. */
        fun eventTypes(eventTypes: List<String>) = eventTypes(JsonField.of(eventTypes))

        /**
         * Sets [Builder.eventTypes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventTypes] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventTypes(eventTypes: JsonField<List<String>>) = apply {
            this.eventTypes = eventTypes.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [eventTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEventType(eventType: String) = apply {
            eventTypes =
                (eventTypes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("eventTypes", it).add(eventType)
                }
        }

        /** The human-readable name of the endpoint. */
        fun name(name: String) = name(JsonField.of(name))

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
         * JsonValue.from("webhook_endpoint")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * The endpoint's signing secret. This is returned only when the endpoint is created or the
         * secret is rotated.
         */
        fun signingSecret(signingSecret: String) = signingSecret(JsonField.of(signingSecret))

        /**
         * Sets [Builder.signingSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.signingSecret] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun signingSecret(signingSecret: JsonField<String>) = apply {
            this.signingSecret = signingSecret
        }

        /** A masked hint for the endpoint's signing secret. */
        fun signingSecretHint(signingSecretHint: String?) =
            signingSecretHint(JsonField.ofNullable(signingSecretHint))

        /** Alias for calling [Builder.signingSecretHint] with `signingSecretHint.orElse(null)`. */
        fun signingSecretHint(signingSecretHint: Optional<String>) =
            signingSecretHint(signingSecretHint.getOrNull())

        /**
         * Sets [Builder.signingSecretHint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.signingSecretHint] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun signingSecretHint(signingSecretHint: JsonField<String>) = apply {
            this.signingSecretHint = signingSecretHint
        }

        /** The HTTPS URL that receives webhook deliveries. */
        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

        /**
         * The Unix timestamp of the last endpoint configuration or signing-secret change.
         * Initialized at creation; tests and unchanged updates do not advance it.
         */
        fun updatedAt(updatedAt: Long) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun updatedAt(updatedAt: JsonField<Long>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [WebhookEndpointWithSecret].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .eventTypes()
         * .name()
         * .signingSecret()
         * .url()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WebhookEndpointWithSecret =
            WebhookEndpointWithSecret(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("eventTypes", eventTypes).map { it.toImmutable() },
                checkRequired("name", name),
                object_,
                checkRequired("signingSecret", signingSecret),
                checkRequired("signingSecretHint", signingSecretHint),
                checkRequired("url", url),
                updatedAt,
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
    fun validate(): WebhookEndpointWithSecret = apply {
        if (validated) {
            return@apply
        }

        idOrThrow()
        createdAtOrThrow()
        eventTypesOrThrow()
        nameOrThrow()
        object_OrThrow()
        signingSecretOrThrow()
        signingSecretHint()
        urlOrThrow()
        updatedAt()
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
            (eventTypes.asKnown().getOrNull()?.size ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("webhook_endpoint")) 1 else 0 } +
            (if (signingSecret.asKnown().isPresent) 1 else 0) +
            (if (signingSecretHint.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookEndpointWithSecret &&
            id == other.id &&
            createdAt == other.createdAt &&
            eventTypes == other.eventTypes &&
            name == other.name &&
            object_ == other.object_ &&
            signingSecret == other.signingSecret &&
            signingSecretHint == other.signingSecretHint &&
            url == other.url &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            eventTypes,
            name,
            object_,
            signingSecret,
            signingSecretHint,
            url,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookEndpointWithSecret{id=$id, createdAt=$createdAt, eventTypes=$eventTypes, name=$name, object_=$object_, signingSecret=[REDACTED], signingSecretHint=$signingSecretHint, url=$url, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
