// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import kotlin.jvm.optionals.getOrNull

/** Response from creating a translation session and client secret for the Realtime API. */
class RealtimeTranslationClientSecretCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val expiresAt: JsonField<Long>,
    private val session: JsonField<RealtimeTranslationSession>,
    private val value: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("session")
        @ExcludeMissing
        session: JsonField<RealtimeTranslationSession> = JsonMissing.of(),
        @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
    ) : this(expiresAt, session, value, mutableMapOf())

    /**
     * Expiration timestamp for the client secret, in seconds since epoch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun expiresAt(): Long = expiresAt.getRequired("expires_at")

    /**
     * A Realtime translation session. Translation sessions continuously translate input audio into
     * the configured output language.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun session(): RealtimeTranslationSession = session.getRequired("session")

    /**
     * The generated client secret value.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun value(): String = value.getRequired("value")

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    /**
     * Returns the raw JSON value of [session].
     *
     * Unlike [session], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session")
    @ExcludeMissing
    fun _session(): JsonField<RealtimeTranslationSession> = session

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
         * Returns a mutable builder for constructing an instance of
         * [RealtimeTranslationClientSecretCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .expiresAt()
         * .session()
         * .value()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTranslationClientSecretCreateResponse]. */
    class Builder internal constructor() {

        private var expiresAt: JsonField<Long>? = null
        private var session: JsonField<RealtimeTranslationSession>? = null
        private var value: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeTranslationClientSecretCreateResponse:
                RealtimeTranslationClientSecretCreateResponse
        ) = apply {
            expiresAt = realtimeTranslationClientSecretCreateResponse.expiresAt
            session = realtimeTranslationClientSecretCreateResponse.session
            value = realtimeTranslationClientSecretCreateResponse.value
            additionalProperties =
                realtimeTranslationClientSecretCreateResponse.additionalProperties.toMutableMap()
        }

        /** Expiration timestamp for the client secret, in seconds since epoch. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /**
         * A Realtime translation session. Translation sessions continuously translate input audio
         * into the configured output language.
         */
        fun session(session: RealtimeTranslationSession) = session(JsonField.of(session))

        /**
         * Sets [Builder.session] to an arbitrary JSON value.
         *
         * You should usually call [Builder.session] with a well-typed [RealtimeTranslationSession]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun session(session: JsonField<RealtimeTranslationSession>) = apply {
            this.session = session
        }

        /** The generated client secret value. */
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
         * Returns an immutable instance of [RealtimeTranslationClientSecretCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .expiresAt()
         * .session()
         * .value()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeTranslationClientSecretCreateResponse =
            RealtimeTranslationClientSecretCreateResponse(
                checkRequired("expiresAt", expiresAt),
                checkRequired("session", session),
                checkRequired("value", value),
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
    fun validate(): RealtimeTranslationClientSecretCreateResponse = apply {
        if (validated) {
            return@apply
        }

        expiresAt()
        session().validate()
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
        (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (session.asKnown().getOrNull()?.validity() ?: 0) +
            (if (value.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranslationClientSecretCreateResponse &&
            expiresAt == other.expiresAt &&
            session == other.session &&
            value == other.value &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(expiresAt, session, value, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeTranslationClientSecretCreateResponse{expiresAt=$expiresAt, session=$session, value=$value, additionalProperties=$additionalProperties}"
}
