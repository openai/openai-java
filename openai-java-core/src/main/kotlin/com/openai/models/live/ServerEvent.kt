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

/**
 * Server events for Live. Response lifecycle events are wrapped inside response.event; dispatch the
 * nested event by its full type and tolerate new response event types. Follow the
 * [Live prompting guide](https://developers.openai.com/api/docs/guides/live-prompting) when
 * designing the conversation and delegation policy.
 */
@JsonDeserialize(using = ServerEvent.Deserializer::class)
@JsonSerialize(using = ServerEvent.Serializer::class)
class ServerEvent
private constructor(
    private val sessionStarted: SessionStartedEvent? = null,
    private val sessionUpdated: SessionUpdatedEvent? = null,
    private val sessionInputAudioMuted: InputAudioMutedEvent? = null,
    private val sessionInputAudioUnmuted: InputAudioUnmutedEvent? = null,
    private val sessionInstructionsAppended: InstructionsAppendedEvent? = null,
    private val sessionThinkingAppended: ThinkingAppendedEvent? = null,
    private val sessionCommentaryAppended: CommentaryAppendedEvent? = null,
    private val sessionInputAudioAppend: SessionInputAudioAppend? = null,
    private val sessionOutputAudioDelta: OutputAudioDeltaEvent? = null,
    private val sessionInputTranscriptDelta: InputTranscriptDeltaEvent? = null,
    private val sessionOutputTranscriptDelta: OutputTranscriptDeltaEvent? = null,
    private val sessionDelegationCreated: DelegationCreatedEvent? = null,
    private val responseEvent: ResponseEvent? = null,
    private val sessionUsageUpdated: SessionUsageUpdatedEvent? = null,
    private val sessionClosed: SessionClosedEvent? = null,
    private val errorEvent: ErrorEvent? = null,
    private val infoEvent: InfoEvent? = null,
    private val transportDtmfReceived: TransportDtmfReceived? = null,
    private val transportDtmfSend: TransportDtmfSend? = null,
    private val transportRinging: TransportRinging? = null,
    private val transportAnswered: TransportAnswered? = null,
    private val transportFailed: TransportFailed? = null,
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
     * Input audio received from the primary transport and reflected to a Live sideband connection
     * before model-input muting.
     */
    fun sessionInputAudioAppend(): Optional<SessionInputAudioAppend> =
        Optional.ofNullable(sessionInputAudioAppend)

    /**
     * An audio chunk generated by the Live model. Decode and play primary WebSocket chunks in
     * delivery order using the configured session audio format. Sideband connections receive
     * reflected output audio with timestamps.
     */
    fun sessionOutputAudioDelta(): Optional<OutputAudioDeltaEvent> =
        Optional.ofNullable(sessionOutputAudioDelta)

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

    /** A SIP DTMF keypress received from the caller. Delivered only to sideband observers. */
    fun transportDtmfReceived(): Optional<TransportDtmfReceived> =
        Optional.ofNullable(transportDtmfReceived)

    /**
     * A SIP DTMF keypress successfully sent by the hosted tool. Delivered only to sideband
     * observers; this is not a client command.
     */
    fun transportDtmfSend(): Optional<TransportDtmfSend> = Optional.ofNullable(transportDtmfSend)

    /**
     * The outbound SIP provider leg is ringing or providing early media. Delivered only to sideband
     * observers.
     */
    fun transportRinging(): Optional<TransportRinging> = Optional.ofNullable(transportRinging)

    /**
     * The outbound SIP provider leg answered and media is established. Delivered only to sideband
     * observers.
     */
    fun transportAnswered(): Optional<TransportAnswered> = Optional.ofNullable(transportAnswered)

    /** An asynchronous outbound SIP setup failure. Delivered only to sideband observers. */
    fun transportFailed(): Optional<TransportFailed> = Optional.ofNullable(transportFailed)

    fun isSessionStarted(): Boolean = sessionStarted != null

    fun isSessionUpdated(): Boolean = sessionUpdated != null

    fun isSessionInputAudioMuted(): Boolean = sessionInputAudioMuted != null

    fun isSessionInputAudioUnmuted(): Boolean = sessionInputAudioUnmuted != null

    fun isSessionInstructionsAppended(): Boolean = sessionInstructionsAppended != null

    fun isSessionThinkingAppended(): Boolean = sessionThinkingAppended != null

    fun isSessionCommentaryAppended(): Boolean = sessionCommentaryAppended != null

    fun isSessionInputAudioAppend(): Boolean = sessionInputAudioAppend != null

    fun isSessionOutputAudioDelta(): Boolean = sessionOutputAudioDelta != null

    fun isSessionInputTranscriptDelta(): Boolean = sessionInputTranscriptDelta != null

    fun isSessionOutputTranscriptDelta(): Boolean = sessionOutputTranscriptDelta != null

    fun isSessionDelegationCreated(): Boolean = sessionDelegationCreated != null

    fun isResponseEvent(): Boolean = responseEvent != null

    fun isSessionUsageUpdated(): Boolean = sessionUsageUpdated != null

    fun isSessionClosed(): Boolean = sessionClosed != null

    fun isErrorEvent(): Boolean = errorEvent != null

    fun isInfoEvent(): Boolean = infoEvent != null

    fun isTransportDtmfReceived(): Boolean = transportDtmfReceived != null

    fun isTransportDtmfSend(): Boolean = transportDtmfSend != null

    fun isTransportRinging(): Boolean = transportRinging != null

    fun isTransportAnswered(): Boolean = transportAnswered != null

    fun isTransportFailed(): Boolean = transportFailed != null

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
     * Input audio received from the primary transport and reflected to a Live sideband connection
     * before model-input muting.
     */
    fun asSessionInputAudioAppend(): SessionInputAudioAppend =
        sessionInputAudioAppend.getOrThrow("sessionInputAudioAppend")

    /**
     * An audio chunk generated by the Live model. Decode and play primary WebSocket chunks in
     * delivery order using the configured session audio format. Sideband connections receive
     * reflected output audio with timestamps.
     */
    fun asSessionOutputAudioDelta(): OutputAudioDeltaEvent =
        sessionOutputAudioDelta.getOrThrow("sessionOutputAudioDelta")

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

    /** A SIP DTMF keypress received from the caller. Delivered only to sideband observers. */
    fun asTransportDtmfReceived(): TransportDtmfReceived =
        transportDtmfReceived.getOrThrow("transportDtmfReceived")

    /**
     * A SIP DTMF keypress successfully sent by the hosted tool. Delivered only to sideband
     * observers; this is not a client command.
     */
    fun asTransportDtmfSend(): TransportDtmfSend = transportDtmfSend.getOrThrow("transportDtmfSend")

    /**
     * The outbound SIP provider leg is ringing or providing early media. Delivered only to sideband
     * observers.
     */
    fun asTransportRinging(): TransportRinging = transportRinging.getOrThrow("transportRinging")

    /**
     * The outbound SIP provider leg answered and media is established. Delivered only to sideband
     * observers.
     */
    fun asTransportAnswered(): TransportAnswered = transportAnswered.getOrThrow("transportAnswered")

    /** An asynchronous outbound SIP setup failure. Delivered only to sideband observers. */
    fun asTransportFailed(): TransportFailed = transportFailed.getOrThrow("transportFailed")

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
     * Optional<String> result = serverEvent.accept(new ServerEvent.Visitor<Optional<String>>() {
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
            sessionInstructionsAppended != null ->
                visitor.visitSessionInstructionsAppended(sessionInstructionsAppended)
            sessionThinkingAppended != null ->
                visitor.visitSessionThinkingAppended(sessionThinkingAppended)
            sessionCommentaryAppended != null ->
                visitor.visitSessionCommentaryAppended(sessionCommentaryAppended)
            sessionInputAudioAppend != null ->
                visitor.visitSessionInputAudioAppend(sessionInputAudioAppend)
            sessionOutputAudioDelta != null ->
                visitor.visitSessionOutputAudioDelta(sessionOutputAudioDelta)
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
            transportDtmfReceived != null ->
                visitor.visitTransportDtmfReceived(transportDtmfReceived)
            transportDtmfSend != null -> visitor.visitTransportDtmfSend(transportDtmfSend)
            transportRinging != null -> visitor.visitTransportRinging(transportRinging)
            transportAnswered != null -> visitor.visitTransportAnswered(transportAnswered)
            transportFailed != null -> visitor.visitTransportFailed(transportFailed)
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
    fun validate(): ServerEvent = apply {
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

                override fun visitSessionInputAudioAppend(
                    sessionInputAudioAppend: SessionInputAudioAppend
                ) {
                    sessionInputAudioAppend.validate()
                }

                override fun visitSessionOutputAudioDelta(
                    sessionOutputAudioDelta: OutputAudioDeltaEvent
                ) {
                    sessionOutputAudioDelta.validate()
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

                override fun visitTransportDtmfReceived(
                    transportDtmfReceived: TransportDtmfReceived
                ) {
                    transportDtmfReceived.validate()
                }

                override fun visitTransportDtmfSend(transportDtmfSend: TransportDtmfSend) {
                    transportDtmfSend.validate()
                }

                override fun visitTransportRinging(transportRinging: TransportRinging) {
                    transportRinging.validate()
                }

                override fun visitTransportAnswered(transportAnswered: TransportAnswered) {
                    transportAnswered.validate()
                }

                override fun visitTransportFailed(transportFailed: TransportFailed) {
                    transportFailed.validate()
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

                override fun visitSessionInstructionsAppended(
                    sessionInstructionsAppended: InstructionsAppendedEvent
                ) = sessionInstructionsAppended.validity()

                override fun visitSessionThinkingAppended(
                    sessionThinkingAppended: ThinkingAppendedEvent
                ) = sessionThinkingAppended.validity()

                override fun visitSessionCommentaryAppended(
                    sessionCommentaryAppended: CommentaryAppendedEvent
                ) = sessionCommentaryAppended.validity()

                override fun visitSessionInputAudioAppend(
                    sessionInputAudioAppend: SessionInputAudioAppend
                ) = sessionInputAudioAppend.validity()

                override fun visitSessionOutputAudioDelta(
                    sessionOutputAudioDelta: OutputAudioDeltaEvent
                ) = sessionOutputAudioDelta.validity()

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

                override fun visitTransportDtmfReceived(
                    transportDtmfReceived: TransportDtmfReceived
                ) = transportDtmfReceived.validity()

                override fun visitTransportDtmfSend(transportDtmfSend: TransportDtmfSend) =
                    transportDtmfSend.validity()

                override fun visitTransportRinging(transportRinging: TransportRinging) =
                    transportRinging.validity()

                override fun visitTransportAnswered(transportAnswered: TransportAnswered) =
                    transportAnswered.validity()

                override fun visitTransportFailed(transportFailed: TransportFailed) =
                    transportFailed.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ServerEvent &&
            sessionStarted == other.sessionStarted &&
            sessionUpdated == other.sessionUpdated &&
            sessionInputAudioMuted == other.sessionInputAudioMuted &&
            sessionInputAudioUnmuted == other.sessionInputAudioUnmuted &&
            sessionInstructionsAppended == other.sessionInstructionsAppended &&
            sessionThinkingAppended == other.sessionThinkingAppended &&
            sessionCommentaryAppended == other.sessionCommentaryAppended &&
            sessionInputAudioAppend == other.sessionInputAudioAppend &&
            sessionOutputAudioDelta == other.sessionOutputAudioDelta &&
            sessionInputTranscriptDelta == other.sessionInputTranscriptDelta &&
            sessionOutputTranscriptDelta == other.sessionOutputTranscriptDelta &&
            sessionDelegationCreated == other.sessionDelegationCreated &&
            responseEvent == other.responseEvent &&
            sessionUsageUpdated == other.sessionUsageUpdated &&
            sessionClosed == other.sessionClosed &&
            errorEvent == other.errorEvent &&
            infoEvent == other.infoEvent &&
            transportDtmfReceived == other.transportDtmfReceived &&
            transportDtmfSend == other.transportDtmfSend &&
            transportRinging == other.transportRinging &&
            transportAnswered == other.transportAnswered &&
            transportFailed == other.transportFailed
    }

    override fun hashCode(): Int =
        Objects.hash(
            sessionStarted,
            sessionUpdated,
            sessionInputAudioMuted,
            sessionInputAudioUnmuted,
            sessionInstructionsAppended,
            sessionThinkingAppended,
            sessionCommentaryAppended,
            sessionInputAudioAppend,
            sessionOutputAudioDelta,
            sessionInputTranscriptDelta,
            sessionOutputTranscriptDelta,
            sessionDelegationCreated,
            responseEvent,
            sessionUsageUpdated,
            sessionClosed,
            errorEvent,
            infoEvent,
            transportDtmfReceived,
            transportDtmfSend,
            transportRinging,
            transportAnswered,
            transportFailed,
        )

    override fun toString(): String =
        when {
            sessionStarted != null -> "ServerEvent{sessionStarted=$sessionStarted}"
            sessionUpdated != null -> "ServerEvent{sessionUpdated=$sessionUpdated}"
            sessionInputAudioMuted != null ->
                "ServerEvent{sessionInputAudioMuted=$sessionInputAudioMuted}"
            sessionInputAudioUnmuted != null ->
                "ServerEvent{sessionInputAudioUnmuted=$sessionInputAudioUnmuted}"
            sessionInstructionsAppended != null ->
                "ServerEvent{sessionInstructionsAppended=$sessionInstructionsAppended}"
            sessionThinkingAppended != null ->
                "ServerEvent{sessionThinkingAppended=$sessionThinkingAppended}"
            sessionCommentaryAppended != null ->
                "ServerEvent{sessionCommentaryAppended=$sessionCommentaryAppended}"
            sessionInputAudioAppend != null ->
                "ServerEvent{sessionInputAudioAppend=$sessionInputAudioAppend}"
            sessionOutputAudioDelta != null ->
                "ServerEvent{sessionOutputAudioDelta=$sessionOutputAudioDelta}"
            sessionInputTranscriptDelta != null ->
                "ServerEvent{sessionInputTranscriptDelta=$sessionInputTranscriptDelta}"
            sessionOutputTranscriptDelta != null ->
                "ServerEvent{sessionOutputTranscriptDelta=$sessionOutputTranscriptDelta}"
            sessionDelegationCreated != null ->
                "ServerEvent{sessionDelegationCreated=$sessionDelegationCreated}"
            responseEvent != null -> "ServerEvent{responseEvent=$responseEvent}"
            sessionUsageUpdated != null -> "ServerEvent{sessionUsageUpdated=$sessionUsageUpdated}"
            sessionClosed != null -> "ServerEvent{sessionClosed=$sessionClosed}"
            errorEvent != null -> "ServerEvent{errorEvent=$errorEvent}"
            infoEvent != null -> "ServerEvent{infoEvent=$infoEvent}"
            transportDtmfReceived != null ->
                "ServerEvent{transportDtmfReceived=$transportDtmfReceived}"
            transportDtmfSend != null -> "ServerEvent{transportDtmfSend=$transportDtmfSend}"
            transportRinging != null -> "ServerEvent{transportRinging=$transportRinging}"
            transportAnswered != null -> "ServerEvent{transportAnswered=$transportAnswered}"
            transportFailed != null -> "ServerEvent{transportFailed=$transportFailed}"
            _json != null -> "ServerEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ServerEvent")
        }

    companion object {

        /**
         * Returned when a Live session has started. Contains the resolved session configuration,
         * including server defaults.
         */
        @JvmStatic
        fun ofSessionStarted(sessionStarted: SessionStartedEvent) =
            ServerEvent(sessionStarted = sessionStarted)

        /**
         * Returned when a Live session update is accepted. Contains the resolved session
         * configuration after the update.
         */
        @JvmStatic
        fun ofSessionUpdated(sessionUpdated: SessionUpdatedEvent) =
            ServerEvent(sessionUpdated = sessionUpdated)

        /**
         * Returned when a session.input_audio.mute command is accepted. Input audio is no longer
         * sent to the model; sideband audio reflection continues.
         */
        @JvmStatic
        fun ofSessionInputAudioMuted(sessionInputAudioMuted: InputAudioMutedEvent) =
            ServerEvent(sessionInputAudioMuted = sessionInputAudioMuted)

        /**
         * Returned when a session.input_audio.unmute command is accepted. Input audio is sent to
         * the model again.
         */
        @JvmStatic
        fun ofSessionInputAudioUnmuted(sessionInputAudioUnmuted: InputAudioUnmutedEvent) =
            ServerEvent(sessionInputAudioUnmuted = sessionInputAudioUnmuted)

        /**
         * Returned when a session.instructions.append command is accepted into the Live session
         * timeline. Acknowledges the appended instructions without guaranteeing that the model has
         * acted on them.
         */
        @JvmStatic
        fun ofSessionInstructionsAppended(sessionInstructionsAppended: InstructionsAppendedEvent) =
            ServerEvent(sessionInstructionsAppended = sessionInstructionsAppended)

        /**
         * Returned when a session.thinking.append command is accepted into the Live session
         * timeline. Acknowledges the added reasoning context without guaranteeing any spoken
         * output.
         */
        @JvmStatic
        fun ofSessionThinkingAppended(sessionThinkingAppended: ThinkingAppendedEvent) =
            ServerEvent(sessionThinkingAppended = sessionThinkingAppended)

        /**
         * Returned when a session.commentary.append command is accepted into the Live session
         * timeline. Acknowledges the added commentary without guaranteeing exact wording or
         * completed audio playback.
         */
        @JvmStatic
        fun ofSessionCommentaryAppended(sessionCommentaryAppended: CommentaryAppendedEvent) =
            ServerEvent(sessionCommentaryAppended = sessionCommentaryAppended)

        /**
         * Input audio received from the primary transport and reflected to a Live sideband
         * connection before model-input muting.
         */
        @JvmStatic
        fun ofSessionInputAudioAppend(sessionInputAudioAppend: SessionInputAudioAppend) =
            ServerEvent(sessionInputAudioAppend = sessionInputAudioAppend)

        /**
         * An audio chunk generated by the Live model. Decode and play primary WebSocket chunks in
         * delivery order using the configured session audio format. Sideband connections receive
         * reflected output audio with timestamps.
         */
        @JvmStatic
        fun ofSessionOutputAudioDelta(sessionOutputAudioDelta: OutputAudioDeltaEvent) =
            ServerEvent(sessionOutputAudioDelta = sessionOutputAudioDelta)

        /**
         * A transcript fragment for user input audio in the Live session. Accumulate fragments in
         * delivery order; these events do not define complete turns or include a transcript-done
         * event.
         */
        @JvmStatic
        fun ofSessionInputTranscriptDelta(sessionInputTranscriptDelta: InputTranscriptDeltaEvent) =
            ServerEvent(sessionInputTranscriptDelta = sessionInputTranscriptDelta)

        /**
         * A transcript fragment for assistant output audio in the Live session. Accumulate
         * fragments in delivery order; these events do not define complete turns or include a
         * transcript-done event.
         */
        @JvmStatic
        fun ofSessionOutputTranscriptDelta(
            sessionOutputTranscriptDelta: OutputTranscriptDeltaEvent
        ) = ServerEvent(sessionOutputTranscriptDelta = sessionOutputTranscriptDelta)

        /**
         * Returned when the Live model delegates work to your application or a Responses backend.
         * Contains delegation metadata and the position on the session timeline where the work was
         * delegated.
         */
        @JvmStatic
        fun ofSessionDelegationCreated(sessionDelegationCreated: DelegationCreatedEvent) =
            ServerEvent(sessionDelegationCreated = sessionDelegationCreated)

        /**
         * A streaming Responses API event from a backend delegated to by the Live session. Use the
         * outer delegation_id to associate the nested stream with its Live delegation.
         */
        @JvmStatic
        fun ofResponseEvent(responseEvent: ResponseEvent) =
            ServerEvent(responseEvent = responseEvent)

        /**
         * Reports cumulative Live audio usage and, when available, the most recent context-window
         * usage. Delegated Responses token usage is reported separately in response.event events.
         */
        @JvmStatic
        fun ofSessionUsageUpdated(sessionUsageUpdated: SessionUsageUpdatedEvent) =
            ServerEvent(sessionUsageUpdated = sessionUsageUpdated)

        /**
         * Returned after the Live session finishes finalizing, with the close reason, final session
         * snapshot, and cumulative audio usage. A connection closing without this event does not
         * confirm successful finalization.
         */
        @JvmStatic
        fun ofSessionClosed(sessionClosed: SessionClosedEvent) =
            ServerEvent(sessionClosed = sessionClosed)

        /**
         * Reports an error in the Live session, such as an invalid client command. Use
         * error.client_event_id, when present, to identify the command that caused the error.
         */
        @JvmStatic fun ofErrorEvent(errorEvent: ErrorEvent) = ServerEvent(errorEvent = errorEvent)

        /**
         * An informational notice about the Live session, such as the event permissions applied to
         * a frontend data channel.
         */
        @JvmStatic fun ofInfoEvent(infoEvent: InfoEvent) = ServerEvent(infoEvent = infoEvent)

        /** A SIP DTMF keypress received from the caller. Delivered only to sideband observers. */
        @JvmStatic
        fun ofTransportDtmfReceived(transportDtmfReceived: TransportDtmfReceived) =
            ServerEvent(transportDtmfReceived = transportDtmfReceived)

        /**
         * A SIP DTMF keypress successfully sent by the hosted tool. Delivered only to sideband
         * observers; this is not a client command.
         */
        @JvmStatic
        fun ofTransportDtmfSend(transportDtmfSend: TransportDtmfSend) =
            ServerEvent(transportDtmfSend = transportDtmfSend)

        /**
         * The outbound SIP provider leg is ringing or providing early media. Delivered only to
         * sideband observers.
         */
        @JvmStatic
        fun ofTransportRinging(transportRinging: TransportRinging) =
            ServerEvent(transportRinging = transportRinging)

        /**
         * The outbound SIP provider leg answered and media is established. Delivered only to
         * sideband observers.
         */
        @JvmStatic
        fun ofTransportAnswered(transportAnswered: TransportAnswered) =
            ServerEvent(transportAnswered = transportAnswered)

        /** An asynchronous outbound SIP setup failure. Delivered only to sideband observers. */
        @JvmStatic
        fun ofTransportFailed(transportFailed: TransportFailed) =
            ServerEvent(transportFailed = transportFailed)
    }

    /**
     * An interface that defines how to map each variant of [ServerEvent] to a value of type [T].
     */
    interface Visitor<out T> {

        /**
         * Returned when a Live session has started. Contains the resolved session configuration,
         * including server defaults.
         */
        fun visitSessionStarted(sessionStarted: SessionStartedEvent): T

        /**
         * Returned when a Live session update is accepted. Contains the resolved session
         * configuration after the update.
         */
        fun visitSessionUpdated(sessionUpdated: SessionUpdatedEvent): T

        /**
         * Returned when a session.input_audio.mute command is accepted. Input audio is no longer
         * sent to the model; sideband audio reflection continues.
         */
        fun visitSessionInputAudioMuted(sessionInputAudioMuted: InputAudioMutedEvent): T

        /**
         * Returned when a session.input_audio.unmute command is accepted. Input audio is sent to
         * the model again.
         */
        fun visitSessionInputAudioUnmuted(sessionInputAudioUnmuted: InputAudioUnmutedEvent): T

        /**
         * Returned when a session.instructions.append command is accepted into the Live session
         * timeline. Acknowledges the appended instructions without guaranteeing that the model has
         * acted on them.
         */
        fun visitSessionInstructionsAppended(
            sessionInstructionsAppended: InstructionsAppendedEvent
        ): T

        /**
         * Returned when a session.thinking.append command is accepted into the Live session
         * timeline. Acknowledges the added reasoning context without guaranteeing any spoken
         * output.
         */
        fun visitSessionThinkingAppended(sessionThinkingAppended: ThinkingAppendedEvent): T

        /**
         * Returned when a session.commentary.append command is accepted into the Live session
         * timeline. Acknowledges the added commentary without guaranteeing exact wording or
         * completed audio playback.
         */
        fun visitSessionCommentaryAppended(sessionCommentaryAppended: CommentaryAppendedEvent): T

        /**
         * Input audio received from the primary transport and reflected to a Live sideband
         * connection before model-input muting.
         */
        fun visitSessionInputAudioAppend(sessionInputAudioAppend: SessionInputAudioAppend): T

        /**
         * An audio chunk generated by the Live model. Decode and play primary WebSocket chunks in
         * delivery order using the configured session audio format. Sideband connections receive
         * reflected output audio with timestamps.
         */
        fun visitSessionOutputAudioDelta(sessionOutputAudioDelta: OutputAudioDeltaEvent): T

        /**
         * A transcript fragment for user input audio in the Live session. Accumulate fragments in
         * delivery order; these events do not define complete turns or include a transcript-done
         * event.
         */
        fun visitSessionInputTranscriptDelta(
            sessionInputTranscriptDelta: InputTranscriptDeltaEvent
        ): T

        /**
         * A transcript fragment for assistant output audio in the Live session. Accumulate
         * fragments in delivery order; these events do not define complete turns or include a
         * transcript-done event.
         */
        fun visitSessionOutputTranscriptDelta(
            sessionOutputTranscriptDelta: OutputTranscriptDeltaEvent
        ): T

        /**
         * Returned when the Live model delegates work to your application or a Responses backend.
         * Contains delegation metadata and the position on the session timeline where the work was
         * delegated.
         */
        fun visitSessionDelegationCreated(sessionDelegationCreated: DelegationCreatedEvent): T

        /**
         * A streaming Responses API event from a backend delegated to by the Live session. Use the
         * outer delegation_id to associate the nested stream with its Live delegation.
         */
        fun visitResponseEvent(responseEvent: ResponseEvent): T

        /**
         * Reports cumulative Live audio usage and, when available, the most recent context-window
         * usage. Delegated Responses token usage is reported separately in response.event events.
         */
        fun visitSessionUsageUpdated(sessionUsageUpdated: SessionUsageUpdatedEvent): T

        /**
         * Returned after the Live session finishes finalizing, with the close reason, final session
         * snapshot, and cumulative audio usage. A connection closing without this event does not
         * confirm successful finalization.
         */
        fun visitSessionClosed(sessionClosed: SessionClosedEvent): T

        /**
         * Reports an error in the Live session, such as an invalid client command. Use
         * error.client_event_id, when present, to identify the command that caused the error.
         */
        fun visitErrorEvent(errorEvent: ErrorEvent): T

        /**
         * An informational notice about the Live session, such as the event permissions applied to
         * a frontend data channel.
         */
        fun visitInfoEvent(infoEvent: InfoEvent): T

        /** A SIP DTMF keypress received from the caller. Delivered only to sideband observers. */
        fun visitTransportDtmfReceived(transportDtmfReceived: TransportDtmfReceived): T

        /**
         * A SIP DTMF keypress successfully sent by the hosted tool. Delivered only to sideband
         * observers; this is not a client command.
         */
        fun visitTransportDtmfSend(transportDtmfSend: TransportDtmfSend): T

        /**
         * The outbound SIP provider leg is ringing or providing early media. Delivered only to
         * sideband observers.
         */
        fun visitTransportRinging(transportRinging: TransportRinging): T

        /**
         * The outbound SIP provider leg answered and media is established. Delivered only to
         * sideband observers.
         */
        fun visitTransportAnswered(transportAnswered: TransportAnswered): T

        /** An asynchronous outbound SIP setup failure. Delivered only to sideband observers. */
        fun visitTransportFailed(transportFailed: TransportFailed): T

        /**
         * Maps an unknown variant of [ServerEvent] to a value of type [T].
         *
         * An instance of [ServerEvent] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ServerEvent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ServerEvent>(ServerEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ServerEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "session.started" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionStartedEvent>())?.let {
                        ServerEvent(sessionStarted = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionUpdatedEvent>())?.let {
                        ServerEvent(sessionUpdated = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.input_audio.muted" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioMutedEvent>())?.let {
                        ServerEvent(sessionInputAudioMuted = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.input_audio.unmuted" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioUnmutedEvent>())?.let {
                        ServerEvent(sessionInputAudioUnmuted = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.instructions.appended" -> {
                    return tryDeserialize(node, jacksonTypeRef<InstructionsAppendedEvent>())?.let {
                        ServerEvent(sessionInstructionsAppended = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.thinking.appended" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThinkingAppendedEvent>())?.let {
                        ServerEvent(sessionThinkingAppended = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.commentary.appended" -> {
                    return tryDeserialize(node, jacksonTypeRef<CommentaryAppendedEvent>())?.let {
                        ServerEvent(sessionCommentaryAppended = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.input_audio.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionInputAudioAppend>())?.let {
                        ServerEvent(sessionInputAudioAppend = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.output_audio.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioDeltaEvent>())?.let {
                        ServerEvent(sessionOutputAudioDelta = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.input_transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputTranscriptDeltaEvent>())?.let {
                        ServerEvent(sessionInputTranscriptDelta = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.output_transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputTranscriptDeltaEvent>())?.let {
                        ServerEvent(sessionOutputTranscriptDelta = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.delegation.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<DelegationCreatedEvent>())?.let {
                        ServerEvent(sessionDelegationCreated = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "response.event" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseEvent>())?.let {
                        ServerEvent(responseEvent = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.usage.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionUsageUpdatedEvent>())?.let {
                        ServerEvent(sessionUsageUpdated = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "session.closed" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionClosedEvent>())?.let {
                        ServerEvent(sessionClosed = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<ErrorEvent>())?.let {
                        ServerEvent(errorEvent = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "info" -> {
                    return tryDeserialize(node, jacksonTypeRef<InfoEvent>())?.let {
                        ServerEvent(infoEvent = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "transport.dtmf.received" -> {
                    return tryDeserialize(node, jacksonTypeRef<TransportDtmfReceived>())?.let {
                        ServerEvent(transportDtmfReceived = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "transport.dtmf.send" -> {
                    return tryDeserialize(node, jacksonTypeRef<TransportDtmfSend>())?.let {
                        ServerEvent(transportDtmfSend = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "transport.ringing" -> {
                    return tryDeserialize(node, jacksonTypeRef<TransportRinging>())?.let {
                        ServerEvent(transportRinging = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "transport.answered" -> {
                    return tryDeserialize(node, jacksonTypeRef<TransportAnswered>())?.let {
                        ServerEvent(transportAnswered = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
                "transport.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<TransportFailed>())?.let {
                        ServerEvent(transportFailed = it, _json = json)
                    } ?: ServerEvent(_json = json)
                }
            }

            return ServerEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ServerEvent>(ServerEvent::class) {

        override fun serialize(
            value: ServerEvent,
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
                value.sessionInstructionsAppended != null ->
                    generator.writeObject(value.sessionInstructionsAppended)
                value.sessionThinkingAppended != null ->
                    generator.writeObject(value.sessionThinkingAppended)
                value.sessionCommentaryAppended != null ->
                    generator.writeObject(value.sessionCommentaryAppended)
                value.sessionInputAudioAppend != null ->
                    generator.writeObject(value.sessionInputAudioAppend)
                value.sessionOutputAudioDelta != null ->
                    generator.writeObject(value.sessionOutputAudioDelta)
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
                value.transportDtmfReceived != null ->
                    generator.writeObject(value.transportDtmfReceived)
                value.transportDtmfSend != null -> generator.writeObject(value.transportDtmfSend)
                value.transportRinging != null -> generator.writeObject(value.transportRinging)
                value.transportAnswered != null -> generator.writeObject(value.transportAnswered)
                value.transportFailed != null -> generator.writeObject(value.transportFailed)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ServerEvent")
            }
        }
    }

    /**
     * Input audio received from the primary transport and reflected to a Live sideband connection
     * before model-input muting.
     */
    class SessionInputAudioAppend
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val audio: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("audio") @ExcludeMissing audio: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(audio, type, mutableMapOf())

        /**
         * Base64-encoded raw mono PCM16LE at 24 kHz received from the primary transport, reflected
         * to the sideband before model-input muting. This server event uses the same audio key as
         * the client command, but is not an acknowledgment of it.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun audio(): String = audio.getRequired("audio")

        /**
         * The event type, always `session.input_audio.append`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("session.input_audio.append")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [audio].
         *
         * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<String> = audio

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
             * Returns a mutable builder for constructing an instance of [SessionInputAudioAppend].
             *
             * The following fields are required:
             * ```java
             * .audio()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SessionInputAudioAppend]. */
        class Builder internal constructor() {

            private var audio: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("session.input_audio.append")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(sessionInputAudioAppend: SessionInputAudioAppend) = apply {
                audio = sessionInputAudioAppend.audio
                type = sessionInputAudioAppend.type
                additionalProperties = sessionInputAudioAppend.additionalProperties.toMutableMap()
            }

            /**
             * Base64-encoded raw mono PCM16LE at 24 kHz received from the primary transport,
             * reflected to the sideband before model-input muting. This server event uses the same
             * audio key as the client command, but is not an acknowledgment of it.
             */
            fun audio(audio: String) = audio(JsonField.of(audio))

            /**
             * Sets [Builder.audio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audio] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audio(audio: JsonField<String>) = apply { this.audio = audio }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("session.input_audio.append")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [SessionInputAudioAppend].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .audio()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): SessionInputAudioAppend =
                SessionInputAudioAppend(
                    checkRequired("audio", audio),
                    type,
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
        fun validate(): SessionInputAudioAppend = apply {
            if (validated) {
                return@apply
            }

            audio()
            _type().let {
                if (it != JsonValue.from("session.input_audio.append")) {
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
            (if (audio.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("session.input_audio.append")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SessionInputAudioAppend &&
                audio == other.audio &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(audio, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SessionInputAudioAppend{audio=$audio, type=$type, additionalProperties=$additionalProperties}"
    }

    /** A SIP DTMF keypress received from the caller. Delivered only to sideband observers. */
    class TransportDtmfReceived
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val event: JsonField<String>,
        private val eventId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event") @ExcludeMissing event: JsonField<String> = JsonMissing.of(),
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(event, eventId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun event(): String = event.getRequired("event")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("transport.dtmf.received")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [event].
         *
         * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonField<String> = event

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
             * Returns a mutable builder for constructing an instance of [TransportDtmfReceived].
             *
             * The following fields are required:
             * ```java
             * .event()
             * .eventId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TransportDtmfReceived]. */
        class Builder internal constructor() {

            private var event: JsonField<String>? = null
            private var eventId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("transport.dtmf.received")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(transportDtmfReceived: TransportDtmfReceived) = apply {
                event = transportDtmfReceived.event
                eventId = transportDtmfReceived.eventId
                type = transportDtmfReceived.type
                additionalProperties = transportDtmfReceived.additionalProperties.toMutableMap()
            }

            fun event(event: String) = event(JsonField.of(event))

            /**
             * Sets [Builder.event] to an arbitrary JSON value.
             *
             * You should usually call [Builder.event] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun event(event: JsonField<String>) = apply { this.event = event }

            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("transport.dtmf.received")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TransportDtmfReceived].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .event()
             * .eventId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TransportDtmfReceived =
                TransportDtmfReceived(
                    checkRequired("event", event),
                    checkRequired("eventId", eventId),
                    type,
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
        fun validate(): TransportDtmfReceived = apply {
            if (validated) {
                return@apply
            }

            event()
            eventId()
            _type().let {
                if (it != JsonValue.from("transport.dtmf.received")) {
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
            (if (event.asKnown().isPresent) 1 else 0) +
                (if (eventId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("transport.dtmf.received")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TransportDtmfReceived &&
                event == other.event &&
                eventId == other.eventId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(event, eventId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TransportDtmfReceived{event=$event, eventId=$eventId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * A SIP DTMF keypress successfully sent by the hosted tool. Delivered only to sideband
     * observers; this is not a client command.
     */
    class TransportDtmfSend
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val event: JsonField<String>,
        private val eventId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event") @ExcludeMissing event: JsonField<String> = JsonMissing.of(),
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(event, eventId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun event(): String = event.getRequired("event")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("transport.dtmf.send")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [event].
         *
         * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonField<String> = event

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
             * Returns a mutable builder for constructing an instance of [TransportDtmfSend].
             *
             * The following fields are required:
             * ```java
             * .event()
             * .eventId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TransportDtmfSend]. */
        class Builder internal constructor() {

            private var event: JsonField<String>? = null
            private var eventId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("transport.dtmf.send")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(transportDtmfSend: TransportDtmfSend) = apply {
                event = transportDtmfSend.event
                eventId = transportDtmfSend.eventId
                type = transportDtmfSend.type
                additionalProperties = transportDtmfSend.additionalProperties.toMutableMap()
            }

            fun event(event: String) = event(JsonField.of(event))

            /**
             * Sets [Builder.event] to an arbitrary JSON value.
             *
             * You should usually call [Builder.event] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun event(event: JsonField<String>) = apply { this.event = event }

            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("transport.dtmf.send")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TransportDtmfSend].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .event()
             * .eventId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TransportDtmfSend =
                TransportDtmfSend(
                    checkRequired("event", event),
                    checkRequired("eventId", eventId),
                    type,
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
        fun validate(): TransportDtmfSend = apply {
            if (validated) {
                return@apply
            }

            event()
            eventId()
            _type().let {
                if (it != JsonValue.from("transport.dtmf.send")) {
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
            (if (event.asKnown().isPresent) 1 else 0) +
                (if (eventId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("transport.dtmf.send")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TransportDtmfSend &&
                event == other.event &&
                eventId == other.eventId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(event, eventId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TransportDtmfSend{event=$event, eventId=$eventId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * The outbound SIP provider leg is ringing or providing early media. Delivered only to sideband
     * observers.
     */
    class TransportRinging
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val eventId: JsonField<String>,
        private val sessionId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("session_id")
            @ExcludeMissing
            sessionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(eventId, sessionId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * The canonical Live session ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sessionId(): String = sessionId.getRequired("session_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("transport.ringing")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

        /**
         * Returns the raw JSON value of [sessionId].
         *
         * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

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
             * Returns a mutable builder for constructing an instance of [TransportRinging].
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .sessionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TransportRinging]. */
        class Builder internal constructor() {

            private var eventId: JsonField<String>? = null
            private var sessionId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("transport.ringing")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(transportRinging: TransportRinging) = apply {
                eventId = transportRinging.eventId
                sessionId = transportRinging.sessionId
                type = transportRinging.type
                additionalProperties = transportRinging.additionalProperties.toMutableMap()
            }

            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /** The canonical Live session ID. */
            fun sessionId(sessionId: String) = sessionId(JsonField.of(sessionId))

            /**
             * Sets [Builder.sessionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("transport.ringing")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TransportRinging].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .sessionId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TransportRinging =
                TransportRinging(
                    checkRequired("eventId", eventId),
                    checkRequired("sessionId", sessionId),
                    type,
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
        fun validate(): TransportRinging = apply {
            if (validated) {
                return@apply
            }

            eventId()
            sessionId()
            _type().let {
                if (it != JsonValue.from("transport.ringing")) {
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
            (if (eventId.asKnown().isPresent) 1 else 0) +
                (if (sessionId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("transport.ringing")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TransportRinging &&
                eventId == other.eventId &&
                sessionId == other.sessionId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(eventId, sessionId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TransportRinging{eventId=$eventId, sessionId=$sessionId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * The outbound SIP provider leg answered and media is established. Delivered only to sideband
     * observers.
     */
    class TransportAnswered
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val eventId: JsonField<String>,
        private val sessionId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("session_id")
            @ExcludeMissing
            sessionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(eventId, sessionId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * The canonical Live session ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sessionId(): String = sessionId.getRequired("session_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("transport.answered")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

        /**
         * Returns the raw JSON value of [sessionId].
         *
         * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

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
             * Returns a mutable builder for constructing an instance of [TransportAnswered].
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .sessionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TransportAnswered]. */
        class Builder internal constructor() {

            private var eventId: JsonField<String>? = null
            private var sessionId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("transport.answered")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(transportAnswered: TransportAnswered) = apply {
                eventId = transportAnswered.eventId
                sessionId = transportAnswered.sessionId
                type = transportAnswered.type
                additionalProperties = transportAnswered.additionalProperties.toMutableMap()
            }

            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /** The canonical Live session ID. */
            fun sessionId(sessionId: String) = sessionId(JsonField.of(sessionId))

            /**
             * Sets [Builder.sessionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("transport.answered")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TransportAnswered].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .sessionId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TransportAnswered =
                TransportAnswered(
                    checkRequired("eventId", eventId),
                    checkRequired("sessionId", sessionId),
                    type,
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
        fun validate(): TransportAnswered = apply {
            if (validated) {
                return@apply
            }

            eventId()
            sessionId()
            _type().let {
                if (it != JsonValue.from("transport.answered")) {
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
            (if (eventId.asKnown().isPresent) 1 else 0) +
                (if (sessionId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("transport.answered")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TransportAnswered &&
                eventId == other.eventId &&
                sessionId == other.sessionId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(eventId, sessionId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TransportAnswered{eventId=$eventId, sessionId=$sessionId, type=$type, additionalProperties=$additionalProperties}"
    }

    /** An asynchronous outbound SIP setup failure. Delivered only to sideband observers. */
    class TransportFailed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val error: JsonField<Error>,
        private val eventId: JsonField<String>,
        private val sessionId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("session_id")
            @ExcludeMissing
            sessionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(error, eventId, sessionId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun error(): Error = error.getRequired("error")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * The canonical Live session ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sessionId(): String = sessionId.getRequired("session_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("transport.failed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

        /**
         * Returns the raw JSON value of [sessionId].
         *
         * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

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
             * Returns a mutable builder for constructing an instance of [TransportFailed].
             *
             * The following fields are required:
             * ```java
             * .error()
             * .eventId()
             * .sessionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TransportFailed]. */
        class Builder internal constructor() {

            private var error: JsonField<Error>? = null
            private var eventId: JsonField<String>? = null
            private var sessionId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("transport.failed")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(transportFailed: TransportFailed) = apply {
                error = transportFailed.error
                eventId = transportFailed.eventId
                sessionId = transportFailed.sessionId
                type = transportFailed.type
                additionalProperties = transportFailed.additionalProperties.toMutableMap()
            }

            fun error(error: Error) = error(JsonField.of(error))

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [Error] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun error(error: JsonField<Error>) = apply { this.error = error }

            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /** The canonical Live session ID. */
            fun sessionId(sessionId: String) = sessionId(JsonField.of(sessionId))

            /**
             * Sets [Builder.sessionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("transport.failed")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TransportFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .error()
             * .eventId()
             * .sessionId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TransportFailed =
                TransportFailed(
                    checkRequired("error", error),
                    checkRequired("eventId", eventId),
                    checkRequired("sessionId", sessionId),
                    type,
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
        fun validate(): TransportFailed = apply {
            if (validated) {
                return@apply
            }

            error().validate()
            eventId()
            sessionId()
            _type().let {
                if (it != JsonValue.from("transport.failed")) {
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
            (error.asKnown().getOrNull()?.validity() ?: 0) +
                (if (eventId.asKnown().isPresent) 1 else 0) +
                (if (sessionId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("transport.failed")) 1 else 0 }

        class Error
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val code: JsonField<String>,
            private val message: JsonField<String>,
            private val type: JsonValue,
            private val param: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("param") @ExcludeMissing param: JsonField<String> = JsonMissing.of(),
            ) : this(code, message, type, param, mutableMapOf())

            /**
             * The call setup failure code.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun code(): String = code.getRequired("code")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun message(): String = message.getRequired("message")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("call_error")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The parameter related to the error, if any. Empty when no parameter applies.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun param(): Optional<String> = param.getOptional("param")

            /**
             * Returns the raw JSON value of [code].
             *
             * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

            /**
             * Returns the raw JSON value of [message].
             *
             * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

            /**
             * Returns the raw JSON value of [param].
             *
             * Unlike [param], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("param") @ExcludeMissing fun _param(): JsonField<String> = param

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
                 * Returns a mutable builder for constructing an instance of [Error].
                 *
                 * The following fields are required:
                 * ```java
                 * .code()
                 * .message()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Error]. */
            class Builder internal constructor() {

                private var code: JsonField<String>? = null
                private var message: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("call_error")
                private var param: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(error: Error) = apply {
                    code = error.code
                    message = error.message
                    type = error.type
                    param = error.param
                    additionalProperties = error.additionalProperties.toMutableMap()
                }

                /** The call setup failure code. */
                fun code(code: String) = code(JsonField.of(code))

                /**
                 * Sets [Builder.code] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.code] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun code(code: JsonField<String>) = apply { this.code = code }

                fun message(message: String) = message(JsonField.of(message))

                /**
                 * Sets [Builder.message] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.message] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun message(message: JsonField<String>) = apply { this.message = message }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("call_error")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The parameter related to the error, if any. Empty when no parameter applies. */
                fun param(param: String) = param(JsonField.of(param))

                /**
                 * Sets [Builder.param] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.param] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun param(param: JsonField<String>) = apply { this.param = param }

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
                 * Returns an immutable instance of [Error].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .code()
                 * .message()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Error =
                    Error(
                        checkRequired("code", code),
                        checkRequired("message", message),
                        type,
                        param,
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
            fun validate(): Error = apply {
                if (validated) {
                    return@apply
                }

                code()
                message()
                _type().let {
                    if (it != JsonValue.from("call_error")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                param()
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
                (if (code.asKnown().isPresent) 1 else 0) +
                    (if (message.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("call_error")) 1 else 0 } +
                    (if (param.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Error &&
                    code == other.code &&
                    message == other.message &&
                    type == other.type &&
                    param == other.param &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(code, message, type, param, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Error{code=$code, message=$message, type=$type, param=$param, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TransportFailed &&
                error == other.error &&
                eventId == other.eventId &&
                sessionId == other.sessionId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(error, eventId, sessionId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TransportFailed{error=$error, eventId=$eventId, sessionId=$sessionId, type=$type, additionalProperties=$additionalProperties}"
    }
}
