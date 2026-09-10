// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Initial configuration for a Live session, including its model, conversation instructions, audio,
 * and delegated task handling.
 */
class SessionConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val model: JsonField<Model>,
    private val audio: JsonField<Audio>,
    private val client: JsonField<ClientConfig>,
    private val delegation: JsonField<Delegation>,
    private val input: JsonField<List<InitialItem>>,
    private val instructions: JsonField<String>,
    private val store: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
        @JsonProperty("audio") @ExcludeMissing audio: JsonField<Audio> = JsonMissing.of(),
        @JsonProperty("client") @ExcludeMissing client: JsonField<ClientConfig> = JsonMissing.of(),
        @JsonProperty("delegation")
        @ExcludeMissing
        delegation: JsonField<Delegation> = JsonMissing.of(),
        @JsonProperty("input")
        @ExcludeMissing
        input: JsonField<List<InitialItem>> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("store") @ExcludeMissing store: JsonField<Boolean> = JsonMissing.of(),
    ) : this(model, audio, client, delegation, input, instructions, store, mutableMapOf())

    /**
     * The Live model. Required in the session configuration for every transport; do not pass it as
     * a URL query parameter.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): Model = model.getRequired("model")

    /**
     * Startup audio configuration. Only primary WebSockets accept audio.format; WebRTC and SIP
     * negotiate their media format. Voice and format are immutable after startup.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audio(): Optional<Audio> = audio.getOptional("audio")

    /**
     * Startup-only capabilities for an untrusted frontend attached to a unified WebRTC session.
     * Trusted sideband connections are unaffected.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun client(): Optional<ClientConfig> = client.getOptional("client")

    /**
     * Who handles tasks delegated by the Live model. Omitted or null selects your application; use
     * `responses` to let the API manage a Responses backend.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun delegation(): Optional<Delegation> = delegation.getOptional("delegation")

    /**
     * Ordered text-only history supplied before startup. Supports developer, user, and assistant
     * messages with one text part each; at most 128 messages and 8,192 rendered tokens in total.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun input(): Optional<List<InitialItem>> = input.getOptional("input")

    /**
     * Frontend instructions for voice, conversation, interruptions, and when to delegate. Start
     * with the
     * [Live prompting guide](https://developers.openai.com/api/docs/guides/live-prompting); put
     * business rules and tool workflows in a separate
     * [backend prompt](https://developers.openai.com/api/docs/guides/live-delegation#start-with-your-existing-backend-prompt).
     * Limited to 16,384 client-supplied tokens. Omitted or blank instructions use server defaults.
     * Immutable after startup.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<String> = instructions.getOptional("instructions")

    /**
     * Whether to store the session for later forking and recording download. Defaults to false for
     * new sessions.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun store(): Optional<Boolean> = store.getOptional("store")

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

    /**
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<Audio> = audio

    /**
     * Returns the raw JSON value of [client].
     *
     * Unlike [client], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client") @ExcludeMissing fun _client(): JsonField<ClientConfig> = client

    /**
     * Returns the raw JSON value of [delegation].
     *
     * Unlike [delegation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delegation")
    @ExcludeMissing
    fun _delegation(): JsonField<Delegation> = delegation

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<List<InitialItem>> = input

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<String> = instructions

    /**
     * Returns the raw JSON value of [store].
     *
     * Unlike [store], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("store") @ExcludeMissing fun _store(): JsonField<Boolean> = store

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
         * Returns a mutable builder for constructing an instance of [SessionConfig].
         *
         * The following fields are required:
         * ```java
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionConfig]. */
    class Builder internal constructor() {

        private var model: JsonField<Model>? = null
        private var audio: JsonField<Audio> = JsonMissing.of()
        private var client: JsonField<ClientConfig> = JsonMissing.of()
        private var delegation: JsonField<Delegation> = JsonMissing.of()
        private var input: JsonField<MutableList<InitialItem>>? = null
        private var instructions: JsonField<String> = JsonMissing.of()
        private var store: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sessionConfig: SessionConfig) = apply {
            model = sessionConfig.model
            audio = sessionConfig.audio
            client = sessionConfig.client
            delegation = sessionConfig.delegation
            input = sessionConfig.input.map { it.toMutableList() }
            instructions = sessionConfig.instructions
            store = sessionConfig.store
            additionalProperties = sessionConfig.additionalProperties.toMutableMap()
        }

        /**
         * The Live model. Required in the session configuration for every transport; do not pass it
         * as a URL query parameter.
         */
        fun model(model: Model) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [Model] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<Model>) = apply { this.model = model }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [Model] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(value: String) = model(Model.of(value))

        /**
         * Startup audio configuration. Only primary WebSockets accept audio.format; WebRTC and SIP
         * negotiate their media format. Voice and format are immutable after startup.
         */
        fun audio(audio: Audio) = audio(JsonField.of(audio))

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [Audio] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audio(audio: JsonField<Audio>) = apply { this.audio = audio }

        /**
         * Startup-only capabilities for an untrusted frontend attached to a unified WebRTC session.
         * Trusted sideband connections are unaffected.
         */
        fun client(client: ClientConfig) = client(JsonField.of(client))

        /**
         * Sets [Builder.client] to an arbitrary JSON value.
         *
         * You should usually call [Builder.client] with a well-typed [ClientConfig] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun client(client: JsonField<ClientConfig>) = apply { this.client = client }

        /**
         * Who handles tasks delegated by the Live model. Omitted or null selects your application;
         * use `responses` to let the API manage a Responses backend.
         */
        fun delegation(delegation: Delegation?) = delegation(JsonField.ofNullable(delegation))

        /** Alias for calling [Builder.delegation] with `delegation.orElse(null)`. */
        fun delegation(delegation: Optional<Delegation>) = delegation(delegation.getOrNull())

        /**
         * Sets [Builder.delegation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delegation] with a well-typed [Delegation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun delegation(delegation: JsonField<Delegation>) = apply { this.delegation = delegation }

        /** Alias for calling [delegation] with `Delegation.ofClient(client)`. */
        fun delegation(client: ClientDelegation) = delegation(Delegation.ofClient(client))

        /** Alias for calling [delegation] with `Delegation.ofResponses(responses)`. */
        fun delegation(responses: Delegation.Responses) =
            delegation(Delegation.ofResponses(responses))

        /**
         * Alias for calling [delegation] with the following:
         * ```java
         * Delegation.Responses.builder()
         *     .responses(responses)
         *     .build()
         * ```
         */
        fun responsesDelegation(responses: ResponsesDelegationConfig) =
            delegation(Delegation.Responses.builder().responses(responses).build())

        /**
         * Ordered text-only history supplied before startup. Supports developer, user, and
         * assistant messages with one text part each; at most 128 messages and 8,192 rendered
         * tokens in total.
         */
        fun input(input: List<InitialItem>) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed `List<InitialItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun input(input: JsonField<List<InitialItem>>) = apply {
            this.input = input.map { it.toMutableList() }
        }

        /**
         * Adds a single [InitialItem] to [Builder.input].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInput(input: InitialItem) = apply {
            this.input =
                (this.input ?: JsonField.of(mutableListOf())).also {
                    checkKnown("input", it).add(input)
                }
        }

        /** Alias for calling [addInput] with `InitialItem.ofDeveloper(developer)`. */
        fun addInput(developer: InitialItem.Developer) =
            addInput(InitialItem.ofDeveloper(developer))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * InitialItem.Developer.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addDeveloperInput(content: List<InitialItem.Developer.Content>) =
            addInput(InitialItem.Developer.builder().content(content).build())

        /** Alias for calling [addInput] with `InitialItem.ofUser(user)`. */
        fun addInput(user: InitialItem.User) = addInput(InitialItem.ofUser(user))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * InitialItem.User.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addUserInput(content: List<InitialItem.User.Content>) =
            addInput(InitialItem.User.builder().content(content).build())

        /** Alias for calling [addInput] with `InitialItem.ofAssistant(assistant)`. */
        fun addInput(assistant: InitialItem.Assistant) =
            addInput(InitialItem.ofAssistant(assistant))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * InitialItem.Assistant.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addAssistantInput(content: List<InitialItem.Assistant.Content>) =
            addInput(InitialItem.Assistant.builder().content(content).build())

        /**
         * Frontend instructions for voice, conversation, interruptions, and when to delegate. Start
         * with the
         * [Live prompting guide](https://developers.openai.com/api/docs/guides/live-prompting); put
         * business rules and tool workflows in a separate
         * [backend prompt](https://developers.openai.com/api/docs/guides/live-delegation#start-with-your-existing-backend-prompt).
         * Limited to 16,384 client-supplied tokens. Omitted or blank instructions use server
         * defaults. Immutable after startup.
         */
        fun instructions(instructions: String?) = instructions(JsonField.ofNullable(instructions))

        /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
        fun instructions(instructions: Optional<String>) = instructions(instructions.getOrNull())

        /**
         * Sets [Builder.instructions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instructions] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            this.instructions = instructions
        }

        /**
         * Whether to store the session for later forking and recording download. Defaults to false
         * for new sessions.
         */
        fun store(store: Boolean) = store(JsonField.of(store))

        /**
         * Sets [Builder.store] to an arbitrary JSON value.
         *
         * You should usually call [Builder.store] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun store(store: JsonField<Boolean>) = apply { this.store = store }

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
         * Returns an immutable instance of [SessionConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .model()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SessionConfig =
            SessionConfig(
                checkRequired("model", model),
                audio,
                client,
                delegation,
                (input ?: JsonMissing.of()).map { it.toImmutable() },
                instructions,
                store,
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
    fun validate(): SessionConfig = apply {
        if (validated) {
            return@apply
        }

        model()
        audio().ifPresent { it.validate() }
        client().ifPresent { it.validate() }
        delegation().ifPresent { it.validate() }
        input().ifPresent { it.forEach { it.validate() } }
        instructions()
        store()
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
        (if (model.asKnown().isPresent) 1 else 0) +
            (audio.asKnown().getOrNull()?.validity() ?: 0) +
            (client.asKnown().getOrNull()?.validity() ?: 0) +
            (delegation.asKnown().getOrNull()?.validity() ?: 0) +
            (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (instructions.asKnown().isPresent) 1 else 0) +
            (if (store.asKnown().isPresent) 1 else 0)

    /**
     * The Live model. Required in the session configuration for every transport; do not pass it as
     * a URL query parameter.
     */
    class Model @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GPT_LIVE_1 = of("gpt-live-1")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            GPT_LIVE_1
        }

        /**
         * An enum containing [Model]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Model] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GPT_LIVE_1,
            /** An enum member indicating that [Model] was instantiated with an unknown value. */
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
                GPT_LIVE_1 -> Value.GPT_LIVE_1
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
                GPT_LIVE_1 -> Known.GPT_LIVE_1
                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Model = apply {
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

            return other is Model && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Startup audio configuration. Only primary WebSockets accept audio.format; WebRTC and SIP
     * negotiate their media format. Voice and format are immutable after startup.
     */
    class Audio
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val format: JsonField<AudioFormat>,
        private val output: JsonField<Output>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("format")
            @ExcludeMissing
            format: JsonField<AudioFormat> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<Output> = JsonMissing.of(),
        ) : this(format, output, mutableMapOf())

        /**
         * Audio encoding and sample rate for audio sent and received over a Live WebSocket
         * connection. WebRTC and SIP negotiate their media format separately.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun format(): Optional<AudioFormat> = format.getOptional("format")

        /**
         * The voice used for speech generated by the Live model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun output(): Optional<Output> = output.getOptional("output")

        /**
         * Returns the raw JSON value of [format].
         *
         * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<AudioFormat> = format

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<Output> = output

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

            /** Returns a mutable builder for constructing an instance of [Audio]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Audio]. */
        class Builder internal constructor() {

            private var format: JsonField<AudioFormat> = JsonMissing.of()
            private var output: JsonField<Output> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audio: Audio) = apply {
                format = audio.format
                output = audio.output
                additionalProperties = audio.additionalProperties.toMutableMap()
            }

            /**
             * Audio encoding and sample rate for audio sent and received over a Live WebSocket
             * connection. WebRTC and SIP negotiate their media format separately.
             */
            fun format(format: AudioFormat) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed [AudioFormat] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun format(format: JsonField<AudioFormat>) = apply { this.format = format }

            /** Alias for calling [format] with `AudioFormat.ofAudioPcm(audioPcm)`. */
            fun format(audioPcm: AudioFormat.AudioPcm) = format(AudioFormat.ofAudioPcm(audioPcm))

            /**
             * Alias for calling [format] with the following:
             * ```java
             * AudioFormat.AudioPcm.builder()
             *     .rate(rate)
             *     .build()
             * ```
             */
            fun audioPcmFormat(rate: AudioFormat.AudioPcm.Rate) =
                format(AudioFormat.AudioPcm.builder().rate(rate).build())

            /** Alias for calling [format] with `AudioFormat.ofAudioPcmu(audioPcmu)`. */
            fun format(audioPcmu: AudioFormat.AudioPcmu) =
                format(AudioFormat.ofAudioPcmu(audioPcmu))

            /**
             * Alias for calling [format] with the following:
             * ```java
             * AudioFormat.AudioPcmu.builder()
             *     .rate(rate)
             *     .build()
             * ```
             */
            fun audioPcmuFormat(rate: Long) =
                format(AudioFormat.AudioPcmu.builder().rate(rate).build())

            /** Alias for calling [format] with `AudioFormat.ofAudioPcma(audioPcma)`. */
            fun format(audioPcma: AudioFormat.AudioPcma) =
                format(AudioFormat.ofAudioPcma(audioPcma))

            /**
             * Alias for calling [format] with the following:
             * ```java
             * AudioFormat.AudioPcma.builder()
             *     .rate(rate)
             *     .build()
             * ```
             */
            fun audioPcmaFormat(rate: Long) =
                format(AudioFormat.AudioPcma.builder().rate(rate).build())

            /** The voice used for speech generated by the Live model. */
            fun output(output: Output) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [Output] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<Output>) = apply { this.output = output }

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
             * Returns an immutable instance of [Audio].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Audio = Audio(format, output, additionalProperties.toMutableMap())
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
        fun validate(): Audio = apply {
            if (validated) {
                return@apply
            }

            format().ifPresent { it.validate() }
            output().ifPresent { it.validate() }
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
            (format.asKnown().getOrNull()?.validity() ?: 0) +
                (output.asKnown().getOrNull()?.validity() ?: 0)

        /** The voice used for speech generated by the Live model. */
        class Output
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val voice: JsonField<Voice>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of()
            ) : this(voice, mutableMapOf())

            /**
             * The voice used for Live speech, as a built-in voice name or a custom voice object
             * containing its ID. Defaults to `marin` and cannot change after startup.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun voice(): Optional<Voice> = voice.getOptional("voice")

            /**
             * Returns the raw JSON value of [voice].
             *
             * Unlike [voice], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("voice") @ExcludeMissing fun _voice(): JsonField<Voice> = voice

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

                /** Returns a mutable builder for constructing an instance of [Output]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Output]. */
            class Builder internal constructor() {

                private var voice: JsonField<Voice> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(output: Output) = apply {
                    voice = output.voice
                    additionalProperties = output.additionalProperties.toMutableMap()
                }

                /**
                 * The voice used for Live speech, as a built-in voice name or a custom voice object
                 * containing its ID. Defaults to `marin` and cannot change after startup.
                 */
                fun voice(voice: Voice) = voice(JsonField.of(voice))

                /**
                 * Sets [Builder.voice] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.voice] with a well-typed [Voice] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

                /** Alias for calling [voice] with `Voice.ofString(string)`. */
                fun voice(string: String) = voice(Voice.ofString(string))

                /** Alias for calling [voice] with `Voice.ofBuiltIn(builtIn)`. */
                fun voice(builtIn: BuiltInVoice) = voice(Voice.ofBuiltIn(builtIn))

                /** Alias for calling [voice] with `Voice.ofCustom(custom)`. */
                fun voice(custom: CustomVoice) = voice(Voice.ofCustom(custom))

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Output].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Output = Output(voice, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Output = apply {
                if (validated) {
                    return@apply
                }

                voice().ifPresent { it.validate() }
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
            internal fun validity(): Int = (voice.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * The voice used for Live speech, as a built-in voice name or a custom voice object
             * containing its ID. Defaults to `marin` and cannot change after startup.
             */
            @JsonDeserialize(using = Voice.Deserializer::class)
            @JsonSerialize(using = Voice.Serializer::class)
            class Voice
            private constructor(
                private val string: String? = null,
                private val builtIn: BuiltInVoice? = null,
                private val custom: CustomVoice? = null,
                private val _json: JsonValue? = null,
            ) {

                fun string(): Optional<String> = Optional.ofNullable(string)

                /** A built-in voice available for Live speech. */
                fun builtIn(): Optional<BuiltInVoice> = Optional.ofNullable(builtIn)

                fun custom(): Optional<CustomVoice> = Optional.ofNullable(custom)

                fun isString(): Boolean = string != null

                fun isBuiltIn(): Boolean = builtIn != null

                fun isCustom(): Boolean = custom != null

                fun asString(): String = string.getOrThrow("string")

                /** A built-in voice available for Live speech. */
                fun asBuiltIn(): BuiltInVoice = builtIn.getOrThrow("builtIn")

                fun asCustom(): CustomVoice = custom.getOrThrow("custom")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = voice.accept(new Voice.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitString(String string) {
                 *         return Optional.of(string.toString());
                 *     }
                 *
                 *     // ...
                 *
                 *     @Override
                 *     public Optional<String> unknown(JsonValue json) {
                 *         // Or inspect the `json`.
                 *         return Optional.empty();
                 *     }
                 * });
                 * ```
                 *
                 * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                 *   [visitor] and the current variant is unknown.
                 */
                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        string != null -> visitor.visitString(string)
                        builtIn != null -> visitor.visitBuiltIn(builtIn)
                        custom != null -> visitor.visitCustom(custom)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Voice = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitString(string: String) {}

                            override fun visitBuiltIn(builtIn: BuiltInVoice) {
                                builtIn.validate()
                            }

                            override fun visitCustom(custom: CustomVoice) {
                                custom.validate()
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
                            override fun visitString(string: String) = 1

                            override fun visitBuiltIn(builtIn: BuiltInVoice) = builtIn.validity()

                            override fun visitCustom(custom: CustomVoice) = custom.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Voice &&
                        string == other.string &&
                        builtIn == other.builtIn &&
                        custom == other.custom
                }

                override fun hashCode(): Int = Objects.hash(string, builtIn, custom)

                override fun toString(): String =
                    when {
                        string != null -> "Voice{string=$string}"
                        builtIn != null -> "Voice{builtIn=$builtIn}"
                        custom != null -> "Voice{custom=$custom}"
                        _json != null -> "Voice{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Voice")
                    }

                companion object {

                    @JvmStatic fun ofString(string: String) = Voice(string = string)

                    /** A built-in voice available for Live speech. */
                    @JvmStatic fun ofBuiltIn(builtIn: BuiltInVoice) = Voice(builtIn = builtIn)

                    @JvmStatic fun ofCustom(custom: CustomVoice) = Voice(custom = custom)
                }

                /**
                 * An interface that defines how to map each variant of [Voice] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitString(string: String): T

                    /** A built-in voice available for Live speech. */
                    fun visitBuiltIn(builtIn: BuiltInVoice): T

                    fun visitCustom(custom: CustomVoice): T

                    /**
                     * Maps an unknown variant of [Voice] to a value of type [T].
                     *
                     * An instance of [Voice] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Voice: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Voice>(Voice::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Voice {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<BuiltInVoice>())?.let {
                                        Voice(builtIn = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<CustomVoice>())?.let {
                                        Voice(custom = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        Voice(string = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // boolean).
                            0 -> Voice(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<Voice>(Voice::class) {

                    override fun serialize(
                        value: Voice,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.string != null -> generator.writeObject(value.string)
                            value.builtIn != null -> generator.writeObject(value.builtIn)
                            value.custom != null -> generator.writeObject(value.custom)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Voice")
                        }
                    }
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Output &&
                    voice == other.voice &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(voice, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Output{voice=$voice, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Audio &&
                format == other.format &&
                output == other.output &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(format, output, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Audio{format=$format, output=$output, additionalProperties=$additionalProperties}"
    }

    /**
     * Who handles tasks delegated by the Live model. Omitted or null selects your application; use
     * `responses` to let the API manage a Responses backend.
     */
    @JsonDeserialize(using = Delegation.Deserializer::class)
    @JsonSerialize(using = Delegation.Serializer::class)
    class Delegation
    private constructor(
        private val client: ClientDelegation? = null,
        private val responses: Responses? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Delegate tasks to your application. The Live session emits delegation events that your
         * backend handles.
         */
        fun client(): Optional<ClientDelegation> = Optional.ofNullable(client)

        /** Delegate tasks to a Responses model managed by the Live session. */
        fun responses(): Optional<Responses> = Optional.ofNullable(responses)

        fun isClient(): Boolean = client != null

        fun isResponses(): Boolean = responses != null

        /**
         * Delegate tasks to your application. The Live session emits delegation events that your
         * backend handles.
         */
        fun asClient(): ClientDelegation = client.getOrThrow("client")

        /** Delegate tasks to a Responses model managed by the Live session. */
        fun asResponses(): Responses = responses.getOrThrow("responses")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = delegation.accept(new Delegation.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitClient(ClientDelegation client) {
         *         return Optional.of(client.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                client != null -> visitor.visitClient(client)
                responses != null -> visitor.visitResponses(responses)
                else -> visitor.unknown(_json)
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
        fun validate(): Delegation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitClient(client: ClientDelegation) {
                        client.validate()
                    }

                    override fun visitResponses(responses: Responses) {
                        responses.validate()
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
                    override fun visitClient(client: ClientDelegation) = client.validity()

                    override fun visitResponses(responses: Responses) = responses.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Delegation && client == other.client && responses == other.responses
        }

        override fun hashCode(): Int = Objects.hash(client, responses)

        override fun toString(): String =
            when {
                client != null -> "Delegation{client=$client}"
                responses != null -> "Delegation{responses=$responses}"
                _json != null -> "Delegation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Delegation")
            }

        companion object {

            /**
             * Delegate tasks to your application. The Live session emits delegation events that
             * your backend handles.
             */
            @JvmStatic fun ofClient(client: ClientDelegation) = Delegation(client = client)

            /** Delegate tasks to a Responses model managed by the Live session. */
            @JvmStatic fun ofResponses(responses: Responses) = Delegation(responses = responses)
        }

        /**
         * An interface that defines how to map each variant of [Delegation] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * Delegate tasks to your application. The Live session emits delegation events that
             * your backend handles.
             */
            fun visitClient(client: ClientDelegation): T

            /** Delegate tasks to a Responses model managed by the Live session. */
            fun visitResponses(responses: Responses): T

            /**
             * Maps an unknown variant of [Delegation] to a value of type [T].
             *
             * An instance of [Delegation] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Delegation: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Delegation>(Delegation::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Delegation {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "client" -> {
                        return tryDeserialize(node, jacksonTypeRef<ClientDelegation>())?.let {
                            Delegation(client = it, _json = json)
                        } ?: Delegation(_json = json)
                    }
                    "responses" -> {
                        return tryDeserialize(node, jacksonTypeRef<Responses>())?.let {
                            Delegation(responses = it, _json = json)
                        } ?: Delegation(_json = json)
                    }
                }

                return Delegation(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Delegation>(Delegation::class) {

            override fun serialize(
                value: Delegation,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.client != null -> generator.writeObject(value.client)
                    value.responses != null -> generator.writeObject(value.responses)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Delegation")
                }
            }
        }

        /** Delegate tasks to a Responses model managed by the Live session. */
        class Responses
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val responses: JsonField<ResponsesDelegationConfig>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("responses")
                @ExcludeMissing
                responses: JsonField<ResponsesDelegationConfig> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(responses, type, mutableMapOf())

            /**
             * Backend model, prompt, and tools used when the Live session delegates a task to
             * Responses.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun responses(): ResponsesDelegationConfig = responses.getRequired("responses")

            /**
             * The delegation owner. Always `responses` for tasks handled by the Responses API.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("responses")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [responses].
             *
             * Unlike [responses], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("responses")
            @ExcludeMissing
            fun _responses(): JsonField<ResponsesDelegationConfig> = responses

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
                 * Returns a mutable builder for constructing an instance of [Responses].
                 *
                 * The following fields are required:
                 * ```java
                 * .responses()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Responses]. */
            class Builder internal constructor() {

                private var responses: JsonField<ResponsesDelegationConfig>? = null
                private var type: JsonValue = JsonValue.from("responses")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(responses: Responses) = apply {
                    this.responses = responses.responses
                    type = responses.type
                    additionalProperties = responses.additionalProperties.toMutableMap()
                }

                /**
                 * Backend model, prompt, and tools used when the Live session delegates a task to
                 * Responses.
                 */
                fun responses(responses: ResponsesDelegationConfig) =
                    responses(JsonField.of(responses))

                /**
                 * Sets [Builder.responses] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.responses] with a well-typed
                 * [ResponsesDelegationConfig] value instead. This method is primarily for setting
                 * the field to an undocumented or not yet supported value.
                 */
                fun responses(responses: JsonField<ResponsesDelegationConfig>) = apply {
                    this.responses = responses
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("responses")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Responses].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .responses()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Responses =
                    Responses(
                        checkRequired("responses", responses),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Responses = apply {
                if (validated) {
                    return@apply
                }

                responses().validate()
                _type().let {
                    if (it != JsonValue.from("responses")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (responses.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("responses")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Responses &&
                    responses == other.responses &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(responses, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Responses{responses=$responses, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionConfig &&
            model == other.model &&
            audio == other.audio &&
            client == other.client &&
            delegation == other.delegation &&
            input == other.input &&
            instructions == other.instructions &&
            store == other.store &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            model,
            audio,
            client,
            delegation,
            input,
            instructions,
            store,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SessionConfig{model=$model, audio=$audio, client=$client, delegation=$delegation, input=$input, instructions=$instructions, store=$store, additionalProperties=$additionalProperties}"
}
