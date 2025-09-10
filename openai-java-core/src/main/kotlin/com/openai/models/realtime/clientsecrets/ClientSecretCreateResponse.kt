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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Response from creating a session and client secret for the Realtime API. */
class ClientSecretCreateResponse
private constructor(
    private val expiresAt: JsonField<Long>,
    private val session: JsonField<Session>,
    private val value: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("session") @ExcludeMissing session: JsonField<Session> = JsonMissing.of(),
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
     * The session configuration for either a realtime or transcription session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun session(): Session = session.getRequired("session")

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
    @JsonProperty("session") @ExcludeMissing fun _session(): JsonField<Session> = session

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
         * Returns a mutable builder for constructing an instance of [ClientSecretCreateResponse].
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

    /** A builder for [ClientSecretCreateResponse]. */
    class Builder internal constructor() {

        private var expiresAt: JsonField<Long>? = null
        private var session: JsonField<Session>? = null
        private var value: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(clientSecretCreateResponse: ClientSecretCreateResponse) = apply {
            expiresAt = clientSecretCreateResponse.expiresAt
            session = clientSecretCreateResponse.session
            value = clientSecretCreateResponse.value
            additionalProperties = clientSecretCreateResponse.additionalProperties.toMutableMap()
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

        /** The session configuration for either a realtime or transcription session. */
        fun session(session: Session) = session(JsonField.of(session))

        /**
         * Sets [Builder.session] to an arbitrary JSON value.
         *
         * You should usually call [Builder.session] with a well-typed [Session] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun session(session: JsonField<Session>) = apply { this.session = session }

        /** Alias for calling [session] with `Session.ofRealtime(realtime)`. */
        fun session(realtime: RealtimeSessionCreateResponse) = session(Session.ofRealtime(realtime))

        /**
         * Alias for calling [session] with the following:
         * ```java
         * RealtimeSessionCreateResponse.builder()
         *     .clientSecret(clientSecret)
         *     .build()
         * ```
         */
        fun realtimeSession(clientSecret: RealtimeSessionClientSecret) =
            session(RealtimeSessionCreateResponse.builder().clientSecret(clientSecret).build())

        /** Alias for calling [session] with `Session.ofTranscription(transcription)`. */
        fun session(transcription: RealtimeTranscriptionSessionCreateResponse) =
            session(Session.ofTranscription(transcription))

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
         * Returns an immutable instance of [ClientSecretCreateResponse].
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
        fun build(): ClientSecretCreateResponse =
            ClientSecretCreateResponse(
                checkRequired("expiresAt", expiresAt),
                checkRequired("session", session),
                checkRequired("value", value),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ClientSecretCreateResponse = apply {
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

    /** The session configuration for either a realtime or transcription session. */
    @JsonDeserialize(using = Session.Deserializer::class)
    @JsonSerialize(using = Session.Serializer::class)
    class Session
    private constructor(
        private val realtime: RealtimeSessionCreateResponse? = null,
        private val transcription: RealtimeTranscriptionSessionCreateResponse? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A new Realtime session configuration, with an ephemeral key. Default TTL for keys is one
         * minute.
         */
        fun realtime(): Optional<RealtimeSessionCreateResponse> = Optional.ofNullable(realtime)

        /** A Realtime transcription session configuration object. */
        fun transcription(): Optional<RealtimeTranscriptionSessionCreateResponse> =
            Optional.ofNullable(transcription)

        fun isRealtime(): Boolean = realtime != null

        fun isTranscription(): Boolean = transcription != null

        /**
         * A new Realtime session configuration, with an ephemeral key. Default TTL for keys is one
         * minute.
         */
        fun asRealtime(): RealtimeSessionCreateResponse = realtime.getOrThrow("realtime")

        /** A Realtime transcription session configuration object. */
        fun asTranscription(): RealtimeTranscriptionSessionCreateResponse =
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
                    override fun visitRealtime(realtime: RealtimeSessionCreateResponse) {
                        realtime.validate()
                    }

                    override fun visitTranscription(
                        transcription: RealtimeTranscriptionSessionCreateResponse
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
                    override fun visitRealtime(realtime: RealtimeSessionCreateResponse) =
                        realtime.validity()

                    override fun visitTranscription(
                        transcription: RealtimeTranscriptionSessionCreateResponse
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

            /**
             * A new Realtime session configuration, with an ephemeral key. Default TTL for keys is
             * one minute.
             */
            @JvmStatic
            fun ofRealtime(realtime: RealtimeSessionCreateResponse) = Session(realtime = realtime)

            /** A Realtime transcription session configuration object. */
            @JvmStatic
            fun ofTranscription(transcription: RealtimeTranscriptionSessionCreateResponse) =
                Session(transcription = transcription)
        }

        /**
         * An interface that defines how to map each variant of [Session] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * A new Realtime session configuration, with an ephemeral key. Default TTL for keys is
             * one minute.
             */
            fun visitRealtime(realtime: RealtimeSessionCreateResponse): T

            /** A Realtime transcription session configuration object. */
            fun visitTranscription(transcription: RealtimeTranscriptionSessionCreateResponse): T

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
                        return tryDeserialize(node, jacksonTypeRef<RealtimeSessionCreateResponse>())
                            ?.let { Session(realtime = it, _json = json) } ?: Session(_json = json)
                    }
                    "transcription" -> {
                        return tryDeserialize(
                                node,
                                jacksonTypeRef<RealtimeTranscriptionSessionCreateResponse>(),
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

        return other is ClientSecretCreateResponse &&
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
        "ClientSecretCreateResponse{expiresAt=$expiresAt, session=$session, value=$value, additionalProperties=$additionalProperties}"
}
