// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to `null` to
 * turn off, in which case the client must manually trigger model response.
 *
 * Server VAD means that the model will detect the start and end of speech based on audio volume and
 * respond at the end of user speech.
 *
 * Semantic VAD is more advanced and uses a turn detection model (in conjunction with VAD) to
 * semantically estimate whether the user has finished speaking, then dynamically sets a timeout
 * based on this probability. For example, if user audio trails off with "uhhm", the model will
 * score a low probability of turn end and wait longer for the user to continue speaking. This can
 * be useful for more natural conversations, but may have a higher latency.
 */
@JsonDeserialize(using = RealtimeAudioInputTurnDetection.Deserializer::class)
@JsonSerialize(using = RealtimeAudioInputTurnDetection.Serializer::class)
class RealtimeAudioInputTurnDetection
private constructor(
    private val serverVad: ServerVad? = null,
    private val semanticVad: SemanticVad? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Server-side voice activity detection (VAD) which flips on when user speech is detected and
     * off after a period of silence.
     */
    fun serverVad(): Optional<ServerVad> = Optional.ofNullable(serverVad)

    /**
     * Server-side semantic turn detection which uses a model to determine when the user has
     * finished speaking.
     */
    fun semanticVad(): Optional<SemanticVad> = Optional.ofNullable(semanticVad)

    fun isServerVad(): Boolean = serverVad != null

    fun isSemanticVad(): Boolean = semanticVad != null

    /**
     * Server-side voice activity detection (VAD) which flips on when user speech is detected and
     * off after a period of silence.
     */
    fun asServerVad(): ServerVad = serverVad.getOrThrow("serverVad")

    /**
     * Server-side semantic turn detection which uses a model to determine when the user has
     * finished speaking.
     */
    fun asSemanticVad(): SemanticVad = semanticVad.getOrThrow("semanticVad")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            serverVad != null -> visitor.visitServerVad(serverVad)
            semanticVad != null -> visitor.visitSemanticVad(semanticVad)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RealtimeAudioInputTurnDetection = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitServerVad(serverVad: ServerVad) {
                    serverVad.validate()
                }

                override fun visitSemanticVad(semanticVad: SemanticVad) {
                    semanticVad.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitServerVad(serverVad: ServerVad) = serverVad.validity()

                override fun visitSemanticVad(semanticVad: SemanticVad) = semanticVad.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeAudioInputTurnDetection &&
            serverVad == other.serverVad &&
            semanticVad == other.semanticVad
    }

    override fun hashCode(): Int = Objects.hash(serverVad, semanticVad)

    override fun toString(): String =
        when {
            serverVad != null -> "RealtimeAudioInputTurnDetection{serverVad=$serverVad}"
            semanticVad != null -> "RealtimeAudioInputTurnDetection{semanticVad=$semanticVad}"
            _json != null -> "RealtimeAudioInputTurnDetection{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeAudioInputTurnDetection")
        }

    companion object {

        /**
         * Server-side voice activity detection (VAD) which flips on when user speech is detected
         * and off after a period of silence.
         */
        @JvmStatic
        fun ofServerVad(serverVad: ServerVad) =
            RealtimeAudioInputTurnDetection(serverVad = serverVad)

        /**
         * Server-side semantic turn detection which uses a model to determine when the user has
         * finished speaking.
         */
        @JvmStatic
        fun ofSemanticVad(semanticVad: SemanticVad) =
            RealtimeAudioInputTurnDetection(semanticVad = semanticVad)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeAudioInputTurnDetection] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /**
         * Server-side voice activity detection (VAD) which flips on when user speech is detected
         * and off after a period of silence.
         */
        fun visitServerVad(serverVad: ServerVad): T

        /**
         * Server-side semantic turn detection which uses a model to determine when the user has
         * finished speaking.
         */
        fun visitSemanticVad(semanticVad: SemanticVad): T

        /**
         * Maps an unknown variant of [RealtimeAudioInputTurnDetection] to a value of type [T].
         *
         * An instance of [RealtimeAudioInputTurnDetection] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeAudioInputTurnDetection: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<RealtimeAudioInputTurnDetection>(RealtimeAudioInputTurnDetection::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeAudioInputTurnDetection {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "server_vad" -> {
                    return tryDeserialize(node, jacksonTypeRef<ServerVad>())?.let {
                        RealtimeAudioInputTurnDetection(serverVad = it, _json = json)
                    } ?: RealtimeAudioInputTurnDetection(_json = json)
                }
                "semantic_vad" -> {
                    return tryDeserialize(node, jacksonTypeRef<SemanticVad>())?.let {
                        RealtimeAudioInputTurnDetection(semanticVad = it, _json = json)
                    } ?: RealtimeAudioInputTurnDetection(_json = json)
                }
            }

            return RealtimeAudioInputTurnDetection(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<RealtimeAudioInputTurnDetection>(RealtimeAudioInputTurnDetection::class) {

        override fun serialize(
            value: RealtimeAudioInputTurnDetection,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.serverVad != null -> generator.writeObject(value.serverVad)
                value.semanticVad != null -> generator.writeObject(value.semanticVad)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeAudioInputTurnDetection")
            }
        }
    }

    /**
     * Server-side voice activity detection (VAD) which flips on when user speech is detected and
     * off after a period of silence.
     */
    class ServerVad
    private constructor(
        private val type: JsonValue,
        private val createResponse: JsonField<Boolean>,
        private val idleTimeoutMs: JsonField<Long>,
        private val interruptResponse: JsonField<Boolean>,
        private val prefixPaddingMs: JsonField<Long>,
        private val silenceDurationMs: JsonField<Long>,
        private val threshold: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("create_response")
            @ExcludeMissing
            createResponse: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("idle_timeout_ms")
            @ExcludeMissing
            idleTimeoutMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("interrupt_response")
            @ExcludeMissing
            interruptResponse: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("prefix_padding_ms")
            @ExcludeMissing
            prefixPaddingMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("silence_duration_ms")
            @ExcludeMissing
            silenceDurationMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("threshold")
            @ExcludeMissing
            threshold: JsonField<Double> = JsonMissing.of(),
        ) : this(
            type,
            createResponse,
            idleTimeoutMs,
            interruptResponse,
            prefixPaddingMs,
            silenceDurationMs,
            threshold,
            mutableMapOf(),
        )

        /**
         * Type of turn detection, `server_vad` to turn on simple Server VAD.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("server_vad")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Whether or not to automatically generate a response when a VAD stop event occurs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun createResponse(): Optional<Boolean> = createResponse.getOptional("create_response")

        /**
         * Optional timeout after which a model response will be triggered automatically. This is
         * useful for situations in which a long pause from the user is unexpected, such as a phone
         * call. The model will effectively prompt the user to continue the conversation based on
         * the current context.
         *
         * The timeout value will be applied after the last model response's audio has finished
         * playing, i.e. it's set to the `response.done` time plus audio playback duration.
         *
         * An `input_audio_buffer.timeout_triggered` event (plus events associated with the
         * Response) will be emitted when the timeout is reached. Idle timeout is currently only
         * supported for `server_vad` mode.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun idleTimeoutMs(): Optional<Long> = idleTimeoutMs.getOptional("idle_timeout_ms")

        /**
         * Whether or not to automatically interrupt any ongoing response with output to the default
         * conversation (i.e. `conversation` of `auto`) when a VAD start event occurs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun interruptResponse(): Optional<Boolean> =
            interruptResponse.getOptional("interrupt_response")

        /**
         * Used only for `server_vad` mode. Amount of audio to include before the VAD detected
         * speech (in milliseconds). Defaults to 300ms.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun prefixPaddingMs(): Optional<Long> = prefixPaddingMs.getOptional("prefix_padding_ms")

        /**
         * Used only for `server_vad` mode. Duration of silence to detect speech stop (in
         * milliseconds). Defaults to 500ms. With shorter values the model will respond more
         * quickly, but may jump in on short pauses from the user.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun silenceDurationMs(): Optional<Long> =
            silenceDurationMs.getOptional("silence_duration_ms")

        /**
         * Used only for `server_vad` mode. Activation threshold for VAD (0.0 to 1.0), this defaults
         * to 0.5. A higher threshold will require louder audio to activate the model, and thus
         * might perform better in noisy environments.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun threshold(): Optional<Double> = threshold.getOptional("threshold")

        /**
         * Returns the raw JSON value of [createResponse].
         *
         * Unlike [createResponse], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("create_response")
        @ExcludeMissing
        fun _createResponse(): JsonField<Boolean> = createResponse

        /**
         * Returns the raw JSON value of [idleTimeoutMs].
         *
         * Unlike [idleTimeoutMs], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("idle_timeout_ms")
        @ExcludeMissing
        fun _idleTimeoutMs(): JsonField<Long> = idleTimeoutMs

        /**
         * Returns the raw JSON value of [interruptResponse].
         *
         * Unlike [interruptResponse], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("interrupt_response")
        @ExcludeMissing
        fun _interruptResponse(): JsonField<Boolean> = interruptResponse

        /**
         * Returns the raw JSON value of [prefixPaddingMs].
         *
         * Unlike [prefixPaddingMs], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("prefix_padding_ms")
        @ExcludeMissing
        fun _prefixPaddingMs(): JsonField<Long> = prefixPaddingMs

        /**
         * Returns the raw JSON value of [silenceDurationMs].
         *
         * Unlike [silenceDurationMs], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("silence_duration_ms")
        @ExcludeMissing
        fun _silenceDurationMs(): JsonField<Long> = silenceDurationMs

        /**
         * Returns the raw JSON value of [threshold].
         *
         * Unlike [threshold], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("threshold") @ExcludeMissing fun _threshold(): JsonField<Double> = threshold

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

            /** Returns a mutable builder for constructing an instance of [ServerVad]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ServerVad]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("server_vad")
            private var createResponse: JsonField<Boolean> = JsonMissing.of()
            private var idleTimeoutMs: JsonField<Long> = JsonMissing.of()
            private var interruptResponse: JsonField<Boolean> = JsonMissing.of()
            private var prefixPaddingMs: JsonField<Long> = JsonMissing.of()
            private var silenceDurationMs: JsonField<Long> = JsonMissing.of()
            private var threshold: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(serverVad: ServerVad) = apply {
                type = serverVad.type
                createResponse = serverVad.createResponse
                idleTimeoutMs = serverVad.idleTimeoutMs
                interruptResponse = serverVad.interruptResponse
                prefixPaddingMs = serverVad.prefixPaddingMs
                silenceDurationMs = serverVad.silenceDurationMs
                threshold = serverVad.threshold
                additionalProperties = serverVad.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("server_vad")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** Whether or not to automatically generate a response when a VAD stop event occurs. */
            fun createResponse(createResponse: Boolean) =
                createResponse(JsonField.of(createResponse))

            /**
             * Sets [Builder.createResponse] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createResponse] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createResponse(createResponse: JsonField<Boolean>) = apply {
                this.createResponse = createResponse
            }

            /**
             * Optional timeout after which a model response will be triggered automatically. This
             * is useful for situations in which a long pause from the user is unexpected, such as a
             * phone call. The model will effectively prompt the user to continue the conversation
             * based on the current context.
             *
             * The timeout value will be applied after the last model response's audio has finished
             * playing, i.e. it's set to the `response.done` time plus audio playback duration.
             *
             * An `input_audio_buffer.timeout_triggered` event (plus events associated with the
             * Response) will be emitted when the timeout is reached. Idle timeout is currently only
             * supported for `server_vad` mode.
             */
            fun idleTimeoutMs(idleTimeoutMs: Long?) =
                idleTimeoutMs(JsonField.ofNullable(idleTimeoutMs))

            /**
             * Alias for [Builder.idleTimeoutMs].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun idleTimeoutMs(idleTimeoutMs: Long) = idleTimeoutMs(idleTimeoutMs as Long?)

            /** Alias for calling [Builder.idleTimeoutMs] with `idleTimeoutMs.orElse(null)`. */
            fun idleTimeoutMs(idleTimeoutMs: Optional<Long>) =
                idleTimeoutMs(idleTimeoutMs.getOrNull())

            /**
             * Sets [Builder.idleTimeoutMs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.idleTimeoutMs] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun idleTimeoutMs(idleTimeoutMs: JsonField<Long>) = apply {
                this.idleTimeoutMs = idleTimeoutMs
            }

            /**
             * Whether or not to automatically interrupt any ongoing response with output to the
             * default conversation (i.e. `conversation` of `auto`) when a VAD start event occurs.
             */
            fun interruptResponse(interruptResponse: Boolean) =
                interruptResponse(JsonField.of(interruptResponse))

            /**
             * Sets [Builder.interruptResponse] to an arbitrary JSON value.
             *
             * You should usually call [Builder.interruptResponse] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun interruptResponse(interruptResponse: JsonField<Boolean>) = apply {
                this.interruptResponse = interruptResponse
            }

            /**
             * Used only for `server_vad` mode. Amount of audio to include before the VAD detected
             * speech (in milliseconds). Defaults to 300ms.
             */
            fun prefixPaddingMs(prefixPaddingMs: Long) =
                prefixPaddingMs(JsonField.of(prefixPaddingMs))

            /**
             * Sets [Builder.prefixPaddingMs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prefixPaddingMs] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prefixPaddingMs(prefixPaddingMs: JsonField<Long>) = apply {
                this.prefixPaddingMs = prefixPaddingMs
            }

            /**
             * Used only for `server_vad` mode. Duration of silence to detect speech stop (in
             * milliseconds). Defaults to 500ms. With shorter values the model will respond more
             * quickly, but may jump in on short pauses from the user.
             */
            fun silenceDurationMs(silenceDurationMs: Long) =
                silenceDurationMs(JsonField.of(silenceDurationMs))

            /**
             * Sets [Builder.silenceDurationMs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.silenceDurationMs] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun silenceDurationMs(silenceDurationMs: JsonField<Long>) = apply {
                this.silenceDurationMs = silenceDurationMs
            }

            /**
             * Used only for `server_vad` mode. Activation threshold for VAD (0.0 to 1.0), this
             * defaults to 0.5. A higher threshold will require louder audio to activate the model,
             * and thus might perform better in noisy environments.
             */
            fun threshold(threshold: Double) = threshold(JsonField.of(threshold))

            /**
             * Sets [Builder.threshold] to an arbitrary JSON value.
             *
             * You should usually call [Builder.threshold] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun threshold(threshold: JsonField<Double>) = apply { this.threshold = threshold }

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
             * Returns an immutable instance of [ServerVad].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ServerVad =
                ServerVad(
                    type,
                    createResponse,
                    idleTimeoutMs,
                    interruptResponse,
                    prefixPaddingMs,
                    silenceDurationMs,
                    threshold,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ServerVad = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("server_vad")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            createResponse()
            idleTimeoutMs()
            interruptResponse()
            prefixPaddingMs()
            silenceDurationMs()
            threshold()
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
            type.let { if (it == JsonValue.from("server_vad")) 1 else 0 } +
                (if (createResponse.asKnown().isPresent) 1 else 0) +
                (if (idleTimeoutMs.asKnown().isPresent) 1 else 0) +
                (if (interruptResponse.asKnown().isPresent) 1 else 0) +
                (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
                (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
                (if (threshold.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ServerVad &&
                type == other.type &&
                createResponse == other.createResponse &&
                idleTimeoutMs == other.idleTimeoutMs &&
                interruptResponse == other.interruptResponse &&
                prefixPaddingMs == other.prefixPaddingMs &&
                silenceDurationMs == other.silenceDurationMs &&
                threshold == other.threshold &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                type,
                createResponse,
                idleTimeoutMs,
                interruptResponse,
                prefixPaddingMs,
                silenceDurationMs,
                threshold,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ServerVad{type=$type, createResponse=$createResponse, idleTimeoutMs=$idleTimeoutMs, interruptResponse=$interruptResponse, prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, additionalProperties=$additionalProperties}"
    }

    /**
     * Server-side semantic turn detection which uses a model to determine when the user has
     * finished speaking.
     */
    class SemanticVad
    private constructor(
        private val type: JsonValue,
        private val createResponse: JsonField<Boolean>,
        private val eagerness: JsonField<Eagerness>,
        private val interruptResponse: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("create_response")
            @ExcludeMissing
            createResponse: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("eagerness")
            @ExcludeMissing
            eagerness: JsonField<Eagerness> = JsonMissing.of(),
            @JsonProperty("interrupt_response")
            @ExcludeMissing
            interruptResponse: JsonField<Boolean> = JsonMissing.of(),
        ) : this(type, createResponse, eagerness, interruptResponse, mutableMapOf())

        /**
         * Type of turn detection, `semantic_vad` to turn on Semantic VAD.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("semantic_vad")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Whether or not to automatically generate a response when a VAD stop event occurs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun createResponse(): Optional<Boolean> = createResponse.getOptional("create_response")

        /**
         * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will wait
         * longer for the user to continue speaking, `high` will respond more quickly. `auto` is the
         * default and is equivalent to `medium`. `low`, `medium`, and `high` have max timeouts of
         * 8s, 4s, and 2s respectively.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun eagerness(): Optional<Eagerness> = eagerness.getOptional("eagerness")

        /**
         * Whether or not to automatically interrupt any ongoing response with output to the default
         * conversation (i.e. `conversation` of `auto`) when a VAD start event occurs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun interruptResponse(): Optional<Boolean> =
            interruptResponse.getOptional("interrupt_response")

        /**
         * Returns the raw JSON value of [createResponse].
         *
         * Unlike [createResponse], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("create_response")
        @ExcludeMissing
        fun _createResponse(): JsonField<Boolean> = createResponse

        /**
         * Returns the raw JSON value of [eagerness].
         *
         * Unlike [eagerness], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("eagerness")
        @ExcludeMissing
        fun _eagerness(): JsonField<Eagerness> = eagerness

        /**
         * Returns the raw JSON value of [interruptResponse].
         *
         * Unlike [interruptResponse], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("interrupt_response")
        @ExcludeMissing
        fun _interruptResponse(): JsonField<Boolean> = interruptResponse

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

            /** Returns a mutable builder for constructing an instance of [SemanticVad]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SemanticVad]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("semantic_vad")
            private var createResponse: JsonField<Boolean> = JsonMissing.of()
            private var eagerness: JsonField<Eagerness> = JsonMissing.of()
            private var interruptResponse: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(semanticVad: SemanticVad) = apply {
                type = semanticVad.type
                createResponse = semanticVad.createResponse
                eagerness = semanticVad.eagerness
                interruptResponse = semanticVad.interruptResponse
                additionalProperties = semanticVad.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("semantic_vad")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** Whether or not to automatically generate a response when a VAD stop event occurs. */
            fun createResponse(createResponse: Boolean) =
                createResponse(JsonField.of(createResponse))

            /**
             * Sets [Builder.createResponse] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createResponse] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createResponse(createResponse: JsonField<Boolean>) = apply {
                this.createResponse = createResponse
            }

            /**
             * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will
             * wait longer for the user to continue speaking, `high` will respond more quickly.
             * `auto` is the default and is equivalent to `medium`. `low`, `medium`, and `high` have
             * max timeouts of 8s, 4s, and 2s respectively.
             */
            fun eagerness(eagerness: Eagerness) = eagerness(JsonField.of(eagerness))

            /**
             * Sets [Builder.eagerness] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eagerness] with a well-typed [Eagerness] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eagerness(eagerness: JsonField<Eagerness>) = apply { this.eagerness = eagerness }

            /**
             * Whether or not to automatically interrupt any ongoing response with output to the
             * default conversation (i.e. `conversation` of `auto`) when a VAD start event occurs.
             */
            fun interruptResponse(interruptResponse: Boolean) =
                interruptResponse(JsonField.of(interruptResponse))

            /**
             * Sets [Builder.interruptResponse] to an arbitrary JSON value.
             *
             * You should usually call [Builder.interruptResponse] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun interruptResponse(interruptResponse: JsonField<Boolean>) = apply {
                this.interruptResponse = interruptResponse
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
             * Returns an immutable instance of [SemanticVad].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): SemanticVad =
                SemanticVad(
                    type,
                    createResponse,
                    eagerness,
                    interruptResponse,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): SemanticVad = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("semantic_vad")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            createResponse()
            eagerness().ifPresent { it.validate() }
            interruptResponse()
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
            type.let { if (it == JsonValue.from("semantic_vad")) 1 else 0 } +
                (if (createResponse.asKnown().isPresent) 1 else 0) +
                (eagerness.asKnown().getOrNull()?.validity() ?: 0) +
                (if (interruptResponse.asKnown().isPresent) 1 else 0)

        /**
         * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will wait
         * longer for the user to continue speaking, `high` will respond more quickly. `auto` is the
         * default and is equivalent to `medium`. `low`, `medium`, and `high` have max timeouts of
         * 8s, 4s, and 2s respectively.
         */
        class Eagerness @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val LOW = of("low")

                @JvmField val MEDIUM = of("medium")

                @JvmField val HIGH = of("high")

                @JvmField val AUTO = of("auto")

                @JvmStatic fun of(value: String) = Eagerness(JsonField.of(value))
            }

            /** An enum containing [Eagerness]'s known values. */
            enum class Known {
                LOW,
                MEDIUM,
                HIGH,
                AUTO,
            }

            /**
             * An enum containing [Eagerness]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Eagerness] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                LOW,
                MEDIUM,
                HIGH,
                AUTO,
                /**
                 * An enum member indicating that [Eagerness] was instantiated with an unknown
                 * value.
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
                    LOW -> Value.LOW
                    MEDIUM -> Value.MEDIUM
                    HIGH -> Value.HIGH
                    AUTO -> Value.AUTO
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
                    LOW -> Known.LOW
                    MEDIUM -> Known.MEDIUM
                    HIGH -> Known.HIGH
                    AUTO -> Known.AUTO
                    else -> throw OpenAIInvalidDataException("Unknown Eagerness: $value")
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

            fun validate(): Eagerness = apply {
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

                return other is Eagerness && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SemanticVad &&
                type == other.type &&
                createResponse == other.createResponse &&
                eagerness == other.eagerness &&
                interruptResponse == other.interruptResponse &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(type, createResponse, eagerness, interruptResponse, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SemanticVad{type=$type, createResponse=$createResponse, eagerness=$eagerness, interruptResponse=$interruptResponse, additionalProperties=$additionalProperties}"
    }
}
