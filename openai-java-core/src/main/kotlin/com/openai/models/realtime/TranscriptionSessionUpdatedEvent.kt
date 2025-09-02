// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returned when a transcription session is updated with a `transcription_session.update` event,
 * unless there is an error.
 */
class TranscriptionSessionUpdatedEvent
private constructor(
    private val eventId: JsonField<String>,
    private val session: JsonField<Session>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("session") @ExcludeMissing session: JsonField<Session> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(eventId, session, type, mutableMapOf())

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * A Realtime transcription session configuration object.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun session(): Session = session.getRequired("session")

    /**
     * The event type, must be `transcription_session.updated`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("transcription_session.updated")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
         * Returns a mutable builder for constructing an instance of
         * [TranscriptionSessionUpdatedEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .session()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionSessionUpdatedEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var session: JsonField<Session>? = null
        private var type: JsonValue = JsonValue.from("transcription_session.updated")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionSessionUpdatedEvent: TranscriptionSessionUpdatedEvent) =
            apply {
                eventId = transcriptionSessionUpdatedEvent.eventId
                session = transcriptionSessionUpdatedEvent.session
                type = transcriptionSessionUpdatedEvent.type
                additionalProperties =
                    transcriptionSessionUpdatedEvent.additionalProperties.toMutableMap()
            }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** A Realtime transcription session configuration object. */
        fun session(session: Session) = session(JsonField.of(session))

        /**
         * Sets [Builder.session] to an arbitrary JSON value.
         *
         * You should usually call [Builder.session] with a well-typed [Session] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun session(session: JsonField<Session>) = apply { this.session = session }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("transcription_session.updated")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [TranscriptionSessionUpdatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .session()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TranscriptionSessionUpdatedEvent =
            TranscriptionSessionUpdatedEvent(
                checkRequired("eventId", eventId),
                checkRequired("session", session),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TranscriptionSessionUpdatedEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        session().validate()
        _type().let {
            if (it != JsonValue.from("transcription_session.updated")) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (eventId.asKnown().isPresent) 1 else 0) +
            (session.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("transcription_session.updated")) 1 else 0 }

    /** A Realtime transcription session configuration object. */
    class Session
    private constructor(
        private val id: JsonField<String>,
        private val audio: JsonField<Audio>,
        private val expiresAt: JsonField<Long>,
        private val include: JsonField<List<Include>>,
        private val object_: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("audio") @ExcludeMissing audio: JsonField<Audio> = JsonMissing.of(),
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("include")
            @ExcludeMissing
            include: JsonField<List<Include>> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        ) : this(id, audio, expiresAt, include, object_, mutableMapOf())

        /**
         * Unique identifier for the session that looks like `sess_1234567890abcdef`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Configuration for input audio for the session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun audio(): Optional<Audio> = audio.getOptional("audio")

        /**
         * Expiration timestamp for the session, in seconds since epoch.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAt(): Optional<Long> = expiresAt.getOptional("expires_at")

        /**
         * Additional fields to include in server outputs.
         * - `item.input_audio_transcription.logprobs`: Include logprobs for input audio
         *   transcription.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun include(): Optional<List<Include>> = include.getOptional("include")

        /**
         * The object type. Always `realtime.transcription_session`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun object_(): Optional<String> = object_.getOptional("object")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [audio].
         *
         * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<Audio> = audio

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

        /**
         * Returns the raw JSON value of [include].
         *
         * Unlike [include], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("include") @ExcludeMissing fun _include(): JsonField<List<Include>> = include

        /**
         * Returns the raw JSON value of [object_].
         *
         * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

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

            /** Returns a mutable builder for constructing an instance of [Session]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Session]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var audio: JsonField<Audio> = JsonMissing.of()
            private var expiresAt: JsonField<Long> = JsonMissing.of()
            private var include: JsonField<MutableList<Include>>? = null
            private var object_: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(session: Session) = apply {
                id = session.id
                audio = session.audio
                expiresAt = session.expiresAt
                include = session.include.map { it.toMutableList() }
                object_ = session.object_
                additionalProperties = session.additionalProperties.toMutableMap()
            }

            /** Unique identifier for the session that looks like `sess_1234567890abcdef`. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Configuration for input audio for the session. */
            fun audio(audio: Audio) = audio(JsonField.of(audio))

            /**
             * Sets [Builder.audio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audio] with a well-typed [Audio] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun audio(audio: JsonField<Audio>) = apply { this.audio = audio }

            /** Expiration timestamp for the session, in seconds since epoch. */
            fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

            /**
             * Additional fields to include in server outputs.
             * - `item.input_audio_transcription.logprobs`: Include logprobs for input audio
             *   transcription.
             */
            fun include(include: List<Include>) = include(JsonField.of(include))

            /**
             * Sets [Builder.include] to an arbitrary JSON value.
             *
             * You should usually call [Builder.include] with a well-typed `List<Include>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun include(include: JsonField<List<Include>>) = apply {
                this.include = include.map { it.toMutableList() }
            }

            /**
             * Adds a single [Include] to [Builder.include].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInclude(include: Include) = apply {
                this.include =
                    (this.include ?: JsonField.of(mutableListOf())).also {
                        checkKnown("include", it).add(include)
                    }
            }

            /** The object type. Always `realtime.transcription_session`. */
            fun object_(object_: String) = object_(JsonField.of(object_))

            /**
             * Sets [Builder.object_] to an arbitrary JSON value.
             *
             * You should usually call [Builder.object_] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

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
             */
            fun build(): Session =
                Session(
                    id,
                    audio,
                    expiresAt,
                    (include ?: JsonMissing.of()).map { it.toImmutable() },
                    object_,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Session = apply {
            if (validated) {
                return@apply
            }

            id()
            audio().ifPresent { it.validate() }
            expiresAt()
            include().ifPresent { it.forEach { it.validate() } }
            object_()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (audio.asKnown().getOrNull()?.validity() ?: 0) +
                (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (include.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (object_.asKnown().isPresent) 1 else 0)

        /** Configuration for input audio for the session. */
        class Audio
        private constructor(
            private val input: JsonField<Input>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of()
            ) : this(input, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun input(): Optional<Input> = input.getOptional("input")

            /**
             * Returns the raw JSON value of [input].
             *
             * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

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

                private var input: JsonField<Input> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(audio: Audio) = apply {
                    input = audio.input
                    additionalProperties = audio.additionalProperties.toMutableMap()
                }

                fun input(input: Input) = input(JsonField.of(input))

                /**
                 * Sets [Builder.input] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.input] with a well-typed [Input] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun input(input: JsonField<Input>) = apply { this.input = input }

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
                fun build(): Audio = Audio(input, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Audio = apply {
                if (validated) {
                    return@apply
                }

                input().ifPresent { it.validate() }
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
            internal fun validity(): Int = (input.asKnown().getOrNull()?.validity() ?: 0)

            class Input
            private constructor(
                private val format: JsonField<String>,
                private val noiseReduction: JsonField<NoiseReduction>,
                private val transcription: JsonField<Transcription>,
                private val turnDetection: JsonField<TurnDetection>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("format")
                    @ExcludeMissing
                    format: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("noise_reduction")
                    @ExcludeMissing
                    noiseReduction: JsonField<NoiseReduction> = JsonMissing.of(),
                    @JsonProperty("transcription")
                    @ExcludeMissing
                    transcription: JsonField<Transcription> = JsonMissing.of(),
                    @JsonProperty("turn_detection")
                    @ExcludeMissing
                    turnDetection: JsonField<TurnDetection> = JsonMissing.of(),
                ) : this(format, noiseReduction, transcription, turnDetection, mutableMapOf())

                /**
                 * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun format(): Optional<String> = format.getOptional("format")

                /**
                 * Configuration for input audio noise reduction.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun noiseReduction(): Optional<NoiseReduction> =
                    noiseReduction.getOptional("noise_reduction")

                /**
                 * Configuration of the transcription model.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun transcription(): Optional<Transcription> =
                    transcription.getOptional("transcription")

                /**
                 * Configuration for turn detection.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun turnDetection(): Optional<TurnDetection> =
                    turnDetection.getOptional("turn_detection")

                /**
                 * Returns the raw JSON value of [format].
                 *
                 * Unlike [format], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<String> = format

                /**
                 * Returns the raw JSON value of [noiseReduction].
                 *
                 * Unlike [noiseReduction], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("noise_reduction")
                @ExcludeMissing
                fun _noiseReduction(): JsonField<NoiseReduction> = noiseReduction

                /**
                 * Returns the raw JSON value of [transcription].
                 *
                 * Unlike [transcription], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("transcription")
                @ExcludeMissing
                fun _transcription(): JsonField<Transcription> = transcription

                /**
                 * Returns the raw JSON value of [turnDetection].
                 *
                 * Unlike [turnDetection], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("turn_detection")
                @ExcludeMissing
                fun _turnDetection(): JsonField<TurnDetection> = turnDetection

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

                    /** Returns a mutable builder for constructing an instance of [Input]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Input]. */
                class Builder internal constructor() {

                    private var format: JsonField<String> = JsonMissing.of()
                    private var noiseReduction: JsonField<NoiseReduction> = JsonMissing.of()
                    private var transcription: JsonField<Transcription> = JsonMissing.of()
                    private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(input: Input) = apply {
                        format = input.format
                        noiseReduction = input.noiseReduction
                        transcription = input.transcription
                        turnDetection = input.turnDetection
                        additionalProperties = input.additionalProperties.toMutableMap()
                    }

                    /**
                     * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`.
                     */
                    fun format(format: String) = format(JsonField.of(format))

                    /**
                     * Sets [Builder.format] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.format] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun format(format: JsonField<String>) = apply { this.format = format }

                    /** Configuration for input audio noise reduction. */
                    fun noiseReduction(noiseReduction: NoiseReduction) =
                        noiseReduction(JsonField.of(noiseReduction))

                    /**
                     * Sets [Builder.noiseReduction] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.noiseReduction] with a well-typed
                     * [NoiseReduction] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun noiseReduction(noiseReduction: JsonField<NoiseReduction>) = apply {
                        this.noiseReduction = noiseReduction
                    }

                    /** Configuration of the transcription model. */
                    fun transcription(transcription: Transcription) =
                        transcription(JsonField.of(transcription))

                    /**
                     * Sets [Builder.transcription] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.transcription] with a well-typed
                     * [Transcription] value instead. This method is primarily for setting the field
                     * to an undocumented or not yet supported value.
                     */
                    fun transcription(transcription: JsonField<Transcription>) = apply {
                        this.transcription = transcription
                    }

                    /** Configuration for turn detection. */
                    fun turnDetection(turnDetection: TurnDetection) =
                        turnDetection(JsonField.of(turnDetection))

                    /**
                     * Sets [Builder.turnDetection] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.turnDetection] with a well-typed
                     * [TurnDetection] value instead. This method is primarily for setting the field
                     * to an undocumented or not yet supported value.
                     */
                    fun turnDetection(turnDetection: JsonField<TurnDetection>) = apply {
                        this.turnDetection = turnDetection
                    }

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
                     * Returns an immutable instance of [Input].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Input =
                        Input(
                            format,
                            noiseReduction,
                            transcription,
                            turnDetection,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Input = apply {
                    if (validated) {
                        return@apply
                    }

                    format()
                    noiseReduction().ifPresent { it.validate() }
                    transcription().ifPresent { it.validate() }
                    turnDetection().ifPresent { it.validate() }
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
                    (if (format.asKnown().isPresent) 1 else 0) +
                        (noiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
                        (transcription.asKnown().getOrNull()?.validity() ?: 0) +
                        (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

                /** Configuration for input audio noise reduction. */
                class NoiseReduction
                private constructor(
                    private val type: JsonField<Type>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<Type> = JsonMissing.of()
                    ) : this(type, mutableMapOf())

                    /**
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun type(): Optional<Type> = type.getOptional("type")

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                         * [NoiseReduction].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [NoiseReduction]. */
                    class Builder internal constructor() {

                        private var type: JsonField<Type> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(noiseReduction: NoiseReduction) = apply {
                            type = noiseReduction.type
                            additionalProperties =
                                noiseReduction.additionalProperties.toMutableMap()
                        }

                        fun type(type: Type) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [Type] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<Type>) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [NoiseReduction].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): NoiseReduction =
                            NoiseReduction(type, additionalProperties.toMutableMap())
                    }

                    private var validated: Boolean = false

                    fun validate(): NoiseReduction = apply {
                        if (validated) {
                            return@apply
                        }

                        type().ifPresent { it.validate() }
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
                    internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

                    class Type
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val NEAR_FIELD = of("near_field")

                            @JvmField val FAR_FIELD = of("far_field")

                            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                        }

                        /** An enum containing [Type]'s known values. */
                        enum class Known {
                            NEAR_FIELD,
                            FAR_FIELD,
                        }

                        /**
                         * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Type] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            NEAR_FIELD,
                            FAR_FIELD,
                            /**
                             * An enum member indicating that [Type] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                NEAR_FIELD -> Value.NEAR_FIELD
                                FAR_FIELD -> Value.FAR_FIELD
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                NEAR_FIELD -> Known.NEAR_FIELD
                                FAR_FIELD -> Known.FAR_FIELD
                                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                OpenAIInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Type = apply {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Type && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is NoiseReduction &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "NoiseReduction{type=$type, additionalProperties=$additionalProperties}"
                }

                /** Configuration of the transcription model. */
                class Transcription
                private constructor(
                    private val language: JsonField<String>,
                    private val model: JsonField<Model>,
                    private val prompt: JsonField<String>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("language")
                        @ExcludeMissing
                        language: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("model")
                        @ExcludeMissing
                        model: JsonField<Model> = JsonMissing.of(),
                        @JsonProperty("prompt")
                        @ExcludeMissing
                        prompt: JsonField<String> = JsonMissing.of(),
                    ) : this(language, model, prompt, mutableMapOf())

                    /**
                     * The language of the input audio. Supplying the input language in
                     * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g.
                     * `en`) format will improve accuracy and latency.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun language(): Optional<String> = language.getOptional("language")

                    /**
                     * The model to use for transcription. Can be `gpt-4o-transcribe`,
                     * `gpt-4o-mini-transcribe`, or `whisper-1`.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun model(): Optional<Model> = model.getOptional("model")

                    /**
                     * An optional text to guide the model's style or continue a previous audio
                     * segment. The
                     * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting)
                     * should match the audio language.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun prompt(): Optional<String> = prompt.getOptional("prompt")

                    /**
                     * Returns the raw JSON value of [language].
                     *
                     * Unlike [language], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("language")
                    @ExcludeMissing
                    fun _language(): JsonField<String> = language

                    /**
                     * Returns the raw JSON value of [model].
                     *
                     * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

                    /**
                     * Returns the raw JSON value of [prompt].
                     *
                     * Unlike [prompt], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("prompt")
                    @ExcludeMissing
                    fun _prompt(): JsonField<String> = prompt

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
                         * [Transcription].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Transcription]. */
                    class Builder internal constructor() {

                        private var language: JsonField<String> = JsonMissing.of()
                        private var model: JsonField<Model> = JsonMissing.of()
                        private var prompt: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(transcription: Transcription) = apply {
                            language = transcription.language
                            model = transcription.model
                            prompt = transcription.prompt
                            additionalProperties = transcription.additionalProperties.toMutableMap()
                        }

                        /**
                         * The language of the input audio. Supplying the input language in
                         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g.
                         * `en`) format will improve accuracy and latency.
                         */
                        fun language(language: String) = language(JsonField.of(language))

                        /**
                         * Sets [Builder.language] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.language] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun language(language: JsonField<String>) = apply {
                            this.language = language
                        }

                        /**
                         * The model to use for transcription. Can be `gpt-4o-transcribe`,
                         * `gpt-4o-mini-transcribe`, or `whisper-1`.
                         */
                        fun model(model: Model) = model(JsonField.of(model))

                        /**
                         * Sets [Builder.model] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.model] with a well-typed [Model] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun model(model: JsonField<Model>) = apply { this.model = model }

                        /**
                         * An optional text to guide the model's style or continue a previous audio
                         * segment. The
                         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting)
                         * should match the audio language.
                         */
                        fun prompt(prompt: String) = prompt(JsonField.of(prompt))

                        /**
                         * Sets [Builder.prompt] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.prompt] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun prompt(prompt: JsonField<String>) = apply { this.prompt = prompt }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Transcription].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Transcription =
                            Transcription(
                                language,
                                model,
                                prompt,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Transcription = apply {
                        if (validated) {
                            return@apply
                        }

                        language()
                        model().ifPresent { it.validate() }
                        prompt()
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
                        (if (language.asKnown().isPresent) 1 else 0) +
                            (model.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (prompt.asKnown().isPresent) 1 else 0)

                    /**
                     * The model to use for transcription. Can be `gpt-4o-transcribe`,
                     * `gpt-4o-mini-transcribe`, or `whisper-1`.
                     */
                    class Model
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val GPT_4O_TRANSCRIBE = of("gpt-4o-transcribe")

                            @JvmField val GPT_4O_MINI_TRANSCRIBE = of("gpt-4o-mini-transcribe")

                            @JvmField val WHISPER_1 = of("whisper-1")

                            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
                        }

                        /** An enum containing [Model]'s known values. */
                        enum class Known {
                            GPT_4O_TRANSCRIBE,
                            GPT_4O_MINI_TRANSCRIBE,
                            WHISPER_1,
                        }

                        /**
                         * An enum containing [Model]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Model] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            GPT_4O_TRANSCRIBE,
                            GPT_4O_MINI_TRANSCRIBE,
                            WHISPER_1,
                            /**
                             * An enum member indicating that [Model] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                GPT_4O_TRANSCRIBE -> Value.GPT_4O_TRANSCRIBE
                                GPT_4O_MINI_TRANSCRIBE -> Value.GPT_4O_MINI_TRANSCRIBE
                                WHISPER_1 -> Value.WHISPER_1
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                GPT_4O_TRANSCRIBE -> Known.GPT_4O_TRANSCRIBE
                                GPT_4O_MINI_TRANSCRIBE -> Known.GPT_4O_MINI_TRANSCRIBE
                                WHISPER_1 -> Known.WHISPER_1
                                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                OpenAIInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Model && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Transcription &&
                            language == other.language &&
                            model == other.model &&
                            prompt == other.prompt &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(language, model, prompt, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Transcription{language=$language, model=$model, prompt=$prompt, additionalProperties=$additionalProperties}"
                }

                /** Configuration for turn detection. */
                class TurnDetection
                private constructor(
                    private val prefixPaddingMs: JsonField<Long>,
                    private val silenceDurationMs: JsonField<Long>,
                    private val threshold: JsonField<Double>,
                    private val type: JsonField<String>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("prefix_padding_ms")
                        @ExcludeMissing
                        prefixPaddingMs: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("silence_duration_ms")
                        @ExcludeMissing
                        silenceDurationMs: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("threshold")
                        @ExcludeMissing
                        threshold: JsonField<Double> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<String> = JsonMissing.of(),
                    ) : this(prefixPaddingMs, silenceDurationMs, threshold, type, mutableMapOf())

                    /**
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun prefixPaddingMs(): Optional<Long> =
                        prefixPaddingMs.getOptional("prefix_padding_ms")

                    /**
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun silenceDurationMs(): Optional<Long> =
                        silenceDurationMs.getOptional("silence_duration_ms")

                    /**
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun threshold(): Optional<Double> = threshold.getOptional("threshold")

                    /**
                     * Type of turn detection, only `server_vad` is currently supported.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun type(): Optional<String> = type.getOptional("type")

                    /**
                     * Returns the raw JSON value of [prefixPaddingMs].
                     *
                     * Unlike [prefixPaddingMs], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("prefix_padding_ms")
                    @ExcludeMissing
                    fun _prefixPaddingMs(): JsonField<Long> = prefixPaddingMs

                    /**
                     * Returns the raw JSON value of [silenceDurationMs].
                     *
                     * Unlike [silenceDurationMs], this method doesn't throw if the JSON field has
                     * an unexpected type.
                     */
                    @JsonProperty("silence_duration_ms")
                    @ExcludeMissing
                    fun _silenceDurationMs(): JsonField<Long> = silenceDurationMs

                    /**
                     * Returns the raw JSON value of [threshold].
                     *
                     * Unlike [threshold], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("threshold")
                    @ExcludeMissing
                    fun _threshold(): JsonField<Double> = threshold

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
                         * [TurnDetection].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [TurnDetection]. */
                    class Builder internal constructor() {

                        private var prefixPaddingMs: JsonField<Long> = JsonMissing.of()
                        private var silenceDurationMs: JsonField<Long> = JsonMissing.of()
                        private var threshold: JsonField<Double> = JsonMissing.of()
                        private var type: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(turnDetection: TurnDetection) = apply {
                            prefixPaddingMs = turnDetection.prefixPaddingMs
                            silenceDurationMs = turnDetection.silenceDurationMs
                            threshold = turnDetection.threshold
                            type = turnDetection.type
                            additionalProperties = turnDetection.additionalProperties.toMutableMap()
                        }

                        fun prefixPaddingMs(prefixPaddingMs: Long) =
                            prefixPaddingMs(JsonField.of(prefixPaddingMs))

                        /**
                         * Sets [Builder.prefixPaddingMs] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.prefixPaddingMs] with a well-typed
                         * [Long] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun prefixPaddingMs(prefixPaddingMs: JsonField<Long>) = apply {
                            this.prefixPaddingMs = prefixPaddingMs
                        }

                        fun silenceDurationMs(silenceDurationMs: Long) =
                            silenceDurationMs(JsonField.of(silenceDurationMs))

                        /**
                         * Sets [Builder.silenceDurationMs] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.silenceDurationMs] with a well-typed
                         * [Long] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun silenceDurationMs(silenceDurationMs: JsonField<Long>) = apply {
                            this.silenceDurationMs = silenceDurationMs
                        }

                        fun threshold(threshold: Double) = threshold(JsonField.of(threshold))

                        /**
                         * Sets [Builder.threshold] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.threshold] with a well-typed [Double]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun threshold(threshold: JsonField<Double>) = apply {
                            this.threshold = threshold
                        }

                        /** Type of turn detection, only `server_vad` is currently supported. */
                        fun type(type: String) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<String>) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [TurnDetection].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): TurnDetection =
                            TurnDetection(
                                prefixPaddingMs,
                                silenceDurationMs,
                                threshold,
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): TurnDetection = apply {
                        if (validated) {
                            return@apply
                        }

                        prefixPaddingMs()
                        silenceDurationMs()
                        threshold()
                        type()
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
                        (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
                            (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
                            (if (threshold.asKnown().isPresent) 1 else 0) +
                            (if (type.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is TurnDetection &&
                            prefixPaddingMs == other.prefixPaddingMs &&
                            silenceDurationMs == other.silenceDurationMs &&
                            threshold == other.threshold &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            prefixPaddingMs,
                            silenceDurationMs,
                            threshold,
                            type,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "TurnDetection{prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, type=$type, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Input &&
                        format == other.format &&
                        noiseReduction == other.noiseReduction &&
                        transcription == other.transcription &&
                        turnDetection == other.turnDetection &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        format,
                        noiseReduction,
                        transcription,
                        turnDetection,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Input{format=$format, noiseReduction=$noiseReduction, transcription=$transcription, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Audio &&
                    input == other.input &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(input, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Audio{input=$input, additionalProperties=$additionalProperties}"
        }

        class Include @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField
                val ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS =
                    of("item.input_audio_transcription.logprobs")

                @JvmStatic fun of(value: String) = Include(JsonField.of(value))
            }

            /** An enum containing [Include]'s known values. */
            enum class Known {
                ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
            }

            /**
             * An enum containing [Include]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Include] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS,
                /**
                 * An enum member indicating that [Include] was instantiated with an unknown value.
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
                    ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS ->
                        Value.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
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
                    ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS ->
                        Known.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                    else -> throw OpenAIInvalidDataException("Unknown Include: $value")
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

            fun validate(): Include = apply {
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

                return other is Include && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Session &&
                id == other.id &&
                audio == other.audio &&
                expiresAt == other.expiresAt &&
                include == other.include &&
                object_ == other.object_ &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, audio, expiresAt, include, object_, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Session{id=$id, audio=$audio, expiresAt=$expiresAt, include=$include, object_=$object_, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TranscriptionSessionUpdatedEvent &&
            eventId == other.eventId &&
            session == other.session &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(eventId, session, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionSessionUpdatedEvent{eventId=$eventId, session=$session, type=$type, additionalProperties=$additionalProperties}"
}
