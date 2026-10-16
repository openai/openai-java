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
import com.openai.models.live.CommentaryAppendEvent
import com.openai.models.live.InputAudioMuteEvent
import com.openai.models.live.InputAudioUnmuteEvent
import com.openai.models.live.InstructionsAppendEvent
import com.openai.models.live.OutputAudioFixturePlayEvent
import com.openai.models.live.ResponseCreateEvent
import com.openai.models.live.ResponseItemCreateEvent
import com.openai.models.live.SessionCloseEvent
import com.openai.models.live.SessionUpdateEvent
import com.openai.models.live.ThinkingAppendEvent
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Client events accepted by an attached Live sideband WebSocket. The session has already started.
 * Send input audio over the primary connection.
 */
@JsonDeserialize(using = SidebandClientEvent.Deserializer::class)
@JsonSerialize(using = SidebandClientEvent.Serializer::class)
class SidebandClientEvent
private constructor(
    private val sessionUpdate: SessionUpdateEvent? = null,
    private val sessionInputAudioMute: InputAudioMuteEvent? = null,
    private val sessionInputAudioUnmute: InputAudioUnmuteEvent? = null,
    private val sessionOutputAudioFixturePlay: OutputAudioFixturePlayEvent? = null,
    private val sessionInstructionsAppend: InstructionsAppendEvent? = null,
    private val sessionThinkingAppend: ThinkingAppendEvent? = null,
    private val sessionCommentaryAppend: CommentaryAppendEvent? = null,
    private val responseItemCreate: ResponseItemCreateEvent? = null,
    private val responseCreate: ResponseCreateEvent? = null,
    private val sessionClose: SessionCloseEvent? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Update the delegation settings of an active Live session. The server acknowledges accepted
     * changes with `session.updated`.
     */
    fun sessionUpdate(): Optional<SessionUpdateEvent> = Optional.ofNullable(sessionUpdate)

    /**
     * Mute audio input to the Live model without closing the session. The server acknowledges with
     * `session.input_audio.muted`.
     */
    fun sessionInputAudioMute(): Optional<InputAudioMuteEvent> =
        Optional.ofNullable(sessionInputAudioMute)

    /**
     * Resume audio input to a Live model after muting it. The server acknowledges with
     * `session.input_audio.unmuted`.
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
     * Append instructions to the Live conversation while it is running, optionally associating them
     * with an existing client delegation.
     */
    fun sessionInstructionsAppend(): Optional<InstructionsAppendEvent> =
        Optional.ofNullable(sessionInstructionsAppend)

    /**
     * Provide silent reasoning or progress context to the Live model, optionally for an existing
     * client delegation.
     */
    fun sessionThinkingAppend(): Optional<ThinkingAppendEvent> =
        Optional.ofNullable(sessionThinkingAppend)

    /**
     * Provide context the Live model can communicate to the user, optionally for an existing client
     * delegation.
     */
    fun sessionCommentaryAppend(): Optional<CommentaryAppendEvent> =
        Optional.ofNullable(sessionCommentaryAppend)

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

    fun isSessionUpdate(): Boolean = sessionUpdate != null

    fun isSessionInputAudioMute(): Boolean = sessionInputAudioMute != null

    fun isSessionInputAudioUnmute(): Boolean = sessionInputAudioUnmute != null

    fun isSessionOutputAudioFixturePlay(): Boolean = sessionOutputAudioFixturePlay != null

    fun isSessionInstructionsAppend(): Boolean = sessionInstructionsAppend != null

    fun isSessionThinkingAppend(): Boolean = sessionThinkingAppend != null

    fun isSessionCommentaryAppend(): Boolean = sessionCommentaryAppend != null

    fun isResponseItemCreate(): Boolean = responseItemCreate != null

    fun isResponseCreate(): Boolean = responseCreate != null

    fun isSessionClose(): Boolean = sessionClose != null

    /**
     * Update the delegation settings of an active Live session. The server acknowledges accepted
     * changes with `session.updated`.
     */
    fun asSessionUpdate(): SessionUpdateEvent = sessionUpdate.getOrThrow("sessionUpdate")

    /**
     * Mute audio input to the Live model without closing the session. The server acknowledges with
     * `session.input_audio.muted`.
     */
    fun asSessionInputAudioMute(): InputAudioMuteEvent =
        sessionInputAudioMute.getOrThrow("sessionInputAudioMute")

    /**
     * Resume audio input to a Live model after muting it. The server acknowledges with
     * `session.input_audio.unmuted`.
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
     * Append instructions to the Live conversation while it is running, optionally associating them
     * with an existing client delegation.
     */
    fun asSessionInstructionsAppend(): InstructionsAppendEvent =
        sessionInstructionsAppend.getOrThrow("sessionInstructionsAppend")

    /**
     * Provide silent reasoning or progress context to the Live model, optionally for an existing
     * client delegation.
     */
    fun asSessionThinkingAppend(): ThinkingAppendEvent =
        sessionThinkingAppend.getOrThrow("sessionThinkingAppend")

    /**
     * Provide context the Live model can communicate to the user, optionally for an existing client
     * delegation.
     */
    fun asSessionCommentaryAppend(): CommentaryAppendEvent =
        sessionCommentaryAppend.getOrThrow("sessionCommentaryAppend")

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
     * Optional<String> result = sidebandClientEvent.accept(new SidebandClientEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitSessionUpdate(SessionUpdateEvent sessionUpdate) {
     *         return Optional.of(sessionUpdate.toString());
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
            sessionUpdate != null -> visitor.visitSessionUpdate(sessionUpdate)
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
    fun validate(): SidebandClientEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent) {
                    sessionUpdate.validate()
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
                override fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent) =
                    sessionUpdate.validity()

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

        return other is SidebandClientEvent &&
            sessionUpdate == other.sessionUpdate &&
            sessionInputAudioMute == other.sessionInputAudioMute &&
            sessionInputAudioUnmute == other.sessionInputAudioUnmute &&
            sessionOutputAudioFixturePlay == other.sessionOutputAudioFixturePlay &&
            sessionInstructionsAppend == other.sessionInstructionsAppend &&
            sessionThinkingAppend == other.sessionThinkingAppend &&
            sessionCommentaryAppend == other.sessionCommentaryAppend &&
            responseItemCreate == other.responseItemCreate &&
            responseCreate == other.responseCreate &&
            sessionClose == other.sessionClose
    }

    override fun hashCode(): Int =
        Objects.hash(
            sessionUpdate,
            sessionInputAudioMute,
            sessionInputAudioUnmute,
            sessionOutputAudioFixturePlay,
            sessionInstructionsAppend,
            sessionThinkingAppend,
            sessionCommentaryAppend,
            responseItemCreate,
            responseCreate,
            sessionClose,
        )

    override fun toString(): String =
        when {
            sessionUpdate != null -> "SidebandClientEvent{sessionUpdate=$sessionUpdate}"
            sessionInputAudioMute != null ->
                "SidebandClientEvent{sessionInputAudioMute=$sessionInputAudioMute}"
            sessionInputAudioUnmute != null ->
                "SidebandClientEvent{sessionInputAudioUnmute=$sessionInputAudioUnmute}"
            sessionOutputAudioFixturePlay != null ->
                "SidebandClientEvent{sessionOutputAudioFixturePlay=$sessionOutputAudioFixturePlay}"
            sessionInstructionsAppend != null ->
                "SidebandClientEvent{sessionInstructionsAppend=$sessionInstructionsAppend}"
            sessionThinkingAppend != null ->
                "SidebandClientEvent{sessionThinkingAppend=$sessionThinkingAppend}"
            sessionCommentaryAppend != null ->
                "SidebandClientEvent{sessionCommentaryAppend=$sessionCommentaryAppend}"
            responseItemCreate != null ->
                "SidebandClientEvent{responseItemCreate=$responseItemCreate}"
            responseCreate != null -> "SidebandClientEvent{responseCreate=$responseCreate}"
            sessionClose != null -> "SidebandClientEvent{sessionClose=$sessionClose}"
            _json != null -> "SidebandClientEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid SidebandClientEvent")
        }

    companion object {

        /**
         * Update the delegation settings of an active Live session. The server acknowledges
         * accepted changes with `session.updated`.
         */
        @JvmStatic
        fun ofSessionUpdate(sessionUpdate: SessionUpdateEvent) =
            SidebandClientEvent(sessionUpdate = sessionUpdate)

        /**
         * Mute audio input to the Live model without closing the session. The server acknowledges
         * with `session.input_audio.muted`.
         */
        @JvmStatic
        fun ofSessionInputAudioMute(sessionInputAudioMute: InputAudioMuteEvent) =
            SidebandClientEvent(sessionInputAudioMute = sessionInputAudioMute)

        /**
         * Resume audio input to a Live model after muting it. The server acknowledges with
         * `session.input_audio.unmuted`.
         */
        @JvmStatic
        fun ofSessionInputAudioUnmute(sessionInputAudioUnmute: InputAudioUnmuteEvent) =
            SidebandClientEvent(sessionInputAudioUnmute = sessionInputAudioUnmute)

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
        ) = SidebandClientEvent(sessionOutputAudioFixturePlay = sessionOutputAudioFixturePlay)

        /**
         * Append instructions to the Live conversation while it is running, optionally associating
         * them with an existing client delegation.
         */
        @JvmStatic
        fun ofSessionInstructionsAppend(sessionInstructionsAppend: InstructionsAppendEvent) =
            SidebandClientEvent(sessionInstructionsAppend = sessionInstructionsAppend)

        /**
         * Provide silent reasoning or progress context to the Live model, optionally for an
         * existing client delegation.
         */
        @JvmStatic
        fun ofSessionThinkingAppend(sessionThinkingAppend: ThinkingAppendEvent) =
            SidebandClientEvent(sessionThinkingAppend = sessionThinkingAppend)

        /**
         * Provide context the Live model can communicate to the user, optionally for an existing
         * client delegation.
         */
        @JvmStatic
        fun ofSessionCommentaryAppend(sessionCommentaryAppend: CommentaryAppendEvent) =
            SidebandClientEvent(sessionCommentaryAppend = sessionCommentaryAppend)

        /**
         * Add an input item to the Live session’s Responses backend. Requires Responses delegation;
         * use `response.create` to request a response.
         */
        @JvmStatic
        fun ofResponseItemCreate(responseItemCreate: ResponseItemCreateEvent) =
            SidebandClientEvent(responseItemCreate = responseItemCreate)

        /**
         * Request a response from the Live session’s Responses backend, or continue a delegated
         * response waiting for tool results. Requires Responses delegation.
         */
        @JvmStatic
        fun ofResponseCreate(responseCreate: ResponseCreateEvent) =
            SidebandClientEvent(responseCreate = responseCreate)

        /**
         * Request that the Live session close. The terminal `session.closed` event contains the
         * close reason and final usage.
         */
        @JvmStatic
        fun ofSessionClose(sessionClose: SessionCloseEvent) =
            SidebandClientEvent(sessionClose = sessionClose)
    }

    /**
     * An interface that defines how to map each variant of [SidebandClientEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /**
         * Update the delegation settings of an active Live session. The server acknowledges
         * accepted changes with `session.updated`.
         */
        fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent): T

        /**
         * Mute audio input to the Live model without closing the session. The server acknowledges
         * with `session.input_audio.muted`.
         */
        fun visitSessionInputAudioMute(sessionInputAudioMute: InputAudioMuteEvent): T

        /**
         * Resume audio input to a Live model after muting it. The server acknowledges with
         * `session.input_audio.unmuted`.
         */
        fun visitSessionInputAudioUnmute(sessionInputAudioUnmute: InputAudioUnmuteEvent): T

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
        ): T

        /**
         * Append instructions to the Live conversation while it is running, optionally associating
         * them with an existing client delegation.
         */
        fun visitSessionInstructionsAppend(sessionInstructionsAppend: InstructionsAppendEvent): T

        /**
         * Provide silent reasoning or progress context to the Live model, optionally for an
         * existing client delegation.
         */
        fun visitSessionThinkingAppend(sessionThinkingAppend: ThinkingAppendEvent): T

        /**
         * Provide context the Live model can communicate to the user, optionally for an existing
         * client delegation.
         */
        fun visitSessionCommentaryAppend(sessionCommentaryAppend: CommentaryAppendEvent): T

        /**
         * Add an input item to the Live session’s Responses backend. Requires Responses delegation;
         * use `response.create` to request a response.
         */
        fun visitResponseItemCreate(responseItemCreate: ResponseItemCreateEvent): T

        /**
         * Request a response from the Live session’s Responses backend, or continue a delegated
         * response waiting for tool results. Requires Responses delegation.
         */
        fun visitResponseCreate(responseCreate: ResponseCreateEvent): T

        /**
         * Request that the Live session close. The terminal `session.closed` event contains the
         * close reason and final usage.
         */
        fun visitSessionClose(sessionClose: SessionCloseEvent): T

        /**
         * Maps an unknown variant of [SidebandClientEvent] to a value of type [T].
         *
         * An instance of [SidebandClientEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown SidebandClientEvent")
        }
    }

    internal class Deserializer :
        BaseDeserializer<SidebandClientEvent>(SidebandClientEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): SidebandClientEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "session.update" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionUpdateEvent>())?.let {
                        SidebandClientEvent(sessionUpdate = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
                "session.input_audio.mute" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioMuteEvent>())?.let {
                        SidebandClientEvent(sessionInputAudioMute = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
                "session.input_audio.unmute" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioUnmuteEvent>())?.let {
                        SidebandClientEvent(sessionInputAudioUnmute = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
                "session.output_audio.fixture.play" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioFixturePlayEvent>())
                        ?.let {
                            SidebandClientEvent(sessionOutputAudioFixturePlay = it, _json = json)
                        } ?: SidebandClientEvent(_json = json)
                }
                "session.instructions.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<InstructionsAppendEvent>())?.let {
                        SidebandClientEvent(sessionInstructionsAppend = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
                "session.thinking.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThinkingAppendEvent>())?.let {
                        SidebandClientEvent(sessionThinkingAppend = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
                "session.commentary.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<CommentaryAppendEvent>())?.let {
                        SidebandClientEvent(sessionCommentaryAppend = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
                "response.item.create" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseItemCreateEvent>())?.let {
                        SidebandClientEvent(responseItemCreate = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
                "response.create" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCreateEvent>())?.let {
                        SidebandClientEvent(responseCreate = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
                "session.close" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionCloseEvent>())?.let {
                        SidebandClientEvent(sessionClose = it, _json = json)
                    } ?: SidebandClientEvent(_json = json)
                }
            }

            return SidebandClientEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<SidebandClientEvent>(SidebandClientEvent::class) {

        override fun serialize(
            value: SidebandClientEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.sessionUpdate != null -> generator.writeObject(value.sessionUpdate)
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
                value.responseItemCreate != null -> generator.writeObject(value.responseItemCreate)
                value.responseCreate != null -> generator.writeObject(value.responseCreate)
                value.sessionClose != null -> generator.writeObject(value.sessionClose)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid SidebandClientEvent")
            }
        }
    }
}
