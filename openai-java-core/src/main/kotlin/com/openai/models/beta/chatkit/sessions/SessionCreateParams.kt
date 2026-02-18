// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.sessions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.chatkit.threads.ChatSessionChatKitConfigurationParam
import com.openai.models.beta.chatkit.threads.ChatSessionExpiresAfterParam
import com.openai.models.beta.chatkit.threads.ChatSessionRateLimitsParam
import com.openai.models.beta.chatkit.threads.ChatSessionWorkflowParam
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a ChatKit session. */
class SessionCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A free-form string that identifies your end user; ensures this Session can access other
     * objects that have the same `user` scope.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun user(): String = body.user()

    /**
     * Workflow that powers the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun workflow(): ChatSessionWorkflowParam = body.workflow()

    /**
     * Optional overrides for ChatKit runtime configuration features
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun chatkitConfiguration(): Optional<ChatSessionChatKitConfigurationParam> =
        body.chatkitConfiguration()

    /**
     * Optional override for session expiration timing in seconds from creation. Defaults to 10
     * minutes.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAfter(): Optional<ChatSessionExpiresAfterParam> = body.expiresAfter()

    /**
     * Optional override for per-minute request limits. When omitted, defaults to 10.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rateLimits(): Optional<ChatSessionRateLimitsParam> = body.rateLimits()

    /**
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _user(): JsonField<String> = body._user()

    /**
     * Returns the raw JSON value of [workflow].
     *
     * Unlike [workflow], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _workflow(): JsonField<ChatSessionWorkflowParam> = body._workflow()

    /**
     * Returns the raw JSON value of [chatkitConfiguration].
     *
     * Unlike [chatkitConfiguration], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _chatkitConfiguration(): JsonField<ChatSessionChatKitConfigurationParam> =
        body._chatkitConfiguration()

    /**
     * Returns the raw JSON value of [expiresAfter].
     *
     * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _expiresAfter(): JsonField<ChatSessionExpiresAfterParam> = body._expiresAfter()

    /**
     * Returns the raw JSON value of [rateLimits].
     *
     * Unlike [rateLimits], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _rateLimits(): JsonField<ChatSessionRateLimitsParam> = body._rateLimits()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SessionCreateParams].
         *
         * The following fields are required:
         * ```java
         * .user()
         * .workflow()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(sessionCreateParams: SessionCreateParams) = apply {
            body = sessionCreateParams.body.toBuilder()
            additionalHeaders = sessionCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = sessionCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [user]
         * - [workflow]
         * - [chatkitConfiguration]
         * - [expiresAfter]
         * - [rateLimits]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * A free-form string that identifies your end user; ensures this Session can access other
         * objects that have the same `user` scope.
         */
        fun user(user: String) = apply { body.user(user) }

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun user(user: JsonField<String>) = apply { body.user(user) }

        /** Workflow that powers the session. */
        fun workflow(workflow: ChatSessionWorkflowParam) = apply { body.workflow(workflow) }

        /**
         * Sets [Builder.workflow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflow] with a well-typed [ChatSessionWorkflowParam]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun workflow(workflow: JsonField<ChatSessionWorkflowParam>) = apply {
            body.workflow(workflow)
        }

        /** Optional overrides for ChatKit runtime configuration features */
        fun chatkitConfiguration(chatkitConfiguration: ChatSessionChatKitConfigurationParam) =
            apply {
                body.chatkitConfiguration(chatkitConfiguration)
            }

        /**
         * Sets [Builder.chatkitConfiguration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chatkitConfiguration] with a well-typed
         * [ChatSessionChatKitConfigurationParam] value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun chatkitConfiguration(
            chatkitConfiguration: JsonField<ChatSessionChatKitConfigurationParam>
        ) = apply { body.chatkitConfiguration(chatkitConfiguration) }

        /**
         * Optional override for session expiration timing in seconds from creation. Defaults to 10
         * minutes.
         */
        fun expiresAfter(expiresAfter: ChatSessionExpiresAfterParam) = apply {
            body.expiresAfter(expiresAfter)
        }

        /**
         * Sets [Builder.expiresAfter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAfter] with a well-typed
         * [ChatSessionExpiresAfterParam] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun expiresAfter(expiresAfter: JsonField<ChatSessionExpiresAfterParam>) = apply {
            body.expiresAfter(expiresAfter)
        }

        /** Optional override for per-minute request limits. When omitted, defaults to 10. */
        fun rateLimits(rateLimits: ChatSessionRateLimitsParam) = apply {
            body.rateLimits(rateLimits)
        }

        /**
         * Sets [Builder.rateLimits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rateLimits] with a well-typed
         * [ChatSessionRateLimitsParam] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun rateLimits(rateLimits: JsonField<ChatSessionRateLimitsParam>) = apply {
            body.rateLimits(rateLimits)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [SessionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .user()
         * .workflow()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SessionCreateParams =
            SessionCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Parameters for provisioning a new ChatKit session. */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val user: JsonField<String>,
        private val workflow: JsonField<ChatSessionWorkflowParam>,
        private val chatkitConfiguration: JsonField<ChatSessionChatKitConfigurationParam>,
        private val expiresAfter: JsonField<ChatSessionExpiresAfterParam>,
        private val rateLimits: JsonField<ChatSessionRateLimitsParam>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
            @JsonProperty("workflow")
            @ExcludeMissing
            workflow: JsonField<ChatSessionWorkflowParam> = JsonMissing.of(),
            @JsonProperty("chatkit_configuration")
            @ExcludeMissing
            chatkitConfiguration: JsonField<ChatSessionChatKitConfigurationParam> =
                JsonMissing.of(),
            @JsonProperty("expires_after")
            @ExcludeMissing
            expiresAfter: JsonField<ChatSessionExpiresAfterParam> = JsonMissing.of(),
            @JsonProperty("rate_limits")
            @ExcludeMissing
            rateLimits: JsonField<ChatSessionRateLimitsParam> = JsonMissing.of(),
        ) : this(user, workflow, chatkitConfiguration, expiresAfter, rateLimits, mutableMapOf())

        /**
         * A free-form string that identifies your end user; ensures this Session can access other
         * objects that have the same `user` scope.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun user(): String = user.getRequired("user")

        /**
         * Workflow that powers the session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun workflow(): ChatSessionWorkflowParam = workflow.getRequired("workflow")

        /**
         * Optional overrides for ChatKit runtime configuration features
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun chatkitConfiguration(): Optional<ChatSessionChatKitConfigurationParam> =
            chatkitConfiguration.getOptional("chatkit_configuration")

        /**
         * Optional override for session expiration timing in seconds from creation. Defaults to 10
         * minutes.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAfter(): Optional<ChatSessionExpiresAfterParam> =
            expiresAfter.getOptional("expires_after")

        /**
         * Optional override for per-minute request limits. When omitted, defaults to 10.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun rateLimits(): Optional<ChatSessionRateLimitsParam> =
            rateLimits.getOptional("rate_limits")

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
        @JsonProperty("workflow")
        @ExcludeMissing
        fun _workflow(): JsonField<ChatSessionWorkflowParam> = workflow

        /**
         * Returns the raw JSON value of [chatkitConfiguration].
         *
         * Unlike [chatkitConfiguration], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("chatkit_configuration")
        @ExcludeMissing
        fun _chatkitConfiguration(): JsonField<ChatSessionChatKitConfigurationParam> =
            chatkitConfiguration

        /**
         * Returns the raw JSON value of [expiresAfter].
         *
         * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("expires_after")
        @ExcludeMissing
        fun _expiresAfter(): JsonField<ChatSessionExpiresAfterParam> = expiresAfter

        /**
         * Returns the raw JSON value of [rateLimits].
         *
         * Unlike [rateLimits], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rate_limits")
        @ExcludeMissing
        fun _rateLimits(): JsonField<ChatSessionRateLimitsParam> = rateLimits

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .user()
             * .workflow()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var user: JsonField<String>? = null
            private var workflow: JsonField<ChatSessionWorkflowParam>? = null
            private var chatkitConfiguration: JsonField<ChatSessionChatKitConfigurationParam> =
                JsonMissing.of()
            private var expiresAfter: JsonField<ChatSessionExpiresAfterParam> = JsonMissing.of()
            private var rateLimits: JsonField<ChatSessionRateLimitsParam> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                user = body.user
                workflow = body.workflow
                chatkitConfiguration = body.chatkitConfiguration
                expiresAfter = body.expiresAfter
                rateLimits = body.rateLimits
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * A free-form string that identifies your end user; ensures this Session can access
             * other objects that have the same `user` scope.
             */
            fun user(user: String) = user(JsonField.of(user))

            /**
             * Sets [Builder.user] to an arbitrary JSON value.
             *
             * You should usually call [Builder.user] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun user(user: JsonField<String>) = apply { this.user = user }

            /** Workflow that powers the session. */
            fun workflow(workflow: ChatSessionWorkflowParam) = workflow(JsonField.of(workflow))

            /**
             * Sets [Builder.workflow] to an arbitrary JSON value.
             *
             * You should usually call [Builder.workflow] with a well-typed
             * [ChatSessionWorkflowParam] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun workflow(workflow: JsonField<ChatSessionWorkflowParam>) = apply {
                this.workflow = workflow
            }

            /** Optional overrides for ChatKit runtime configuration features */
            fun chatkitConfiguration(chatkitConfiguration: ChatSessionChatKitConfigurationParam) =
                chatkitConfiguration(JsonField.of(chatkitConfiguration))

            /**
             * Sets [Builder.chatkitConfiguration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chatkitConfiguration] with a well-typed
             * [ChatSessionChatKitConfigurationParam] value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun chatkitConfiguration(
                chatkitConfiguration: JsonField<ChatSessionChatKitConfigurationParam>
            ) = apply { this.chatkitConfiguration = chatkitConfiguration }

            /**
             * Optional override for session expiration timing in seconds from creation. Defaults to
             * 10 minutes.
             */
            fun expiresAfter(expiresAfter: ChatSessionExpiresAfterParam) =
                expiresAfter(JsonField.of(expiresAfter))

            /**
             * Sets [Builder.expiresAfter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAfter] with a well-typed
             * [ChatSessionExpiresAfterParam] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun expiresAfter(expiresAfter: JsonField<ChatSessionExpiresAfterParam>) = apply {
                this.expiresAfter = expiresAfter
            }

            /** Optional override for per-minute request limits. When omitted, defaults to 10. */
            fun rateLimits(rateLimits: ChatSessionRateLimitsParam) =
                rateLimits(JsonField.of(rateLimits))

            /**
             * Sets [Builder.rateLimits] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rateLimits] with a well-typed
             * [ChatSessionRateLimitsParam] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun rateLimits(rateLimits: JsonField<ChatSessionRateLimitsParam>) = apply {
                this.rateLimits = rateLimits
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .user()
             * .workflow()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("user", user),
                    checkRequired("workflow", workflow),
                    chatkitConfiguration,
                    expiresAfter,
                    rateLimits,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            user()
            workflow().validate()
            chatkitConfiguration().ifPresent { it.validate() }
            expiresAfter().ifPresent { it.validate() }
            rateLimits().ifPresent { it.validate() }
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
            (if (user.asKnown().isPresent) 1 else 0) +
                (workflow.asKnown().getOrNull()?.validity() ?: 0) +
                (chatkitConfiguration.asKnown().getOrNull()?.validity() ?: 0) +
                (expiresAfter.asKnown().getOrNull()?.validity() ?: 0) +
                (rateLimits.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                user == other.user &&
                workflow == other.workflow &&
                chatkitConfiguration == other.chatkitConfiguration &&
                expiresAfter == other.expiresAfter &&
                rateLimits == other.rateLimits &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                user,
                workflow,
                chatkitConfiguration,
                expiresAfter,
                rateLimits,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{user=$user, workflow=$workflow, chatkitConfiguration=$chatkitConfiguration, expiresAfter=$expiresAfter, rateLimits=$rateLimits, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "SessionCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
