// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

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
import com.openai.models.beta.chatkit.ChatKitWorkflow
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Represents a ChatKit session and its resolved configuration. */
class ChatSession
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val chatkitConfiguration: JsonField<ChatSessionChatKitConfiguration>,
    private val clientSecret: JsonField<String>,
    private val expiresAt: JsonField<Long>,
    private val maxRequestsPer1Minute: JsonField<Long>,
    private val object_: JsonValue,
    private val rateLimits: JsonField<ChatSessionRateLimits>,
    private val status: JsonField<ChatSessionStatus>,
    private val user: JsonField<String>,
    private val workflow: JsonField<ChatKitWorkflow>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("chatkit_configuration")
        @ExcludeMissing
        chatkitConfiguration: JsonField<ChatSessionChatKitConfiguration> = JsonMissing.of(),
        @JsonProperty("client_secret")
        @ExcludeMissing
        clientSecret: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_requests_per_1_minute")
        @ExcludeMissing
        maxRequestsPer1Minute: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("rate_limits")
        @ExcludeMissing
        rateLimits: JsonField<ChatSessionRateLimits> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<ChatSessionStatus> = JsonMissing.of(),
        @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
        @JsonProperty("workflow")
        @ExcludeMissing
        workflow: JsonField<ChatKitWorkflow> = JsonMissing.of(),
    ) : this(
        id,
        chatkitConfiguration,
        clientSecret,
        expiresAt,
        maxRequestsPer1Minute,
        object_,
        rateLimits,
        status,
        user,
        workflow,
        mutableMapOf(),
    )

    /**
     * Identifier for the ChatKit session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Resolved ChatKit feature configuration for the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chatkitConfiguration(): ChatSessionChatKitConfiguration =
        chatkitConfiguration.getRequired("chatkit_configuration")

    /**
     * Ephemeral client secret that authenticates session requests.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun clientSecret(): String = clientSecret.getRequired("client_secret")

    /**
     * Unix timestamp (in seconds) for when the session expires.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun expiresAt(): Long = expiresAt.getRequired("expires_at")

    /**
     * Convenience copy of the per-minute request limit.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun maxRequestsPer1Minute(): Long =
        maxRequestsPer1Minute.getRequired("max_requests_per_1_minute")

    /**
     * Type discriminator that is always `chatkit.session`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("chatkit.session")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Resolved rate limit values.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun rateLimits(): ChatSessionRateLimits = rateLimits.getRequired("rate_limits")

    /**
     * Current lifecycle state of the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): ChatSessionStatus = status.getRequired("status")

    /**
     * User identifier associated with the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun user(): String = user.getRequired("user")

    /**
     * Workflow metadata for the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun workflow(): ChatKitWorkflow = workflow.getRequired("workflow")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [chatkitConfiguration].
     *
     * Unlike [chatkitConfiguration], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("chatkit_configuration")
    @ExcludeMissing
    fun _chatkitConfiguration(): JsonField<ChatSessionChatKitConfiguration> = chatkitConfiguration

    /**
     * Returns the raw JSON value of [clientSecret].
     *
     * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client_secret")
    @ExcludeMissing
    fun _clientSecret(): JsonField<String> = clientSecret

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    /**
     * Returns the raw JSON value of [maxRequestsPer1Minute].
     *
     * Unlike [maxRequestsPer1Minute], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_requests_per_1_minute")
    @ExcludeMissing
    fun _maxRequestsPer1Minute(): JsonField<Long> = maxRequestsPer1Minute

    /**
     * Returns the raw JSON value of [rateLimits].
     *
     * Unlike [rateLimits], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rate_limits")
    @ExcludeMissing
    fun _rateLimits(): JsonField<ChatSessionRateLimits> = rateLimits

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<ChatSessionStatus> = status

    /**
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

    /**
     * Returns the raw JSON value of [workflow].
     *
     * Unlike [workflow], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("workflow") @ExcludeMissing fun _workflow(): JsonField<ChatKitWorkflow> = workflow

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
         * Returns a mutable builder for constructing an instance of [ChatSession].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .chatkitConfiguration()
         * .clientSecret()
         * .expiresAt()
         * .maxRequestsPer1Minute()
         * .rateLimits()
         * .status()
         * .user()
         * .workflow()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatSession]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var chatkitConfiguration: JsonField<ChatSessionChatKitConfiguration>? = null
        private var clientSecret: JsonField<String>? = null
        private var expiresAt: JsonField<Long>? = null
        private var maxRequestsPer1Minute: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("chatkit.session")
        private var rateLimits: JsonField<ChatSessionRateLimits>? = null
        private var status: JsonField<ChatSessionStatus>? = null
        private var user: JsonField<String>? = null
        private var workflow: JsonField<ChatKitWorkflow>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatSession: ChatSession) = apply {
            id = chatSession.id
            chatkitConfiguration = chatSession.chatkitConfiguration
            clientSecret = chatSession.clientSecret
            expiresAt = chatSession.expiresAt
            maxRequestsPer1Minute = chatSession.maxRequestsPer1Minute
            object_ = chatSession.object_
            rateLimits = chatSession.rateLimits
            status = chatSession.status
            user = chatSession.user
            workflow = chatSession.workflow
            additionalProperties = chatSession.additionalProperties.toMutableMap()
        }

        /** Identifier for the ChatKit session. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Resolved ChatKit feature configuration for the session. */
        fun chatkitConfiguration(chatkitConfiguration: ChatSessionChatKitConfiguration) =
            chatkitConfiguration(JsonField.of(chatkitConfiguration))

        /**
         * Sets [Builder.chatkitConfiguration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chatkitConfiguration] with a well-typed
         * [ChatSessionChatKitConfiguration] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun chatkitConfiguration(chatkitConfiguration: JsonField<ChatSessionChatKitConfiguration>) =
            apply {
                this.chatkitConfiguration = chatkitConfiguration
            }

        /** Ephemeral client secret that authenticates session requests. */
        fun clientSecret(clientSecret: String) = clientSecret(JsonField.of(clientSecret))

        /**
         * Sets [Builder.clientSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientSecret] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clientSecret(clientSecret: JsonField<String>) = apply {
            this.clientSecret = clientSecret
        }

        /** Unix timestamp (in seconds) for when the session expires. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** Convenience copy of the per-minute request limit. */
        fun maxRequestsPer1Minute(maxRequestsPer1Minute: Long) =
            maxRequestsPer1Minute(JsonField.of(maxRequestsPer1Minute))

        /**
         * Sets [Builder.maxRequestsPer1Minute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxRequestsPer1Minute] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxRequestsPer1Minute(maxRequestsPer1Minute: JsonField<Long>) = apply {
            this.maxRequestsPer1Minute = maxRequestsPer1Minute
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("chatkit.session")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Resolved rate limit values. */
        fun rateLimits(rateLimits: ChatSessionRateLimits) = rateLimits(JsonField.of(rateLimits))

        /**
         * Sets [Builder.rateLimits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rateLimits] with a well-typed [ChatSessionRateLimits]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun rateLimits(rateLimits: JsonField<ChatSessionRateLimits>) = apply {
            this.rateLimits = rateLimits
        }

        /** Current lifecycle state of the session. */
        fun status(status: ChatSessionStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [ChatSessionStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<ChatSessionStatus>) = apply { this.status = status }

        /** User identifier associated with the session. */
        fun user(user: String) = user(JsonField.of(user))

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun user(user: JsonField<String>) = apply { this.user = user }

        /** Workflow metadata for the session. */
        fun workflow(workflow: ChatKitWorkflow) = workflow(JsonField.of(workflow))

        /**
         * Sets [Builder.workflow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflow] with a well-typed [ChatKitWorkflow] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun workflow(workflow: JsonField<ChatKitWorkflow>) = apply { this.workflow = workflow }

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
         * Returns an immutable instance of [ChatSession].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .chatkitConfiguration()
         * .clientSecret()
         * .expiresAt()
         * .maxRequestsPer1Minute()
         * .rateLimits()
         * .status()
         * .user()
         * .workflow()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatSession =
            ChatSession(
                checkRequired("id", id),
                checkRequired("chatkitConfiguration", chatkitConfiguration),
                checkRequired("clientSecret", clientSecret),
                checkRequired("expiresAt", expiresAt),
                checkRequired("maxRequestsPer1Minute", maxRequestsPer1Minute),
                object_,
                checkRequired("rateLimits", rateLimits),
                checkRequired("status", status),
                checkRequired("user", user),
                checkRequired("workflow", workflow),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatSession = apply {
        if (validated) {
            return@apply
        }

        id()
        chatkitConfiguration().validate()
        clientSecret()
        expiresAt()
        maxRequestsPer1Minute()
        _object_().let {
            if (it != JsonValue.from("chatkit.session")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        rateLimits().validate()
        status().validate()
        user()
        workflow().validate()
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
            (chatkitConfiguration.asKnown().getOrNull()?.validity() ?: 0) +
            (if (clientSecret.asKnown().isPresent) 1 else 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (if (maxRequestsPer1Minute.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("chatkit.session")) 1 else 0 } +
            (rateLimits.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (user.asKnown().isPresent) 1 else 0) +
            (workflow.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatSession &&
            id == other.id &&
            chatkitConfiguration == other.chatkitConfiguration &&
            clientSecret == other.clientSecret &&
            expiresAt == other.expiresAt &&
            maxRequestsPer1Minute == other.maxRequestsPer1Minute &&
            object_ == other.object_ &&
            rateLimits == other.rateLimits &&
            status == other.status &&
            user == other.user &&
            workflow == other.workflow &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            chatkitConfiguration,
            clientSecret,
            expiresAt,
            maxRequestsPer1Minute,
            object_,
            rateLimits,
            status,
            user,
            workflow,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatSession{id=$id, chatkitConfiguration=$chatkitConfiguration, clientSecret=$clientSecret, expiresAt=$expiresAt, maxRequestsPer1Minute=$maxRequestsPer1Minute, object_=$object_, rateLimits=$rateLimits, status=$status, user=$user, workflow=$workflow, additionalProperties=$additionalProperties}"
}
