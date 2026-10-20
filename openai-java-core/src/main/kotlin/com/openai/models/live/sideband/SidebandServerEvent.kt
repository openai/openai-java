// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sideband

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
import com.openai.models.live.CommentaryAppendedEvent
import com.openai.models.live.DelegationCreatedEvent
import com.openai.models.live.ErrorEvent
import com.openai.models.live.InfoEvent
import com.openai.models.live.InputAudioMutedEvent
import com.openai.models.live.InputAudioUnmutedEvent
import com.openai.models.live.InputTranscriptDeltaEvent
import com.openai.models.live.InstructionsAppendedEvent
import com.openai.models.live.OutputAudioFixturePlayedEvent
import com.openai.models.live.OutputAudioFixturePlayingEvent
import com.openai.models.live.OutputTranscriptDeltaEvent
import com.openai.models.live.ResponseEvent
import com.openai.models.live.SessionClosedEvent
import com.openai.models.live.SessionStartedEvent
import com.openai.models.live.SessionUpdatedEvent
import com.openai.models.live.SessionUsageUpdatedEvent
import com.openai.models.live.ThinkingAppendedEvent
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Server events received by an attached Live sideband WebSocket. Audio deltas are delivered over
 * the primary connection.
 */
@JsonDeserialize(using = SidebandServerEvent.Deserializer::class)
@JsonSerialize(using = SidebandServerEvent.Serializer::class)
class SidebandServerEvent
private constructor(
    private val sessionStarted: SessionStartedEvent? = null,
    private val sessionUpdated: SessionUpdatedEvent? = null,
    private val sessionInputAudioMuted: InputAudioMutedEvent? = null,
    private val sessionInputAudioUnmuted: InputAudioUnmutedEvent? = null,
    private val sessionOutputAudioFixturePlaying: OutputAudioFixturePlayingEvent? = null,
    private val sessionOutputAudioFixturePlayed: OutputAudioFixturePlayedEvent? = null,
    private val sessionInstructionsAppended: InstructionsAppendedEvent? = null,
    private val sessionThinkingAppended: ThinkingAppendedEvent? = null,
    private val sessionCommentaryAppended: CommentaryAppendedEvent? = null,
    private val sessionInputTranscriptDelta: InputTranscriptDeltaEvent? = null,
    private val sessionOutputTranscriptDelta: OutputTranscriptDeltaEvent? = null,
    private val sessionDelegationCreated: DelegationCreatedEvent? = null,
    private val responseEvent: ResponseEvent? = null,
    private val sessionUsageUpdated: SessionUsageUpdatedEvent? = null,
    private val sessionClosed: SessionClosedEvent? = null,
    private val errorEvent: ErrorEvent? = null,
    private val infoEvent: InfoEvent? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Returned when a Live session has started. Contains the resolved session configuration,
     * including server defaults.
     */
    fun sessionStarted(): Optional<SessionStartedEvent> = Optional.ofNullable(sessionStarted)

    /**
     * Returned when a Live session update is accepted. Contains the resolved session configuration
     * after the update.
     */
    fun sessionUpdated(): Optional<SessionUpdatedEvent> = Optional.ofNullable(sessionUpdated)

    /**
     * Returned when a session.input_audio.mute command is accepted. Input audio is no longer sent
     * to the model; sideband audio reflection continues.
     */
    fun sessionInputAudioMuted(): Optional<InputAudioMutedEvent> =
        Optional.ofNullable(sessionInputAudioMuted)

    /**
     * Returned when a session.input_audio.unmute command is accepted. Input audio is sent to the
     * model again.
     */
    fun sessionInputAudioUnmuted(): Optional<InputAudioUnmutedEvent> =
        Optional.ofNullable(sessionInputAudioUnmuted)

    /**
     * The existing playback path has accepted the validated audio fixture. This acknowledgment does
     * not identify when the listener receives the first sample. The optional client_event_id echoes
     * the play command.
     */
    fun sessionOutputAudioFixturePlaying(): Optional<OutputAudioFixturePlayingEvent> =
        Optional.ofNullable(sessionOutputAudioFixturePlaying)

    /**
     * The complete audio fixture has drained from the server mixer and normal inference has
     * resumed. Transport buffers may still contain audio; this event does not prove listener-side
     * completion. The optional client_event_id echoes the play command. This event is not emitted
     * for canceled or failed playback.
     */
    fun sessionOutputAudioFixturePlayed(): Optional<OutputAudioFixturePlayedEvent> =
        Optional.ofNullable(sessionOutputAudioFixturePlayed)

    /**
     * Returned when a session.instructions.append command is accepted into the Live session
     * timeline. Acknowledges the appended instructions without guaranteeing that the model has
     * acted on them.
     */
    fun sessionInstructionsAppended(): Optional<InstructionsAppendedEvent> =
        Optional.ofNullable(sessionInstructionsAppended)

    /**
     * Returned when a session.thinking.append command is accepted into the Live session timeline.
     * Acknowledges the added reasoning context without guaranteeing any spoken output.
     */
    fun sessionThinkingAppended(): Optional<ThinkingAppendedEvent> =
        Optional.ofNullable(sessionThinkingAppended)

    /**
     * Returned when a session.commentary.append command is accepted into the Live session timeline.
     * Acknowledges the added commentary without guaranteeing exact wording or completed audio
     * playback.
     */
    fun sessionCommentaryAppended(): Optional<CommentaryAppendedEvent> =
        Optional.ofNullable(sessionCommentaryAppended)

    /**
     * A transcript fragment for user input audio in the Live session. Accumulate fragments in
     * delivery order; these events do not define complete turns or include a transcript-done event.
     */
    fun sessionInputTranscriptDelta(): Optional<InputTranscriptDeltaEvent> =
        Optional.ofNullable(sessionInputTranscriptDelta)

    /**
     * A transcript fragment for assistant output audio in the Live session. Accumulate fragments in
     * delivery order; these events do not define complete turns or include a transcript-done event.
     */
    fun sessionOutputTranscriptDelta(): Optional<OutputTranscriptDeltaEvent> =
        Optional.ofNullable(sessionOutputTranscriptDelta)

    /**
     * Returned when the Live model delegates work to your application or a Responses backend.
     * Contains delegation metadata and the position on the session timeline where the work was
     * delegated.
     */
    fun sessionDelegationCreated(): Optional<DelegationCreatedEvent> =
        Optional.ofNullable(sessionDelegationCreated)

    /**
     * A streaming Responses API event from a backend delegated to by the Live session. Use the
     * outer delegation_id to associate the nested stream with its Live delegation.
     */
    fun responseEvent(): Optional<ResponseEvent> = Optional.ofNullable(responseEvent)

    /**
     * Reports cumulative Live audio usage and, when available, the most recent context-window
     * usage. Delegated Responses token usage is reported separately in response.event events.
     */
    fun sessionUsageUpdated(): Optional<SessionUsageUpdatedEvent> =
        Optional.ofNullable(sessionUsageUpdated)

    /**
     * Returned after the Live session finishes finalizing, with the close reason, final session
     * snapshot, and cumulative audio usage. A connection closing without this event does not
     * confirm successful finalization.
     */
    fun sessionClosed(): Optional<SessionClosedEvent> = Optional.ofNullable(sessionClosed)

    /**
     * Reports an error in the Live session, such as an invalid client command. Use
     * error.client_event_id, when present, to identify the command that caused the error.
     */
    fun errorEvent(): Optional<ErrorEvent> = Optional.ofNullable(errorEvent)

    /**
     * An informational notice about the Live session, such as the event permissions applied to a
     * frontend data channel.
     */
    fun infoEvent(): Optional<InfoEvent> = Optional.ofNullable(infoEvent)

    fun isSessionStarted(): Boolean = sessionStarted != null

    fun isSessionUpdated(): Boolean = sessionUpdated != null

    fun isSessionInputAudioMuted(): Boolean = sessionInputAudioMuted != null

    fun isSessionInputAudioUnmuted(): Boolean = sessionInputAudioUnmuted != null

    fun isSessionOutputAudioFixturePlaying(): Boolean = sessionOutputAudioFixturePlaying != null

    fun isSessionOutputAudioFixturePlayed(): Boolean = sessionOutputAudioFixturePlayed != null

    fun isSessionInstructionsAppended(): Boolean = sessionInstructionsAppended != null

    fun isSessionThinkingAppended(): Boolean = sessionThinkingAppended != null

    fun isSessionCommentaryAppended(): Boolean = sessionCommentaryAppended != null

    fun isSessionInputTranscriptDelta(): Boolean = sessionInputTranscriptDelta != null

    fun isSessionOutputTranscriptDelta(): Boolean = sessionOutputTranscriptDelta != null

    fun isSessionDelegationCreated(): Boolean = sessionDelegationCreated != null

    fun isResponseEvent(): Boolean = responseEvent != null

    fun isSessionUsageUpdated(): Boolean = sessionUsageUpdated != null

    fun isSessionClosed(): Boolean = sessionClosed != null

    fun isErrorEvent(): Boolean = errorEvent != null

    fun isInfoEvent(): Boolean = infoEvent != null

    /**
     * Returned when a Live session has started. Contains the resolved session configuration,
     * including server defaults.
     */
    fun asSessionStarted(): SessionStartedEvent = sessionStarted.getOrThrow("sessionStarted")

    /**
     * Returned when a Live session update is accepted. Contains the resolved session configuration
     * after the update.
     */
    fun asSessionUpdated(): SessionUpdatedEvent = sessionUpdated.getOrThrow("sessionUpdated")

    /**
     * Returned when a session.input_audio.mute command is accepted. Input audio is no longer sent
     * to the model; sideband audio reflection continues.
     */
    fun asSessionInputAudioMuted(): InputAudioMutedEvent =
        sessionInputAudioMuted.getOrThrow("sessionInputAudioMuted")

    /**
     * Returned when a session.input_audio.unmute command is accepted. Input audio is sent to the
     * model again.
     */
    fun asSessionInputAudioUnmuted(): InputAudioUnmutedEvent =
        sessionInputAudioUnmuted.getOrThrow("sessionInputAudioUnmuted")

    /**
     * The existing playback path has accepted the validated audio fixture. This acknowledgment does
     * not identify when the listener receives the first sample. The optional client_event_id echoes
     * the play command.
     */
    fun asSessionOutputAudioFixturePlaying(): OutputAudioFixturePlayingEvent =
        sessionOutputAudioFixturePlaying.getOrThrow("sessionOutputAudioFixturePlaying")

    /**
     * The complete audio fixture has drained from the server mixer and normal inference has
     * resumed. Transport buffers may still contain audio; this event does not prove listener-side
     * completion. The optional client_event_id echoes the play command. This event is not emitted
     * for canceled or failed playback.
     */
    fun asSessionOutputAudioFixturePlayed(): OutputAudioFixturePlayedEvent =
        sessionOutputAudioFixturePlayed.getOrThrow("sessionOutputAudioFixturePlayed")

    /**
     * Returned when a session.instructions.append command is accepted into the Live session
     * timeline. Acknowledges the appended instructions without guaranteeing that the model has
     * acted on them.
     */
    fun asSessionInstructionsAppended(): InstructionsAppendedEvent =
        sessionInstructionsAppended.getOrThrow("sessionInstructionsAppended")

    /**
     * Returned when a session.thinking.append command is accepted into the Live session timeline.
     * Acknowledges the added reasoning context without guaranteeing any spoken output.
     */
    fun asSessionThinkingAppended(): ThinkingAppendedEvent =
        sessionThinkingAppended.getOrThrow("sessionThinkingAppended")

    /**
     * Returned when a session.commentary.append command is accepted into the Live session timeline.
     * Acknowledges the added commentary without guaranteeing exact wording or completed audio
     * playback.
     */
    fun asSessionCommentaryAppended(): CommentaryAppendedEvent =
        sessionCommentaryAppended.getOrThrow("sessionCommentaryAppended")

    /**
     * A transcript fragment for user input audio in the Live session. Accumulate fragments in
     * delivery order; these events do not define complete turns or include a transcript-done event.
     */
    fun asSessionInputTranscriptDelta(): InputTranscriptDeltaEvent =
        sessionInputTranscriptDelta.getOrThrow("sessionInputTranscriptDelta")

    /**
     * A transcript fragment for assistant output audio in the Live session. Accumulate fragments in
     * delivery order; these events do not define complete turns or include a transcript-done event.
     */
    fun asSessionOutputTranscriptDelta(): OutputTranscriptDeltaEvent =
        sessionOutputTranscriptDelta.getOrThrow("sessionOutputTranscriptDelta")

    /**
     * Returned when the Live model delegates work to your application or a Responses backend.
     * Contains delegation metadata and the position on the session timeline where the work was
     * delegated.
     */
    fun asSessionDelegationCreated(): DelegationCreatedEvent =
        sessionDelegationCreated.getOrThrow("sessionDelegationCreated")

    /**
     * A streaming Responses API event from a backend delegated to by the Live session. Use the
     * outer delegation_id to associate the nested stream with its Live delegation.
     */
    fun asResponseEvent(): ResponseEvent = responseEvent.getOrThrow("responseEvent")

    /**
     * Reports cumulative Live audio usage and, when available, the most recent context-window
     * usage. Delegated Responses token usage is reported separately in response.event events.
     */
    fun asSessionUsageUpdated(): SessionUsageUpdatedEvent =
        sessionUsageUpdated.getOrThrow("sessionUsageUpdated")

    /**
     * Returned after the Live session finishes finalizing, with the close reason, final session
     * snapshot, and cumulative audio usage. A connection closing without this event does not
     * confirm successful finalization.
     */
    fun asSessionClosed(): SessionClosedEvent = sessionClosed.getOrThrow("sessionClosed")

    /**
     * Reports an error in the Live session, such as an invalid client command. Use
     * error.client_event_id, when present, to identify the command that caused the error.
     */
    fun asErrorEvent(): ErrorEvent = errorEvent.getOrThrow("errorEvent")

    /**
     * An informational notice about the Live session, such as the event permissions applied to a
     * frontend data channel.
     */
    fun asInfoEvent(): InfoEvent = infoEvent.getOrThrow("infoEvent")

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
     * Optional<String> result = sidebandServerEvent.accept(new SidebandServerEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitSessionStarted(SessionStartedEvent sessionStarted) {
     *         return Optional.of(sessionStarted.toString());
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
            sessionStarted != null -> visitor.visitSessionStarted(sessionStarted)
            sessionUpdated != null -> visitor.visitSessionUpdated(sessionUpdated)
            sessionInputAudioMuted != null ->
                visitor.visitSessionInputAudioMuted(sessionInputAudioMuted)
            sessionInputAudioUnmuted != null ->
                visitor.visitSessionInputAudioUnmuted(sessionInputAudioUnmuted)
            sessionOutputAudioFixturePlaying != null ->
                visitor.visitSessionOutputAudioFixturePlaying(sessionOutputAudioFixturePlaying)
            sessionOutputAudioFixturePlayed != null ->
                visitor.visitSessionOutputAudioFixturePlayed(sessionOutputAudioFixturePlayed)
            sessionInstructionsAppended != null ->
                visitor.visitSessionInstructionsAppended(sessionInstructionsAppended)
            sessionThinkingAppended != null ->
                visitor.visitSessionThinkingAppended(sessionThinkingAppended)
            sessionCommentaryAppended != null ->
                visitor.visitSessionCommentaryAppended(sessionCommentaryAppended)
            sessionInputTranscriptDelta != null ->
                visitor.visitSessionInputTranscriptDelta(sessionInputTranscriptDelta)
            sessionOutputTranscriptDelta != null ->
                visitor.visitSessionOutputTranscriptDelta(sessionOutputTranscriptDelta)
            sessionDelegationCreated != null ->
                visitor.visitSessionDelegationCreated(sessionDelegationCreated)
            responseEvent != null -> visitor.visitResponseEvent(responseEvent)
            sessionUsageUpdated != null -> visitor.visitSessionUsageUpdated(sessionUsageUpdated)
            sessionClosed != null -> visitor.visitSessionClosed(sessionClosed)
            errorEvent != null -> visitor.visitErrorEvent(errorEvent)
            infoEvent != null -> visitor.visitInfoEvent(infoEvent)
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
    fun validate(): SidebandServerEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitSessionStarted(sessionStarted: SessionStartedEvent) {
                    sessionStarted.validate()
                }

                override fun visitSessionUpdated(sessionUpdated: SessionUpdatedEvent) {
                    sessionUpdated.validate()
                }

                override fun visitSessionInputAudioMuted(
                    sessionInputAudioMuted: InputAudioMutedEvent
                ) {
                    sessionInputAudioMuted.validate()
                }

                override fun visitSessionInputAudioUnmuted(
                    sessionInputAudioUnmuted: InputAudioUnmutedEvent
                ) {
                    sessionInputAudioUnmuted.validate()
                }

                override fun visitSessionOutputAudioFixturePlaying(
                    sessionOutputAudioFixturePlaying: OutputAudioFixturePlayingEvent
                ) {
                    sessionOutputAudioFixturePlaying.validate()
                }

                override fun visitSessionOutputAudioFixturePlayed(
                    sessionOutputAudioFixturePlayed: OutputAudioFixturePlayedEvent
                ) {
                    sessionOutputAudioFixturePlayed.validate()
                }

                override fun visitSessionInstructionsAppended(
                    sessionInstructionsAppended: InstructionsAppendedEvent
                ) {
                    sessionInstructionsAppended.validate()
                }

                override fun visitSessionThinkingAppended(
                    sessionThinkingAppended: ThinkingAppendedEvent
                ) {
                    sessionThinkingAppended.validate()
                }

                override fun visitSessionCommentaryAppended(
                    sessionCommentaryAppended: CommentaryAppendedEvent
                ) {
                    sessionCommentaryAppended.validate()
                }

                override fun visitSessionInputTranscriptDelta(
                    sessionInputTranscriptDelta: InputTranscriptDeltaEvent
                ) {
                    sessionInputTranscriptDelta.validate()
                }

                override fun visitSessionOutputTranscriptDelta(
                    sessionOutputTranscriptDelta: OutputTranscriptDeltaEvent
                ) {
                    sessionOutputTranscriptDelta.validate()
                }

                override fun visitSessionDelegationCreated(
                    sessionDelegationCreated: DelegationCreatedEvent
                ) {
                    sessionDelegationCreated.validate()
                }

                override fun visitResponseEvent(responseEvent: ResponseEvent) {
                    responseEvent.validate()
                }

                override fun visitSessionUsageUpdated(
                    sessionUsageUpdated: SessionUsageUpdatedEvent
                ) {
                    sessionUsageUpdated.validate()
                }

                override fun visitSessionClosed(sessionClosed: SessionClosedEvent) {
                    sessionClosed.validate()
                }

                override fun visitErrorEvent(errorEvent: ErrorEvent) {
                    errorEvent.validate()
                }

                override fun visitInfoEvent(infoEvent: InfoEvent) {
                    infoEvent.validate()
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
                override fun visitSessionStarted(sessionStarted: SessionStartedEvent) =
                    sessionStarted.validity()

                override fun visitSessionUpdated(sessionUpdated: SessionUpdatedEvent) =
                    sessionUpdated.validity()

                override fun visitSessionInputAudioMuted(
                    sessionInputAudioMuted: InputAudioMutedEvent
                ) = sessionInputAudioMuted.validity()

                override fun visitSessionInputAudioUnmuted(
                    sessionInputAudioUnmuted: InputAudioUnmutedEvent
                ) = sessionInputAudioUnmuted.validity()

                override fun visitSessionOutputAudioFixturePlaying(
                    sessionOutputAudioFixturePlaying: OutputAudioFixturePlayingEvent
                ) = sessionOutputAudioFixturePlaying.validity()

                override fun visitSessionOutputAudioFixturePlayed(
                    sessionOutputAudioFixturePlayed: OutputAudioFixturePlayedEvent
                ) = sessionOutputAudioFixturePlayed.validity()

                override fun visitSessionInstructionsAppended(
                    sessionInstructionsAppended: InstructionsAppendedEvent
                ) = sessionInstructionsAppended.validity()

                override fun visitSessionThinkingAppended(
                    sessionThinkingAppended: ThinkingAppendedEvent
                ) = sessionThinkingAppended.validity()

                override fun visitSessionCommentaryAppended(
                    sessionCommentaryAppended: CommentaryAppendedEvent
                ) = sessionCommentaryAppended.validity()

                override fun visitSessionInputTranscriptDelta(
                    sessionInputTranscriptDelta: InputTranscriptDeltaEvent
                ) = sessionInputTranscriptDelta.validity()

                override fun visitSessionOutputTranscriptDelta(
                    sessionOutputTranscriptDelta: OutputTranscriptDeltaEvent
                ) = sessionOutputTranscriptDelta.validity()

                override fun visitSessionDelegationCreated(
                    sessionDelegationCreated: DelegationCreatedEvent
                ) = sessionDelegationCreated.validity()

                override fun visitResponseEvent(responseEvent: ResponseEvent) =
                    responseEvent.validity()

                override fun visitSessionUsageUpdated(
                    sessionUsageUpdated: SessionUsageUpdatedEvent
                ) = sessionUsageUpdated.validity()

                override fun visitSessionClosed(sessionClosed: SessionClosedEvent) =
                    sessionClosed.validity()

                override fun visitErrorEvent(errorEvent: ErrorEvent) = errorEvent.validity()

                override fun visitInfoEvent(infoEvent: InfoEvent) = infoEvent.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SidebandServerEvent &&
            sessionStarted == other.sessionStarted &&
            sessionUpdated == other.sessionUpdated &&
            sessionInputAudioMuted == other.sessionInputAudioMuted &&
            sessionInputAudioUnmuted == other.sessionInputAudioUnmuted &&
            sessionOutputAudioFixturePlaying == other.sessionOutputAudioFixturePlaying &&
            sessionOutputAudioFixturePlayed == other.sessionOutputAudioFixturePlayed &&
            sessionInstructionsAppended == other.sessionInstructionsAppended &&
            sessionThinkingAppended == other.sessionThinkingAppended &&
            sessionCommentaryAppended == other.sessionCommentaryAppended &&
            sessionInputTranscriptDelta == other.sessionInputTranscriptDelta &&
            sessionOutputTranscriptDelta == other.sessionOutputTranscriptDelta &&
            sessionDelegationCreated == other.sessionDelegationCreated &&
            responseEvent == other.responseEvent &&
            sessionUsageUpdated == other.sessionUsageUpdated &&
            sessionClosed == other.sessionClosed &&
            errorEvent == other.errorEvent &&
            infoEvent == other.infoEvent
    }

    override fun hashCode(): Int =
        Objects.hash(
            sessionStarted,
            sessionUpdated,
            sessionInputAudioMuted,
            sessionInputAudioUnmuted,
            sessionOutputAudioFixturePlaying,
            sessionOutputAudioFixturePlayed,
            sessionInstructionsAppended,
            sessionThinkingAppended,
            sessionCommentaryAppended,
            sessionInputTranscriptDelta,
            sessionOutputTranscriptDelta,
            sessionDelegationCreated,
            responseEvent,
            sessionUsageUpdated,
            sessionClosed,
            errorEvent,
            infoEvent,
        )

    override fun toString(): String =
        when {
            sessionStarted != null -> "SidebandServerEvent{sessionStarted=$sessionStarted}"
            sessionUpdated != null -> "SidebandServerEvent{sessionUpdated=$sessionUpdated}"
            sessionInputAudioMuted != null ->
                "SidebandServerEvent{sessionInputAudioMuted=$sessionInputAudioMuted}"
            sessionInputAudioUnmuted != null ->
                "SidebandServerEvent{sessionInputAudioUnmuted=$sessionInputAudioUnmuted}"
            sessionOutputAudioFixturePlaying != null ->
                "SidebandServerEvent{sessionOutputAudioFixturePlaying=$sessionOutputAudioFixturePlaying}"
            sessionOutputAudioFixturePlayed != null ->
                "SidebandServerEvent{sessionOutputAudioFixturePlayed=$sessionOutputAudioFixturePlayed}"
            sessionInstructionsAppended != null ->
                "SidebandServerEvent{sessionInstructionsAppended=$sessionInstructionsAppended}"
            sessionThinkingAppended != null ->
                "SidebandServerEvent{sessionThinkingAppended=$sessionThinkingAppended}"
            sessionCommentaryAppended != null ->
                "SidebandServerEvent{sessionCommentaryAppended=$sessionCommentaryAppended}"
            sessionInputTranscriptDelta != null ->
                "SidebandServerEvent{sessionInputTranscriptDelta=$sessionInputTranscriptDelta}"
            sessionOutputTranscriptDelta != null ->
                "SidebandServerEvent{sessionOutputTranscriptDelta=$sessionOutputTranscriptDelta}"
            sessionDelegationCreated != null ->
                "SidebandServerEvent{sessionDelegationCreated=$sessionDelegationCreated}"
            responseEvent != null -> "SidebandServerEvent{responseEvent=$responseEvent}"
            sessionUsageUpdated != null ->
                "SidebandServerEvent{sessionUsageUpdated=$sessionUsageUpdated}"
            sessionClosed != null -> "SidebandServerEvent{sessionClosed=$sessionClosed}"
            errorEvent != null -> "SidebandServerEvent{errorEvent=$errorEvent}"
            infoEvent != null -> "SidebandServerEvent{infoEvent=$infoEvent}"
            _json != null -> "SidebandServerEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid SidebandServerEvent")
        }

    companion object {

        /**
         * Returned when a Live session has started. Contains the resolved session configuration,
         * including server defaults.
         */
        @JvmStatic
        fun ofSessionStarted(sessionStarted: SessionStartedEvent) =
            SidebandServerEvent(sessionStarted = sessionStarted)

        /**
         * Returned when a Live session update is accepted. Contains the resolved session
         * configuration after the update.
         */
        @JvmStatic
        fun ofSessionUpdated(sessionUpdated: SessionUpdatedEvent) =
            SidebandServerEvent(sessionUpdated = sessionUpdated)

        /**
         * Returned when a session.input_audio.mute command is accepted. Input audio is no longer
         * sent to the model; sideband audio reflection continues.
         */
        @JvmStatic
        fun ofSessionInputAudioMuted(sessionInputAudioMuted: InputAudioMutedEvent) =
            SidebandServerEvent(sessionInputAudioMuted = sessionInputAudioMuted)

        /**
         * Returned when a session.input_audio.unmute command is accepted. Input audio is sent to
         * the model again.
         */
        @JvmStatic
        fun ofSessionInputAudioUnmuted(sessionInputAudioUnmuted: InputAudioUnmutedEvent) =
            SidebandServerEvent(sessionInputAudioUnmuted = sessionInputAudioUnmuted)

        /**
         * The existing playback path has accepted the validated audio fixture. This acknowledgment
         * does not identify when the listener receives the first sample. The optional
         * client_event_id echoes the play command.
         */
        @JvmStatic
        fun ofSessionOutputAudioFixturePlaying(
            sessionOutputAudioFixturePlaying: OutputAudioFixturePlayingEvent
        ) = SidebandServerEvent(sessionOutputAudioFixturePlaying = sessionOutputAudioFixturePlaying)

        /**
         * The complete audio fixture has drained from the server mixer and normal inference has
         * resumed. Transport buffers may still contain audio; this event does not prove
         * listener-side completion. The optional client_event_id echoes the play command. This
         * event is not emitted for canceled or failed playback.
         */
        @JvmStatic
        fun ofSessionOutputAudioFixturePlayed(
            sessionOutputAudioFixturePlayed: OutputAudioFixturePlayedEvent
        ) = SidebandServerEvent(sessionOutputAudioFixturePlayed = sessionOutputAudioFixturePlayed)

        /**
         * Returned when a session.instructions.append command is accepted into the Live session
         * timeline. Acknowledges the appended instructions without guaranteeing that the model has
         * acted on them.
         */
        @JvmStatic
        fun ofSessionInstructionsAppended(sessionInstructionsAppended: InstructionsAppendedEvent) =
            SidebandServerEvent(sessionInstructionsAppended = sessionInstructionsAppended)

        /**
         * Returned when a session.thinking.append command is accepted into the Live session
         * timeline. Acknowledges the added reasoning context without guaranteeing any spoken
         * output.
         */
        @JvmStatic
        fun ofSessionThinkingAppended(sessionThinkingAppended: ThinkingAppendedEvent) =
            SidebandServerEvent(sessionThinkingAppended = sessionThinkingAppended)

        /**
         * Returned when a session.commentary.append command is accepted into the Live session
         * timeline. Acknowledges the added commentary without guaranteeing exact wording or
         * completed audio playback.
         */
        @JvmStatic
        fun ofSessionCommentaryAppended(sessionCommentaryAppended: CommentaryAppendedEvent) =
            SidebandServerEvent(sessionCommentaryAppended = sessionCommentaryAppended)

        /**
         * A transcript fragment for user input audio in the Live session. Accumulate fragments in
         * delivery order; these events do not define complete turns or include a transcript-done
         * event.
         */
        @JvmStatic
        fun ofSessionInputTranscriptDelta(sessionInputTranscriptDelta: InputTranscriptDeltaEvent) =
            SidebandServerEvent(sessionInputTranscriptDelta = sessionInputTranscriptDelta)

        /**
         * A transcript fragment for assistant output audio in the Live session. Accumulate
         * fragments in delivery order; these events do not define complete turns or include a
         * transcript-done event.
         */
        @JvmStatic
        fun ofSessionOutputTranscriptDelta(
            sessionOutputTranscriptDelta: OutputTranscriptDeltaEvent
        ) = SidebandServerEvent(sessionOutputTranscriptDelta = sessionOutputTranscriptDelta)

        /**
         * Returned when the Live model delegates work to your application or a Responses backend.
         * Contains delegation metadata and the position on the session timeline where the work was
         * delegated.
         */
        @JvmStatic
        fun ofSessionDelegationCreated(sessionDelegationCreated: DelegationCreatedEvent) =
            SidebandServerEvent(sessionDelegationCreated = sessionDelegationCreated)

        /**
         * A streaming Responses API event from a backend delegated to by the Live session. Use the
         * outer delegation_id to associate the nested stream with its Live delegation.
         */
        @JvmStatic
        fun ofResponseEvent(responseEvent: ResponseEvent) =
            SidebandServerEvent(responseEvent = responseEvent)

        /**
         * Reports cumulative Live audio usage and, when available, the most recent context-window
         * usage. Delegated Responses token usage is reported separately in response.event events.
         */
        @JvmStatic
        fun ofSessionUsageUpdated(sessionUsageUpdated: SessionUsageUpdatedEvent) =
            SidebandServerEvent(sessionUsageUpdated = sessionUsageUpdated)

        /**
         * Returned after the Live session finishes finalizing, with the close reason, final session
         * snapshot, and cumulative audio usage. A connection closing without this event does not
         * confirm successful finalization.
         */
        @JvmStatic
        fun ofSessionClosed(sessionClosed: SessionClosedEvent) =
            SidebandServerEvent(sessionClosed = sessionClosed)

        /**
         * Reports an error in the Live session, such as an invalid client command. Use
         * error.client_event_id, when present, to identify the command that caused the error.
         */
        @JvmStatic
        fun ofErrorEvent(errorEvent: ErrorEvent) = SidebandServerEvent(errorEvent = errorEvent)

        /**
         * An informational notice about the Live session, such as the event permissions applied to
         * a frontend data channel.
         */
        @JvmStatic
        fun ofInfoEvent(infoEvent: InfoEvent) = SidebandServerEvent(infoEvent = infoEvent)
    }

    /**
     * An interface that defines how to map each variant of [SidebandServerEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /**
         * Returned when a Live session has started. Contains the resolved session configuration,
         * including server defaults.
         */
        fun visitSessionStarted(sessionStarted: SessionStartedEvent): T =
            unknown(JsonValue.from(sessionStarted))

        /**
         * Returned when a Live session update is accepted. Contains the resolved session
         * configuration after the update.
         */
        fun visitSessionUpdated(sessionUpdated: SessionUpdatedEvent): T =
            unknown(JsonValue.from(sessionUpdated))

        /**
         * Returned when a session.input_audio.mute command is accepted. Input audio is no longer
         * sent to the model; sideband audio reflection continues.
         */
        fun visitSessionInputAudioMuted(sessionInputAudioMuted: InputAudioMutedEvent): T =
            unknown(JsonValue.from(sessionInputAudioMuted))

        /**
         * Returned when a session.input_audio.unmute command is accepted. Input audio is sent to
         * the model again.
         */
        fun visitSessionInputAudioUnmuted(sessionInputAudioUnmuted: InputAudioUnmutedEvent): T =
            unknown(JsonValue.from(sessionInputAudioUnmuted))

        /**
         * The existing playback path has accepted the validated audio fixture. This acknowledgment
         * does not identify when the listener receives the first sample. The optional
         * client_event_id echoes the play command.
         */
        fun visitSessionOutputAudioFixturePlaying(
            sessionOutputAudioFixturePlaying: OutputAudioFixturePlayingEvent
        ): T = unknown(JsonValue.from(sessionOutputAudioFixturePlaying))

        /**
         * The complete audio fixture has drained from the server mixer and normal inference has
         * resumed. Transport buffers may still contain audio; this event does not prove
         * listener-side completion. The optional client_event_id echoes the play command. This
         * event is not emitted for canceled or failed playback.
         */
        fun visitSessionOutputAudioFixturePlayed(
            sessionOutputAudioFixturePlayed: OutputAudioFixturePlayedEvent
        ): T = unknown(JsonValue.from(sessionOutputAudioFixturePlayed))

        /**
         * Returned when a session.instructions.append command is accepted into the Live session
         * timeline. Acknowledges the appended instructions without guaranteeing that the model has
         * acted on them.
         */
        fun visitSessionInstructionsAppended(
            sessionInstructionsAppended: InstructionsAppendedEvent
        ): T = unknown(JsonValue.from(sessionInstructionsAppended))

        /**
         * Returned when a session.thinking.append command is accepted into the Live session
         * timeline. Acknowledges the added reasoning context without guaranteeing any spoken
         * output.
         */
        fun visitSessionThinkingAppended(sessionThinkingAppended: ThinkingAppendedEvent): T =
            unknown(JsonValue.from(sessionThinkingAppended))

        /**
         * Returned when a session.commentary.append command is accepted into the Live session
         * timeline. Acknowledges the added commentary without guaranteeing exact wording or
         * completed audio playback.
         */
        fun visitSessionCommentaryAppended(sessionCommentaryAppended: CommentaryAppendedEvent): T =
            unknown(JsonValue.from(sessionCommentaryAppended))

        /**
         * A transcript fragment for user input audio in the Live session. Accumulate fragments in
         * delivery order; these events do not define complete turns or include a transcript-done
         * event.
         */
        fun visitSessionInputTranscriptDelta(
            sessionInputTranscriptDelta: InputTranscriptDeltaEvent
        ): T = unknown(JsonValue.from(sessionInputTranscriptDelta))

        /**
         * A transcript fragment for assistant output audio in the Live session. Accumulate
         * fragments in delivery order; these events do not define complete turns or include a
         * transcript-done event.
         */
        fun visitSessionOutputTranscriptDelta(
            sessionOutputTranscriptDelta: OutputTranscriptDeltaEvent
        ): T = unknown(JsonValue.from(sessionOutputTranscriptDelta))

        /**
         * Returned when the Live model delegates work to your application or a Responses backend.
         * Contains delegation metadata and the position on the session timeline where the work was
         * delegated.
         */
        fun visitSessionDelegationCreated(sessionDelegationCreated: DelegationCreatedEvent): T =
            unknown(JsonValue.from(sessionDelegationCreated))

        /**
         * A streaming Responses API event from a backend delegated to by the Live session. Use the
         * outer delegation_id to associate the nested stream with its Live delegation.
         */
        fun visitResponseEvent(responseEvent: ResponseEvent): T =
            unknown(JsonValue.from(responseEvent))

        /**
         * Reports cumulative Live audio usage and, when available, the most recent context-window
         * usage. Delegated Responses token usage is reported separately in response.event events.
         */
        fun visitSessionUsageUpdated(sessionUsageUpdated: SessionUsageUpdatedEvent): T =
            unknown(JsonValue.from(sessionUsageUpdated))

        /**
         * Returned after the Live session finishes finalizing, with the close reason, final session
         * snapshot, and cumulative audio usage. A connection closing without this event does not
         * confirm successful finalization.
         */
        fun visitSessionClosed(sessionClosed: SessionClosedEvent): T =
            unknown(JsonValue.from(sessionClosed))

        /**
         * Reports an error in the Live session, such as an invalid client command. Use
         * error.client_event_id, when present, to identify the command that caused the error.
         */
        fun visitErrorEvent(errorEvent: ErrorEvent): T = unknown(JsonValue.from(errorEvent))

        /**
         * An informational notice about the Live session, such as the event permissions applied to
         * a frontend data channel.
         */
        fun visitInfoEvent(infoEvent: InfoEvent): T = unknown(JsonValue.from(infoEvent))

        /**
         * Maps an unknown variant of [SidebandServerEvent] to a value of type [T].
         *
         * An instance of [SidebandServerEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * Recognized variants also reach this method when their visit method is not overridden.
         * This allows existing visitors to handle variants added by newer SDK versions.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown SidebandServerEvent")
        }
    }

    internal class Deserializer :
        BaseDeserializer<SidebandServerEvent>(SidebandServerEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): SidebandServerEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "session.started" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionStartedEvent>())?.let {
                        SidebandServerEvent(sessionStarted = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionUpdatedEvent>())?.let {
                        SidebandServerEvent(sessionUpdated = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.input_audio.muted" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioMutedEvent>())?.let {
                        SidebandServerEvent(sessionInputAudioMuted = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.input_audio.unmuted" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioUnmutedEvent>())?.let {
                        SidebandServerEvent(sessionInputAudioUnmuted = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.output_audio.fixture.playing" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioFixturePlayingEvent>())
                        ?.let {
                            SidebandServerEvent(sessionOutputAudioFixturePlaying = it, _json = json)
                        } ?: SidebandServerEvent(_json = json)
                }
                "session.output_audio.fixture.played" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioFixturePlayedEvent>())
                        ?.let {
                            SidebandServerEvent(sessionOutputAudioFixturePlayed = it, _json = json)
                        } ?: SidebandServerEvent(_json = json)
                }
                "session.instructions.appended" -> {
                    return tryDeserialize(node, jacksonTypeRef<InstructionsAppendedEvent>())?.let {
                        SidebandServerEvent(sessionInstructionsAppended = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.thinking.appended" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThinkingAppendedEvent>())?.let {
                        SidebandServerEvent(sessionThinkingAppended = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.commentary.appended" -> {
                    return tryDeserialize(node, jacksonTypeRef<CommentaryAppendedEvent>())?.let {
                        SidebandServerEvent(sessionCommentaryAppended = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.input_transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputTranscriptDeltaEvent>())?.let {
                        SidebandServerEvent(sessionInputTranscriptDelta = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.output_transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputTranscriptDeltaEvent>())?.let {
                        SidebandServerEvent(sessionOutputTranscriptDelta = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.delegation.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<DelegationCreatedEvent>())?.let {
                        SidebandServerEvent(sessionDelegationCreated = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "response.event" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseEvent>())?.let {
                        SidebandServerEvent(responseEvent = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.usage.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionUsageUpdatedEvent>())?.let {
                        SidebandServerEvent(sessionUsageUpdated = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "session.closed" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionClosedEvent>())?.let {
                        SidebandServerEvent(sessionClosed = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<ErrorEvent>())?.let {
                        SidebandServerEvent(errorEvent = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
                "info" -> {
                    return tryDeserialize(node, jacksonTypeRef<InfoEvent>())?.let {
                        SidebandServerEvent(infoEvent = it, _json = json)
                    } ?: SidebandServerEvent(_json = json)
                }
            }

            return SidebandServerEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<SidebandServerEvent>(SidebandServerEvent::class) {

        override fun serialize(
            value: SidebandServerEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.sessionStarted != null -> generator.writeObject(value.sessionStarted)
                value.sessionUpdated != null -> generator.writeObject(value.sessionUpdated)
                value.sessionInputAudioMuted != null ->
                    generator.writeObject(value.sessionInputAudioMuted)
                value.sessionInputAudioUnmuted != null ->
                    generator.writeObject(value.sessionInputAudioUnmuted)
                value.sessionOutputAudioFixturePlaying != null ->
                    generator.writeObject(value.sessionOutputAudioFixturePlaying)
                value.sessionOutputAudioFixturePlayed != null ->
                    generator.writeObject(value.sessionOutputAudioFixturePlayed)
                value.sessionInstructionsAppended != null ->
                    generator.writeObject(value.sessionInstructionsAppended)
                value.sessionThinkingAppended != null ->
                    generator.writeObject(value.sessionThinkingAppended)
                value.sessionCommentaryAppended != null ->
                    generator.writeObject(value.sessionCommentaryAppended)
                value.sessionInputTranscriptDelta != null ->
                    generator.writeObject(value.sessionInputTranscriptDelta)
                value.sessionOutputTranscriptDelta != null ->
                    generator.writeObject(value.sessionOutputTranscriptDelta)
                value.sessionDelegationCreated != null ->
                    generator.writeObject(value.sessionDelegationCreated)
                value.responseEvent != null -> generator.writeObject(value.responseEvent)
                value.sessionUsageUpdated != null ->
                    generator.writeObject(value.sessionUsageUpdated)
                value.sessionClosed != null -> generator.writeObject(value.sessionClosed)
                value.errorEvent != null -> generator.writeObject(value.errorEvent)
                value.infoEvent != null -> generator.writeObject(value.infoEvent)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid SidebandServerEvent")
            }
        }
    }
}
