// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Client events for Live. Initialize a primary WebSocket with session.start and wait for
 * session.started. WebRTC creation already starts the session. Audio append is primary
 * WebSocket-only. See the
 * [Live prompting guide](https://developers.openai.com/api/docs/guides/live-prompting) before
 * writing frontend instructions and delegation policies.
 */
@JsonDeserialize(using = ClientEvent.Deserializer::class)
@JsonSerialize(using = ClientEvent.Serializer::class)
class ClientEvent
private constructor(
    private val sessionStart: SessionStartEvent? = null,
    private val sessionUpdate: SessionUpdateEvent? = null,
    private val sessionInputAudioAppend: InputAudioAppendEvent? = null,
    private val sessionInputAudioMute: InputAudioMuteEvent? = null,
    private val sessionInputAudioUnmute: InputAudioUnmuteEvent? = null,
    private val sessionOutputAudioFixturePlay: OutputAudioFixturePlayEvent? = null,
    private val sessionInstructionsAppend: InstructionsAppendEvent? = null,
    private val sessionThinkingAppend: ThinkingAppendEvent? = null,
    private val sessionCommentaryAppend: CommentaryAppendEvent? = null,
    private val decisionCreate: DecisionCreateEvent? = null,
    private val decisionItemCreate: DecisionItemCreateEvent? = null,
    private val decisionItemDelete: DecisionItemDeleteEvent? = null,
    private val responseItemCreate: ResponseItemCreateEvent? = null,
    private val responseCreate: ResponseCreateEvent? = null,
    private val sessionClose: SessionCloseEvent? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Start a Live session on a primary WebSocket. Send this event before other commands and wait
     * for `session.started`.
     */
    fun sessionStart(): Optional<SessionStartEvent> = Optional.ofNullable(sessionStart)

    /**
     * Update the delegation settings or transcript triggers of an active Live session. The server
     * acknowledges accepted changes with `session.updated`.
     */
    fun sessionUpdate(): Optional<SessionUpdateEvent> = Optional.ofNullable(sessionUpdate)

    /**
     * Send audio to a Live session over its primary WebSocket. WebRTC and SIP sessions send audio
     * over their media transport.
     */
    fun sessionInputAudioAppend(): Optional<InputAudioAppendEvent> =
        Optional.ofNullable(sessionInputAudioAppend)

    /**
     * Mute audio input to the Live model without closing the session. The server acknowledges with
     * `session.input_audio.muted`.
     */
    fun sessionInputAudioMute(): Optional<InputAudioMuteEvent> =
        Optional.ofNullable(sessionInputAudioMute)

    /**
     * Resume audio input to a Live model after muting it. The server acknowledges with
     * `session.input_audio.unmuted`. An active audio fixture still pauses inference until playback
     * finishes.
     */
    fun sessionInputAudioUnmute(): Optional<InputAudioUnmuteEvent> =
        Optional.ofNullable(sessionInputAudioUnmute)

    /**
     * Play one complete audio fixture through the session output. Send this event over the primary
     * WebSocket or a server sideband. Audio must be raw mono PCM16 little-endian at 24 kHz,
     * regardless of the session audio format, and at most 30 seconds. The entire payload is
     * validated before model speech is interrupted and input is muted. Only one fixture can be
     * active. fixture.playing acknowledges acceptance and fixture.played reports server mixer
     * drain. These notifications are not exact transport-media boundaries. Input arriving during
     * playback is dropped and not replayed.
     */
    fun sessionOutputAudioFixturePlay(): Optional<OutputAudioFixturePlayEvent> =
        Optional.ofNullable(sessionOutputAudioFixturePlay)

    /**
     * Append developer instructions to the Live conversation while it is running, optionally
     * associating them with an existing client delegation. Rejected while an audio fixture is
     * active. These instructions remain in conversation history through compaction and are included
     * in future backend delegations. For external audio, describe content already delivered so the
     * assistant does not repeat it.
     */
    fun sessionInstructionsAppend(): Optional<InstructionsAppendEvent> =
        Optional.ofNullable(sessionInstructionsAppend)

    /**
     * Provide silent reasoning or progress context to the Live model, optionally for an existing
     * client delegation. Rejected while an audio fixture is active.
     */
    fun sessionThinkingAppend(): Optional<ThinkingAppendEvent> =
        Optional.ofNullable(sessionThinkingAppend)

    /**
     * Provide context the Live model can communicate to the user, optionally for an existing client
     * delegation. Rejected while an audio fixture is active.
     */
    fun sessionCommentaryAppend(): Optional<CommentaryAppendEvent> =
        Optional.ofNullable(sessionCommentaryAppend)

    /**
     * Evaluate the configured questions using the current conversation and Decision inputs. Reusing
     * an event_id is rejected for the lifetime of the session.
     */
    fun decisionCreate(): Optional<DecisionCreateEvent> = Optional.ofNullable(decisionCreate)

    /**
     * Append an input item for future decisions without starting an evaluation or changing Live
     * voice context.
     */
    fun decisionItemCreate(): Optional<DecisionItemCreateEvent> =
        Optional.ofNullable(decisionItemCreate)

    /**
     * Delete an input item from future decisions without starting an evaluation or changing Live
     * voice context.
     */
    fun decisionItemDelete(): Optional<DecisionItemDeleteEvent> =
        Optional.ofNullable(decisionItemDelete)

    /**
     * Add an input item to the Live session’s Responses backend. Requires Responses delegation; use
     * `response.create` to request a response.
     */
    fun responseItemCreate(): Optional<ResponseItemCreateEvent> =
        Optional.ofNullable(responseItemCreate)

    /**
     * Request a response from the Live session’s Responses backend, or continue a delegated
     * response waiting for tool results. Requires Responses delegation.
     */
    fun responseCreate(): Optional<ResponseCreateEvent> = Optional.ofNullable(responseCreate)

    /**
     * Request that the Live session close. The terminal `session.closed` event contains the close
     * reason and final usage.
     */
    fun sessionClose(): Optional<SessionCloseEvent> = Optional.ofNullable(sessionClose)

    fun isSessionStart(): Boolean = sessionStart != null

    fun isSessionUpdate(): Boolean = sessionUpdate != null

    fun isSessionInputAudioAppend(): Boolean = sessionInputAudioAppend != null

    fun isSessionInputAudioMute(): Boolean = sessionInputAudioMute != null

    fun isSessionInputAudioUnmute(): Boolean = sessionInputAudioUnmute != null

    fun isSessionOutputAudioFixturePlay(): Boolean = sessionOutputAudioFixturePlay != null

    fun isSessionInstructionsAppend(): Boolean = sessionInstructionsAppend != null

    fun isSessionThinkingAppend(): Boolean = sessionThinkingAppend != null

    fun isSessionCommentaryAppend(): Boolean = sessionCommentaryAppend != null

    fun isDecisionCreate(): Boolean = decisionCreate != null

    fun isDecisionItemCreate(): Boolean = decisionItemCreate != null

    fun isDecisionItemDelete(): Boolean = decisionItemDelete != null

    fun isResponseItemCreate(): Boolean = responseItemCreate != null

    fun isResponseCreate(): Boolean = responseCreate != null

    fun isSessionClose(): Boolean = sessionClose != null

    /**
     * Start a Live session on a primary WebSocket. Send this event before other commands and wait
     * for `session.started`.
     */
    fun asSessionStart(): SessionStartEvent = sessionStart.getOrThrow("sessionStart")

    /**
     * Update the delegation settings or transcript triggers of an active Live session. The server
     * acknowledges accepted changes with `session.updated`.
     */
    fun asSessionUpdate(): SessionUpdateEvent = sessionUpdate.getOrThrow("sessionUpdate")

    /**
     * Send audio to a Live session over its primary WebSocket. WebRTC and SIP sessions send audio
     * over their media transport.
     */
    fun asSessionInputAudioAppend(): InputAudioAppendEvent =
        sessionInputAudioAppend.getOrThrow("sessionInputAudioAppend")

    /**
     * Mute audio input to the Live model without closing the session. The server acknowledges with
     * `session.input_audio.muted`.
     */
    fun asSessionInputAudioMute(): InputAudioMuteEvent =
        sessionInputAudioMute.getOrThrow("sessionInputAudioMute")

    /**
     * Resume audio input to a Live model after muting it. The server acknowledges with
     * `session.input_audio.unmuted`. An active audio fixture still pauses inference until playback
     * finishes.
     */
    fun asSessionInputAudioUnmute(): InputAudioUnmuteEvent =
        sessionInputAudioUnmute.getOrThrow("sessionInputAudioUnmute")

    /**
     * Play one complete audio fixture through the session output. Send this event over the primary
     * WebSocket or a server sideband. Audio must be raw mono PCM16 little-endian at 24 kHz,
     * regardless of the session audio format, and at most 30 seconds. The entire payload is
     * validated before model speech is interrupted and input is muted. Only one fixture can be
     * active. fixture.playing acknowledges acceptance and fixture.played reports server mixer
     * drain. These notifications are not exact transport-media boundaries. Input arriving during
     * playback is dropped and not replayed.
     */
    fun asSessionOutputAudioFixturePlay(): OutputAudioFixturePlayEvent =
        sessionOutputAudioFixturePlay.getOrThrow("sessionOutputAudioFixturePlay")

    /**
     * Append developer instructions to the Live conversation while it is running, optionally
     * associating them with an existing client delegation. Rejected while an audio fixture is
     * active. These instructions remain in conversation history through compaction and are included
     * in future backend delegations. For external audio, describe content already delivered so the
     * assistant does not repeat it.
     */
    fun asSessionInstructionsAppend(): InstructionsAppendEvent =
        sessionInstructionsAppend.getOrThrow("sessionInstructionsAppend")

    /**
     * Provide silent reasoning or progress context to the Live model, optionally for an existing
     * client delegation. Rejected while an audio fixture is active.
     */
    fun asSessionThinkingAppend(): ThinkingAppendEvent =
        sessionThinkingAppend.getOrThrow("sessionThinkingAppend")

    /**
     * Provide context the Live model can communicate to the user, optionally for an existing client
     * delegation. Rejected while an audio fixture is active.
     */
    fun asSessionCommentaryAppend(): CommentaryAppendEvent =
        sessionCommentaryAppend.getOrThrow("sessionCommentaryAppend")

    /**
     * Evaluate the configured questions using the current conversation and Decision inputs. Reusing
     * an event_id is rejected for the lifetime of the session.
     */
    fun asDecisionCreate(): DecisionCreateEvent = decisionCreate.getOrThrow("decisionCreate")

    /**
     * Append an input item for future decisions without starting an evaluation or changing Live
     * voice context.
     */
    fun asDecisionItemCreate(): DecisionItemCreateEvent =
        decisionItemCreate.getOrThrow("decisionItemCreate")

    /**
     * Delete an input item from future decisions without starting an evaluation or changing Live
     * voice context.
     */
    fun asDecisionItemDelete(): DecisionItemDeleteEvent =
        decisionItemDelete.getOrThrow("decisionItemDelete")

    /**
     * Add an input item to the Live session’s Responses backend. Requires Responses delegation; use
     * `response.create` to request a response.
     */
    fun asResponseItemCreate(): ResponseItemCreateEvent =
        responseItemCreate.getOrThrow("responseItemCreate")

    /**
     * Request a response from the Live session’s Responses backend, or continue a delegated
     * response waiting for tool results. Requires Responses delegation.
     */
    fun asResponseCreate(): ResponseCreateEvent = responseCreate.getOrThrow("responseCreate")

    /**
     * Request that the Live session close. The terminal `session.closed` event contains the close
     * reason and final usage.
     */
    fun asSessionClose(): SessionCloseEvent = sessionClose.getOrThrow("sessionClose")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = clientEvent.accept(new ClientEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitSessionStart(SessionStartEvent sessionStart) {
     *         return Optional.of(sessionStart.toString());
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
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            sessionStart != null -> visitor.visitSessionStart(sessionStart)
            sessionUpdate != null -> visitor.visitSessionUpdate(sessionUpdate)
            sessionInputAudioAppend != null ->
                visitor.visitSessionInputAudioAppend(sessionInputAudioAppend)
            sessionInputAudioMute != null ->
                visitor.visitSessionInputAudioMute(sessionInputAudioMute)
            sessionInputAudioUnmute != null ->
                visitor.visitSessionInputAudioUnmute(sessionInputAudioUnmute)
            sessionOutputAudioFixturePlay != null ->
                visitor.visitSessionOutputAudioFixturePlay(sessionOutputAudioFixturePlay)
            sessionInstructionsAppend != null ->
                visitor.visitSessionInstructionsAppend(sessionInstructionsAppend)
            sessionThinkingAppend != null ->
                visitor.visitSessionThinkingAppend(sessionThinkingAppend)
            sessionCommentaryAppend != null ->
                visitor.visitSessionCommentaryAppend(sessionCommentaryAppend)
            decisionCreate != null -> visitor.visitDecisionCreate(decisionCreate)
            decisionItemCreate != null -> visitor.visitDecisionItemCreate(decisionItemCreate)
            decisionItemDelete != null -> visitor.visitDecisionItemDelete(decisionItemDelete)
            responseItemCreate != null -> visitor.visitResponseItemCreate(responseItemCreate)
            responseCreate != null -> visitor.visitResponseCreate(responseCreate)
            sessionClose != null -> visitor.visitSessionClose(sessionClose)
            else -> visitor.unknown(_json)
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
    fun validate(): ClientEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitSessionStart(sessionStart: SessionStartEvent) {
                    sessionStart.validate()
                }

                override fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent) {
                    sessionUpdate.validate()
                }

                override fun visitSessionInputAudioAppend(
                    sessionInputAudioAppend: InputAudioAppendEvent
                ) {
                    sessionInputAudioAppend.validate()
                }

                override fun visitSessionInputAudioMute(
                    sessionInputAudioMute: InputAudioMuteEvent
                ) {
                    sessionInputAudioMute.validate()
                }

                override fun visitSessionInputAudioUnmute(
                    sessionInputAudioUnmute: InputAudioUnmuteEvent
                ) {
                    sessionInputAudioUnmute.validate()
                }

                override fun visitSessionOutputAudioFixturePlay(
                    sessionOutputAudioFixturePlay: OutputAudioFixturePlayEvent
                ) {
                    sessionOutputAudioFixturePlay.validate()
                }

                override fun visitSessionInstructionsAppend(
                    sessionInstructionsAppend: InstructionsAppendEvent
                ) {
                    sessionInstructionsAppend.validate()
                }

                override fun visitSessionThinkingAppend(
                    sessionThinkingAppend: ThinkingAppendEvent
                ) {
                    sessionThinkingAppend.validate()
                }

                override fun visitSessionCommentaryAppend(
                    sessionCommentaryAppend: CommentaryAppendEvent
                ) {
                    sessionCommentaryAppend.validate()
                }

                override fun visitDecisionCreate(decisionCreate: DecisionCreateEvent) {
                    decisionCreate.validate()
                }

                override fun visitDecisionItemCreate(decisionItemCreate: DecisionItemCreateEvent) {
                    decisionItemCreate.validate()
                }

                override fun visitDecisionItemDelete(decisionItemDelete: DecisionItemDeleteEvent) {
                    decisionItemDelete.validate()
                }

                override fun visitResponseItemCreate(responseItemCreate: ResponseItemCreateEvent) {
                    responseItemCreate.validate()
                }

                override fun visitResponseCreate(responseCreate: ResponseCreateEvent) {
                    responseCreate.validate()
                }

                override fun visitSessionClose(sessionClose: SessionCloseEvent) {
                    sessionClose.validate()
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
                override fun visitSessionStart(sessionStart: SessionStartEvent) =
                    sessionStart.validity()

                override fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent) =
                    sessionUpdate.validity()

                override fun visitSessionInputAudioAppend(
                    sessionInputAudioAppend: InputAudioAppendEvent
                ) = sessionInputAudioAppend.validity()

                override fun visitSessionInputAudioMute(
                    sessionInputAudioMute: InputAudioMuteEvent
                ) = sessionInputAudioMute.validity()

                override fun visitSessionInputAudioUnmute(
                    sessionInputAudioUnmute: InputAudioUnmuteEvent
                ) = sessionInputAudioUnmute.validity()

                override fun visitSessionOutputAudioFixturePlay(
                    sessionOutputAudioFixturePlay: OutputAudioFixturePlayEvent
                ) = sessionOutputAudioFixturePlay.validity()

                override fun visitSessionInstructionsAppend(
                    sessionInstructionsAppend: InstructionsAppendEvent
                ) = sessionInstructionsAppend.validity()

                override fun visitSessionThinkingAppend(
                    sessionThinkingAppend: ThinkingAppendEvent
                ) = sessionThinkingAppend.validity()

                override fun visitSessionCommentaryAppend(
                    sessionCommentaryAppend: CommentaryAppendEvent
                ) = sessionCommentaryAppend.validity()

                override fun visitDecisionCreate(decisionCreate: DecisionCreateEvent) =
                    decisionCreate.validity()

                override fun visitDecisionItemCreate(decisionItemCreate: DecisionItemCreateEvent) =
                    decisionItemCreate.validity()

                override fun visitDecisionItemDelete(decisionItemDelete: DecisionItemDeleteEvent) =
                    decisionItemDelete.validity()

                override fun visitResponseItemCreate(responseItemCreate: ResponseItemCreateEvent) =
                    responseItemCreate.validity()

                override fun visitResponseCreate(responseCreate: ResponseCreateEvent) =
                    responseCreate.validity()

                override fun visitSessionClose(sessionClose: SessionCloseEvent) =
                    sessionClose.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ClientEvent &&
            sessionStart == other.sessionStart &&
            sessionUpdate == other.sessionUpdate &&
            sessionInputAudioAppend == other.sessionInputAudioAppend &&
            sessionInputAudioMute == other.sessionInputAudioMute &&
            sessionInputAudioUnmute == other.sessionInputAudioUnmute &&
            sessionOutputAudioFixturePlay == other.sessionOutputAudioFixturePlay &&
            sessionInstructionsAppend == other.sessionInstructionsAppend &&
            sessionThinkingAppend == other.sessionThinkingAppend &&
            sessionCommentaryAppend == other.sessionCommentaryAppend &&
            decisionCreate == other.decisionCreate &&
            decisionItemCreate == other.decisionItemCreate &&
            decisionItemDelete == other.decisionItemDelete &&
            responseItemCreate == other.responseItemCreate &&
            responseCreate == other.responseCreate &&
            sessionClose == other.sessionClose &&
            (sessionStart != null ||
                sessionUpdate != null ||
                sessionInputAudioAppend != null ||
                sessionInputAudioMute != null ||
                sessionInputAudioUnmute != null ||
                sessionOutputAudioFixturePlay != null ||
                sessionInstructionsAppend != null ||
                sessionThinkingAppend != null ||
                sessionCommentaryAppend != null ||
                decisionCreate != null ||
                decisionItemCreate != null ||
                decisionItemDelete != null ||
                responseItemCreate != null ||
                responseCreate != null ||
                sessionClose != null ||
                _json == other._json)
    }

    override fun hashCode(): Int =
        if (
            sessionStart == null &&
                sessionUpdate == null &&
                sessionInputAudioAppend == null &&
                sessionInputAudioMute == null &&
                sessionInputAudioUnmute == null &&
                sessionOutputAudioFixturePlay == null &&
                sessionInstructionsAppend == null &&
                sessionThinkingAppend == null &&
                sessionCommentaryAppend == null &&
                decisionCreate == null &&
                decisionItemCreate == null &&
                decisionItemDelete == null &&
                responseItemCreate == null &&
                responseCreate == null &&
                sessionClose == null
        )
            Objects.hash(_json)
        else
            Objects.hash(
                sessionStart,
                sessionUpdate,
                sessionInputAudioAppend,
                sessionInputAudioMute,
                sessionInputAudioUnmute,
                sessionOutputAudioFixturePlay,
                sessionInstructionsAppend,
                sessionThinkingAppend,
                sessionCommentaryAppend,
                decisionCreate,
                decisionItemCreate,
                decisionItemDelete,
                responseItemCreate,
                responseCreate,
                sessionClose,
            )

    override fun toString(): String =
        when {
            sessionStart != null -> "ClientEvent{sessionStart=$sessionStart}"
            sessionUpdate != null -> "ClientEvent{sessionUpdate=$sessionUpdate}"
            sessionInputAudioAppend != null ->
                "ClientEvent{sessionInputAudioAppend=$sessionInputAudioAppend}"
            sessionInputAudioMute != null ->
                "ClientEvent{sessionInputAudioMute=$sessionInputAudioMute}"
            sessionInputAudioUnmute != null ->
                "ClientEvent{sessionInputAudioUnmute=$sessionInputAudioUnmute}"
            sessionOutputAudioFixturePlay != null ->
                "ClientEvent{sessionOutputAudioFixturePlay=$sessionOutputAudioFixturePlay}"
            sessionInstructionsAppend != null ->
                "ClientEvent{sessionInstructionsAppend=$sessionInstructionsAppend}"
            sessionThinkingAppend != null ->
                "ClientEvent{sessionThinkingAppend=$sessionThinkingAppend}"
            sessionCommentaryAppend != null ->
                "ClientEvent{sessionCommentaryAppend=$sessionCommentaryAppend}"
            decisionCreate != null -> "ClientEvent{decisionCreate=$decisionCreate}"
            decisionItemCreate != null -> "ClientEvent{decisionItemCreate=$decisionItemCreate}"
            decisionItemDelete != null -> "ClientEvent{decisionItemDelete=$decisionItemDelete}"
            responseItemCreate != null -> "ClientEvent{responseItemCreate=$responseItemCreate}"
            responseCreate != null -> "ClientEvent{responseCreate=$responseCreate}"
            sessionClose != null -> "ClientEvent{sessionClose=$sessionClose}"
            _json != null -> "ClientEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ClientEvent")
        }

    companion object {

        /**
         * Start a Live session on a primary WebSocket. Send this event before other commands and
         * wait for `session.started`.
         */
        @JvmStatic
        fun ofSessionStart(sessionStart: SessionStartEvent) =
            ClientEvent(sessionStart = sessionStart)

        /**
         * Update the delegation settings or transcript triggers of an active Live session. The
         * server acknowledges accepted changes with `session.updated`.
         */
        @JvmStatic
        fun ofSessionUpdate(sessionUpdate: SessionUpdateEvent) =
            ClientEvent(sessionUpdate = sessionUpdate)

        /**
         * Send audio to a Live session over its primary WebSocket. WebRTC and SIP sessions send
         * audio over their media transport.
         */
        @JvmStatic
        fun ofSessionInputAudioAppend(sessionInputAudioAppend: InputAudioAppendEvent) =
            ClientEvent(sessionInputAudioAppend = sessionInputAudioAppend)

        /**
         * Mute audio input to the Live model without closing the session. The server acknowledges
         * with `session.input_audio.muted`.
         */
        @JvmStatic
        fun ofSessionInputAudioMute(sessionInputAudioMute: InputAudioMuteEvent) =
            ClientEvent(sessionInputAudioMute = sessionInputAudioMute)

        /**
         * Resume audio input to a Live model after muting it. The server acknowledges with
         * `session.input_audio.unmuted`. An active audio fixture still pauses inference until
         * playback finishes.
         */
        @JvmStatic
        fun ofSessionInputAudioUnmute(sessionInputAudioUnmute: InputAudioUnmuteEvent) =
            ClientEvent(sessionInputAudioUnmute = sessionInputAudioUnmute)

        /**
         * Play one complete audio fixture through the session output. Send this event over the
         * primary WebSocket or a server sideband. Audio must be raw mono PCM16 little-endian at 24
         * kHz, regardless of the session audio format, and at most 30 seconds. The entire payload
         * is validated before model speech is interrupted and input is muted. Only one fixture can
         * be active. fixture.playing acknowledges acceptance and fixture.played reports server
         * mixer drain. These notifications are not exact transport-media boundaries. Input arriving
         * during playback is dropped and not replayed.
         */
        @JvmStatic
        fun ofSessionOutputAudioFixturePlay(
            sessionOutputAudioFixturePlay: OutputAudioFixturePlayEvent
        ) = ClientEvent(sessionOutputAudioFixturePlay = sessionOutputAudioFixturePlay)

        /**
         * Append developer instructions to the Live conversation while it is running, optionally
         * associating them with an existing client delegation. Rejected while an audio fixture is
         * active. These instructions remain in conversation history through compaction and are
         * included in future backend delegations. For external audio, describe content already
         * delivered so the assistant does not repeat it.
         */
        @JvmStatic
        fun ofSessionInstructionsAppend(sessionInstructionsAppend: InstructionsAppendEvent) =
            ClientEvent(sessionInstructionsAppend = sessionInstructionsAppend)

        /**
         * Provide silent reasoning or progress context to the Live model, optionally for an
         * existing client delegation. Rejected while an audio fixture is active.
         */
        @JvmStatic
        fun ofSessionThinkingAppend(sessionThinkingAppend: ThinkingAppendEvent) =
            ClientEvent(sessionThinkingAppend = sessionThinkingAppend)

        /**
         * Provide context the Live model can communicate to the user, optionally for an existing
         * client delegation. Rejected while an audio fixture is active.
         */
        @JvmStatic
        fun ofSessionCommentaryAppend(sessionCommentaryAppend: CommentaryAppendEvent) =
            ClientEvent(sessionCommentaryAppend = sessionCommentaryAppend)

        /**
         * Evaluate the configured questions using the current conversation and Decision inputs.
         * Reusing an event_id is rejected for the lifetime of the session.
         */
        @JvmStatic
        fun ofDecisionCreate(decisionCreate: DecisionCreateEvent) =
            ClientEvent(decisionCreate = decisionCreate)

        /**
         * Append an input item for future decisions without starting an evaluation or changing Live
         * voice context.
         */
        @JvmStatic
        fun ofDecisionItemCreate(decisionItemCreate: DecisionItemCreateEvent) =
            ClientEvent(decisionItemCreate = decisionItemCreate)

        /**
         * Delete an input item from future decisions without starting an evaluation or changing
         * Live voice context.
         */
        @JvmStatic
        fun ofDecisionItemDelete(decisionItemDelete: DecisionItemDeleteEvent) =
            ClientEvent(decisionItemDelete = decisionItemDelete)

        /**
         * Add an input item to the Live session’s Responses backend. Requires Responses delegation;
         * use `response.create` to request a response.
         */
        @JvmStatic
        fun ofResponseItemCreate(responseItemCreate: ResponseItemCreateEvent) =
            ClientEvent(responseItemCreate = responseItemCreate)

        /**
         * Request a response from the Live session’s Responses backend, or continue a delegated
         * response waiting for tool results. Requires Responses delegation.
         */
        @JvmStatic
        fun ofResponseCreate(responseCreate: ResponseCreateEvent) =
            ClientEvent(responseCreate = responseCreate)

        /**
         * Request that the Live session close. The terminal `session.closed` event contains the
         * close reason and final usage.
         */
        @JvmStatic
        fun ofSessionClose(sessionClose: SessionCloseEvent) =
            ClientEvent(sessionClose = sessionClose)
    }

    /**
     * An interface that defines how to map each variant of [ClientEvent] to a value of type [T].
     */
    interface Visitor<out T> {

        /**
         * Start a Live session on a primary WebSocket. Send this event before other commands and
         * wait for `session.started`.
         */
        fun visitSessionStart(sessionStart: SessionStartEvent): T =
            unknown(JsonValue.from(sessionStart))

        /**
         * Update the delegation settings or transcript triggers of an active Live session. The
         * server acknowledges accepted changes with `session.updated`.
         */
        fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent): T =
            unknown(JsonValue.from(sessionUpdate))

        /**
         * Send audio to a Live session over its primary WebSocket. WebRTC and SIP sessions send
         * audio over their media transport.
         */
        fun visitSessionInputAudioAppend(sessionInputAudioAppend: InputAudioAppendEvent): T =
            unknown(JsonValue.from(sessionInputAudioAppend))

        /**
         * Mute audio input to the Live model without closing the session. The server acknowledges
         * with `session.input_audio.muted`.
         */
        fun visitSessionInputAudioMute(sessionInputAudioMute: InputAudioMuteEvent): T =
            unknown(JsonValue.from(sessionInputAudioMute))

        /**
         * Resume audio input to a Live model after muting it. The server acknowledges with
         * `session.input_audio.unmuted`. An active audio fixture still pauses inference until
         * playback finishes.
         */
        fun visitSessionInputAudioUnmute(sessionInputAudioUnmute: InputAudioUnmuteEvent): T =
            unknown(JsonValue.from(sessionInputAudioUnmute))

        /**
         * Play one complete audio fixture through the session output. Send this event over the
         * primary WebSocket or a server sideband. Audio must be raw mono PCM16 little-endian at 24
         * kHz, regardless of the session audio format, and at most 30 seconds. The entire payload
         * is validated before model speech is interrupted and input is muted. Only one fixture can
         * be active. fixture.playing acknowledges acceptance and fixture.played reports server
         * mixer drain. These notifications are not exact transport-media boundaries. Input arriving
         * during playback is dropped and not replayed.
         */
        fun visitSessionOutputAudioFixturePlay(
            sessionOutputAudioFixturePlay: OutputAudioFixturePlayEvent
        ): T = unknown(JsonValue.from(sessionOutputAudioFixturePlay))

        /**
         * Append developer instructions to the Live conversation while it is running, optionally
         * associating them with an existing client delegation. Rejected while an audio fixture is
         * active. These instructions remain in conversation history through compaction and are
         * included in future backend delegations. For external audio, describe content already
         * delivered so the assistant does not repeat it.
         */
        fun visitSessionInstructionsAppend(sessionInstructionsAppend: InstructionsAppendEvent): T =
            unknown(JsonValue.from(sessionInstructionsAppend))

        /**
         * Provide silent reasoning or progress context to the Live model, optionally for an
         * existing client delegation. Rejected while an audio fixture is active.
         */
        fun visitSessionThinkingAppend(sessionThinkingAppend: ThinkingAppendEvent): T =
            unknown(JsonValue.from(sessionThinkingAppend))

        /**
         * Provide context the Live model can communicate to the user, optionally for an existing
         * client delegation. Rejected while an audio fixture is active.
         */
        fun visitSessionCommentaryAppend(sessionCommentaryAppend: CommentaryAppendEvent): T =
            unknown(JsonValue.from(sessionCommentaryAppend))

        /**
         * Evaluate the configured questions using the current conversation and Decision inputs.
         * Reusing an event_id is rejected for the lifetime of the session.
         */
        fun visitDecisionCreate(decisionCreate: DecisionCreateEvent): T =
            unknown(JsonValue.from(decisionCreate))

        /**
         * Append an input item for future decisions without starting an evaluation or changing Live
         * voice context.
         */
        fun visitDecisionItemCreate(decisionItemCreate: DecisionItemCreateEvent): T =
            unknown(JsonValue.from(decisionItemCreate))

        /**
         * Delete an input item from future decisions without starting an evaluation or changing
         * Live voice context.
         */
        fun visitDecisionItemDelete(decisionItemDelete: DecisionItemDeleteEvent): T =
            unknown(JsonValue.from(decisionItemDelete))

        /**
         * Add an input item to the Live session’s Responses backend. Requires Responses delegation;
         * use `response.create` to request a response.
         */
        fun visitResponseItemCreate(responseItemCreate: ResponseItemCreateEvent): T =
            unknown(JsonValue.from(responseItemCreate))

        /**
         * Request a response from the Live session’s Responses backend, or continue a delegated
         * response waiting for tool results. Requires Responses delegation.
         */
        fun visitResponseCreate(responseCreate: ResponseCreateEvent): T =
            unknown(JsonValue.from(responseCreate))

        /**
         * Request that the Live session close. The terminal `session.closed` event contains the
         * close reason and final usage.
         */
        fun visitSessionClose(sessionClose: SessionCloseEvent): T =
            unknown(JsonValue.from(sessionClose))

        /**
         * Maps an unknown variant of [ClientEvent] to a value of type [T].
         *
         * An instance of [ClientEvent] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * Recognized variants also reach this method when their visit method is not overridden.
         * This allows existing visitors to handle variants added by newer SDK versions.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ClientEvent")
        }
    }

    internal class Deserializer : BaseDeserializer<ClientEvent>(ClientEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ClientEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "session.start" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionStartEvent>())?.let {
                        ClientEvent(sessionStart = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "session.update" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionUpdateEvent>())?.let {
                        ClientEvent(sessionUpdate = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "session.input_audio.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioAppendEvent>())?.let {
                        ClientEvent(sessionInputAudioAppend = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "session.input_audio.mute" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioMuteEvent>())?.let {
                        ClientEvent(sessionInputAudioMute = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "session.input_audio.unmute" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioUnmuteEvent>())?.let {
                        ClientEvent(sessionInputAudioUnmute = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "session.output_audio.fixture.play" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioFixturePlayEvent>())
                        ?.let { ClientEvent(sessionOutputAudioFixturePlay = it, _json = json) }
                        ?: ClientEvent(_json = json)
                }
                "session.instructions.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<InstructionsAppendEvent>())?.let {
                        ClientEvent(sessionInstructionsAppend = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "session.thinking.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThinkingAppendEvent>())?.let {
                        ClientEvent(sessionThinkingAppend = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "session.commentary.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<CommentaryAppendEvent>())?.let {
                        ClientEvent(sessionCommentaryAppend = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "decision.create" -> {
                    return tryDeserialize(node, jacksonTypeRef<DecisionCreateEvent>())?.let {
                        ClientEvent(decisionCreate = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "decision.item.create" -> {
                    return tryDeserialize(node, jacksonTypeRef<DecisionItemCreateEvent>())?.let {
                        ClientEvent(decisionItemCreate = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "decision.item.delete" -> {
                    return tryDeserialize(node, jacksonTypeRef<DecisionItemDeleteEvent>())?.let {
                        ClientEvent(decisionItemDelete = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "response.item.create" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseItemCreateEvent>())?.let {
                        ClientEvent(responseItemCreate = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "response.create" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCreateEvent>())?.let {
                        ClientEvent(responseCreate = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
                "session.close" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionCloseEvent>())?.let {
                        ClientEvent(sessionClose = it, _json = json)
                    } ?: ClientEvent(_json = json)
                }
            }

            return ClientEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ClientEvent>(ClientEvent::class) {

        override fun serialize(
            value: ClientEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.sessionStart != null -> generator.writeObject(value.sessionStart)
                value.sessionUpdate != null -> generator.writeObject(value.sessionUpdate)
                value.sessionInputAudioAppend != null ->
                    generator.writeObject(value.sessionInputAudioAppend)
                value.sessionInputAudioMute != null ->
                    generator.writeObject(value.sessionInputAudioMute)
                value.sessionInputAudioUnmute != null ->
                    generator.writeObject(value.sessionInputAudioUnmute)
                value.sessionOutputAudioFixturePlay != null ->
                    generator.writeObject(value.sessionOutputAudioFixturePlay)
                value.sessionInstructionsAppend != null ->
                    generator.writeObject(value.sessionInstructionsAppend)
                value.sessionThinkingAppend != null ->
                    generator.writeObject(value.sessionThinkingAppend)
                value.sessionCommentaryAppend != null ->
                    generator.writeObject(value.sessionCommentaryAppend)
                value.decisionCreate != null -> generator.writeObject(value.decisionCreate)
                value.decisionItemCreate != null -> generator.writeObject(value.decisionItemCreate)
                value.decisionItemDelete != null -> generator.writeObject(value.decisionItemDelete)
                value.responseItemCreate != null -> generator.writeObject(value.responseItemCreate)
                value.responseCreate != null -> generator.writeObject(value.responseCreate)
                value.sessionClose != null -> generator.writeObject(value.sessionClose)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ClientEvent")
            }
        }
    }
}
