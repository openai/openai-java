// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sessions

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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.live.BuiltInVoice
import com.openai.models.live.ClientDelegation
import com.openai.models.live.CustomVoice
import com.openai.models.live.InitialItem
import com.openai.models.live.ResponsesDelegationConfig
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Accept an incoming SIP call with Live startup configuration. */
class SessionAcceptParams
private constructor(
    private val sessionId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun sessionId(): Optional<String> = Optional.ofNullable(sessionId)

    /**
     * Model and startup configuration for the Live session that answers the incoming SIP call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun session(): Session = body.session()

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

        /**
         * Returns a mutable builder for constructing an instance of [SessionAcceptParams].
         *
         * The following fields are required:
         * ```java
         * .session()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionAcceptParams]. */
    class Builder internal constructor() {

        private var sessionId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(sessionAcceptParams: SessionAcceptParams) = apply {
            sessionId = sessionAcceptParams.sessionId
            body = sessionAcceptParams.body.toBuilder()
            additionalHeaders = sessionAcceptParams.additionalHeaders.toBuilder()
            additionalQueryParams = sessionAcceptParams.additionalQueryParams.toBuilder()
        }

        fun sessionId(sessionId: String?) = apply { this.sessionId = sessionId }

        /** Alias for calling [Builder.sessionId] with `sessionId.orElse(null)`. */
        fun sessionId(sessionId: Optional<String>) = sessionId(sessionId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [session]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Model and startup configuration for the Live session that answers the incoming SIP call.
         */
        fun session(session: Session) = apply { body.session(session) }

        /**
         * Sets [Builder.session] to an arbitrary JSON value.
         *
         * You should usually call [Builder.session] with a well-typed [Session] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun session(session: JsonField<Session>) = apply { body.session(session) }

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
         * Returns an immutable instance of [SessionAcceptParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .session()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SessionAcceptParams =
            SessionAcceptParams(
                sessionId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> sessionId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Accept an incoming SIP call with Live startup configuration. */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val session: JsonField<Session>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("session") @ExcludeMissing session: JsonField<Session> = JsonMissing.of()
        ) : this(session, mutableMapOf())

        /**
         * Model and startup configuration for the Live session that answers the incoming SIP call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun session(): Session = session.getRequired("session")

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

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .session()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var session: JsonField<Session>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                session = body.session
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Model and startup configuration for the Live session that answers the incoming SIP
             * call.
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
             * .session()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(checkRequired("session", session), additionalProperties.toMutableMap())
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            session().validate()
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
        internal fun validity(): Int = (session.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                session == other.session &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(session, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{session=$session, additionalProperties=$additionalProperties}"
    }

    /** Model and startup configuration for the Live session that answers the incoming SIP call. */
    class Session
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val model: JsonField<Model>,
        private val type: JsonValue,
        private val audio: JsonField<Audio>,
        private val delegation: JsonField<Delegation>,
        private val input: JsonField<List<InitialItem>>,
        private val instructions: JsonField<String>,
        private val store: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("audio") @ExcludeMissing audio: JsonField<Audio> = JsonMissing.of(),
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
        ) : this(model, type, audio, delegation, input, instructions, store, mutableMapOf())

        /**
         * The Live model to use for the accepted call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): Model = model.getRequired("model")

        /**
         * The session type. Always `live`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("live")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Startup audio output configuration. SIP negotiates the media format; audio.format is only
         * accepted for primary WebSockets. Voice cannot change after startup.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun audio(): Optional<Audio> = audio.getOptional("audio")

        /**
         * Who handles tasks delegated by the Live model. Omitted or null selects your application;
         * use `responses` to let the API manage a Responses backend.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun delegation(): Optional<Delegation> = delegation.getOptional("delegation")

        /**
         * Ordered text-only history supplied before startup. Supports developer, user, and
         * assistant messages with one text part each; at most 128 messages and 8,192 rendered
         * tokens in total.
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
         * Limited to 16,384 client-supplied tokens. Omitted or blank instructions use server
         * defaults. Immutable after startup.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun instructions(): Optional<String> = instructions.getOptional("instructions")

        /**
         * Whether to store the session for later forking and recording download. Defaults to false
         * for new sessions.
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
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
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
             * Returns a mutable builder for constructing an instance of [Session].
             *
             * The following fields are required:
             * ```java
             * .model()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Session]. */
        class Builder internal constructor() {

            private var model: JsonField<Model>? = null
            private var type: JsonValue = JsonValue.from("live")
            private var audio: JsonField<Audio> = JsonMissing.of()
            private var delegation: JsonField<Delegation> = JsonMissing.of()
            private var input: JsonField<MutableList<InitialItem>>? = null
            private var instructions: JsonField<String> = JsonMissing.of()
            private var store: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(session: Session) = apply {
                model = session.model
                type = session.type
                audio = session.audio
                delegation = session.delegation
                input = session.input.map { it.toMutableList() }
                instructions = session.instructions
                store = session.store
                additionalProperties = session.additionalProperties.toMutableMap()
            }

            /** The Live model to use for the accepted call. */
            fun model(model: Model) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [Model] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(model: JsonField<Model>) = apply { this.model = model }

            /**
             * Sets [model] to an arbitrary [String].
             *
             * You should usually call [model] with a well-typed [Model] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(value: String) = model(Model.of(value))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("live")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * Startup audio output configuration. SIP negotiates the media format; audio.format is
             * only accepted for primary WebSockets. Voice cannot change after startup.
             */
            fun audio(audio: Audio) = audio(JsonField.of(audio))

            /**
             * Sets [Builder.audio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audio] with a well-typed [Audio] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun audio(audio: JsonField<Audio>) = apply { this.audio = audio }

            /**
             * Who handles tasks delegated by the Live model. Omitted or null selects your
             * application; use `responses` to let the API manage a Responses backend.
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
            fun delegation(delegation: JsonField<Delegation>) = apply {
                this.delegation = delegation
            }

            /** Alias for calling [delegation] with `Delegation.ofClient(client)`. */
            fun delegation(client: ClientDelegation) = delegation(Delegation.ofClient(client))

            /** Alias for calling [delegation] with `Delegation.ofResponses(responses)`. */
            fun delegation(responses: Delegation.Responses) =
                delegation(Delegation.ofResponses(responses))

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
             * Frontend instructions for voice, conversation, interruptions, and when to delegate.
             * Start with the
             * [Live prompting guide](https://developers.openai.com/api/docs/guides/live-prompting);
             * put business rules and tool workflows in a separate
             * [backend prompt](https://developers.openai.com/api/docs/guides/live-delegation#start-with-your-existing-backend-prompt).
             * Limited to 16,384 client-supplied tokens. Omitted or blank instructions use server
             * defaults. Immutable after startup.
             */
            fun instructions(instructions: String?) =
                instructions(JsonField.ofNullable(instructions))

            /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
            fun instructions(instructions: Optional<String>) =
                instructions(instructions.getOrNull())

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun instructions(instructions: JsonField<String>) = apply {
                this.instructions = instructions
            }

            /**
             * Whether to store the session for later forking and recording download. Defaults to
             * false for new sessions.
             */
            fun store(store: Boolean) = store(JsonField.of(store))

            /**
             * Sets [Builder.store] to an arbitrary JSON value.
             *
             * You should usually call [Builder.store] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Session].
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
            fun build(): Session =
                Session(
                    checkRequired("model", model),
                    type,
                    audio,
                    delegation,
                    (input ?: JsonMissing.of()).map { it.toImmutable() },
                    instructions,
                    store,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Session = apply {
            if (validated) {
                return@apply
            }

            model()
            _type().let {
                if (it != JsonValue.from("live")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            audio().ifPresent { it.validate() }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (model.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("live")) 1 else 0 } +
                (audio.asKnown().getOrNull()?.validity() ?: 0) +
                (delegation.asKnown().getOrNull()?.validity() ?: 0) +
                (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (store.asKnown().isPresent) 1 else 0)

        /** The Live model to use for the accepted call. */
        class Model @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                GPT_LIVE_1,
                /**
                 * An enum member indicating that [Model] was instantiated with an unknown value.
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
                    GPT_LIVE_1 -> Value.GPT_LIVE_1
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
                    GPT_LIVE_1 -> Known.GPT_LIVE_1
                    else -> throw OpenAIInvalidDataException("Unknown Model: $value")
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
         * Startup audio output configuration. SIP negotiates the media format; audio.format is only
         * accepted for primary WebSockets. Voice cannot change after startup.
         */
        class Audio
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val output: JsonField<Output>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("output") @ExcludeMissing output: JsonField<Output> = JsonMissing.of()
            ) : this(output, mutableMapOf())

            /**
             * Settings for speech generated by the Live model. Choose the voice before starting the
             * session.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun output(): Optional<Output> = output.getOptional("output")

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

                private var output: JsonField<Output> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(audio: Audio) = apply {
                    output = audio.output
                    additionalProperties = audio.additionalProperties.toMutableMap()
                }

                /**
                 * Settings for speech generated by the Live model. Choose the voice before starting
                 * the session.
                 */
                fun output(output: Output) = output(JsonField.of(output))

                /**
                 * Sets [Builder.output] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.output] with a well-typed [Output] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun output(output: JsonField<Output>) = apply { this.output = output }

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
                 * Returns an immutable instance of [Audio].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Audio = Audio(output, additionalProperties.toMutableMap())
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
            fun validate(): Audio = apply {
                if (validated) {
                    return@apply
                }

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
            internal fun validity(): Int = (output.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Settings for speech generated by the Live model. Choose the voice before starting the
             * session.
             */
            class Output
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val voice: JsonField<Voice>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("voice")
                    @ExcludeMissing
                    voice: JsonField<Voice> = JsonMissing.of()
                ) : this(voice, mutableMapOf())

                /**
                 * The voice used for Live speech, as a built-in voice name or a custom voice object
                 * containing its ID. Defaults to `marin` and cannot change after startup.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun voice(): Optional<Voice> = voice.getOptional("voice")

                /**
                 * Returns the raw JSON value of [voice].
                 *
                 * Unlike [voice], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * The voice used for Live speech, as a built-in voice name or a custom voice
                     * object containing its ID. Defaults to `marin` and cannot change after
                     * startup.
                     */
                    fun voice(voice: Voice) = voice(JsonField.of(voice))

                    /**
                     * Sets [Builder.voice] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.voice] with a well-typed [Voice] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
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
                     * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not
                     * known to this version of the SDK gracefully, consider overriding
                     * [Visitor.unknown]:
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
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
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

                                override fun visitBuiltIn(builtIn: BuiltInVoice) =
                                    builtIn.validity()

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
                     * An interface that defines how to map each variant of [Voice] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitString(string: String): T

                        /** A built-in voice available for Live speech. */
                        fun visitBuiltIn(builtIn: BuiltInVoice): T

                        fun visitCustom(custom: CustomVoice): T

                        /**
                         * Maps an unknown variant of [Voice] to a value of type [T].
                         *
                         * An instance of [Voice] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
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
                                // incompatible with all the possible variants (e.g. deserializing
                                // from boolean).
                                0 -> Voice(_json = json)
                                1 -> bestMatches.single()
                                // If there's more than one match with the highest validity, then
                                // use the first completely valid match, or simply the first match
                                // if none are completely valid.
                                else ->
                                    bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
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
                    output == other.output &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(output, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Audio{output=$output, additionalProperties=$additionalProperties}"
        }

        /**
         * Who handles tasks delegated by the Live model. Omitted or null selects your application;
         * use `responses` to let the API manage a Responses backend.
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
             * Delegate tasks to your application. The Live session emits delegation events that
             * your backend handles.
             */
            fun client(): Optional<ClientDelegation> = Optional.ofNullable(client)

            /** Delegate tasks to a Responses model managed by the Live session. */
            fun responses(): Optional<Responses> = Optional.ofNullable(responses)

            fun isClient(): Boolean = client != null

            fun isResponses(): Boolean = responses != null

            /**
             * Delegate tasks to your application. The Live session emits delegation events that
             * your backend handles.
             */
            fun asClient(): ClientDelegation = client.getOrThrow("client")

            /** Delegate tasks to a Responses model managed by the Live session. */
            fun asResponses(): Responses = responses.getOrThrow("responses")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
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
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
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
             * An interface that defines how to map each variant of [Delegation] to a value of type
             * [T].
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
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
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

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<ClientDelegation>())?.let {
                                    Delegation(client = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Responses>())?.let {
                                    Delegation(responses = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Delegation(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
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
                     * Backend model, prompt, and tools used when the Live session delegates a task
                     * to Responses.
                     */
                    fun responses(responses: ResponsesDelegationConfig) =
                        responses(JsonField.of(responses))

                    /**
                     * Sets [Builder.responses] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.responses] with a well-typed
                     * [ResponsesDelegationConfig] value instead. This method is primarily for
                     * setting the field to an undocumented or not yet supported value.
                     */
                    fun responses(responses: JsonField<ResponsesDelegationConfig>) = apply {
                        this.responses = responses
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
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

            return other is Session &&
                model == other.model &&
                type == other.type &&
                audio == other.audio &&
                delegation == other.delegation &&
                input == other.input &&
                instructions == other.instructions &&
                store == other.store &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                model,
                type,
                audio,
                delegation,
                input,
                instructions,
                store,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Session{model=$model, type=$type, audio=$audio, delegation=$delegation, input=$input, instructions=$instructions, store=$store, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionAcceptParams &&
            sessionId == other.sessionId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(sessionId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "SessionAcceptParams{sessionId=$sessionId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
