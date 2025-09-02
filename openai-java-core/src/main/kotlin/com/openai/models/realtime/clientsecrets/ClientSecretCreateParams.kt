// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.realtime.RealtimeSessionCreateRequest
import com.openai.models.realtime.RealtimeTranscriptionSessionCreateRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a Realtime session and client secret for either realtime or transcription. */
class ClientSecretCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Configuration for the ephemeral token expiration.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAfter(): Optional<ExpiresAfter> = body.expiresAfter()

    /**
     * Session configuration to use for the client secret. Choose either a realtime session or a
     * transcription session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun session(): Optional<Session> = body.session()

    /**
     * Returns the raw JSON value of [expiresAfter].
     *
     * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _expiresAfter(): JsonField<ExpiresAfter> = body._expiresAfter()

    /**
     * Returns the raw JSON value of [session].
     *
     * Unlike [session], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _session(): JsonField<Session> = body._session()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ClientSecretCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ClientSecretCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ClientSecretCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(clientSecretCreateParams: ClientSecretCreateParams) = apply {
            body = clientSecretCreateParams.body.toBuilder()
            additionalHeaders = clientSecretCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = clientSecretCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [expiresAfter]
         * - [session]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Configuration for the ephemeral token expiration. */
        fun expiresAfter(expiresAfter: ExpiresAfter) = apply { body.expiresAfter(expiresAfter) }

        /**
         * Sets [Builder.expiresAfter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
            body.expiresAfter(expiresAfter)
        }

        /**
         * Session configuration to use for the client secret. Choose either a realtime session or a
         * transcription session.
         */
        fun session(session: Session) = apply { body.session(session) }

        /**
         * Sets [Builder.session] to an arbitrary JSON value.
         *
         * You should usually call [Builder.session] with a well-typed [Session] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun session(session: JsonField<Session>) = apply { body.session(session) }

        /** Alias for calling [session] with `Session.ofRealtime(realtime)`. */
        fun session(realtime: RealtimeSessionCreateRequest) = apply { body.session(realtime) }

        /**
         * Alias for calling [session] with the following:
         * ```java
         * RealtimeSessionCreateRequest.builder()
         *     .model(model)
         *     .build()
         * ```
         */
        fun realtimeSession(model: RealtimeSessionCreateRequest.Model) = apply {
            body.realtimeSession(model)
        }

        /**
         * Alias for calling [realtimeSession] with
         * `RealtimeSessionCreateRequest.Model.ofString(string)`.
         */
        fun realtimeSession(string: String) = apply { body.realtimeSession(string) }

        /** Alias for calling [session] with `Session.ofTranscription(transcription)`. */
        fun session(transcription: RealtimeTranscriptionSessionCreateRequest) = apply {
            body.session(transcription)
        }

        /**
         * Alias for calling [session] with the following:
         * ```java
         * RealtimeTranscriptionSessionCreateRequest.builder()
         *     .model(model)
         *     .build()
         * ```
         */
        fun transcriptionSession(model: RealtimeTranscriptionSessionCreateRequest.Model) = apply {
            body.transcriptionSession(model)
        }

        /**
         * Alias for calling [transcriptionSession] with
         * `RealtimeTranscriptionSessionCreateRequest.Model.ofString(string)`.
         */
        fun transcriptionSession(string: String) = apply { body.transcriptionSession(string) }

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
         * Returns an immutable instance of [ClientSecretCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ClientSecretCreateParams =
            ClientSecretCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Create a session and client secret for the Realtime API. The request can specify either a
     * realtime or a transcription session configuration.
     * [Learn more about the Realtime API](https://platform.openai.com/docs/guides/realtime).
     */
    class Body
    private constructor(
        private val expiresAfter: JsonField<ExpiresAfter>,
        private val session: JsonField<Session>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("expires_after")
            @ExcludeMissing
            expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of(),
            @JsonProperty("session") @ExcludeMissing session: JsonField<Session> = JsonMissing.of(),
        ) : this(expiresAfter, session, mutableMapOf())

        /**
         * Configuration for the ephemeral token expiration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAfter(): Optional<ExpiresAfter> = expiresAfter.getOptional("expires_after")

        /**
         * Session configuration to use for the client secret. Choose either a realtime session or a
         * transcription session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun session(): Optional<Session> = session.getOptional("session")

        /**
         * Returns the raw JSON value of [expiresAfter].
         *
         * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("expires_after")
        @ExcludeMissing
        fun _expiresAfter(): JsonField<ExpiresAfter> = expiresAfter

        /**
         * Returns the raw JSON value of [session].
         *
         * Unlike [session], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("session") @ExcludeMissing fun _session(): JsonField<Session> = session

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
            private var session: JsonField<Session> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                expiresAfter = body.expiresAfter
                session = body.session
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Configuration for the ephemeral token expiration. */
            fun expiresAfter(expiresAfter: ExpiresAfter) = expiresAfter(JsonField.of(expiresAfter))

            /**
             * Sets [Builder.expiresAfter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
                this.expiresAfter = expiresAfter
            }

            /**
             * Session configuration to use for the client secret. Choose either a realtime session
             * or a transcription session.
             */
            fun session(session: Session) = session(JsonField.of(session))

            /**
             * Sets [Builder.session] to an arbitrary JSON value.
             *
             * You should usually call [Builder.session] with a well-typed [Session] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun session(session: JsonField<Session>) = apply { this.session = session }

            /** Alias for calling [session] with `Session.ofRealtime(realtime)`. */
            fun session(realtime: RealtimeSessionCreateRequest) =
                session(Session.ofRealtime(realtime))

            /**
             * Alias for calling [session] with the following:
             * ```java
             * RealtimeSessionCreateRequest.builder()
             *     .model(model)
             *     .build()
             * ```
             */
            fun realtimeSession(model: RealtimeSessionCreateRequest.Model) =
                session(RealtimeSessionCreateRequest.builder().model(model).build())

            /**
             * Alias for calling [realtimeSession] with
             * `RealtimeSessionCreateRequest.Model.ofString(string)`.
             */
            fun realtimeSession(string: String) =
                realtimeSession(RealtimeSessionCreateRequest.Model.of(string))

            /** Alias for calling [session] with `Session.ofTranscription(transcription)`. */
            fun session(transcription: RealtimeTranscriptionSessionCreateRequest) =
                session(Session.ofTranscription(transcription))

            /**
             * Alias for calling [session] with the following:
             * ```java
             * RealtimeTranscriptionSessionCreateRequest.builder()
             *     .model(model)
             *     .build()
             * ```
             */
            fun transcriptionSession(model: RealtimeTranscriptionSessionCreateRequest.Model) =
                session(RealtimeTranscriptionSessionCreateRequest.builder().model(model).build())

            /**
             * Alias for calling [transcriptionSession] with
             * `RealtimeTranscriptionSessionCreateRequest.Model.ofString(string)`.
             */
            fun transcriptionSession(string: String) =
                transcriptionSession(RealtimeTranscriptionSessionCreateRequest.Model.of(string))

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
             */
            fun build(): Body = Body(expiresAfter, session, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            expiresAfter().ifPresent { it.validate() }
            session().ifPresent { it.validate() }
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
            (expiresAfter.asKnown().getOrNull()?.validity() ?: 0) +
                (session.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                expiresAfter == other.expiresAfter &&
                session == other.session &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(expiresAfter, session, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{expiresAfter=$expiresAfter, session=$session, additionalProperties=$additionalProperties}"
    }

    /** Configuration for the ephemeral token expiration. */
    class ExpiresAfter
    private constructor(
        private val anchor: JsonField<Anchor>,
        private val seconds: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("anchor") @ExcludeMissing anchor: JsonField<Anchor> = JsonMissing.of(),
            @JsonProperty("seconds") @ExcludeMissing seconds: JsonField<Long> = JsonMissing.of(),
        ) : this(anchor, seconds, mutableMapOf())

        /**
         * The anchor point for the ephemeral token expiration. Only `created_at` is currently
         * supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun anchor(): Optional<Anchor> = anchor.getOptional("anchor")

        /**
         * The number of seconds from the anchor point to the expiration. Select a value between
         * `10` and `7200`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun seconds(): Optional<Long> = seconds.getOptional("seconds")

        /**
         * Returns the raw JSON value of [anchor].
         *
         * Unlike [anchor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonField<Anchor> = anchor

        /**
         * Returns the raw JSON value of [seconds].
         *
         * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Long> = seconds

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

            /** Returns a mutable builder for constructing an instance of [ExpiresAfter]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExpiresAfter]. */
        class Builder internal constructor() {

            private var anchor: JsonField<Anchor> = JsonMissing.of()
            private var seconds: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(expiresAfter: ExpiresAfter) = apply {
                anchor = expiresAfter.anchor
                seconds = expiresAfter.seconds
                additionalProperties = expiresAfter.additionalProperties.toMutableMap()
            }

            /**
             * The anchor point for the ephemeral token expiration. Only `created_at` is currently
             * supported.
             */
            fun anchor(anchor: Anchor) = anchor(JsonField.of(anchor))

            /**
             * Sets [Builder.anchor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.anchor] with a well-typed [Anchor] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun anchor(anchor: JsonField<Anchor>) = apply { this.anchor = anchor }

            /**
             * The number of seconds from the anchor point to the expiration. Select a value between
             * `10` and `7200`.
             */
            fun seconds(seconds: Long) = seconds(JsonField.of(seconds))

            /**
             * Sets [Builder.seconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.seconds] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun seconds(seconds: JsonField<Long>) = apply { this.seconds = seconds }

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
             * Returns an immutable instance of [ExpiresAfter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ExpiresAfter =
                ExpiresAfter(anchor, seconds, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (validated) {
                return@apply
            }

            anchor().ifPresent { it.validate() }
            seconds()
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
            (anchor.asKnown().getOrNull()?.validity() ?: 0) +
                (if (seconds.asKnown().isPresent) 1 else 0)

        /**
         * The anchor point for the ephemeral token expiration. Only `created_at` is currently
         * supported.
         */
        class Anchor @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val CREATED_AT = of("created_at")

                @JvmStatic fun of(value: String) = Anchor(JsonField.of(value))
            }

            /** An enum containing [Anchor]'s known values. */
            enum class Known {
                CREATED_AT
            }

            /**
             * An enum containing [Anchor]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Anchor] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                CREATED_AT,
                /**
                 * An enum member indicating that [Anchor] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    CREATED_AT -> Value.CREATED_AT
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    CREATED_AT -> Known.CREATED_AT
                    else -> throw OpenAIInvalidDataException("Unknown Anchor: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Anchor = apply {
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

                return other is Anchor && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ExpiresAfter &&
                anchor == other.anchor &&
                seconds == other.seconds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(anchor, seconds, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExpiresAfter{anchor=$anchor, seconds=$seconds, additionalProperties=$additionalProperties}"
    }

    /**
     * Session configuration to use for the client secret. Choose either a realtime session or a
     * transcription session.
     */
    @JsonDeserialize(using = Session.Deserializer::class)
    @JsonSerialize(using = Session.Serializer::class)
    class Session
    private constructor(
        private val realtime: RealtimeSessionCreateRequest? = null,
        private val transcription: RealtimeTranscriptionSessionCreateRequest? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Realtime session object configuration. */
        fun realtime(): Optional<RealtimeSessionCreateRequest> = Optional.ofNullable(realtime)

        /** Realtime transcription session object configuration. */
        fun transcription(): Optional<RealtimeTranscriptionSessionCreateRequest> =
            Optional.ofNullable(transcription)

        fun isRealtime(): Boolean = realtime != null

        fun isTranscription(): Boolean = transcription != null

        /** Realtime session object configuration. */
        fun asRealtime(): RealtimeSessionCreateRequest = realtime.getOrThrow("realtime")

        /** Realtime transcription session object configuration. */
        fun asTranscription(): RealtimeTranscriptionSessionCreateRequest =
            transcription.getOrThrow("transcription")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                realtime != null -> visitor.visitRealtime(realtime)
                transcription != null -> visitor.visitTranscription(transcription)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Session = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitRealtime(realtime: RealtimeSessionCreateRequest) {
                        realtime.validate()
                    }

                    override fun visitTranscription(
                        transcription: RealtimeTranscriptionSessionCreateRequest
                    ) {
                        transcription.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitRealtime(realtime: RealtimeSessionCreateRequest) =
                        realtime.validity()

                    override fun visitTranscription(
                        transcription: RealtimeTranscriptionSessionCreateRequest
                    ) = transcription.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Session &&
                realtime == other.realtime &&
                transcription == other.transcription
        }

        override fun hashCode(): Int = Objects.hash(realtime, transcription)

        override fun toString(): String =
            when {
                realtime != null -> "Session{realtime=$realtime}"
                transcription != null -> "Session{transcription=$transcription}"
                _json != null -> "Session{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Session")
            }

        companion object {

            /** Realtime session object configuration. */
            @JvmStatic
            fun ofRealtime(realtime: RealtimeSessionCreateRequest) = Session(realtime = realtime)

            /** Realtime transcription session object configuration. */
            @JvmStatic
            fun ofTranscription(transcription: RealtimeTranscriptionSessionCreateRequest) =
                Session(transcription = transcription)
        }

        /**
         * An interface that defines how to map each variant of [Session] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Realtime session object configuration. */
            fun visitRealtime(realtime: RealtimeSessionCreateRequest): T

            /** Realtime transcription session object configuration. */
            fun visitTranscription(transcription: RealtimeTranscriptionSessionCreateRequest): T

            /**
             * Maps an unknown variant of [Session] to a value of type [T].
             *
             * An instance of [Session] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Session: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Session>(Session::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Session {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "realtime" -> {
                        return tryDeserialize(node, jacksonTypeRef<RealtimeSessionCreateRequest>())
                            ?.let { Session(realtime = it, _json = json) } ?: Session(_json = json)
                    }
                    "transcription" -> {
                        return tryDeserialize(
                                node,
                                jacksonTypeRef<RealtimeTranscriptionSessionCreateRequest>(),
                            )
                            ?.let { Session(transcription = it, _json = json) }
                            ?: Session(_json = json)
                    }
                }

                return Session(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Session>(Session::class) {

            override fun serialize(
                value: Session,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.realtime != null -> generator.writeObject(value.realtime)
                    value.transcription != null -> generator.writeObject(value.transcription)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Session")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ClientSecretCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ClientSecretCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
